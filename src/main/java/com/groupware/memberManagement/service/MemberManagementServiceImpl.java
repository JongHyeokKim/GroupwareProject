package com.groupware.memberManagement.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.groupware.dto.MemberVO;
import com.groupware.memberManagement.dao.IMemberManagementDAO;

/**
 * @Class Name : MemberManagementServiceImpl.java
 * @Description : 사원관리 service class
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
@Service
public class MemberManagementServiceImpl implements IMemberManagementService {

	@Autowired
	private IMemberManagementDAO memberDAO;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	//사원리스트
	@Override
	public List<MemberVO> getMemberList() {
		List<MemberVO> memberList = null;
		try {
			memberList = memberDAO.getMemberList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}

	//사원등록
	@Override
	public void memberInsert(MemberVO memberVO){
		String bCryptString = null;
	      if(StringUtils.hasText(memberVO.getMem_pw())){
	         // 암호화 작업
	         bCryptString = passwordEncoder.encode(memberVO.getMem_pw());
	         memberVO.setMem_pw(bCryptString);
	      }
		try {
			memberDAO.memberInsert(memberVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	   }

	//상세보기
	@Override
	public MemberVO getMemberDetail(String mem_num) {
		MemberVO memberVO = null;
		try {
			memberVO = memberDAO.getMemberDetail(mem_num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberVO;
	}

	//사원정보수정
	@Override
	public int memberUpdate(MemberVO memberVO) {
		
		int memberUpdate = 0;
		try {
			memberUpdate = memberDAO.memberUpdate(memberVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberUpdate;
	}
	
	//사원이미지 수정
	@Override
	public int memberUpdate1(MemberVO memberVO) {
		int memberUpdate1 = 0;
		try {
			memberUpdate1 = memberDAO.memberUpdate1(memberVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberUpdate1;
	}
	
	//서명 이미지 수정
	@Override
	public int memberUpdate2(MemberVO memberVO) {
		int memberUpdate2 = 0;
		try {
			memberUpdate2 = memberDAO.memberUpdate2(memberVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberUpdate2;
	}

	//이미지 제외 정보 수정
	@Override
	public int memberUpdate3(MemberVO memberVO) {
		int memberUpdate3 = 0;
		try {
			memberUpdate3 = memberDAO.memberUpdate3(memberVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberUpdate3;
	}

	//사원명검색
	@Override
	public List<MemberVO> getSearchList(String searchKeyword) {
		List<MemberVO> searchList = null;
		try {
			searchList = memberDAO.getSearchList(searchKeyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return searchList;
	}

	//부서별검색
	@Override
	public List<MemberVO> getSearchList1(String searchKeyword) {
		List<MemberVO> searchList = null;
		try {
			searchList = memberDAO.getSearchList1(searchKeyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return searchList;
	}
	
	//직급별검색
	@Override
	public List<MemberVO> getSearchList2(String searchKeyword) {
		List<MemberVO> searchList = null;
		try {
			searchList = memberDAO.getSearchList2(searchKeyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return searchList;
	}

	//퇴사자검색
	@Override
	public List<MemberVO> getSearchList3(String searchKeyword) {
		List<MemberVO> searchList = null;
		try {
			searchList = memberDAO.getSearchList3(searchKeyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return searchList;
	}

	//아이디 중복 체크
	@Override
	public String check(String mem_num) {
		String check = null;
		try {
			check = memberDAO.check(mem_num);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}




}




















