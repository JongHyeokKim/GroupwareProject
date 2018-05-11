<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
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
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 2 | Data Tables</title>

</head>
<body>
	
	<h3>근태 관리</h3>
	<div style="border: 1px solid gold;">

		<div class="row">
			<div style="border: 1px solid gold;" class="col-md-4 col-md-offset-4">
				<form class="form-horizontal" role="form">

					<!-- Form Name -->
					<div>
						<br>
						<!-- Text input-->
						<div class="form-group">
							<label class="col-sm-2 control-label" for="textinput">부서</label>
							<div class="col-sm-4">
								<div class="form-group">
									<select style="margin-left: 17px;" class="form-control">
										<option>--전체--</option>
										<option>option 2</option>
										<option>option 3</option>
									</select>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!-- /.col-lg-12 -->
		<br> <br>
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">사원관리 조회</h3>
			</div>
			<!-- /.box-header -->
			<div class="box-body">
				<div class="col">
					<div class="form-group">
						<select style="margin-left: 17px;" class="form-control2">
							<option>2016년</option>
							<option>2015년</option>
							<option>2014년</option>
						</select>
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<select style="margin-left: 17px;" class="form-control2">
							<option>8월</option>
							<option>7월</option>
							<option>6월</option>
						</select>
					</div>
				</div>
				<table id="example1" class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>부서</th>
							<th>직급</th>
							<th>사원</th>
							<th>출근</th>
							<th>휴가</th>
							<th>출장</th>
							<th>교육</th>
							<th>훈련</th>
							<th>조회</th>
							<th>당직</th>
							<th>기타</th>
							<th>연장</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td onclick="location.href='attendanceInformation';">총무팀</td>
							<td>계장</td>
							<td>김철수</td>
							<td>30</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
						</tr>
						<tr>
							<td onclick="location.href='attendanceInformation';">인사팀</td>
							<td>대리</td>
							<td>이기수</td>
							<td>40</td>
							<td>1</td>
							<td>1</td>
							<td>1</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
						</tr>
						<tr>
							<td onclick="location.href='attendanceInformation';">총무팀</td>
							<td>계장</td>
							<td>김철수</td>
							<td>30</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
						</tr>
						<tr>
							<td onclick="location.href='attendanceInformation';">총무팀</td>
							<td>계장</td>
							<td>김철수</td>
							<td>30</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
						</tr>
						<tr>
							<td onclick="location.href='attendanceInformation';">총무팀</td>
							<td>계장</td>
							<td>김철수</td>
							<td>30</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
						</tr>
						<tr>
							<td onclick="location.href='attendanceInformation';">총무팀</td>
							<td>팀장</td>
							<td>김이리</td>
							<td>30</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
							<td>0</td>
						</tr>
				</table>
			</div>
			<!-- /.box-body -->
		</div>
	</div>
	<div class="button">
		<input type="button" class="btn btn-danger" value="수정"
			onclick="location.href='attendanceUpdate';"> <input
			type="button" class="btn btn-danger" value="목록"
			onclick="location.href='attendanceList';"> <input
			type="button" class="btn btn-danger" value="출력"
			onclick="location.href='';">
	</div>
</body>
</html>



