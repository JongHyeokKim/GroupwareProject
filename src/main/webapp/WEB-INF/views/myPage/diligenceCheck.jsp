<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--==============================================================
 * 근태조회 페이지
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
<style type="text/css">
.hoverEvent:hover td {
	background-color: #B2EBF4 !important;
}

#example1_filter {
	display: none !important;
}

#example1_length {
	display: none !important;
}

#example1_info {
	display: none !important;
}
</style>
	<link rel="stylesheet" href="dateInput/css/jqx.base.css" type="text/css" />
	<script type="text/javascript" src="dateInput/js/demos.js"></script>
	<script type="text/javascript" src="dateInput/js/jqxcore.js"></script>
	<script type="text/javascript" src="dateInput/js/jqxdatetimeinput.js"></script>
	<script type="text/javascript" src="dateInput/js/jqxcalendar.js"></script>
	<script type="text/javascript" src="dateInput/js/jqxtooltip.js"></script>
	<script type="text/javascript" src="dateInput/js/globalize.js"></script>
	<script type="text/javascript">
		var startDate = new Date();
		var endDate = new Date();
		var startDateText = "";
		var endDateText = "";
		var table;
		function getFormatDate(date) {
			var year = date.getFullYear(); //yyyy
			var month = (1 + date.getMonth()); //M
			month = month >= 10 ? month : '0' + month; // month 두자리로 저장
			var day = date.getDate(); //d
			day = day >= 10 ? day : '0' + day; //day 두자리로 저장
			return year + '/' + month + '/' + day;
		}

		// 날짜 입력창 세팅
		$(function() {
			$("#inputDate1").jqxDateTimeInput({
				width : 150,
				height : 34,
				formatString : 'yyyy/MM/dd',
				readonly : true,
				allowKeyboardDelete : false,
				theme : 'summer'
			});
			$("#inputDate2").jqxDateTimeInput({
				width : 150,
				height : 34,
				formatString : 'yyyy/MM/dd',
				readonly : true,
				allowKeyboardDelete : false,
				theme : 'summer'
			});
			$("#inputDate1").jqxDateTimeInput('setMaxDate', new Date());
			$("#inputDate2").jqxDateTimeInput('setMaxDate', new Date());
			$('#inputDate1').on('valueChanged', function(event) {
				startDate = event.args.date;
				startDateText = getFormatDate(startDate);
			});
			$('#inputDate2').on('valueChanged', function(event) {
				endDate = event.args.date;
				endDateText = getFormatDate(endDate);
			});
			startDateText = getFormatDate(startDate);
			endDateText = getFormatDate(endDate);
			table = $("#example1").DataTable({
				ordering : false,
				autoWidth : false
			});
		});
		function search() {
			if (startDate <= endDate) {
				$.ajax({
					type : "get",
					url : "searchDilCheck",
					data : {
						"startDate" : startDateText,
						"endDate" : endDateText,
						"keyword" : $("#selBox option:selected").val().trim()
					},
					dataType : "json",
					success : function(data) {
						table.destroy();
						var htmlCode = "";
						$("#attendanceList").html("");
						if (data != "") {
							$.each(data, function(key, value) {
								htmlCode += "<tr>";
								htmlCode += "<td>"+value.att_date+"</td>";
								var att_in_time = value.att_in_time==null?"":value.att_in_time;
								var att_out_time = value.att_out_time==null?"":value.att_out_time;
								htmlCode += "<td>"+att_in_time+"</td>";
								htmlCode += "<td>"+att_out_time+"</td>";
								htmlCode += "<td>"+value.wk_st_nm+"</td>";
								htmlCode += "</tr>";
							});
						} else {
							swal("검색 결과 없음","검색된 결과가 존재하지 않습니다.","error");
							htmlCode += "<c:forEach items="${attendanceList}" var="attendanceVO">" + "<tr>" + "<td>${attendanceVO.att_date}</td>" + "<td>${attendanceVO.att_in_time}</td>" + "<td>${attendanceVO.att_out_time}</td>" + "<td>${attendanceVO.wk_st_nm}</td>" + "</tr>" + "</c:forEach>";
						}
						$("#attendanceList").append(htmlCode);
						table = $("#example1").DataTable({ordering:false, autoWidth : false});
					},
					error : function() {
						swal("근태 정보 로딩 에러","서버 통신 중 무넺가 발생했습니다.","error");
					}
				});
			} else {
				swal("날짜 범위 오류","시작일이 종료일보다 늦을 수 없습니다.","info");
			}
		}
	</script>
	<div class="box-header">
		<h3 class="box-title">
			<strong>근태정보 조회</strong>
		</h3>
		<br />
		<div class="box box-info"></div>
	</div>

	<div style="margin-left: 50px; width: 1200px;">
		<table class="table table-bordered table-striped">
			<tr>
				<td>조회기간</td>
				<td><div style="float: left;">
						<div id="inputDate1"></div>
					</div>
					<div style="float: left;">&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;&nbsp;</div>
					<div style="float: left;">
						<div id="inputDate2"></div>
					</div></td>
			</tr>
			<tr>
				<td>근태구분</td>
				<td><select class="form-control" style="width: 150px;" id="selBox">
						<option value="1" selected="selected">내근</option>
						<option value="2">외근</option>
						<option value="3">조퇴</option>
						<option value="4">결근</option>
						<option value="5">지각</option>
						<option value="6">출장</option>
						<option value="7">병가</option>
						<option value="8">휴가</option>
						<option value="9">경조</option>
						<option value="10">병무</option>
						<option value="11">정직</option>

				</select> <input type="button" class="btn btn-danger" value="검색" onclick="search()"></td>
			</tr>
		</table>


		<br />
		<div style="width: 1184px; margin-left: 15px;">
			<!-- /.box-header -->
			<table id="example1" class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>날짜</th>
						<th>출근시간</th>
						<th>퇴근시간</th>
						<th>근태구분</th>
					</tr>
				</thead>
				<tbody id="attendanceList">
					<c:forEach var="attendanceVO" items="${attendanceList}">
						<tr>
							<td>${attendanceVO.att_date}</td>
							<td>${attendanceVO.att_in_time}</td>
							<td>${attendanceVO.att_out_time}</td>
							<td>${attendanceVO.wk_st_nm}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- /.box-body -->
		<div style="float: right;">

			<input type="button" class="btn btn-danger" onClick="location.href='/gw/main';" value="홈으로">
		</div>
	</div>

</body>
</html>