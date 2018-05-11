<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--==============================================================
 * 임시비밀번호 발송 페이지
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
<html>
<head>
<meta charset="utf-8">

<title>로그인</title>
<link href="treeview/css/sweetalert.css" rel="stylesheet">
<script src="treeview/js/sweetalert.min.js"></script>
<script type="text/javascript" src="treeview/js/jquery.js"></script>
<script type="text/javascript" src="treeview/js/jquery.form.js"></script>
<script>
    function pwdSend(){
		if($("#mem_num").val()==""){
			swal("오류","사원번호를 입력하세요.","warning");
		}
		else if($("#mem_reg").val()==""){
			swal("오류","주민번호를 입력하세요.","warning");
		}
		else if($("#mem_mail").val()==""){
			swal("오류","이메일을 입력하세요.","warning");
		}
		else{
		$("#passwordChangeForm").ajaxForm({
			beforeSend:function(){
				$(".wrap-loading").removeClass('display-none');
			}
			,complete:function(){
				 $(".wrap-loading").addClass('display-none');
			},
			url : "passwordSend",
			dataType : "text",
			success : function(data){
				if(data==""){
					
					swal("오류","이메일과 주민번호를 확인하시오.","warning");
				}
			     else{
					swal({
							title: "전송완료",
							text: "이메일에 임시 비밀번호를 전송했습니다.",
							type: "warning"},
							function(){
								location.href="login";
							});
				}
			},
			error : function(){
				swal("통신 에러","서버 통신 에러입니다.","error");
			}
		}).submit();
		}
	}
    </script>
<link href="resources/assets/css/login/bootstrap-theme.css"
	rel="stylesheet">
<link href="resources/assets/css/login/style.css" rel="stylesheet">
<link href="resources/assets/css/login/line-icons.css" rel="stylesheet">
<link href="resources/assets/css/login/elegant-icons-style.css"
	rel="stylesheet">
<style>
.wrap-loading { /*화면 전체를 어둡게 합니다.*/
	position: fixed;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
	background: rgba(0, 0, 0, 0.2); /*not in ie */
	filter: progid:DXImageTransform.Microsoft.Gradient(startColorstr='#20000000',
		endColorstr='#20000000'); /* ie */
}

.wrap-loading div { /*로딩 이미지*/
	position: fixed;
	top: 50%;
	left: 50%;
	margin-left: -21px;
	margin-top: -21px;
}

.display-none { /*감추기*/
	display: none;
}
</style>
</head>

<body class="login-img3-body">

	<div class="container">

		<form class="login-form" id="passwordChangeForm" action="passwordSend"
			method="post">
			<div class="wrap-loading display-none">
				<div>
					<img width="50px" height="50px" src="treeview/images/spinner.gif" />
				</div>
			</div>
			<div class="login-wrap">
				<p class="login-img">
					<i class="icon_lock_alt"></i>
				</p>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon_profile"></i></span>
					<input type="text" name="mem_num" id="mem_num" class="form-control"
						placeholder="사원번호" autofocus="">
				</div>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon_key_alt"></i></span>
					<input type="text" maxlength="13" name="mem_reg" id="mem_reg"
						class="form-control" placeholder="주민번호">
				</div>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon_mail"></i></span> <input
						type="email" name="mem_mail" id="mem_mail" class="form-control"
						placeholder="이메일">
				</div>
				<label class="checkbox"> <span class="pull-right"> <a
						href="/gw/login"> 로그인 이동 ▷</a></span>
				</label> <input type="button" class="btn btn-primary btn-lg btn-block"
					onclick="pwdSend()" value="임시 비밀번호 전송">
			</div>
		</form>
	</div>





</body>
</html>