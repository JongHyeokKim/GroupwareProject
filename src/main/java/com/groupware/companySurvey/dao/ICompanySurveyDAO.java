package com.groupware.companySurvey.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.groupware.dto.CompanySurveyCheckVO;
import com.groupware.dto.CompanySurveyVO;
/**
 * @Class Name : ICompanySurveyDAO.java
 * @Description : 설문조사 화면 검색/조회/등록/수정/삭제/설문마감 기능 메서드 모음
 * @Modification Dao
 * @author 함박눈
 * @since  2016.08.29.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *   2016.08.29.  함박눈        최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
public interface ICompanySurveyDAO {
	/**
	 *	설문 검색
	 * @param String
	 * @return 
	 * @throws SQLException
	 * 
	 */
	public List<CompanySurveyVO> companySurveySearch(String key) throws SQLException;

	/**
	 *	설문 상세조회
	 * @param String
	 * @return 
	 * @throws SQLException
	 * 
	 */
	public CompanySurveyVO companySurveyInformation(String res_code) throws SQLException;

	/**
	 *	설문 조회
	 * @param 
	 * @return 
	 * @throws SQLException
	 * 
	 */
	public List<CompanySurveyVO> companySurveyList() throws SQLException;

	/**
	 *	설문 마감
	 * @param Map
	 * @return 
	 * @throws SQLException
	 * 
	 */
	public void companySurveyDeadline(Map<String, String> param) throws SQLException;

	/**
	 *	설문 삭제
	 * @param CompanySurveyVO
	 * @return 
	 * @throws SQLException
	 * 
	 */
	public int companySurveyDelete(CompanySurveyVO companySurveyVO) throws SQLException;

	/**
	 *	설문 수정
	 * @param CompanySurveyVO
	 * @return 
	 * @throws SQLException
	 * 
	 */
	public int companySurveyUpdate(CompanySurveyVO companySurveyVO) throws SQLException;

	/**
	 *	설문 등록
	 * @param CompanySurveyVO
	 * @return 
	 * @throws SQLException
	 * 
	 */
	public void companySurveyWrite(CompanySurveyVO companySurveyVO) throws SQLException;
	/**
	 *	설문 제출
	 * @param Map
	 * @return 
	 * @throws SQLException
	 * 
	 */
	public void companySurveyAdd(Map<String, String> param)throws SQLException;
	/**
	 *	해당글 항목당 투표값 조회
	 * @param String
	 * @return 
	 * @throws SQLException
	 * 
	 */
	public CompanySurveyVO checkCount(String res_code)throws SQLException;
	/**
	 *	투표수 체크
	 * @param Map
	 * @return 
	 * @throws SQLException
	 * 
	 */
	public int countNumCheck(Map<String,Object> countGroup)throws SQLException;
	/**
	 *	투표수 가져오기
	 * @param Map
	 * @return 
	 * @throws SQLException
	 * 
	 */

	public CompanySurveyVO getcountTotal(Map<String, String> param2)throws SQLException;
	/**
	 *	설문 제출 여부에 따른 정보창조회
	 * @param Map
	 * @return 
	 * @throws SQLException
	 * 
	 */

	public CompanySurveyCheckVO checkSearch(Map<String, String> param2)throws SQLException;
	/**
	 *	투표여부확인
	 * @param Map
	 * @return 
	 * @throws SQLException
	 * 
	 */

	public void addcheckSearch(Map<String, String> param2)throws SQLException;

}
