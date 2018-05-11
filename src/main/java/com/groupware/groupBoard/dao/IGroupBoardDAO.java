package com.groupware.groupBoard.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.groupware.dto.BoardVO;

public interface IGroupBoardDAO {
	/**
	 * @Class Name : IGroupBoardDAO.java
	 * @Description : 게시판 조회/등록/수정/삭제/ 기능 메서드 모음
	 * @Modification Dao
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
	 * @throws SQLException
	 */
	public List<BoardVO> getNoticeList() throws SQLException;
	/**
	 * 사내뉴스 리스트조회
	 * @param 
	 * @return 
	 * @throws SQLException
	 */

	public List<BoardVO> getWorkNewsList() throws SQLException;
	/**
	 * 공지사항 상세조회
	 * @param String
	 * @return 
	 * @throws SQLException
	 */
	public BoardVO getNoticeInformation(String br_wrt_num) throws SQLException;
	/**
	 * 사내뉴스  상세조회
	 * @param String
	 * @return 
	* @throws SQLException
	 */
	public BoardVO getWorkNewsInformation(String br_wrt_num) throws SQLException;
	/**
	 * 공지사항 등록
	* @param BoardVO
	 * @return 
	* @throws SQLException
	 */

	public void getNoticeWriteCom(BoardVO boardVO)throws SQLException;
	/**
	 * 사내뉴스 등록
	* @param BoardVO
	 * @return 
	* @throws SQLException
	 */
	public void getWorkNewsWriteCom(BoardVO boardVO)throws SQLException;
	/**
	 * 사내뉴스 수정
	* @param BoardVO
	 * @return 
	* @throws SQLException
	 */

	public int getWorkNewsUpdate(BoardVO boardVO)throws SQLException;
	/**
	 * 공지사항 수정
	* @param BoardVO
	 * @return 
	* @throws SQLException
	 */

	public int getNoticeUpdate(BoardVO boardVO)throws SQLException;

	/**
	 * 사내뉴스 검색
	* @param String
	 * @return 
	* @throws SQLException
	 */

	public List<BoardVO> getWorkNewsSearch(String key)throws SQLException;

	/**
	 * 공지사항 검색
	* @param String
	 * @return 
	* @throws SQLException
	 */


	public List<BoardVO> getNoticeSearch(String key)throws SQLException;
	/**
	 * 사내뉴스 삭제
	* @param BoardVO
	 * @return 
	* @throws SQLException
	 */

	public int getWorkNewsDeleteBoard(BoardVO boardVO)throws SQLException;
	/**
	 * 공지사항 삭제
	* @param BoardVO
	 * @return 
	* @throws SQLException
	 */

	public int getNoticeDeleteBoard(BoardVO boardVO)throws SQLException;

}
