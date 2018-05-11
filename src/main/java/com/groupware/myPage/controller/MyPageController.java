package com.groupware.myPage.controller;

import java.util.List;


import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.groupware.dto.MemberVO;
import com.groupware.dto.attendance.AttendanceVO;
import com.groupware.main.service.IMainService;
import com.groupware.myPage.service.IMyPageService;

/**
 * @Class Name : MyPageController.java
 * @Description : 개인정보수정, 증명서출력, 근태 조회
 * @Modification Information
 * @author 이준수
 * @since 2016.09.01.
 * @version 1.0
 * @see <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.09.01.  이준수        최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */

@Controller
public class MyPageController {
	@Autowired
	private IMyPageService iMyPageService;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private IMainService iMainService;
	
	/**
	 * 개인정보
	 * 
	 * @param 
	 * @return String
	 * @throws 
	 */
	@RequestMapping("/personalInformation")
	public String personalInformation(Model model, HttpSession session) {
		String url = "redirect:/login";

		if (session.getAttribute("loginUser") != null) {
			MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
			model.addAttribute("memberVO", memberVO);
			String id = memberVO.getMem_num();
			MemberVO member = iMyPageService.personalInformation(id);
			model.addAttribute("member", member);

			MemberVO memberId = iMyPageService.serverancePay(id);
			model.addAttribute("member", memberId);


			url = "myPage/personalInformation";
		}

		return url;
	}

	/**
	 * 개인정보 수정 폼
	 * 
	 * @param 
	 * @return String
	 * @throws 
	 */
	@RequestMapping("/personalInformationUpdateForm")
	public String personalInformationUpdateForm(Model model, HttpSession session) {
		String url = "redirect:/login";
		if (session.getAttribute("loginUser") != null) {
			MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
			model.addAttribute("memberVO", memberVO);

			int noneReadMsg = iMainService.noneReadMsg(memberVO.getMem_num());
			session.setAttribute("noneReadMsg", noneReadMsg);

			String id = memberVO.getMem_num();

			MemberVO member = iMyPageService.personalInformation(id);
			model.addAttribute("member", member);
			url = "myPage/personalInformationUpdate";
		}
		return url;
	}
	
	/**
	 * 개인정보 수정하기
	 * 
	 * @param MemberVO member, String mem_em, String domain
	 * @return String
	 * @throws 
	 */
	@RequestMapping("/personalInformationUpdate")
	public String personalInformationUpdate(Model model, HttpSession session,
			MemberVO member, @RequestParam("mem_em") String mem_em,
			@RequestParam("domain") String domain) {
		String url = "redirect:/login";
		if (session.getAttribute("loginUser") != null) {
			MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
			String id = memberVO.getMem_num();
			String img = memberVO.getMem_img();
			member.setMem_num(id);
			member.setMem_em(mem_em + "@" + domain);
			String bCryptString = "";
			if (member.getMem_pw() == "".trim()) {
				member.setMem_pw(memberVO.getMem_pw());
			} else {
				if (StringUtils.hasText(member.getMem_pw())) {
					// 암호화 작업
					bCryptString = passwordEncoder.encode(member.getMem_pw());
					member.setMem_pw(bCryptString);
				}
			}
			iMyPageService.personalInformationuUpdate(member);
			model.addAttribute("member", member);
			session.setAttribute("loginUser", memberVO);
			url = "redirect:/personalInformation";
		}
		return url;
	}

	/*
	 * @RequestMapping("/severancePay") public String severancePay(Model model,
	 * HttpSession session) { MemberVO memberVO = (MemberVO)
	 * session.getAttribute("loginUser");
	 * model.addAttribute("memberVO",memberVO); String id =
	 * memberVO.getMem_num(); MemberVO member =
	 * iMyPageService.serverancePay(id); model.addAttribute("member",member);
	 * String url = "myPage/severancePay";
	 * 
	 * return url; }
	 */
	
	/**
	 * 증명서 출력
	 * 
	 * @param 
	 * @return String
	 * @throws 
	 */
	@RequestMapping("/certificate")
	public String certificate(Model model, HttpSession session) {
		String url = "redirect:/login";
		if (session.getAttribute("loginUser") != null) {
			MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
			model.addAttribute("memberVO", memberVO);
			String id = memberVO.getMem_num();
			MemberVO member = iMyPageService.personalInformation(id);
			model.addAttribute("member", member);


			url = "myPage/certificate";
		}
		return url;
	}

