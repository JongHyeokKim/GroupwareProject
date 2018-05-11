/**
 * @Class Name : ICustomerControlDAO.java
 * @Description :  거래처 관리의 수정/등록/삭제 DAO
 * @Modification DAO
 * @author 김준학
 * @since  2016.08.29.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.08.29.  김준학        최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
package com.groupware.customerControl.dao;

import java.sql.SQLException;
import java.util.List;

import com.groupware.dto.AccountVO;

public interface ICustomerControlDAO {
	/**
	 * 거래처 리스트
	 * @param
	 * @return 
	 * @throws  
	 */
	public List<AccountVO> getCustomerList() throws SQLException;
	
	/**
	 * 거래처 상세보기
	 * @param String ac_code
	 * @return 
	 * @throws  SQLException
	 */
	public AccountVO getCustomerInformation(String ac_code) throws SQLException;
	
	/**
	 * 거래처 수정
	 * @param AccountVO
	 * @return 
	 * @throws  SQLException
	 */
	public void getCustomerUpdate(AccountVO accountVO) throws SQLException;
	/**
	 * 거래처 삭제
	 * @param AccountVO
	 * @return 
	 * @throws  SQLException
	 */
	public void getCusotomerDelete(AccountVO accountVO) throws SQLException;
	/**
	 * 거래처 등록
	 * @param AccountVO
	 * @return 
	 * @throws  SQLException
	 */
	public void getCustomerWrite(AccountVO accountVO) throws SQLException;


	public List<AccountVO> getSearchList(String searchKeyword)throws SQLException;

	public List<AccountVO> getSearchList1(String searchKeyword)throws SQLException;

}
