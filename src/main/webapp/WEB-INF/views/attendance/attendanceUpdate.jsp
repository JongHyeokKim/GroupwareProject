<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<div class="wrapper">


		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper" style="background: white">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<!-- Main content -->
				<section class="content">
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<h3 class="box-title">근태 정보 수정</h3>
								</div>
								<!-- /.box-header -->
								<form action="attendanceUpdateCom" method="get">
								<div class="box-body">
									<table id="example2" class="table table-bordered table-hover">
										<thead>
											<tr>
												<td>사원명</td>
												<td>${attendanceInfo.mem_nm}</td>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>일시</td>
												<td>${attendanceInfo.att_date}</td>
											</tr>

											<tr>
												<td>근태정보</td>
												<td>
													<div class="col-sm-10">
														<select class="form-control" name="att_wk_st_code"
															style="width: 150px;" id="selBox">
															<option value="1" selected="selected">내근</option>
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
								</div>
								<input type="hidden" name="att_date" value="${attendanceInfo.att_date}"> 
								<input type="hidden" name="att_mem_num" value="${attendanceInfo.att_mem_num}"> 
								<input type="submit" value="수정" /> <input type="reset"	value="초기화" />
								</form>
							</div>
						</div>
					</div>
				</section>
			</section>
		</div>
	</div>


	<!-- /.box -->

</body>
</html>

