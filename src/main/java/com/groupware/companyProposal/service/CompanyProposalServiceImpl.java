package com.groupware.companyProposal.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.companyProposal.dao.ICompanyProposalDAO;
import com.groupware.dto.CompanyProposalVO;

@Service
public class CompanyProposalServiceImpl implements ICompanyProposalService {
	
	@Autowired
	private ICompanyProposalDAO dao;
	//제안 검색
	@Override
	public List<CompanyProposalVO> companyProposalSearch(String key) {
		List<CompanyProposalVO>companyProposalSearch = null;
		try{
			companyProposalSearch = dao.companyProposalSearch(key);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return companyProposalSearch;
	}
	//제안 조회
	@Override
	public List<CompanyProposalVO> companyProposalList() {
		List<CompanyProposalVO>companyProposalList = null;
		try{
			companyProposalList = dao.companyProposalList();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return companyProposalList;
	}
	//제안 상세조회
	@Override
	public CompanyProposalVO companyProposalInformation(String prop_code) {
		CompanyProposalVO companyProposalInformation = null;
		try{
			companyProposalInformation = dao.companyProposalInformation(prop_code);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return companyProposalInformation;
	}

	//제안 수정
	@Override
	public int companyProposalUpdate(CompanyProposalVO companyProposalVO) {
		int companyProposalUpdate = 0;
		try{
			companyProposalUpdate=dao.companyProposalUpdate(companyProposalVO);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return companyProposalUpdate;
	}

	//제안 등록
	@Override
	public void companyProposalWriteCom(CompanyProposalVO companyProposalVO) {
		try{
			dao.companyProposalWriteCom(companyProposalVO);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	//제안 삭제
	@Override
	public int companyProposalDelete(CompanyProposalVO companyProposalVO) {
		int companyProposalDelete = 0;
		try{
			companyProposalDelete=dao.companyProposalDelete(companyProposalVO);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return companyProposalDelete;
	}
	
	//제안 처리현황
	@Override
	public void companyProposalCheck(Map<String, String> param) {
		try{
			dao.companyProposalCheck(param);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}


}
