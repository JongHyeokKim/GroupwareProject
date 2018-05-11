package com.groupware.groupFile.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.dto.AccountVO;
import com.groupware.dto.GroupFileVO;
import com.groupware.groupFile.dao.IGroupFileDAO;

@Service
public class GroupFileServiceImpl implements IGroupFileService {
	@Autowired
	private IGroupFileDAO dao;
	
	@Override
	public List<GroupFileVO> getGroupFileList() {
		List<GroupFileVO> groupFileList=null;
		try {
			groupFileList=dao.getGroupFileList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groupFileList;
	}

	@Override
	public GroupFileVO getGroupFileInfo(String doc_code) {
		GroupFileVO groupFileVO =null;
		
		try {
			groupFileVO=dao.getGroupFileInfo(doc_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groupFileVO;
	}

	@Override
	public List<GroupFileVO> getSearchList(String searchKeyword) {
		List<GroupFileVO> searchList = null;
		try {
			searchList = dao.getSearchList(searchKeyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchList;
	}

	@Override
	public List<GroupFileVO> getSearchList1(String searchKeyword) {
		List<GroupFileVO> searchList = null;
		try {
			searchList = dao.getSearchList1(searchKeyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchList;
	}

	@Override
	public void getGroupFileWrite(GroupFileVO groupFileVO) {
		try {
			dao.getGroupFileWrite(groupFileVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void getGroupFileUpdate(GroupFileVO groupFileVO) {
		try {
			dao.getGroupFileUpdate(groupFileVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void getgroupFileDelete(GroupFileVO groupFileVO) {
		try {
			dao.getGroupFileDelete(groupFileVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void getGroupFileUpdateWithoutFile(GroupFileVO groupFileVO) {
		try {
			dao.getGroupFileUpdateWithoutFile(groupFileVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getFileName(String doc_code) {
		String fileName="";
		try {
			fileName = dao.getFileName(doc_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fileName;
	}
}
