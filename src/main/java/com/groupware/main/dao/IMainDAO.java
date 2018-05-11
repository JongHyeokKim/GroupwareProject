package com.groupware.main.dao;

import java.sql.SQLException;
import java.util.List;

import com.groupware.dto.MemberVO;
import com.groupware.dto.MessageVO;

/**
 * @Class Name : IMainDAO.java
 * @Description : 메인, 메시지함 Interface
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
public interface IMainDAO {
	
	/**
	 * 메시지 리스트
	 * 
	 * @param String id
	 * @return List<MessageVO>
	 * @throws SQLException
	 */
	List<MessageVO> messageList(String id)throws SQLException;

	/**
	 * 메시지 송신
	 * 
	 * @param MessageVO messageVO
	 * @return void
	 * @throws SQLException
	 */
	void sendMessage(MessageVO messageVO)throws SQLException;

	/**
	 * 메시지 상세보기
	 * 
	 * @param String code
	 * @return MessageVO messageVO
	 * @throws SQLException
	 */
	MessageVO detailMessage(String code)throws SQLException;

	/**
	 * 메시지 읽음 처리
	 * 
	 * @param String code
	 * @return void
	 * @throws SQLException
	 */
	void readProcess(String code)throws SQLException;

	/**
	 * 읽지 않은 메시지 확인
	 * 
	 * @param String id
	 * @return int
	 * @throws SQLException
	 */
	int noneReadMsg(String id)throws SQLException;

	/**
	 * 새 메시지 체크
	 * 
	 * @param String id
	 * @return void
	 * @throws SQLException
	 */
	void newMsgCheck(String id)throws SQLException;

	/**
	 * 새 메시지 알림
	 * 
	 * @param String id
	 * @return int
	 * @throws SQLException
	 */
	int newMsgPush(String id)throws SQLException;

	/**
	 * 메시지 삭제
	 * 
	 * @param MessageVO messageVO
	 * @return void
	 * @throws SQLException
	 */
	void messageDelete(MessageVO messageVO)throws SQLException;


}
