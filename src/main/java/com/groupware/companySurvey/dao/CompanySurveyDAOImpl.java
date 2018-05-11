package com.groupware.companySurvey.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupware.dto.CompanySurveyCheckVO;
import com.groupware.dto.CompanySurveyVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class CompanySurveyDAOImpl implements ICompanySurveyDAO {

	@Autowired
	private SqlMapClient client;
	//설문검색
	@Override
	public List<CompanySurveyVO> companySurveySearch(String key)
			throws SQLException {
		// TODO Auto-generated method stub
		return client.queryForList("companySurvey.companySurveySearch", key);
	}

	//설문상세조회
	@Override
	public CompanySurveyVO companySurveyInformation(String res_code)
			throws SQLException {
		// TODO Auto-generated method stub
		return (CompanySurveyVO) client.queryForObject("companySurvey.companySurveyInformation", res_code);
	}
	//설문조회
	@Override
	public List<CompanySurveyVO> companySurveyList() throws SQLException {
		// TODO Auto-generated method stub
		return client.queryForList("companySurvey.companySurveyList");
	}
	//설문등록
	@Override
	public void companySurveyWrite(CompanySurveyVO companySurveyVO) throws SQLException {
		client.insert("companySurvey.companySurveyWrite", companySurveyVO);
		
	}
	//설문수정
	@Override
	public int companySurveyUpdate(CompanySurveyVO companySurveyVO)
			throws SQLException {
		
		return client.update("companySurvey.companySurveyUpdate", companySurveyVO);
	}
	
	//설문마감처리
	@Override
	public void companySurveyDeadline(Map<String, String> param) throws SQLException {
		client.update("companySurvey.companySurveyDeadlineUpdate", param);
		
	}
	//설문삭제
	@Override
	public int companySurveyDelete(CompanySurveyVO companySurveyVO)
			throws SQLException {
		// TODO Auto-generated method stub
		return client.delete("companySurvey.companySurveyDelete", companySurveyVO);
	}
	//설문제출
	@Override
	public void companySurveyAdd(Map<String, String> param) throws SQLException {
			client.update("companySurvey.companySurveyAdd", param);
		
		
		
	}
	//해당글 투표값조회
	@Override
	public CompanySurveyVO checkCount(String res_code) throws SQLException {
		CompanySurveyVO count=null;
		count=(CompanySurveyVO) client.queryForObject("companySurvey.checkCount",res_code);
		return count;
	}
	//해당 글 투표수 체크
	@Override
	public int countNumCheck(Map<String, Object> countGroup) throws SQLException {
		int error = 0;
		error = client.update("companySurvey.countUpdate",countGroup);
		return error;
	}
	// 투표 수 가져오기
	@Override
	public CompanySurveyVO getcountTotal(Map<String, String> param2)
			throws SQLException {
		// TODO Auto-generated method stub
		return (CompanySurveyVO) client.queryForObject("companySurvey.getcountTotal",param2);
	}
	//설문체크여부에 따른 정보창 보기
	@Override
	public CompanySurveyCheckVO checkSearch(Map<String, String> param2)
			throws SQLException {
		return (CompanySurveyCheckVO) client.queryForObject("companySurvey.checkSearch",param2);
	}
	//투표여부확인
	@Override
	public void addcheckSearch(Map<String, String> param2) throws SQLException {
		client.insert("companySurvey.addcheckSearch",param2);
		
	}
	

}
