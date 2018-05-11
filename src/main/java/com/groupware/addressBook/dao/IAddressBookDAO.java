package com.groupware.addressBook.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.groupware.dto.MemberVO;
import com.groupware.dto.address.AddressBookVO;
import com.groupware.dto.address.AddressViewVO;

public interface IAddressBookDAO {

	List<AddressBookVO> getAddressBookList()throws SQLException;

	void insertAddressBook(MemberVO memberVO)throws SQLException;

	ArrayList<AddressViewVO> getAddressList();

	ArrayList<String> getKeyList();

}
