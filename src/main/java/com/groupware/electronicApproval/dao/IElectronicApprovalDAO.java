package com.groupware.electronicApproval.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.groupware.dto.Sign_DocumentVO;
import com.groupware.dto.StampVO;
/**
 * @Class Name : IElectronicApprovalDAO.java
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
public interface IElectronicApprovalDAO {

	/**
	 * 문서 유형, 사원별 리스트
	 * @param Map<String, Object> info
	 * @return List<Sign_DocumentVO> 
	 * @throws SQLException
	 */
	List<Sign_DocumentVO> getDocumentList(Map<String, Object> info) throws SQLException;
	/**
	 * 문서 전체 리스트
	 * @param
	 * @return List<Sign_DocumentVO> 
	 * @throws SQLException
	 */
	List<Sign_DocumentVO> documentList(String mem_num) throws SQLException;
	/**
	 * 문서 상세보기
	 * @param int docNum
	 * @return Sign_DocumentVO
	 * @throws SQLException
	 */
	Sign_DocumentVO getDocumentDetail(int docNum) throws SQLException;
	/**
	 * 기안 문서 작성
	 * @param Sign_DocumentVO signDocumentVO
	 * @return Sign_DocumentVO
	 * @throws SQLException
	 */
	Sign_DocumentVO writeElectDocument(Sign_DocumentVO signDocumentVO) throws SQLException;
	/**
	 * 결재해야 할 문서 리스트
	 * @param Map<String, Object> info
	 * @return List<Sign_DocumentVO> 
	 * @throws SQLException
	 */
	List<Sign_DocumentVO> getApprovalDocList(Map<String, Object> info) throws SQLException;
	/**
	 * 멤버 도장 가져오기
	 * @param Map<String, Object> docInfo
	 * @return List<StampVO> 
	 * @throws SQLException
	 */
	List<StampVO> getStamp(Map<String, Object> docInfo) throws SQLException;
	/**
	 * 결재선 등록
	 * @param
	 * @return int 
	 * @throws SQLException
	 */
	int signLineNumEnroll() throws SQLException;
	/**
	 * 결재선 정보 등록
	 * @param Map<String,Object> lineEnroll
	 * @return void 
	 * @throws SQLException
	 */
	void signLineEnroll(Map<String,Object> lineEnroll) throws SQLException;
	/**
	 * 문서승인
	 * @param Map<String, Object> appro
	 * @return int 
	 * @throws SQLException
	 */
	int documentOk(Map<String, Object> appro) throws SQLException;
	/**
	 * 결재 순서 가져오기
	 * @param Map<String, Object> docInfo
	 * @return StampVO
	 * @throws SQLException
	 */
	StampVO getPref(Map<String, Object> docInfo) throws SQLException;
	/**
	 * 이전 결재자 순서 정보 수정
	 * @param Map<String, Object> appro
	 * @return void 
	 * @throws SQLException
	 */
	void documentOkPre(Map<String, Object> appro) throws SQLException;
	/**
	 * 최종승인
	 * @param Map<String, Object> appro
	 * @return void
	 * @throws SQLException
	 */
	void documentFianlOk(Map<String, Object> appro) throws SQLException;
	/**
	 * 반려 한 문서 리스트가져오기
	 * @param Map<String, Object> myInfo
	 * @return List<Sign_DocumentVO>
	 * @throws SQLException
	 */
	List<Sign_DocumentVO> getMyReturnDocumentList(Map<String, Object> myInfo) throws SQLException;
	/**
	 * 결재 승인한 문서 리스트가져오기
	 * @param Map<String, Object> myInfo
	 * @return List<Sign_DocumentVO> 
	 * @throws SQLException
	 */
	List<Sign_DocumentVO> getMyApprovalDocumentList(Map<String, Object> myInfo) throws SQLException;
	/**
	 * 문서 상태 변경
	 * @param Map<String, Object> appro
	 * @return void 
	 * @throws SQLException
	 */
	void changeDocState(Map<String, Object> appro) throws SQLException;
	/**
	 * 임시문서 작성
	 * @param Sign_DocumentVO signDocumentVO
	 * @return int 
	 * @throws SQLException
	 */
	int transDocWrite(Sign_DocumentVO signDocumentVO) throws SQLException;
	/**
	 * 임시문서 업데이트
	 * @param Sign_DocumentVO signDocument
	 * @return void 
	 * @throws SQLException
	 */
	void transDocumentUpdate(Sign_DocumentVO signDocument) throws SQLException;
	/**
	 * 임시문서 반복 업데이트
	 * @param Sign_DocumentVO signDocument
	 * @return int 
	 * @throws SQLException
	 */
	void transDocumentUpdateChange(Sign_DocumentVO signDocument) throws SQLException;
	/**
	 * 반려 사유
	 * @param int docNum
	 * @return Sign_DocumentVO 
	 * @throws SQLException
	 */
	Sign_DocumentVO returnComment(int docNum) throws SQLException;
	/**
	 * 승인한 리스트 가져오기
	 * @param int docNum
	 * @return List<Sign_DocumentVO> 
	 * @throws SQLException
	 */
	List<Sign_DocumentVO> signList(int docNum) throws SQLException;
	/**
	 * 승인자 이름 가져오기
	 * @param int docNum
	 * @return Sign_DocumentVO 
	 * @throws SQLException
	 */
	Sign_DocumentVO approvalName(int docNum) throws SQLException;
	/**
	 * 문서 회수
	 * @param int sig_doc_num
	 * @return void 
	 * @throws SQLException
	 */
	void backDocument(int sig_doc_num) throws SQLException;
	/**
	 * 회수 문서 상태 변경
	 * @param int sig_doc_num
	 * @return void 
	 * @throws SQLException
	 */
	void backDocumentChangeState(int sig_doc_num) throws SQLException;
	List<Sign_DocumentVO> getDocumentWaitDtSt(Map<String, Object> info) throws SQLException;

}
