package com.groupware.addressBook.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupware.dto.MemberVO;
import com.groupware.dto.address.AddressBookVO;
import com.groupware.dto.address.AddressViewVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class AddressBookDAOImpl implements IAddressBookDAO {
	@Autowired
	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public List<AddressBookVO> getAddressBookList() throws SQLException {
		List<AddressBookVO> list  =	client.queryForList("");
		return list;
	}

	@Override
	public void insertAddressBook(MemberVO memberVO) throws SQLException {
		client.insert("",memberVO);
		
	}

	@Override
	public ArrayList<AddressViewVO> getAddressList() {
		ArrayList<AddressViewVO> list = null;
		try {
			list = (ArrayList<AddressViewVO>) client.queryForList("address.getAddressList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<String> getKeyList() {
		ArrayList<String> list = null;
		try {
			list = (ArrayList<String>) client.queryForList("address.getKeyList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
