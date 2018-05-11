<%--==============================================================
 * 전체 예약 정보
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

	<style type="text/css">
.hoverEvent:hover td {
	background-color: #B2EBF4 !important;
}
</style>

							<div class="box-header">
								<h3 class="box-title">
									<strong>전체 예약정보</strong>
								</h3>
								<br />
								<div class="box box-info"></div>
							</div>
							<div style="width: 1200px; margin-left: 30px;">
							<!-- /.box-header -->
							<div class="box-body">
								<table id="example2" style="text-align: center;"
									class="table table-bordered table-hover">
									<thead>
										<tr>
											<td><b>예약코드</b></td>
											<td><b>시설명</b></td>
											<td><b>예약날짜</b></td>
											<td><b>예약시간</b></td>
											<td><b>예약사원</b></td>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="all" items="${allReservation}">
											<tr class="hoverEvent">
												<td>${all.reserv_code}</td>
												<td>${all.fac_name}</td>
												<td>${all.reserv_day}</td>
												<td>${all.reserv_time}</td>
												<td>${all.mem_nm}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
					<div style="float: right; margin-top: 20px;">
						<br><br><br><br>
						<a href="javascript:location.href='allReservationListExcel'"> 
							<input type="button" class="btn btn-danger" value="Excel 출력">
						</a> 
						<a href="companyFacilityList">
							<button type="submit" class="btn btn-danger">목록</button>
						</a>
					</div>
						</div>

		
</body>
</html>
