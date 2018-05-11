package com.groupware.memberManagement.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupware.dto.MemberVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class MemberManagementDAOImpl implements IMemberManagementDAO {

	@Autowired
	private SqlMapClient client;
	
	//사원리스트 불러오기
	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		
		List<MemberVO> memberList = null;
		memberList = client.queryForList("member.getMemberList");
		return memberList;
	}

	//사원등록
	@Override
	public void memberInsert(MemberVO memberVO) throws SQLException {
		client.insert("member.memberInsert", memberVO);
	}

	//상세보기
	@Override
	public MemberVO getMemberDetail(String mem_num) throws SQLException {
		MemberVO memberVO = null;
		
		memberVO = (MemberVO) client.queryForObject("member.getMemberDetail",mem_num);
		return memberVO;
	}

	//사원정보수정
	@Override
	public int memberUpdate(MemberVO memberVO) throws SQLException {
		
		int memberUpdate = 0;
		memberUpdate = client.update("member.memberUpdate", memberVO);
		return memberUpdate;
	}
	
	//사원이미지수정
	@Override
	public int memberUpdate1(MemberVO memberVO) throws SQLException {
		int memberUpdate1 = 0;
		memberUpdate1 = client.update("member.memberUpdate1", memberVO);
		return memberUpdate1;
	}
	
	//서명이미지수정
	@Override
	public int memberUpdate2(MemberVO memberVO) throws SQLException {
		int memberUpdate2 = 0;
		memberUpdate2 = client.update("member.memberUpdate2", memberVO);
		return memberUpdate2;
	}
	
	//이미지 제외 정보 수정
	@Override
	public int memberUpdate3(MemberVO memberVO) throws SQLException {
		int memberUpdate3 = 0;
		memberUpdate3 = client.update("member.memberUpdate3", memberVO);
		return memberUpdate3;
	}

	//사원 검색
	@Override
	public List<MemberVO> getSearchList(String searchKeyword) throws SQLException{
		
		List<MemberVO> searchList = null;
		searchList = client.queryForList("member.getSearchList", searchKeyword);
		return searchList;
	}
	
	//부서별 검색
	@Override
	public List<MemberVO> getSearchList1(String searchKeyword) throws SQLException{
		
		List<MemberVO> searchList = null;
		searchList = client.queryForList("member.getSearchList1", searchKeyword);
		return searchList;
	}
	
	//직급별 검색
	@Override
	public List<MemberVO> getSearchList2(String searchKeyword) throws SQLException{
		
		List<MemberVO> searchList = null;
		searchList = client.queryForList("member.getSearchList2", searchKeyword);
		return searchList;
	}

	//퇴사자 검색
	@Override
	public List<MemberVO> getSearchList3(String searchKeyword) throws SQLException {

		List<MemberVO> searchList = null;
		searchList = client.queryForList("member.getSearchList3", searchKeyword);
		return searchList;
	}

	//아이디 중복 체크
	@Override
	public String check(String mem_num) throws SQLException {
		String check = (String) client.queryForObject("member.check",mem_num);
		return check;
	}
}














