package com.groupware.companyProposal.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupware.companyProposal.service.ICompanyProposalService;
import com.groupware.dto.CompanyProposalVO;
import com.groupware.dto.MemberVO;
/**
 * @Class Name : AdminCompanyCProposalController.java
 * @Description : 제안 관리자 화면 등록/삭제/수정
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
public class AdminCompanyCProposalController {
	
	@Autowired
	private ICompanyProposalService service;
	/**
	 * 제안 폼 호출
	 * @param 
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value="/companyProposalWrite", method=RequestMethod.GET)
	public String companyProposalWrite(Model model, HttpSession session) {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		url = "/companyProposal/companyProposalWrite";
		  }
		return url;
	}
	/**
	 * 제안 등록
	 * @param CompanyProposalVO
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value="/companyProposalWrite", method=RequestMethod.POST)
	public String companyProposalWrite(CompanyProposalVO companyProposalVO, HttpSession session, Model model) {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO",memberVO);	
		
		companyProposalVO.setProp_mem_num(memberVO.getMem_num());
		String tt = companyProposalVO.getProp_tt();
		tt = tt.replace("<", "＜");
		tt = tt.replace(">", "＞");
		companyProposalVO.setProp_tt(tt);
		
		String prop_cont = companyProposalVO.getProp_cont();
		prop_cont = prop_cont.replace("<p>", "");
		prop_cont = prop_cont.replace("</p>", "");
		prop_cont = prop_cont.replace("<", "＜");
		prop_cont = prop_cont.replace(">", "＞");
		companyProposalVO.setProp_cont(prop_cont);
		service.companyProposalWriteCom(companyProposalVO);
		url = "redirect:/companyProposalList";
		  }		return url;
	}
	/**
	 * 제안 수정 폼 호출
	 * @param String
	 * @return String
	 * @throws 
	 */
	
	@RequestMapping(value="/companyProposalUpdate", method=RequestMethod.GET)
	public String companyProposalUpdate(Model model, HttpSession session, @RequestParam(value="prop_code", defaultValue="")String prop_code) {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		CompanyProposalVO companyProposalInformation =  service.companyProposalInformation(prop_code);
		model.addAttribute("companyProposalInformation", companyProposalInformation);
		  
		url = "companyProposal/companyProposalUpdate";
		  }
		return url;
	}
	/**
	 * 제안 수정
	 * @param CompanyProposalVO
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value="/companyProposalUpdateCom", method=RequestMethod.POST)
	public String companyProposalUpdate(Model model, HttpSession session, CompanyProposalVO companyProposalVO) {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		int companyProposalUpdate =service.companyProposalUpdate(companyProposalVO);
		String tt = companyProposalVO.getProp_tt();
		tt = tt.replace("<", "＜");
		tt = tt.replace(">", "＞");
		companyProposalVO.setProp_tt(tt);
		
		String prop_cont = companyProposalVO.getProp_cont();
		prop_cont = prop_cont.replace("<p>", "");
		prop_cont = prop_cont.replace("</p>", "");
		prop_cont = prop_cont.replace("<", "＜");
		prop_cont = prop_cont.replace(">", "＞");
		companyProposalVO.setProp_cont(prop_cont);
		
		url = "redirect:/companyProposalList";
		}
		return url;
	}
	/**
	 * 제안 삭제
	 * @param CompanyProposalVO
	 * @return String
	 * @throws 
	 */
	@RequestMapping("/companyProposalDelete")
	public String companyProposalDelete(Model model, HttpSession session, CompanyProposalVO companyProposalVO) {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		int companyProposalDelete = service.companyProposalDelete(companyProposalVO);
		url = "redirect:/companyProposalList";
		  
		  }
		return url;
	}
	/**
	 * 제안 수정
	 * @param String
	 * @return String
	 * @throws 
	 */

	@RequestMapping(value="/companyProposalCheck", method=RequestMethod.GET)
	public String companyProposalCheck(Model model, @RequestParam(value="prop_st")String prop_st
			, @RequestParam(value="prop_code")String prop_code
			, HttpSession session) {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO",memberVO);
		
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("prop_code", prop_code);
		param.put("prop_st", prop_st);
		service.companyProposalCheck(param);
		url = "redirect:/companyProposalList";
		  }
		return url;
	}
	


}
