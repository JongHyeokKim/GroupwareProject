package com.groupware.dto;

public class ProjectVO {
	private String pro_code;	//프로젝트 코드
	private String pro_nm;		//프로젝트명
	private String pro_mm;		//프로젝트내용
	private String pro_beg_day;	//시작일
	private String pro_end_day;	//종료일
	private String cur_seq;
	private String pro_dt_mm;
	private int percent;
	private String paging;
	private String progress;
	private String progress2;
	private String color;
	
	public String getProgress2() {
		return progress2;
	}
	public void setProgress2(String progress2) {
		this.progress2 = progress2;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPaging() {
		return paging;
	}
	public void setPaging(String paging) {
		this.paging = paging;
	}
	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}
	public String getPro_dt_mm() {
		return pro_dt_mm;
	}
	public void setPro_dt_mm(String pro_dt_mm) {
		this.pro_dt_mm = pro_dt_mm;
	}
	public String getCur_seq() {
		return cur_seq;
	}
	public void setCur_seq(String cur_seq) {
		this.cur_seq = cur_seq;
	}
	public String getPro_code() {
		return pro_code;
	}
	public void setPro_code(String pro_code) {
		this.pro_code = pro_code;
	}
	public String getPro_nm() {
		return pro_nm;
	}
	public void setPro_nm(String pro_nm) {
		this.pro_nm = pro_nm;
	}
	public String getPro_mm() {
		return pro_mm;
	}
	public void setPro_mm(String pro_mm) {
		this.pro_mm = pro_mm;
	}
	public String getPro_beg_day() {
		return pro_beg_day;
	}
	public void setPro_beg_day(String pro_beg_day) {
		this.pro_beg_day = pro_beg_day;
	}
	public String getPro_end_day() {
		return pro_end_day;
	}
	public void setPro_end_day(String pro_end_day) {
		this.pro_end_day = pro_end_day;
	}
	
}
