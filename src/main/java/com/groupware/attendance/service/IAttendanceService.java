package com.groupware.attendance.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.groupware.dto.attendance.AttendanceVO;
import com.groupware.dto.attendance.DepartVO;
import com.groupware.dto.attendance.WorkStateVO;
/**
 * @Interface Name : IAttendanceService.java
 * @Description : 관리자 근태 정보 및 관리를 위한 Service Interface
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
public interface IAttendanceService {
	/**
	 * 근태 정보 리스트 불러오기
	 * 
	 * @param none
	 * @return ArrayList<AttendanceVO>
	 * @throws none
	 */
	public ArrayList<AttendanceVO> getAttendanceList(); //리스트
	/**
	 * 근태 상세정보 리스트 불러오기
	 * 
	 * @param (Map<String, String>)
	 * @return AttendanceVO
	 * @throws none
	 */
	public AttendanceVO getAttendanceDetailList(Map<String, String> info);//상세보기
	/**
	 * 근태 상세정보 수정
	 * 
	 * @param (Map<String, String>)
	 * @return none
	 * @throws none
	 */
	public void getAttendanceUpdate(Map<String, String> info); //업데이트
	/**
	 * 부서 목록 불러오기
	 * 
	 * @param none
	 * @return ArrayList<DepartVO>
	 * @throws none
	 */
	public ArrayList<DepartVO> getDepartList();  // 부서 리스트
	/**
	 * 근태 상태 목록 불러오기
	 * 
	 * @param none
	 * @return ArrayList<WorkStateVO>
	 * @throws none
	 */
	public ArrayList<WorkStateVO> getWorkStateList();
	/**
	 * 근태 검색 결과 (조건 : 날짜)
	 * 
	 * @param HashMap<String, String>
	 * @return ArrayList<AttendanceVO>
	 * @throws none
	 */
	public ArrayList<AttendanceVO> getAttDefault(HashMap<String, String> params);
	/**
	 * 근태 검색 결과 (조건 : 날짜,근태상태)
	 * 
	 * @param HashMap<String, String>
	 * @return ArrayList<AttendanceVO>
	 * @throws none
	 */
	public ArrayList<AttendanceVO> getAttWithState(HashMap<String, String> params);
	/**
	 * 근태 검색 결과 (조건 : 날짜,부서)
	 * 
	 * @param HashMap<String, String>
	 * @return ArrayList<AttendanceVO>
	 * @throws none
	 */
	public ArrayList<AttendanceVO> getAttWithDepart(HashMap<String, String> params);
	/**
	 * 근태 검색 결과 (조건 : 날짜,부서,근태상태)
	 * 
	 * @param HashMap<String, String>
	 * @return ArrayList<AttendanceVO>
	 * @throws none
	 */
	public ArrayList<AttendanceVO> getAttWithDepartState(HashMap<String, String> params);
	/**
	 * 근태 검색 결과 (조건 : 날짜,사원명)
	 * 
	 * @param HashMap<String, String>
	 * @return ArrayList<AttendanceVO>
	 * @throws none
	 */
	public ArrayList<AttendanceVO> getAttWithName(HashMap<String, String> params);
	/**
	 * 근태 검색 결과 (조건 : 날짜,사원명,근태상태)
	 * 
	 * @param HashMap<String, String>
	 * @return ArrayList<AttendanceVO>
	 * @throws none
	 */
	public ArrayList<AttendanceVO> getAttWithNameState(HashMap<String, String> params);
	/**
	 * 근태 검색 결과 (조건 : 날짜,사원명,부서)
	 * 
	 * @param HashMap<String, String>
	 * @return ArrayList<AttendanceVO>
	 * @throws none
	 */
	public ArrayList<AttendanceVO> getAttWithNameDepart(HashMap<String, String> params);
	/**
	 * 근태 검색 결과 (조건 : 날짜,사원명,부서,근태상태)
	 * 
	 * @param HashMap<String, String>
	 * @return ArrayList<AttendanceVO>
	 * @throws none
	 */
	public ArrayList<AttendanceVO> getAttWithNameDepartState(HashMap<String, String> params);
	/**
	 * 출근 처리
	 * 
	 * @param String
	 * @return int
	 * @throws none
	 */
	public int attendanceCheckIn(String string);
	/**
	 * 퇴근 처리
	 * 
	 * @param String
	 * @return int
	 * @throws none
	 */
	public int attendanceCheckOut(String mem_num);
}
