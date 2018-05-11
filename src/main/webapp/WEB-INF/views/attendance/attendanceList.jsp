<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--==============================================================
 * 근태 관리 수정
 * @author 김준학
 * @since  2016.09.05.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일      		 수정자          		수정내용
 *    -------      -------     -------------------
 *    2016.09.05.   김준학      			최초생성
 	  2016.09.10	김태균				기능 구현 및 개선
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
.hoverEvent:hover td{
         background-color: #B2EBF4 !important;
   }
#example1_filter {
	display: none !important;
}
 #example1_length{
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
		var today = new Date();
		var table;
		function getFormatDate(date) {
			var year="";
			var month="";
			var day="";
				year = date.getFullYear(); //yyyy
				month = (1 + date.getMonth()); //M
				month = month >= 10 ? month : '0' + month; // month 두자리로 저장
				day = date.getDate(); //d
				day = day >= 10 ? day : '0' + day; //day 두자리로 저장
				return year + '/' + month + '/' + day;
		}
		
		function getCustomDate(order){
			var year="";
			var month="";
			var day="";
			var dateForm="";
			if(order == 'week'){
				day = today.getDate()-7;
				today.setDate(day);
				year = today.getFullYear(); //yyyy
				month = (1 + today.getMonth()); //M
				month = month >= 10 ? month : '0' + month; // month 두자리로 저장
				day = today.getDate(); //d
				day = day >= 10 ? day : '0' + day; //day 두자리로 저장
				dateForm = year + '/' + month + '/' + day;
			}else if(order == 'month'){
				month = today.getMonth()-1;
				today.setMonth(month);
				year = today.getFullYear(); //yyyy
				month = (1 + today.getMonth()); //M
				month = month >= 10 ? month : '0' + month; // month 두자리로 저장
				day = today.getDate(); //d
				day = day >= 10 ? day : '0' + day; //day 두자리로 저장
				dateForm = year + '/' + month + '/' + day;
			}
			today = new Date();
			return dateForm;
		}
		//조회일자1
		$(function() {
			$("#startDateInput").jqxDateTimeInput({width : 150,height : 34, formatString : 'yyyy/MM/dd', readonly: true, allowKeyboardDelete: false, theme:'summer'});
			$("#endDateInput").jqxDateTimeInput({width : 150,height : 34, formatString : 'yyyy/MM/dd', readonly: true, allowKeyboardDelete: false, theme:'summer' });
			$('#startDateInput ').jqxDateTimeInput('setMaxDate', new Date());
			$('#endDateInput ').jqxDateTimeInput('setMaxDate', new Date());
			$('#startDateInput').on('valueChanged', function(event) {
				startDate = event.args.date;
				startDateText = getFormatDate(startDate);
			});
			$('#endDateInput').on('valueChanged', function(event) {
				endDate = event.args.date;
				endDateText = getFormatDate(endDate);
			});
			startDateText = getFormatDate(startDate);
			endDateText = getFormatDate(endDate);
			table = $("#example1").DataTable({ordering:false, autoWidth: false});
		});
		
		function weekSetting(){
			var weekDate = getCustomDate("week");
			$('#endDateInput ').jqxDateTimeInput('val', getFormatDate(today));
			$('#startDateInput ').jqxDateTimeInput('val', weekDate);
		}
		
		function monthSetting(){
			var monthDate = getCustomDate("month");
			$('#endDateInput ').jqxDateTimeInput('val', getFormatDate(today));
			$('#startDateInput ').jqxDateTimeInput('val', monthDate);
		}
		
		function search() {
			if (startDate <= endDate) {
				$.ajax({
					type : "get",
					url : "searchAttendanceAdmin",
					data : {
						"startDate" : startDateText,
						"endDate" : endDateText,
						"depart" : $("#departSelect option:selected").val().trim(),
						"state" : $("#stateSelect option:selected").val().trim(),
						"name" : $("#mem_nm").val()
					},
					dataType : "json",
					success : function(data) {
						table.destroy();
						var htmlCode = "";
						$("#attendanceList").html("");
						if (data != "") {
							$.each(data, function(key, value) {
								htmlCode += "<tr class=\"hoverEvent\" onclick=\"location.href='attendanceDetailList?att_date="+value.att_date+"&att_mem_num="+value.att_mem_num+"'\">";
								htmlCode += "<td>"+value.att_date+"</td>";
								htmlCode += "<td>"+value.dep_nm+"</td>";
								htmlCode += "<td>"+value.pos_nm+"</td>";
								htmlCode += "<td>"+value.mem_nm+"</td>";
								var att_in_time = value.att_in_time==null?"":value.att_in_time;
								var att_out_time = value.att_out_time==null?"":value.att_out_time;
								htmlCode += "<td>"+att_in_time+"</td>";
								htmlCode += "<td>"+att_out_time+"</td>";
								htmlCode += "<td>"+value.wk_st_nm+"</td></tr>";
							});
						} else {
							swal("검색 결과 없음","검색된 결과가 존재하지 않습니다.","error");
							htmlCode += "<c:forEach items="${attendanceList}" var="attendanceVO">";
							htmlCode += "<tr class='hoverEvent' onclick='location.href='attendanceDetailList?att_date=${attendanceVO.att_date}&att_mem_num=${attendanceVO.att_mem_num}'>";
							htmlCode += "<td>${attendanceVO.att_date}</td>";
							htmlCode += "<td>${attendanceVO.dep_nm}</td>";
							htmlCode += "<td>${attendanceVO.pos_nm}</td>";
							htmlCode += "<td>${attendanceVO.mem_nm}</td>";
							htmlCode += "<td>${attendanceVO.att_in_time}</td>";
							htmlCode += "<td>${attendanceVO.att_out_time}</td>";
							htmlCode += "<td>${attendanceVO.wk_st_nm}</td>";
							htmlCode += "</tr></c:forEach>";
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
	<style type="text/css">
.hoverEvent:hover td {
	background-color: #B2EBF4 !important;
}
.center{
	text-align: center;
}
</style>
	<div class="box-header">
					<h3 class="box-title"><strong>근태 관리</strong></h3>
	<br/>
 	<div class="box box-info"></div>
					</div>
					<br />
							<div class="box-body" style="width: 1200px; margin-left: 50px;">
					<table class="table table-bordered ">
					<tr>
					<td style="width:10%;" class="center"><b>조회기간</b></td>
					<td style="width:40%;">
				<div style="float: left;  vertical-align: middle;">
					<div id="startDateInput"></div>
				</div>
				
				<div style="float: left; height: 27px; vertical-align: middle;">&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;&nbsp;</div>
				<div style="float: left; vertical-align: middle;">
					<div id="endDateInput"></div>
				</div>
				<div style="margin-left: 15px; float: left;">
					<input id="weekBtn" type="button" class="btn btn-default" value="1주" onclick="weekSetting();"> <input id="monthBtn" type="button" class="btn btn-default" value="1달" onclick="monthSetting();">
				</div>
					</td>
					<td class="center" style="width:10%;"><b>사원명</b></td>
					<td>
					<div style="float: left;">
					<input id="mem_nm" type="text" class="form-control" style="width: 440px;">
				<input type="button" class="btn btn-danger" value="검색" onclick="search()">
				</div>
					</td>
					</tr>
					<tr>
					<td class="center"><b>부서</b></td>
					<td>
					<select class="form-control" style="width: 480px;" id="departSelect">
					<option value="0" selected="selected">전체</option>
					<c:forEach var="item" items="${departList}">
						<option value="${item.dep_nm}">${item.dep_nm}</option>
					</c:forEach>
				</select>
					</td>
					<td class="center"><b>상태</b></td>
					<td><select class="form-control" style="width:500px;" id="stateSelect">
					<option value="0" selected="selected">전체</option>
					<c:forEach var="item" items="${workStateList}">
						<option value="${item.wk_st_code}">${item.wk_st_nm}</option>
					</c:forEach>
				</select></td>
					</tr>

					</table>
					<br/>

		<!-- /.box-header -->

			<table id="example1" class="table table-bordered table-striped" style="margin-left: 15px; width: 1175px;">
				<thead>
					<tr>
						<th class="center">날짜</th>
						<th class="center">부서</th>
						<th class="center">직급</th>
						<th class="center">이름</th>
						<th class="center">출근시간</th>
						<th class="center">퇴근시간</th>
						<th class="center">근태구분</th>
					</tr>
				</thead>
				<tbody id="attendanceList">
					<c:forEach var="attendanceVO" items="${attendanceList}">
						<tr class="hoverEvent" onclick="location.href='attendanceDetailList?att_date=${attendanceVO.att_date}&att_mem_num=${attendanceVO.att_mem_num}'">
							<td>${attendanceVO.att_date}</td>
							<td>${attendanceVO.dep_nm}</td>
							<td>${attendanceVO.pos_nm }</td>
							<td>${attendanceVO.mem_nm }</td>
							<td>${attendanceVO.att_in_time}</td>
							<td>${attendanceVO.att_out_time}</td>
							<td>${attendanceVO.wk_st_nm }</td>
						</tr>
					</c:forEach>
				</tbody>


			</table>
		</div>
	

</body>
</html>