package com.groupware.companyFacility.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupware.dto.FacilityVO;
import com.groupware.dto.ReservationVO;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @Class Name : CompanyFacilityDAOImpl.java
 * @Description : 시설예약 DAOImpl
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

@Repository
public class CompanyFacilityDAOImpl implements ICompanyFacilityDAO{

	@Autowired
	private SqlMapClient client;
	
	//사내시설리스트
	@Override
	public List<FacilityVO> getFacilityList() throws SQLException{
		List<FacilityVO> facilityList = null;
		facilityList = client.queryForList("facility.getFacilityList");
		return facilityList;
	}

	//사내시설등록
	@Override
	public void facilityInsert(FacilityVO facilityVO) throws SQLException {
		client.insert("facility.facilityInsert", facilityVO);
	}

	//사내시설 정보
	@Override
	public FacilityVO getFacilityInfo(String fac_code) throws SQLException {
		FacilityVO facilityVO = null;
		facilityVO = (FacilityVO) client.queryForObject("facility.getFacilityInfo", fac_code);
		return facilityVO;
	}

	//사내시설수정
	@Override
	public int facilityUpdate(FacilityVO facilityVO) throws SQLException {
		int facilityUpdate = 0;
		facilityUpdate = client.update("facility.facilityUpdate", facilityVO);
		return facilityUpdate;
	}

	//사내시설 삭제
	@Override
	public int facilityDelete(String fac_code) throws SQLException {
		int facilityDelete = 0;
		facilityDelete = client.delete("facility.facilityDelete", fac_code);
		return facilityDelete;
	}

	//예약정보 가져오기
	@Override
	public List<ReservationVO> getReserve(String date,String code) throws SQLException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("date", date);
		map.put("code", code);
		List<ReservationVO> reserveList = client.queryForList("reserve.getReserve",map);
		return reserveList;
	}

	//시설예약
	@Override
	public void insertReserve(ReservationVO reserveVO) throws SQLException {
		client.insert("reserve.insertReserve", reserveVO);
	}

	//나의 예약 정보 리스트
	@Override
	public List<ReservationVO> getMyReserveList(ReservationVO reserveVO) throws SQLException {
		List<ReservationVO> getMyReserveList = null;
		getMyReserveList = client.queryForList("reserve.getMyReserveList", reserveVO);
		return getMyReserveList;
	}

	//예약취소
	@Override
	public int reserveCancel(String reserv_code) throws SQLException {
		int reserveCancel = 0;
		reserveCancel = client.delete("reserve.reserveCancel",reserv_code);
		return reserveCancel;
	}

	//전체 예약 리스트
	@Override
	public List<ReservationVO> allReservation() throws SQLException {
		List<ReservationVO> allReservation  = client.queryForList("reserve.allReservation");
		return allReservation;
	}

	//사내시설 이미지 수정
	@Override
	public int facilityUpdate1(FacilityVO facilityVO) throws SQLException {
		int facilityUpdate = 0;
		facilityUpdate = client.update("facility.facilityUpdate1",facilityVO);
		return facilityUpdate;
	}

	//세부이미지1 수정
	@Override
	public int facilityUpdate2(FacilityVO facilityVO) throws SQLException {
		int facilityUpdate = client.update("facility.facilityUpdate2", facilityVO);
		return facilityUpdate;
	}

	//세부이미지2 수정
	@Override
	public int facilityUpdate3(FacilityVO facilityVO) throws SQLException {
		int facilityUpdate = client.update("facility.facilityUpdate3", facilityVO);
		return facilityUpdate;
	}

	//이미지 외 정보 수정
	@Override
	public int facilityUpdate4(FacilityVO facilityVO) throws SQLException {
		int facilityUpdate = client.update("facility.facilityUpdate4", facilityVO);
		return facilityUpdate;
	}

}
























