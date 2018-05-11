<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--==============================================================
 * 헤더 페이지
 * @author 함박눈
 * @since  2016.09.01.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *     수정일              수정자                    수정내용
 *    -------      -------     -------------------
 *   2016.09.01.     함박눈                   최초생성
 *   2016.09.15.     이준수                메시지함 추가
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
===============================================================--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Grand Destiny GroupWare</title>
<style>
#logout {
	height: 40px;
}

#mail {
	width: 55px;
}
</style>


</head>
<script type="text/javascript">
	$(function() {
		var eventSource = new EventSource("messageServer");
		eventSource
				.addEventListener(
						"message",
						function(e) {
							var data = e.data.split("\n");
							var data1 = data[0];
							var data2 = data[1];
							if (data1 != 0) {
								$("#new")
										.html(
												"<span class='badge bg-theme'style='position: absolute; right: 190px;'>new</span>");
								swal({
									title : "메시지 도착",
									text : "메시지 함으로 이동하십니까?",
									type : "warning",
									showCancelButton : true,
									confirmButtonColor : "#DD6B55",
									confirmButtonText : "예",
									cancelButtonText : "아니오",
									closeOnConfirm : false,
									closeOncancel : false
								}, function(isConfirm) {
									if (isConfirm) {
										location.href = "/gw/messageList";
										$.ajax({
											url : "newMsgCheck",
											type : "get",
											success : function() {

											}
										});
									} else {
										$.ajax({
											url : "newMsgCheck",
											type : "get",
											success : function() {

											}
										});
									}

								});

							} else if (data2 != 0) {
								$("#new")
										.html(
												"<span class='badge bg-theme'style='position: absolute; right: 190px;'>new</span>");
							} else {
								$("#new").html("");
							}
						}, false);

	});
	function messageList() {
		location.href = "/gw/messageList";
	}
	function mainmove() {
		location.href = "/gw/main";

	}
</script>
<body>

	<div id="wrapper">
		<nav class="navbar navbar-default navbar-cls-top " role="navigation"
			style="margin-bottom: 0;">
			<div class="navbar-header" style="width: 240px; height: 70px;">
				<a class="navbar-brand"><img width="160px"
					src="resources/assets/img/logo123.png" onclick="mainmove();"
					style="margin-left: 12px;" /></a>
			</div>
			<div
				style="color: white; padding: 15px 50px 5px 50px; float: right; font-size: 16px;">
				<a style="cursor: pointer" onclick="messageList()"><img
					style="width: 40px; height: 40px;"
					src="resources/assets/img/message.png" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span id="new"></span> <a href="/gw/emailWrite"><img id="mail"
					style="width: 40px; height: 40px;"
					src="resources/assets/img/mail.png"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="logout"> <img id="logout"
					style="width: 40px; height: 40px;"
					src="resources/assets/img/logout.png"></a>
			</div>

		</nav>

		<!-- /. NAV TOP  -->
	</div>
</body>


</html>