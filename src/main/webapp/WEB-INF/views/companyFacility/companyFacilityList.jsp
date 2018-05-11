<%--==============================================================
 * 사내시설 리스트 information
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
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div class="box-header">
		<h3 class="box-title">
			<strong>시설현황</strong>
		</h3>
		<br />
		<div class="box box-info"></div>
	</div>
	
	<div class="box-body" style="width: 1200px; margin-left: 50px;">

		<c:forEach var="fa" items="${facilityList}">
			<div style="display: inline-block; float: left; margin-left: 50px;">
				<input type="hidden" id="fac_code" name="fac_code"
					value="${fa.fac_code}">
				<table class="table table-bordered table-striped table-hover"
					style="width: 330px; height: 500px; float: left; margin-left: 3px; margin-bottom: 35px;">
					<thead>
						<tr>
							<td colspan="2" style="height: 200px; text-align: center;">
								<img width="300px" height="200px"
								src="resources/facilityImage/${fa.fac_img}"
								alt="User profile picture">
							</td>
						</tr>
						<tr>
							<td style="width: 80px; text-align: center;"><b>시&nbsp;&nbsp;설&nbsp;&nbsp;명</b></td>
							<td style="text-align: center;">${fa.fac_name}</td>
						</tr>
						<%-- <tr>
							<td style="text-align: center;"><b>상세설명</b></td>
							<td style="text-align: center; height: 80px;">${fa.fac_desc}</td>
						</tr> --%>
						<tr align="center">
							<td colspan="2"><a
								href="companyFacilityReservaionForm?fac_code=${fa.fac_code}"
								class="btn btn-danger">시설예약</a> <sec:authorize
									access="hasAnyRole('ROLE_ADMIN')">
									<a href="adminFacilityUpdateForm?fac_code=${fa.fac_code}"
										class="btn btn-danger">시설수정</a>

									<a href="adminFacilityDelete?fac_code=${fa.fac_code}">
										<button class="btn btn-danger" onclick="facDelete();">시설삭제</button>
									</a> 
								</sec:authorize></td>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</c:forEach>
	
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
		</div>
	<div style="float: right;">
		<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
			<input style="float: right" type="button" value="시설등록"
				class="btn btn-danger" onClick="location.href='facilityWriterForm';">
		</sec:authorize>
		<input style="float: right" type="button" value="나의 예약정보"
			class="btn btn-danger"
			onClick="location.href='myCompanyFacilityReservationInformation?mem_num=${memberVO.mem_num}';">
		<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
			<input style="float: right" type="button" value="전체예약정보"
				class="btn btn-danger" onClick="location.href='allReservation';">
		</sec:authorize>
	</div>

	<script type="text/javascript"
		src="resources/assets/js/facility/facility.js"></script>
</body>


</html>