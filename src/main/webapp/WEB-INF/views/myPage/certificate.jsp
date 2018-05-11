<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%--==============================================================
 * 증명서 출력 페이지
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

	<link rel="stylesheet" href="resources/assets/css/jqx.base.css" type="text/css" />
	<script type="text/javascript" src="resources/assets/js/miniCalendar/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="resources/assets/js/miniCalendar/jqxcore.js"></script>
	<script type="text/javascript" src="resources/assets/js/miniCalendar/jqxdatetimeinput.js"></script>
	<script type="text/javascript" src="resources/assets/js/miniCalendar/jqxcalendar.js"></script>
	<script type="text/javascript" src="resources/assets/js/miniCalendar/globalize.js"></script>
	<script type="text/javascript">
		function getFormatDate(date) {
			var year = date.getFullYear(); //yyyy
			var month = (1 + date.getMonth()); //M
			month = month >= 10 ? month : '0' + month; // month 두자리로 저장
			var day = date.getDate(); //d
			day = day >= 10 ? day : '0' + day; //day 두자리로 저장
			return year + '/' + month + '/' + day;
		}
		var today = new Date();
		var todayText;
		$(function() {
			$("#selBox").change(function() {
				if ($("#selBox option:selected").val() == 1) {
					$("#form").attr("action", "workPdf");
				} else if ($("#selBox option:selected").val() == 2) {
					$("#form").attr("action", "careerPdf");
				}
			});
			todayText = getFormatDate(today);
			$("#inputDate1").val(todayText);
			$("#inputDate2").val(todayText);
		});
	</script>



	<div class="box-header">
		<h3 class="box-title">
			<strong>증명서 입력 사항</strong>
		</h3>
		<br />
		<div class="box box-info"></div>
	</div>
	<br />

	<div style="margin-left: 55px; width: 1200px;">
		<form id="form" action="workPdf" class="form-horizontal" method="post">
			<table class="table table-bordered table-hover" style="text-align: center;">
				<tr>
					<td><b>신청일자</b></td>
					<td><input type="text" class="form-control" name="request" id="inputDate1" style="width: 80%; float: left;" readonly="readonly"> 
					<td><b>증명서 구분</b></td>
					<td><select id="selBox" class="form-control" style="float: left; width: 80%;">
							<option value="1" selected="selected">재직증명서</option>
							<option value="2">경력증명서</option>
					</select></td>
				</tr>
				<tr>
					<td style="height: 50px;"><b>부&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;서</b></td>
					<td>${memberVO.dep_nm}</td>
					<td><b>직&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;급</b></td>
					<td>${memberVO.pos_nm}</td>
				</tr>
				<tr>
					<td><b>주민등록번호</b></td>
					<td>${memberVO.mem_reg1}-${memberVO.mem_reg2}</td>
					<td><b>재직기간</b></td>
					<td>
						<div style="float: left;">
							<input type="text" class="form-control" id="inputDate1" placeholder="workDate" style="width: 240px;" value="${memberVO.mem_jn}" readonly="readonly">
							&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;&nbsp;
						</div>
						<div style="float: left;">
							<input type="text" class="form-control" name="work" id="inputDate2" placeholder="workDate" style="width: 240px;" readonly="readonly">
						</div>
					</td>
				</tr>
			</table>

			<div style="float: right;">
				<button type="submit" class="btn btn-danger">PDF출력</button>
				<input type="button" class="btn btn-danger" onClick="location.href='/gw/main';" value="홈으로">
			</div>
		</form>
	</div>
</body>
</html>