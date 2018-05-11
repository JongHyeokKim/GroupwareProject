<%--==============================================================
 * 사원등록양식 폼
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 2 | Data Tables</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">

</head>

<body>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
	<script type="text/javascript" src="resources/assets/js/memberManagement/memberManagement.js"></script>
	<script type="text/javascript">
		
	var cnt = 2;
	
	$(function(){
		function search(){
			   $(".postcodify_address").val()=="";
		   }
		//$("#postcodify_search_button").postcodifyPopUp();
	   });
	
	function check(){
	      var mem_num = $("#num").val();
	      var patt = /[a-z0-9]{4}/;
	      if(mem_num==""){
	    	  swal("아이디를 입력하세요.","","info");
	         return false;
	      }
	      
	      $.ajax({
	         url:"check",
	         type:"get",
	         data:{"mem_num":mem_num},
	         success:function(data){
	            if(!patt.test(mem_num)){
	               swal("형식에 맞지 않습니다.","","info");
	               return false;
	            }else if(patt.test(mem_num)){
	               $("#num").change(function(){
	                  cnt=2;
	               });
	               if(data==""){
	               swal("사용가능","","success");
	               cnt=0;
	               }
	            }
	         },
	         error:function(){
	            swal("중복","","error");
	            cnt=2;
	         }
	         
	      });
	   }
	
	function mySubmit(){
		
		var frm = document.frm;

		var yy     = $("#reg1").val().substr(0,2);
		var mm     = $("#reg1").val().substr(2,2);
		var dd     = $("#reg1").val().substr(4,2);
		
			if($("#num").val()==""){
				swal("사원번호 필수 항목","","info");
				frm.mem_num.select();
				return false;
			}else if($("#pwd").val()==""){
 		   	 swal("비밀번호 필수 항목","","info");
				frm.mem_pw.select();
				return false;
			}else if($("#name").val()==""){
				swal("사원명 필수 항목","","info");
				frm.mem_nm.select();
				return false;
			}else if($("#reg1").val()==""){
				swal("주민번호 앞자리 필수 항목","","info");
				frm.mem_reg1.select();
				return false;
			}else if(yy < "00" || yy > "99"){
				swal("년도를 확인바랍니다","","info");
				frm.mem_reg1.select();
				return false;
			}else if(mm < "01" || mm > "12"){
				swal("월은 01~12월까지 입력","","info");
				frm.mem_reg1.select();
				return false;
			}else if(dd < "01"|| dd > "31"){
				swal("일은 01~31일까지 입력","","info");
				frm.mem_reg1.select();
				return false;
			}else if($("#pwd").val() != $("#reg1").val()){
				swal("패스워드와 주민번호 앞자리 불일치","","info");
				return false;
			}else if($("#reg2").val()==""){
				swal("주민번호 뒷자리 필수 항목","","info");
				frm.mem_reg2.select();
				return false;
			}else if($("#address").val()=="") {
				swal("주소검색 필수 항목","","info");
				return false;
			}else if($("#address1").val()=="") {
				swal("상세주소 필수 항목","","info");
				return false;
			}else if($("#phone").val()==""){
				swal("연락처 필수 항목","","info");
				return false;
			}else if($("#email").val()==""){
				swal("이메일 필수 항목","","info");
				return false;
			}else if($("#imgInp").val()==""){
				swal("사원 이미지 필수 항목","","info");
				return false;
			}else if($("#imgInp1").val()==""){
				swal("서명 이미지 필수 항목","","info");
				return false;
			}else if(cnt==2){
				swal("아이디 중복 체크 필수 항목","","info");
				return false;
			}else {
				swal("등록되었습니다.","","success");
					return true;
			}
	}
	
		
	</script>

	<div class="box-header">
		<h3 class="box-title">
			<strong>사원 등록</strong>
		</h3>
		<br />
		<div class="box box-info"></div>
	</div>

	<form name="frm" class="form-horizontal" action="memberWrite" 
		  onsubmit="return mySubmit();" method="post" enctype="multipart/form-data">
	<span style="margin-left: 1063px;"><b>* 모든 정보는 필수 항목입니다.</b></span>
	<table id="example2" class="table table-bordered table-hover" style="text-align: center; width: 1200px; margin-left: 58px;">
		<tbody>
				<tr>
					<td class="line" style="vertical-align: middle;" width="10%"><b>사원번호</b></td>
					<td width="20%">
						<input type="text"class="form-control" style="width: 70%;" id="num"
							pattern="[a-z0-9]{4}" placeholder="영소문자 숫자 4자리" name="mem_num" maxlength="4">
						<input id="btn" type="button" class="btn btn-danger" value="중복확인" onclick="return check();">
					</td>
					<td class="line" style="vertical-align: middle;" width="10%"><b>패스워드</b></td>
					<td width="20%"><input type="password" style="width: 100%;" class="form-control" id="pwd" name="mem_pw" 
						placeholder="주민번호 앞 숫자 6자리" maxlength="6">
					</td>
				</tr>
				
				<tr>
					<td style="vertical-align: middle;"><b>사원명</b></td>
					<td>
						<input type="text" style="width: 100%;"class="form-control" pattern="[가-힣]{2,4}" title="한글로 입력바랍니다."
								id="name" name="mem_nm" placeholder="한글 2~4글자 입력해주세요" maxlength="4">
					</td>
					<td style="vertical-align: middle;"><b>주민등록번호</b></td>
					<td>
						<input type="text" style="width: 47%;" class="form-control3" name="mem_reg1" size="30px"
					 		id="reg1" placeholder="숫자 6자리" title="숫자만 입력 가능합니다." maxlength="6">&nbsp;&nbsp;-&nbsp;&nbsp;
					 	<input type="text" class="form-control3" style="width: 47%;" size="30px" name="mem_reg2"
							pattern="[1-4]{1}[0-9]{6}" id="reg2" title="숫자만 입력 가능합니다." placeholder="숫자 7자리" maxlength="7">
					</td>
				</tr>

				<tr>
					<td style="vertical-align: middle;"><b>도로명주소</b></td>
					<td>
						<input type="text" name="mem_addr" style="width:70%;" id="address" class="postcodify_address" value="" readonly="readonly"/>
						<input type="button" id="postcodify_search_button" class="btn btn-danger" name="mem_addr" onclick="search();" value="검색">
					</td>
					<td style="vertical-align: middle;"><b>상세주소</b></td>
					<td>
						<input type="text" name="mem_dt_addr" class="form-control" id="address1"
							pattern="[a-zA-Z0-9가-힣,@,-]{1,20}" title="공백 없이 입력하세요" style="width: 100%;" class="postcodify_details" 
							placeholder="공백 없이 입력, 특수문자는 @,-만 가능" maxlength="20"/>
					</td>
				</tr>

				<tr>
					<td style="vertical-align: middle;"><b>연락처</b></td>
					<td>
						<input type="text" id="phone" style="width: 100%;" class="form-control" name="mem_tel" 
								pattern="01[0|1|6|7|9]{1}[1-9]{3,4}[0-9]{4}" title="한글, 영소/대문자, 특수문자 입력 불가" 
								placeholder="01(0,1,6,7,9)으로 시작 10~ 11자리 '-'제외 " maxlength="11">
					</td>
					<td style="vertical-align: middle;"><b>이메일</b></td>
					<td>
						<input type="text" class="form-control" placeholder="한글/특문/공백 입력불가"
								pattern="[a-zA-Z0-9]{1,30}" id="email" style="width: 47%;" 
								title="한글, 특수문자 입력 불가합니다." name="mem_em" maxlength="30">
						@
						<select class="form-control" style="width: 47%;" name="mem_em1">
							<option selected="selected">naver.com</option>
							<option>gmail.com</option>
						</select>
					</td>
				</tr>

				<tr>
					<td style="vertical-align: middle;"><b>사원이미지</b></td>
					<td><img id="empImg" alt="your image" width="130px" height="150px" src="resources/assets/img/noImg.jpg" />
					<br/><div class="btn btn-danger btn-file">
                  <i class="fa fa-paperclip"></i> 첨부 파일
                   <input type="file" id="imgInp" name="file"/>
                </div>
					</td>
					<td style="vertical-align: middle;"><b>서명이미지</b></td>
					<td>
						<img id="signImg" alt="your image" width="150px" height="150px" src="resources/assets/img/noImg.jpg" /> 
						<br/>
						<div class="btn btn-danger btn-file">
                  		<i class="fa fa-paperclip"></i> 첨부 파일
                   		<input type="file" id="imgInp1" name="file1"/>
                		</div>
					</td>
				</tr>

				<tr>
					<td style="vertical-align: middle;"><b>부서</b></td>
					<td>
					 <select class="form-control" style="width: 100%;" name="mem_dep_code">
						<option selected="selected" value="1">기획부</option>
						<option selected="selected" value="2">인사부</option>
						<option selected="selected" value="3">개발부</option>
						<option selected="selected" value="4">재무부</option>
						<option selected="selected" value="5">마케팅부</option>
						<option selected="selected" value="6">영업부</option>
					</select>
					</td>
					<td style="vertical-align: middle;"><b>직책</b></td>
					<td >
					<select class="form-control2" name="mem_pos_code" style="width: 100%;">
						<option value="1">사원</option>
						<option value="2">대리</option>
						<option value="3">과장</option>
						<option value="4">부장</option>
					</select>
					</td>
				</tr>
				
				<tr>
					<td style="vertical-align: middle;"><b>권한</b></td>
					<td ><select class="form-control2" name="mem_authority" style="width: 100%;">
							<option selected="selected" value="ROLE_USER">ROLE_USER</option>
							<option value="ROLE_LEADER">ROLE_LEADER</option>
							<option value="ROLE_ADMIN">ROLE_ADMIN</option>
						</select>
					</td>
					<td colspan="2">
						<img src="resources/assets/img/logo1.png" style="width: 150px; height: 40px; float: right;">
					</td>
				</tr>
		</tbody>			
	</table>
			<div style="float: right; margin-right: 65px;">
					<div class="pull-right">
					<br><br><br>
						<input type="submit" class="btn btn-danger" value="등록">
						<a href="memberManagementList">
							<input type="button" class="btn btn-danger" value="취소">
						</a>
					</div>
			</div>
		</form>

</body>
</html>