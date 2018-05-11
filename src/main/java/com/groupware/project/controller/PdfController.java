package com.groupware.project.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupware.dto.MemberVO;
import com.groupware.dto.ProjectVO;
import com.groupware.project.service.IProjectService;

/**
 * @Class Name : PdfController.java
 * @Description : 프로젝트 상세정보 PDF출력을 위한 클래스
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
public class PdfController {
	@Autowired
	IProjectService service;
	
	/**
	 * 프로젝트 상세정보 PDF 출력
	 * 
	 * @param (Model, String)
	 * @return String
	 * @throws try/catch
	 */
	@RequestMapping("/pdfPrint")
	public String pdfPrint(Model model, @RequestParam("pro_code")String pro_code){
		ProjectVO projectVO = new ProjectVO();
		List<MemberVO> members = null;
		try {
		projectVO =service.getCalendar(pro_code);
		members = service.getProjectMembers(pro_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("pdfProject",projectVO);
		model.addAttribute("members",members);
		return "BuildPdf";
	}
}