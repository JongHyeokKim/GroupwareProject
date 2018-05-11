<%--==============================================================
 * 파일관리 등록페이지
 * @author 김준학
 * @since  2016.08.31.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.08.31.  김준학      최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
===============================================================--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>파일관리 등록</title>

</head>




<body class="hold-transition skin-blue sidebar-mini">
	
	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-md-12">
					<div class="box-header">
					<h3 class="box-title"><strong>파일함</strong></h3>
	<br/>
 	<div class="box box-info"></div>
					<div class="box-body pad">
						<form action="groupFileWrite" method="post"
							enctype="multipart/form-data" id="dataForm">
							<table>
								<tr>
									<td style="width: 100px; text-align: center;"><b>제목</b></td>
									<td>
										<input type="text" style="width: 1200px;"
											class="form-control" maxlength="20" id="inputName" name="doc_nm">
									</td>
								</tr>
								<tr>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td style="width: 100px; text-align: center; vertical-align: text-top;"><b>내용</b></td>
									<td>
										<textarea id="editor1" rows="10" cols="80" name="doc_cont"></textarea>
									</td>
								</tr>
								<tr>
								<td></td>
								<td><div class="filebox">
								
								
								<input class="upload-name" value="파일선택" disabled="disabled">
								<label for="ex_filename">업로드</label>
								<input type="file" name="file" value="${file.doc_file}"id="ex_filename" class="upload-hidden">
							</div>
							</td>
								</tr>
							</table>

							<br /> 
							<div style="float: right;">
							
							<input type="button" onclick="sendData();" class="btn btn-danger" value="등록">
							<input type="reset" class="btn btn-danger" value="취소"
								onclick="location.href='/gw/groupFileList';">
								</div>
						</form>
					</div>

				<!-- /.box -->
			</div>
				<!-- /.col-->
			</div>
			<!-- ./row -->
		</div>

	</section>


	<!-- CK Editor -->
	<script src="https://cdn.ckeditor.com/4.5.7/standard/ckeditor.js"></script>
	
	<script>
		$(function() {
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
			CKEDITOR.replace('editor1');
			$(".textarea").wysihtml5();
		});
		
		 
		function sendData(){
			if ($("#doc_nm").val() == "") {
				swal("필수 조건","제목은 필수입니다.","info");
				return false;
			} else if ($("#ex_filename").val() == "") {
				swal("필수 조건","파일 첨부는 필수입니다.","info");
				return false;
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
							title : "등록 완료",
							text : "등록이 완료되었습니다.",
							type : "success"
						},
						function(){
							$("#dataForm").submit();
						});
					}else{
						swal("등록 취소","등록이 취소되었습니다.","error");
					}
				});
			}
		}
	</script>




</body>
</html>