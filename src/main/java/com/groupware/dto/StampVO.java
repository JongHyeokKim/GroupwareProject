/**
 * @Class Name : ElectronicApprovalController.java
 * @Description : 승인 정보
 * @Modification Information
 * @author 박진우
 * @since  2016.08.31.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.08.31.  박진우        최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
 */
package com.groupware.dto;

public class StampVO {
	private String mem_stamp;
	private String sig_lin_dt_pref;
	private String sig_lin_dt_mem_num;
	private String sig_lin_dt_st;
	private String sig_lin_dt_pos;
	
	public String getSig_lin_dt_pos() {
		return sig_lin_dt_pos;
	}

	public void setSig_lin_dt_pos(String sig_lin_dt_pos) {
		this.sig_lin_dt_pos = sig_lin_dt_pos;
	}

	public String getSig_lin_dt_st() {
		return sig_lin_dt_st;
	}

	public void setSig_lin_dt_st(String sig_lin_dt_st) {
		this.sig_lin_dt_st = sig_lin_dt_st;
	}

	public String getSig_lin_dt_pref() {
		return sig_lin_dt_pref;
	}

	public void setSig_lin_dt_pref(String sig_lin_dt_pref) {
		this.sig_lin_dt_pref = sig_lin_dt_pref;
	}

	public String getSig_lin_dt_mem_num() {
		return sig_lin_dt_mem_num;
	}

	public void setSig_lin_dt_mem_num(String sig_lin_dt_mem_num) {
		this.sig_lin_dt_mem_num = sig_lin_dt_mem_num;
	}

	public String getMem_stamp() {
		return mem_stamp;
	}

	public void setMem_stamp(String mem_stamp) {
		this.mem_stamp = mem_stamp;
	}
	
	
}
