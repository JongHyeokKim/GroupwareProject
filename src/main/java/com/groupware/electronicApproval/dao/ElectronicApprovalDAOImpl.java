package com.groupware.electronicApproval.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupware.dto.Sign_DocumentVO;
import com.groupware.dto.StampVO;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @Class Name : ElectronicApprovalDAOImpl.java
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
@Repository
public class ElectronicApprovalDAOImpl implements IElectronicApprovalDAO{
	@Autowired
	private SqlMapClient client;
	//문서 유형, 사원별 리스트
	@Override
	public List<Sign_DocumentVO> getDocumentList(Map<String, Object> info) throws SQLException {
		List<Sign_DocumentVO> getDocumentList = null;
		getDocumentList = client.queryForList("documentList.docList", info);
		return getDocumentList;
	}
	//문서 전체 리스트
	@Override
	public List<Sign_DocumentVO> documentList(String mem_num) throws SQLException {
		List<Sign_DocumentVO> documentList = null;
		documentList = client.queryForList("documentList.docListAll", mem_num);
		return documentList;
	}
	//문서 상세보기
	@Override
	public Sign_DocumentVO getDocumentDetail(int docNum) throws SQLException {
			Sign_DocumentVO getDocumentDetail = null;
			getDocumentDetail = (Sign_DocumentVO) client.queryForObject("documentList.docDetail",docNum);
		return getDocumentDetail;
	}
	//기안 문서 작성
	@Override
	public Sign_DocumentVO writeElectDocument(Sign_DocumentVO signDocumentVO)
			throws SQLException {
		Sign_DocumentVO writeElectDocument = null;
		writeElectDocument=(Sign_DocumentVO) client.insert("documentList.insertElectDocument",signDocumentVO);
		return writeElectDocument;
	}
	//승인문서리스트
	@Override
	public List<Sign_DocumentVO> getApprovalDocList(Map<String, Object> info) throws SQLException {
		List<Sign_DocumentVO> getApprovalDocList = null;
		getApprovalDocList = client.queryForList("documentList.approvalDocList", info);
		return getApprovalDocList;
	}
	//도장 가져오기
	@Override
	public List<StampVO> getStamp(Map<String, Object> docInfo) throws SQLException {
		List<StampVO> getStamp = null;
		getStamp = client.queryForList("documentList.stampList", docInfo);
		return getStamp;
	}
	//결재선 등록
	@Override
	public int signLineNumEnroll() throws SQLException {
		int lineNum = 0;
		lineNum = (Integer) client.insert("documentList.lineNumEnroll");
		return lineNum;
	}
	//결재선 상세 등록
	@Override
	public void signLineEnroll(Map<String,Object> lineEnroll) throws SQLException {
		client.insert("documentList.lineEnroll",lineEnroll);
	}
	//문서 승인
	@Override
	public int documentOk(Map<String, Object> appro) throws SQLException {
		int error = client.update("documentList.okSign",appro);
		return error;
	}
	//우선순위 가져오기
	@Override
	public StampVO getPref(Map<String, Object> docInfo) throws SQLException {
		StampVO getPref = null;
		getPref = (StampVO) client.queryForObject("documentList.prefList", docInfo);
		return getPref;
	}
	//이전 승인 상태 업데이트
	@Override
	public void documentOkPre(Map<String, Object> appro) throws SQLException {
		client.update("documentList.okSignPre",appro);	
	}
	//최종승인
	@Override
	public void documentFianlOk(Map<String, Object> appro) throws SQLException {
		client.update("documentList.finalDocOk",appro);
	}
	//반려한 문서 리스트가져오기
	@Override
	public List<Sign_DocumentVO> getMyReturnDocumentList(Map<String, Object> myInfo)
			throws SQLException {
		List<Sign_DocumentVO> getMyReturnDocumentList = null;
		getMyReturnDocumentList = client.queryForList("documentList.getMyReturnList", myInfo);
		return getMyReturnDocumentList;
	}
	//승인한 문서 리스트 가져오기
	@Override
	public List<Sign_DocumentVO> getMyApprovalDocumentList(
			Map<String, Object> myInfo) throws SQLException {
		List<Sign_DocumentVO> getMyApprovalDocumentList = null;
		getMyApprovalDocumentList = client.queryForList("documentList.getMyApprovalList", myInfo);
		System.out.println(getMyApprovalDocumentList.size());
		return getMyApprovalDocumentList;
	}
	//문서 상태 변경
	@Override
	public void changeDocState(Map<String, Object> appro) throws SQLException {
		client.update("documentList.changeDocState", appro);
	}
	//임시문서 작성
	@Override
	public int transDocWrite(Sign_DocumentVO signDocumentVO)
			throws SQLException {
		int docNum = 0;
		docNum = (Integer) client.insert("documentList.insertTransElectDocument",signDocumentVO);
		return docNum;
	}
	//임시문서 업데이트
	@Override
	public void transDocumentUpdate(Sign_DocumentVO signDocument)
			throws SQLException {
		client.update("documentList.transDocUp",signDocument);
	}
	//임시문서 반복 업데이트
	@Override
	public void transDocumentUpdateChange(Sign_DocumentVO signDocument)
			throws SQLException {
		client.update("documentList.transDocUpChange",signDocument);
		
	}
	//반려사유
	@Override
	public Sign_DocumentVO returnComment(int docNum) throws SQLException {
		Sign_DocumentVO returnComment = null;
		returnComment = (Sign_DocumentVO) client.queryForObject("documentList.returnComment",docNum);
		System.out.println(returnComment.getMem_nm());
		return returnComment;
	}
	//승인 리스트
	@Override
	public List<Sign_DocumentVO> signList(int docNum) throws SQLException {
		List<Sign_DocumentVO> signList = null;
		signList = client.queryForList("documentList.signList", docNum);
		return signList;
	}
	//승인자 이름
	@Override
	public Sign_DocumentVO approvalName(int docNum) throws SQLException {
		Sign_DocumentVO approvalName = null;
		approvalName = (Sign_DocumentVO) client.queryForObject("documentList.approvalName",docNum);
		return approvalName;
	}
	//문서 회수
	@Override
	public void backDocument(int sig_doc_num) throws SQLException {
		client.delete("documentList.backDoc",sig_doc_num);
	}
	//회수 문서 상태 변경
	@Override
	public void backDocumentChangeState(int sig_doc_num) throws SQLException {
		client.delete("documentList.backDocSt",sig_doc_num);
	}
	@Override
	public List<Sign_DocumentVO> getDocumentWaitDtSt(Map<String, Object> info)
			throws SQLException {
		List<Sign_DocumentVO> getDocumentWaitDtSt = null;
		getDocumentWaitDtSt = client.queryForList("documentList.docWaitDtSt", info);
		return getDocumentWaitDtSt;
	}
	
	
}
