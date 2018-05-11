package com.groupware.email.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.groupware.dto.EmailVO;
import com.groupware.dto.MemberVO;
import com.groupware.email.common.SendMail;
/**
 * @Class Name : EmailController.java
 * @Description : 이메일 발송 (주소록 연동)
 * @Modification Information
 * @author 김태균
 * @since  2016.08.30.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일      		 수정자          		수정내용
 *    -------      -------     -------------------
 *    2016.08.30.  	김태균        			최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
@Controller
public class EmailController {
	/**
	 * 이메일 쓰기 화면 이동
	 * @param session, model
	 * @return url / model+(sessionVO)
	 * @throws none
	 */
	@RequestMapping("/emailWrite")
	public String emailWrite(Model model, HttpSession session) {
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		String url="redirect:/login";
		if(loginUser!=null){
			url = "email/emailWrite";
			model.addAttribute("loginUser", loginUser);
		}
		return url;
	}
	
	/**
	 * 이메일 화면 주소록창 새창
	 * @param none
	 * @return url
	 * @throws none
	 */
	@RequestMapping(value="/emailAddressBook")
	public String emailAddressBook() {
		String url = "email/emailAddressBook";
		return url;
	}
	
	/**
	 * 이메일 전송
	 * @param session, EmailVO
	 * @return String (이메일 전송 관련 결과 메세지)
	 * @throws none
	 */
	@RequestMapping(value="/emailSend" ,method=RequestMethod.POST)
	@ResponseBody
	public String emailSend(HttpSession session, EmailVO emailVO) {
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		String imagePath = session.getServletContext().getRealPath("resources/treeview/images");
		String result = "";
		if(loginUser!=null){
			result = SendMail.sendGmail(emailVO, loginUser, imagePath);
		}
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("resMsg", result);
		return result;
	}
}
