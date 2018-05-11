var pattern_file = "doc|docx|xls|xlsx|ppt|pptx|hwp|pdf|txt|zip|tar|gz|tgz|alz";
var pattern_img = "jpg|jpeg|gif|png";

$(function() {
	// Show Hide
	$(".loginBoxOpen").click(function() {
		$("#loginErrorMsg").empty();
		$("#logId").val("");
		$("#logPw").val("");
		
		$("#loginBox").fadeIn("fast", function() {
			if(! $("#loginBox_cover").is("div") ) {
				$(this).before($("<div id=\"loginBox_cover\"></div>").css({
					position : "fixed",
					top : "0px",
					left : "0px",
					bottom : "0px",
					right : "0px",
					background : "#000",
					opacity : "0.2"
				}));
			}
			$("#logId").focus();
		}).keydown(function(event) {
			if( event.keyCode == 13 ) {
				$(":image", this).click();
			}
		});
	});
	$("#loginBox .close").click(function() {
		$("#loginBox").fadeOut("fast", function() {
			$("#loginBox_cover").remove();
		});
		return false;
	});
	$("#loginBox").hide();
	
	// AJAX
	$("#ajax_loading").css({
		position:"fixed", background:"#fff", 
		padding:"5px 20px", border:"1px solid #ddd", 
		zIndex:"1000000", color:"#319778", fontWeight:"bold"
	}).hide();
	
	$("#ajax_loading").ajaxStart(function(){
		var w = ( $(window).width()-$(this).width() ) / 2;
		var h = ( $(window).height()-$(this).height() ) / 2;
		
		$(this).css({left:w + "px", top: h + "px"}).show();
	});
	$("#ajax_loading").ajaxStop(function(){
		$(this).hide();
	});
	$("#ajax_loading").ajaxError(function(event, request, settings){
		//alert(request.status + ": " +  request.statusText + "\n" + settings.url);
	});
});
function facility_login_check(login_url, mode){
	if($("#logId").val() == ""){
		$("#loginErrorMsg").show().html("아이디를 입력하세요.");
		$("#logId").focus();
		return false;
	}
	if($("#logPw").val() == ""){
		$("#loginErrorMsg").show().html("비밀번호를 입력하세요.");
		$("#logPw").focus();
		return false;
	}
	if(mode == "share") {
		$.post("/loginChk.do", {"dept_cd" : $("#logId").val(), "passwd" : $("#logPw").val()}, function(response) {
			if(response.exception == "S"){
				document.loginFrm.action = login_url;
				document.loginFrm.submit();
			}else{
				if (response.exception == "존재하지 않는 ID입니다.") {
					$("#loginErrorMsg").html("존재하지 않는 ID입니다.");
					$("#logId").focus();
				} else {
					$("#loginErrorMsg").html(response.exception);
					$("#logPw").focus();
				}
			}
		}, "json"); 
	} else {
		document.loginFrm.action = login_url;
		document.loginFrm.submit();
	}
	return false;
}
function facility_pagelink_to_js(obj_selector) {
	$(obj_selector).find("p.list_num a").click(function() {
		var url = $.trim($(this).attr("href"));
		if(url == "" || /#$/.test(url)) return false;
		if(/^javascript/i.test(url)) return true;
		
		$(obj_selector).load(url, function(){ facility_pagelink_to_js(obj_selector); });
		return false;
	});
}
// 기관검색
function facility_dept_search() {
	$("#revBox .revBoxarea").load("./deptSearch.do", $("#sfrm").serialize(), function() {
		$("#revBox").fadeIn("fast", function() {
			if(! $("#revBox_cover").is("div") ) {
				$("#revBox").before($("<div id=\"revBox_cover\"></div>").css({
					position : "fixed",
					top : "0px",
					left : "0px",
					bottom : "0px",
					right : "0px",
					background : "#000",
					opacity : "0.2"
				}));
			}
		});
		facility_pagelink_to_js("#revBox .revBoxarea");
	});
	var $pO = $("#revBox").parent().parent().parent();
	var zI = $pO.css("zIndex");
	$pO.css("zIndex", "999");
	
	$("#revBox .close").click(function() {
		$("#revBox").fadeOut("fast", function() {
			$("#revBox_cover").remove();
			$pO.css("zIndex", zI);
		});
		$("#sfrm :text[name=sval]").val("");
		return false;
	});
	return false;
}
function facility_dept_search_click() {
	$("#revBox .revBoxarea .tit a").click(function() {
		$(document.frm.deptCd).val($(this).nextAll("input:eq(0)").val());
		$(document.frm.deptNm).val($(this).nextAll("input:eq(1)").val());
		$(document.frm.areaCd).val($(this).nextAll("input:eq(2)").val());
		$(document.frm.areaNm).val($(this).nextAll("input:eq(3)").val());
		try {
			var tel = $(this).nextAll("input:eq(4)").val();
			tel = tel.split("-");
			$(document.frm.facTel1).val(tel[0]);
			$(document.frm.facTel2).val(tel[1]);
			$(document.frm.facTel3).val(tel[2]);
		} catch (e) {}
		
		$("#revBox .close").click();
	});
}
// 시설물 입력 체크
function facility_insert_check() {
	var fm = document.frm;
	
	if ($.trim(fm.deptCd.value) == "") {
		alert("시설물을 등록할 기관을 선택하세요.");
		fm.deptNm.focus();
		return false;
	}
	if ($.trim(fm.facNm.value) == "") {
		alert("시설명을 입력하세요.");
		fm.facNm.focus();
		return false;
	}
	
	// 파일체크
	var pattern1 = new RegExp("\\.(" + pattern_file + ")$", "i");
	if($.trim(fm.facFile3.value) != "") {
		if(!pattern1.test(fm.facFile3.value)) {
			alert("시설개방규정에 업로드 할수 없는 파일입니다.");
			fm.facFile3.focus();
			return false;
		}
	}
	if($.trim(fm.facFile1.value) != "") {
		if(!pattern1.test(fm.facFile1.value)) {
			alert("장기사용허가 공고문에 업로드 할수 없는 파일입니다.");
			fm.facFile1.focus();
			return false;
		}
	}
	if($.trim(fm.facFile2.value) != "") {
		if(!pattern1.test(fm.facFile2.value)) {
			alert("장기대여현황에 업로드 할수 없는 파일입니다.");
			fm.facFile2.focus();
			return false;
		}
	}

	// 이미지 체크
	var pattern2 = new RegExp("\\.(" + pattern_img + ")$", "i");
	if($.trim(fm.facImg1.value) != "" && !pattern2.test(fm.facImg1.value)) {
		alert("첫번째 이미지파일 형식이 잘못되었습니다.");
		fm.facImg1.focus();
		return false;
	}
	if($.trim(fm.facImg2.value) != "" && !pattern2.test(fm.facImg2.value)) {
		alert("두번째 이미지파일 형식이 잘못되었습니다.");
		fm.facImg2.focus();
		return false;
	}
	if($.trim(fm.facImg3.value) != "" && !pattern2.test(fm.facImg3.value)) {
		alert("세번째 이미지파일 형식이 잘못되었습니다.");
		fm.facImg3.focus();
		return false;
	}
	if($.trim(fm.facImg4.value) != "" && !pattern2.test(fm.facImg4.value)) {
		alert("네번째 이미지파일 형식이 잘못되었습니다.");
		fm.facImg4.focus();
		return false;
	}
	
	return true;
}
// 시설물 상세내용
function facility_view_ready() {
	$("#thumbnail_slider_doc > img").bind("mouseenter", function(){
		var idx = $("img", $(this).parent()).index(this);	
		var idx_o = $("#thumbnail_slider > img:eq(" + idx + ")");
		
		$("#thumbnail_slider > img").not(idx_o).fadeOut();
		idx_o.fadeIn();
	}).css({cursor:"pointer"});
	$("#thumbnail_slider > img").css({position:"absolute"});
	$("#thumbnail_slider_doc > img:eq(0)").mouseenter();
	$("#thumbnail_slider > div > a").click(function(){
		var url = $("img:visible", $(this).parent().parent()).attr("src");
		window.open(url, "img_facility_pop", "scrollbars=yes,width=820,height=600,resizable=yes").focus();
		return false;
	});
	$(".facView_time li a").click(function() {
		return false;
	}).css({"cursor":"default"});
	$(".facView_timeA li a").click(function() {
		return false;
	}).css({"cursor":"default"});
}
// 시설물 예약
function facility_resv_ready() {
	//$( document ).on( "click", "#members li a", function( e ) {} ); 
//	$(".facView_time li a").on("click",function() {
	$( document ).on( "click", ".facView_time ul li a", function() {
		if($(this).parent().attr("id") == "on") {
			if($(".timeSel ul").find("li").length>0){  
				swal("이미 선택한 시간이 존재합니다","","info");
				//swal("삭제되었습니다","","success");
			}
			else{
				facility_resv_time_click1(this);
			}
		}
	});
	$(".facView_time li a").css({"cursor":"default"});
	$(".facView_time li#on a").css({"cursor":"pointer"});
}
//예약시간 클릭
function facility_resv_time_click1(obj) {
	// 이미선택한 시간대
	var timesVal = $.trim($(".timeSel :hidden").val());
	var times = new Array();
	if(timesVal != "") {
		times = timesVal.split("|");
	}
	// 선택한 시간대 없으면 추가
	var selTime = $(obj).text().substring(0, 5).replace(":", "");
	var $newObj = $(obj).parent().clone().attr("id", "sel");
	// 클릭시 선택 해제
	$newObj.children("a").click(function() {
		facility_resv_time_click2(this);
		return false;
	});
	
	if(times.length < 1) {
		$newObj.appendTo($(".timeSel ul"));
		times.push(selTime);
		$(".timeSel :hidden").val(times.join("|"));
		$(obj).parent().attr("id", "sel");
		var time = $(".timeSel ul").text();
		   $("#time").attr("value",time);
		
		// 클릭이벤트 변경
		$(obj).unbind("click");
		$(obj).click(function() {
			facility_resv_time_click3(this);
			return false;
		});
	} else if($.inArray(selTime, times) < 0) {
		var timesTemp = $.grep(times, function(data, i) {
			return data < selTime;
		});
		var index = timesTemp.length-1;
		if(index < 0) {
			$newObj.insertBefore($(".timeSel ul li:eq(0)"));
		} else {
			$newObj.insertAfter($(".timeSel ul li:eq(" + index + ")"));
		}
		times.push(selTime);
		times.sort();
		$(".timeSel :hidden").val(times.join("|"));
		$(obj).parent().attr("id", "sel");
		
		// 클릭이벤트 변경
		$(obj).unbind("click");
		$(obj).click(function() {
			facility_resv_time_click3(this);
			return false;
		});
	}	
}

// 선택한 시간 클릭 > 해지
function facility_resv_time_click2(obj) {
	var $rmObj = $(obj).parent();
	$(".facView_time ul li[id=sel] a").each(function(i, iobj) {
		// 원래대로
		if($.trim($(iobj).text()) == $.trim($rmObj.text())) {
			$(iobj).parent().attr("id", "on");

			$(iobj).unbind("click");
			$(iobj).click(function() {
				facility_resv_time_click1(iobj);
				return false;
			});
		}
	});
	
	var timesVal = $.trim($(".timeSel :hidden").val());
	var times = new Array();
	if(timesVal != "") {
		times = timesVal.split("|");
	}
	var index = $(".timeSel ul li").index($rmObj);
	$rmObj.remove();
	   $("#time").attr("value","");
	times.splice(index, 1); // 삭제
	$(".timeSel :hidden").val(times.join("|"));
}
// 선택된 예약시간 클릭 > 해지
function facility_resv_time_click3(obj) {
	var $chObj = $(obj).parent();
	
	$(".timeSel ul li a").each(function(i, iobj) {
		if($.trim($(iobj).text()) == $.trim($chObj.text())) {
			$(iobj).click();
		}
	});
}
// 예약전 체크
function facility_resv_check() {
	var fm = document.frm;
	
	if ($.trim(fm.frevRDate.value) == "") {
		alert("예약신청일이 선택되지 않았습니다.");
		fm.frevDate.focus();
		return false;
	}
	if ($.trim(fm.frevTime.value) == "") {
		alert("이용시간을 선택하세요.");
		//fm.frevTime.focus();
		return false;
	}
	if ($.trim(fm.frevName.value) == "") {
		alert("예약자 성명을 입력하세요.");
		fm.frevName.focus();
		return false;
	}
	if ($.trim(fm.frevDesc.value) == "") {
		alert("사용목적을 간략하게 입력하세요.");
		fm.frevDesc.focus();
		return false;
	}
	if ($.trim(fm.frevTel1.value) == "" || $.trim(fm.frevTel2.value) == "" || $.trim(fm.frevTel3.value) == "") {
		alert("회신 연락처를 입력하세요.");
		fm.frevTel1.focus();
		return false;
	}
	
	var chkDate = new Date();
	chkDate.setDate(chkDate.getDate()+3);
	
	var rvDate = new Date(fm.frevRDate.value);
	
	if(chkDate >= rvDate) {
		if(!confirm("예약신청일의 3일전까지 신청하지 않을경우 승인받을 수 없습니다.\n그래도 예약신청을 하시겠습니까.? \n\n신청 후에는 반드시 [승인결과]를 확인하세요.")) {
			return false;
		}
	} else {
		if(!confirm("입력하신 정보로 예약신청을 하시겠습니까.? \n신청 후에는 반드시 [승인결과]를 확인하세요.")) {
			return false;
		}
	}
	return true;
}
// 예약내역확인
function facility_resv_result_ready() {
	// layer
	var $div = $("<div></div>").css({
		position:"absolute",
		background:"#fff",
		margin:"-20px 0 0 -300px",
		border:"1px solid #cbcbcb",
		padding:"1px",
		width:"300px",
		zIndex:"10000"
	}).hide().append(
		$("<div></div>").css({
			background:"#eeeeee",
			width:"290px",
			padding:"5px",
			textAlign:"left",
			fontWeight:"bold"
		}).text("승인불가 사유").append(
			$("<div></div>").css({
				background:"#fff",
				border:"1px solid #e5e5e5",
				width:"268px",
				height:"50px",
				padding:"10px",
				marginTop:"5px",
				textAlign:"left",
				fontWeight:"normal"
			})
		)
	).appendTo("body");
	
	$(".resvDetailDesc").hide();
	$(".resvDetailRs").bind("mouseover", function (/*event*/e) {
		var offset = $(this).offset();
		var $obj = $(this).next("div");
		$div.children().children().text($obj.text());
		$div.css({top:offset.top+"px", left:(offset.left - 10) +"px"});
		$div.show();
	}).bind("mouseout", function() {
		$div.hide();
	}).css({cursor:"pointer"});
}
// 예약내역확인
function facility_resv_view_ready() {
	facility_view_ready();
	
	$("#frm").submit(function() {
		var $txtObj = $("textarea[name=frevStatDesc]");
		if($.trim($txtObj.val()) == $txtObj.attr("title") || $.trim($(":radio[name=frevStat]:checked").val()) != "N") {
			$txtObj.val("");
		}
	});
	$("#frm .checkBox > a").click(function() {
		$(this).prev(":radio").click();
	});
	
	$("#frm .checkBox > :radio").click(function() {
		if($(this).val() == "N") {
			$("textarea[name=frevStatDesc]").show();
		} else {
			$("textarea[name=frevStatDesc]").hide();
		}
	});
	$("textarea[name=frevStatDesc]").focus(function () {
		if($.trim($(this).val()) == $(this).attr("title")) {
			$(this).val("");
		}
	}).blur(function() {
		if($.trim($(this).val()) == "") {
			$(this).val($(this).attr("title"));
		}	
	}).blur();
	$(".facView_timeA li a[href!=#]").unbind("click");
	$(".facView_timeA li#rev a").css({"cursor":"pointer"});
}
//시설물 예약설정
function facility_time_ready() {
	// 페이지 로드시 라디오박스 설정
	if($(":radio.rtime_part1[value=Y]").length < 12 || $(":radio.rtime_part1[value=Y]:checked").length > 0) {	
		$(":radio[name=allsetRTime_1][value=Y]").attr("checked", true);
	}
	if($(":radio.rtime_part2[value=Y]").length < 12 || $(":radio.rtime_part2[value=Y]:checked").length > 0) {	
		$(":radio[name=allsetRTime_2][value=Y]").attr("checked", true);
	}
	if($(":radio.rtime_part3[value=Y]").length < 12 || $(":radio.rtime_part3[value=Y]:checked").length > 0) {	
		$(":radio[name=allsetRTime_3][value=Y]").attr("checked", true);
	}

	// 전체설정 가능/불가 클릭시
	$(":radio[name^=allsetRTime_]").click(function(){
		var part = $(this).attr("name").replace("allsetRTime_", "");
		if($(this).val() == "Y") {
			$(":radio.rtime_part" + part + "[value=Y]").attr("checked", true);
		} else {
			$(":radio.rtime_part" + part + "[value=N]").attr("checked", true);
		}
	});
	
	// 세부 가능/불가클릭시
	$(":radio.rtime_part1").click(function(){
		if($(":radio.rtime_part1[value=Y]:checked").length > 0) {
			$(":radio[name=allsetRTime_1][value=Y]").attr("checked", true);
		} else {
			$(":radio[name=allsetRTime_1][value=N]").attr("checked", true);
		}
	});
	$(":radio.rtime_part2").click(function(){
		if($(":radio.rtime_part2[value=Y]:checked").length > 0) {
			$(":radio[name=allsetRTime_2][value=Y]").attr("checked", true);
		} else {
			$(":radio[name=allsetRTime_2][value=N]").attr("checked", true);
		}
	});
	$(":radio.rtime_part3").click(function(){
		if($(":radio.rtime_part3[value=Y]:checked").length > 0) {
			$(":radio[name=allsetRTime_3][value=Y]").attr("checked", true);
		} else {
			$(":radio[name=allsetRTime_3][value=N]").attr("checked", true);
		}
	});
}

// FAQ 입력 체크
function faq_insert_check() {
	var fm = document.frm;

	if ($.trim(fm.title.value) == "") {
		alert("질문을 입력하세요.");
		fm.title.focus();
		return false;
	}

	if ($.trim(fm.content.value) == "") {
		alert("답변을 입력하세요.");
		fm.title.focus();
		return false;
	}

	return true;
}
// FAQ 리스트
function faq_list_ready() {
	$(".faq_list tr.faq_a").hide();

	$(".faq_list tr.faq_q a.point").toggle(function() {
		$(this).parent().parent().next("tr.faq_a").show();
	}, function() {
		$(this).parent().parent().next("tr.faq_a").hide();
	}).css({
		cursor : "pointer"
	});
}

function facility_statistics_nofile(fileNum) {
	/*
	var top_s = 40;	
	if(fileNum == 1) {
		top_s = 170;
	} else if(fileNum == 2) {
		top_s = 305;
	}
	$("#data" + fileNum + "Box").css({top: top_s + "px"});
	*/
	$("#data" + fileNum + "Box .dataBoxarea").load("./stsNoFile.do", $("#sfrm").serialize() + "&fileNum=" + fileNum, function() {
		$("#data" + fileNum + "Box").fadeIn("fast", function() {
			if(! $("#dataBox_cover").is("div") ) {
				$("#data" + fileNum + "Box").before($("<div id=\"dataBox_cover\"></div>").css({
					position : "fixed",
					top : "0px",
					left : "0px",
					bottom : "0px",
					right : "0px",
					background : "#000",
					opacity : "0.2"
				}));
			}
		});
		facility_pagelink_to_js("#data" + fileNum + "Box .dataBoxarea");
	});
	
	
	$("#data" + fileNum + "Box .close").click(function() {
		$("#data" + fileNum + "Box").fadeOut("fast", function() {
			$("#dataBox_cover").remove();
		});
		return false;
	});
	return false;
}

