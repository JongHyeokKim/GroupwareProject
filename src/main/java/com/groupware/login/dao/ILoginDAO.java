package com.groupware.login.dao;

import java.sql.SQLException;

import com.groupware.dto.MemberVO;

/**
 * @Class Name : ILoginDAO.java
 * @Description : 로그인 DAO Interface
 * @Modification Information
 * @author 이준수
 * @since  2016.09.01.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.09.01.   이준수             최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
public interface ILoginDAO {

	/**
	 * 로그인 처리
	 * 
	 * @param String id
	 * @return MemberVO
	 * @throws SQLException
	 */
	MemberVO login(String id) throws SQLException;


	/**
	 * 임시비밀번호 발송
	 * 
	 * @param String id, String reg, String encryptPwd
	 * @return int
	 * @throws SQLException
	 */
	int passwordSend(String id, String reg, String encryptPwd)throws SQLException;



}
