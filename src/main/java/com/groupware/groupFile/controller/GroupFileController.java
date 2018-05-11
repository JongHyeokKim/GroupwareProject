package com.groupware.groupFile.controller;

/**
 * @Class Name : GroupFileController.java
 * @Description : 파일 관리  수정/등록/삭제
 * @Modification CONTROLLER
 * @author 김준학
 * @since  2016.08.31.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.08.31.  김준학        최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.groupware.dto.GroupFileVO;
import com.groupware.dto.MemberVO;
import com.groupware.groupFile.service.IGroupFileService;

@Controller
public class GroupFileController implements ApplicationContextAware {
	@Autowired
	private IGroupFileService service = null;
	private WebApplicationContext context = null;

	@RequestMapping("/groupFileList")
	public String groupFileList(Model model, HttpSession session) { // 파일리스트

		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		String url = "redirect:/login";
		if (memberVO != null) {

			model.addAttribute("memberVO", memberVO);

			List<GroupFileVO> groupFileList = service.getGroupFileList();
			for(int i=0; i<groupFileList.size(); i++){
				groupFileList.get(i).setDoc_file(groupFileList.get(i).getDoc_file().substring(10));
			}
			model.addAttribute("groupFileList", groupFileList);
			url = "groupFile/groupFileList";
		}
		return url;
	}

	@RequestMapping("/groupFileDownload")
	// 파일 다운로드
	public ModelAndView download(@RequestParam("doc_code") String doc_code,
			HttpServletResponse response, Model model) throws IOException {
		String fileName = service.getFileName(doc_code);
		File downloadFile = getFile(fileName);
		if (downloadFile == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return new ModelAndView("download", "downloadFile", downloadFile);
	}

	private File getFile(String fileId) {// 파일 다운로드 관련메서드
		String baseDir = context.getServletContext().getRealPath(
				"resources/groupFile");
		return new File(baseDir, fileId);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)// 파일
																			// 다운로드
																			// 관련메서드
			throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
	}

	//
	@RequestMapping(value = "/fileSearch", method = RequestMethod.GET)
	public String customerSearch(
			// 리스트 찾기
			@RequestParam(value = "searchKeyword") String searchKeyword,
			@RequestParam(value = "searchKey2") String searchKey2, Model model,
			HttpSession session) {

		String url = "redirect:/login";
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		if (memberVO != null) {

			model.addAttribute("memberVO", memberVO);

			if (searchKey2.equals("제목")) {
				List<GroupFileVO> searchList = service
						.getSearchList(searchKeyword);
				model.addAttribute("groupFileList", searchList);
				url = "groupFile/groupFileList";
			} else if (searchKey2.equals("작성자")) {
				List<GroupFileVO> searchList = service
						.getSearchList1(searchKeyword);
				model.addAttribute("groupFileList", searchList);
				url = "groupFile/groupFileList";
			}
		}
		return url;
	}

	@RequestMapping("/groupFileWrite")
	public String groupFileWrite(HttpSession session) { // 글쓰기 폼
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		String url = "redirect:/login";
		if (memberVO != null) {

			url = "/groupFile/groupFileWrite";
		}
		return url;
	}

	@RequestMapping(value = "/groupFileWrite", method = RequestMethod.POST)
	public String groupFileWrite(GroupFileVO groupFileVO, HttpSession session,
			@RequestParam("file") MultipartFile multipartFile,
			HttpServletRequest request) throws IOException { // 글쓰기

		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		String url = "redirect:/login";
		if (memberVO != null) {

			String doc_cont = groupFileVO.getDoc_cont();

			doc_cont = doc_cont.replace("<p>", "");
			doc_cont = doc_cont.replace("</p>", "");
			groupFileVO.setDoc_cont(doc_cont);

			url = "redirect:/groupFileList";

			String uploadPath = request.getSession().getServletContext().getRealPath("resources/groupFile");  
			//final String uploadPath = new File(session.getServletContext().getRealPath("/../../../../../../GD/src/main/webapp/resources/groupFile")).getCanonicalPath();
/*			String uploadPath = request.getSession().getServletContext()
					.getRealPath("resources/memberManagementImage");*/
			if (!multipartFile.isEmpty()) {
				File file = new File(uploadPath, ((System.currentTimeMillis()+32400000)/1000) +
						multipartFile.getOriginalFilename());

				multipartFile.transferTo(file); // 실제 저장이 이루어짐
				groupFileVO.setDoc_mem_num(memberVO.getMem_num());
				groupFileVO.setDoc_file(file.getName());
			}
			service.getGroupFileWrite(groupFileVO);
		}
		return url;
	}

	@RequestMapping("/groupFileInformation")
	public String groupFileInformation(Model model,
			@RequestParam(value = "doc_code") String doc_code,
			HttpSession session) {// 상세 정보 보기

		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		String url = "redirect:/login";
		if (memberVO != null) {
			url = "/groupFile/groupFileInformation";
			model.addAttribute("memberVO", memberVO);
			GroupFileVO groupFileInfo = service.getGroupFileInfo(doc_code);
			groupFileInfo.setDoc_file(groupFileInfo.getDoc_file().substring(10));
			model.addAttribute("groupFileInfo", groupFileInfo);
		}
		return url;
	}

	//
	@RequestMapping("/groupFileUpdate")
	// 수정 폼
	public String groupFileUpdate(Model model,
			@RequestParam("doc_code") String doc_code, HttpSession session) {
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		String url = "redirect:/login";
		if (memberVO != null) {

			url = "/groupFile/groupFileUpdate";
			GroupFileVO groupFileVO = service.getGroupFileInfo(doc_code);
			groupFileVO.setDoc_file(groupFileVO.getDoc_file().substring(10));
			model.addAttribute("groupFileUpdate", groupFileVO);
		}
		return url;
	}

	
	@RequestMapping(value = "/groupFileUpdateCom", method = RequestMethod.POST)
	// 업데이트
	public String groupFileUpdateCom(Model model, GroupFileVO groupFileVO,
			HttpSession session,
			@RequestParam("file") MultipartFile multipartFile,
			HttpServletRequest request) throws IOException {

		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		String url = "redirect:/login";
		if (memberVO != null) {
			url = "redirect:/groupFileList";
			String doc_cont = groupFileVO.getDoc_cont();

			doc_cont = doc_cont.replace("<p>", "");
			doc_cont = doc_cont.replace("</p>", "");
			groupFileVO.setDoc_cont(doc_cont);
			String uploadPath = request.getSession().getServletContext().getRealPath("resources/groupFile"); 

			File file;
			if (!multipartFile.isEmpty()) {
				file = new File(uploadPath, ((System.currentTimeMillis()+32400000)/1000)
						+ multipartFile.getOriginalFilename());
				multipartFile.transferTo(file); // 실제 저장이 이루어짐
				groupFileVO.setDoc_file(file.getName());
				service.getGroupFileUpdate(groupFileVO);
			} else {
				service.getGroupFileUpdateWithoutFile(groupFileVO);
			}
		}
		return url;
	}

	//
	@RequestMapping("/gropuFileDelete")
	// 삭제
	public String groupFileDelete(GroupFileVO groupFileVO, HttpSession session,
			Model model) {
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		String url = "redirect:/login";
		if (memberVO != null) {

			model.addAttribute("memberVO", memberVO);

			service.getgroupFileDelete(groupFileVO);
			url = "redirect:/groupFileList";
		}
		return url;
	}

}
