<%--==============================================================
 * 사내시설예약 information
 * @author 김성수
 * @since  2016.08.30.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.08.30.  	김성수              최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
===============================================================--%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);
	int month = calendar.get(Calendar.MONTH);
	int day = calendar.get(Calendar.DATE);
%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--// DOCTYPE -->

<title></title>
<!--// CSS_JS -->
</head>
<body>
<link rel="stylesheet" href="dateInput/css/jqx.base.css" type="text/css" />
<style type="text/css">
.suzy {
	width: 100px;
	height: 230px;
	display: block;
	margin: auto;
	margin-top: 10px;
}

.cycle-slideshow, .cycle-slideshow* {
	-webkit-box-sizing: border-box;
	-moz-box-sizing;
	border-box;
	box-sizing;
	border-box;
}

.cycle-slideshow {
	width: 300px;
	min-width: 300px;
	max-width: 500px;
	margin: 5px auto;
	padding: 0;
	position: relative;
}

.cycle-slideshow div.slide {
	width: 100%;
	height: 100%;
}

.cycle-slideshow img {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	padding: 0;
	display: block;
}

.cycle-slideshow img:first-child {
	position: static;
	z-index: 100;
}

.cycle-pager {
	text-align: center;
	width: 100%;
	z-index: 500;
	position: absolute;
	top: 1px;
	overflow: hidden;
}

.cycle-pager span {
	font-family: arial;
	font-size: 50px;
	width: 16px;
	height: 16px;
	display: inline-block;
	color: #ddd;
	cursor: pointer;
}

.cycle-pager span.cycle-pager-active {
	color: #D69746;
}

.cycle-pager>* {
	cursor: pointer;
}

button {
	background-color: pink;
	width: 100px;
	height: 50px;
	font-size: 20px;
	color: black;
}

