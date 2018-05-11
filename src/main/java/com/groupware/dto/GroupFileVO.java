package com.groupware.dto;
/**
 * @Class Name : AccountVO.java
 * @Description : 파일함
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
public class GroupFileVO {
	
	private String doc_code; //문서 코드(기본키)
	private String doc_nm; //문서명(제목)
	private String doc_cont;//문서 내용
	private String doc_date; //작성일
	private String doc_mem_num; //작성자
	private String doc_file; //업로드
	private String mem_nm;	//사원이름
	
	
	public String getDoc_code() {
		return doc_code;
	}
	public void setDoc_code(String doc_code) {
		this.doc_code = doc_code;
	}
	public String getDoc_nm() {
		return doc_nm;
	}
	public void setDoc_nm(String doc_nm) {
		this.doc_nm = doc_nm;
	}
	public String getDoc_cont() {
		return doc_cont;
	}
	public void setDoc_cont(String doc_cont) {
		this.doc_cont = doc_cont;
	}
	public String getDoc_date() {
		return doc_date;
	}
	public void setDoc_date(String doc_date) {
		this.doc_date = doc_date;
	}
	public String getDoc_mem_num() {
		return doc_mem_num;
	}
	public void setDoc_mem_num(String doc_mem_num) {
		this.doc_mem_num = doc_mem_num;
	}
	public String getDoc_file() {
		return doc_file;
	}
	public void setDoc_file(String doc_file) {
		this.doc_file = doc_file;
	}
	public String getMem_nm() {
		return mem_nm;
	}
	public void setMem_nm(String mem_nm) {
		this.mem_nm = mem_nm;
	}
	
	
	
	
 
	
	
}
