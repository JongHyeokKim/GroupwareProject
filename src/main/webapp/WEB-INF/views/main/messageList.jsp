<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--==============================================================
 * 메시지함 페이지
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
<title>쪽지함</title>
</head>
<body>
<style>
th {
	text-align: center;
}

.table {
	width: 100%;
}

.box-body {
	padding-left: 10px;
	padding-right: 10px;
}

.hoverEvent:hover td {
	background-color: #B2EBF4 !important;
}

#example1_filter {
	display: none !important;
}

#example1_info {
	display: none !important;
}
</style>
	<script>
$(function () {
	$.ajax({
		url : "newMsgCheck",
		type : "get",
		success : function(){
			
		}
	});
  $("#example1").DataTable({
      "bSort" : false,
      "sLengthMenu" : false
  });
  
  setInterval(function(){
	  $(".hoverEvent td .bg-theme").toggle();
	  }, 500);

});
function writeMessage(){
	location.href="/gw/writeMessageForm";
}
function detailMessage(mess_num){
	location.href='deMessage?mess_num='+mess_num;
}
</script>
	<div class="box-header">
		<h3 class="box-title">
			<strong>쪽 지 함</strong>
		</h3>
		<br />
	</div>
	<div class="box box-info"></div>
	<div class="box-body" style="margin-left: 60px; width: 1200px;">
		<table id="example1" class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>쪽지번호</th>
					<th>제목</th>
					<th>보낸사람</th>
					<th>보낸시각</th>
					<th>읽음 여부</th>
				</tr>
			</thead>
			<c:forEach var="messageVO" items="${sessionScope.messageList}" begin="0"
				varStatus="status">
				<tr class="hoverEvent" style="font-size: 17px;"
					onclick="detailMessage(${messageVO.mess_num});">
					<td style="width: 10%; text-align: center;">${status.count}</td>
					<td style="width: 30%; text-align: left;"><c:if
							test="${messageVO.mess_check eq'N'}">
							<span class='badge bg-theme' style="position: absolute;">new</span>
						</c:if> <span style="margin-right: 40px;"></span> ${messageVO.mess_title}
					</td>
					<td style="width: 20%; text-align: center;">${messageVO.mess_get_mem_num}</td>
					<td style="width: 20%; text-align: center;">${messageVO.mess_time}</td>
					<c:if test="${messageVO.mess_check eq 'N'}">
						<td style="color: red; width: 20%; text-align: center;">${messageVO.mess_check}</td>
					</c:if>
					<c:if test="${messageVO.mess_check eq 'Y'}">
						<td style="color: blue; width: 20%; text-align: center;">${messageVO.mess_check}</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
		<input type="button" style="float: right; margin-top: 30px;"
			class="btn btn-danger" value="쪽지쓰기" onclick="writeMessage();">
	</div>
</body>
</html>