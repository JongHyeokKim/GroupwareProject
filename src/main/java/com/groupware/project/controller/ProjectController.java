package com.groupware.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.groupware.dto.EmployeeProjectVO;
import com.groupware.dto.MemberVO;
import com.groupware.dto.OpinionVO;
import com.groupware.dto.ProjectVO;
import com.groupware.project.dao.ProjectDAOImpl;
import com.groupware.project.service.IProjectService;

/**
 * @Class Name : ProjectController.java
 * @Description : 프로젝트, 개인일정 CRUD
 * @Modification Information
 * @author 정준호
 * @since 2016.09.01.
 * @version 1.0
 * @see <pre>
 * << 개정이력(Modification Information) >>
 *    	수정일            수정자                    수정내용
 *    -------      -------     -------------------
 *   2016.09.01.    정준호                    최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */

@Controller
public class ProjectController {
	@Autowired
	IProjectService service;
	/**
	 * 프로젝트 메인 페이지
	 * 
	 * @param
	 * @return String
	 * @throws
	 */

	
	@RequestMapping("/workSchedule")
	public String main(Model model, HttpSession session) {
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		String url = "redirect:/login";
		if (memberVO != null) {
			url = "project/workSchedule";
			model.addAttribute("memberVO", memberVO);
		}
		return url;
	}

