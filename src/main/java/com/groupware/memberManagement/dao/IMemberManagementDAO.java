package com.groupware.memberManagement.dao;

import java.sql.SQLException;
import java.util.List;

import com.groupware.dto.MemberVO;
/**
 * @Class Name : IMemberManagementDAO.java
 * @Description : 사원관리 Interface
 * @Modification Information
 * @author 김성수
 * @since  2016.08.30.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.08.30.   김성수             최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
public interface IMemberManagementDAO {

	/**
	 * 사원리스트 불러오기
	 * @param : x
	 * @return  : x
	 * @throws  : SQLException
	 */
	public List<MemberVO> getMemberList() throws SQLException;

	/**
	 * 사원등록
	 * @param : MemberVO memberVO
	 * @return  : memberInsert
	 * @throws  : SQLException
	 */
	public void memberInsert(MemberVO memberVO) throws SQLException;

	/**
	 * 사원상세보기
	 * @param : String mem_num
	 * @return  : memberVO
	 * @throws  : SQLException
	 */
	public MemberVO getMemberDetail(String mem_num) throws SQLException;

	/**
	 * 사원정보수정
	 * @param : MemberVO memberVO
	 * @return  : memberUpdate
	 * @throws  : SQLException
	 */
	public int memberUpdate(MemberVO memberVO) throws SQLException;

	/**
	 * 사원명 검색
	 * @param : String searchKeyword
	 * @return  : searchList
	 * @throws  : SQLException
	 */
	public List<MemberVO> getSearchList(String searchKeyword) throws SQLException;

	/**
	 * 부서별 검색
	 * @param : String searchKeyword
	 * @return  : searchList
	 * @throws  : SQLException
	 */
	public List<MemberVO> getSearchList1(String searchKeyword) throws SQLException;
	
	/**
	 * 직급별 검색
	 * @param : String searchKeyword
	 * @return  : searchList
	 * @throws  : SQLException
	 */
	public List<MemberVO> getSearchList2(String searchKeyword) throws SQLException;

	/**
	 * 퇴사자 검색
	 * @param : String searchKeyword
	 * @return  : searchList
	 * @throws  : SQLException
	 */
	public List<MemberVO> getSearchList3(String searchKeyword) throws SQLException;

	
	/**
	 * 사원 이미지 수정
	 * @param : MemberVO memberVO
	 * @return  : memberUpdate
	 * @throws  : SQLException
	 */
	public int memberUpdate1(MemberVO memberVO) throws SQLException;
	
	/**
	 * 서명 이미지 수정
	 * @param : MemberVO memberVO
	 * @return  : memberUpdate
	 * @throws  : SQLException
	 */
	public int memberUpdate2(MemberVO memberVO) throws SQLException;

	/**
	 * 이미지 제외 정보 수정
	 * @param : MemberVO memberVO
	 * @return  : memberUpdate
	 * @throws  : SQLException
	 */
	public int memberUpdate3(MemberVO memberVO) throws SQLException;

	/**
	 * 아이디 중복 체크
	 * @param : String
	 * @return  : check
	 * @throws  : SQLException
	 */
	public String check(String mem_num) throws SQLException;

}





















