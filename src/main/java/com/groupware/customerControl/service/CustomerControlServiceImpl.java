package com.groupware.customerControl.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.customerControl.dao.ICustomerControlDAO;
import com.groupware.dto.AccountVO;
import com.groupware.dto.MemberVO;

@Service
public class CustomerControlServiceImpl implements ICustomerControlService{
	@Autowired
	private ICustomerControlDAO dao;
	
	@Override
	public List<AccountVO> getCustomerList() {
		List<AccountVO> accountList=null;

		try{
			accountList=dao.getCustomerList();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return accountList;
	}

	@Override
	public AccountVO getCustomerInformation(String ac_code) {
		AccountVO accountVO =null;
		try {
			accountVO = dao.getCustomerInformation(ac_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountVO;
	}



	@Override
	public void getCustomerUpdate(AccountVO accountVO) {
		try {
			dao.getCustomerUpdate(accountVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getCustomerDelete(AccountVO accountVO) {
		try {
			dao.getCusotomerDelete(accountVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getCustomerWrite(AccountVO accountVO) {
		try {
			dao.getCustomerWrite(accountVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<AccountVO> getSearchList(String searchKeyword) {
		List<AccountVO> searchList = null;
		try {
			searchList = dao.getSearchList(searchKeyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return searchList;
	}
	@Override
	public List<AccountVO> getSearchList1(String searchKeyword) {
		List<AccountVO> searchList = null;
		try {
			searchList = dao.getSearchList1(searchKeyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return searchList;
	}


}