	/**
	 * 근태 조회
	 * 
	 * @param 
	 * @return String
	 * @throws 
	 */
	@RequestMapping("/diligenceCheck")
	public String diligenceCheck(Model model, HttpSession session) {
		String url = "redirect:/login";
		if (session.getAttribute("loginUser") != null) {
			MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
			String id = memberVO.getMem_num();
			List<AttendanceVO> attendanceList = null;
			attendanceList = iMyPageService.diligenceCheck(id);


			model.addAttribute("attendanceList", attendanceList);
			model.addAttribute("memberVO", memberVO);
			url = "myPage/diligenceCheck";
		}
		return url;
	}

	/**
	 * 근태 검색 조회
	 * 
	 * @param String keyword, String startDate, String endDate
	 * @return List<AttendaceVO>
	 * @throws 
	 */
	@RequestMapping("/searchDilCheck")
	@ResponseBody
	public List<AttendanceVO> searchDiligenceCheck(Model model,
			HttpSession session, @RequestParam String keyword,
			@RequestParam String startDate, @RequestParam String endDate) {
		String url = "redirect:/login";
		List<AttendanceVO> searchAttendanceList = null;
		if (session.getAttribute("loginUser") != null) {
			MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
			String id = memberVO.getMem_num();
			searchAttendanceList = iMyPageService.searchDiligenceCheck(id,
					keyword, startDate, endDate);
			model.addAttribute("memberVO", memberVO);
		}
		return searchAttendanceList;
	}

	/**
	 * 재직 증명서
	 * 
	 * @param String work, String request
	 * @return String
	 * @throws 
	 */
	@RequestMapping("/workPdf")
	public String workPdf(Model model, HttpSession session,
			@RequestParam("work") String work,
			@RequestParam("request") String request) {
		String url = "redirect:/login";
		if (session.getAttribute("loginUser") != null) {
			MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
			model.addAttribute("memberVO", memberVO);
			MemberVO member = iMyPageService.personalInformation(memberVO
					.getMem_num());
			model.addAttribute("member", member);
			model.addAttribute("work", work);
			model.addAttribute("request", request);
		}
		return "workPdf";
	}

	/**
	 * 경력 증명서
	 * 
	 * @param String work, String request
	 * @return String
	 * @throws 
	 */
	@RequestMapping("/careerPdf")
	public String careerPdf(Model model, HttpSession session,
			@RequestParam("work") String work,
			@RequestParam("request") String request) {
		String url = "redirect:/login";
		if (session.getAttribute("loginUser") != null) {
			MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
			model.addAttribute("memberVO", memberVO);
			MemberVO member = iMyPageService.personalInformation(memberVO
					.getMem_num());
			model.addAttribute("member", member);
			model.addAttribute("work", work);
			model.addAttribute("request", request);
		}
		return "careerPdf";
	}

	/**
	 * 비밀번호 수정 폼
	 * 
	 * @param  
	 * @return String
	 * @throws 
	 */
	@RequestMapping("passwordUpdateForm")
	public String passwordUpdateForm(HttpSession session, Model model) {
		String url = "redirect:/login";
		if (session.getAttribute("loginUser") != null) {
			url = "myPage/passwordUpdateForm";
			MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
			model.addAttribute("memberVO", memberVO);
		}
		return url;
	}

	/**
	 * 비밀번호 수정
	 * 
	 * @param  String new_pw
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "passwordUpdate", method = RequestMethod.POST)
	public String passwordUpdate(@RequestParam("new_pw") String new_pw,
			HttpSession session) {
		String url = "redirect:/login";
		if (session.getAttribute("loginUser") != null) {
			url = "redirect:/personalInformationUpdateForm";
			MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
			String id = memberVO.getMem_num();
			String bCryptString = "";
			MemberVO member = new MemberVO();
			if (StringUtils.hasText(new_pw)) {
				// 암호화 작업
				bCryptString = passwordEncoder.encode(new_pw);
			}
			iMyPageService.passwordUpdate(bCryptString, id);
		}
		return url;
	}

	/**
	 * 현재 비밀번호 확인 폼
	 * 
	 * @param  
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "passwordCheckForm", method = RequestMethod.GET)
	public String passwordCheckForm(HttpSession session) {
		String url = "redirect:/login";
		if (session.getAttribute("loginUser") != null) {
			url = "myPage/passwordCheckForm";
		}
		return url;
	}

	/**
	 * 현재 비밀번호 확인
	 * 
	 * @param String curr_pw
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "passwordCheck", method = RequestMethod.POST)
	@ResponseBody
	public String passwordCheck(HttpSession session,
			@RequestParam("cur_pw") String curr_pw) {
		String url = "redirect:/login";
		String result = "";
		if (session.getAttribute("loginUser") != null) {
			MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
			Boolean passCheck = passwordEncoder.matches(curr_pw,
					memberVO.getMem_pw());
			result = passCheck ? "pwd" : "";
		}
		return result;
	}
}