<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--==============================================================
 * 근태 관리 수정
 * @author 김준학
 * @since  2016.09.05.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일      		 수정자          		수정내용
 *    -------      -------     -------------------
 *    2016.09.05.   김준학      			최초생성
 	  2016.09.10	김태균				기능 구현 및 개선
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
===============================================================--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<style type="text/css">
	thead tr th{
		background-color: #D5D5D5;
		border-color: #BDBDBD !important;	
	}
	#example2{
		border-top-color: #BDBDBD !important;
	}
	#example2 tbody tr td:not(#stateInfo){
		padding-left: 25px;
	}
	.center{
		text-align: center;
	}
</style>
	<script type="text/javascript">
		$(function(){
			$("#selBox").val("<c:out value='${attendanceInfo.att_wk_st_code}'/>");
		});
	</script>
	
							<div class="box-header">
					<h3 class="box-title"><strong>근태 정보</strong></h3>
	<br/>
 	<div class="box box-info"></div>
					</div>
					<br />
								<!-- /.box-header -->
								<form action="attendanceUpdate" method="get">
								<div class="box-body" style="display:inline-block;">
									<table id="example2" class="table table-bordered table-hover" style="margin-left: 230px; width: 780px;">
										<tbody>
											<tr>
												<td class="center">사원명</td>
												<td class="center">${attendanceInfo.mem_nm}</td>
											</tr>
											<tr>
												<td class="center">부서명</td>
												<td class="center">${attendanceInfo.dep_nm}</td>
											</tr>
											<tr>
												<td class="center">직급</td>
												<td class="center">${attendanceInfo.pos_nm}</td>
											</tr>
											<tr>
												<td class="center">일시</td>
												<td class="center">${attendanceInfo.att_date}</td>
											</tr>
											<tr>
												<td class="center">출근 시간</td>
												<td class="center">${attendanceInfo.att_in_time}</td>
											</tr>
											<tr>
												<td class="center">퇴근 시간</td>
												<td class="center">${attendanceInfo.att_out_time}</td>
											</tr>
											<tr>
												<td class="center">근태정보</td>
												<td id="stateInfo"  class="center">
													<div class="col-sm-10">
														<select class="form-control" name="att_wk_st_code" style="margin-left: 130px; width: 150px;" id="selBox">
															<option value="1">내근</option>
															<option value="2">외근</option>
															<option value="3">조퇴</option>
															<option value="4">결근</option>
															<option value="5">지각</option>
															<option value="6">출장</option>
															<option value="7">병가</option>
															<option value="8">휴가</option>
															<option value="9">경조</option>
															<option value="10">병무</option>
															<option value="11">정직</option>
														</select>
													</div>
												</td>
											</tr>

										</tbody>
										<tfoot>
										</tfoot>
									</table>
									<input type="hidden" name="att_date" value="${attendanceInfo.att_date }">
									<input type="hidden" name="att_mem_num" value="${attendanceInfo.att_mem_num }">
									<!-- /.box-body -->
									<div class="form-group" style="display: inline-block; margin-top: 20px;">
										<div style="float: right;">
											<input type="submit" class="btn btn-danger" value="수정">
											<input type="button" class="btn btn-danger" value="목록" onclick="javascript:location.href='attendanceList'">
										</div>
									</div>
								</div>
								<!-- /.box -->
								</form>
							
</body>
</html>

