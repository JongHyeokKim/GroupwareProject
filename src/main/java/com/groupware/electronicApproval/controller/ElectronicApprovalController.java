package com.groupware.electronicApproval.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupware.dto.MemberVO;
import com.groupware.dto.Sign_DocumentVO;
import com.groupware.dto.StampVO;
import com.groupware.electronicApproval.service.IElectronicApprovalService;
/**
 * @Class Name : ElectronicApprovalController.java
 * @Description : 기안서의 등록 및 리스트, 조건별 검색
 * @Modification Information
 * @author 박진우
 * @since  2016.08.31.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.08.31.  박진우        최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
@Controller
public class ElectronicApprovalController {
	@Autowired
	private IElectronicApprovalService electronicApprovalService;
	
	// 기안서 작성----------------------------------------------------------------------
	@RequestMapping("/draftDocumentWriteForm")
	public String draftDocumentWriteForm(Model model, HttpSession session, MemberVO member) throws IOException {
		String url = "redirect:/login";
		member = (MemberVO) session.getAttribute("loginUser");
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(member!=null){
			SimpleDateFormat onDay = new SimpleDateFormat("yyyy-MM-dd");
			String today = onDay.format(new Date());
						
			model.addAttribute("mem_num",member.getMem_num());
			model.addAttribute("mem_nm",member.getMem_nm());
			model.addAttribute("today",today);
			model.addAttribute("memberVO",loginUser);
			url = "electronicApproval/draftdocument/draftDocumentWrite";
		}
		return url;
	}

	@RequestMapping("/transDocumentWriteForm")
	public String transDocumentWriteForm(Model model, HttpSession session, Sign_DocumentVO signDocumentVO) {
		String url = "redirect:/login";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		if(loginUser!=null){
			signDocumentVO.setSig_doc_sig_st_num(1);
			int lineNum = electronicApprovalService.signLineNumEnroll();
			signDocumentVO.setSig_doc_sig_lin_num(lineNum);
			String sig_doc_cont = signDocumentVO.getSig_doc_cont();
			String sig_doc_tt = signDocumentVO.getSig_doc_tt();
			sig_doc_cont = sig_doc_cont.replace("<p>", "");
			sig_doc_cont = sig_doc_cont.replace("</p>", "");
			sig_doc_tt = sig_doc_tt.replace("<", "＜");
			sig_doc_tt = sig_doc_tt.replace(">", "＞");
		    
		    
		    signDocumentVO.setSig_doc_cont(sig_doc_cont);
		    signDocumentVO.setSig_doc_tt(sig_doc_tt);
			electronicApprovalService.writeElectDocument(signDocumentVO);
			model.addAttribute("memberVO",loginUser);
			url = "redirect:/documentMain";
		}
		return url;
	}
	
	@RequestMapping("/transDocumentWriteRepeat")
	public String transDocumentWriteRepeat(Model model, HttpSession session, @RequestParam(value = "transDocNum") String transDocNum) {
		String url = "redirect:/login";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(loginUser!=null){
			int docNum = Integer.parseInt(transDocNum);
			Sign_DocumentVO getDocumentDetail = electronicApprovalService.getDocumentDetail(docNum);
			
			model.addAttribute("getDocumentDetail", getDocumentDetail);
			model.addAttribute("memberVO",loginUser);
			url = "electronicApproval/draftdocument/transDocumentWrite";
		}
		return url;
	}
	@RequestMapping("/transDocumentWriteRepeatUpdate")
	public String transDocumentWriteRepeatUpdate(Model 	model, HttpSession session,	Sign_DocumentVO signDocument) {
		String url = "redirect:/login";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		if(loginUser!=null){
			String sig_doc_cont = signDocument.getSig_doc_cont();
			String sig_doc_tt = signDocument.getSig_doc_tt();
			sig_doc_cont = sig_doc_cont.replace("<p>", "");
			sig_doc_cont = sig_doc_cont.replace("</p>", "");
			sig_doc_tt = sig_doc_tt.replace("<", "＜");
			sig_doc_tt = sig_doc_tt.replace(">", "＞");
		    
		    
		    signDocument.setSig_doc_cont(sig_doc_cont);
		    signDocument.setSig_doc_tt(sig_doc_tt);
			electronicApprovalService.transDocumentUpdate(signDocument);
			model.addAttribute("memberVO",loginUser);
			url = "redirect:/transientStorageList";
		}
		return url;
	}
	@RequestMapping("/transDocumentWriteRepeatChange")
	public String transDocumentWriteRepeatChange(Model 	model, HttpSession session,
			Sign_DocumentVO signDocumentVO,
			 @RequestParam(value="signMem")ArrayList<String> signMem,
			 @RequestParam(value="signMemPos")ArrayList<String> signMemPos) {
		String url = "redirect:/login";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if(loginUser!=null){
			electronicApprovalService.transDocumentUpdateChange(signDocumentVO);
			int lineNum = signDocumentVO.getSig_doc_sig_lin_num();
			Map<String,Object> lineEnroll = new HashMap<String, Object>();
			String sig_doc_cont = signDocumentVO.getSig_doc_cont();
			String sig_doc_tt = signDocumentVO.getSig_doc_tt();
			sig_doc_cont = sig_doc_cont.replace("<p>", "");
			sig_doc_cont = sig_doc_cont.replace("</p>", "");
			sig_doc_tt = sig_doc_tt.replace("<", "＜");
			sig_doc_tt = sig_doc_tt.replace(">", "＞");
		    
		    
		    signDocumentVO.setSig_doc_cont(sig_doc_cont);
		    signDocumentVO.setSig_doc_tt(sig_doc_tt);
		    signDocumentVO.setSig_doc_sig_st_num(5);
		    
			lineEnroll.put("lineNum", lineNum);
			for(int i=0; i<signMem.size(); i++){
				lineEnroll.put("signMem",signMem.get(i));
				lineEnroll.put("signMemPr",(i+1));
				lineEnroll.put("signMemPos", signMemPos.get(i));
				if(i==0){
					lineEnroll.put("signDtSt", 1);
				}else{
					lineEnroll.put("signDtSt", 0);
				}
				electronicApprovalService.signLineEnroll(lineEnroll);
			}
			signDocumentVO.setSig_doc_sig_lin_num(lineNum);
			model.addAttribute("memberVO",loginUser);
			url = "redirect:/documentMain";
		}
		return url;
	}
	
	

	@RequestMapping("/draftDocumentWrite")
	public String draftDocumentWrite(Model model, Sign_DocumentVO signDocumentVO, HttpSession session,
									 @RequestParam(value="signMem")ArrayList<String> signMem,
									 @RequestParam(value="signMemPos")ArrayList<String> signMemPos) {
		
		String url = "redirect:/login";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		if(loginUser!=null){
			int lineNum = electronicApprovalService.signLineNumEnroll();
			Map<String,Object> lineEnroll = new HashMap<String, Object>();
			
			String sig_doc_cont = signDocumentVO.getSig_doc_cont();
			String sig_doc_tt = signDocumentVO.getSig_doc_tt();
			sig_doc_cont = sig_doc_cont.replace("<p>", "");
			sig_doc_cont = sig_doc_cont.replace("</p>", "");
			sig_doc_tt = sig_doc_tt.replace("<", "＜");
			sig_doc_tt = sig_doc_tt.replace(">", "＞");
		    
		    
		    signDocumentVO.setSig_doc_cont(sig_doc_cont);
		    signDocumentVO.setSig_doc_tt(sig_doc_tt);
		    
			lineEnroll.put("lineNum", lineNum);
			for(int i=0; i<signMem.size(); i++){
				lineEnroll.put("signMem",signMem.get(i));
				lineEnroll.put("signMemPr",(i+1));
				lineEnroll.put("signMemPos", signMemPos.get(i));
				if(i==0){
					lineEnroll.put("signDtSt", 1);
				}else{
					lineEnroll.put("signDtSt", 0);
				}
				electronicApprovalService.signLineEnroll(lineEnroll);
			}
			
			signDocumentVO.setSig_doc_sig_lin_num(lineNum);
			electronicApprovalService.writeElectDocument(signDocumentVO);
			model.addAttribute("memberVO",loginUser);
			url = "redirect:/documentMain";
			
		}
		return url;
	}
	// 문서함 메인------------------------------------------------------------------------
	@RequestMapping("/documentMain")
	public String documentMain(Model model, HttpSession session) {
		String url = "redirect:/login";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		//---------------------------------------------------
		Map<String, Object> info = new HashMap<String, Object>();

		
		if(loginUser!=null){
			info.put("stateNum", 1);
			info.put("mem_num", loginUser.getMem_num());
			List<Sign_DocumentVO> getDocumentList = electronicApprovalService
					.getDocumentList(info);
			if(getDocumentList.size()!=0){
				model.addAttribute("getDocumentList1", getDocumentList);
			}
		
			info.put("stateNum", 2);
			info.put("mem_num", loginUser.getMem_num());
			getDocumentList = electronicApprovalService
					.getDocumentList(info);
			if(getDocumentList.size()!=0){
				model.addAttribute("getDocumentList2", getDocumentList);
			}
			info.put("stateNum", 1);
			info.put("mem_num", loginUser.getMem_num());
			List<Sign_DocumentVO> getDocumentListWait = electronicApprovalService
					.getDocumentWaitDtSt(info);
			if(getDocumentListWait.size()!=0){
				model.addAttribute("getDocumentListWait", getDocumentListWait);
			}
		
			info.put("stateNum", 3);
			info.put("mem_num", loginUser.getMem_num());
			getDocumentList = electronicApprovalService.getDocumentList(info);
			if(getDocumentList.size()!=0){
				model.addAttribute("getDocumentList3", getDocumentList);
			}
		
			info.put("stateNum", 4);
			info.put("mem_num", loginUser.getMem_num());
			getDocumentList = electronicApprovalService
					.getDocumentList(info);
			if(getDocumentList.size()!=0){
				model.addAttribute("getDocumentList4", getDocumentList);
			}
		
			info.put("mem_num", loginUser.getMem_num());
			info.put("approvalState", 1);
			
			List<Sign_DocumentVO> getApprovalDocList = electronicApprovalService.getApprovalDocList(info);
			if(getApprovalDocList.size()!=0){
				model.addAttribute("getApprovalDocList",getApprovalDocList);
			}
			model.addAttribute("checking",1);
			model.addAttribute("memberVO",loginUser);
			url = "electronicApproval/documentBox/documentMain";
			
		}
		
		return url;
	}
	
	// 임시저장문서함------------------------------------------------------------------------
		@RequestMapping("/transientStorageList")
		public String transientStorageList(Model model,
										   HttpSession session
										  ) {
			Map<String, Object> info = new HashMap<String, Object>();
			String url = "redirect:/login";
			MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
			if(loginUser!=null){
				info.put("stateNum", 1);
				info.put("mem_num", loginUser.getMem_num());
				List<Sign_DocumentVO> getDocumentList = electronicApprovalService
						.getDocumentList(info);
				if(getDocumentList.size()!=0){
					model.addAttribute("getDocumentList", getDocumentList);
				}
				model.addAttribute("memberVO",loginUser);
				url = "electronicApproval/documentBox/transientStorageList";
			}
			return url;
		}

		@RequestMapping("/detailTransientStorage")
		public String transientStorage(Model model,
									   @RequestParam(value = "docNum") int docNum,
									   @RequestParam(value = "classiNum") String classiNum,
									   HttpSession session) {
			String url = "redirect:/login";
			MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
			if(loginUser!=null){
				Sign_DocumentVO getDocumentDetail = electronicApprovalService
						.getDocumentDetail(docNum);
				
				Map<String, Object> docInfo = new HashMap<String, Object>();
				docInfo.put("docNum",Integer.parseInt(getDocumentDetail.getSig_doc_num()));
				docInfo.put("docMem",getDocumentDetail.getSig_doc_mem_num());
				docInfo.put("docLoginMem",loginUser.getMem_num());
				if (classiNum.equals("1")) {
					url = "electronicApproval/draftdocument/draft1";
				}else if(classiNum.equals("2")){
					url = "electronicApproval/draftdocument/draft2";
				}
				List<StampVO> okStamp = electronicApprovalService.getStamp(docInfo);
				StampVO okPref = electronicApprovalService.getPref(docInfo);
				List<Sign_DocumentVO> signList = electronicApprovalService.signList(docNum);
				if(signList!=null){
					model.addAttribute("signList",signList);
				}
				for(int i = 0; i<okStamp.size(); i++){
					if(okStamp.get(i).getSig_lin_dt_pref().equals("4")){
						okStamp.get(i).setMem_stamp("return.png");
					}
				}
				model.addAttribute("okStamp",okStamp);
				model.addAttribute("okPref",okPref);
				model.addAttribute("getDocumentDetail", getDocumentDetail);
				model.addAttribute("memberVO",loginUser);
			}
			return url;
		}

		@RequestMapping("/transDocumentWrite")
		public String transDocumentWrite(Model model, HttpSession session,
											  Sign_DocumentVO signDocumentVO) {
			String url = "redirect:/login";
			MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
			if(loginUser!=null){
				int lineNum = electronicApprovalService.signLineNumEnroll();
				signDocumentVO.setSig_doc_sig_lin_num(lineNum); 
				model.addAttribute("memberVO",loginUser);
				electronicApprovalService.transDocWrite(signDocumentVO);
				url = "electronicApproval/documentBox/documentMain";
			}
			return url;
		}

		// 진행중인문서함------------------------------------------------------------------------
		@RequestMapping("/ongoingDocumentList")
		public String ongoingDocumentList(Model model, HttpSession session) {
			Map<String, Object> info = new HashMap<String, Object>();
			String url = "redirect:/login";
			MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
			if(loginUser!=null){
				info.put("stateNum", 2);
				info.put("mem_num", loginUser.getMem_num());
				List<Sign_DocumentVO> getDocumentList = electronicApprovalService
						.getDocumentList(info);
				if(getDocumentList.size()!=0){
					model.addAttribute("getDocumentList", getDocumentList);
				}
				info.put("stateNum", 5);
				info.put("mem_num", loginUser.getMem_num());
				List<Sign_DocumentVO> getDocumentListWait = electronicApprovalService
						.getDocumentList(info);
				if(getDocumentListWait.size()!=0){
					model.addAttribute("getDocumentListWait", getDocumentListWait);
				}
				model.addAttribute("memberVO",loginUser);
				url = "electronicApproval/documentBox/ongoingDocumentList";
			}
			return url;
		}

		@RequestMapping("/detailOngoingDocument")
		public String ongoingDocument(Model model,
									  @RequestParam(value = "docNum") int docNum,
									  @RequestParam(value = "classiNum") String classiNum,
									  HttpSession session) {
			String url = "redirect:/login";
			MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
			if(loginUser!=null){
				Sign_DocumentVO getDocumentDetail = electronicApprovalService
						.getDocumentDetail(docNum);
				
				Map<String, Object> docInfo = new HashMap<String, Object>();
				docInfo.put("docNum",Integer.parseInt(getDocumentDetail.getSig_doc_num()));
				docInfo.put("docMem",getDocumentDetail.getSig_doc_mem_num());
				docInfo.put("docLoginMem",loginUser.getMem_num());
				if (classiNum.equals("1")) {
					url = "electronicApproval/draftdocument/draft1";
				}else if(classiNum.equals("2")){
					url = "electronicApproval/draftdocument/draft2";
				}
				List<Sign_DocumentVO> signList = electronicApprovalService.signList(docNum);
				if(signList!=null){
					model.addAttribute("signList",signList);
				}
				List<StampVO> okStamp = electronicApprovalService.getStamp(docInfo);
				StampVO okPref = electronicApprovalService.getPref(docInfo);
				for(int i = 0; i<okStamp.size(); i++){
					if(okStamp.get(i).getSig_lin_dt_pref().equals("4")){
						okStamp.get(i).setMem_stamp("return.png");
					}
						
				}
				model.addAttribute("okStamp",okStamp);
				model.addAttribute("okPref",okPref);
				model.addAttribute("getDocumentDetail", getDocumentDetail);
				model.addAttribute("loginUser", loginUser);
				model.addAttribute("memberVO",loginUser);
			}
			return url;
		}
		
		// 최종승인문서함------------------------------------------------------------------------
		@RequestMapping("/finalizationDocumentList")
		public String finalizationDocumentList(Model model, HttpSession session) {
			String url = "redirect:/login";
			Map<String, Object> info = new HashMap<String, Object>();

			MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
			if(loginUser !=null){
				info.put("stateNum", 3);
				info.put("mem_num", loginUser.getMem_num());
				List<Sign_DocumentVO> getDocumentList = electronicApprovalService
						.getDocumentList(info);
				if(getDocumentList.size()!=0){
					model.addAttribute("getDocumentList", getDocumentList);
				}
				model.addAttribute("memberVO",loginUser);
				url = "electronicApproval/documentBox/finalizationDocumentList";
			}
			return url;
		}

		@RequestMapping("/detailFinalizationDocument")
		public String finalizationDocument(Model model,
										   @RequestParam(value = "docNum") int docNum,
										   @RequestParam(value = "classiNum") String classiNum,
										   HttpSession session) {
			String url = "redirect:/login";
			MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
			if(loginUser!=null){
				Sign_DocumentVO getDocumentDetail = electronicApprovalService
						.getDocumentDetail(docNum);
				
				Map<String, Object> docInfo = new HashMap<String, Object>();
				docInfo.put("docNum",Integer.parseInt(getDocumentDetail.getSig_doc_num()));
				docInfo.put("docMem",getDocumentDetail.getSig_doc_mem_num());
				docInfo.put("docLoginMem",loginUser.getMem_num());
				if (classiNum.equals("1")) {
					url = "electronicApproval/draftdocument/draft1";
				}else if(classiNum.equals("2")){
					url = "electronicApproval/draftdocument/draft2";
				}
				Sign_DocumentVO approvalName = electronicApprovalService.approvalName(docNum);
				if(approvalName!=null){
					model.addAttribute("approvalName",approvalName);
				}
				List<StampVO> okStamp = electronicApprovalService.getStamp(docInfo);
				StampVO okPref = electronicApprovalService.getPref(docInfo);
				for(int i = 0; i<okStamp.size(); i++){
					if(okStamp.get(i).getSig_lin_dt_pref().equals("4")){
						okStamp.get(i).setMem_stamp("return.png");
					}
						
				}
				
				List<Sign_DocumentVO> signList = electronicApprovalService.signList(docNum);
				if(signList!=null){
					model.addAttribute("signList",signList);
				}
				model.addAttribute("okStamp",okStamp);
				model.addAttribute("okPref",okPref);
				model.addAttribute("getDocumentDetail", getDocumentDetail);
				model.addAttribute("memberVO",loginUser);
			}
			return url;
		}

		// 반려문서함------------------------------------------------------------------------
		@RequestMapping("/returnDocumentList")
		public String returnDocumentList(Model model, HttpSession session) {
			String url = "redirect:/login";
			Map<String, Object> info = new HashMap<String, Object>();

			MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
			if(loginUser != null){
				info.put("stateNum", 4);
				info.put("mem_num", loginUser.getMem_num());
				List<Sign_DocumentVO> getDocumentList = electronicApprovalService
						.getDocumentList(info);
				if(getDocumentList.size()!=0){
					model.addAttribute("getDocumentList", getDocumentList);
				}
				model.addAttribute("memberVO",loginUser);
				url = "electronicApproval/documentBox/returnDocumentList";
			}
			return url;
		}
		@RequestMapping("/returnMydocumentList")
		public String returnMydocumentList(Model model, HttpSession session) {
			String url = "redirect:/login";
			Map<String, Object> myInfo = new HashMap<String, Object>();
			MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
			if(loginUser !=null){
				myInfo.put("stateNum", 4);
				myInfo.put("sig_lin_dt_st", 4);
				myInfo.put("mem_num", loginUser.getMem_num());
				List<Sign_DocumentVO> getMyReturnDocumentList = electronicApprovalService
						.getMyReturnDocumentList(myInfo);
				if(getMyReturnDocumentList.size()!=0){
					model.addAttribute("getReturnDocumentList", getMyReturnDocumentList);
				}
				model.addAttribute("memberVO",loginUser);
				url = "electronicApproval/documentBox/returnMyDocument";
			}
			return url;
		}

		@RequestMapping("/detailReturnDocument")
		public String returnDocument(Model model,
									 @RequestParam(value = "docNum") int docNum,
									 @RequestParam(value = "classiNum") String classiNum,
									 HttpSession session,
									 MemberVO member) {
			String url = "redirect:/login";
			MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
			if(loginUser!=null){
				url = "electronicApproval/documentBox/returnDocument";
				Sign_DocumentVO getDocumentDetail = electronicApprovalService.getDocumentDetail(docNum);
				Map<String, Object> docInfo = new HashMap<String, Object>();
				docInfo.put("docNum",Integer.parseInt(getDocumentDetail.getSig_doc_num()));
				docInfo.put("docMem",getDocumentDetail.getSig_doc_mem_num());
				docInfo.put("docLoginMem",member.getMem_num());
				if (classiNum.equals("1")) {
					url = "electronicApproval/draftdocument/draft1";
				}else if(classiNum.equals("2")){
					url = "electronicApproval/draftdocument/draft2";
				}
				List<StampVO> okStamp = electronicApprovalService.getStamp(docInfo);
				StampVO okPref = electronicApprovalService.getPref(docInfo);
				for(int i = 0; i<okStamp.size(); i++){
					if(okStamp.get(i).getSig_lin_dt_st().equals("4")){
						okStamp.get(i).setMem_stamp("return.png");
					}
				}
				
				Sign_DocumentVO returnComment = electronicApprovalService.returnComment(docNum);
				if(returnComment!=null){
					model.addAttribute("returnComment",returnComment);
				}
				List<Sign_DocumentVO> signList = electronicApprovalService.signList(docNum);
				if(signList!=null){
					model.addAttribute("signList",signList);
				}
				model.addAttribute("okStamp",okStamp);
				model.addAttribute("okPref",okPref);
				model.addAttribute("getDocumentDetail", getDocumentDetail);
				model.addAttribute("memberVO",loginUser);
			}
			return url;
		}
		
	// 결재할문서------------------------------------------------------------------------
		@RequestMapping("/documentApprovalList")
		public String documentApprovalList(Model model, HttpSession session) {
			String url = "redirect:/login";
			Map<String, Object> info = new HashMap<String, Object>();

			MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
			if(loginUser!=null){
				info.put("mem_num", loginUser.getMem_num());
				info.put("approvalState", 1);
				
				List<Sign_DocumentVO> getApprovalDocList = electronicApprovalService.getApprovalDocList(info);
				if(getApprovalDocList.size()!=0){
					model.addAttribute("getApprovalDocList",getApprovalDocList);
				}
				model.addAttribute("checking",1);
				model.addAttribute("memberVO",loginUser);
				url = "electronicApproval/documentBox/documentApprovalList";
			}
			return url;
		}
		
		@RequestMapping("/approvalMyDocumentList")
		public String approvalMyDocumentList(Model model, HttpSession session) {
			String url = "redirect:/login";
			Map<String, Object> myInfo = new HashMap<String, Object>();
			MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
			if(loginUser!=null){
				myInfo.put("stateNum1", 2);
				myInfo.put("stateNum2", 3);
				myInfo.put("sig_lin_dt_st1", 2);
				myInfo.put("sig_lin_dt_st2", 3);
				myInfo.put("mem_num", loginUser.getMem_num());
				List<Sign_DocumentVO> getMyApprovalDocumentList = electronicApprovalService.getMyApprovalDocumentList(myInfo);
				if(getMyApprovalDocumentList.size()!=0){
					model.addAttribute("getMyApprovalDocumentList", getMyApprovalDocumentList);
				}
				model.addAttribute("memberVO",loginUser);
				url = "electronicApproval/documentBox/approvalMyDocument";
			}
			return url;
		}

		@RequestMapping("/detailDocumentApproval")
		public String documentApproval(Model model,
				@RequestParam(value = "docNum") int docNum,
				@RequestParam(value = "classiNum") String classiNum,
				@RequestParam(value = "checking") String checking,
				HttpSession session) {
			String url = "redirect:/login";
			Sign_DocumentVO getDocumentDetail = electronicApprovalService
					.getDocumentDetail(docNum);
			MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
			if(loginUser!=null){
				url = "electronicApproval/documentBox/documentApproval";
				if (classiNum.equals("1")) {
					url = "electronicApproval/draftdocument/draft1";
				}else if(classiNum.equals("2")){
					url = "electronicApproval/draftdocument/draft2";
				}
				Map<String, Object> docInfo = new HashMap<String, Object>();
				docInfo.put("docNum",Integer.parseInt(getDocumentDetail.getSig_doc_num()));
				docInfo.put("docMem",getDocumentDetail.getSig_doc_mem_num());
				docInfo.put("docLoginMem",loginUser.getMem_num());
				List<StampVO> okStamp = electronicApprovalService.getStamp(docInfo);
				StampVO okPref = electronicApprovalService.getPref(docInfo);
				for(int i = 0; i<okStamp.size(); i++){
					if(okStamp.get(i).getSig_lin_dt_pref().equals("4")){
						okStamp.get(i).setMem_stamp("return.png");
					}
						
				}
				
				Sign_DocumentVO approvalName = electronicApprovalService.approvalName(docNum);
				if(approvalName!=null){
					model.addAttribute("approvalName",approvalName);
				}
				List<Sign_DocumentVO> signList = electronicApprovalService.signList(docNum);
				if(signList!=null){
					model.addAttribute("signList",signList);
				}
				
				if(!checking.equals("")){
					model.addAttribute("checking",checking);
				}
				model.addAttribute("okStamp",okStamp);
				model.addAttribute("okPref",okPref);
				model.addAttribute("getDocumentDetail", getDocumentDetail);
				model.addAttribute("memberVO",loginUser);
			}
			return url;
		}
	//----------------------------------------------------------------------
	
		@RequestMapping("/documentOk")
		public String documentApprovalOk(Model model,HttpSession session,
										   @RequestParam(value="sig_doc_num")String sig_doc_num,
										   @RequestParam(value="sig_lin_dt_pref")String sig_lin_dt_pref,
										   @RequestParam(value="ok_sign")String ok_sign){
			String url = "redirect:/login";
			MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
			if(loginUser!=null){
				Map<String, Object> appro = new HashMap<String, Object>();
				url = "electronicApproval/documentBox/documentMain";
				int docNum = Integer.parseInt(sig_doc_num);
				int prefNum = Integer.parseInt(sig_lin_dt_pref);
				int dtNum=2;
				int stNum = 2;
				appro.put("docNum",docNum);
				appro.put("prefNum",prefNum);
				appro.put("dtNum", dtNum);
				if(prefNum==1){
					appro.put("stNum",stNum);
					electronicApprovalService.changeDocState(appro);
				}
				if(ok_sign.equals("1")){
					electronicApprovalService.documentOkPre(appro);
					prefNum++;
					dtNum=1;	
					appro.put("prefNum",prefNum);
					appro.put("dtNum", dtNum);
					int error = electronicApprovalService.documentOk(appro);
					if(error==0){
						appro.put("finalDoc", 3);
						electronicApprovalService.documentFinalOk(appro);
						dtNum=3;
						prefNum--;
						appro.put("dtNum", dtNum);
						appro.put("prefNum", prefNum);
						electronicApprovalService.documentOkPre(appro);
					}
				}
				model.addAttribute("memberVO",loginUser);
			}
			return url;
		}
		@RequestMapping("/documentNo")
		public String documentApprovalOkNo(Model model,HttpSession session,
				@RequestParam(value="sig_doc_num")String sig_doc_num,
				@RequestParam(value="sig_lin_dt_pref")String sig_lin_dt_pref,
				@RequestParam(value="ok_sign")String ok_sign,
				@RequestParam(value="inputString")String inputString){
			String url = "redirect:/login";
			MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
			if(loginUser!=null){
				Map<String, Object> appro = new HashMap<String, Object>();
				url = "electronicApproval/documentBox/documentMain";
				int docNum = Integer.parseInt(sig_doc_num);
				int prefNum = Integer.parseInt(sig_lin_dt_pref);
				int dtNum=2;
				int stNum = 2;
				appro.put("docNum",docNum);
				appro.put("prefNum",prefNum);
				appro.put("dtNum", dtNum);
				if(prefNum==1){
					appro.put("stNum",stNum);
					electronicApprovalService.changeDocState(appro);
				}
				if(ok_sign.equals("2")){
					appro.put("dtNum",4);
					appro.put("finalDoc",4);
					appro.put("inputString", inputString);
					electronicApprovalService.documentOk(appro);
					electronicApprovalService.documentFinalOk(appro);
				}
				model.addAttribute("memberVO",loginUser);
			}
			return url;
		}
		@RequestMapping(value="/draftAddressBook")
		public String emailAddressBook(Model model, HttpSession session) {
			String url = "electronicApproval/draftdocument/draftAddress";
			MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
			model.addAttribute("memberVO",loginUser);
			return url;
		}
		
		@RequestMapping(value="/backDocument")
		public String backDocument(Model model, HttpSession session,
				@RequestParam(value="sig_doc_num")int sig_doc_num){
			String url = "redirect:/documentMain";
			MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
			electronicApprovalService.backDocument(sig_doc_num);
			electronicApprovalService.backDocumentChangeState(sig_doc_num);
			model.addAttribute("memberVO",loginUser);
			return url;
		}
}
