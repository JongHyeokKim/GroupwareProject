package com.groupware.attendance.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupware.dto.attendance.AttendanceVO;
import com.groupware.dto.attendance.DepartVO;
import com.groupware.dto.attendance.WorkStateVO;
import com.ibatis.sqlmap.client.SqlMapClient;
/**
 * @Class Name : AttendanceDAOImpl.java
 * @Description : 관리자 근태 정보 및 관리를 위한 DAO 클래스
 * @Modification Information
 * @author 김태균
 * @since 2016.09.01.
 * @version 1.0
 * @see <pre>
 * << 개정이력(Modification Information) >>
 *    	수정일                   수정자                    수정내용
 *    -------      -------     -------------------
 *   2016.09.01.    김태균                   최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
@Repository
public class AttendanceDAOImpl implements IAttendanceDAO {
	@Autowired
	private SqlMapClient client;
	// 근태 정보 리스트 불러오기
	@Override
	public ArrayList<AttendanceVO> getAttendanceList() throws SQLException {
		ArrayList<AttendanceVO> attendanceList = null;
		attendanceList = (ArrayList<AttendanceVO>) client.queryForList("attendance.getAttendanceList");
		return attendanceList;
	}
	// 근태 상세 정보 리스트 불러오기
	@Override
	public AttendanceVO getAttendanceDetailList(Map<String, String> info) throws SQLException {
		return (AttendanceVO) client.queryForObject("attendance.getAttendanceInformation", info);
	}
	// 근태 상세정보 수정
	@Override
	public void getAttendanceUpdate(Map<String, String> info) throws SQLException {
		client.update("attendance.attendanceUpdate", info);
	}
	// 부서 목록 불러오기 
	@Override
	public ArrayList<DepartVO> getDepartList() throws SQLException {
		return (ArrayList<DepartVO>) client.queryForList("attendance.getDepartList");
	}
	// 근태 상태 목록 불러오기
	@Override
	public ArrayList<WorkStateVO> getWorkStateList() throws SQLException {
		return (ArrayList<WorkStateVO>) client.queryForList("attendance.getWorkStateList");
	}
	// 근태 검색 결과(조건 : 날짜)
	@Override
	public ArrayList<AttendanceVO> getAttDefault(HashMap<String, String> params) throws SQLException {
		return (ArrayList<AttendanceVO>) client.queryForList("attendance.getAttDefault", params);
	}
	// 근태 검색 결과(조건 : 날짜,근태상태)
	@Override
	public ArrayList<AttendanceVO> getAttWithState(HashMap<String, String> params) throws SQLException {
		return (ArrayList<AttendanceVO>) client.queryForList("attendance.getAttWithState", params);
	}
	// 근태 검색 결과(조건 : 날짜,부서)
	@Override
	public ArrayList<AttendanceVO> getAttWithDepart(HashMap<String, String> params) throws SQLException {
		return (ArrayList<AttendanceVO>) client.queryForList("attendance.getAttWithDepart", params);
	}
	// 근태 검색 결과(조건 : 날짜,부서,근태상태)
	@Override
	public ArrayList<AttendanceVO> getAttWithDepartState(HashMap<String, String> params) throws SQLException {
		return (ArrayList<AttendanceVO>) client.queryForList("attendance.getAttWithDepartState", params);
	}
	// 근태 검색 결과(조건 : 날짜,사원명)
	@Override
	public ArrayList<AttendanceVO> getAttWithName(HashMap<String, String> params) throws SQLException {
		return (ArrayList<AttendanceVO>) client.queryForList("attendance.getAttWithName", params);
	}
	// 근태 검색 결과(조건 : 날짜,사원명,근태상태)
	@Override
	public ArrayList<AttendanceVO> getAttWithNameState(HashMap<String, String> params) throws SQLException {
		return (ArrayList<AttendanceVO>) client.queryForList("attendance.getAttWithNameState", params);
	}
	// 근태 검색 결과(조건 : 날짜,사원명, 부서)
	@Override
	public ArrayList<AttendanceVO> getAttWithNameDepart(HashMap<String, String> params) throws SQLException {
		return (ArrayList<AttendanceVO>) client.queryForList("attendance.getAttWithNameDepart", params);
	}
	// 근태 검색 결과(조건 : 날짜,사원명,부서,근태상태)
	@Override
	public ArrayList<AttendanceVO> getAttWithNameDepartState(HashMap<String, String> params) throws SQLException {
		return (ArrayList<AttendanceVO>) client.queryForList("attendance.getAttWithNameDepartState", params);
	}
	// 출근 처리
	@Override
	public int attendanceCheckIn(String mem_num) throws SQLException {
		return client.update("attendance.attendanceCheckIn", mem_num);
	}
	// 퇴근 처리
	@Override
	public int attendanceCheckOut(String mem_num) throws SQLException {
		return client.update("attendance.attendanceCheckOut", mem_num);
	}

}
