package com.groupware.companySurvey.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupware.companySurvey.service.ICompanySurveyService;
import com.groupware.dto.CompanySurveyVO;
import com.groupware.dto.MemberVO;
/**
 * @Class Name : AdminCompanySurveyController.java
 * @Description : 설문 관리자 화면 등록/수정/삭제/설문마감
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
public class AdminCompanySurveyController {
	
	@Autowired
	private ICompanySurveyService service;

	/**
	 * 설문 등록 폼 호출
	 * @param  
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value="/companySurveyWrite",method=RequestMethod.GET)
	public String companySurveywrite(HttpSession session, Model model) {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO",memberVO);
		url = "companySurvey/companySurveyWrite";
		  }
		return url;
	}
	/**
	 * 설문 등록
	 * @param  CompanySurveyVO
	 * @return String
	 * @throws 
	 */
	
	@RequestMapping(value="/companySurveyWrite",method=RequestMethod.POST)
	public String companySurveywrite(CompanySurveyVO companySurveyVO, HttpSession session, Model model) {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO",memberVO);
		
		companySurveyVO.setRes_mem_num(memberVO.getMem_num());
		String tt = companySurveyVO.getRes_tt();
		tt = tt.replace("<", "＜");
		tt = tt.replace(">", "＞");
		companySurveyVO.setRes_tt(tt);
		
		String res_cont1 = companySurveyVO.getRes_ex_tt();
		String res_cont2 = companySurveyVO.getRes_it1();
		String res_cont3 = companySurveyVO.getRes_it2();
		String res_cont4 = companySurveyVO.getRes_it3();
		String res_cont5 = companySurveyVO.getRes_it4();
		
		res_cont1 = res_cont1.replace("<", "＜");
		res_cont1 = res_cont1.replace(">", "＞");
		res_cont2 = res_cont2.replace("<", "＜");
		res_cont2 = res_cont2.replace(">", "＞");
		res_cont3 = res_cont3.replace("<", "＜");
		res_cont3 = res_cont3.replace(">", "＞");
		res_cont4 = res_cont4.replace("<", "＜");
		res_cont4 = res_cont4.replace(">", "＞");
		res_cont5 = res_cont5.replace("<", "＜");
		res_cont5 = res_cont5.replace(">", "＞");
		companySurveyVO.setRes_ex_tt(res_cont1);
		companySurveyVO.setRes_it1(res_cont2);
		companySurveyVO.setRes_it2(res_cont3);
		companySurveyVO.setRes_it3(res_cont4);
		companySurveyVO.setRes_it4(res_cont5);
		service.companySurveyWrite(companySurveyVO);
		url = "redirect:/companySurveyList";
		  }
		return url;
	}

	/**
	 * 설문 수정 폼으로 이동
	 * @param String
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value="/companySurveyUpdate", method=RequestMethod.GET)
	public String companySurveyUpdate(Model model, @RequestParam(value="res_code", defaultValue="")String res_code
				, HttpSession session) {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO",memberVO);
		
		CompanySurveyVO companySurveyInformation =  service.companySurveyInformation(res_code);
		model.addAttribute("companySurveyInformation",companySurveyInformation);
		url = "companySurvey/companySurveyUpdate";}
		return url;
	}
	/**
	 * 설문 수정
	 * @param CompanySurveyVO
	 * @return String
	 * @throws 
	 */
	
	@RequestMapping(value="/companySurveyUpdateCom", method=RequestMethod.POST)
	public String companySurveyUpdate(Model model, CompanySurveyVO companySurveyVO, HttpSession session) {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO",memberVO);
		
		String tt = companySurveyVO.getRes_tt();
		tt = tt.replace("<", "＜");
		tt = tt.replace(">", "＞");
		companySurveyVO.setRes_tt(tt);
		
		String res_cont1 = companySurveyVO.getRes_ex_tt();
		String res_cont2 = companySurveyVO.getRes_it1();
		String res_cont3 = companySurveyVO.getRes_it2();
		String res_cont4 = companySurveyVO.getRes_it3();
		String res_cont5 = companySurveyVO.getRes_it4();
		
		res_cont1 = res_cont1.replace("<", "＜");
		res_cont1 = res_cont1.replace(">", "＞");
		res_cont2 = res_cont2.replace("<", "＜");
		res_cont2 = res_cont2.replace(">", "＞");
		res_cont3 = res_cont3.replace("<", "＜");
		res_cont3 = res_cont3.replace(">", "＞");
		res_cont4 = res_cont4.replace("<", "＜");
		res_cont4 = res_cont4.replace(">", "＞");
		res_cont5 = res_cont5.replace("<", "＜");
		res_cont5 = res_cont5.replace(">", "＞");
		companySurveyVO.setRes_ex_tt(res_cont1);
		companySurveyVO.setRes_it1(res_cont2);
		companySurveyVO.setRes_it2(res_cont3);
		companySurveyVO.setRes_it3(res_cont4);
		companySurveyVO.setRes_it4(res_cont5);
		
		
		int companySurveyUpdate =service.companySurveyUpdate(companySurveyVO);
		
		url = "redirect:/companySurveyList";}
		return url;
	}
	/**
	 * 설문 삭제
	 * @param CompanySurveyVO
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value="/companySurveyDelete", method=RequestMethod.GET)
	public String companySurveyDelete(CompanySurveyVO companySurveyVO, Model model
					, HttpSession session) {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO",memberVO);
		
		int companySurveyDelete = service.companySurveyDelete(companySurveyVO);
		url = "redirect:/companySurveyList";}
		
		return url;
	}
	/**
	 * 설문 마감
	 * @Param String
	 * @return String
	 * @throws 
	 */
	
	@RequestMapping(value="/companySurveyDeadline", method=RequestMethod.GET)
	public String companySurveyDeadline(Model model, @RequestParam(value="res_prog_st")String res_prog_st, @RequestParam(value="res_code")String res_code, @RequestParam(value="res_count1")String res_count1, @RequestParam(value="res_count2")String res_count2, @RequestParam(value="res_count3")String res_count3, @RequestParam(value="res_count4")String res_count4
				, HttpSession session) {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO",memberVO);
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("res_prog_st", res_prog_st);
		param.put("res_code", res_code);
		service.companySurveyDeadline(param);
		
		Map<String, String> param2 = new HashMap<String, String>();
		param2.put("res_count1", res_count1);
		param2.put("res_count2", res_count2);
		param2.put("res_count3", res_count3);
		param2.put("res_count4", res_count4);
		CompanySurveyVO companySurveyCount = service.getcountTotal(param2);
		model.addAttribute("companySurveyCount", companySurveyCount);
		url = "redirect:/companySurveyList";
		  }		
		return url;
	}

}
