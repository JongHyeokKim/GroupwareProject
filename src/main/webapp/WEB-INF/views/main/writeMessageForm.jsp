<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--==============================================================
 * 메시지 쓰기 페이지
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
<title>쪽지 쓰기</title>
</head>

<body>
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
	<script src="resources/assets/js/jquery-1.12.4.js"></script>
	<script src="treeview/js/jquery.form.js"></script>
	<script src="treeview/js/sweetalert.min.js"></script>
	<script>
		var receiver = "";
		function writeMessage(form) {
			var maxByte = 50; //최대 입력 바이트 수
			var message = $("#mess_title").val();
			var str_len = message.length;
			var totalByte = 0;
			var rlen = 0;
			 var pattern = /^[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]$/; 
			var str2 = "";


			for (var i = 0; i < str_len; i++) { //저금통 소개 글자수 카운트
				var currentByte = message.charCodeAt(i);
			    var currentChar = message.charAt(i);
				if (currentByte > 128) {
					totalByte += 3;
				}
				else if(pattern.test(currentChar)){
					totalByte += 3;
				} else {
					totalByte++;
				}
				if (totalByte <= maxByte) {
					rlen = i + 1; //return할 문자열 갯수
				}
			}

			if (totalByte > maxByte) {
				swal("제목 글자 수 초과", "한글, 특수문자 " + parseInt(maxByte / 3) + " 자 / 영문 "
						+ maxByte + "자를 초과 입력할 수 없습니다.", "warning");
			} else if ($("#mess_title").val() == null
					|| $("#mess_title").val() == ""
					|| $("#mess_get_mem_num").val() == ""
					|| $("#mess_cont").val() == "") {
				swal("형식 오류", "입력이 누란 된 곳이 존재, 제목 또는 수신자,내용 공백입니다.", "warning");
			} else {
				swal({
					title : "송신",
					text : "메시지를 보내시겠습니까?",
					type : "warning",
					showCancelButton : true,
					confirmButtonColor : "#DD6B55",
					confirmButtonText : "예",
					cancelButtonText : "아니오",
					closeOnConfirm : false
				}, function() {
					swal({
						title : "메시지를 보냈습니다.",
						type : "success"
					},
							function() {
								form.action = "sendMessage";
								form.submit();
							});
				});
			}

		}
		var recievers = new Array();
		function getMemberValue() {
			for (var i = 0; i < recievers.length; i++) {
				var code = recievers[i].id;
				var name = recievers[i].name;
				$('#mess_get_mem_num').val(code + "(" + name + ")");

			}
		};
	</script>
	<div class="box-header">
		<h3 class="box-title">
			<strong>쪽지 쓰기</strong>
		</h3>
		<br />
		<div class="box box-info"></div>
	</div>
	<div style="margin-left: 50px; width: 1200px;">
		<div class="box-body">
			<form id="sendMessageForm" class="form-horizontal" method="post">
				<table class="table table-bordered table-hover" border="0">
					<tr>
						<th>제목</th>
						<td><input type="text" id="mess_title" name="mess_title"
							style="width: 100%;" class="form-control"
							placeholder="제목을 입력하시오."></td>
					</tr>
					<tr>
						<th>받는 사람</th>
						<td><input type="text" id="mess_get_mem_num"
							name="mess_get_mem_num" style="width: 80%;" readonly="readonly"
							class="form-control" placeholder="받는사사람을 추가하시오.">
							<button type="button" class="btn btn-danger"
								onclick="window.open('/gw/messageAddressBook','','width=300,height=500,top=300,left=600');">주소록</button></td>
					</tr>

					<tr>
						<th colspan="2">내용</th>
					</tr>
					<tr>
						<td colspan="2"><textarea placeholder="내용을 입력하시오."
								name="mess_cont" id="mess_cont"
								style="width: 100%; height: 320px;" class="form-control"></textarea></td>
					</tr>
				</table>
				<input type="button" style="float: right;" class="btn btn-danger"
					value="쪽지보내기" onclick="return writeMessage(this.form)">
			</form>
		</div>
	</div>
</body>
</html>