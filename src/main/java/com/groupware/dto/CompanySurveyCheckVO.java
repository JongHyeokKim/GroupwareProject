package com.groupware.dto;
/**
 * @Class Name : CompanySurveyCheckVO.java
 * @Description : 설문 여부에 필요한 DB모음
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
public class CompanySurveyCheckVO {
	private String res_dup_res_code;
	private String res_dup_mem_num;
	
	public String getRes_dup_res_code() {
		return res_dup_res_code;
	}
	public void setRes_dup_res_code(String res_dup_res_code) {
		this.res_dup_res_code = res_dup_res_code;
	}
	public String getRes_dup_mem_num() {
		return res_dup_mem_num;
	}
	public void setRes_dup_mem_num(String res_dup_mem_num) {
		this.res_dup_mem_num = res_dup_mem_num;
	}

}
