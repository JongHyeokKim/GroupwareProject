package com.groupware.companyFacility.dao;

import java.sql.SQLException;
import java.util.List;

import com.groupware.dto.FacilityVO;
import com.groupware.dto.ReservationVO;

/**
 * @Class Name : ICompanyFacilityDAO.java
 * @Description : 시설예약 DAO interface
 * @Modification Information
 * @author 김성수
 * @since  2016.08.30.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.08.30.   김성수             최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
public interface ICompanyFacilityDAO {

	/**
	 * 사내시설 리스트
	 * @param
	 * @return : getFacilityList
	 * @throws : SQLException
	 */
	public List<FacilityVO> getFacilityList() throws SQLException;

	
	/**
	 * 사내시설 등록
	 * @param : facilityVO
	 * @return : facilityInsert
	 * @throws : SQLException
	 */
	public void facilityInsert(FacilityVO facilityVO) throws SQLException;

	
	/**
	 * 사내시설 정보
	 * @param : fac_code
	 * @return : getFacilityInfo
	 * @throws : SQLException 
	 */
	public FacilityVO getFacilityInfo(String fac_code) throws SQLException;

	
	/**
	 * 사내시설 수정
	 * @param : facilityVO
	 * @return : facilityUpdate
	 * @throws  : SQLException
	 */
	public int facilityUpdate(FacilityVO facilityVO) throws SQLException;

	
	/**
	 * 사내시설 삭제
	 * @param : String fac_code
	 * @return : facilityDelete
	 * @throws : SQLException
	 */
	public int facilityDelete(String fac_code) throws SQLException;

	
	/**
	 * 사내시설 예약 리스트
	 * @param : String date
	 * @return : getReserveList
	 * @throws  : SQLException
	 */
	public List<ReservationVO> getReserve(String date, String code) throws SQLException;

	/**
	 * 사내시설 예약
	 * @param : reserveVO
	 * @return : insertReserve
	 * @throws  : SQLException
	 */
	public void insertReserve(ReservationVO reserveVO) throws SQLException;

	/**
	 * 나의 예약 정보리스트
	 * @param : reserveVO
	 * @return : getMyReserveList
	 * @throws  : SQLException
	 */
	public List<ReservationVO> getMyReserveList(ReservationVO reserveVO) throws SQLException;

	/**
	 * 예약 취소
	 * @param : reserv_code
	 * @return : reserveCancle
	 * @throws  : SQLException
	 */
	public int reserveCancel(String reserv_code) throws SQLException;

	/**
	 * 전체 예약 정보 리스트
	 * @param : 
	 * @return : allReservation
	 * @throws  : SQLException
	 */
	public List<ReservationVO> allReservation() throws SQLException;

	/**
	 * 사내시설 이미지 수정
	 * @param : facilityVO
	 * @return : facilityUpdate
	 * @throws  : SQLException
	 */
	public int facilityUpdate1(FacilityVO facilityVO) throws SQLException;

	/**
	 * 세부 이미지1 수정
	 * @param : facilityVO
	 * @return : facilityUpdate
	 * @throws  : SQLException
	 */
	public int facilityUpdate2(FacilityVO facilityVO) throws SQLException;

	/**
	 * 세부 이미지2 수정
	 * @param : facilityVO
	 * @return : facilityUpdate
	 * @throws  : SQLException
	 */
	public int facilityUpdate3(FacilityVO facilityVO) throws SQLException;

	/**
	 * 이미지 외 정보 수정
	 * @param : facilityVO
	 * @return : facilityUpdate
	 * @throws  : SQLException
	 */
	public int facilityUpdate4(FacilityVO facilityVO) throws SQLException;

}



























