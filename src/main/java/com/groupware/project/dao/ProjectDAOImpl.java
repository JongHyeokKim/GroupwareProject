package com.groupware.project.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupware.dto.EmployeeProjectVO;
import com.groupware.dto.MemberVO;
import com.groupware.dto.OpinionVO;
import com.groupware.dto.ProjectVO;
import com.ibatis.sqlmap.client.SqlMapClient;
/**
 * @Class Name : ProjectDAOImpl.java
 * @Description : 프로젝트, 개인일정 CRUD에 대한 DB연동 구현부
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
@Repository
public class ProjectDAOImpl implements IProjectDAO {
	@Autowired
	private SqlMapClient client;

	/**
	 * 프로젝트 전체 리스트 불러오기
	 * @param ()
	 * @return List<ProjectVO> 
	 * @throws SQLException
	 */
	@Override
	public List<ProjectVO> getCalendarList() throws SQLException {
		List<ProjectVO> list = client.queryForList("project.getCalendarList");
		return list;
	}

	/**
	 * 프로젝트 상세보기
	 * @param (String)
	 * @return ProjectVO 
	 * @throws SQLException
	 */
	@Override
	public ProjectVO getCalendar(String paramData) throws SQLException {
		ProjectVO projectVO = (ProjectVO) client.queryForObject(
				"project.getCalendar", paramData);
		return projectVO;
	}
	
	/**
	 * 프로젝트 삭제
	 * @param (int)
	 * @return void 
	 * @throws SQLException
	 */
	@Override
	public void deleteCalendar(int id) throws SQLException {
		client.delete("project.deleteCalendar", id);

	}

	/**
	 * 선택된 일정 번호 불러오기
	 * @param (ProjectVO)
	 * @return String
	 * @throws SQLException
	 */
	@Override
	public String findId(ProjectVO projectVO) throws SQLException {
		String id = (String) client.queryForObject("project.findId", projectVO);
		return id;
	}

	/**
	 * 프로젝트 수정
	 * @param (ProjectVO)
	 * @return void 
	 * @throws SQLException
	 */
	@Override
	public void modifyCalendar(ProjectVO projectVO) throws SQLException {
		client.update("project.modifyCalendar", projectVO);
		client.update("project.modifyCalendar2",projectVO.getPro_code());
	}
	
	/**
	 * 전체 프로젝트 등록
	 * @param (ProjectVO)
	 * @return String
	 * @throws SQLException
	 */
	@Override
	public String insertCalendar(ProjectVO projectVO) throws SQLException {
		return (String) client.insert("project.insertCalendar",projectVO);
		
	}

	/**
	 * 개인 일정 전체 불러오기
	 * @param (String)
	 * @return List<ProjectVO>
	 * @throws SQLException
	 */
	@Override
	public List<ProjectVO> getEmployeeList(String num) throws SQLException {
		List<ProjectVO> list = client.queryForList("project.employeeList",num);
		return list;
	}

	/**
	 * 개인 일정 등록
	 * @param (EmployeeProjectVO)
	 * @return void
	 * @throws SQLException
	 */
	@Override
	public void employeeInsertCalendar(EmployeeProjectVO employVO)
			throws SQLException {
		client.insert("project.employeeInserCalendar",employVO);
		
	}

	/**
	 * 개인 일정 수정
	 * @param (EmployeeProjectVO)
	 * @return void
	 * @throws SQLException
	 */
	@Override
	public void employeeModifyCalendar(EmployeeProjectVO employVO)
			throws SQLException {
		client.update("project.employeeModifyCalendar",employVO);
		
	}

	/**
	 * 선택된 개인일정 ID 불러오기
	 * @param (EmployeeProjectVO)
	 * @return String
	 * @throws SQLException
	 */
	@Override
	public String employeeFindId(EmployeeProjectVO employVO)
			throws SQLException {
		String id = (String) client.queryForObject("project.employeeFindId",employVO);
		return id;
	}

	/**
	 * 개인 일정 삭제
	 * @param (int)
	 * @return void
	 * @throws SQLException
	 */
	@Override
	public void employeeDeleteCalendar(int id) throws SQLException {
		client.delete("project.employeeDeleteCalendar",id);
		
	}

	/**
	 * 프로젝트 함께할 인원 추가
	 * @param (EmployeeProjectVO)
	 * @return void
	 * @throws SQLException
	 */
	@Override
	public void addMember(EmployeeProjectVO employVO) throws SQLException {
		client.insert("project.addProjectMember",employVO);
		
	}

	/**
	 * 선택된 프로젝트에 참여중인 인원 불러오기
	 * @param (String)
	 * @return List<MemberVO>
	 * @throws SQLException
	 */
	@Override
	public List<MemberVO> getProjectMembers(String choice_pro_code) throws SQLException {
		return client.queryForList("project.getProjectMembers",choice_pro_code);
	}

	/**
	 * 개인일정중 선택된 프로젝트에 참여중인 인원 불러오기
	 * @param (String)
	 * @return List<MemberVO>
	 * @throws SQLException
	 */
	@Override
	public List<MemberVO> getProjectMembers2(String choice_pro_code)
			throws SQLException {
		return client.queryForList("project.getProjectMembers2",choice_pro_code);
	}

	@Override
	public void addProjectDetail(String pro_code, String proDetail)
			throws SQLException {
		Map<String, String> detail = new HashMap<String, String>();
		detail.put("pro_code", pro_code);
		detail.put("pro_dt_mm", proDetail);
		client.update("project.addProjectDetail",detail);
		
	}

	@Override
	public List<ProjectVO> searchProject(String pro_nm) throws SQLException {
		return client.queryForList("project.searchProject",pro_nm); 
	}

	@Override
	public void insertOption(Map<String, String> map) throws SQLException {
		client.insert("project.insertOption",map);
		
	}

	@Override
	public List<OpinionVO> getOpinion(String op_pro_code)
			throws SQLException {
		return client.queryForList("project.getOpinion",op_pro_code);
	}
	
	
	public int totalRecord(String pro_nm) throws SQLException {
		int total_pages = 0;
		if (pro_nm.equals("")||pro_nm==null) {
			pro_nm = "%";
		}
		return total_pages = (Integer) client.queryForObject("project.totalRecord",pro_nm);
	}

	
	@Override
	public List<ProjectVO> listProject(int tpage, String pro_nm)
			throws SQLException {
		ArrayList<ProjectVO> projectList = new ArrayList<ProjectVO>();
		int startRow = -1;
		int endRow = -1;

		if (pro_nm.equals("")) {
			pro_nm = "%";
		}

		int totalRecord = totalRecord(pro_nm);

		startRow = (tpage - 1) * counts ;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;
		
		projectList=(ArrayList<ProjectVO>)client.queryForList("project.listProject",pro_nm, startRow, counts);
		return projectList;
	}
	static int counts = 10;
	static int view_rows = 9999;
	
	@Override
	public String pageNumber(int tpage, String name) throws SQLException {
		String str = "<li><a href='projectSchedule?tpage="+ (tpage-1) + "&pro_nm=" + name+ "'><<</a></li>";;

		int total_pages = totalRecord(name);
		int page_count = total_pages / counts + 1;

		if (total_pages % counts == 0) {
			page_count--;
		}
		if (tpage < 1) {
			tpage = 1;
		}

		int start_page = tpage - (tpage % view_rows) + 1;
		int end_page = start_page + (counts - 1);

		if (end_page > page_count) {
			end_page = page_count;
		}
		if (start_page > view_rows) {
			str += "<li><a href='projectSchedule?tpage=1&pro_nm="+ name + "'></a></li>";
			str += "<li><a href='projectSchedule?tpage="+ (start_page - 1)+"&pro_nm=<%=product_name%>"+(start_page - 1)+"</a></li>";
		}

		for (int i = start_page; i <= end_page; i++) {
			if (i == tpage) {
				str += "<li><a href='projectSchedule?tpage=" + i + "'>"+i+"</a></li>";
			} else {
				str += "<li><a href='projectSchedule?tpage="+ i + "&pro_nm=" + name + "'>"+ i + "</a></li>";
			}
		}

		if (page_count > end_page) {
			str += "<li><a href='projectSchedule?tpage="+ (end_page + 1) + "&pro_nm=" + name+ "'>"+(end_page + 1)+"</a>&nbsp;&nbsp;";
			str += "<li><a href='projectSchedule?tpage="+ page_count + "&pro_nm=" + name+ "'></a></li>";
		}
		str += "<li><a href='projectSchedule?tpage="+ (tpage+1) + "&pro_nm=" + name+ "'>>></a></li>";
		return str;
	}

	@Override
	public int getTotalRecord(String pro_nm) throws SQLException {
		int total_pages = 0;
		if (pro_nm.equals("")||pro_nm==null) {
			pro_nm = "%";
		}
		return total_pages = (Integer) client.queryForObject("project.totalRecord",pro_nm);
		
	}

	@Override
	public List<ProjectVO> getMainProjectList() throws SQLException {
		return client.queryForList("project.getMainProjectList");
	}

	@Override
	public void opinionDelete(String op_code) throws SQLException {
		client.delete("project.opinionDelete",op_code);
		
	}
}