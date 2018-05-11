package com.groupware.companyFacility.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.companyFacility.dao.ICompanyFacilityDAO;
import com.groupware.dto.FacilityVO;
import com.groupware.dto.ReservationVO;

/**
 * @Class Name : CompanyFacilityServiceImpl.java
 * @Description : 시설예약 serviceImpl
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
@Service
public class CompanyFacilityServiceImpl implements ICompanyFacilityService{

	@Autowired
	private ICompanyFacilityDAO facilityDAO;
	
	// 사내시설 리스트
	@Override
	public List<FacilityVO> getFacilityList() {
		List<FacilityVO> facilityList = null;
		try {
			facilityList =  facilityDAO.getFacilityList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return facilityList;
	}

	//사내시설 등록
	@Override
	public void facilityInsert(FacilityVO facilityVO) {
		try {
			facilityDAO.facilityInsert(facilityVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//사내시설 정보
	@Override
	public FacilityVO getFacilityInfo(String fac_code) {
		FacilityVO facilityVO = null;
		try {
			facilityVO = facilityDAO.getFacilityInfo(fac_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return facilityVO;
	}

	//사내시설 수정
	@Override
	public int facilityUpdate(FacilityVO facilityVO) {
		int facilityUpdate = 0;
		try {
			facilityUpdate = facilityDAO.facilityUpdate(facilityVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return facilityUpdate;
	}

	//사내시설 삭제
	@Override
	public int facilityDelete(String fac_code) {
		int facilityDelete = 0;
		try {
			facilityDelete = facilityDAO.facilityDelete(fac_code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return facilityDelete;
	}

	//사내시설 예약리스트
	@Override
	public List<ReservationVO> getReserve(String date,String code) {
		
		List<ReservationVO> reserveList = null;
		try {
			reserveList = facilityDAO.getReserve(date,code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reserveList;
	}

	//예약
	@Override
	public void insertReserve(ReservationVO reserveVO) {
		
		try {
			facilityDAO.insertReserve(reserveVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//나의 예약 정보
	@Override
	public List<ReservationVO> getMyReserveList(ReservationVO reserveVO) {

		List<ReservationVO> getMyReserveList = null;
		try {
			getMyReserveList = facilityDAO.getMyReserveList(reserveVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getMyReserveList;
	}

	//예약취소
	@Override
	public int reserveCancel(String reserv_code) {
		int reserveCancel = 0;
		try {
			reserveCancel = facilityDAO.reserveCancel(reserv_code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reserveCancel;
	}

	//전체예약
	@Override
	public List<ReservationVO> allReservation() {
		List<ReservationVO> allReservation = null;
		try {
			allReservation = facilityDAO.allReservation();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allReservation;
	}

	//수정
	@Override
	public int facilityUpdate1(FacilityVO facilityVO) {
		int facilityUpdate = 0;
		try {
			facilityUpdate = facilityDAO.facilityUpdate1(facilityVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return facilityUpdate;
	}

	//수정
	@Override
	public int facilityUpdate2(FacilityVO facilityVO) {
		int facilityUpdate = 0;
		try {
			facilityUpdate = facilityDAO.facilityUpdate2(facilityVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return facilityUpdate;
	}
	
	//수정
	@Override
	public int facilityUpdate3(FacilityVO facilityVO) {
		int facilityUpdate = 0;
		try {
			facilityUpdate = facilityDAO.facilityUpdate3(facilityVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return facilityUpdate;
	}

	//수정
	@Override
	public int facilityUpdate4(FacilityVO facilityVO) {
		int facilityUpdate = 0;
		try {
			facilityUpdate = facilityDAO.facilityUpdate4(facilityVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return facilityUpdate;
	}



}



































