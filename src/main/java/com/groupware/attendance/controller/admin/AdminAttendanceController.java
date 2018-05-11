package com.groupware.attendance.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.groupware.attendance.service.IAttendanceService;
import com.groupware.dto.MemberVO;
import com.groupware.dto.attendance.AttendanceVO;
import com.groupware.dto.attendance.DepartVO;
import com.groupware.dto.attendance.WorkStateVO;

/**
 * @Class Name : AdminAttendanceController.java
 * @Description : 관리자 근태 정보 및 관리를 위한 클래스
 * @Modification Information
 * @author 김태균
 * @since 2016.09.01.
 * @version 1.0
 * @see <pre>
 * << 개정이력(Modification Information) >>
 *    	수정일                  수정자                    수정내용
 *    -------      -------     -------------------
 *   2016.09.01.    김태균                    최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */

@Controller
public class AdminAttendanceController {

	@Autowired
	private IAttendanceService iAttendanceService;
	
	/**
	 * 근태 정보 리스트 출력
	 * 
	 * @param none
	 * @return String
	 * @throws none
	 */
	@RequestMapping("/attendanceList")
	// 리스트
	public String attendanceList(Model model, HttpSession session) {
		String url = "redirect:/login";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO", loginUser);
		if(loginUser !=null){
			ArrayList<AttendanceVO> attendanceList = iAttendanceService.getAttendanceList();
			ArrayList<DepartVO> departList = iAttendanceService.getDepartList();
			ArrayList<WorkStateVO> workStateList = iAttendanceService.getWorkStateList();
			model.addAttribute("attendanceList", attendanceList);
			model.addAttribute("departList", departList);
			model.addAttribute("workStateList", workStateList);
			url = "attendance/attendanceList";
		}
		return url;
	}
	
	/**
	 * 근태 정보 상세 페이지 출력
	 * 
	 * @param String
	 * @return String
	 * @throws none
	 */
	@RequestMapping("/attendanceDetailList")
	// 상세보기
	public String adminAttendanceDetailList(Model model, @RequestParam(value = "att_date") String att_date, @RequestParam(value = "att_mem_num") String att_mem_num, HttpSession session) {
		String url = "redirect:/login";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO", loginUser);
		if(loginUser!=null){
			Map<String, String> info = new HashMap<String, String>();
			info.put("att_date", att_date);
			info.put("att_mem_num", att_mem_num);
			AttendanceVO attendanceInfo = iAttendanceService.getAttendanceDetailList(info);
			model.addAttribute("attendanceInfo", attendanceInfo);
			url = "attendance/attendanceDetailList";
		}
		return url;
	}
	
	/**
	 * 근태 정보 수정
	 * 
	 * @param String
	 * @return String
	 * @throws none
	 */
	@RequestMapping(value = "/attendanceUpdate", method = RequestMethod.GET)
	// 업데이트
	public String attendanceUpdate(Model model, @RequestParam(value = "att_date") String att_date, @RequestParam(value = "att_mem_num") String att_mem_num, @RequestParam(value="att_wk_st_code") String att_wk_st_code, HttpSession session) {
		String url = "redirect:/login";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO", loginUser);
		if(loginUser!=null){
			Map<String, String> info = new HashMap<String, String>();
			info.put("att_date", att_date);
			info.put("att_mem_num", att_mem_num);
			info.put("att_wk_st_code", att_wk_st_code);
			iAttendanceService.getAttendanceUpdate(info);
			url = "redirect:/attendanceList";
		}
		return url;
	}
	
	/**
	 * 근태 정보 검색
	 * 
	 * @param String
	 * @return int
	 * @throws none
	 */
	@RequestMapping(value = "/searchAttendanceAdmin", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<AttendanceVO> searchAttendance(Model model, @RequestParam(value = "startDate") String startDate, @RequestParam(value = "endDate") String endDate, @RequestParam(value="depart") String depart, @RequestParam(value="name") String mem_nm, @RequestParam(value = "state") String state) {
		ArrayList<AttendanceVO> result = null;
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("startDate", startDate);
		params.put("endDate", endDate);
		params.put("depart", depart);
		params.put("state", state);
		params.put("name", mem_nm);
		if(mem_nm.equals("")){
			if(depart.equals("0")){
				if(state.equals("0")){
					result = iAttendanceService.getAttDefault(params);
				}else{
					result = iAttendanceService.getAttWithState(params);
				}
			}else{
				if(state.equals("0")){
					result = iAttendanceService.getAttWithDepart(params);
				}else{
					result = iAttendanceService.getAttWithDepartState(params);
				}
			}
		}else{
			if(depart.equals("0")){
				if(state.equals("0")){
					result = iAttendanceService.getAttWithName(params);
				}else{
					result = iAttendanceService.getAttWithNameState(params);
				}
			}else{
				if(state.equals("0")){
					result = iAttendanceService.getAttWithNameDepart(params);
				}else{
					result = iAttendanceService.getAttWithNameDepartState(params);
				}
			}
		}
		return result;
	}
	
	/**
	 * 메인 페이지의 출근 처리
	 * 
	 * @param none
	 * @return int
	 * @throws none
	 */
	@RequestMapping("/attendanceCheckIn")
	@ResponseBody
	public int attendanceCheckIn(HttpSession session) {
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		return iAttendanceService.attendanceCheckIn(loginUser.getMem_num());
	}
	/**
	 * 메인 페이지의 퇴근 처리
	 * 
	 * @param none
	 * @return int
	 * @throws none
	 */
	@RequestMapping("/attendanceCheckOut")
	@ResponseBody
	public int attendanceCheckOut(HttpSession session) {
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		return iAttendanceService.attendanceCheckOut(loginUser.getMem_num());
	}
}
