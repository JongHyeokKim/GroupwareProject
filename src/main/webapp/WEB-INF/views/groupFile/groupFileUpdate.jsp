<%--==============================================================
 * 파일관리 수정
 * @author 김준학
 * @since  2016.09.01.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.09.01.   김준학      최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
===============================================================--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<script>
$(document).ready(
		function() {
			var fileTarget = $('.filebox .upload-hidden');

			fileTarget.on('change', function() { // 값이 변경되면
				if (window.FileReader) { // modern browser
					var filename = $(this)[0].files[0].name;
				} else { // old IE
					var filename = $(this).val().split('/').pop()
							.split('\\').pop(); // 파일명만 추출
				}

				// 추출한 파일명 삽입
				$(this).siblings('.upload-name').val(filename);
			});
		});
		
$(function() {
	// Replace the <textarea id="editor1"> with a CKEditor
	// instance, using default configuration.
	CKEDITOR.replace('editor1');
	//bootstrap WYSIHTML5 - text editor
	$(".textarea").wysihtml5();
});

function onSubmit() {
	if ($("#doc_nm").val() == "") {
		swal("필수 조건","제목은 필수입니다.","info");
		return false;
		/*}  else if ($("#ex_filename").val() == "") {
		swal("필수 조건","파일 첨부는 필수입니다.","info");
		return false; */
	}else {
		swal({
			title : "등록 확인",
			text : "등록하시겠습니까?",
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
					title : "등록완료",
					text : "등록이 완료되었습니다.",
					type : "success"
				},
				function(){
					$("#updateForm").submit();
				});
			}else{
				swal("등록 취소","등록이 취소되었습니다.","error");
			}
		});
		
	}
}
function getFileName(fileObj){
	var filePath = fileObj.value;
	var fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
	$("#attachFileName").val(fileName);
};
</script>
	<!-- CK Editor -->
	<script src="https://cdn.ckeditor.com/4.5.7/standard/ckeditor.js">
	</script>

	<div class="box-header">
		<h3 class="box-title">
			<strong>파일 수정</strong>
		</h3>
		<br />
		<div class="box box-info"></div>
	</div>
	<!-- /.box-header -->
	<div class="box-body">
		<form id="updateForm" action="groupFileUpdateCom" method="POST"
			enctype="multipart/form-data">
			<input type="hidden" value="${groupFileUpdate.doc_code}"
				name="doc_code" />
			<table id="example2" class="table table-bordered table-hover">
				<thead>
					<tr>
						<td style="text-align: center;"><b>제목</b></td>
						<td><input type="text" id="doc_nm" name="doc_nm"
							value="${groupFileUpdate.doc_nm}"></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="text-align: center;"><b>작성자</b></td>
						<td><input type="text" readonly="readonly" name="mem_nm"
							value="${groupFileUpdate.mem_nm}"></td>
					</tr>
					<tr>
						<td style="text-align: center;"><b>작성일</b></td>
						<td><input type="text" name="doc_date" readonly="readonly"
							value="${groupFileUpdate.doc_date}"></td>
					</tr>

				</tbody>
			</table>
			<textarea id="editor1" rows="10" cols="80" name="doc_cont">${groupFileUpdate.doc_cont}</textarea>
			<div class="form-group">
				<div class="btn btn-danger btn-file">
					<i class="fa fa-paperclip"></i> 첨부 파일 <input type="file"
						name="file" id="file" onchange="getFileName(this);">
				</div>
				<input id="attachFileName" class="form-control" style="width: 40%;"
					readonly="readonly" value="${groupFileUpdate.doc_file}">
			</div>
			<div style="float: right;">
				<input type="button" onclick="onSubmit();" class="btn btn-danger"
					value="수정" /> <a href=groupFileList><input type="button"
					class="btn btn-danger" value="취소"></a>
			</div>
		</form>
	</div>


	<!-- /.box -->

</body>
</html>

