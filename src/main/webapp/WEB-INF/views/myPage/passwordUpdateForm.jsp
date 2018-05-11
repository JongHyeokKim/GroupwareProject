<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--==============================================================
 * 비밀번호 수정 페이지
 * @author 이준수
 * @since  2016.09.01.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *     수정일              수정자                    수정내용
 *    -------      -------     -------------------
 *   2016.09.01.    이준수                     최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
===============================================================--%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 변경</title>
</head>
<link href="resources/assets/css/bootstrap.css" rel="stylesheet" />
<link href="resources/assets/css/AdminLTE.css" rel="stylesheet" />
<script src='resources/assets/js/scheduler/jquery-1.12.4.js'></script>
<script src="treeview/js/sweetalert.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="treeview/css/sweetalert.css" />
<body onresize="parent.resizeTo(400,400)"
	onload="parent.resizeTo(400,400)" style="overflow: hidden;">
	<style>
.btn-danger {
	float: right;
	margin-top: 30px;
	background-color: #066bb2;
	border-color: #066bb2;
}

.btn-danger:hover {
	background-color: #75D2D5;
}
</style>
	<script>
		var pwd = /[a-z0-9]{8}/;
		function passwordUpdate() {
			if ($("#new_pw").val() != null && $("#new_pw").val() != null
					&& pwd.test($("#new_pw").val())
					&& pwd.test($("#new_pw1").val())) {
				if ($("#new_pw").val() != $("#new_pw1").val()) {
					swal("일치 하지 않음", "비밀번호 확인과 일치하지 않습니다.", "warning");
				} else {
					$.ajax({
						url : "passwordUpdate",
						type : "post",
						data : {
							"new_pw" : $("#new_pw").val()
						},
						success : function() {
							$("#new_pw").val("");
							$("#new_pw1").val("");
							swal("수정", "비밀번호가 수정되었습니다.", "success");
						},
						error : function() {
							swal("통신오류", "에러입니다.", "error");
						}
					});
				}
			} else {
				swal("형식오류", "빈칸, 공백, 특수문자 등 형식 오류입니다.", "warning");
			}
		}
	</script>
	<div class="box-header">
		<h3 class="box-title">
			<strong>비밀번호 변경</strong>
		</h3>
		<br />
		<div class="box box-info"></div>
	</div>
	<div class="box-body" style="width: 95%;">
		<table id="example1" class="table table-bordered table-striped"
			style="margin-left: 10px;">
			<thead>
				<tr>
					<th style="vertical-align: middle; text-align: center;">새 비밀번호</th>
					<td style="text-align: center;"><input type="password"
						id="new_pw" class="form-control"
						style="border-radius: 4px; width: 80%;" maxlength="8"></td>

				</tr>
				<tr>
					<th style="vertical-align: middle; text-align: center;">새 비밀번호
						확인</th>
					<td style="text-align: center;"><input type="password"
						id="new_pw1" class="form-control"
						style="border-radius: 4px; width: 80%;" maxlength="8"></td>

				</tr>
			</thead>
		</table>
		<input type="button" class="btn btn-danger" value="변경"
			onclick="passwordUpdate()">
	</div>
</body>
</html>