package com.groupware.main.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.dto.MemberVO;
import com.groupware.dto.MessageVO;
import com.groupware.main.dao.IMainDAO;

/**
 * @Class Name : MainServiceImpl.java
 * @Description : 메인, 메시지함 service class
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
public class MainServiceImpl implements IMainService {
	@Autowired
	private IMainDAO iMainDAO;
	
	//메시지 리스트
	@Override
	public List<MessageVO> messageList(String id) {
		List<MessageVO> messageList = null;
		try {
			messageList = iMainDAO.messageList(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return messageList;
	}
	
	//메시지 송신
	@Override
	public void sendMessage(MessageVO messageVO) {
		try {
			iMainDAO.sendMessage(messageVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//메시지 상세보기
	@Override
	public MessageVO detailMessage(String code) {
		MessageVO messageVO = null;
		try {
			messageVO = iMainDAO.detailMessage(code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return messageVO;
	}
	
	//메시지 읽음 처리
	@Override
	public void readProcess(String code) {
		try {
			iMainDAO.readProcess(code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//읽지 않은 메시지 확인
	@Override
	public int noneReadMsg(String id) {
		int res=0;
		try {
			res = iMainDAO.noneReadMsg(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	//새 메시지 체크
	@Override
	public void newMsgCheck(String id) {
		try {
			iMainDAO.newMsgCheck(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//새 메시지 알림
	@Override
	public int newMsgPush(String id) {
		int newMsgPush = 0;
		try {
			newMsgPush = iMainDAO.newMsgPush(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newMsgPush;
	}
	
	//메시지 삭제
	@Override
	public void messageDelete(MessageVO messageVO) {
		try {
			iMainDAO.messageDelete(messageVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
