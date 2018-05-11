package com.groupware.companySurvey.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.groupware.dto.CompanySurveyCheckVO;
import com.groupware.dto.CompanySurveyVO;
/**
 * @Class Name : ICompanySurveyService.java
 * @Description : 설문조사 화면 검색/조회/등록/수정/삭제/설문마감 기능 메서드 모음
 * @Modification Service
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
public interface ICompanySurveyService {
	
	/**
	 *	설문 검색
	 * @param String
	 * @return 
	 * @throws 
	 * 
	 */
	public List<CompanySurveyVO> companySurveySearch(String key);
	/**
	 *	설문 정보
	 * @param String
	 * @return 
	 * @throws 
	 * 
	 */

	public CompanySurveyVO companySurveyInformation(String res_code);
	/**
	 *	설문 조회
	 * @param String
	 * @return 
	 * @throws 
	 * 
	 */
	public List<CompanySurveyVO> companySurveyList();

	/**
	 *	설문 마감
	 * @param Map
	 * @return 
	 * @throws 
	 * 
	 */
	public void companySurveyDeadline(Map<String, String> param);
	/**
	 *	설문 삭제
	 * @param CompanySurveyVO
	 * @return 
	 * @throws 
	 * 
	 */
	public int companySurveyDelete(CompanySurveyVO companySurveyVO);
	/**
	 *	설문 수정
	 * @param CompanySurveyVO
	 * @return 
	 * @throws 
	 * 
	 */
	public int companySurveyUpdate(CompanySurveyVO companySurveyVO);
	/**
	 *	설문 등록
	 * @param CompanySurveyVO
	 * @return 
	 * @throws 
	 * 
	 */

	public void companySurveyWrite(CompanySurveyVO companySurveyVO);
	/**
	 *	설문 제출
	 * @param Map
	 * @return 
	 * @throws 
	 * 
	 */
	public void companySurveyAdd(Map<String, String> param);
	/**
	 *	해당글 항목당투표값조회
	 * @param String
	 * @return 
	 * @throws 
	 * 
	 */
	public CompanySurveyVO checkCount(String res_code);
	/**
	 *	투표수체크
	 * @param Map
	 * @return 
	 * @throws 
	 * 
	 */
	public int countNumCheck(Map<String,Object> countGroup);
	/**
	 *	투표수 가져오기
	 * @param Map
	 * @return 
	 * @throws 
	 * 
	 */
	public CompanySurveyVO getcountTotal(Map<String, String> param2);
	/**
	 *	설문제출여부에 따른 정보창보기
	 * @param Map
	 * @return 
	 * @throws 
	 * 
	 */
	public CompanySurveyCheckVO checkSearch(Map<String, String> param2);
	/**
	 *	투표여부 확인
	 * @param Map
	 * @return 
	 * @throws 
	 * 
	 */
	public void addcheckSearch(Map<String, String> param2);

}
