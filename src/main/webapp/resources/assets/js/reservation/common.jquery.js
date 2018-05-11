// jquery 필요

/* Korean initialisation for the jQuery calendar extension. */
/* Written by DaeKwon Kang (ncrash.dk@gmail.com). */
jQuery(function($){
	if($.datepicker != null) {
		$.datepicker.regional['ko'] = {
			closeText: '닫기',
			prevText: '이전달',
			nextText: '다음달',
			currentText: '오늘',
			monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
			monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
			dayNames: ['일','월','화','수','목','금','토'],
			dayNamesShort: ['일','월','화','수','목','금','토'],
			dayNamesMin: ['일','월','화','수','목','금','토'],
			weekHeader: 'Wk',
			dateFormat: 'yy-mm-dd',
			firstDay: 0,
			isRTL: false,
			showMonthAfterYear: false,
			yearSuffix: '년',
			changeYear: true,
			changeMonth: true};
		$.datepicker.setDefaults($.datepicker.regional['ko']);

		// 기간 inputbox
		$("input[type=text][name^=sterm_d]").attr("readonly","readonly").addClass("readonly").datepicker();
		// 날짜 inputbox
		$("input[type=text].datepicker").attr("readonly","readonly").addClass("readonly").datepicker();
	}

	$(":text.numbox").keyup(function() {
		input_only_number(this);
	}).blur(function(){
		input_only_number(this);
	}).css({"ime-mode":"disabled","text-align":"right"});
	
	$(":text.numbox_l").keyup(function() {
		input_only_number(this);
	}).blur(function(){
		input_only_number(this);
	}).css({"ime-mode":"disabled"});
	
	// number string
	$(":text.numstr").keyup(function() {
		input_only_number_string(this);
	}).blur(function(){
		input_only_number_string(this);
	}).css({"ime-mode":"disabled","text-align":"right"});
	
	$(":text.numstr_l").keyup(function() {
		input_only_number_string(this);
	}).blur(function(){
		input_only_number_string(this);
	}).css({"ime-mode":"disabled"});

});
function input_only_number(obj){
	var v = $(obj).val().replace(/[^0-9.-]+/g,'');
	if(v != $(obj).val()) $(obj).val(v);
}
function input_only_number_string(obj) {
	var v = $(obj).val().replace(/[^0-9.,-]+/g,"");
	if(v != $(obj).val()) $(obj).val(v);
}
function clear_search_date(frm) {
	frm.sterm_d1.value = "";
	frm.sterm_d2.value = "";
}
// ajax 에러처리
function ajax_error(xhr, status, errorThrown) {
	if (status == "error") {
		var msg = "Sorry but there was an error: \n";
		alert(msg + xhr.status + " " + xhr.statusText);
	}
}
// ajax 에러처리
function load_error(response, status, xhr) {
	if (status == "error") {
		var msg = "Sorry but there was an error: \n";
		alert(msg + xhr.status + " " + xhr.statusText);
		return false;
	}
	else if(response == "error") {
		alert("정상적으로 처리되지 않았습니다.");
		return false;
	}
	else if(response == "error_input") {
		alert("필요한 값이 정상적으로 입력되지 않았습니다.");
		return false;
	}
	else if(response == "error_delete") {
		alert("삭제할 수 없습니다. \n잠시후 다시 시도해 주십시오.");
		return false;
	}
	else if(response == "error_update") {
		alert("수정할 수 없습니다. \n잠시후 다시 시도해 주십시오.");
		return false;
	}
	else if(response == "error_nodata") {
		alert("선택된 데이터가 없습니다.");
		return false;
	}
	else if(response == "error_dupl") {
		alert("중복된 데이터입니다.");
		return false;
	}
	else if(response == "logout") {
		alert("로그인후 사용하세요.");
		top.document.location.href="/index.php";
		return false;
	}
	else if(response == "error_require") {
		alert("필수값이 누락되었습니다.");
		return false;
	}
	else if(response == "error_require_data") {
		alert("데이터가 삭제되었거나 찾을 수 없습니다.");
		return false;
	}
	return true;
}

