package com.groupware.memberManagement.controller.admin;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.groupware.dto.MemberVO;
import com.groupware.memberManagement.service.IMemberManagementService;

/**
 * @Class Name : AdminMemberManagementController.java
 * @Description : 사원관리 관리자단
 * @Modification Information
 * @author 김성수
 * @since 2016.08.29.
 * @version 1.0
 * @see <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.08.29.  김성수        최초생성
 *    2016.09.08.  김태균		세션관리 및 기타 수정
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
@Controller
public class AdminMemberManagementController {

	@Autowired
	private IMemberManagementService memberService;
	
	/*@Autowired
	BCryptPasswordEncoder passwordEncoder;*/

	/**
	 * 사원리스트
	 * @param : 
	 * @return : memberManagement/memberManagementList
	 * @throws 
	 */
	//리스트
	@RequestMapping(value="memberManagementList",method=RequestMethod.GET)
	public String memberList(Model model,HttpSession session) {
		String url = "redirect:/login";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(loginUser!=null){
			List<MemberVO> memberList = memberService.getMemberList();
			model.addAttribute("memberList", memberList);
			model.addAttribute("memberVO", loginUser);
			url = "memberManagement/memberManagementList";
		}
		return url;
	}

	/**
	 * 사원상세보기
	 * @param : String mem_num, Model model
	 * @return : memberManagement/memberManagementInformation
	 * @throws 
	 */
	//상세보기
	@RequestMapping(value="/memberManagementInformation")
	public String memberDetail(@RequestParam("mem_num")String mem_num, HttpSession session, Model model){
		
		String url = "redirect:/login";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(loginUser!=null){
			model.addAttribute("memberVO",loginUser);
			MemberVO member = memberService.getMemberDetail(mem_num);
			model.addAttribute("member", member);
			url = "memberManagement/memberManagementInformation";
		}
		return url;
	}

	/**
	 * 사원정보수정폼
	 * @param : String mem_num
	 * @return : memberManagement/memberManagementUpdateForm
	 * @throws 
	 */
	//수정폼
	@RequestMapping("/memberManagementUpdateForm")
	public String memberManagementUpdateForm(@RequestParam("mem_num")String mem_num,Model model, HttpSession session) {
		String url = "redirect:/login";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(loginUser !=null){
			model.addAttribute("memberVO",loginUser);
			MemberVO member = memberService.getMemberDetail(mem_num);
			model.addAttribute("member", member);
			url = "memberManagement/memberManagementUpdateForm";
		}
		return url;
	}
	
	/**
	 * 수정하기
	 * @param : MemberVO memberVO, MultipartFile multipartFile
	 * @return : redirect:/memberManagementList
	 * @throws : IOException
	 */
	//수정
	@RequestMapping(value="/memberManagementUpdate",method=RequestMethod.POST)
	public String memberUpdate(MemberVO member, Model model, HttpServletResponse response, @RequestParam("file")MultipartFile multipartFile
			, @RequestParam("file1")MultipartFile multipartFile1, HttpServletRequest request
			, HttpSession session) throws IOException{
		String url = "redirect:/login";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(loginUser !=null){
			
			//final String imagePath = new File(session.getServletContext().getRealPath("/../../../../../../GD/src/main/webapp/resources/memberManagementImage")).getCanonicalPath();
			//final String signPath = new File(session.getServletContext().getRealPath("/../../../../../../GD/src/main/webapp/resources/memberSign")).getCanonicalPath();
			String imagePath = request.getSession().getServletContext().getRealPath("resources/memberManagementImage");  
			String signPath = request.getSession().getServletContext().getRealPath("resources/memberSign"); 			
			url = "redirect:/memberManagementList";
			
			MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
			model.addAttribute("memberVO",memberVO);
			
			File file;
			File file1;
			
			if(!multipartFile.isEmpty()&&!multipartFile1.isEmpty()){
				file = new File(imagePath, "$$"+System.currentTimeMillis() + multipartFile.getOriginalFilename());
				file1 = new File(signPath, "$$"+System.currentTimeMillis() + multipartFile1.getOriginalFilename());
				multipartFile.transferTo(file); //실제 저장이 이루어짐
				multipartFile1.transferTo(file1); //실제 저장이 이루어짐
				member.setMem_img(file.getName());
				member.setMem_stamp(file1.getName());
				memberService.memberUpdate(member);
			}else if(!multipartFile.isEmpty() && !multipartFile.equals(member.getMem_img())){
				file = new File(imagePath, "$$"+System.currentTimeMillis() + multipartFile.getOriginalFilename());
				multipartFile.transferTo(file); //실제 저장이 이루어짐
				member.setMem_img(file.getName());
				memberService.memberUpdate1(member);
			}else if(!multipartFile1.isEmpty() &&!multipartFile1.equals(member.getMem_stamp())){
				file1 = new File(signPath, "$$"+System.currentTimeMillis() + multipartFile1.getOriginalFilename());
				multipartFile1.transferTo(file1); //실제 저장이 이루어짐
				member.setMem_stamp(file1.getName());
				member.setMem_img(member.getMem_img());
				memberService.memberUpdate2(member);
			}else{
				memberService.memberUpdate3(member);
			}
		}
		return url;
	}
	
	/**
	 * 사원등록폼
	 * @param : 
	 * @return : memberManagement/memberManagementWriteForm
	 * @throws 
	 */
	//작성폼
	@RequestMapping("/memberManagementWriteForm")
	public String memberManagementWrite(Model model, HttpSession session) {
		String url = "redirect:/login";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(loginUser!=null){
			model.addAttribute("memberVO",loginUser);
			url = "memberManagement/memberManagementWriteForm";
		}
		return url;
	}
	
	/**
	 * 사원등록
	 * @param : MemberVO memberVO, String mem_em1, String mem_em, MultipartFile multipartFile
	 * @return : redirect:/memberManagementList
	 * @throws 
	 */
	//작성업로드
	@RequestMapping(value="/memberWrite",method=RequestMethod.POST)
	public String memberWrite(@ModelAttribute("member")MemberVO member, Model model, 
							  @RequestParam(value="mem_em1")String mem_em1
							, @RequestParam(value="mem_em")String mem_em
							, HttpServletRequest request, HttpServletResponse response
							, @RequestParam("file")MultipartFile multipartFile
							, @RequestParam("file1")MultipartFile multipartFile1
							, HttpSession session) throws IOException {
		
		
		//final String imagePath = new File(session.getServletContext().getRealPath("/../../../../../../GD/src/main/webapp/resources/memberManagementImage")).getCanonicalPath();
		//final String signPath = new File(session.getServletContext().getRealPath("/../../../../../../GD/src/main/webapp/resources/memberSign")).getCanonicalPath();
		String imagePath = request.getSession().getServletContext().getRealPath("resources/memberManagementImage");   	
		String signPath = request.getSession().getServletContext().getRealPath("resources/memberSign"); 				
		
		
		String url = "redirect:/login";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		if(loginUser !=null){
			url = "redirect:/memberManagementList";
			model.addAttribute("memberVO",loginUser);
			if(!multipartFile.isEmpty()&&!multipartFile1.isEmpty()){
				File file = new File(imagePath, "$$"+System.currentTimeMillis() + multipartFile.getOriginalFilename());
				File file1 = new File(signPath, "$$"+System.currentTimeMillis() + multipartFile1.getOriginalFilename());
				
				multipartFile.transferTo(file); //실제 저장이 이루어짐
				multipartFile1.transferTo(file1); //실제 저장이 이루어짐
				member.setMem_img(file.getName());
				member.setMem_stamp(file1.getName());
				System.out.println(file.getName());
				System.out.println(file1.getName());
			}
				member.setMem_em(mem_em + "@" + mem_em1);
				memberService.memberInsert(member);
		}
		return url;
	}
	
	/**
	 * 사원리스트
	 * @param : l
	 * @return : memberListExcel
	 * @throws 
	 */
	//excel 출력
	@RequestMapping(value="/memberListExcel")
	public String memberListExcel(Model model, HttpSession session){
		
		String url = "redirect:/login";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(loginUser !=null){
			model.addAttribute("memberVO", loginUser);
			List<MemberVO> memberList = memberService.getMemberList();
			model.addAttribute("memberList",memberList);
			url = "memberListExcel";
		}
		return url;
	}
	
	
	/**
	 * 조건검색리스트
	 * @param : l
	 * @return : searchListExcel
	 * @throws 
	 */
	//excel 출력
	@RequestMapping(value="/searchListExcel")
	public String searchListExcel(@RequestParam(value="searchKeyword")String searchKeyword, 
			   @RequestParam(value="searchKey")String searchKey, Model model
			   , HttpSession session){
		
		String url = "redirect:/login";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(loginUser!=null){
			model.addAttribute("memberVO",loginUser);
			if(searchKey.equals("사원명")){
				List<MemberVO> searchList = memberService.getSearchList(searchKeyword);
				model.addAttribute("memberList",searchList);
				model.addAttribute("searchKey",searchKey);
				model.addAttribute("searchKeyword",searchKeyword);
				url="searchListExcel";
			}else if(searchKey.equals("부서명")){
				List<MemberVO> searchList = memberService.getSearchList1(searchKeyword);
				model.addAttribute("memberList",searchList);
				model.addAttribute("searchKey",searchKey);
				model.addAttribute("searchKeyword",searchKeyword);
				url="searchListExcel";
			}else if(searchKey.equals("직책명")){
				List<MemberVO> searchList = memberService.getSearchList2(searchKeyword);
				model.addAttribute("memberList",searchList);
				model.addAttribute("searchKey",searchKey);
				model.addAttribute("searchKeyword",searchKeyword);
				url="searchListExcel";
			}else if(searchKey.equals("퇴사자")){
				List<MemberVO> searchList = memberService.getSearchList3(searchKeyword);
				model.addAttribute("memberList",searchList);
				model.addAttribute("searchKey",searchKey);
				model.addAttribute("searchKeyword",searchKeyword);
				url="searchListExcel";
			}
		}
		return url;
	}
	
	
	/**
	 * 사원정보 PDF
	 * @param : l
	 * @return : memberInfoPdf
	 * @throws 
	 */
	//PDF 출력
	@RequestMapping(value="/memberInfoPdf")
	public String memberInfoPdf(@RequestParam("mem_num")String mem_num
							  , Model model, HttpSession session){
		String url = "redirect:/login";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(loginUser!=null){
			model.addAttribute("memberVO", loginUser);
			MemberVO member = memberService.getMemberDetail(mem_num);
			if(member.getMem_rt() == null){
				member.setMem_rt("-");
			}
			model.addAttribute("member", member);
			url = "memberInfoPdf";
		}
		return url;
	}
	
	
	@RequestMapping(value="check",method=RequestMethod.GET)
	@ResponseBody
	public String check(@RequestParam("mem_num")String mem_num, Model model
								, HttpSession session){
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		String check = memberService.check(mem_num);
		
		return check;
	}

	
	
	
	/**
	 * 사원조건 검색
	 * @param : String searchKeyword, String searchKey
	 * @return : memberManagement/memberManagementList
	 * @throws 
	 */
	//검색
	@RequestMapping(value="/memberSearch",method=RequestMethod.GET)
	public String memberSearch(@RequestParam(value="searchKeyword")String searchKeyword, 
							   @RequestParam(value="searchKey")String searchKey, Model model
							   , HttpSession session){

		String url = "redirect:/login";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(loginUser!=null){
			model.addAttribute("memberVO",loginUser);
			if(searchKey.equals("사원명")){
				List<MemberVO> searchList = memberService.getSearchList(searchKeyword);
				model.addAttribute("memberList",searchList);
				model.addAttribute("searchKey",searchKey);
				model.addAttribute("searchKeyword",searchKeyword);
				url="memberManagement/memberManagementList";
			}else if(searchKey.equals("부서명")){
				List<MemberVO> searchList = memberService.getSearchList1(searchKeyword);
				model.addAttribute("memberList",searchList);
				model.addAttribute("searchKey",searchKey);
				model.addAttribute("searchKeyword",searchKeyword);
				url="memberManagement/memberManagementList";
			}else if(searchKey.equals("직책명")){
				List<MemberVO> searchList = memberService.getSearchList2(searchKeyword);
				model.addAttribute("memberList",searchList);
				model.addAttribute("searchKey",searchKey);
				model.addAttribute("searchKeyword",searchKeyword);
				url="memberManagement/memberManagementList";
			}else if(searchKey.equals("퇴사자")){
				List<MemberVO> searchList = memberService.getSearchList3(searchKeyword);
				model.addAttribute("memberList",searchList);
				model.addAttribute("searchKey",searchKey);
				model.addAttribute("searchKeyword",searchKeyword);
				url="memberManagement/memberManagementList";
			}
		}
		return url;
	}
	
	

}





















