<%--==============================================================
 * 사원 상세보기 information
 * @autdor 김성수
 * @since  2016.08.30.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.08.30.  	김성수              최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
===============================================================--%>



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>

<body>

<style type="text/css">
	.bgc{
		background-color: lightgray;
	}
</style>

	<div class="box-header">
		<h3 class="box-title"><strong>사 원 정 보</strong></h3>
		<br />
		<div class="box box-info"></div>
	</div>
	<div style="width: 1200px; margin-left: 50px;">
	<table id="example2" class="table table-bordered"
			style="text-align: center; ">
		<tbody>
			<tr>
				<td width="5%" height="50px"><b>사 원 번 호</b></td>
				<td width="6%">${member.mem_num}</td>

				<td width="5%"><b>입&nbsp;&nbsp;&nbsp;사&nbsp;&nbsp;&nbsp;일</b></td>
				<td width="6%">${member.mem_jn}</td>
			</tr>
			<tr>
				<td height="50px"><b>사&nbsp;&nbsp;&nbsp;원&nbsp;&nbsp;&nbsp;명</b></td>
				<td>${member.mem_nm}</td>
				<td><b>생 년 월 일</b></td>
				<td>${member.mem_reg1}</td>
			</tr>
			<tr>
				<td height="50px"><b>도 로 명 주 소</b></td>
				<td colspan="4">${member.mem_addr}&nbsp;${member.mem_dt_addr}</td>
			</tr>
			<tr>
				<td><b>연&nbsp;&nbsp;&nbsp;락&nbsp;&nbsp;&nbsp;처</b></td>
				<td>${member.mem_tel}</td>
				<td><b>이&nbsp;&nbsp;&nbsp;메&nbsp;&nbsp;&nbsp;일</b></td>
				<td colspan="2">${member.mem_em}</td>
			</tr>
			<tr>
				<td><b>사 원 이 미 지</b></td>
				<td><img id="empImg"
					src="resources/memberManagementImage/${member.mem_img}"
					width="105px" height="140px" /></td>
				<td><b>서 명 이 미 지</b></td>
				<td><img id="signImg"
					src="resources/memberSign/${member.mem_stamp}" alt="your image"
					width="150px" height="150px" /></td>
			</tr>
			<tr>
				<td height="50px"><b>부&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;서</b></td>
				<td>${member.dep_nm}</td>
				<td><b>직&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;책</b></td>
				<td>${member.pos_nm}</td>
			</tr>
			<tr>
				<td height="50px"><b>권&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;한</b></td>
				<td>${member.mem_authority}</td>
				<td><b>퇴&nbsp;&nbsp;&nbsp;사&nbsp;&nbsp;&nbsp;일</b></td>
				<td>${member.mem_rt}</td>
			</tr>
			<tr>
				<td colspan="4"><img src="resources/assets/img/logo1.png"
					style="width: 140px; height: 40px; float: right;"></td>
			</tr>
		</tbody>
	</table>
	<div style="float: right;">
	<br><br><br><br>
		 	<a href="memberInfoPdf?mem_num=${member.mem_num}"> 
				<input type="button" class="btn btn-danger" value="PDF출력">
			</a>
			<a href="memberManagementUpdateForm?mem_num=${member.mem_num}">
				<input type="button" class="btn btn-danger" value="수정">
			</a> 
			<a href="memberManagementList">
				<input type="button" class="btn btn-danger" value="목록">
			</a>
	</div>
	</div>
</body>
</html>



