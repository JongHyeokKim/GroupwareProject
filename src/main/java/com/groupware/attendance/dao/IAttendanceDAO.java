package com.groupware.attendance.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.groupware.dto.attendance.AttendanceVO;
import com.groupware.dto.attendance.DepartVO;
import com.groupware.dto.attendance.WorkStateVO;
/**
 * @Interface Name : IAttendanceDAO.java
 * @Description : 관리자 근태 정보 및 관리를 위한 DAO Interface
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
public interface IAttendanceDAO {
	/**
	 * 근태 정보 리스트 불러오기
	 * 
	 * @param none
	 * @return ArrayList<AttendanceVO>
	 * @throws SQLException
	 */
	ArrayList<AttendanceVO> getAttendanceList()throws SQLException;
	/**
	 * 근태 상세정보 리스트 불러오기
	 * 
	 * @param (Map<String, String>)
	 * @return AttendanceVO
	 * @throws SQLException
	 */
	AttendanceVO getAttendanceDetailList(Map<String, String> info) throws SQLException;
	/**
	 * 근태 상세정보 수정
	 * 
	 * @param (Map<String, String>)
	 * @return none
	 * @throws SQLException
	 */
	void getAttendanceUpdate(Map<String, String> info)throws SQLException;
	/**
	 * 부서 목록 불러오기
	 * 
	 * @param none
	 * @return ArrayList<DepartVO>
	 * @throws SQLException
	 */
	ArrayList<DepartVO> getDepartList() throws SQLException;
	/**
	 * 근태 상태 목록 불러오기
	 * 
	 * @param none
	 * @return ArrayList<WorkStateVO>
	 * @throws SQLException
	 */
	ArrayList<WorkStateVO> getWorkStateList() throws SQLException;
	/**
	 * 근태 검색 결과 (조건 : 날짜)
	 * 
	 * @param HashMap<String, String>
	 * @return ArrayList<AttendanceVO>
	 * @throws SQLException
	 */
	public ArrayList<AttendanceVO> getAttDefault(HashMap<String, String> params) throws SQLException;
	/**
	 * 근태 검색 결과 (조건 : 날짜,근태상태)
	 * 
	 * @param HashMap<String, String>
	 * @return ArrayList<AttendanceVO>
	 * @throws SQLException
	 */
	public ArrayList<AttendanceVO> getAttWithState(HashMap<String, String> params) throws SQLException;
	/**
	 * 근태 검색 결과 (조건 : 날짜,부서)
	 * 
	 * @param HashMap<String, String>
	 * @return ArrayList<AttendanceVO>
	 * @throws SQLException
	 */
	public ArrayList<AttendanceVO> getAttWithDepart(HashMap<String, String> params) throws SQLException;
	/**
	 * 근태 검색 결과 (조건 : 날짜,부서,근태상태)
	 * 
	 * @param HashMap<String, String>
	 * @return ArrayList<AttendanceVO>
	 * @throws SQLException
	 */
	public ArrayList<AttendanceVO> getAttWithDepartState(HashMap<String, String> params) throws SQLException;
	/**
	 * 근태 검색 결과 (조건 : 날짜,사원명)
	 * 
	 * @param HashMap<String, String>
	 * @return ArrayList<AttendanceVO>
	 * @throws SQLException
	 */
	public ArrayList<AttendanceVO> getAttWithName(HashMap<String, String> params) throws SQLException;
	/**
	 * 근태 검색 결과 (조건 : 날짜,사원명,근태상태)
	 * 
	 * @param HashMap<String, String>
	 * @return ArrayList<AttendanceVO>
	 * @throws SQLException
	 */
	public ArrayList<AttendanceVO> getAttWithNameState(HashMap<String, String> params) throws SQLException;
	/**
	 * 근태 검색 결과 (조건 : 날짜,사원명,부서)
	 * 
	 * @param HashMap<String, String>
	 * @return ArrayList<AttendanceVO>
	 * @throws SQLException
	 */
	public ArrayList<AttendanceVO> getAttWithNameDepart(HashMap<String, String> params) throws SQLException;
	/**
	 * 근태 검색 결과 (조건 : 날짜,사원명,부서,근태상태)
	 * 
	 * @param HashMap<String, String>
	 * @return ArrayList<AttendanceVO>
	 * @throws SQLException
	 */
	public ArrayList<AttendanceVO> getAttWithNameDepartState(HashMap<String, String> params) throws SQLException;
	/**
	 * 출근 처리
	 * 
	 * @param String
	 * @return int
	 * @throws SQLException
	 */
	int attendanceCheckIn(String mem_num) throws SQLException;
	/**
	 * 퇴근 처리
	 * 
	 * @param String
	 * @return int
	 * @throws SQLException
	 */
	int attendanceCheckOut(String mem_num) throws SQLException;

}
