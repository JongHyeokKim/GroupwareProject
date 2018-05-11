package com.groupware.addressBook.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.addressBook.dao.IAddressBookDAO;
import com.groupware.dto.MemberVO;
import com.groupware.dto.address.AddressBookVO;
import com.groupware.dto.address.AddressViewVO;

@Service
public class AddressBookServiceImpl implements IAddressBookService{
	@Autowired
	private IAddressBookDAO dao;
	@Override
	public List<AddressBookVO> getAddressBookList() throws SQLException {
		List<AddressBookVO> list= dao.getAddressBookList();
		return list;
	}
	@Override
	public void insertAddresssBook(MemberVO memberVO) throws SQLException {
		dao.insertAddressBook(memberVO);
	}
	@Override
	public ArrayList<AddressViewVO> getAddressList() {
		return dao.getAddressList();
	}
	@Override
	public ArrayList<String> getKeyList() {
		return dao.getKeyList();
	}

}