#click {
	margin-top: 10px;
}
]
</style>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script src="http://malsup.github.com/jquery.cycle2.js"></script>
	<script type="text/javascript" src="resources/assets/js/reservation/common.jquery.js"></script>
	<script type="text/javascript" src="resources/assets/js/reservation/common.js"></script>
	<script type="text/javascript" src="resources/assets/js/reservation/dge.facility.js"></script>
	<script type="text/javascript" src="dateInput/js/demos.js"></script>
	<script type="text/javascript" src="dateInput/js/jqxcore.js"></script>
	<script type="text/javascript" src="dateInput/js/jqxdatetimeinput.js"></script>
	<script type="text/javascript" src="dateInput/js/jqxcalendar.js"></script>
	<script type="text/javascript" src="dateInput/js/jqxtooltip.js"></script>
	<script type="text/javascript" src="dateInput/js/globalize.js"></script>
	<script type="text/javascript">
		$(function() {
			var date = new Date();
			var year = date.getFullYear();
			var month = date.getMonth();
			var day = date.getDate();
			var preDate = new Date(year, (month + 1), day);

			$.ajax({
				type : "get",
				url : "getReserve",
				dataType : "json",
				data : {
					"date" : year + '-' + (month + 1) + '-' + day,
					"code" : $("#code").val()
				},
				success : function(data) {
					var time = $(".timeSel ul").text();
					$("#time").attr("value", time);
					$("#days").attr("value", year + '-' + (month + 1) + '-' + day);
					var d = 0;
					$.each(data, function(key, value) {
						if (value.reserv_time == "9:00~10:00") {
							d = value.reserv_time;
						}
						return false;
					});
					$("#reserveList").html("");
					for (var i = 0; i < 9; i++) {
						$("#reserveList").append('<li id="on" name="'+i+'"><a href="#" style="cursor: pointer;">' + (i + 9) + ':00~' + (i + 10) + ':00</a></li>');
						$.each(data, function(key, value) {
							if ($("li[name=" + i + "]").text() == value.reserv_time) {
								$("li[name=" + i + "] a").css("cursor", "default");
								$("li[name=" + i + "]").attr("id", "off");
								if (d != 0) {
									$("li[name='0'] a").css("cursor", "default");
									$("li[name='0']").attr("id", "off");
									d = 0;
								}
							}
						});
					}
				},
				error : function() {
					swal("네트워크 에러","서버와 통신 중 에러가 발생했습니다.","error");
				}
			});

			$("#jqxcalendar").jqxCalendar({
				titleFormat : 	["yyyy MMMM", "yyyy", "yyyy"],
				width : '195px',
				height : '250px',
				showOtherMonthDays : false,
			});
			$('#jqxcalendar').jqxCalendar("setMinDate",new Date());
			$('#jqxcalendar').on('change', function(event) {
				var date = event.args.date;
				var date2 = (date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate());
				var curDate = new Date(date.getFullYear(), (date.getMonth() + 1), date.getDate());
				if ($(".timeSel ul li").length > 0) {
					swal("날짜 변경 오류","이미 시간이 선택되어 있습니다.","info");
					return true;
				} else {
					$("#bookingDay").attr("value", date2);
					$.ajax({
						type : "get",
						url : "getReserve",
						dataType : "json",
						data : {
							"date" : date2,
							"code" : $("#code").val()
						},
						success : function(data) {
							var d = 0;
							$.each(data, function(key, value) {
								if (value.reserv_time == "09:00~10:00") {
									d = value.reserv_time;
								}
								return false;
							});
							$("#reserveList").html("");
							for (var i = 0; i < 9; i++) {
								$("#reserveList").append('<li id="on" name="'+i+'"><a href="#" style="cursor: pointer;">' + (i + 9) + ':00~' + (i + 10) + ':00</a></li>');
								$.each(data, function(key, value) {
									if ($("li[name=" + i + "]").text() == value.reserv_time) {
										$("li[name=" + i + "] a").css("cursor", "default");
										$("li[name=" + i + "]").attr("id", "off");
										if (d != 0) {
											$("li[name='0'] a").css("cursor", "default");
											$("li[name='0']").attr("id", "off");
											d = 0;
										}
									}
								});
							}
							$("#days").attr("value", date2);
						},
						error : function() {
							swal("서버 연결 실패","서버와의 통신 중 문제가 발생했습니다.","error");
						}
					});
				}
			});
		});
	</script>
	<div id="wrap">
		<div class="box-header">
			<h3 class="box-title">
				<strong>시설물 이용 예약</strong>
			</h3>
			<br />
			<div class="box box-info"></div>
		</div>
		<!--컨테이너-->
		<div id="container">
			<div class="contants">
				<div class="facView">
					<h4>
						<img src="resources/facilityImage/${facilityVO.fac_img}" alt="시설물정보" width="300" height="220" />
					</h4>
					<dl>
						<dd>
							<strong>시&nbsp;&nbsp;설&nbsp;&nbsp;명&nbsp;:</strong>&nbsp;<strong class="tit">${facilityVO.fac_name}</strong>
						</dd>
						<dd>
							<strong>상세설명&nbsp;:</strong>&nbsp;<strong class="tit">${facilityVO.fac_desc}</strong>
						</dd>
						<dd>
							<strong>연&nbsp;&nbsp;락&nbsp;&nbsp;처&nbsp;:</strong>&nbsp;<strong class="tit">${facilityVO.fac_phone}</strong>
						</dd>

						<div class="cycle-slideshow" data-cycle-fx=scrollHorz data-cycle-timeout=1500>
							<div class="cycle-pager"></div>
							<img src="resources/facilityImage/${facilityVO.fac_img1}" class="suzy"> <img src="resources/facilityImage/${facilityVO.fac_img2}" class="suzy">
						</div>
					</dl>
				</div>

				<div class="facView_day">
					<h4>
						<img src="resources/assets/img/reservation/facView_day_tit01.gif" alt="예약현황" />
					</h4>
					<div class="dayBoxt">
						<strong>TODAY <%=year%>.<%=month + 1%>.<%=day%></strong>
					</div>
					<div class="dayBox">
						<div id='jqxcalendar'></div>
					</div>
					<div align="center" style="margin-left: -30px;">
						<ul id="ex">
							</br>
							<li id="on"><a href="#" style="cursor: default;">예약가능</a></li>
							</br>
							</br>
							<br>
							<li id="off"><a href="#" style="cursor: default;">예약불가</a></li>
							</br>
							</br>
							<br>
							<li id="sel"><a href="#" style="cursor: default;">예약선택</a></li>
							</br>
							</br>
							<br>
						</ul>
					</div>
				</div>
				<h4 class="blind">예약시간설정</h4>
				<div class="facView_time">
					<strong><img src="resources/assets/img/reservation/facView_day_tit01.gif" alt="오전" align="absmiddle" /> 9:00 &sim; 18:00</strong>
					<ul id="reserveList"></ul>
				</div>
				<div class="facVieww">
					<h4>
						<img src="resources/assets/img/reservation/facView_tit02.gif" alt="예약내용 선택/입력">
					</h4>
					<ol>
						<li><label for="bookingDay"> <img src="resources/assets/img/reservation/facView_tit03.gif" alt="예약신청일">
						</label> <input type="text" id="bookingDay" name="frevRDate" value="<%=year%>.<%=month + 1%>.<%=day%>" readonly="readonly" class="facVeiw_box">
							<p>※ 예약현황 확인의 캘린더에서 예약 가능일(V) 중 예약을 원하시는 날을 클릭하십시오.</p></li>
						<li><img src="resources/assets/img/reservation/facView_tit04.gif" alt="이용시간"> <br>
							<div class="timeSel">
								<ul></ul>
								<input type="hidden" name="frevTime" value="">
							</div>
							<p>
								※ 예약 현황 확인의 예약 시간 현황에서 예약 가능 시간<span style="color: #1F9773;"><strong>(녹색)</strong></span>중 예약을 원하시는 시간을 클릭하십시오. <br>※ <strong>선택한 시간대를 취소</strong>하시려면 선택된 시간을 다시 클릭해주시면 해당시간대 선택이 해제됩니다.
							</p></li>
					</ol>
					<li><label for="bookingDay"> <img src="resources/assets/img/reservation/facView_tit05.gif" alt="예약자성명"></label> <input type="text" id="bookingDay" name="frevName" class="facVeiw_box"
						value="${memberVO.mem_nm}" readonly="readonly"> 님</li>
				</div>
				<form action="insertReserve" method="post" onsubmit="return onSubmit()">
					<input type="text" id="code" name="code" value="${facilityVO.fac_code}" style="visibility: hidden;" /> <input type="text" id="time" name="time" value="" style="visibility: hidden;" /> <input
						type="text" id="days" name="days" value="" style="visibility: hidden;" />

					<div style="float: right;">
						<input type="image" name="button" style="width: 95px; height: 34px;" src="resources/assets/img/reservation/facComplete_btn.gif" alt="예약신청" /> <a href="companyFacilityList"><input
							type="button" class="btn btn-danger" style="margin-bottom: 26px;" value="목록" /></a>
					</div>
				</form>
			</div>

			<script type="text/javascript">
				function onSubmit() {
					if ($("#time").val() == "") {
						swal("조건 선택","날짜와 시간을 선택하세요.","info");
						return false;
					} else {
						swal("예약되었습니다","","success");
					}
				}

				$(function() {
					facility_resv_ready();
				});
			</script>
		</div>
		<!--//컨테이너-->
	</div>

	<link rel="stylesheet" href="resources/assets/css/reservation/default.css" type="text/css" />

	<!-- ============================================================================== -->

</body>
</html>















