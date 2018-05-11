package com.groupware.companyProposal.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupware.dto.CompanyProposalVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class CompanyProposalDAOImpl implements ICompanyProposalDAO{
	
	@Autowired
	private SqlMapClient client;
	//제안 검색
	@Override
	public List<CompanyProposalVO> companyProposalSearch(String key)
			throws SQLException {
		
		return client.queryForList("companyProposal.companyProposalSearch", key);
	}
	//제안 리스트조회
	@Override
	public List<CompanyProposalVO> companyProposalList() throws SQLException {
		// TODO Auto-generated method stub
		return client.queryForList("companyProposal.companyProposalList");
		
	}
	//제안 상세조회
	@Override
	public CompanyProposalVO companyProposalInformation(String prop_code) throws SQLException {
		
		return (CompanyProposalVO) client.queryForObject("companyProposal.companyProposalInformation",prop_code);
	}

	//제안 등록
	@Override
	public void companyProposalWriteCom(CompanyProposalVO companyProposalVO) throws SQLException {
		client.insert("companyProposal.companyProposalWriteCom",companyProposalVO);
		
	}
	
	//제안 수정
	@Override
	public int companyProposalUpdate(CompanyProposalVO companyProposalVO)
			throws SQLException {
		return client.update("companyProposal.companyProposalUpdateCom",companyProposalVO);
	}
	//제안 삭제
	@Override
	public int companyProposalDelete(CompanyProposalVO companyProposalVO)
			throws SQLException {
		// TODO Auto-generated method stub
		return client.delete("companyProposal.companyProposalDelete",companyProposalVO);
	}
	// 제안 처리현황
	@Override
	public void companyProposalCheck(Map<String, String> param)	throws SQLException {
		client.update("companyProposal.companyProposalCheckUpdate", param);
	}


}
