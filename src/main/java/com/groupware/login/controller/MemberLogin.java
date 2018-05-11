package com.groupware.login.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.groupware.dto.BoardVO;
import com.groupware.dto.MemberVO;
import com.groupware.dto.ProjectVO;
import com.groupware.dto.Sign_DocumentVO;
import com.groupware.electronicApproval.service.IElectronicApprovalService;
import com.groupware.groupBoard.service.IGroupBoardService;
import com.groupware.login.common.MimeRegistrationNotifier;
import com.groupware.login.common.Receiver;
import com.groupware.login.service.ILoginService;
import com.groupware.main.service.IMainService;
import com.groupware.project.service.IProjectService;

/**
 * @Class Name : MemberLogin.java
 * @Description : 로그인, 세션세팅 ,임시비밀번호 발송
 * @Modification Information
 * @author 이준수
 * @since 2016.09.01.
 * @version 1.0
 * @see <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.09.01.  이준수        최초생성
 *    2016.09.17.  이준수        암호화 및 임시 비밀번호 발송
 *    2016.09.20.  김태균        암호화 수정 공지사항, 전자결재 추가, 세션세팅 		
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */

@Controller
public class MemberLogin {
	@Autowired
	ILoginService loginService;
	@Autowired
	private IGroupBoardService service= null;
	@Autowired	
	IProjectService projectService;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	MimeRegistrationNotifier mimeNotifier;
	
	@Autowired
	private IElectronicApprovalService electronicApprovalService2;
	
	@Autowired
	private IMainService iMainService;
	
	
	/**
	 * 메인
	 * 
	 * @param 
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "/main")
	public String Login(HttpSession session, Model model) throws SQLException, ParseException {
		String url = "redirect:/login";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		int noneReadMsg = 0;
		noneReadMsg = iMainService.noneReadMsg(loginUser.getMem_num());
		session.setAttribute("noneReadMsg", noneReadMsg);
		
		if (loginUser != null) {
			url = "/main/main";
			//공지사항 시작
			List<BoardVO> noticeList = service.getNoticeList();
			model.addAttribute("noticeList",noticeList);
			//공지사항 끝
			//전자결재 시작
			Map<String, Object> info = new HashMap<String, Object>();
				info.put("stateNum", 1);
				info.put("mem_num", loginUser.getMem_num());
				List<Sign_DocumentVO> getDocumentList = electronicApprovalService2.getDocumentList(info);
				if(getDocumentList.size()!=0){
					model.addAttribute("getDocumentList1", getDocumentList);
				}
			
				info.put("stateNum", 2);
				info.put("mem_num", loginUser.getMem_num());
				getDocumentList = electronicApprovalService2
						.getDocumentList(info);
				if(getDocumentList.size()!=0){
					model.addAttribute("getDocumentList2", getDocumentList);
				}
				info.put("stateNum", 5);
				info.put("mem_num", loginUser.getMem_num());
				List<Sign_DocumentVO> getDocumentListWait = electronicApprovalService2
						.getDocumentList(info);
				if(getDocumentListWait.size()!=0){
					model.addAttribute("getDocumentListWait", getDocumentListWait);
				}
			
				info.put("stateNum", 3);
				info.put("mem_num", loginUser.getMem_num());
				getDocumentList = electronicApprovalService2.getDocumentList(info);
				if(getDocumentList.size()!=0){
					model.addAttribute("getDocumentList3", getDocumentList);
				}
			//전자결재 끝
			//프로젝트 현황 
			List<ProjectVO> projectList;
			projectList = projectService.getMainProjectList();
			for (int i = 0; i < projectList.size(); i++) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String beg_Day = projectList.get(i).getPro_beg_day();
				String end_Day = projectList.get(i).getPro_end_day();
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
				int progress = (int) (Math.random()*2);
				int color = (int) (Math.random()*4);
				if(progress>0){
					projectList.get(i).setProgress("progress progress-xs progress-striped active");
				}else{
					projectList.get(i).setProgress("progress progress-xs");
				}
				switch (color) {
				case 0:
					projectList.get(i).setColor("badge bg-red");
					projectList.get(i).setProgress2("progress-bar progress-bar-danger");
					break;
				case 1:
					projectList.get(i).setProgress2("progress-bar progress-bar-yellow");
					projectList.get(i).setColor("badge bg-yellow");
					break;
				case 2:
					projectList.get(i).setProgress2("progress-bar progress-bar-primary");
					projectList.get(i).setColor("badge bg-light-blue");
					break;
				default:
					projectList.get(i).setProgress2("progress-bar progress-bar-success");
					projectList.get(i).setColor("badge bg-green");
					break;
				}
				projectList.get(i).setPercent((int)proPercent);
			}
			model.addAttribute("projectList",projectList);
			model.addAttribute("memberVO", loginUser);
		}
		//메인 프로젝트 현황 끝
		return url;
	}

	/**
	 * 세션세팅
	 * 
	 * @param 
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "/sessionSetting")
	public String sessionSetting(HttpSession session, Model model) {
		String url = "redirect:/main";
		MemberVO  memberVO = (MemberVO) session.getAttribute("loginUser");
		session.setAttribute("loginUser", memberVO);
		model.addAttribute("memberVO", memberVO);
		return url;
	}
	
	/**
	 * 로그인
	 * 
	 * @param 
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "/login")
	public String login(Model model) {
		String url = "/login/login";
		return url;
	}

	/**
	 * 로그아웃
	 * 
	 * @param 
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		String url = "redirect:/login";
		session.removeAttribute("loginUser");
		return url;
	}

	/**
	 * 임시비밀번호 변경
	 * 
	 * @param  
	 * @return String
	 * @throws 
	 */
	@RequestMapping("/passwordChange")
	public String passwordChange(Model model) {
		String url = "/login/passwordChange";
		return url;
	}
	
	/**
	 * 로그인 처리
	 * 
	 * @param String id, String password
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	@ResponseBody
	public String loginCheck(@RequestParam("mem_num") String id, @RequestParam("mem_pw") String password, Model model,
			HttpSession session) {
		MemberVO memberVO = loginService.login(id);
		String result = "network error";
		if (memberVO != null) {
			Boolean passCheck = passwordEncoder.matches(password, memberVO.getMem_pw());
			if(passCheck){
				session.setAttribute("loginUser", memberVO);
			}
			result = passCheck? "login success" : "invalid password";
		} else {
			result = "account not exist";
		}
		return result;
	}

	/**
	 * 임시비밀번호 발송
	 * 
	 * @param String reg, String mail, String id
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "/passwordSend", method = RequestMethod.POST)
	@ResponseBody
	public String passwordSend(@RequestParam("mem_num") String id,
			@RequestParam("mem_reg") String reg,
			@RequestParam("mem_mail") String mail) {
		String tempPwd = null;
		String email = "";
		String regNum = "";
		if (id != "" || email != "") {
			MemberVO memberVO = loginService.login(id);
			regNum = memberVO.getMem_reg1()+memberVO.getMem_reg2();
			if (memberVO.getMem_em().equals(mail) && regNum.equals(reg)) {
				tempPwd = loginService.passwordSend(id, reg);
				mimeNotifier.sendMail(new Receiver(mail), tempPwd);
				email = memberVO.getMem_em();
			}
		}
		return email;
	}

}