// 삭제전 체크
function check_delete() {
	return confirm("정말 삭제하시겠습니까.?");
}

function jq_all_check_toggle(name, sel, unsel, obj) {
	if(name == null) {
		name="chk[]";
	}
	name = name.replace(/\[/g, "\\[");
	name = name.replace(/\]/g, "\\]");
	if ($("input[type=checkbox][name=" + name + "]").length < 1) return false;
		
	var src = $(obj).children("img").attr("src");
	var pattern = new RegExp(unsel + "(\.[a-zA-Z]*)$");
	
	var flg_select = !pattern.test(src);

	if(flg_select) {
		jq_all_check(name);
		
		var pattern = new RegExp(sel + "(\.[a-zA-Z]*)$");
		src = src.replace(pattern, unsel + "$1");
		
		$(obj).children("img").attr("src", src);
		$(obj).children("img").attr("alt", "선택해지");
	} else {
		jq_un_check(name);
		
		var pattern = new RegExp(unsel + "(\.[a-zA-Z]*)$");
		src = src.replace(pattern, sel + "$1");
		
		$(obj).children("img").attr("src", src);
		$(obj).children("img").attr("alt", "전체선택");
	}	
	return false;
}
function jq_all_check(name) {
	if(name == null) {
		name="chk[]";
	}
	name = name.replace(/\[/g, "\\[");
	name = name.replace(/\]/g, "\\]");
	$("input[type=checkbox][name=" + name + "]").attr('checked', true);

	return false;
}

function jq_un_check(name) {
	if(name == null) {
		name="chk[]";
	}
	name = name.replace(/\[/g, "\\[");
	name = name.replace(/\]/g, "\\]");
	$("input[type=checkbox][name=" + name + "]").attr('checked', false);

	return false;
}

function jq_is_chk(name) {
	if(name == null) {
		name="chk[]";
	}
	name = name.replace(/\[/g, "\\[");
	name = name.replace(/\]/g, "\\]");

	if($("input[type=checkbox][name=" + name + "]:checked").length > 0) {
		return true;
	} else {
		alert("선택된 데이터가 없습니다.");
		return false;
	}
}

function jq_is_chk_form(form, name) {
	if(name == null) {
		name="chk[]";
	}
	name = name.replace(/\[/g, "\\[");
	name = name.replace(/\]/g, "\\]");

	if($("#" + $(form).attr("id") + " input[type=checkbox][name=" + name + "]:checked").length > 0) {
		return true;
	} else {
		alert("선택된 데이터가 없습니다.");
		return false;
	}
}

function jq_multi_delete(name, action, target) {
	if(!jq_is_chk(name)) return false;
    if(!check_delete()) return false; 

	_action_delete(action, target);
}
function jq_multi_delete_form(form, name, action, target) {
	if(!jq_is_chk_form(form, name)) return false;
    if(!check_delete()) return false; 

	_action_delete_form(form, action, target);
}
function jq_multi_delete_pop(name, action, target) {
	if(!jq_is_chk(name)) return false;
    if(!check_delete()) return false; 

	_action_delete(action, target, 'pop');
}
function jq_multi_delete_check(name) {
	if(!jq_is_chk(name)) return false;
    if(!check_delete()) return false; 
	return true;
}
function jq_multi_sms(name, mode) {
	if(!jq_is_chk(name)) return false;

	var frm = document.frm;
	frm.mode.value = mode;

	var old_action = frm.action;
	var old_method = frm.mothod;
	var old_target = frm.target;
	var old_onsubmit_func = frm.onsubmit;

	frm.action = "/mng/sms.php";
	frm.mothod = "post";
	frm.target = "_self";
	frm.onsubmit = null;
	frm.submit(); 

	frm.action = old_action;
	frm.mothod = old_method;
	frm.target = old_target;
	frm.onsubmit = old_onsubmit_func;
}

