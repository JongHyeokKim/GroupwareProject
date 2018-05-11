package com.groupware.companySurvey.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupware.companySurvey.service.ICompanySurveyService;
import com.groupware.dto.CompanySurveyCheckVO;
import com.groupware.dto.CompanySurveyVO;
import com.groupware.dto.MemberVO;
/**
 * @Class Name : CompanySurveyController.java
 * @Description : 설문 사용자 리스트 조회 및 검색
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
public class CompanySurveyController {
	
	@Autowired
	private ICompanySurveyService service;
	/**
	 * 설문 리스트조회
	 * 
	 * @param 
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value="/companySurveyList", method=RequestMethod.GET)
	public String companySurveyList(Model model, HttpSession session) {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO",memberVO);
		
		List<CompanySurveyVO>companySurveyList= service.companySurveyList();
		model.addAttribute("companySurveyList",companySurveyList);
		url = "companySurvey/companySurveyList";}
		return url;
	}
	/**
	 * 설문 상세조회
	 * 
	 * @param String
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value="/companySurveyInformation", method=RequestMethod.GET)
	public String companySurveyInformation(HttpServletRequest request, Model model
				, @RequestParam(value="res_code", defaultValue="")String res_code
				, HttpSession session) {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		CompanySurveyVO companySurveyInformation =  service.companySurveyInformation(res_code);
		model.addAttribute("companySurveyInformation",companySurveyInformation);

		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO",memberVO);
		
		Map<String, String> param2 = new HashMap<String, String>();
		param2.put("res_dup_res_code", res_code);
		param2.put("res_dup_mem_num", memberVO.getMem_num());
		
		
		 CompanySurveyCheckVO checkVO = service.checkSearch(param2);
		 model.addAttribute("checkVO",checkVO);
		 url = "companySurvey/companySurveyInformation";
		  }
		return url;
	}
	/**
	 * 설문 검색
	 * @param String
	 * @return String
	 * @throws 
	 */
	

	@RequestMapping(value="/companySurveySearch", method=RequestMethod.GET)
	public String companySurveySearch(Model model, @RequestParam(value="key")String key
				, HttpSession session) {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO",memberVO);
		
		List<CompanySurveyVO>companySurveySearch= service.companySurveySearch(key);
		model.addAttribute("companySurveyList", companySurveySearch);
		url = "companySurvey/companySurveyList";}
		return url;
	}
	/**
	 * 설문 제출
	 * @param  String
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value="/companySurveyAdd", method=RequestMethod.GET)
	public String companySurveyAdd(HttpServletRequest request, Model model
					, @RequestParam(value="res_code")String res_code, @RequestParam(value="res_count1")String count1,  @RequestParam(value="res_count2")String count2, @RequestParam(value="res_count3")String count3
					, @RequestParam(value="res_count4")String count4
					, HttpSession session) {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO",memberVO);
		
		CompanySurveyVO count=service.checkCount(res_code);
		
		Map<String, String> param= new HashMap<String, String>();
		Map<String, Object> countGroup = new HashMap<String, Object>(); 
		countGroup.put("res_code1", Integer.parseInt(count.getRes_count1()));
		countGroup.put("res_code2", Integer.parseInt(count.getRes_count2()));
		countGroup.put("res_code3", Integer.parseInt(count.getRes_count3()));
		countGroup.put("res_code4", Integer.parseInt(count.getRes_count4()));
		
		
		if (Integer.parseInt(count1) != 0) {
			int countNums = Integer.parseInt(count.getRes_count1());
			countNums++;
			countGroup.put("res_code1", countNums);
		}
		if (Integer.parseInt(count2) != 0) {
			int countNums = Integer.parseInt(count.getRes_count2());
			countNums++;
			countGroup.put("res_code2", countNums);
		}
		if (Integer.parseInt(count3) != 0) {
			int countNums = Integer.parseInt(count.getRes_count3());
			countNums++;
			countGroup.put("res_code3", countNums);
		}
		if (Integer.parseInt(count4) != 0) {
			int countNums = Integer.parseInt(count.getRes_count4());
			countNums++;
			countGroup.put("res_code4", countNums);
		}
		
		int error = service.countNumCheck(countGroup);
		Map<String, String> param2 = new HashMap<String, String>();
		param2.put("res_dup_res_code", res_code);
		param2.put("res_dup_mem_num", memberVO.getMem_num());
		service.addcheckSearch(param2);
		url = "redirect:/companySurveyList";
		  }	
		return url;
		
		
	}
	
	
	
	
}
