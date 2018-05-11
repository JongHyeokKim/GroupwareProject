<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--==============================================================
 * 현재 비밀번호 확인 페이지
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
<title>비밀번호 확인</title>
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
		function passwordCheck() {
			$.ajax({
				url : "passwordCheck",
				type : "post",
				data : {
					"cur_pw" : $("#cur_pw").val()
				},
				dataType : "text",
				success : function(data) {
					if (data != "pwd") {
						swal("비밀번호 오류", "비밀번호가 다릅니다.", "warning");
					} else {
						location.href = "/gw/passwordUpdateForm";
					}
				},
				error : function() {
					swal("에러","에러","error");
				}
			});
		}
	</script>
	<div class="box-header">
		<h3 class="box-title">
			<strong>현재 비밀번호 입력</strong>
		</h3>
		<br />
		<div class="box box-info"></div>
	</div>
	<div class="box-body" style="width: 95%;">
		<table id="example1" class="table table-bordered table-striped"
			style="margin-left: 10px;">
			<tr>
				<th style="vertical-align: middle; text-align: center;">현재 비밀번호</th>
				<td style="text-align: center;"><input type="password"
					id="cur_pw" name="curr_pw" class="form-control"
					style="border-radius: 4px; width: 80%;" maxlength="8"></td>
			</tr>
		</table>
		<input type="button" class="btn btn-danger" value="확인"
			onclick="passwordCheck()">
	</div>
</body>
</html>