function _action_delete(action, target, pos) {
	action_submit(action, "mdel", target, pos);
}
function _action_delete_form(form, action, target, pos) {
	action_submit_form(form, action, "mdel", target, pos);
}
function action_submit(action, mode, target, pos) {
	var frm = document.frm;
	frm.mode.value = mode;

	var old_action = frm.action;
	var old_method = frm.mothod;
	var old_target = frm.target;
	var old_onsubmit_func = frm.onsubmit;

	if(target == null) target = (pos == "pop" ? "act_pifr" : "act_ifr");
	if(action == null) action = old_action;

	frm.action = action;
	frm.mothod = "post";
	frm.target = target;
	frm.onsubmit = null;
	frm.submit(); 

	frm.action = old_action;
	frm.mothod = old_method;
	frm.target = old_target;
	frm.onsubmit = old_onsubmit_func;
}
function action_submit_form(form, action, mode, target, pos) {
	var frm = form;
	frm.mode.value = mode;

	var old_action = frm.action;
	var old_method = frm.mothod;
	var old_target = frm.target;
	var old_onsubmit_func = frm.onsubmit;

	if(target == null) target = (pos == "pop" ? "act_pifr" : "act_ifr");
	if(action == null) action = old_action;

	frm.action = action;
	frm.mothod = "post";
	frm.target = target;
	frm.onsubmit = null;
	frm.submit(); 

	frm.action = old_action;
	frm.mothod = old_method;
	frm.target = old_target;
	frm.onsubmit = old_onsubmit_func;
}



//// form check
function form_check_name(val) {
	return /^[가-힣]*$/i.test(val);
}
function form_check_phone(val) {
	val = val.replace(/[ .-]+/g, '-');
	val = val.split('-');

	if(val.length != 3) return false;
	return form_check_phone1(val[0], val[1], val[2]);
}
function form_check_phone1(val1, val2, val3) {
	// 시외 전화번호
	if(/^(02|0[3-6][1-9])$/.test(val1)) {
		if(!/^[0-9]{3}$/.test(val2)) return false;
		if(!/^[0-9]{4}$/.test(val3)) return false;
		return true;
	} 
	// 휴대폰 및 기타
	else if(/^(0[1][016789]|0[5678][0-6]|050[2-6])$/.test(val1)) {
		if(!/^[0-9]{3,4}$/.test(val2)) return false;
		if(!/^[0-9]{4}$/.test(val3)) return false;
		return true;
	} 
	return false;
}
function form_check_mobile(val) {
	val = val.replace(/[ .-]*/g, '');
	return (/^[0][1][016789][0-9]{8,9}$/.test(val));
}
function form_check_id(val) {
	return /^[a-zA-Z][a-zA-Z0-9_-]{5,19}$/.test(val);
}

function form_check_pass(val) {
	return /^.{4,20}$/.test(val);
}
function form_check_email(v) {
	var filter = /^[a-zA-z_-]+[0-9a-zA-Z._-]+@[a-zA-z-]+[0-9a-zA-Z.-]+\.[a-zA-Z]{2,3}$/;
	return (filter.test(v));
}
function form_check_email1(v1, v2) {
	var filter1 = /^[a-zA-z_-]+[0-9a-zA-Z._-]+$/;
	var filter2 = /^[a-zA-z-]+[0-9a-zA-Z.-]+\.[a-zA-Z]{2,3}$/;
	return (filter1.test(v1) && filter2.test(v2));
}

//// common
function conv_numberic(val) {
	val = String(val);
	val = val.replace(/[^0-9.]*/g,'');
	if(!val) val = 0;
	return parseFloat(val);
}
function number_format(v1,v2){
	v1 = parseInt(conv_numberic(v1), 10);
	if(v2 == null || v2 < 1) v2 = 3;
	var str = new Array();
	v1 = String(v1);
	for(var i=1;i<=v1.length;i++){
		if(i % v2) str[v1.length-i] = v1.charAt(v1.length-i);
		else str[v1.length-i] = ','+v1.charAt(v1.length-i);
	}
	return str.join('').replace(/^,/,'');    
} 
function number_format_object(obj, v2) {
	obj.value = number_format(obj.value, v2);
}
