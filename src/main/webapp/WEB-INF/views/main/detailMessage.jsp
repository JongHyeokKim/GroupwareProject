<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--==============================================================
 * 메시지 상세보기 페이지
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
<title>쪽지</title>
</head>
<link href="resources/assets/css/AdminLTE.css" rel="stylesheet" />
<link href="resources/assets/css/bootstrap.css" rel="stylesheet" />
<link href="treeview/css/sweetalert.css" rel="stylesheet">
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
</style>
<body>
<script type="text/javascript">
$(function(){
		history.pushState(null, null, location.href); 
		window.onpopstate = function(event) { 
		history.go(1); 
	}
});
</script>
	<div class="box-header">
		<h3 class="box-title">
			<strong>쪽지</strong>
		</h3>
		<br />
		<div class="box box-info"></div>
	</div>
	<div class="box-body" style="width: 1200px; margin-left: 50px;">
		<table class="table table-bordered table-hover" border="0">
			<tr>
				<th>제목</th>
				<td><input type="text" id="mess_title" name="mess_title"
					style="width: 100%;" class="form-control"
					value="${messageVO.mess_title}" readonly="readonly"></td>
			</tr>
			<tr>
				<th>보낸 사람</th>
				<td><input type="text" id="mess_get_mem_num"
					name="mess_get_mem_num" style="width: 100%;" class="form-control"
					value="${messageVO.mess_get_mem_num}" readonly="readonly"></td>
			</tr>

			<tr>
				<th colspan="2">내용</th>
			</tr>
			<tr>
				<td colspan="2"><textarea readonly="readonly" name="mess_cont"
						id="mess_cont" style="width: 100%; height: 320px;"
						class="form-control">${messageVO.mess_cont}</textarea></td>
			</tr>
		</table>
		<br /> <input type="button" style="float: right;"
			class="btn btn-danger" value="목록"
			onclick="location.href='/gw/messageList'"> <a
			href="messageDelete?mess_num=${messageVO.mess_num}"><input
			type="button" style="float: right;" class="btn btn-danger" value="삭제"></a>
	</div>
</body>
</html>