<%--==============================================================
 * 나의 예약정보  information
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
		.hoverEvent:hover td{
      	   background-color: #B2EBF4 !important;
  	 	}
	</style>

							<div class="box-header">
								<h3 class="box-title">
									<strong>나의 예약 정보</strong>
								</h3>
								<br />
								<div class="box box-info"></div>
							</div>
							<!-- /.box-header -->
							<div class="box-body"style="width: 1200px; margin-left: 30px;">
								<table id="example2" class="table table-bordered table-hover"
									style="text-align: center;">
									<thead>
										<tr>
											<td width="7%"><b>예약코드</b></td>
											<td><b>시설명</b></td>
											<td><b>일자</b></td>
											<td><b>시간</b></td>
											<td width="10%"><b>예약취소</b></td>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="my" items="${myReserveList}">
											<input type="hidden" id="reserv_code" name="reserv_code"
												value="${my.reserv_code}">
											<tr class="hoverEvent">
												<td style="vertical-align: middle;">${my.reserv_code}</td>
												<td style="vertical-align: middle;">${my.fac_name}</td>
												<td style="vertical-align: middle;">${my.reserv_day}</td>
												<td style="vertical-align: middle;">${my.reserv_time}</td>
												<td style="vertical-align: middle;">
													<button class="btn btn-danger" onclick="myCancle();">예약취소</button>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							
						
					<div style="float: right; margin-top: 20px;">
					<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
						<a href="javascript:location.href='myReservationListExcel'"> 
							<input type="button" class="btn btn-danger" value="Excel 출력">
						</a> 
						<a href="companyFacilityList">
							<button type="button" class="btn btn-danger">목록</button>
						</a>
					</div>
					</div>
	<script type="text/javascript" src="resources/assets/js/facility/facility.js"></script>
		
</body>
</html>
