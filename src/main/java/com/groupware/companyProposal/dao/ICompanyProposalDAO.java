package com.groupware.companyProposal.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.groupware.dto.CompanyProposalVO;
/**
 * @Class Name : ICompanyProposalDAO.java
 * @Description : 제안서 조회/등록/삭제/수정/현황처리 메서드 모음
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
public interface ICompanyProposalDAO {
	/**
	 * 제안 검색
	 * @param String
	 * @return
	 * @throws SQLException
	 */

	public List<CompanyProposalVO> companyProposalSearch(String key)throws SQLException;
	/**
	 * 제안 조회
	 * @param 
	 * @return
	 * @throws SQLException
	 */
	public List<CompanyProposalVO> companyProposalList()throws SQLException;
	/**
	 * 제안 상세조회
	 * @param String
	 * @return
	 * @throws SQLException
	 */
	public CompanyProposalVO companyProposalInformation(String prop_code)throws SQLException;
	/**
	 * 제안 수정
	 * @param CompanyProposalVO
	 * @return
	 * @throws SQLException
	 */
	public int companyProposalUpdate(CompanyProposalVO companyProposalVO)throws SQLException;
	/**
	 * 제안 등록
	 * @param CompanyProposalVO
	 * @return
	 * @throws SQLException
	 */
	public void companyProposalWriteCom(CompanyProposalVO companyProposalVO)throws SQLException;
	/**
	 * 제안 처리현황
	 * @param Map
	 * @return
	 * @throws SQLException
	 */
	public void companyProposalCheck(Map<String, String> param)throws SQLException;
	/**
	 * 제안 삭제
	 * @param CompanyProposalVO
	 * @return
	 * @throws SQLException
	 */
	public int companyProposalDelete(CompanyProposalVO companyProposalVO)throws SQLException;

}
