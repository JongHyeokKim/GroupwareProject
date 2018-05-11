package com.groupware.myPage.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.dto.MemberVO;
import com.groupware.dto.attendance.AttendanceVO;
import com.groupware.myPage.dao.IMyPageDAO;

/**
 * @Class Name : MyPageServiceImpl.java
 * @Description : 마이페이지 service class
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
@Service
public class MyPageServiceImpl implements IMyPageService {

	@Autowired
	private IMyPageDAO iMyPageDAO;
	
	//개인정보
	@Override
	public MemberVO personalInformation(String id) {
		MemberVO memberVO = null;
		try {
			memberVO = iMyPageDAO.personalInformation(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberVO;
	}

	//퇴직금 조회
	@Override
	public MemberVO serverancePay(String id) {
		MemberVO memberVO = null;
		try {
			memberVO = iMyPageDAO.serverancePay(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberVO;
	}

	//근태 조회
	@Override
	public List<AttendanceVO> diligenceCheck(String id) {
		List<AttendanceVO> attendanceList = null;
		try {
			attendanceList = iMyPageDAO.diligenceCheck(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return attendanceList;
	}

	//근태 검색 조회
	@Override
	public List<AttendanceVO> searchDiligenceCheck(String id,String keyword, String startDate,
			String endDate) {
		List<AttendanceVO> searchAttendanceList = null;
		try {
			searchAttendanceList = iMyPageDAO.searchDiligenceCheck(id,keyword,startDate,endDate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return searchAttendanceList;
	}

	//개인정보 수정 처리
	@Override
	public void personalInformationuUpdate(MemberVO member) {
		try {
			iMyPageDAO.personalInformationUpdate(member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	//패스워드 수정
	@Override
	public void passwordUpdate(String bCryptString, String id) {
		try {
			iMyPageDAO.passwordUpdate(bCryptString,id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
