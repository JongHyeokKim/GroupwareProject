package com.groupware.groupFile.service;

import java.util.List;

import com.groupware.dto.AccountVO;
import com.groupware.dto.GroupFileVO;

public interface IGroupFileService {

	public List<GroupFileVO> getGroupFileList();

	public List<GroupFileVO> getSearchList(String searchKeyword); //검색
	
	
	public List<GroupFileVO> getSearchList1(String searchKeyword); //검색

	public GroupFileVO getGroupFileInfo(String doc_code);//상세정보

	public void getGroupFileWrite(GroupFileVO groupFileVO); //쓰기

	public void getGroupFileUpdate(GroupFileVO groupFileVO); //수정

	public void getgroupFileDelete(GroupFileVO groupFileVO); //삭제

	public void getGroupFileUpdateWithoutFile(GroupFileVO groupFileVO);

	public String getFileName(String doc_code);


}
