package com.groupware.main.controller;

import java.util.List;
import java.util.Map;

import javax.mail.Message;
import javax.servlet.http.HttpSession;

import oracle.net.aso.i;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.groupware.dto.MemberVO;
import com.groupware.dto.MessageVO;
import com.groupware.main.service.IMainService;

/**
 * @Class Name : MainController.java
 * @Description : 메인
 * @Modification Information
 * @author 이준수
 * @since 2016.09.01.
 * @version 1.0
 * @see <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.09.01.  이준수        최초생성
 *    2016.09.24.  이준수		메시지함 추가 및 알림
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */

@Controller
public class MainController {
	@Autowired
	private IMainService iMainService;

	/**
	 * 새메시지 확인
	 * 
	 * @param 
	 * @return void 
	 * @throws 
	 */
	@RequestMapping(value = "newMsgCheck")
	public void newMsgCheck(HttpSession session) {
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		iMainService.newMsgCheck(memberVO.getMem_num());
	}

	/**
	 * 메시지리스트
	 * 
	 * @param 
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "/messageList")
	public String messageList(Model model, HttpSession session) {
		String url = "redirect:/login";
		if (session.getAttribute("loginUser") != null) {
			url = "/main/messageList";
			MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
			model.addAttribute("memberVO", memberVO);
			String id = memberVO.getMem_num();
			List<MessageVO> messageList = iMainService.messageList(id);
			session.setAttribute("messageList", messageList);
		}
		return url;
	}

	/**
	 * 메시지 쓰기 폼
	 * @param 
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "/writeMessageForm")
	public String sendMessageForm(HttpSession session, Model model) {
		String url = "redirect:/login";
		if (session.getAttribute("loginUser") != null) {
			url = "/main/writeMessageForm";
			MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");


			model.addAttribute("memberVO", memberVO);
		}
		return url;
	}

	/**
	 * 메시지 보내기
	 * 
	 * @param MessageVO messageVO
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "/sendMessage")
	public String sendMessage(MessageVO messageVO, HttpSession session,
			Model model) {
		String url = "redirect:/login";
		if (session.getAttribute("loginUser") != null) {
			url = "redirect:/messageList";
			MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
			String[] str = messageVO.getMess_get_mem_num().split("\\(");
			messageVO.setMess_get_mem_num(str[0]);
			messageVO.setMess_send_mem_num(memberVO.getMem_num());
			String title = messageVO.getMess_title().replace("<", "&lt;");
			title = title.replace(">", "&gt;");
			messageVO.setMess_title(title);
			iMainService.newMsgCheck(memberVO.getMem_num());
			iMainService.sendMessage(messageVO);
		}
		return url;
	}

	/**
	 * 메시지 상세보기
	 * 
	 * @param MessageVO messageVO
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "/deMessage",method=RequestMethod.GET)
	public String detailMessage(Model model, MessageVO messageVO,
			HttpSession session) {
		String url = "redirect:/login";
		if (session.getAttribute("loginUser") != null) {
			url = "main/detailMessage";
			MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
			String code = messageVO.getMess_num();
			iMainService.readProcess(code);
			messageVO = iMainService.detailMessage(code);
			model.addAttribute("memberVO",memberVO);
			model.addAttribute("messageVO", messageVO);
		}
		return url;
	}

	/**
	 * 메시지 주소록
	 * 
	 * @param 
	 * @return String
	 * @throws 
	 */
	@RequestMapping("/messageAddressBook")
	public String messageAddressBook(Model model, HttpSession session) {
		String url = "redirect:/login";
		if (session.getAttribute("loginUser") != null) {
			MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
			model.addAttribute("memberVO", memberVO);
			url = "main/messageAddressBook";
		}
		return url;
	}

	/**
	 * 메시지 서버
	 * 
	 * @param 
	 * @return String
	 * @throws 
	 */
	@RequestMapping("/messageServer")
	public String server(Model model, HttpSession session) {
		String url = "redirect:/login";
		if (session.getAttribute("loginUser") != null) {
			url = "main/server";
			MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
			int newMsgPush = 0;
			int noneReadMsg = 0;
			newMsgPush = iMainService.newMsgPush(memberVO.getMem_num());
			noneReadMsg = iMainService.noneReadMsg(memberVO.getMem_num());
			session.setAttribute("newMsgPush", newMsgPush);
			session.setAttribute("noneReadMsg", noneReadMsg);
		}
		return url;
	}

	/**
	 * 메시지 삭제
	 * 
	 * @param String mess_num
	 * @return String
	 * @throws 
	 */
	@RequestMapping("/messageDelete")
	public String messageDelete(Model model, HttpSession session,
			@RequestParam("mess_num") String mess_num) {
		String url = "redirect:/login";
		if (session.getAttribute("loginUser") != null) {
			url = "redirect:/messageList";
			MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
			MessageVO messageVO = new MessageVO();
			messageVO.setMess_num(mess_num);
			messageVO.setMess_get_mem_num(memberVO.getMem_num());

			iMainService.messageDelete(messageVO);
		}
		return url;
	}
}
