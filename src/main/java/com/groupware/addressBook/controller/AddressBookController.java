package com.groupware.addressBook.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.groupware.addressBook.service.IAddressBookService;
import com.groupware.dto.MemberVO;
import com.groupware.dto.address.AddressBookVO;
import com.groupware.dto.address.JsonParseVO;
/**
 * @Class Name : AddressBookController.java
 * @Description : 주소록(사내의 사원목록) 조회
 * @Modification Information
 * @author 김태균
 * @since  2016.08.30.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.08.30.  김태균        최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
@Controller
public class AddressBookController{
	@Autowired
	private IAddressBookService service;
	
	@RequestMapping("/addressBook")
	public String addresssBookList(){
		try {
			List<AddressBookVO> list = 	service.getAddressBookList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	@RequestMapping("/insertAddrssBook")
	public String insertAddressBook(MemberVO memberVO){
		try {
			service.insertAddresssBook(memberVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	@RequestMapping("/adminDepartment")
	public String adminDepartment(Model model) {
		String url = "addressBook/adminDepartment";
		return url;
	}
	@RequestMapping("/adminEmployee")
	public String adminEmployee(Model model) {
		String url = "addressBook/adminEmployee";
		return url;
	}
	
	@RequestMapping("/addressMain")
	public String addressMain(Model model){
		String url = "addressBook/addressMain";
		return url;
	}
	
	@RequestMapping(value="/addressData", method=RequestMethod.GET)
	@ResponseBody
	public JsonParseVO memberList(){
		return new JsonParseVO(service.getAddressList());
	}
	
	@RequestMapping(value="/getDepart", method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<String> getKeyList(){
		return service.getKeyList();
	}
}
