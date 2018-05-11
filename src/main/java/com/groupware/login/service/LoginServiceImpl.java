package com.groupware.login.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.groupware.dto.MemberVO;
import com.groupware.login.dao.ILoginDAO;

/**
 * @Class Name : MemberManagementServiceImpl.java
 * @Description : 로그인 service class
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
@Service
public class LoginServiceImpl implements ILoginService {
	@Autowired
	private ILoginDAO loginDAO;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	//로그인 처리
	@Override
	public MemberVO login(String id) {
		MemberVO memberVO=null;
		try {
			memberVO = loginDAO.login(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memberVO;
	}

	//임시비밀번호 발송
	@Override
	public String passwordSend(String id, String reg) {
		String tempPwd = "";
		String encryptPwd = "";
		try {
			  for(int i = 0; i < 8; i++){
			   char lowerStr = (char)(Math.random() * 26 + 97);
			   if(i%2 == 0){
				   tempPwd += (int)(Math.random() * 10);
			   }else{
				   tempPwd += lowerStr;
			   }
			  }
				if(StringUtils.hasText(tempPwd)){
					// 암호화 작업
					encryptPwd = passwordEncoder.encode(tempPwd);
				}
			 
			loginDAO.passwordSend(id,reg,encryptPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tempPwd;
	}
	
}
