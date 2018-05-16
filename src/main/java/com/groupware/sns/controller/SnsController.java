package com.groupware.sns.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupware.dto.MemberVO;
import com.groupware.sns.service.SnsService;

@Controller
public class SnsController {

	@Autowired
	private SnsService snsService;
	
	@RequestMapping(value = "/snsForm")
	public String snsForm(Model model, HttpSession session) {
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		String url = "redirect:/login";
		if (memberVO != null) {
			url = "sns/sns";
			model.addAttribute("memberVO", memberVO);
		}
		
		return url;
	}
}
