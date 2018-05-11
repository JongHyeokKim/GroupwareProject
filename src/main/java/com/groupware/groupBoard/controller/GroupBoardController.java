package com.groupware.groupBoard.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.groupware.dto.BoardVO;
import com.groupware.dto.MemberVO;
import com.groupware.groupBoard.service.IGroupBoardService;

/**
 * @Class Name : GroupBoardController.java
 * @Description : 사용자/관리자 모두 열람가능한 게시판 리스트(공지사항/사내뉴스) 조회 및 상세조회
 * @Modification controller
 * @author 함박눈
 * @since  2016.08.29.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.08.29.  함박눈        최초생성
 *    2016.09.02   김준학       파일 업로드/다운로드
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */



@Controller
public class GroupBoardController implements ApplicationContextAware{
	
	@Autowired
	private IGroupBoardService service= null;
	private WebApplicationContext context = null;//파일 다운로드ㄴ
	
	/**
	 * 공지사항 조회
	 * 
	 * @param 
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value="/noticeList", method=RequestMethod.GET)
	public String noticeList(Model model,HttpSession session) {
		 String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		
		List<BoardVO> noticeList = service.getNoticeList();
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		
		model.addAttribute("memberVO",memberVO);
		model.addAttribute("noticeList",noticeList);
	
			url="groupBoard/notice/noticeList";
		}
		return url;
	}
	
	/**
	 * 사내뉴스 조회
	 * 
	 * @param 
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value="/workNewsList", method=RequestMethod.GET)
	public String workNewsList(Model model,HttpSession session) {
		 String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		List<BoardVO> workNewsList = service.getWorkNewsList();
		model.addAttribute("workNewsList",workNewsList);
		model.addAttribute("memberVO",memberVO);
	
			url="groupBoard/workNews/workNewsList";
		}
		return url;
	}
	
	
	/**
	 * 공지사항 상세조회
	 * 
	 * @param String
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value="/noticeInformation", method=RequestMethod.GET)
	public String noticeInformation(HttpSession session,Model model, @RequestParam(value="br_wrt_num", defaultValue="")String br_wrt_num) {
		 String url="redirect:/login";
		  if(session.getAttribute("loginUser")!=null){
		
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		BoardVO noticeInformation = service.getNoticeInformation(br_wrt_num);
		String Fname="";
		if(!(noticeInformation.getBr_file().equals("gy.jpg"))){
		Fname = noticeInformation.getBr_file().substring(10);
		}
		model.addAttribute("noticeInformation", noticeInformation);
		model.addAttribute("memberVO",memberVO);
		model.addAttribute("Fname",Fname);
		url = "groupBoard/notice/noticeInformation";
		  }
		return url;
	}
	/**
	 * 사내뉴스 상세조회
	 * 
	 * @param String
	 * @return String
	 * @throws 
	 */
	
	@RequestMapping(value="/workNewsInformation", method=RequestMethod.GET)
	public String workNewsInformation(Model model,HttpSession session, @RequestParam(value="br_wrt_num", defaultValue="")String br_wrt_num) {
		 String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		
		BoardVO workNewsInformation = service.getWorkNewsInformation(br_wrt_num);
		model.addAttribute("memberVO",memberVO);
		model.addAttribute("workNewsInformation", workNewsInformation);
		url = "groupBoard/workNews/workNewsInformation";
		  }
		return url;
	}
	
	/**
	 * 공지사항 검색
	 * 
	 * @param String
	 * @return String
	 * @throws 
	 */
	
	@RequestMapping(value="/noticeSearch", method=RequestMethod.GET)
	public String noticeSearch(Model model,HttpSession session, @RequestParam(value="key", defaultValue="")String key) {
		 String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
	
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		List<BoardVO> noticeSearch = service.getNoticeSearch(key);
		model.addAttribute("noticeList", noticeSearch);
		model.addAttribute("memberVO",memberVO);
		url = "groupBoard/notice/noticeList";
		  }
		return url;
	}
	/**
	 * 사내뉴스 검색
	 * 
	 * @param String
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value="/workNewsSearch", method=RequestMethod.GET)
	public String workNewsSearch(Model model,HttpSession session, @RequestParam(value="key", defaultValue="")String key) {
		 String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		List<BoardVO> workNewsSearch = service.getWorkNewsSearch(key);
		model.addAttribute("workNewsList", workNewsSearch);
		model.addAttribute("memberVO",memberVO);
		url = "groupBoard/workNews/workNewsList";
		  }
		return url;
	}
	
	
	/**
	 * 공지사항 , 사내뉴스 파일 다운로드
	 * 
	 * @param String
	 * @return 
	 * @throws 
	 */
	@RequestMapping("/groupBoardDownload")
	// 파일 다운로드
	public ModelAndView download(@RequestParam("file")String file,
			HttpServletResponse response, Model model) throws IOException {
		File downloadFile = getFile(file);
		if (downloadFile == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return new ModelAndView("download", "downloadFile", downloadFile);
	}
	
	
	/**
	 * 공지사항 , 사내뉴스 파일 다운로드
	 * 
	 * @param String
	 * @return File
	 * @throws 
	 */
	private File getFile(String fileId) {//파일 다운로드 관련메서드
		String baseDir = context.getServletContext().getRealPath("resources/groupBoard");
		return new File(baseDir, fileId);
	}
	/**
	 * 공지사항 , 사내뉴스 파일 다운로드
	 * 
	 * @param String
	 * @return 
	 * @throws 
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)//파일 다운로드  관련메서드
			throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
	}
	

}
