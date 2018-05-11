/**
 * @Class Name : AdminCompanyFacilityController.java
 * @Description : 시설예약 관리자 컨드롤러
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
package com.groupware.companyFacility.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.groupware.companyFacility.service.ICompanyFacilityService;
import com.groupware.dto.FacilityVO;
import com.groupware.dto.MemberVO;
import com.groupware.dto.ReservationVO;

@Controller
public class AdminCompanyFacilityController {

	@Autowired
	private ICompanyFacilityService facilityService;
	
	/**
	 * 사내시설 등록폼
	 * @param
	 * @return : companyFacility/adminFacilityWriter
	 * @throws 
	 */
	@RequestMapping(value="/facilityWriterForm")
	public String adminFacilityWriterForm(Model model, HttpSession session) {
		String url = "redirect:/login";
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		
		if(memberVO != null){
			model.addAttribute("memberVO",memberVO);
			url = "companyFacility/adminFacilityWriter";
		}
		return url;
	}
	
	/**
	 * 사내시설 등록
	 * @param : FacilityVO facilityVO
	 * @return : redirect:/companyFacilityList
	 * @throws : IOException
	 */
	@RequestMapping(value="/adminFacilityWriter",method=RequestMethod.POST)
	public String adminFacilityWriter(@ModelAttribute("facility")FacilityVO facilityVO
				, Model model, HttpSession session
				, HttpServletRequest request, HttpServletResponse response
				, @RequestParam("file")MultipartFile multipartFile
				, @RequestParam("file1")MultipartFile multipartFile1
				, @RequestParam("file2")MultipartFile multipartFile2
				) throws IOException{
		
		//final String uploadPath = new File(session.getServletContext().getRealPath("/../../../../../../GD/src/main/webapp/resources/facilityImage")).getCanonicalPath();
		//final String uploadPath1 = new File(session.getServletContext().getRealPath("/../../../../../../GD/src/main/webapp/resources/facilityImage")).getCanonicalPath();
		//final String uploadPath2 = new File(session.getServletContext().getRealPath("/../../../../../../GD/src/main/webapp/resources/facilityImage")).getCanonicalPath();
		String uploadPath = request.getSession().getServletContext().getRealPath("resources/facilityImage");
		String uploadPath1 = request.getSession().getServletContext().getRealPath("resources/facilityImage");
		String uploadPath2 = request.getSession().getServletContext().getRealPath("resources/facilityImage");
		String url = "redirect:/login";
		
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");

		if(memberVO != null){
			model.addAttribute("memberVO",memberVO);
			url = "redirect:/companyFacilityList";
			
			if(!multipartFile.isEmpty()&&!multipartFile1.isEmpty()){
				File file = new File(uploadPath, "$$"+System.currentTimeMillis() + multipartFile.getOriginalFilename());
				File file1 = new File(uploadPath1, "$$"+System.currentTimeMillis() + multipartFile1.getOriginalFilename());
				File file2 = new File(uploadPath2, "$$"+System.currentTimeMillis() + multipartFile2.getOriginalFilename());
				multipartFile.transferTo(file);
				multipartFile1.transferTo(file1);
				multipartFile2.transferTo(file2);
				
				String fac_name = facilityVO.getFac_name();
				String fac_desc = facilityVO.getFac_desc();
				fac_name = fac_name.replace("<", "＜");
				fac_name = fac_name.replace(">", "＞");
				fac_desc = fac_desc.replace("<", "＜");
				fac_desc = fac_desc.replace(">", "＞");
				
				facilityVO.setFac_name(fac_name);
				facilityVO.setFac_desc(fac_desc);
				facilityVO.setFac_img(file.getName());
				facilityVO.setFac_img1(file1.getName());
				facilityVO.setFac_img2(file2.getName());
			}else{
				facilityVO.setFac_img("");
			}
			facilityService.facilityInsert(facilityVO);
		}
		return url;
	}
	
	/**
	 * 사내시설 정보 수정폼
	 * @param :String fac_code
	 * @return : companyFacility/companyFacilityUpdateForm
	 * @throws 
	 */
	@RequestMapping("/adminFacilityUpdateForm")
	public String adminFacilityUpdateForm(@RequestParam String fac_code
			, Model model, HttpSession session) {
		String url = "redirect:/login";
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		
		if(memberVO != null){
			model.addAttribute("memberVO",memberVO);
			
			FacilityVO facilityVO = facilityService.getFacilityInfo(fac_code);
			model.addAttribute("facilityVO",facilityVO);
			url = "companyFacility/companyFacilityUpdateForm";
		}
		return url;
	}
	
	/**
	 * 사내시설 정보 수정
	 * @param : FacilityVO facilityVO, MultipartFile multipartFil
	 * @return : redirect:/companyFacilityLis
	 * @throws 
	 */
	@RequestMapping("/adminFacilityUpdate")
	public String adminFacilityUpdate(FacilityVO facilityVO, Model model
			, HttpServletRequest request, HttpServletResponse response
			, @RequestParam("file")MultipartFile multipartFile
			, @RequestParam("file1")MultipartFile multipartFile1
			, @RequestParam("file2")MultipartFile multipartFile2
			, HttpSession session) throws IOException {
		
		//final String uploadPath = new File(session.getServletContext().getRealPath("/../../../../../../GD/src/main/webapp/resources/facilityImage")).getCanonicalPath();
		//final String uploadPath1 = new File(session.getServletContext().getRealPath("/../../../../../../GD/src/main/webapp/resources/facilityImage")).getCanonicalPath();
		//final String uploadPath2 = new File(session.getServletContext().getRealPath("/../../../../../../GD/src/main/webapp/resources/facilityImage")).getCanonicalPath();
		//final String uploadPath = new File(session.getServletContext().getRealPath("/../../../../../../GD/src/main/webapp/resources/facilityImage")).getCanonicalPath();
		String uploadPath = request.getSession().getServletContext().getRealPath("resources/facilityImage");
		String uploadPath1 = request.getSession().getServletContext().getRealPath("resources/facilityImage");
		String uploadPath2 = request.getSession().getServletContext().getRealPath("resources/facilityImage");
		//String uploadPath = "D:/GDProject/spring_sts/workspace/GD/src/main/webapp/resources/assets/img";
		String url = "redirect:/login";
		
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		File file;
		File file1;
		File file2;
		int facilityUpdate;
		String fac_name = facilityVO.getFac_name();
		String fac_desc = facilityVO.getFac_desc();
		
		if(memberVO != null){
			model.addAttribute("memberVO",memberVO);
			if(!multipartFile.isEmpty()&&!multipartFile1.isEmpty()&&!multipartFile2.isEmpty()){
				file = new File(uploadPath, "$$"+System.currentTimeMillis() + multipartFile.getOriginalFilename());
				file1 = new File(uploadPath1, "$$"+System.currentTimeMillis() + multipartFile1.getOriginalFilename());
				file2 = new File(uploadPath2, "$$"+System.currentTimeMillis() + multipartFile2.getOriginalFilename());
				multipartFile.transferTo(file);
				multipartFile1.transferTo(file1);
				multipartFile2.transferTo(file2);
				
				fac_name = fac_name.replace("<", "＜");
				fac_name = fac_name.replace(">", "＞");
				fac_desc = fac_desc.replace("<", "＜");
				fac_desc = fac_desc.replace(">", "＞");
				
				facilityVO.setFac_name(fac_name);
				facilityVO.setFac_desc(fac_desc);
				facilityVO.setFac_img(file.getName());
				facilityVO.setFac_img1(file1.getName());
				facilityVO.setFac_img2(file2.getName());
				facilityUpdate = facilityService.facilityUpdate(facilityVO);
				url = "redirect:/companyFacilityList";
			}else if(!multipartFile.isEmpty()&&!multipartFile.equals(facilityVO.getFac_img())){
				file = new File(uploadPath, "$$"+System.currentTimeMillis() + multipartFile.getOriginalFilename());
				multipartFile.transferTo(file);
				
				fac_name = fac_name.replace("<", "＜");
				fac_name = fac_name.replace(">", "＞");
				fac_desc = fac_desc.replace("<", "＜");
				fac_desc = fac_desc.replace(">", "＞");
				
				facilityVO.setFac_name(fac_name);
				facilityVO.setFac_desc(fac_desc);
				facilityVO.setFac_img(file.getName());
				facilityUpdate = facilityService.facilityUpdate1(facilityVO);
				url = "redirect:/companyFacilityList";
			}else if(!multipartFile1.isEmpty()&&!multipartFile1.equals(facilityVO.getFac_img1())){
				file1 = new File(uploadPath1, "$$"+System.currentTimeMillis() + multipartFile1.getOriginalFilename());
				multipartFile1.transferTo(file1);
				
				fac_name = fac_name.replace("<", "＜");
				fac_name = fac_name.replace(">", "＞");
				fac_desc = fac_desc.replace("<", "＜");
				fac_desc = fac_desc.replace(">", "＞");
				
				facilityVO.setFac_name(fac_name);
				facilityVO.setFac_desc(fac_desc);
				facilityVO.setFac_img1(file1.getName());
				facilityUpdate = facilityService.facilityUpdate2(facilityVO);
				url = "redirect:/companyFacilityList";
			}else if(!multipartFile2.isEmpty()&&!multipartFile2.equals(facilityVO.getFac_img2())){
				file2 = new File(uploadPath2, "$$"+System.currentTimeMillis() + multipartFile2.getOriginalFilename());
				multipartFile2.transferTo(file2);
				
				fac_name = fac_name.replace("<", "＜");
				fac_name = fac_name.replace(">", "＞");
				fac_desc = fac_desc.replace("<", "＜");
				fac_desc = fac_desc.replace(">", "＞");
				
				facilityVO.setFac_name(fac_name);
				facilityVO.setFac_desc(fac_desc);
				facilityVO.setFac_img2(file2.getName());
				facilityUpdate = facilityService.facilityUpdate3(facilityVO);
				url = "redirect:/companyFacilityList";
			}else{
				fac_name = fac_name.replace("<", "＜");
				fac_name = fac_name.replace(">", "＞");
				fac_desc = fac_desc.replace("<", "＜");
				fac_desc = fac_desc.replace(">", "＞");
				
				facilityVO.setFac_name(fac_name);
				facilityVO.setFac_desc(fac_desc);
				facilityUpdate = facilityService.facilityUpdate4(facilityVO);
				url = "redirect:/companyFacilityList";
			}
		}
		
		return url;
	}
	
	/**
	 * 사내시설 삭제
	 * @param : String fac_code
	 * @return : redirect:/companyFacilityList
	 * @throws 
	 */
	@RequestMapping("/adminFacilityDelete")
	public String adminFacilityDelete(@RequestParam("fac_code")String fac_code, Model model
				, HttpSession session) {
		String url = "redirect:/login";
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		
		if(memberVO != null){
			model.addAttribute("memberVO",memberVO);
			int facilityDelete = facilityService.facilityDelete(fac_code);
			url = "redirect:/companyFacilityList";
		}
		return url;
	}

	/**
	 * 전체 예약 정보
	 * @param : 
	 * @return : "companyFacility/allReservation";
	 * @throws 
	 */
	@RequestMapping(value="/allReservation")
	public String allReservation(Model model, HttpSession session) {
		String url = "redirect:/login";
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		
		if(memberVO != null){
			model.addAttribute("memberVO",memberVO);
			List<ReservationVO> allReservation = facilityService.allReservation();
			model.addAttribute("allReservation",allReservation);
			url = "companyFacility/allReservationInformation";
		}
		return url;
	}
	
	/**
	 * 전체 예약 정보 excel 출력
	 * @param : 
	 * @return : "allReservationListExcel";
	 * @throws 
	 */
	//excel 출력
	@RequestMapping(value="/allReservationListExcel")
	public String allReservationListExcel(Model model, HttpSession session){
		
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		
		if(memberVO != null){
			model.addAttribute("memberVO",memberVO);
			List<ReservationVO> allReservation = facilityService.allReservation();
			model.addAttribute("allReservation",allReservation);
		}
		return "allReservationListExcel";
	}

}











