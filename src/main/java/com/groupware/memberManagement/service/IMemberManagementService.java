package com.groupware.memberManagement.service;

import java.util.List;

import com.groupware.dto.MemberVO;

/**
 * @Class Name : MemberManagementController.java
 * @Description : 사원관리 service interface
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

public interface IMemberManagementService {

	/**
	 * 사원리스트 불러오기
	 * @param : x
	 * @return  : x
	 * @throws  : SQLException
	 */
	public List<MemberVO> getMemberList();

	/**
	 * 사원등록
	 * @param : MemberVO memberVO
	 * @return  : memberInsert
	 * @throws  : SQLException
	 */
	public void memberInsert(MemberVO memberVO);

	/**
	 * 사원상세보기
	 * @param : String mem_num
	 * @return  : memberVO
	 * @throws  : SQLException
	 */
	public MemberVO getMemberDetail(String mem_num);

	/**
	 * 사원정보수정
	 * @param : MemberVO memberVO
	 * @return  : memberUpdate
	 * @throws  : SQLException
	 */
	public int memberUpdate(MemberVO memberVO);

	/**
	 * 사원명 검색
	 * @param : String searchKeyword
	 * @return  : searchList
	 * @throws  : SQLException
	 */
	public List<MemberVO> getSearchList(String searchKeyword);

	/**
	 * 부서별 검색
	 * @param : String searchKeyword
	 * @return  : searchList
	 * @throws  : SQLException
	 */
	public List<MemberVO> getSearchList1(String searchKeyword);
	
	/**
	 * 직급별 검색
	 * @param : String searchKeyword
	 * @return  : searchList
	 * @throws  : SQLException
	 */
	public List<MemberVO> getSearchList2(String searchKeyword);

	
	/**
	 * 퇴사자 검색
	 * @param : String searchKeyword
	 * @return  : searchList
	 * @throws  : SQLException
	 */
	public List<MemberVO> getSearchList3(String searchKeyword);

	/**
	 * 사원 이미지만 수정
	 * @param : MemberVO memberVO
	 * @return  : memberUpdate
	 * @throws  : SQLException
	 */
	public int memberUpdate1(MemberVO memberVO);

	/**
	 * 서명 이미지만 수정
	 * @param : MemberVO memberVO
	 * @return  : memberUpdate
	 * @throws  : SQLException
	 */
	public int memberUpdate2(MemberVO memberVO);

	/**
	 * 이미지 제외 정보만
	 * @param : MemberVO memberVO
	 * @return  : memberUpdate
	 * @throws  : SQLException
	 */
	public int memberUpdate3(MemberVO memberVO);

	/**
	 * 아이디 중복 체크
	 * @param : String
	 * @return  : check
	 * @throws  : SQLException
	 */
	public String check(String mem_num);
	

}
































