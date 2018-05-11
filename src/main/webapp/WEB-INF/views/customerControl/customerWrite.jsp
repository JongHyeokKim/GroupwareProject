<%--==============================================================
 * 거래처 관리 등록
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
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
	$(function() {
		$("#postcodify_search_button").postcodifyPopUp();
		
		$('#ac_em3').change(function(){
			
			if($(this).children("option:selected").text() == '직접입력'){
				$('#ac_em2').val('');
			}else{
				$('#ac_em2').val($(this).children("option:selected").text());
			}
		});
	});
	
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
		} else if ($("#").val() == "") {
			swal("공백오류","email 주소 필수입니다.","error");
			return false;
		} else if ($("#ac_addr").val() == "") {
			swal("공백 오류","주소 검색 필수","error");
			return false;
		} else{
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
							$("#dataForm").attr("onsubmit","");
							$("#dataForm").submit();
						});
					}else{
						swal("등록 취소","등록이 취소되었습니다.","error");
					}
			});
		}
	}
</script>
	<div class="col-xs-12">
		<div class="box-header">
			<h3 class="box-title">
				<strong>거래처 등록</strong>
			</h3>
			<br />
			<div class="box box-info"></div>
		</div>
		<br />
		<!-- /.box-header -->
		<form id="dataForm" method="post" action="customerWrite" onsubmit="return sendData();">
			<div class="box-body">
				<table id="example2" class="table table-bordered table-hover"
					style="width: 700px; margin-left: 250px;">
					<thead>
						<tr>
							<td style="text-align: center;">거래처명 *</td>
							<td><input type="text" style="width: 100%;" name="ac_nm"
								class="form-control" maxlength="15" pattern="[a-zA-Z0-9가-힣]{1,15}" id="ac_nm" placeholder="거래처명을 1~15 글자로 입력하세요">
								  </td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td style="text-align: center;">대표자</td>
							<td><input type="text" style="width: 100%;" name="ac_reps"
								class="form-control" maxlength="15" pattern="[a-zA-Z0-9가-힣]{1,15}" id="ac_reps" placeholder="대표자명을 입력하세요. (15자 이내로 입력하세요)"></td>
						</tr>
						<tr>
							<td style="text-align: center;">전화번호</td>
							<td><input type="text" style="width: 100%;" name="ac_tel"
								class="form-control" id="ac_tel"
								placeholder="'-'를 뺸  11자리 입력하세요" maxlength="11" pattern="[0-9]{1,11}"></td>
						</tr>
						<tr>
							<td style="text-align: center;">이메일</td>
							<td id="cus_mail"><input type="text" style="width: 37%;"
								id="ac_em" name="ac_em" class="form-control"  maxlength="20"pattern="[a-zA-Z0-9]{1,15}"
								placeholder="20자리 이내 이메일을 입력하세요"> &nbsp; @ &nbsp;
								<input type="text" maxlength="20" id="ac_em2"maxlength="15" name="ac_em2" class="form-control"
								placeholder="직접 입력" style="width: 37%;"> <select
								id="ac_em3" name="ac_em3">
									<option vlaue="직접입력">직접입력</option>
									<option value="naver.com">naver.com</option>
									<option value="daum.net">daum.net</option>
									<option value="nate.com">nate.com</option>
									<option value="google.com">google.com</option>
									<option value="hanmail.com">hanmail.com</option>
							</select></td>
						</tr>
						<tr>
							<td style="text-align: center;">거래처 주소</td>
							<td><input type="text" name="ac_addr" style="width: 80%;"
								id="ac_addr" class="postcodify_address" value=""
								placeholder="거래처 주소" readonly="readonly" /> 
								<input type="button" id="postcodify_search_button" class="btn btn-danger" value="검색" /></td>
						</tr>
						<tr>
							<td style="text-align: center;">상세주소</td>
							<td><input type="text" style="width: 100%;"
								class="form-control" maxlength="20" name="ac_dt_addr" id="ac_dt_addr"
								placeholder="상세주소를 입력하세요"><br>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- /.box-body -->
			<div style="margin-left: 865px; margin-top: 10px;">
				<input type="submit"
					class="btn btn-danger" id="intoWrite" value="저장">
				 <input	type="button" class="btn btn-danger" value="취소"
					onclick="location.href='/gw/customerList';">
			</div>
		</form>
	</div>
	<!-- /.box -->

</body>
</html>

