package com.groupware.groupBoard.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupware.dto.BoardVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class GroupBoardDAOImpl implements IGroupBoardDAO {
	
	@Autowired
	private SqlMapClient client = null;
	//getNoticeList 공지사항등록
	@Override
	public List<BoardVO> getNoticeList() throws SQLException {
		// TODO Auto-generated method stub
		return client.queryForList("board.noticeList");
	}
	//getWorkNewsList 사내뉴스등록
	@Override
	public List<BoardVO> getWorkNewsList() throws SQLException {
		// TODO Auto-generated method stub
		return client.queryForList("board.workNewsList");
	}
	//getNoticeInformation 공지사항상세보기
	@Override
	public BoardVO getNoticeInformation(String br_wrt_num) throws SQLException {
		// TODO Auto-generated method stub
		return (BoardVO) client.queryForObject("board.noticeInformation",br_wrt_num);
	}
	//getWorkNewsInformation 사내뉴스상세보기
	@Override
	public BoardVO getWorkNewsInformation(String br_wrt_num)
			throws SQLException {
		// TODO Auto-generated method stub
		return (BoardVO) client.queryForObject("board.workNewsInformation",br_wrt_num);
	}

	//getNoticeWriteCom 공지사항등록
	@Override
	public void getNoticeWriteCom(BoardVO boardVO) throws SQLException {
		client.insert("board.NoticeWriteCom",boardVO);
		
	}

	//getWorkNewsWriteCom 사내뉴스등록
	@Override
	public void getWorkNewsWriteCom(BoardVO boardVO) throws SQLException {
		client.insert("board.WorkNewsWriteCom",boardVO);
		
	}

	//getWorkNewsUpdate 사내뉴스수정
	@Override
	public int getWorkNewsUpdate(BoardVO boardVO) throws SQLException {
	
		return client.update("board.WorkNewsUpdateCom", boardVO);
	}

	//getNoticeUpdate 공지사항수정
	@Override
	public int getNoticeUpdate(BoardVO boardVO) throws SQLException {
	
		return client.update("board.NoticeUpdateCom", boardVO);
	}


	//getNoticeSearch 공지사항검색
	@Override
	public List<BoardVO> getNoticeSearch(String key) throws SQLException {
		// TODO Auto-generated method stub
		return client.queryForList("board.NoticeSearch", key);
	}
	//getWorkNewsSearch 사내뉴스 검색
	@Override
	public List<BoardVO> getWorkNewsSearch(String key) throws SQLException {
		// TODO Auto-generated method stub
		return client.queryForList("board.WorkNewsSearch", key);
	}

	//getWorkNewsDeleteBoard 사내뉴스 삭제
	@Override
	public int getWorkNewsDeleteBoard(BoardVO boardVO) throws SQLException {
		// TODO Auto-generated method stub
		return client.delete("board.workNewsDelete", boardVO);
	}

	//getNoticeDeleteBoard 공지사항 삭제
	@Override
	public int getNoticeDeleteBoard(BoardVO boardVO) throws SQLException {
		// TODO Auto-generated method stub
		return client.delete("board.noticeDelete", boardVO);
	}

}
