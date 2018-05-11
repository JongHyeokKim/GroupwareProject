package com.groupware.myPage.service;

import java.util.List;

import com.groupware.dto.MemberVO;
import com.groupware.dto.attendance.AttendanceVO;

/**
 * @Class Name : IMyPageService.java
 * @Description : 마이페이지 service interface
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
public interface IMyPageService {

	/**
	 * 개인 정보
	 * 
	 * @param String id
	 * @return MemberVO
	 * @throws 
	 */
	MemberVO personalInformation(String id);

	/**
	 * 퇴직금 조회
	 * 
	 * @param String id
	 * @return MemberVO
	 * @throws 
	 */
	MemberVO serverancePay(String id);

	/**
	 * 근태 조회
	 * 
	 * @param String id
	 * @return List<AttendanceVO>
	 * @throws 
	 */
	List<AttendanceVO> diligenceCheck(String id);

	/**
	 * 근태 검색 조회
	 * 
	 * @param String id, String keyword, String startDate
	 * @return List<AttendanceVO>
	 * @throws 
	 */
	List<AttendanceVO> searchDiligenceCheck(String id,String keyword,String startDate,
			String endDate);
	
	/**
	 * 개인정보 수정 처리
	 * 
	 * @param MemberVO member
	 * @return void
	 * @throws 
	 */
	void personalInformationuUpdate(MemberVO member);

	/**
	 * 패스워드 수정
	 * 
	 * @param String bCryptString, String id
	 * @return void
	 * @throws 
	 */
	void passwordUpdate(String bCryptString, String id);

}
