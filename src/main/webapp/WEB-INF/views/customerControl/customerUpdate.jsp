<%--==============================================================
 * 거래처 관리 업데이트
 * @author 김준학
 * @since  2016.08.29.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.08.29.   김준학      최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
===============================================================--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title></title>
</head>
<body>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
	<script>
	var aa=/[0-9]/;
	$(function() {
		$("#postcodify_search_button").postcodifyPopUp();
	});
	
	/* function onSubmit() {
		if ($(".postcodify_address").val() == "") {
			return false;
		} else {
			return true;
		}
	} */
	function sendData(){
		event.preventDefault();
		if ($("#ac_nm").val() == "") {
			swal("공백 오류","거래처명 필수입니다.","error");
			return false;
		} else if ($("#ac_reps").val() == "") {
			swal("공백 오류","대표자 필수입니다.","error");
			return false;
		} else if ($("#ac_tel").val().length != 11) {
			swal("공백오류","전화번호는 숫자 11자리입니다","error");
			return false;
		} else if ($("#ac_addr").val() == "") {
			swal("공백 오류","주소 검색 필수","error");
			return false;
		} else{
			swal({
				title : "수정 확인",
				text : "수정하시겠습니까?",
				type : "warning",
				showCancelButton : true,
				cancelButtonText : "취소",
				confirmButtonColor : "#3BC1C5",
				confirmButtonText : "확인",
				closeOnConfirm : false,
				closeOnCancel : false
			},
			function(isConfirm){
				if(isConfirm){
					swal({
						title : "수정 완료",
						text : "수정이 완료되었습니다.",
						type : "success"
					},
					function(){
						$("#updateForm").attr("onsubmit","");
						$("#updateForm").submit();
					});
				}else{
					swal("등록 취소","등록이 취소되었습니다.","error");
				}
		});
	}
	}
</script>
	<div class="box-header">
		<input type="hidden" name="ac_mem_num" class="form-control" value="${customerUpdate.ac_mem_num}" >
		<h3 class="box-title">
			<strong>거래처 수정</strong>
		</h3>
		<br />
		<div class="box box-info"></div>
	</div>
	<br />
	<!-- /.box-header -->
	<form id="updateForm" action="customerUpdateCom" method="get" onsubmit="return sendData();">
		<div class="box-body">
			<table id="example2" class="table table-bordered table-hover" style="width: 700px; margin-left: 250px;">
				<thead>
					<tr>
						<td>거래처명</td>
						<td><input type="text" maxlength="15" pattern="[a-zA-Z0-9가-힣]{1,15}" id="ac_nm" class="form-control" name="ac_nm" id="ac_nm" value="${customerUpdate.ac_nm}"></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>대표자</td>
						<td><input type="text" maxlength="15" pattern="[a-zA-Z0-9가-힣]{1,15}" class="form-control" name="ac_reps" id="ac_reps" value="${customerUpdate.ac_reps}"></td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td><input type="text" class="form-control" maxlength="11" pattern="[0-9]{11}" name="ac_tel" id="ac_tel" value="${customerUpdate.ac_tel}"></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="text" class="form-control" name="ac_em" id="ac_em" value="${customerUpdate.ac_em}"></td>
					</tr>
					<tr>
						<td>거래처주소</td>
						<td><input type="text" readonly="readonly" name="ac_addr" id="ac_addr" class="postcodify_address" value="${customerUpdate.ac_addr}"> 
						<input type="button" id="postcodify_search_button"
							class="btn btn-danger" value="검색" /></td>
					</tr>
					<tr>
						<td>상세주소</td>
						<td><input type="text" maxlength="15" pattern="[a-zA-Z0-9가-힣]{1,15}" name="ac_dt_addr" class="form-control" value="${customerUpdate.ac_dt_addr}"></td>
					</tr>
					
					
				</tbody>
			</table>
			<input type="hidden" name="ac_code" class="form-control" value="${customerUpdate.ac_code}" readonly="readonly">
		</div>
		<!-- /.box-body -->
		<div style="margin-left: 865px; margin-top: 10px;">
			<input class="btn btn-danger"  type="submit" value="수정" /> 
			<input type="button" class="btn btn-danger" value="취소" onclick="location.href='/gw/customerList';">
		</div>
	</form>
	<!-- /.box -->

</body>
</html>



