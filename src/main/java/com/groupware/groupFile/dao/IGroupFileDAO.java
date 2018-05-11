package com.groupware.groupFile.dao;

import java.sql.SQLException;
import java.util.List;

import com.groupware.dto.GroupFileVO;

public interface IGroupFileDAO {
	public  List<GroupFileVO> getGroupFileList() throws SQLException; 
	public GroupFileVO getGroupFileInfo(String doc_code) throws SQLException;
	public List<GroupFileVO> getSearchList(String searchKeyword) throws SQLException;
	public List<GroupFileVO> getSearchList1(String searchKeyword) throws SQLException;
	public void getGroupFileWrite(GroupFileVO groupFileVO) throws SQLException;
	public void getGroupFileUpdate(GroupFileVO groupFileVO) throws SQLException;
	public void getGroupFileDelete(GroupFileVO groupFileVO) throws SQLException;
	public void getGroupFileUpdateWithoutFile(GroupFileVO groupFileVO) throws SQLException;
	public String getFileName(String doc_code) throws SQLException; 
}
