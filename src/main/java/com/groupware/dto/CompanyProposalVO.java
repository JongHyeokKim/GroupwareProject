package com.groupware.dto;
/**
 * @Class Name : CompanyProposalVO.java
 * @Description : 제안에 필요한 DB모음
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
public class CompanyProposalVO {
	
	private String prop_code;
	private String prop_day;
	private String prop_tt;
	private String prop_cont;
	private String prop_mem_num;
	private String prop_st;
	private String mem_nm;

	
	public String getMem_nm() {
		return mem_nm;
	}
	public void setMem_nm(String mem_nm) {
		this.mem_nm = mem_nm;
	}
	public String getProp_code() {
		return prop_code;
	}
	public void setProp_code(String prop_code) {
		this.prop_code = prop_code;
	}
	public String getProp_day() {
		return prop_day;
	}
	public void setProp_day(String prop_day) {
		this.prop_day = prop_day;
	}
	public String getProp_tt() {
		return prop_tt;
	}
	public void setProp_tt(String prop_tt) {
		this.prop_tt = prop_tt;
	}
	public String getProp_cont() {
		return prop_cont;
	}
	public void setProp_cont(String prop_cont) {
		this.prop_cont = prop_cont;
	}
	public String getProp_mem_num() {
		return prop_mem_num;
	}
	public void setProp_mem_num(String prop_mem_num) {
		this.prop_mem_num = prop_mem_num;
	}
	public String getProp_st() {
		return prop_st;
	}
	public void setProp_st(String prop_st) {
		this.prop_st = prop_st;
	}

}


























