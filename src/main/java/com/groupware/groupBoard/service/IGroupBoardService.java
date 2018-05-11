package com.groupware.groupBoard.service;

import java.util.List;

import com.groupware.dto.BoardVO;

public interface IGroupBoardService {
	/**
	 * @Class Name : IGroupBoardService.java
	 * @Description : 게시판 조회/등록/수정/삭제/ 기능 메서드 모음
	 * @Modification service
	 * @author 함박눈
	 * @since  2016.08.29.
	 * @version 1.0
	 * @see
	 * <pre>
	 * << 개정이력(Modification Information) >>
	 *    수정일       수정자          수정내용
	 *    -------      -------     -------------------
	 *    2016.08.29.  함박눈        최초생성
	 * Copyright (c) 2016 by DDIT  All right reserved
	 * </pre>
	 */
	
	/**
	 * 공지사항 리스트조회
	 * 
	 * @param 
	 * @return 
	 * @throws 
	 */
	public List<BoardVO> getNoticeList();
	/**
	 * 사내뉴스 리스트조회
	 * @param 
	 * @return 
	 * @throws 
	 */
	public List<BoardVO> getWorkNewsList();
	/**
	 * 공지사항 상세조회
	 * 
	 * @param String
	 * @return 
	 * @throws 
	 */
	public BoardVO getWorkNewsInformation(String br_wrt_num);
	/**
	 * 사내뉴스 상세조회
	 * 
	 * @param String
	 * @return 
	 * @throws 
	 */
	public BoardVO getNoticeInformation(String br_wrt_num);
	/**
	 * 공지사항 등록
	 * 
	 * @param BoardVO
	 * @return 
	 * @throws 
	 */
	public void getNoticeWriteCom(BoardVO boardVO);
	/**
	 * 사내뉴스 등록
	 * 
	 * @param BoardVO
	 * @return 
	 * @throws 
	 */
	public void getWorkNewsWriteCom(BoardVO boardVO);
	/**
	 * 공지사항 수정
	 * 
	 * @param BoardVO
	 * @return 
	 * @throws 
	 */
	public int getNoticeUpdate(BoardVO boardVO);
	/**
	 * 사내뉴스 수정
	 * 
	 * @param BoardVO
	 * @return 
	 * @throws 
	 */
	public int getWorkNewsUpdate(BoardVO boardVO);
	/**
	 * 공지사항 삭제
	 * 
	 * @param BoardVO
	 * @return 
	 * @throws 
	 */

	public int getNoticeDeleteBoard(BoardVO boardVO);
	/**
	 * 사내뉴스 삭제
	 * 
	 * @param BoardVO
	 * @return 
	 * @throws 
	 */
	public int getWorkNewsDeleteBoard(BoardVO boardVO);
	/**
	 * 공지사항 검색
	 * 
	 * @param String
	 * @return 
	 * @throws 
	 */
	public List<BoardVO> getNoticeSearch(String key);
	/**
	 * 사내뉴스 검색
	 * 
	 * @param String 
	 * @return 
	 * @throws 
	 */
	public List<BoardVO> getWorkNewsSearch(String key);


}
