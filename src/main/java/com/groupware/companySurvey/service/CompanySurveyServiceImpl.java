package com.groupware.companySurvey.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.companySurvey.dao.ICompanySurveyDAO;
import com.groupware.dto.CompanySurveyCheckVO;
import com.groupware.dto.CompanySurveyVO;

@Service
public class CompanySurveyServiceImpl implements ICompanySurveyService {
	@Autowired
	private ICompanySurveyDAO dao;
	// 설문검색
	@Override
	public List<CompanySurveyVO> companySurveySearch(String key) {
		List<CompanySurveyVO> companySurveySearch = null;
		try{
			companySurveySearch=dao.companySurveySearch(key);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return companySurveySearch;
	}
	//설문상세조회
	@Override
	public CompanySurveyVO companySurveyInformation(String res_code) {
		CompanySurveyVO companySurveyInformation =null;
		try{
			companySurveyInformation =dao.companySurveyInformation(res_code);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return companySurveyInformation;
	}
	//설문조회
	@Override
	public List<CompanySurveyVO> companySurveyList() {
		List<CompanySurveyVO> companySurveyList = null;
		try{
			companySurveyList = dao.companySurveyList();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return companySurveyList;
	}
	//설문마감처리
	@Override
	public void companySurveyDeadline(Map<String, String> param) {
		try{
		dao.companySurveyDeadline(param);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//설문삭제
	@Override
	public int companySurveyDelete(CompanySurveyVO companySurveyVO) {
		int companySurveyDelete = 0;
		try{
			companySurveyDelete =dao.companySurveyDelete(companySurveyVO);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return companySurveyDelete;
	}
	//설문수정
	@Override
	public int companySurveyUpdate(CompanySurveyVO companySurveyVO) {
		int companySurveyUpdate = 0;
		try{
			companySurveyUpdate =dao.companySurveyUpdate(companySurveyVO);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return companySurveyUpdate;
	}
	//설문등록
	@Override
	public void companySurveyWrite(CompanySurveyVO companySurveyVO) {
		try{
			dao.companySurveyWrite(companySurveyVO);
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	
	//설문제출
	@Override
	public void companySurveyAdd(Map<String, String> param) {
		
		try{
			dao.companySurveyAdd(param);
		}catch(SQLException e){
			e.printStackTrace();
		}
	
		
	}
	//해당글 항목당 투표값 조회
	@Override
	public CompanySurveyVO checkCount(String res_code) {
		CompanySurveyVO count=null;
		try {
			count =	dao.checkCount(res_code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	//투표수 체크
	@Override
	public int countNumCheck(Map<String,Object> countGroup) {
		int error=0;
		
		try {
			error=dao.countNumCheck(countGroup);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return error;
	}
	//투표수 가져오기
	@Override
	public CompanySurveyVO getcountTotal(Map<String, String> param2) {
		CompanySurveyVO companySurveyVO = null;
		

			try {
				companySurveyVO = dao.getcountTotal(param2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		return companySurveyVO;
	}
	//설문제출여부에 따른 정보창보기
	@Override
	public CompanySurveyCheckVO checkSearch(Map<String, String> param2) {
		CompanySurveyCheckVO checkSearch =null;
		 try {
			checkSearch=dao.checkSearch(param2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return checkSearch;
	}
	//설문제출여부확인
	@Override
	public void addcheckSearch(Map<String, String> param2) {
		try {
			dao.addcheckSearch(param2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}			
	

}
