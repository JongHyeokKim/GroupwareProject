package com.groupware.login.common;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.mail.javamail.JavaMailSender;

import com.groupware.dto.MemberVO;

public class MimeRegistrationNotifier  implements RegistrationNotifier{
	private JavaMailSender mailSender;
	
	
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}


	@Override
	public void sendMail(Receiver receiver, String tempPwd) {
		MimeMessage message = mailSender.createMimeMessage();
		try{
			message.setSubject("비밀번호 변경 안내","utf-8");
			String htmlContent = "<strong>안녕하세요</strong>, 반갑습니다.<br>"
					           + "회원님의 비밀번호는  <strong>"+tempPwd+"</strong> 입니다.<br>"
					           + "로그인 후 비밀번호 변경을 꼭 해주세요.";
			message.setText(htmlContent, "utf-8", "html");
			message.setFrom(new InternetAddress("tmxhfl92@hanmail.net"));
			message.addRecipient(RecipientType.TO, new InternetAddress(receiver.getEmail()));
			mailSender.send(message);
		}catch(Exception e){
			// 실제로 익셉션 발생 내지 로그 남김
		}
	}

}
