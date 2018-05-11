package com.groupware.companyProposal.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupware.companyProposal.service.ICompanyProposalService;
import com.groupware.dto.CompanyProposalVO;
import com.groupware.dto.MemberVO;

/**
 * @Class Name : CompanyProposalController.java
 * @Description : 제안 사용자/관리자 화면 리스트 조회 및 검색
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
public class CompanyProposalController {
	
	@Autowired
	private ICompanyProposalService service;
	
	/**
	 * 제안 검색
	 * @param String
	 * @return String
	 * @throws 
	 */
	@RequestMapping("/companyProposalSearch")
	public String companyProposalSearch(@RequestParam(value="key", defaultValue="")String key
				, HttpSession session, Model model) {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO",memberVO);
		
		List<CompanyProposalVO>companyProposalSearch= service.companyProposalSearch(key);
		model.addAttribute("companyProposalList", companyProposalSearch);
		url = "companyProposal/companyProposalList";
		  }
		return url;
	}
	/**
	 * 제안 조회
	 * @param 
	 * @return String
	 * @throws 
	 */
	@RequestMapping("/companyProposalList")
	public String companyProposalList(Model model, HttpSession session) {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		
		
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO",memberVO);
		
		List<CompanyProposalVO>companyProposalList= service.companyProposalList();
		model.addAttribute("companyProposalList",companyProposalList);
		url = "/companyProposal/companyProposalList";
		  }
		return url;
	}
	/**
	 * 제안 정보 조회
	 * @param String
	 * @return String
	 * @throws 
	 */
	@RequestMapping("/companyProposalInformation")
	public String companyProposalInformation(Model model, @RequestParam(value="prop_code", defaultValue="")String prop_code
			, HttpSession session) {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO",memberVO);
		
		CompanyProposalVO companyProposalInformation =  service.companyProposalInformation(prop_code);
		model.addAttribute("companyProposalInformation", companyProposalInformation);
		url = "/companyProposal/companyProposalInformation";
		  }
		return url;
	}


}
