package com.groupware.dto;
/**
 * @Class Name : AccountVO.java
 * @Description : 게시판 
 * @Modification Vo
 * @author 김준학
 * @since  2016.08.31.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *   2016.08.30.  김준학        최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
public class AccountVO {
	private String ac_code; //거래처 코드
	private String ac_mem_num; //담당사원
	private String ac_nm; //거래처명
	private String ac_em; //이메일
	private String ac_reps; //이메일
	private String ac_tel; //연락처
	private String ac_addr; //주소
	private String ac_dt_addr; //주소
	private String mem_nm;
	
	
	public String getMem_nm() {
		return mem_nm;
	}
	public void setMem_nm(String mem_nm) {
		this.mem_nm = mem_nm;
	}
	public String getAc_dt_addr() {
		return ac_dt_addr;
	}
	public void setAc_dt_addr(String ac_dt_addr) {
		this.ac_dt_addr = ac_dt_addr;
	}
	public String getAc_code() {
		return ac_code;
	}
	public void setAc_code(String ac_code) {
		this.ac_code = ac_code;
	}
	public String getAc_mem_num() {
		return ac_mem_num;
	}
	public void setAc_mem_num(String ac_mem_num) {
		this.ac_mem_num = ac_mem_num;
	}
	public String getAc_nm() {
		return ac_nm;
	}
	public void setAc_nm(String ac_nm) {
		this.ac_nm = ac_nm;
	}
	public String getAc_em() {
		return ac_em;
	}
	public void setAc_em(String ac_em) {
		this.ac_em = ac_em;
	}
	public String getAc_reps() {
		return ac_reps;
	}
	public void setAc_reps(String ac_reps) {
		this.ac_reps = ac_reps;
	}
	public String getAc_tel() {
		return ac_tel;
	}
	public void setAc_tel(String ac_tel) {
		this.ac_tel = ac_tel;
	}
	public String getAc_addr() {
		return ac_addr;
	}
	public void setAc_addr(String ac_addr) {
		this.ac_addr = ac_addr;
	}
	

	
	
}
