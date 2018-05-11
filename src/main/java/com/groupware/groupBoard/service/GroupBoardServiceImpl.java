package com.groupware.groupBoard.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.dto.BoardVO;
import com.groupware.groupBoard.dao.IGroupBoardDAO;

@Service
public class GroupBoardServiceImpl implements IGroupBoardService {
	@Autowired
	private IGroupBoardDAO dao = null;
	
	//getNoticeList 공지사항 리스트조회
	@Override
	public List<BoardVO> getNoticeList() {
		List<BoardVO> noticeList = null;
		try{
		noticeList=dao.getNoticeList();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return noticeList;
	}

	//getWorkNewsList 사내뉴스 리스트조회
	@Override
	public List<BoardVO> getWorkNewsList() {
		List<BoardVO> workNewsList = null;
		try{
			workNewsList=dao.getWorkNewsList();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return workNewsList;
	}

	//getWorkNewsInformation 사내뉴스 상세조회
	@Override
	public BoardVO getWorkNewsInformation(String br_wrt_num) {
		BoardVO board = null;
		try{
			board = dao.getWorkNewsInformation(br_wrt_num);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return board;
	}

	//getNoticeInformation 공지사항 상세조회
	@Override
	public BoardVO getNoticeInformation(String br_wrt_num) {
		BoardVO board = null;
		try{
			board = dao.getNoticeInformation(br_wrt_num);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return board;
	}
	//getNoticeWriteCom 공지사항 등록

	@Override
	public void getNoticeWriteCom(BoardVO boardVO) {
		try{
		dao.getNoticeWriteCom(boardVO);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	//getWorkNewsWriteCom 사내뉴스 등록
	@Override
	public void getWorkNewsWriteCom(BoardVO boardVO) {
		try{
			dao.getWorkNewsWriteCom(boardVO);
			}catch(SQLException e){
				e.printStackTrace();
			}
		
	}
	//getNoticeUpdate 공지사항 수정
	@Override
	public int getNoticeUpdate(BoardVO boardVO) {
		int getNoticeUpdate = 0;
		try{
			getNoticeUpdate =dao.getNoticeUpdate(boardVO);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return getNoticeUpdate;
	}
	//getWorkNewsUpdate 사내뉴스 수정
	@Override
	public int getWorkNewsUpdate(BoardVO boardVO) {
		int getWorkNewsUpdate = 0;
		try{
			getWorkNewsUpdate=dao.getWorkNewsUpdate(boardVO);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return getWorkNewsUpdate;
	}


	//getNoticeSearch 공지사항 검색
	@Override
	public List<BoardVO> getNoticeSearch(String key) {
		List<BoardVO> getNoticeSearch= null;
		try{
		getNoticeSearch=dao.getNoticeSearch(key);}
		catch(SQLException e){
			e.printStackTrace();
		}
		return getNoticeSearch;
	}
	//getWorkNewsSearch 사내뉴스 검색
	@Override
	public List<BoardVO> getWorkNewsSearch(String key) {
		List<BoardVO>getWorkNewsSearch=null;
		try{
			getWorkNewsSearch=dao.getWorkNewsSearch(key);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return getWorkNewsSearch;
	}
	//getNoticeDeleteBoard 공지사항 삭제
	@Override
	public int getNoticeDeleteBoard(BoardVO boardVO) {
		int getDeleteBoard = 0;
		try{
			getDeleteBoard=dao.getNoticeDeleteBoard(boardVO);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return getDeleteBoard;
	}

	//getWorkNewsDeleteBoard 사내뉴스 삭제
	@Override
	public int getWorkNewsDeleteBoard(BoardVO boardVO) {
		int getDeleteBoard = 0;
		try{
			getDeleteBoard=dao.getWorkNewsDeleteBoard(boardVO);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return getDeleteBoard;
	}
	
	}


