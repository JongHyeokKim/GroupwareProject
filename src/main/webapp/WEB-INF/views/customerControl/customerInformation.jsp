<%--==============================================================
 * 거래처 관리 상세 정보
 * @author 김준학
 * @since  2016.08.29.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.08.29.   김준학      최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
===============================================================--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>id
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
a
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div class="box-header">
		<h3 class="box-title">
			<strong>거래처 정보</strong>
		</h3>
		<br />
		<div class="box box-info"></div>
	</div>
	<br />
	<!-- /.box-header -->
	<div class="box-body" style="width: 700px; margin-left: 250px;">
		<table id="example2" class="table table-bordered">
			<thead>
				<tr style="text-align: center;">
					<td width="25%"><strong>거래처명</strong></td>
					<td>${accountInfo.ac_nm}</td>
				</tr>
			</thead>
			<tbody>
				<tr style="text-align: center;">
					<td><strong>대표자</strong></td>
					<td>${accountInfo.ac_reps}</td>
				</tr>
				<tr style="text-align: center;">
					<td><strong>사업자번호</strong></td>
					<td>${accountInfo.ac_code}</td>
				</tr>
				<tr style="text-align: center;">
					<td><strong>전화번호</strong></td>
					<td>${accountInfo.ac_tel}</td>
				</tr>
				<tr style="text-align: center;">
					<td><strong>이메일</strong></td>
					<td>${accountInfo.ac_em}</td>
				</tr>
				<tr style="text-align: center;">
					<td><strong>거래처주소</strong></td>
					<td>${accountInfo.ac_addr}</td>
				</tr>
				<tr style="text-align: center;">
					<td><strong>담당사원</strong></td>
					<td>${accountInfo.mem_nm}</td>
				</tr>

			</tbody>
			<tfoot>

			</tfoot>
		</table>
	</div>

	<!-- /.box-body -->
	<div style="margin-left: 780px; margin-top: 10px;">
		<sec:authorize access="hasAnyRole('ROLE_LEADER','ROLE_ADMIN')">
			<a href="customerUpdate?ac_code=${accountInfo.ac_code}"> <input
				type="button" class="btn btn-danger" value="수정"></a>
			<a href="customerDelete?ac_code=${accountInfo.ac_code}"> <input
				type="button" class="btn btn-danger" value="삭제"></a>
		</sec:authorize>
		<c:set value='${loginUser.mem_authority}' var="auto" />
		<c:if
			test="${loginUser.mem_num==accountInfo.ac_mem_num&&auto=='ROLE_USER'}">
			<a href="customerUpdate?ac_code=${accountInfo.ac_code}"><input
				type="button" class="btn btn-danger" value="수정"></a>
			<a href="customerDelete?ac_code=${accountInfo.ac_code}"><input
				type="button" class="btn btn-danger" value="삭제"></a>
		</c:if>
		<a href="customerList"><input type="button" class="btn btn-danger"
			value="목록"></a>
	</div>
	<script type="text/javascript" src="resources/assets/js/customer/customer.js"></script>



</body>
</html>

