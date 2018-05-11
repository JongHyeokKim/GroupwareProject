function reloadUrl() {
	var url = document.location.href.replace("#(.*)$", "");
	document.location.replace(url);
}
function movePage(val1, val2)
{
	var old_method = document.frm.method;
	var old_action = document.frm.action;
	var old_target = document.frm.target;
	document.frm.page.value = val1;
	document.frm.method="get";
	document.frm.action = val2;
	document.frm.target = "_self";
	document.frm.submit();
	document.frm.method = old_method;
	document.frm.action = old_action;
	document.frm.target = old_target;
}
function movePage2(val1)
{
	var old_method = document.frm.method;
	var old_action = document.frm.action;
	var old_target = document.frm.target;
	document.frm.v_page.value=val1;
	document.frm.method="get";
	document.frm.target = "_self";
	document.frm.submit();
	document.frm.method = old_method;
	document.frm.action = old_action;
	document.frm.target = old_target;
}
function moveModify(url)
{
	url = url.replace('mode=view', 'mode=modify');
	document.location.replace(url);
}
function moveView(url)
{
	if(url.indexOf('mode=modify') < 0) {
		history.back();
	} else {
		url = url.replace('mode=modify', 'mode=view');
		document.location.replace(url);
	}
}
function move(url)
{
	document.location.replace(url);
}
function moveCancel(mode, url)
{
	if(mode=="upd") {
		url = url.replace('_write.', '_view.');
		document.location.replace(url);
	} else {
		history.back();
	}
}
function open_pop(url, name, w, h) {
	m_pop=window.open(url,name,'scrollbars=yes,width='+w+',height='+h+",resize=yes");
	if(m_pop) m_pop.focus();
}
function open_pop_submit(frm, url, name, w, h) {
	m_pop=window.open('about:blank','subpop_' + name,'scrollbars=yes,width='+w+',height='+h+",resize=yes");

	var old_method = frm.method;
	var old_action = frm.action;
	var old_target = frm.target;

	frm.method="post";
	frm.target="subpop_" + name;
	frm.action = url;
	frm.submit();

	frm.method = old_method;
	frm.action = old_action;
	var old_target = frm.target;

	if(m_pop) m_pop.focus();
}
function mail_pop(val){
	m_pop=window.open('/ems/send/mail_send.php?mail_type='+val,'m_pop','scrollbars=yes,width=800,height=650');
}
function sms_pop(val){
	s_pop=window.open('/ems/send/sms_send.php?mail_type='+val,'sms_pop','scrollbars=yes, width=325,height=525 scrollbars=no, status=no');
}

function mail_send(val){
	var old_method = document.frm.method;
	var old_target = document.frm.target;
	var old_action = document.frm.action;
	var action = "/ems/send/mail_send.php";

	if(val == null || val == "") {
		var chkitem = "chk[]"; 
		var chk_name = document.getElementsByName(chkitem); 
		var Cnt = 0; 
		for(i=0;i<chk_name.length;i++) {         
			if(chk_name[i].checked) Cnt += 1; 
		} 
		if(Cnt==0) { 
			alert("보낼 사람이 체크 되지 않았습니다.");
			return false; 
		}
	} else action += "?mail_type="+val;
	
	window.open('','mail_pop','width=800, height=650, scrollbars=no, status=no');
	document.frm.method="post";
	document.frm.target="mail_pop";
	document.frm.action = action;
	document.frm.submit();

	// target, action 되돌림
	document.frm.target = old_target;
	document.frm.action = old_action;
}

function sms_send(val){
	var old_method = document.frm.method;
	var old_target = document.frm.target;
	var old_action = document.frm.action;
	var action = "/ems/send/sms_send.php";

	if(val == null || val == "") {
		var chkitem = "chk[]"; 
		var chk_name = document.getElementsByName(chkitem); 
		var Cnt = 0; 
		for(i=0;i<chk_name.length;i++) {         
			if(chk_name[i].checked) Cnt += 1; 
		} 
		if(Cnt==0) { 
			alert("보낼 사람이 체크 되지 않았습니다.");
			return false; 
		}
	} else action += "?mail_type="+val;

	window.open('','sms_pop','width=325, height=525, scrollbars=no, status=no');
	document.frm.method="post";
	document.frm.target="sms_pop";
	document.frm.action = action;
	document.frm.submit();

	// target, action 되돌림
	document.frm.method = old_method;
	document.frm.target = old_target;
	document.frm.action = old_action;
}

// excel or print
function list_print(purl, type, w, h){
	if( type == 'excel' ) {
		if(purl.indexOf('?') < 0) {
			purl += '?tm=excel';
		} else {
			purl += '&tm=excel';
		}
		act_ifr.location.href=purl;
	} else {
		if(purl.indexOf('?') < 0) {
			purl += '?tm=print';
		} else {
			purl += '&tm=print';
		}
		if(!w) w=800;
		if(!h) h=700;
		var win = window.open(purl,'prt_pop','width='+w+', height='+h+', scrollbars=yes, status=no');
		if(win) win.focus();
	}
}

//check all
function all_check(form1) 
{ 
	for( var i=0; i<form1.elements.length; i++) { 
		var check = form1.elements[i]; 
		check.checked = true; 
	} 
	return; 
} 


//uncheck all
function un_check(form1) 
{ 
	//alert(form1);
	for( var i=0; i<form1.elements.length; i++) { 
		var check = form1.elements[i]; 
		check.checked = false; 
	} 
	return; 
}

function getCookieVal(offset) {
    var endstr = document.cookie.indexOf (";", offset);
    if (endstr == -1) {
        endstr = document.cookie.length;
    }
    value = document.cookie.substring(offset, endstr);
    if(value == 'null' || value == '' || value == null) return null;
    else return unescape(value);
}

function getCookie(name) {
    var arg = name + "=";
    var alen = arg.length;
    var clen = document.cookie.length;
    var i = 0;

    while (i < clen) {
        var j = i + alen;
        if (document.cookie.substring(i, j) == arg) {
            return getCookieVal (j);
        }
        i = document.cookie.indexOf(" ", i) + 1;
        if (i == 0) break;
    }
    return null;
}

function setCookie (name, value) {
    var argv = setCookie.arguments;
    var argc = setCookie.arguments.length;
    var expires = (argc > 2) ? argv[2] : null;
    var path = (argc > 3) ? argv[3] : null;
    var domain = (argc > 4) ? argv[4] : null;
    var secure = (argc > 5) ? argv[5] : false;
    document.cookie = name + "=" + escape (value) +
        ((expires == null) ? "" : ("; expires=" + expires.toGMTString())) +
        ((path == null) ? "" : ("; path=" + path)) +
        ((domain == null) ? "" : ("; domain=" + domain)) +
        ((secure == true) ? "; secure" : "");
}

function deleteCookie(name) {
    var exp = new Date();
    exp.setTime (exp.getTime() - 1);
    var cval = getCookie (name);
    if (cval != null) {
		setCookie(name, '', exp, '/');
    }
}
