package com.groupware.login.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupware.dto.MemberVO;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @Class Name : LoginDAOImpl.java
 * @Description : 로그인 처리 및 임시 비밀번호 발송에 대한 DB연동 구현부
 * @Modification Information
 * @author 이준수
 * @since  2016.09.01.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    	수정일            수정자                    수정내용
 *    -------      -------     -------------------
 *   2016.09.01.    이준수                    최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
@Repository
public class LoginDAOImpl implements ILoginDAO {
	@Autowired
	private SqlMapClient client;	
	
	//로그인 처리
	@Override
	public MemberVO login(String id)throws SQLException {
		MemberVO member = (MemberVO) client.queryForObject("member.login", id);
		return member;
	}


	//임시비밀번호 발송
	@Override
	public int passwordSend(String id, String reg, String encryptPwd) throws SQLException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("reg", reg);
		map.put("encryptPwd", encryptPwd);
		return client.update("member.passwordSend",map);
	}


}
