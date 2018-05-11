package com.groupware.groupFile.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupware.dto.AccountVO;
import com.groupware.dto.GroupFileVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class GroupFileDAOImpl implements IGroupFileDAO {
	@Autowired
	private SqlMapClient client =null;
	
	@Override
	public List<GroupFileVO> getGroupFileList() throws SQLException {
		List<GroupFileVO> groupFileList =null;
		groupFileList=client.queryForList("file.getGroupFileList");
		return groupFileList;
	}

	@Override
	public GroupFileVO getGroupFileInfo(String doc_code) throws SQLException {
		
		return (GroupFileVO) client.queryForObject("file.getGroupFileInfo",doc_code);
	}

	@Override
	public List<GroupFileVO> getSearchList(String searchKeyword)
			throws SQLException {
		List<GroupFileVO> searchList =null;
		searchList=client.queryForList("file.getSearchList",searchKeyword);
		return searchList;
	}

	@Override
	public List<GroupFileVO> getSearchList1(String searchKeyword)
			throws SQLException {
		List<GroupFileVO> searchList =null;
		searchList=client.queryForList("file.getSearchList1",searchKeyword);
		return searchList;
	}

	@Override
	public void getGroupFileWrite(GroupFileVO groupFileVO) throws SQLException {
		client.insert("file.groupFileWrite",groupFileVO);
		
	}

	@Override
	public void getGroupFileUpdate(GroupFileVO groupFileVO) throws SQLException {
		client.update("file.groupFileUpdateWithFile",groupFileVO);
	}

	@Override
	public void getGroupFileDelete(GroupFileVO groupFileVO) throws SQLException {
		client.delete("file.groupFileDelete",groupFileVO);
	}

	@Override
	public void getGroupFileUpdateWithoutFile(GroupFileVO groupFileVO) throws SQLException {
		client.update("file.groupFileUpdateWithoutFile",groupFileVO);
	}

	@Override
	public String getFileName(String doc_code) throws SQLException {
		String result = (String) client.queryForObject("file.getFileName",doc_code);
		return result;
	}

}
