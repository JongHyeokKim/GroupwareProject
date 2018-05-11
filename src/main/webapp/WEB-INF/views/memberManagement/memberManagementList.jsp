<%--==============================================================
 * 사원리스트
 * @author 김성수
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

	<script>
	$(function() {
		$("#example1").DataTable();
	});

	function memberSearch(form) {
		form.action = "memberSearch";
		form.method = "get";
		form.target = "_self";
		form.submit();
	}
	
</script>
	<style type="text/css">
.hoverEvent:hover td {
	background-color: #B2EBF4 !important;
}

#example1_filter {
	display: none !important;
}

#example1_info {
	display: none !important;
}
</style>
	<section class="content">
		<div class="box-header">
			<h3 class="box-title">
				<strong>사원 조회</strong>
			</h3>
			<br />
			<div class="box box-info"></div>
		</div>
		<div style="margin-left: 30px; width: 1200px;">
			<div class="box-tools" style="float: right;">
				<form>
					<div style="float: left;">
						<select class="form-control2" name="searchKey" id="searchKey">
							<option value="사원명" selected="selected">사원명</option>
							<option value="부서명">부서명</option>
							<option value="직책명">직책명</option>
							<option value="퇴사자">퇴사자</option>
						</select>
					</div>

					<div class="input-group input-group-sm" style="width: 200px;">
						<input type="text" name="searchKeyword" id="searchKeyword"
							class="form-control pull-right" placeholder="search">

						<div class="input-group-btn">
							<button class="btn btn-default"
								onclick="memberSearch(this.form);">
								<i class="fa fa-search"></i>
							</button>
						</div>
					</div>
				</form>


			</div>
			<!-- /.box-header -->
			<div class="box-body">
				<table id="example1"
					class="table table-bordered table-striped table-hover">
					<thead>
						<tr style="font-size: 17px;">
							<th class="list" style="vertical-align: middle;" width="10%">사원이미지</th>
							<th class="list" style="vertical-align: middle;" width="10%">사원번호</th>
							<th class="list" style="vertical-align: middle;" width="10%">사원명</th>
							<th class="list" style="vertical-align: middle;" width="10%">부서</th>
							<th class="list" style="vertical-align: middle;" width="10%">직책</th>
							<th class="list" style="vertical-align: middle;" width="15%">연락처</th>
							<th class="list" style="vertical-align: middle;" width="20%">이메일</th>
							<th class="list" style="vertical-align: middle;" width="20%">입사일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="member" items="${memberList}">
							<tr class="hoverEvent"
								onclick="location.href='memberManagementInformation?mem_num=${member.mem_num}'">
								<td class="list" style="vertical-align: middle;"><img
									src="resources/memberManagementImage/${member.mem_img}"
									width="40px" height="54px" /></td>
								<td class="list" style="vertical-align: middle;">${member.mem_num}</td>
								<td class="list" style="vertical-align: middle;">${member.mem_nm}</td>
								<td class="list" style="vertical-align: middle;">${member.dep_nm}</td>
								<td class="list" style="vertical-align: middle;">${member.pos_nm}</td>
								<td class="list" style="vertical-align: middle;">${member.mem_tel}</td>
								<td class="list" style="vertical-align: middle;">${member.mem_em}</td>
								<td class="list" style="vertical-align: middle;">${member.mem_jn}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div style="float: right;">
					<a href="memberManagementWriteForm"> 
						<input type="button" class="btn btn-danger" value="사원등록">
					</a> 
					<a href="javascript:location.href='memberListExcel'"> 
						<input type="button" class="btn btn-danger" value="Excel 출력">
					</a>
					<c:if test="${searchKeyword!=null}">
					<a href="javascript:location.href='searchListExcel?searchKey=${searchKey}&searchKeyword=${searchKeyword}'">
						<input type="button" class="btn btn-danger" value="검색 Excel 출력">
					</a>
					</c:if>
				</div>
			</div>

		</div>
	</section>

	<link rel="stylesheet" href="resources/assets/css/memberManagement.css" type="text/css" />
</body>
</html>
