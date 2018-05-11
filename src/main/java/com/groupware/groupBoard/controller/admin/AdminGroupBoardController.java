package com.groupware.groupBoard.controller.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.groupware.dto.BoardVO;
import com.groupware.dto.GroupFileVO;
import com.groupware.dto.MemberVO;
import com.groupware.groupBoard.service.IGroupBoardService;

/**
 * @Class Name : AdminGroupBoardController.java
 * @Description : 관리자만 접근 가능한 게시판 등록/수정/삭제 기능
 * @Modification controller
 * @author 함박눈
 * @since 2016.08.29.
 * @version 1.0
 * @see <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.08.29.  함박눈        최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
@Controller
public class AdminGroupBoardController {
	@Autowired
	private IGroupBoardService service = null;

	/**
	 * 공지등록 폼 호출
	 * @param 
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "/noticeWrite", method = RequestMethod.GET)
	public String noticeWrite(HttpSession session) {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		url = "groupBoard/notice/noticeWrite";
		  }
		return url;
	}

	/**
	 * 공지등록
	 * @param  BoardVO, MultipartFile
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "/noticeWrite", method = RequestMethod.POST)
	public String noticeWrite(BoardVO boardVO,
			@RequestParam("file") MultipartFile multipartFile,
			HttpServletRequest request, HttpSession session, Model model) throws IOException {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO",memberVO);
		
		String uploadPath = "D:/GDProject/spring_sts/workspace/GD/src/main/webapp/resources/groupBoard";
/*		String uploadPath = request.getSession().getServletContext()
				.getRealPath("resources/memberManagementImage");
*/		if (!multipartFile.isEmpty()) {
			File file = new File(uploadPath, ((System.currentTimeMillis()+32400000)/1000)
					+ multipartFile.getOriginalFilename());

			multipartFile.transferTo(file); // 실제 저장이 이루어짐
			boardVO.setBr_file(file.getName());
		} else {
			boardVO.setBr_file("gy.jpg");
		}
		boardVO.setBr_mem_num(memberVO.getMem_num());
		String tt = boardVO.getBr_tt();
		tt = tt.replace("<", "＜");
		tt = tt.replace(">", "＞");
		boardVO.setBr_tt(tt);
		
		String brcont = boardVO.getBr_cont();
		brcont = brcont.replace("<p>", "");
		brcont = brcont.replace("</p>", "");
		brcont = brcont.replace("<", "＜");
		brcont = brcont.replace(">", "＞");
		boardVO.setBr_cont(brcont);
		service.getNoticeWriteCom(boardVO);
		url = "redirect:/noticeList";
		  }
		return url;
	}

	/**
	 * 사내뉴스 등록 폼 조회
	 * @param  
	 * @return String
	 * @throws 
	 */
	@RequestMapping("/workNewsWrite")
	public String workNewsWrite(HttpSession session) {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		url = "groupBoard/workNews/workNewsWrite";
		  }
		return url;
	}

	/**
	 * 사내뉴스 등록
	 * @param  BoardVO, MultipartFile
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "/workNewsWrite", method = RequestMethod.POST)
	public String workNewsWrite(BoardVO boardVO,
			
			HttpServletRequest request, HttpSession session, Model model) throws IOException {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		model.addAttribute("memberVO",memberVO);
		
		
		
		
		boardVO.setBr_mem_num(memberVO.getMem_num());
		String tt = boardVO.getBr_tt();
		tt = tt.replace("<", "＜");
		tt = tt.replace(">", "＞");
		boardVO.setBr_tt(tt);
		
		String brcont = boardVO.getBr_cont();
		brcont = brcont.replace("<p>", "");
		brcont = brcont.replace("</p>", "");
		brcont = brcont.replace("<", "＜");
		brcont = brcont.replace(">", "＞");
		boardVO.setBr_cont(brcont);
		service.getWorkNewsWriteCom(boardVO);
		url = "redirect:/workNewsList";
		  }

		return url;
	}

	/**
	 * 공지사항 수정 폼 호출
	 * @param  String
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "/noticeUpdate", method = RequestMethod.GET)
	public String noticeUpdate(
			Model model,HttpSession session,
			@RequestParam(value = "br_wrt_num", defaultValue = "") String br_wrt_num) {
		String url="redirect:/login";
		   String Fname="";
		  if(session.getAttribute("loginUser")!=null){
		BoardVO noticeInformation = service.getNoticeInformation(br_wrt_num);
		if(!(noticeInformation.getBr_file().equals("gy.jpg"))){
			Fname = noticeInformation.getBr_file().substring(10);
			}
		model.addAttribute("noticeInformation", noticeInformation);
		model.addAttribute("Fname",Fname);
		url = "groupBoard/notice/noticeUpdate";}
		return url;
	}

	/**
	 * 공지사항 수정 
	 * @param  BoardVO, MultipartFile
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "/noticeUpdateCom", method = RequestMethod.POST)
	public String noticeUpdate(Model model, BoardVO boardVO, @RequestParam("br_file")String br_file,
			@RequestParam("file") MultipartFile multipartFile, HttpSession session,
			HttpServletRequest request) throws IOException {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		/*String uploadPath = request.getSession().getServletContext()
				.getRealPath("resources/memberManagementImage");*/
			  String uploadPath = "D:/GDProject/spring_sts/workspace/GD/src/main/webapp/resources/groupBoard";
		File file=null;
		if(br_file!=null){
			file = new File(uploadPath, br_file);
		}
		if (br_file.equals("gy.jpg")&&!multipartFile.isEmpty()) {
			file = new File(uploadPath, ((System.currentTimeMillis()+32400000)/1000)
					+ multipartFile.getOriginalFilename());
		} else if(br_file.equals("removeFile")&&multipartFile.isEmpty()) {
			boardVO.setBr_file("gy.jpg");
		}else if(br_file.equals("removeFile")&&!multipartFile.isEmpty()){
			file = new File(uploadPath, ((System.currentTimeMillis()+32400000)/1000)
					+ multipartFile.getOriginalFilename());
			
		}else if(multipartFile.isEmpty()){
			boardVO.setBr_file("gy.jpg");
		}
		multipartFile.transferTo(file);//실제 저장이 이루어짐
		boardVO.setBr_file(file.getName());
		String tt = boardVO.getBr_tt();
		tt = tt.replace("<", "＜");
		tt = tt.replace(">", "＞");
		boardVO.setBr_tt(tt);
		
		String brcont = boardVO.getBr_cont();
		brcont = brcont.replace("<p>", "");
		brcont = brcont.replace("</p>", "");
		brcont = brcont.replace("<", "＜");
		brcont = brcont.replace(">", "＞");
		boardVO.setBr_cont(brcont);
		
		service.getNoticeUpdate(boardVO);
		
		url = "redirect:/noticeList";
		  }
		
		return url;
	}

	/**
	 * 사내소식 수정 폼 호출 
	 * @param String
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "/workNewsUpdate", method = RequestMethod.GET)
	public String workNewsUpdate(HttpSession session,
			Model model,
			@RequestParam(value = "br_wrt_num", defaultValue = "") String br_wrt_num) {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		BoardVO workNewsInformation = service
				.getWorkNewsInformation(br_wrt_num);
		model.addAttribute("workNewsInformation", workNewsInformation);
		url = "groupBoard/workNews/workNewsUpdate";}
		return url;
	}

	/**
	 * 사내소식 수정 
	 * @param BoardVO, MultipartFile
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "/workNewsUpdateCom", method = RequestMethod.POST)
	public String workNewsUpdate(Model model, BoardVO boardVO,HttpSession session,
			HttpServletRequest request) throws IOException {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		String tt = boardVO.getBr_tt();
		tt = tt.replace("<", "＜");
		tt = tt.replace(">", "＞");
		boardVO.setBr_tt(tt);
		
		String brcont = boardVO.getBr_cont();
		brcont = brcont.replace("<p>", "");
		brcont = brcont.replace("</p>", "");
		brcont = brcont.replace("<", "＜");
		brcont = brcont.replace(">", "＞");
		boardVO.setBr_cont(brcont);
		service.getWorkNewsUpdate(boardVO);
		// BoardVO noticeInformation = service.getNoticeInformation(br_file);
		url = "redirect:/workNewsList";
		  }
		return url;
	}

	/**
	 * 공지사항 삭제
	 * @param BoardVO
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "/noticeDelete", method = RequestMethod.GET)
	public String noticeDeleteBoard(BoardVO boardVO, Model model,
			HttpSession session) {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");

		model.addAttribute("memberVO", memberVO);
		int deleteBoard = service.getNoticeDeleteBoard(boardVO);
		  
		url = "redirect:/noticeList";
		  }
		return url;
	}

	/**
	 * 사내소식 삭제
	 * @param BoardVO
	 * @return String
	 * @throws 
	 */
	@RequestMapping(value = "/workNewsDelete", method = RequestMethod.GET)
	public String workNewsDeleteBoard(BoardVO boardVO,HttpSession session,Model model) {
		String url="redirect:/login";
		   
		  if(session.getAttribute("loginUser")!=null){
		int deleteBoard = service.getWorkNewsDeleteBoard(boardVO);
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");

		model.addAttribute("memberVO", memberVO);
		url = "redirect:/workNewsList";
		  }
		return url;
	}

}
