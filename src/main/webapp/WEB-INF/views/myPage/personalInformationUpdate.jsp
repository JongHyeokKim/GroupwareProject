<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%--==============================================================
 * 개인정보 수정 페이지
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
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title></title>
</head>
<body>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>

	<script>
		$(function() {
			var email = "${memberVO.mem_em}";
			var array = email.split("@");
			$("#mem_em").val(""+array[0]+"");
			$("select#domain>option[value='"+array[1]+"']").attr("selected",true);
			function search() {
				$(".postcodify_address").val() == "";
			}
			$("#postcodify_search_button").postcodifyPopUp();
		});
		function onSubmit(form) {
			var frm = document.frm;
			var name = /[a-zA-Z가-힣]{2,4}/;
			var addr = /[a-zA-Z0-9가-힣]{1,20}/;
			var tel = /[010][1-9]{1}[0-9]{3}[0-9]{4}/;
			var mail = /^[a-zA-Z0-9]{1,15}$/;
			if ($("#mem_nm").val() == "") {
				swal("공백", "사원명 필수입니다.", "warning");
				return false;
			} else if (!name.test($("#mem_nm").val())) {
				swal("공백", "사원명에 특수문자 및 숫자를 사용할 수 없습니다.", "warning");
				frm.mem_nm.select();
				return false;
			}  else if ($("#mem_em").val() == "") {
				swal("필수 사항 공백", "email 주소 필수입니다.", "warning");
				frm.mem_em.select();
				return false;
			} else if (!mail.test($("#mem_em").val())) {
				swal("형식 오류", "이메일은 영소문자와 숫자로 입력하세요", "warning");
				frm.mem_em.select();
				return false;
			} else if ($("#mem_addr").val() == "") {
				swal("필수 사항 공백", "주소 검색 필수입니다.", "warning");
				return false;
			} else if ($("#mem_dt_addr").val() == "") {
				swal("필수 사항 공백", "상세주소 필수입니다.", "warning");
				return false;
			} else if (!addr.test($("#mem_dt_addr").val())) {
				swal("형식 오류", "상세주소에 특수문자 사용 불가합니다.", "warning");
				frm.mem_dt_addr.select();
				return false;
			} else if ($("#mem_tel").val() == "") {
				swal("공백", "연락처 공백 불가합니다.", "warning");
				return false;
			} else {
				swal({
					title : "정말 수정하시겠습니까?",
					text : "",
					type : "warning",
					showCancelButton : true,
					confirmButtonColor : "#DD6B55",
					confirmButtonText : "예",
					cancelButtonText : "아니오",
					closeOnConfirm : false
				}, function() {
					swal({
						title : "수정되었습니다",
						type : "success"
					}, function() {
						form.action = "personalInformationUpdate";
						form.submit();
					});
				});
			}
			return false;
		}

		function onCancel() {
			location.href = "personalInformation";
		}
	</script>

	<div class="box-header">
		<h3 class="box-title">
			<strong>개인정보 수정</strong>
		</h3>
		<br />
		<div class="box box-info"></div>
	</div>

	<form name="frm" class="form-horizontal form-label-left" method="post">
		<table class="table table-bordered table-hover"
			style="text-align: center; margin-left: 50px; width: 1200px;">
			<tr>
				<td style="vertical-align: middle;">사원번호</td>
				<td><input type="text" class="form-control" name="mem_num"
					style="width: 100%;" value="${memberVO.mem_num}"
					readonly="readonly"></td>
				<td style="vertical-align: middle;">사원명</td>
				<td><input type="text" class="form-control" name="mem_nm"
					id="mem_nm" style="width: 100%;" pattern="[가-힣]{2,4}"
					placeholder="한글로 입력해주세요" value="${memberVO.mem_nm}"></td>
			</tr>
			<tr>
				<td style="vertical-align: middle;">비밀번호</td>
				<td colspan="3"><input type="button" class="btn btn-danger"
					onclick="window.open('/gw/passwordCheckForm','','width=400,height=400,top=200,left=700');"
					value="비밀번호변경" style="float: left; width: 20%;" /></td>
			</tr>
			<tr>
				<td style="vertical-align: middle;">이메일 주소</td>
				<td colspan="3"><input type="text" class="form-control"
					placeholder="이메일을 입력해주세요(정확히 입력해야 임시비밀번호를 발송 받을 수 있습니다)"
					pattern="[a-zA-Z0-9]" name="mem_em" id="mem_em"
					style="width: 50%; float: left;" value=""><span
					style="float: left;">&nbsp;@&nbsp;</span> <select id="domain"
					name="domain" style="float: left; width: 20%;">
						<option value="gmail.com">gmail.com</option>
						<option value="naver.com">naver.com</option>
				</select></td>

			</tr>
			<tr>
				<td style="vertical-align: middle;">도로명주소<br />(상세주소)
				</td>
				<td colspan="3"><input type="text" name="mem_addr"
					id="mem_addr" style="width: 50%; float: left;"
					class="postcodify_address" value="${memberVO.mem_addr}" /> <input
					type="button" style="float: left;" id="postcodify_search_button"
					name="mem_addr" class="btn btn-danger" onclick="search()"
					value="검색"> <br /> <input type="text" name="mem_dt_addr"
					name="mem_dt_addr" id="mem_dt_addr" style="width: 100%;"
					class="form-control" placeholder="상세 주소 입력해 주세요"
					class="postcodify_details" value="${memberVO.mem_dt_addr}" /></td>
			</tr>
			<tr>
				<td style="vertical-align: middle;">연락처</td>
				<td colspan="3"><input type="text" class="form-control"
					id="mem_tel" name="mem_tel" style="width: 100%;"
					value="${memberVO.mem_tel}" pattern="010[1-9]{3,4}[0-9]{4}"
					title="숫자만 입력 가능합니다."
					placeholder="010으로 시작 11자리 '-'제외 ex)01012345678 " maxlength="11"></td>
			</tr>
			<tr>
				<td style="vertical-align: middle;">직급</td>
				<td><input type="text" class="form-control" name="pos_nm"
					style="width: 100%;" value="${memberVO.pos_nm}" readonly="readonly"></td>
				<td style="vertical-align: middle;">부서</td>
				<td><input type="text" class="form-control" name="dep_nm"
					style="width: 100%;" value="${memberVO.dep_nm}" readonly="readonly"></td>
			</tr>
			<tr>
				<td style="vertical-align: middle;">입사일</td>
				<td colspan="3"><input type="text" class="form-control"
					name="mem_jn" style="width: 100%;" value="${memberVO.mem_jn}"
					readonly="readonly"></td>
			</tr>

		</table>

		<div style="float: right;">
			<input type="button" class="btn btn-danger"
				onclick="return onSubmit(this.form)" value="수정"> <input
				type="button" class="btn btn-danger" onclick="onCancel()" value="취소">
		</div>
	</form>






</body>
</html>