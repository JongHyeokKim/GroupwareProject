package com.groupware.login.service;

import com.groupware.dto.MemberVO;

/**
 * @Class Name : ILoginService.java
 * @Description : 로그인 service interface
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
public interface ILoginService {
	
	/**
	 * 로그인
	 * 
	 * @param String id
	 * @return MemberVO
	 * @throws 
	 */
	MemberVO login(String id);
	
	/**
	 * 임시비밀번호 발송
	 * 
	 * @param String id, String reg
	 * @return String
	 * @throws 
	 */
	String passwordSend(String id, String reg);
}
