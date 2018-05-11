package com.groupware.main.service;

import java.util.List;

import com.groupware.dto.MemberVO;
import com.groupware.dto.MessageVO;

/**
 * @Class Name : IMainService.java
 * @Description : 메인, 메시지함 service interface
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
public interface IMainService {

	/**
	 * 메시지리스트
	 * 
	 * @param String id
	 * @return List<MessageVO>
	 * @throws 
	 */
	List<MessageVO> messageList(String id);

	/**
	 * 메시지 송신
	 * 
	 * @param MessageVO messageVO
	 * @return void
	 * @throws 
	 */
	void sendMessage(MessageVO messageVO);

	/**
	 * 메시지 상세보기
	 * 
	 * @param String code
	 * @return MessageVO
	 * @throws 
	 */
	MessageVO detailMessage(String code);

	/**
	 * 메시지 읽음 처리
	 * 
	 * @param String code
	 * @return void
	 * @throws 
	 */
	void readProcess(String code);

	/**
	 * 읽지 않은 메시지 확인
	 * 
	 * @param String id
	 * @return int
	 * @throws 
	 */
	int noneReadMsg(String id);

	/**
	 * 새 메시지 체크
	 * 
	 * @param String id
	 * @return void
	 * @throws 
	 */
	void newMsgCheck(String id);

	/**
	 * 새 메시지 알림
	 * 
	 * @param String id
	 * @return int
	 * @throws 
	 */
	int newMsgPush(String id);

	/**
	 * 메시지 삭제
	 * 
	 * @param MessageVO messageVO
	 * @return void
	 * @throws 
	 */
	void messageDelete(MessageVO messageVO);
	

}
