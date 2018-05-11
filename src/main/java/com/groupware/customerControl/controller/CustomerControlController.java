/**
 * @Class Name : CustomerControlController.java
 * @Description : 거래처 관리의 수정/등록/삭제
 * @Modification CONTROLLER
 * @author 김준학
 * @since  2016.08.29.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.08.29.  김준학        최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
package com.groupware.customerControl.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.groupware.customerControl.service.ICustomerControlService;
import com.groupware.dto.AccountVO;
import com.groupware.dto.MemberVO;
import com.groupware.util.HtmlUtil;

@Controller
public class CustomerControlController {
	
	@Autowired
	private ICustomerControlService iCustomerControlService = null;
	
	/**
	 * 거래처 리스트
	 * @param : Model model
	 * @return : String
	 * @throws 
	 */
	@RequestMapping("/customerList") //리스트 불러오는거
	public String customerList(Model model,HttpSession session){
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		String url = "redirect:/login";
		if(memberVO !=null){
		List<AccountVO> accountList= iCustomerControlService.getCustomerList();
		model.addAttribute("accountList",accountList);
		model.addAttribute("memberVO",memberVO);
		url="customerControl/customerList";
		}
		return url;
	}
	@RequestMapping(value="/customerInformation", method=RequestMethod.GET) //상세보기
	public String customerInformation(Model model,HttpSession session, @RequestParam(value="ac_code",defaultValue="")String ac_code){
		MemberVO memberVO=(MemberVO) session.getAttribute("loginUser");
		String url = "redirect:/login";
		if(memberVO !=null){
			url = "customerControl/customerInformation";
			AccountVO accountInfo = iCustomerControlService.getCustomerInformation(ac_code);
			model.addAttribute("accountInfo",accountInfo);
			model.addAttribute("memberVO",memberVO);
		}
		return url;
	}
	/**
	 * 거래처 업데이트 후
	 * @param : Model,String 
	 * @return :String
	 * @throws 
	 */
	@RequestMapping(value="/customerUpdate", method=RequestMethod.GET) //업데이트
	public String customerUpdate(HttpSession session,Model model, @RequestParam(value="ac_code",defaultValue="")String ac_code){
		MemberVO memberVO=(MemberVO) session.getAttribute("loginUser");
		String url = "redirect:/login";
		if(memberVO !=null){
			url="customerControl/customerUpdate";
			AccountVO accountVO =iCustomerControlService.getCustomerInformation(ac_code);
			model.addAttribute("customerUpdate",accountVO);
		}
		return url;
	}
	/**
	 * 거래처 업데이트 수정
	 * @param :Model AccountVO
	 * @return :String
	 * @throws 
	 */
	@RequestMapping(value="/customerUpdateCom", method=RequestMethod.GET) //업데이트
	public String customerUpdateCom(Model model, AccountVO accountVO, HttpSession session){
		MemberVO memberVO=(MemberVO) session.getAttribute("loginUser");
		String url = "redirect:/login";
		if(memberVO !=null){
			accountVO.setAc_mem_num(memberVO.getMem_num());
			accountVO.setAc_nm(HtmlUtil.HtmlCleaner(accountVO.getAc_nm()));
			accountVO.setAc_reps(HtmlUtil.HtmlCleaner(accountVO.getAc_reps()));
			accountVO.setAc_tel(HtmlUtil.HtmlCleaner(accountVO.getAc_tel()));
			accountVO.setAc_em(HtmlUtil.HtmlCleaner(accountVO.getAc_em()));
			accountVO.setAc_addr(HtmlUtil.HtmlCleaner(accountVO.getAc_addr()));
			accountVO.setAc_dt_addr(HtmlUtil.HtmlCleaner(accountVO.getAc_dt_addr()));
			 url="redirect:/customerList";
			iCustomerControlService.getCustomerUpdate(accountVO);
		}
		return url;
	}
	/**
	 * 거래처 글쓰기 폼
	 * @param :
	 * @return :String
	 * @throws 
	 */
	@RequestMapping("/customerWrite") //글쓰기
	public String customerWrite(HttpSession session){

		MemberVO memberVO=(MemberVO) session.getAttribute("loginUser");
		String url = "redirect:/login";
		if(memberVO !=null){
		 url="customerControl/customerWrite";
		}
		return url;
	}
	/**
	 * 거래처 글쓰기 
	 * @param :AccountVO, String, String, String, String 
	 * @return : String
	 * @throws 
	 */
	@RequestMapping(value="/customerWrite", method=RequestMethod.POST) //글쓰기
	public String customerWrite(AccountVO accountVO, @RequestParam(value="ac_em")String ac_em,
													 @RequestParam(value="ac_em2")String ac_em2,
													 @RequestParam(value="ac_addr")String ac_addr,
													 @RequestParam(value="ac_dt_addr")String ac_dt_addr,
													 HttpSession session){
		MemberVO memberVO=(MemberVO) session.getAttribute("loginUser");
		String url = "redirect:/login";
		if(memberVO !=null){
			accountVO.setAc_mem_num(memberVO.getMem_num());
			accountVO.setAc_nm(HtmlUtil.HtmlCleaner(accountVO.getAc_nm()));
			accountVO.setAc_reps(HtmlUtil.HtmlCleaner(accountVO.getAc_reps()));
			accountVO.setAc_tel(HtmlUtil.HtmlCleaner(accountVO.getAc_tel()));
			accountVO.setAc_em(HtmlUtil.HtmlCleaner(ac_em+"@"+ac_em2));
			accountVO.setAc_addr(HtmlUtil.HtmlCleaner(ac_addr+","+ac_dt_addr));
			accountVO.setAc_dt_addr(HtmlUtil.HtmlCleaner(accountVO.getAc_dt_addr()));
			iCustomerControlService.getCustomerWrite(accountVO);
			url="redirect:/customerList";
		}
		return url;
	}
	/**
	 * 거래처 삭제
	 * @param :AccountVO, 
	 * @return : String
	 * @throws 
	 */
	@RequestMapping("/customerDelete") //삭제
	public String customerDelete(AccountVO accountVO,HttpSession session,Model model){
		String url = "redirect:/login";
		MemberVO memberVO=(MemberVO) session.getAttribute("loginUser");
		if(memberVO !=null){
		iCustomerControlService.getCustomerDelete(accountVO);
		model.addAttribute("memberVO",memberVO);
		url="redirect:/customerList";
		}
		return url;
	}
	
	@RequestMapping("/customerListExcel")
	public String customerListExcel(Model model,HttpSession session){
		String url = "redirect:/login";
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		if(memberVO !=null){
			List<AccountVO> customerList = iCustomerControlService.getCustomerList();
			model.addAttribute("customerList",customerList);
			url = "custromerListExcel"; 
		}
		return url;
	}
	
	//검색
	@RequestMapping(value="/customerSearch",method=RequestMethod.GET)
	public String customerSearch(@RequestParam(value="searchKeyword")String searchKeyword, 
							   @RequestParam(value="searchKey2")String searchKey2, Model model,HttpSession session){

		String url = "redirect:/login";
		MemberVO memberVO=(MemberVO) session.getAttribute("loginUser");
		if(memberVO !=null){
			if(searchKey2.equals("담당사원")){
				List<AccountVO> searchList = iCustomerControlService.getSearchList(searchKeyword);
				model.addAttribute("accountList",searchList);
				url="customerControl/customerList";
			}else if(searchKey2.equals("업체명")){
				List<AccountVO> searchList = iCustomerControlService.getSearchList1(searchKeyword);
				model.addAttribute("accountList",searchList);
				url="customerControl/customerList";
			}
		}
		return url;
	}

}
