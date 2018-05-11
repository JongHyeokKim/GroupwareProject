package com.groupware.dto;

/**
 * @Class Name : ElectronicApprovalController.java
 * @Description : 기안서 속성
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
public class Sign_DocumentVO {

	private String sig_doc_num;
	private String sig_doc_tt;
	private String sig_doc_cont;
	private String sig_doc_day; 
	private int sig_doc_classi;
	private int sig_doc_sig_st_num;
	private String sig_doc_mem_num;
	private int sig_doc_sig_lin_num;
	private String sig_doc_down_code;
	private String sig_st_nm;
	private String sig_doc_period;
	private String sig_lin_dt_mem_num;
	private String mem_nm;
	private String sig_lin_dt_pos;
	private String sig_lin_dt_comm;
	private String dep_nm;
	
	
	public String getDep_nm() {
		return dep_nm;
	}
	public void setDep_nm(String dep_nm) {
		this.dep_nm = dep_nm;
	}
	public String getSig_lin_dt_pos() {
		return sig_lin_dt_pos;
	}
	public void setSig_lin_dt_pos(String sig_lin_dt_pos) {
		this.sig_lin_dt_pos = sig_lin_dt_pos;
	}
	public String getSig_lin_dt_comm() {
		return sig_lin_dt_comm;
	}
	public void setSig_lin_dt_comm(String sig_lin_dt_comm) {
		this.sig_lin_dt_comm = sig_lin_dt_comm;
	}
	public String getMem_nm() {
		return mem_nm;
	}
	public void setMem_nm(String mem_nm) {
		this.mem_nm = mem_nm;
	}
	public int getSig_doc_classi() {
		return sig_doc_classi;
	}
	public void setSig_doc_classi(int sig_doc_classi) {
		this.sig_doc_classi = sig_doc_classi;
	}
	public String getSig_lin_dt_mem_num() {
		return sig_lin_dt_mem_num;
	}
	public void setSig_lin_dt_mem_num(String sig_lin_dt_mem_num) {
		this.sig_lin_dt_mem_num = sig_lin_dt_mem_num;
	}
	public String getSig_doc_period() {
		return sig_doc_period;
	}
	public void setSig_doc_period(String sig_doc_period) {
		this.sig_doc_period = sig_doc_period;
	}
	public String getSig_st_nm() {
		return sig_st_nm;
	}
	public void setSig_st_nm(String sig_st_nm) {
		this.sig_st_nm = sig_st_nm;
	}
	public String getSig_doc_num() {
		return sig_doc_num;
	}
	public void setSig_doc_num(String sig_doc_num) {
		this.sig_doc_num = sig_doc_num;
	}
	public String getSig_doc_tt() {
		return sig_doc_tt;
	}
	public void setSig_doc_tt(String sig_doc_tt) {
		this.sig_doc_tt = sig_doc_tt;
	}
	public String getSig_doc_cont() {
		return sig_doc_cont;
	}
	public void setSig_doc_cont(String sig_doc_cont) {
		this.sig_doc_cont = sig_doc_cont;
	}
	public String getSig_doc_day() {
		return sig_doc_day;
	}
	public void setSig_doc_day(String sig_doc_day) {
		this.sig_doc_day = sig_doc_day;
	}
	public int getsig_doc_classi() {
		return sig_doc_classi;
	}
	public void setsig_doc_classi(int sig_doc_classi) {
		this.sig_doc_classi = sig_doc_classi;
	}
	public int getSig_doc_sig_st_num() {
		return sig_doc_sig_st_num;
	}
	public void setSig_doc_sig_st_num(int sig_doc_sig_st_num) {
		this.sig_doc_sig_st_num = sig_doc_sig_st_num;
	}
	public String getSig_doc_mem_num() {
		return sig_doc_mem_num;
	}
	public void setSig_doc_mem_num(String sig_doc_mem_num) {
		this.sig_doc_mem_num = sig_doc_mem_num;
	}
	public int getSig_doc_sig_lin_num() {
		return sig_doc_sig_lin_num;
	}
	public void setSig_doc_sig_lin_num(int sig_doc_sig_lin_num) {
		this.sig_doc_sig_lin_num = sig_doc_sig_lin_num;
	}
	public String getSig_doc_down_code() {
		return sig_doc_down_code;
	}
	public void setSig_doc_down_code(String sig_doc_down_code) {
		this.sig_doc_down_code = sig_doc_down_code;
	}
	

}
