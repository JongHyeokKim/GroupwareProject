package com.groupware.dto;
/**
 * @Class Name : BoardVO.java
 * @Description : 게시판에 필요한 DB모음
 * @Modification Vo
 * @author 함박눈
 * @since  2016.08.29.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *   2016.08.29.  함박눈        최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */

public class BoardVO {
	
	private String br_wrt_num;
	private String br_code;
	private String br_tt;
	private String br_writ_day;
	private String br_cont;
	private String br_mem_num;
	private String mem_nm;
	private String br_down_code;
	private String br_file;
	
	
	public String getMem_nm() {
		return mem_nm;
	}
	public void setMem_nm(String mem_nm) {
		this.mem_nm = mem_nm;
	}
	public String getBr_file() {
		return br_file;
	}
	public void setBr_file(String br_file) {
		this.br_file = br_file;
	}
	public String getBr_wrt_num() {
		return br_wrt_num;
	}
	public void setBr_wrt_num(String br_wrt_num) {
		this.br_wrt_num = br_wrt_num;
	}
	public String getBr_code() {
		return br_code;
	}
	public void setBr_code(String br_code) {
		this.br_code = br_code;
	}
	public String getBr_tt() {
		return br_tt;
	}
	public void setBr_tt(String br_tt) {
		this.br_tt = br_tt;
	}
	public String getBr_writ_day() {
		return br_writ_day;
	}
	public void setBr_writ_day(String br_writ_day) {
		this.br_writ_day = br_writ_day;
	}
	public String getBr_cont() {
		return br_cont;
	}
	public void setBr_cont(String br_cont) {
		this.br_cont = br_cont;
	}
	public String getBr_mem_num() {
		return br_mem_num;
	}
	public void setBr_mem_num(String br_mem_num) {
		this.br_mem_num = br_mem_num;
	}
	public String getBr_down_code() {
		return br_down_code;
	}
	public void setBr_down_code(String br_down_code) {
		this.br_down_code = br_down_code;
	}

	
	
	
}