	/**
	 * 프로젝트관리 페이지
	 * 
	 * @param 
	 * @return List<ProjectVO>
	 * @throws try
	 *             /catch
	 */
	@RequestMapping("/projectSchedule")
	public String main2(Model model,
			@RequestParam(value = "pro_nm", defaultValue = "") String pro_nm,
			HttpSession session,
			@RequestParam(value = "tpage", defaultValue = "1") String tpage)
			throws ParseException {
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		String url = "redirect:/login";
		if (memberVO != null) {
			model.addAttribute("memberVO", memberVO);
			List<ProjectVO> list = null;
			url = "project/projectSchedule";
			String paging = null;
			try {
				int totalPage = service.getTotalRecord(pro_nm);
				int page_count = totalPage / 10 + 1;
				int comPage = Integer.parseInt(tpage);
				if (comPage > page_count) {
					tpage = page_count + "";
					url = "redirect:projectSchedule?tpage=" + tpage
							+ "&pro_nm=" + pro_nm;
				}
				list = service.listProject(Integer.parseInt(tpage), pro_nm);
				paging = service.pageNumber(Integer.parseInt(tpage), pro_nm);

			} catch (SQLException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < list.size(); i++) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String beg_Day = list.get(i).getPro_beg_day();
				String end_Day = list.get(i).getPro_end_day();
				Date now = new Date(); // 오늘
				Date begDay = format.parse(beg_Day); // 시작일
				Date endDay = format.parse(end_Day); // 종료일
				double totalPer = endDay.getTime() - begDay.getTime();
				double totalper2 = (totalPer / (1000 * 60 * 60 * 24));
				double gap = now.getTime() - begDay.getTime();// 시작일 - 오늘
				gap = (gap / (1000 * 60 * 60 * 24)); // 시작일 - 오늘 숫자로
				double proPercent = (gap / totalper2) * 100;
				if (proPercent > 100) {
					proPercent = 100;
				} else if (proPercent < 0) {
					proPercent = 0;
				}
				int progress = (int) (Math.random() * 2);
				int color = (int) (Math.random() * 4);
				// 그래프 색상랜덤지정
				if (progress > 0) {
					list.get(i).setProgress(
							"progress progress-xs progress-striped active");
				} else {
					list.get(i).setProgress("progress progress-xs");
				}
				switch (color) {
				case 0:
					list.get(i).setColor("badge bg-red");
					list.get(i)
							.setProgress2("progress-bar progress-bar-danger");
					break;
				case 1:
					list.get(i)
							.setProgress2("progress-bar progress-bar-yellow");
					list.get(i).setColor("badge bg-yellow");
					break;
				case 2:
					list.get(i).setProgress2(
							"progress-bar progress-bar-primary");
					list.get(i).setColor("badge bg-light-blue");
					break;
				default:
					list.get(i).setProgress2(
							"progress-bar progress-bar-success");
					list.get(i).setColor("badge bg-green");
					break;
				}
				list.get(i).setPercent((int) proPercent);
			}
			model.addAttribute("projectList", list);
			model.addAttribute("paging", paging);
		}
		return url;
	}

	/**
	 * 프로젝트 의견 등록
	 * 
	 * @param (String, String)
	 * @return List<ProjectVO>
	 * @throws
	 */
	@RequestMapping("/insertOption")
	public String main3(HttpServletRequest request, Model model,
			@RequestParam("pro_code") String pro_code,
			@RequestParam("opinion") String opinion) {
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		String url = "redirect:/login";
		if (memberVO != null) {
			model.addAttribute("memberVO", memberVO);
			String mem_nm = memberVO.getMem_num();
			Map<String, String> map = new HashMap<String, String>();
			map.put("op_pro_code", pro_code);
			map.put("op_mem_code", mem_nm);
			opinion = opinion.replace("<", "＜");
			opinion = opinion.replace(">", "＞");
			map.put("op_opn", opinion);
			try {
				service.insertOption(map);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			url = "redirect:/projectSupervise?pro_code=" + pro_code;
		}
		return url;
	}

	/**
	 * 프로젝트 상세보기
	 * 
	 * @param (String)
	 * @return String
	 * @throws 
	 */
	@RequestMapping("/projectSupervise")
	public String main4(Model model, @RequestParam("pro_code") String pro_code,
			HttpSession session) {
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		String url = "redirect:/login";
		if (memberVO != null) {
		model.addAttribute("memberVO", memberVO);
		ProjectVO projectVO = new ProjectVO();
		List<MemberVO> members = null;
		try {
			projectVO = service.getCalendar(pro_code);
			members = service.getProjectMembers(pro_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("project", projectVO);
		model.addAttribute("members", members);
		url = "project/projectSupervise";
		}
		return url;
	}

	/**
	 * 일정 업데이트
	 * 
	 * @param (String, String)
	 * @return String
	 * @throws 
	 */
	@RequestMapping("/projectUpdate")
	public String main5(Model model,
			@RequestParam("proDetail") String proDetail,
			@RequestParam("pro_code") String pro_code, HttpSession session) {
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		String url = "redirect:/login";
		if (memberVO != null) {
		model.addAttribute("memberVO", memberVO);
		try {
			service.addProjectDetail(pro_code, proDetail);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		url = "redirect:/projectSupervise?pro_code=" + pro_code;
		}
		return url;
	}

	/**
	 * 개인 일정 페이지 불러오기
	 * 
	 * @param 
	 * @return String
	 * @throws
	 */
	@RequestMapping("employeeSchedule")
	public String employeeSchedule(Model model, HttpSession session) {
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		String url = "redirect:/login";
		if (memberVO != null) {
		model.addAttribute("memberVO", memberVO);
		url = "project/employeeSchedule";
		}
		return url;
	}

	/**
	 * 개인 일정 전체 불러오기
	 * 
	 * @param
	 * @return List<ProjectVO>
	 * @throws
	 */
	@RequestMapping("/getEmployeeSchedule")
	@ResponseBody
	public List<ProjectVO> employeeSchedule(HttpServletRequest request,
			Model model) {
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO", memberVO);
		String num = memberVO.getMem_num();
		List<ProjectVO> list = null;
		try {
			list = service.getEmployeeList(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 프로젝트 전체 리스트 불러오기
	 * 
	 * @param 
	 * @return List<ProjectVO>
	 * @throws 
	 */
	@RequestMapping("/selectCalendar")
	@ResponseBody
	public List<ProjectVO> getCalendarList(Model model, HttpSession session) {
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO", memberVO);
		List<ProjectVO> list = null;
		try {
			list = service.getCalendarList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 선택된 일정 번호 불러오기
	 * 
	 * @param (String)
	 * @return String
	 * @throws 
	 */
	@RequestMapping("/findId")
	@ResponseBody
	public String findId(Model model,
			@RequestParam("paramData") String paramData, HttpSession session) {
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO", memberVO);
		ObjectMapper mapper = new ObjectMapper();
		ProjectVO projectVO = new ProjectVO();
		ArrayList<Map<String, Object>> arrVal;
		try {
			arrVal = mapper.readValue(paramData, ArrayList.class);
			for (Map<String, Object> map : arrVal) {
				projectVO.setPro_nm((String) map.get("title"));
				projectVO.setPro_mm((String) map.get("content"));
				projectVO.setPro_beg_day((String) map.get("start"));
				projectVO.setPro_end_day((String) map.get("end"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String id = "";
		try {
			id = service.findId(projectVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	/**
	 * 선택된 개인일정 ID 불러오기
	 * 
	 * @param (String)
	 * @return String
	 * @throws 
	 */
	@RequestMapping("/employFindId")
	@ResponseBody
	public String employeeFindId(Model model, HttpServletRequest request,
			@RequestParam("paramData") String paramData) {
		ObjectMapper mapper = new ObjectMapper();
		EmployeeProjectVO employVO = new EmployeeProjectVO();
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO", memberVO);
		employVO.setMem_sch_mem_code(memberVO.getMem_num());
		ArrayList<Map<String, Object>> arrVal;
		try {
			arrVal = mapper.readValue(paramData, ArrayList.class);
			for (Map<String, Object> map : arrVal) {
				employVO.setMem_sch_tt((String) map.get("title"));
				employVO.setMem_sch_mm((String) map.get("content"));
				employVO.setMem_sch_beg_day((String) map.get("start"));
				employVO.setMem_sch_end_day((String) map.get("end"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String id = "";
		try {
			id = service.employeeFindId(employVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	/**
	 * 프로젝트 수정
	 * 
	 * @param (String, String)
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "/modifyCalendar", method = RequestMethod.GET)
	@ResponseBody
	public String modifyCalendar(Model model, HttpSession session,
			@RequestParam String paramData,
			@RequestParam(value = "id") String id) {
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO", memberVO);
		ObjectMapper mapper = new ObjectMapper();
		ProjectVO projectVO = new ProjectVO();
		projectVO.setPro_code(id);
		try {
			ArrayList<Map<String, Object>> arrVal = mapper.readValue(paramData,
					ArrayList.class);
			for (Map<String, Object> map : arrVal) {
				String title = (String) map.get("title");
				title = title.replace("<", "＜");
				title = title.replace(">", "＞");
				String content = (String) map.get("content");
				content = content.replace("<", "＜");
				content = content.replace(">", "＞");
				projectVO.setPro_nm(title);
				projectVO.setPro_mm(content);
				projectVO.setPro_beg_day((String) map.get("start"));
				projectVO.setPro_end_day((String) map.get("end"));
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			service.modifyCalendar(projectVO);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "project/workSchedule";
	}

	/**
	 * 프로젝트 삭제
	 * 
	 * @param (int)
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "/deleteCalendar", method = RequestMethod.GET)
	@ResponseBody
	public String deleteCalendar(@RequestParam int id, Model model,
			HttpSession session) {
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO", memberVO);
		try {
			service.deleteCalendar(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "project/workSchedule";
	}

	/**
	 * 개인 일정 삭제
	 * 
	 * @param (int)
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "/employeeDeleteCalendar", method = RequestMethod.GET)
	@ResponseBody
	public String employeeDeleteCalendar(@RequestParam int id, Model model,
			HttpSession session) {
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO", memberVO);
		try {
			service.employeeDeleteCalendar(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "project/workSchedule";
	}

	/**
	 * 전체 프로젝트 등록
	 * 
	 * @param (String)
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "/insetCalendar", method = RequestMethod.GET)
	@ResponseBody
	public String insertCalendar(@RequestParam String paramData, Model model,
			HttpSession session) {
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO", memberVO);
		ObjectMapper mapper = new ObjectMapper();
		ProjectVO projectVO = new ProjectVO();
		String memcode = "";
		try {
			ArrayList<Map<String, Object>> arrVal = mapper.readValue(paramData,
					ArrayList.class);
			for (Map<String, Object> map : arrVal) {
				String title = (String) map.get("title");
				title = title.replace("<", "＜");
				title = title.replace(">", "＞");
				String content = (String) map.get("content");
				content = content.replace("<", "＜");
				content = content.replace(">", "＞");
				projectVO.setPro_nm(title);
				projectVO.setPro_mm(content);
				projectVO.setPro_beg_day((String) map.get("start"));
				projectVO.setPro_end_day((String) map.get("end"));
				memcode = (String) map.get("memcode");
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			String member[] = memcode.split(",");
			String proNum = service.insertCalendar(projectVO);

			/**
			 * 프로젝트 함께할 인원 추가
			 * 
			 * @param (EmployeeProjectVO)
			 * @return void
			 * @throws 
			 */
			for (int i = 0; i < member.length; i++) {
				EmployeeProjectVO employVO = new EmployeeProjectVO();
				employVO.setMem_sch_mem_code(member[i]);
				employVO.setMem_sch_tt(projectVO.getPro_nm());
				employVO.setMem_sch_mm(projectVO.getPro_mm());
				employVO.setMem_sch_beg_day(projectVO.getPro_beg_day());
				employVO.setMem_sch_end_day(projectVO.getPro_end_day());
				employVO.setMem_sch_pro_code(proNum);
				service.addMember(employVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "project/workSchedule";
	}

	/**
	 * 개인 일정 등록
	 * 
	 * @param (String)
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "/employeeInsetCalendar", method = RequestMethod.GET)
	@ResponseBody
	public String employeeInsertCalendar(Model model,
			HttpServletRequest request, @RequestParam String paramData) {
		ObjectMapper mapper = new ObjectMapper();
		EmployeeProjectVO employVO = new EmployeeProjectVO();
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO", memberVO);
		try {
			ArrayList<Map<String, Object>> arrVal = mapper.readValue(paramData,
					ArrayList.class);
			for (Map<String, Object> map : arrVal) {
				String title = (String) map.get("title");
				title = title.replace("<", "＜");
				title = title.replace(">", "＞");
				String content = (String) map.get("content");
				content = content.replace("<", "＜");
				content = content.replace(">", "＞");
				employVO.setMem_sch_mem_code(memberVO.getMem_num());
				employVO.setMem_sch_tt(title);
				employVO.setMem_sch_mm(content);
				employVO.setMem_sch_beg_day((String) map.get("start"));
				employVO.setMem_sch_end_day((String) map.get("end"));
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			service.employeeInsertCalendar(employVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "project/workSchedule";
	}

	/**
	 * 개인 일정 수정
	 * 
	 * @param (String)
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "/employeeModifyCalendar", method = RequestMethod.GET)
	@ResponseBody
	public String employeeModifyCalendar(Model model,
			HttpServletRequest request, @RequestParam String paramData,
			@RequestParam(value = "id") String id) {

		ObjectMapper mapper = new ObjectMapper();
		EmployeeProjectVO employVO = new EmployeeProjectVO();
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO", memberVO);
		employVO.setMem_sch_code(id);
		employVO.setMem_sch_mem_code(memberVO.getMem_num());
		try {
			ArrayList<Map<String, Object>> arrVal = mapper.readValue(paramData,
					ArrayList.class);
			for (Map<String, Object> map : arrVal) {
				String title = (String) map.get("title");
				title = title.replace("<", "＜");
				title = title.replace(">", "＞");
				String content = (String) map.get("content");
				content = content.replace("<", "＜");
				content = content.replace(">", "＞");
				employVO.setMem_sch_tt(title);
				employVO.setMem_sch_mm(content);
				employVO.setMem_sch_beg_day((String) map.get("start"));
				employVO.setMem_sch_end_day((String) map.get("end"));
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			service.employeeModifyCalendar(employVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "project/workSchedule";
	}

	/**
	 * 주소록창 팝업
	 * 
	 * @param 
	 * @return String
	 * @throws
	 */
	@RequestMapping("/projectAddressBook")
	public String emailAddressBook(Model model, HttpSession session) {
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		String url = "redirect:/login";
		if (memberVO != null) {
		model.addAttribute("memberVO", memberVO);
		url = "project/projectAddressBook";
		}
		return url;
	}

	/**
	 * 선택된 프로젝트에 참여중인 인원 불러오기
	 * 
	 * @param (String)
	 * @return List<MemberVO>
	 * @throws 
	 */
	@RequestMapping("/getProjectMembers")
	@ResponseBody
	public List<MemberVO> getProjectMembers(Model model,
			@RequestParam("pro_code") String choice_pro_code,
			HttpSession session) {
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO", memberVO);
		List<MemberVO> members = null;
		try {
			members = service.getProjectMembers(choice_pro_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return members;
	}

	/**
	 * 개인일정중 선택된 프로젝트에 참여중인 인원 불러오기
	 * 
	 * @param (String)
	 * @return List<MemberVO>
	 * @throws 
	 */
	@RequestMapping("/getProjectMembers2")
	@ResponseBody
	public List<MemberVO> getProjectMembers2(Model model,
			@RequestParam("pro_code") String choice_pro_code,
			HttpSession session) {
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO", memberVO);
		List<MemberVO> members = null;
		try {
			members = service.getProjectMembers2(choice_pro_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return members;
	}

	/**
	 * 프로젝트 의견 불러오기
	 * 
	 * @param (String)
	 * @return List<OpinionVO>
	 * @throws 
	 */
	@RequestMapping("getOpinion")
	@ResponseBody
	public List<OpinionVO> getOpinion(
			@RequestParam("pro_code") String pro_code, Model model,
			HttpSession session) {
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO", memberVO);
		List<OpinionVO> list = null;
		try {
			list = service.getOpinion(pro_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 프로젝트 의견 삭제
	 * 
	 * @param (String)
	 * @return String
	 * @throws 
	 */
	@RequestMapping("/opinionDelete")
	public String opinionDelete(@RequestParam("op_code") String op_code,
			@RequestParam("pro_code") String pro_code, Model model,
			HttpSession session) {
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		String url = "redirect:/login";
		if (memberVO != null) {
		model.addAttribute("memberVO", memberVO);
		try {
			service.opinionDelete(op_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		url = "redirect:/projectSupervise?pro_code=" + pro_code;
		}
		return url;
	}
}