package com.groupware.project.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.groupware.dto.EmployeeProjectVO;
import com.groupware.dto.MemberVO;
import com.groupware.dto.OpinionVO;
import com.groupware.dto.ProjectVO;
/**
 * @Class Name : IProjectDAO.java
 * @Description : 프로젝트, 개인일정 CRUD에 대한 ineterface
 * @Modification Information
 * @author 정준호
 * @since  2016.09.01.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    	수정일            수정자                    수정내용
 *    -------      -------     -------------------
 *   2016.09.01.    정준호                    최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
public interface IProjectDAO {
	/**
	 * 프로젝트 전체 리스트 불러오기
	 * @param ()
	 * @return List<ProjectVO> 
	 * @throws SQLException
	 */
	List<ProjectVO> getCalendarList() throws SQLException;

	/**
	 * 전체 프로젝트 등록
	 * @param (ProjectVO)
	 * @return String
	 * @throws SQLException
	 */
	String insertCalendar(ProjectVO projectVO)throws SQLException;
	
	/**
	 * 프로젝트 상세보기
	 * @param (String)
	 * @return ProjectVO 
	 * @throws SQLException
	 */
	ProjectVO getCalendar(String paramData)throws SQLException;

	/**
	 * 프로젝트 수정
	 * @param (ProjectVO)
	 * @return void 
	 * @throws SQLException
	 */
	void modifyCalendar(ProjectVO projectVO)throws SQLException;
	
	/**
	 * 프로젝트 삭제
	 * @param (int)
	 * @return void 
	 * @throws SQLException
	 */
	void deleteCalendar(int id)throws SQLException;
	
	/**
	 * 선택된 일정 번호 불러오기
	 * @param (ProjectVO)
	 * @return String
	 * @throws SQLException
	 */
	String findId(ProjectVO projectVO)throws SQLException;
	
	/**
	 * 개인 일정 전체 불러오기
	 * @param (String)
	 * @return List<ProjectVO>
	 * @throws SQLException
	 */
	List<ProjectVO> getEmployeeList(String num)throws SQLException;

	/**
	 * 개인 일정 등록
	 * @param (EmployeeProjectVO)
	 * @return void
	 * @throws SQLException
	 */
	void employeeInsertCalendar(EmployeeProjectVO employVO)throws SQLException;
	
	/**
	 * 개인 일정 수정
	 * @param (EmployeeProjectVO)
	 * @return void
	 * @throws SQLException
	 */
	void employeeModifyCalendar(EmployeeProjectVO employVO)throws SQLException;
	
	/**
	 * 개인 일정 삭제
	 * @param (int)
	 * @return void
	 * @throws SQLException
	 */
	void employeeDeleteCalendar(int id)throws SQLException;

	/**
	 * 선택된 개인일정 ID 불러오기
	 * @param (EmployeeProjectVO)
	 * @return String
	 * @throws SQLException
	 */
	String employeeFindId(EmployeeProjectVO employVO)throws SQLException;

	/**
	 * 프로젝트 함께할 인원 추가
	 * @param (EmployeeProjectVO)
	 * @return void
	 * @throws SQLException
	 */
	void addMember(EmployeeProjectVO employVO)throws SQLException;

	/**
	 * 선택된 프로젝트에 참여중인 인원 불러오기
	 * @param (String)
	 * @return List<MemberVO>
	 * @throws SQLException
	 */
	List<MemberVO> getProjectMembers(String choice_pro_code)throws SQLException;
	
	
	/**
	 * 개인일정중 선택된 프로젝트에 참여중인 인원 불러오기
	 * @param (String)
	 * @return List<MemberVO>
	 * @throws SQLException
	 */
	List<MemberVO> getProjectMembers2(String choice_pro_code)throws SQLException;

	void addProjectDetail(String pro_code, String proDetail)throws SQLException;

	List<ProjectVO> searchProject(String pro_nm)throws SQLException;

	void insertOption(Map<String, String> map)throws SQLException;

	List<OpinionVO> getOpinion(String pro_code)throws SQLException;
	String pageNumber(int tpage, String pro_nm)throws SQLException;
	List<ProjectVO> listProject(int tpage, String pro_nm)throws SQLException;

	int getTotalRecord(String pro_nm)throws SQLException;

	List<ProjectVO> getMainProjectList()throws SQLException;

	void opinionDelete(String op_code)throws SQLException;

}
