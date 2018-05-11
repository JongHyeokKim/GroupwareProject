package com.groupware.myPage.dao;

import java.sql.SQLException;
import java.util.List;

import com.groupware.dto.MemberVO;
import com.groupware.dto.attendance.AttendanceVO;

/**
 * @Class Name : IMyPageDAO.java
 * @Description : 마이페이지 DAO interface
 * @Modification Information
 * @author 이준수
 * @since  2016.09.01.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.09.01.   이준수             최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
public interface IMyPageDAO {

	/**
	 * 개인 정보
	 * 
	 * @param String id
	 * @return MemberVO
	 * @throws SQLException
	 */
	MemberVO personalInformation(String id)throws SQLException;

	/**
	 * 퇴직금 조회
	 * 
	 * @param String id
	 * @return MemberVO
	 * @throws SQLException
	 */
	MemberVO serverancePay(String id)throws SQLException;

	/**
	 * 근태 조회
	 * 
	 * @param String id
	 * @return List<AttendanceVO>
	 * @throws SQLException
	 */
	List<AttendanceVO> diligenceCheck(String id)throws SQLException;

	/**
	 * 근태 검색 조회
	 * 
	 * @param String id, String keyword, String startDate
	 * @return List<AttendanceVO>
	 * @throws SQLException
	 */
	List<AttendanceVO> searchDiligenceCheck(String id,String keyword, String startDate,
			String endDate)throws SQLException;

	/**
	 * 개인정보 수정 처리
	 * 
	 * @param MemberVO member
	 * @return void
	 * @throws SQLException
	 */
	void personalInformationUpdate(MemberVO member)throws SQLException;

	/**
	 * 패스워드 수정
	 * 
	 * @param String bCryptString, String id
	 * @return void
	 * @throws SQLException
	 */
	void passwordUpdate(String bCryptString, String id)throws SQLException;

}
