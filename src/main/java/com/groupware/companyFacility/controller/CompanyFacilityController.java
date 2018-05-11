/**
 * @Class Name : CompanyFacilityController.java
 * @Description : 시설예약 사용자 컨트롤러
 * @Modification Information
 * @author 김성수
 * @since  2016.08.30.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.08.30.   김성수             최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
package com.groupware.companyFacility.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.groupware.companyFacility.service.ICompanyFacilityService;
import com.groupware.dto.FacilityVO;
import com.groupware.dto.MemberVO;
import com.groupware.dto.ReservationVO;

@Controller
public class CompanyFacilityController {
	
	@Autowired
	private ICompanyFacilityService facilityService;
	
	/**
	 * 사내시설리스트
	 * @param
	 * @return : companyFacility/companyFacilityList
	 * @throws 
	 */
	@RequestMapping("/companyFacilityList")
	public String companyFacilityList(Model model, HttpSession session) {
		String url = "redirect:/login";
		
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		if(memberVO != null){
			model.addAttribute("memberVO",memberVO);
			List<FacilityVO> facilityList = facilityService.getFacilityList();
			model.addAttribute("facilityList", facilityList);
			url = "companyFacility/companyFacilityList";
		}
		return url;
	}
	
	/**
	 * 사내시설예약
	 * @param : String fac_code
	 * @return : companyFacility/companyFacilityReservaionForm
	 * @throws 
	 */
	@RequestMapping("/companyFacilityReservaionForm")
	public String companyFacilityReservaion(@RequestParam("fac_code")String fac_code
					, Model model, HttpSession session) {
		String url = "redirect:/login";
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		if(memberVO != null){
			model.addAttribute("memberVO", memberVO);
			FacilityVO facilityVO = facilityService.getFacilityInfo(fac_code);
			model.addAttribute("facilityVO",facilityVO);
			url = "companyFacility/companyFacilityReservaionForm";
		}
		return url;
	}
	
	/**
	 * 나의 사내시설 예약정보
	 * @param
	 * @return : companyFacility/myCompanyFacilityReservationInformation
	 * @throws 
	 */
	@RequestMapping("/myCompanyFacilityReservationInformation")
	public String myCompanyFacilityReservationInformation(Model model, HttpSession session) {
		
		String url = "redirect:/login";
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		
		if(memberVO!=null){
			model.addAttribute("memberVO", memberVO);
			ReservationVO reserveVO = new ReservationVO();
			reserveVO.setReserv_mem_num(memberVO.getMem_num());
			List<ReservationVO> myReserveList = facilityService.getMyReserveList(reserveVO);
			model.addAttribute("myReserveList",myReserveList);
			url = "companyFacility/myCompanyFacilityReservationInformation";
		}
		return url;
	}
	
	/**
	 * 사내시설 예약정보
	 * @param : String date
	 * @return : reserveList
	 * @throws 
	 */
	@RequestMapping(value="/getReserve", method=RequestMethod.GET)
	@ResponseBody
	public List<ReservationVO> facilityReserve(@RequestParam String date
											 , @RequestParam String code, Model model
											 , HttpSession session) {
		
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO",memberVO);
		
		List<ReservationVO> reserveList = facilityService.getReserve(date,code);
		model.addAttribute("reserveList ",reserveList );
		return reserveList;
	}

	
	/**
	 * 사내시설 예약
	 * @param : String date
	 * @return : reserveList
	 * @throws 
	 */
	@RequestMapping(value="/insertReserve", method=RequestMethod.POST)
	public String insertReserve(@RequestParam("time")String time
							  , @RequestParam("days")String days
							  , @RequestParam("code")String code
							  , HttpSession session
							  , Model model) {
		
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		String url = "redirect:/login";
		
		if(memberVO!=null){
			model.addAttribute("memberVO",memberVO);
			
			ReservationVO reserveVO = new ReservationVO();
			reserveVO.setReserv_mem_num(memberVO.getMem_num());
			reserveVO.setReserv_fac_code(code);
			reserveVO.setReserv_time(time);
			reserveVO.setReserv_day(days);
			System.out.println(reserveVO.getReserv_code()+"@@@@@@@@@@@");
			facilityService.insertReserve(reserveVO);
			//String url = "companyFacility/myCompanyFacilityReservationInformation";
			url = "redirect:/companyFacilityList";
		}
		return url;
	}
	
	
	/**
	 * 예약취소
	 * @param : String fac_code
	 * @return : redirect:/companyFacilityList
	 * @throws 
	 */
	@RequestMapping("/reserveCancel")
	public String reserveCancel(@RequestParam("reserv_code")String reserv_code
					, Model model, HttpSession session) {
		
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		String url = "redirect:/login";
		
		if(memberVO != null){
			int reserveCancel = facilityService.reserveCancel(reserv_code);
			url = "redirect:/myCompanyFacilityReservationInformation";
		}
		return url;
	}
	
	/**
	 * 나의 예약 정보 excel 출력
	 * @param : 
	 * @return : "myReservationListExcel";
	 * @throws 
	 */
	//excel 출력
		@RequestMapping(value="/myReservationListExcel")
		public String myReservationListExcel(Model model, HttpSession session){
			String url = "redirect:/login";
			MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
			
			if(memberVO != null){
				model.addAttribute("memberVO",memberVO);
				
				ReservationVO reserveVO = new ReservationVO();
				reserveVO.setReserv_mem_num(memberVO.getMem_num());
				
				List<ReservationVO> myReservation = facilityService.getMyReserveList(reserveVO);
				model.addAttribute("myReservation",myReservation);
				url = "myReservationListExcel";
			}
			return url;
		}
	
	
	
	
}

