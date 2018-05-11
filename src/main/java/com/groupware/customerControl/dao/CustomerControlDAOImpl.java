package com.groupware.customerControl.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupware.dto.AccountVO;
import com.groupware.dto.MemberVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class CustomerControlDAOImpl implements ICustomerControlDAO{
	@Autowired
	private SqlMapClient client;
	
	@Override
	public List<AccountVO> getCustomerList() throws SQLException {
		
		List<AccountVO> accountList = null;
		accountList = client.queryForList("account.getCustomerList");
		return accountList;
	}

	@Override
	public AccountVO getCustomerInformation(String ac_code) throws SQLException {
		
		return (AccountVO) client.queryForObject("account.getCustomerInformation",ac_code);
	}

	@Override
	public void getCustomerUpdate(AccountVO accountVO) throws SQLException {
		client.update("account.customerUpdate",accountVO);
	}

	@Override
	public void getCusotomerDelete(AccountVO accountVO) throws SQLException {
		client.delete("account.customerDelete",accountVO);
	}

	@Override
	public void getCustomerWrite(AccountVO accountVO) throws SQLException {
		client.insert("account.customerWrite",accountVO);
	}

	@Override
	public List<AccountVO> getSearchList(String searchKeyword)
			throws SQLException {
		List<AccountVO> searchList = null;
		searchList = client.queryForList("account.getSearchList", searchKeyword);
		return searchList;
	}

	@Override
	public List<AccountVO> getSearchList1(String searchKeyword)
			throws SQLException {
		List<AccountVO> searchList = null;
		searchList = client.queryForList("account.getSearchList1", searchKeyword);
		return searchList;
	}



}
