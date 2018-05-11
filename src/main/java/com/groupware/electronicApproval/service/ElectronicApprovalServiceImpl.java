package com.groupware.electronicApproval.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.dto.Sign_DocumentVO;
import com.groupware.dto.StampVO;
import com.groupware.electronicApproval.dao.IElectronicApprovalDAO;
/**
 * @Class Name : ElectronicApprovalServiceImpl.java
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
@Service
public class ElectronicApprovalServiceImpl implements
		IElectronicApprovalService {
	@Autowired
	private IElectronicApprovalDAO dao;

	//문서 유형, 사원별 리스트
	@Override
	public List<Sign_DocumentVO> getDocumentList(Map<String, Object> info){
			List<Sign_DocumentVO> getDocumentList = null;
			try {
				getDocumentList = dao.getDocumentList(info);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return getDocumentList;
	}
	
	//문서 전체 리스트
	@Override
	public List<Sign_DocumentVO> documentList(String mem_num) {
		List<Sign_DocumentVO> documentList = null;
		try {
			documentList=dao.documentList(mem_num);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return documentList;
	}
	//문서 상세보기
	@Override
	public Sign_DocumentVO getDocumentDetail(int docNum) {
		Sign_DocumentVO getDocumentDetail = null;
		
		try {
			getDocumentDetail=dao.getDocumentDetail(docNum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getDocumentDetail;
	}
	//기안 문서 작성
	@Override
	public Sign_DocumentVO writeElectDocument(Sign_DocumentVO signDocumentVO) {
		Sign_DocumentVO writeElectDocument = null;
		try {
			writeElectDocument=dao.writeElectDocument(signDocumentVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return writeElectDocument;
	}
	//결재해야 할 문서 리스트
	@Override
	public List<Sign_DocumentVO> getApprovalDocList(Map<String, Object> info) {
		List<Sign_DocumentVO> getApprovalDocList = null;
		try {
			getApprovalDocList = dao.getApprovalDocList(info);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getApprovalDocList;
	}
	//도장 가져오기
	@Override
	public List<StampVO> getStamp(Map<String, Object> docInfo) {
		List<StampVO> getStamp = null;
			try {
				getStamp = dao.getStamp(docInfo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return getStamp;
	}
	//결재선 등록
	@Override
	public int signLineNumEnroll() {
		int lineNum = 0;
		try {
			lineNum = dao.signLineNumEnroll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lineNum;
	}
	//결재선 정보 등록
	@Override
	public void signLineEnroll(Map<String,Object> lineEnroll) {
		try {
			dao.signLineEnroll(lineEnroll);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//문서 승인
	@Override
	public int documentOk(Map<String, Object> appro) {
		int error = 0;
		try {
			error = dao.documentOk(appro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return error;
	}
	//우선순위 가져오기
	@Override
	public StampVO getPref(Map<String, Object> docInfo) {
		StampVO getPref = null;
		try {
			getPref = dao.getPref(docInfo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return getPref;
	}
	//이전 결재자 상태변경
	@Override
	public void documentOkPre(Map<String, Object> appro) {
		try {
			dao.documentOkPre(appro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//문서 최종 승인
	@Override
	public void documentFinalOk(Map<String, Object> appro) {
		try {
			dao.documentFianlOk(appro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//반려한 문서 리스트가져오기
	@Override
	public List<Sign_DocumentVO> getMyReturnDocumentList(Map<String, Object> myInfo) {
		List<Sign_DocumentVO> getMyReturnDocumentList = null;
		try {
			getMyReturnDocumentList = dao.getMyReturnDocumentList(myInfo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getMyReturnDocumentList;
	}
	//승인한 문서 리스트 가져오기
	@Override
	public List<Sign_DocumentVO> getMyApprovalDocumentList(
			Map<String, Object> myInfo) {
		List<Sign_DocumentVO> getMyApprovalDocumentList = null;
		try {
			getMyApprovalDocumentList = dao.getMyApprovalDocumentList(myInfo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(getMyApprovalDocumentList.size());
		return getMyApprovalDocumentList;
	}
	//문서 상태 변경
	@Override
	public void changeDocState(Map<String, Object> appro) {
		try {
			dao.changeDocState(appro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//임시문서 작성
	@Override
	public int transDocWrite(Sign_DocumentVO signDocumentVO) {
		int docNum = 0;
		try {
			docNum = dao.transDocWrite(signDocumentVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return docNum;
	}
	//임시문서 업데이트
	@Override
	public void transDocumentUpdate(Sign_DocumentVO signDocument) {
		try {
			dao.transDocumentUpdate(signDocument);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//임시문서 반복 업데이트
	@Override
	public void transDocumentUpdateChange(Sign_DocumentVO signDocument) {
		try {
			dao.transDocumentUpdateChange(signDocument);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//반려사유
	@Override
	public Sign_DocumentVO returnComment(int docNum) {
		Sign_DocumentVO returnComment = null;
		try {
			returnComment = dao.returnComment(docNum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnComment;
	}
	//승인 리스트
	@Override
	public List<Sign_DocumentVO> signList(int docNum) {
		List<Sign_DocumentVO> signList = null;
		try {
			signList = dao.signList(docNum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return signList;
	}
	//승인자 이름
	@Override
	public Sign_DocumentVO approvalName(int docNum) {
		Sign_DocumentVO approvalName = null;
		try {
			approvalName = dao.approvalName(docNum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return approvalName;
	}
	//문서 회수
	@Override
	public void backDocument(int sig_doc_num) {
		try {
			dao.backDocument(sig_doc_num);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//회수문서 상태변경
	@Override
	public void backDocumentChangeState(int sig_doc_num) {
		try {
			dao.backDocumentChangeState(sig_doc_num);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Sign_DocumentVO> getDocumentWaitDtSt(Map<String, Object> info) {
		List<Sign_DocumentVO> getDocumentWaitDtSt = null;
		try {
			getDocumentWaitDtSt = dao.getDocumentWaitDtSt(info);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getDocumentWaitDtSt;
	}

}
