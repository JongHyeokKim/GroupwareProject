package com.groupware.email.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.web.multipart.MultipartFile;

import com.groupware.dto.EmailVO;
import com.groupware.dto.MemberVO;

/**
 * @Class Name : sendGmail.java
 * @Description : 이메일 발송 (주소록 연동)
 * @Modification Information
 * @author 김태균
 * @since  2016.09.01.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       		수정자         			 수정내용
 *    -------      -------     -------------------
 *    2016.09.01. 	 김태균        			최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
public class SendMail {
	/**
	 * SMTP 서버 활용 메일(Naver / Gmail)
	 * @param emailVO, SessionVO(MemberVO), imageSavePath
	 * @return 전송 관련 결과 메세지
	 * @throws none
	 */
	public static String sendGmail(EmailVO emailVO, MemberVO loginUser, String imagePath) {
		String SMTP_PORT = "465";
		String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		Session session = null;
		StringTokenizer idToken = new StringTokenizer(loginUser.getMem_em(), "@");
		String id = idToken.nextToken();
		boolean checkGmail = emailVO.getEmailAddress().contains("gmail");
		try {
			Properties props = new Properties();
			props.put("mail.smtp.user", emailVO.getEmailAddress());
			String SMTP_HOST_NAME = "";
			if (checkGmail) {
				SMTP_HOST_NAME = "smtp.gmail.com";
			} else {
				SMTP_HOST_NAME = "smtp.naver.com";
			}
			props.put("mail.smtp.host", SMTP_HOST_NAME);
			props.put("mail.smtp.port", SMTP_PORT);
			props.put("mail.smtp.socketFactory.port", SMTP_PORT);
			props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
			props.put("mail.smtp.socketFactory.fallback", "false");
			session = Session.getInstance(props, null);
			Transport transport = session.getTransport();
			Message msg = new MimeMessage(session);
			InternetAddress addressFrom;

			addressFrom = new InternetAddress(emailVO.getEmailAddress());
			msg.setFrom(addressFrom);
			List<String> recievers = emailVO.getEmailRecievers();
			InternetAddress[] addressTo = new InternetAddress[emailVO.getEmailRecievers().size()];
			for (int i = 0; i < recievers.size(); i++) {
				addressTo[i] = new InternetAddress(recievers.get(i));
			}
			msg.setRecipients(Message.RecipientType.TO, addressTo);

			// Setting the Subject and Content Type
			msg.setSubject(emailVO.getEmailTitle());
			/*
			 * 텍스트만 전송하는 경우 아래의 2라인만 추가하면 된다. 그러나 텍스트와 첨부파일을 함께 전송하는 경우에는 아래의
			 * 2라인을 제거하고 대신에 그 아래의 모든 문장을 추가해야 한다.
			 */
			transport.connect(id, emailVO.getEmailPassword());
			if (emailVO.getEmailFile()==null) {
				msg.setContent(emailVO.getEmailContent(), "text/plain; charset=UTF-8");
				transport.sendMessage(msg, addressTo);
				transport.close();
			} else {
				/* 텍스트와 첨부파일을 함께 전송하는 경우에는 위의 2라인을 제거하고 아래의 모든 라인을 추가한다. */
				// Create the message part
				BodyPart messageBodyPart = new MimeBodyPart();

				// Fill the message
				messageBodyPart.setText(emailVO.getEmailContent());
				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(messageBodyPart);

				// Part two is attachment
				messageBodyPart = new MimeBodyPart();
				MultipartFile attachFile = emailVO.getEmailFile();
				String fileName = attachFile.getOriginalFilename();
				// 1. FileOutputStream 사용
				byte[] fileData = attachFile.getBytes();
				FileOutputStream output = new FileOutputStream(imagePath+"/"+ fileName);
				output.write(fileData);
				output.close();

				// 2. File 사용
				File file = new File(imagePath , fileName);

				FileDataSource fds = new FileDataSource(file);
				messageBodyPart.setDataHandler(new DataHandler(fds));

				messageBodyPart.setFileName(fileName);

				multipart.addBodyPart(messageBodyPart);

				// Put parts in message
				msg.setContent(multipart);

				// Send the message
				transport.sendMessage(msg, addressTo);
				transport.close();
				file.delete();
			}
		} catch (AddressException e1) {
			return "Address Error";
		} catch (MessagingException e1) {
			return "Authentication Error";
		} catch (IOException e1) {
			return "IO Error";
		}
		return "Mail Successfully Send";
	}
}
