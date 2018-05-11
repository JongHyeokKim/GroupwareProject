<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--==============================================================
 * 로그인 페이지
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
<meta charset="utf-8">

<title>로그인</title>
<script src="resources/assets/js/jquery-1.12.4.js"></script>
<script src="treeview/js/jquery.form.js"></script>
<script src="treeview/js/sweetalert.min.js"></script>
<link href="resources/assets/css/login/bootstrap-theme.css"
	rel="stylesheet">
<link href="resources/assets/css/login/style.css" rel="stylesheet">
<link href="resources/assets/css/login/line-icons.css" rel="stylesheet">
<link href="resources/assets/css/login/elegant-icons-style.css"
	rel="stylesheet">
<link href="treeview/css/sweetalert.css" rel="stylesheet">
</head>
<script>
	var id = "";
	var pwd = "";
	$(function() {
		$("#mem_num").focus();
	});

	$("#loginForm").ajaxForm({
		beforeSubmit : function() {
			id = $("#mem_num").val();
			pwd = $("#mem_pw").val();
			if (id == "" || pwd == "") {
				swal("데이터 부족", "아이디와 비밀번호 중 빈칸이 존재합니다.", "warning");
				return false;
			}
		},
		dataType : "text",
		success : function(data) {
			if (data == "login success") {
				swal({
					title : "로그인 성공",
					text : "환영합니다.",
					type : "success"
				}, function() {
					$("#loginForm").ajaxFormUnbind();
					$("#loginForm").attr("action", "sessionProcess");
					$("#loginForm").submit();
				});
			} else if (data == "invalid password") {
				swal("비밀번호 오류", "비밀번호가 맞지 않습니다.", "warning");
			} else if (data == "account not exist") {
				swal("계정 오류", "존재하지 않는 계정입니다.", "warning");
			} else if (data == "network error") {
				swal("통신 오류", "연결 중 오류가 발생했습니다.", "error");
			}
		},
		error : function() {
			swal("통신 오류", "연결 중 오류가 발생했습니다.", "error");
		}
	});
</script>

<body class="login-img3-body">

	<div class="container">
		<form id="loginForm" class="login-form" action="loginCheck"
			method="post">
			<div class="login-wrap">
				<p class="login-img">
					<i class="icon_lock_alt"></i>
				</p>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon_profile"></i></span>
					<input type="text" name="mem_num" id="mem_num" class="form-control"
						placeholder="사원번호">
				</div>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon_key_alt"></i></span>
					<input type="password" id="mem_pw" maxlength="8" name="mem_pw"
						class="form-control" placeholder="패스워드">
				</div>
				<label class="checkbox"> <span class="pull-right"> <a
						href="/gw/passwordChange"> 비밀번호를 잃어버렸나요?</a></span>
				</label> <input type="submit" class="btn btn-primary btn-lg btn-block"
					value="로그인">
			</div>
		</form>

	</div>




</body>
</html>