package com.groupware.attendance.service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.attendance.dao.IAttendanceDAO;
import com.groupware.dto.attendance.AttendanceVO;
import com.groupware.dto.attendance.DepartVO;
import com.groupware.dto.attendance.WorkStateVO;

/**
 * @Class Name : AttendanceServiceImpl.java
 * @Description : 관리자 근태 정보 및 관리를 위한 Service 클래스
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
@Service
public class AttendanceServiceImpl implements IAttendanceService {
	@Autowired
	private IAttendanceDAO dao;
	// 근태 정보 리스트 불러오기
	@Override
	public ArrayList<AttendanceVO> getAttendanceList() {
		ArrayList<AttendanceVO> attendanceList = null;
		try {
			attendanceList = dao.getAttendanceList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return attendanceList;
	}
	// 근태 상세정보 리스트 불러오기
	@Override
	public AttendanceVO getAttendanceDetailList(Map<String, String> info) {
		AttendanceVO attendanceVO = null;
		try {
			attendanceVO = dao.getAttendanceDetailList(info);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return attendanceVO;
	}
	// 근태 상세정보 수정
	@Override
	public void getAttendanceUpdate(Map<String, String> info) {
		try {
			dao.getAttendanceUpdate(info);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 부서 목록 불러오기
	@Override
	public ArrayList<DepartVO> getDepartList() {
		ArrayList<DepartVO> result = null;
		try {
			 result = dao.getDepartList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	// 근태 상태 목록 불러오기
	@Override
	public ArrayList<WorkStateVO> getWorkStateList() {
		ArrayList<WorkStateVO> result = null;
		try {
			result = dao.getWorkStateList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	// 근태 검색 결과(조건 : 날짜)
	@Override
	public ArrayList<AttendanceVO> getAttDefault(HashMap<String, String> params) {
		ArrayList<AttendanceVO> result = null;
		try {
			result = dao.getAttDefault(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	// 근태 검색 결과 (조건 : 날짜,근태상태)
	@Override
	public ArrayList<AttendanceVO> getAttWithState(HashMap<String, String> params) {
		ArrayList<AttendanceVO> result = null;
		try {
			result = dao.getAttWithState(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	// 근태 검색 결과 (조건 : 날짜,부서)
	@Override
	public ArrayList<AttendanceVO> getAttWithDepart(HashMap<String, String> params) {
		ArrayList<AttendanceVO> result = null;
		try {
			result = dao.getAttWithDepart(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	// 근태 검색 결과(조건 : 날짜,부서,근태상태)
	@Override
	public ArrayList<AttendanceVO> getAttWithDepartState(HashMap<String, String> params) {
		ArrayList<AttendanceVO> result = null;
		try {
			result = dao.getAttWithDepartState(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	// 근태 검색 결과(조건 : 날짜,사원명)
	@Override
	public ArrayList<AttendanceVO> getAttWithName(HashMap<String, String> params) {
		ArrayList<AttendanceVO> result = null;
		try {
			result = dao.getAttWithName(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	// 근태 검색 결과(조건 : 날짜,사원명,근태상태)
	@Override
	public ArrayList<AttendanceVO> getAttWithNameState(HashMap<String, String> params) {
		ArrayList<AttendanceVO> result = null;
		try {
			result = dao.getAttWithNameState(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	// 근태 검색 결과(조건 : 날짜,사원명,부서)
	@Override
	public ArrayList<AttendanceVO> getAttWithNameDepart(HashMap<String, String> params) {
		ArrayList<AttendanceVO> result = null;
		try {
			result = dao.getAttWithNameDepart(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	// 근태 검색 결과(조건 : 날짜,사원명,부서,근태상태)
	@Override
	public ArrayList<AttendanceVO> getAttWithNameDepartState(HashMap<String, String> params) {
		ArrayList<AttendanceVO> result = null;
		try {
			result = dao.getAttWithNameDepartState(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	// 출근 처리
	@Override
	public int attendanceCheckIn(String mem_num) {
		int result = 0;
		try {
			result = dao.attendanceCheckIn(mem_num);
		} catch (Exception e) {
			if(e.getCause() instanceof SQLIntegrityConstraintViolationException){
				return 2;
			}
			e.printStackTrace();
		} 
		return result;
	}
	// 퇴근 처리
	@Override
	public int attendanceCheckOut(String mem_num) {
		int result = 0; 
		try {
			result = dao.attendanceCheckOut(mem_num);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}

}
