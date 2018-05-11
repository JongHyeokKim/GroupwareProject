package com.groupware.myPage.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupware.dto.MemberVO;
import com.groupware.dto.attendance.AttendanceVO;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @Class Name : IMyPageDAO.java
 * @Description : 마이페이지 DB연동 구현부
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
@Repository
public class MyPageDAOImpl implements IMyPageDAO {
	
	@Autowired
	private SqlMapClient client;
	
	//개인정보
	@Override
	public MemberVO personalInformation(String id) throws SQLException {
		return (MemberVO) client.queryForObject("mypage.personalInformation",id);
	}
	
	//퇴직금 조회
	@Override
	public MemberVO serverancePay(String id) throws SQLException {
		return (MemberVO) client.queryForObject("mypage.serverancePay",id);
	}
	
	//근태 조회
	@Override
	public List<AttendanceVO> diligenceCheck(String id) throws SQLException {
		List<AttendanceVO> attendanceList = client.queryForList("mypage.diligenceCheck",id);
		return attendanceList;
	}
	
	//근태 검색 조회
	@Override
	public List<AttendanceVO> searchDiligenceCheck(String id,String keyword, String startDate,
			String endDate) throws SQLException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("keyword", keyword);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		List<AttendanceVO> searchAttendanceList = client.queryForList("mypage.searchDiligenceCheck",map);
		return searchAttendanceList;
	}
	
	//개인정보 수정 처리
	@Override
	public void personalInformationUpdate(MemberVO member) throws SQLException {
		client.update("mypage.personalInformationUpdate",member);
		
	}
	
	//패스워드 수정
	@Override
	public void passwordUpdate(String bCryptString, String id)
			throws SQLException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("mem_pw", bCryptString);
		map.put("mem_num", id);
		client.update("mypage.passwordUpdate",map);
	}

}
