package com.groupware.dto.attendance;

public class AttendanceVO {
	private String att_date;
	private String att_mem_num;
	private String att_in_time;
	private String att_out_time;
	private String att_wk_st_code;
	private String wk_st_nm;
	private String dep_nm;
	private String pos_nm;
	private String mem_nm;
	
	public String getDep_nm() {
		return dep_nm;
	}
	public void setDep_nm(String dep_nm) {
		this.dep_nm = dep_nm;
	}
	public String getPos_nm() {
		return pos_nm;
	}
	public void setPos_nm(String pos_nm) {
		this.pos_nm = pos_nm;
	}
	public String getMem_nm() {
		return mem_nm;
	}
	public void setMem_nm(String mem_nm) {
		this.mem_nm = mem_nm;
	}
	public String getWk_st_nm() {
		return wk_st_nm;
	}
	public void setWk_st_nm(String wk_st_nm) {
		this.wk_st_nm = wk_st_nm;
	}
	public String getAtt_date() {
		return att_date;
	}
	public void setAtt_date(String att_date) {
		this.att_date = att_date;
	}
	public String getAtt_mem_num() {
		return att_mem_num;
	}
	public void setAtt_mem_num(String att_mem_num) {
		this.att_mem_num = att_mem_num;
	}
	public String getAtt_in_time() {
		return att_in_time;
	}
	public void setAtt_in_time(String att_in_time) {
		this.att_in_time = att_in_time;
	}
	public String getAtt_out_time() {
		return att_out_time;
	}
	public void setAtt_out_time(String att_out_time) {
		this.att_out_time = att_out_time;
	}
	public String getAtt_wk_st_code() {
		return att_wk_st_code;
	}
	public void setAtt_wk_st_code(String att_wk_st_code) {
		this.att_wk_st_code = att_wk_st_code;
	}
	
	
}
