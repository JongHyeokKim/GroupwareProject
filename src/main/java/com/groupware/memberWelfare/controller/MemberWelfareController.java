package com.groupware.memberWelfare.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupware.dto.MemberVO;
/**
 * @Class Name : MemberWelfareController.java
 * @Description : 사내복지
 * @Modification Controller
 * @author 함박눈
 * @since  2016.08.29.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *   2016.08.29.  함박눈        최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
@Controller
public class MemberWelfareController {
	/**
	 * 사내복지 조회
	 * @param 
	 * @return String
	 * @throws 
	 */
	@RequestMapping("/welfareInformation")
	public String login(Model model,HttpSession session) {
		 String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
	
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO",memberVO);
		url = "/memberWelfare/welfareInformation";
		  }
		return url;
	}

}
