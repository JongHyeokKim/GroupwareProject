package com.groupware.project.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.dto.EmployeeProjectVO;
import com.groupware.dto.MemberVO;
import com.groupware.dto.OpinionVO;
import com.groupware.dto.ProjectVO;
import com.groupware.project.dao.IProjectDAO;

/**
 * @Class Name : ProjectServiceImpl.java
 * @Description : 프로젝트, 개인일정 CRUD에 대한 Service클래스
 * @Modification Information
 * @author 정준호
 * @since 2016.09.01.
 * @version 1.0
 * @see <pre>
 * << 개정이력(Modification Information) >>
 *    	수정일            수정자                    수정내용
 *    -------      -------     -------------------
 *   2016.09.01.    정준호                    최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
@Service
public class ProjectServiceImpl implements IProjectService {
	@Autowired
	private IProjectDAO dao;

	/**
	 * 프로젝트 전체 리스트 불러오기
	 * 
	 * @param ()
	 * @return List<ProjectVO>
	 * @throws SQLException
	 */
	@Override
	public List<ProjectVO> getCalendarList() throws SQLException {
		List<ProjectVO> list = dao.getCalendarList();
		return list;
	}

	/**
	 * 프로젝트 상세보기
	 * 
	 * @param (String)
	 * @return ProjectVO
	 * @throws SQLException
	 */
	@Override
	public ProjectVO getCalendar(String paramData) throws SQLException {
		ProjectVO projectVO = dao.getCalendar(paramData);
		return projectVO;
	}

	/**
	 * 프로젝트 삭제
	 * 
	 * @param (int)
	 * @return void
	 * @throws SQLException
	 */
	@Override
	public void deleteCalendar(int id) throws SQLException {
		dao.deleteCalendar(id);

	}

	/**
	 * 선택된 일정 번호 불러오기
	 * 
	 * @param (ProjectVO)
	 * @return String
	 * @throws SQLException
	 */
	@Override
	public String findId(ProjectVO projectVO) throws SQLException {
		String id = dao.findId(projectVO);
		return id;
	}

	/**
	 * 프로젝트 수정
	 * 
	 * @param (ProjectVO)
	 * @return void
	 * @throws SQLException
	 */
	@Override
	public void modifyCalendar(ProjectVO projectVO) throws SQLException {
		dao.modifyCalendar(projectVO);

	}

	/**
	 * 전체 프로젝트 등록
	 * 
	 * @param (ProjectVO)
	 * @return String
	 * @throws SQLException
	 */
	@Override
	public String insertCalendar(ProjectVO projectVO) throws SQLException {
		return dao.insertCalendar(projectVO);

	}

	/**
	 * 개인 일정 전체 불러오기
	 * 
	 * @param (String)
	 * @return List<ProjectVO>
	 * @throws SQLException
	 */
	@Override
	public List<ProjectVO> getEmployeeList(String num) throws SQLException {
		List<ProjectVO> list = dao.getEmployeeList(num);
		return list;
	}

	/**
	 * 개인 일정 등록
	 * 
	 * @param (EmployeeProjectVO)
	 * @return void
	 * @throws SQLException
	 */
	@Override
	public void employeeInsertCalendar(EmployeeProjectVO employVO)
			throws SQLException {
		dao.employeeInsertCalendar(employVO);

	}

	/**
	 * 개인 일정 수정
	 * 
	 * @param (EmployeeProjectVO)
	 * @return void
	 * @throws SQLException
	 */
	@Override
	public void employeeModifyCalendar(EmployeeProjectVO employVO)
			throws SQLException {
		dao.employeeModifyCalendar(employVO);

	}

	/**
	 * 선택된 개인일정 ID 불러오기
	 * 
	 * @param (EmployeeProjectVO)
	 * @return String
	 * @throws SQLException
	 */
	@Override
	public String employeeFindId(EmployeeProjectVO employVO)
			throws SQLException {
		String id = dao.employeeFindId(employVO);
		return id;
	}

	/**
	 * 개인 일정 삭제
	 * 
	 * @param (int)
	 * @return void
	 * @throws SQLException
	 */
	@Override
	public void employeeDeleteCalendar(int id) throws SQLException {
		dao.employeeDeleteCalendar(id);

	}

	/**
	 * 프로젝트 함께할 인원 추가
	 * 
	 * @param (EmployeeProjectVO)
	 * @return void
	 * @throws SQLException
	 */
	@Override
	public void addMember(EmployeeProjectVO employVO) throws SQLException {
		dao.addMember(employVO);

	}

	/**
	 * 선택된 프로젝트에 참여중인 인원 불러오기
	 * 
	 * @param (String)
	 * @return List<MemberVO>
	 * @throws SQLException
	 */
	@Override
	public List<MemberVO> getProjectMembers(String choice_pro_code)
			throws SQLException {
		return dao.getProjectMembers(choice_pro_code);
	}

	/**
	 * 개인일정중 선택된 프로젝트에 참여중인 인원 불러오기
	 * 
	 * @param (String)
	 * @return List<MemberVO>
	 * @throws SQLException
	 */
	@Override
	public List<MemberVO> getProjectMembers2(String choice_pro_code)
			throws SQLException {
		return dao.getProjectMembers2(choice_pro_code);
	}

	@Override
	public void addProjectDetail(String pro_code, String proDetail)
			throws SQLException {
		dao.addProjectDetail(pro_code, proDetail);

	}

	@Override
	public void insertOption(Map<String, String> map) throws SQLException {
		dao.insertOption(map);

	}

	@Override
	public String pageNumber(int tpage, String pro_nm) throws SQLException {
		return dao.pageNumber(tpage, pro_nm);
	}

	@Override
	public List<OpinionVO> getOpinion(String pro_code) throws SQLException {
		return dao.getOpinion(pro_code);
	}

	@Override
	public List<ProjectVO> listProject(int tpage, String pro_nm)
			throws SQLException {
		return dao.listProject(tpage, pro_nm);
	}

	@Override
	public int getTotalRecord(String pro_nm) throws SQLException {
		return dao.getTotalRecord(pro_nm);
	}

	@Override
	public List<ProjectVO> getMainProjectList() throws SQLException {
		return dao.getMainProjectList();
	}

	@Override
	public void opinionDelete(String op_code) throws SQLException {
		dao.opinionDelete(op_code);
	}

}
