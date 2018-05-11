package com.groupware.main.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupware.dto.MemberVO;
import com.groupware.dto.MessageVO;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @Class Name : MainDAOImpl.java
 * @Description : 메시지송신, 상세보기 및 수신리스트에 대한 DB연동 구현부
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
public class MainDAOImpl implements IMainDAO {
	@Autowired
	private SqlMapClient client;

	//메시지 리스트
	@Override
	public List<MessageVO> messageList(String id) throws SQLException {
		List<MessageVO> messageList = client.queryForList("message.messageList",id);
		return messageList;
	}

	//메시지 송신
	@Override
	public void sendMessage(MessageVO messageVO) throws SQLException {
		client.insert("message.sendMessage",messageVO);
	}

	//메시지 상세보기
	@Override
	public MessageVO detailMessage(String code) throws SQLException {
		MessageVO messageVO = (MessageVO) client.queryForObject("message.detailMessage",code);
		return messageVO;
	}

	//메시지 읽음 처리
	@Override
	public void readProcess(String code) throws SQLException {
		client.update("message.readProcess",code);
	}

	//읽지 않은 메시지 확인
	@Override
	public int noneReadMsg(String id) throws SQLException {
		int res = 0;
		res = (Integer) client.queryForObject("message.noneReadMsg",id);
		return res;
	}

	//새 메시지 체크
	@Override
	public void newMsgCheck(String id) throws SQLException {
		client.update("message.newMsgCheck",id);
	}

	//세 메시지 알림
	@Override
	public int newMsgPush(String id) throws SQLException {
		int newMsgPush = 0;
		newMsgPush = (Integer) client.queryForObject("message.newMsgPush",id);
		return newMsgPush;
	}

	//메시지 삭제
	@Override
	public void messageDelete(MessageVO messageVO) throws SQLException {
		client.delete("message.messageDelete", messageVO);
	}


}
