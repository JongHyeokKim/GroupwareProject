<%--==============================================================
 * 사원정보수정 폼
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<link rel="stylesheet" href="resources/assets/css/jqx.base.css" type="text/css"/>
<script type="text/javascript" src="resources/assets/js/miniCalendar/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="resources/assets/js/miniCalendar/jqxcore.js"></script>
<script type="text/javascript" src="resources/assets/js/miniCalendar/jqxdatetimeinput.js"></script>
<script type="text/javascript" src="resources/assets/js/miniCalendar/jqxcalendar.js"></script>
<script type="text/javascript" src="resources/assets/js/miniCalendar/globalize.js"></script>
<script type="text/javascript" src="resources/assets/js/memberManagement/memberManagementUpdate.js"></script>


<script type="text/javascript">
	
/* 	function update(){
 		if(confirm("수정하시겠습니까?")==true){
			swal("수정되었습니다.","","success");
			return true;
		}else{
			return false;
		}
	}
 */
 
 function update(form){
		
			swal({
				title : "수정",
				text : "수정하시겠습니까?",
				type : "warning",
				showCancelButton : true,
				confirmButtonColor : "#DD6B55",
				confirmButtonText : "예",
				cancelButtonText : "아니오",
				closeOnConfirm : false
			}, function() {
				swal({
					title : "수정하였습니다.",
					type : "success"
				},function(){
					form.action="memberManagementUpdate";
					form.submit();
				});
			});
	}
 
 
		
/* 	function cancle(form){
		form.action="memberManagementList";
		form.submit();
		return true;
	} */

</script>

		<div class="box-header">
						<h3 class="box-title"><strong>사원정보 수정</strong></h3>
						<br/>
						<div class="box box-info"></div>
					</div>
	
<!-- 	action="memberManagementUpdate" 
	method="post" -->
	<div style="width: 1200px; margin-left: 50px;">
		<form method="post" class="form-horizontal" 
			enctype="multipart/form-data" name="frm" >
	
	<table id="example2" class="table table-bordered table-hover" 
			style="text-align: center;">
	<tbody>
				<tr>
					<td width="8%"><b>사 원 번 호</b></td>
					<td width="15%"><input type="text" style="width:100%;" class="form-control" value="${member.mem_num}"
						size="50%" name="mem_num" readonly="readonly">
					</td>
					<td width="8%"><b>패 스 워 드</b></td>
					<td width="15%">
						<input type="password" style="width:100%;" class="form-control" id="pwd" name="mem_pw" 
							value="${member.mem_pw}" readonly="readonly">
					</td>
				</tr>
				<tr>
					<td><b>사&nbsp;&nbsp;&nbsp;원&nbsp;&nbsp;&nbsp;명</b></td>
					<td>
						<input type="text" style="width:100%;" class="form-control" name="mem_nm" 
							pattern="[가-힣]{2,4}" title="한글 2~4자리로 입력바랍니다." maxlength="4" value="${member.mem_nm}">
					</td>
					<td><b>생 년 월 일</b></td>
					<td>
						<input type="text" class="form-control" name="mem_reg1" readonly="readonly"
					 		id="reg1"style="width:100%;" style="size: 20%;" value="${member.mem_reg1}">
					</td>
				</tr>
				<tr>
					<td><b>연&nbsp;&nbsp;&nbsp;락&nbsp;&nbsp;&nbsp;처</b></td>
					<td>
						<input type="tel" style="width:100%;" class="form-control" name="mem_tel" 
								value="${member.mem_tel}" readonly="readonly">
					</td>
					<td><b>이&nbsp;&nbsp;&nbsp;메&nbsp;&nbsp;&nbsp;일</b></td>
					<td colspan="2">
						<input type="text" style="width:100%;" class="form-control" placeholder="e-mail"
								id="email" name="mem_em" value="${member.mem_em}" readonly="readonly">
					</td>
				</tr>

				<tr>
					<td style="vertical-align: middle;"><b>사 원 이 미 지</b></td>
					<td>
						<img id="empImg" alt="your image" width="105px" height="140px" 
								src="resources/memberManagementImage/${member.mem_img}"/>
						<br/>
						<div class="btn btn-danger btn-file">
                  			<i class="fa fa-paperclip"></i> 첨 부 파 일
                   			<input type="file" id="imgInp" name="file"/>
                		</div>
					</td>
					<td style="vertical-align: middle;"><b>서 명 이 미 지</b></td>
					<td>
						<img id="signImg" alt="your image" width="150px" height="150px" 
								src="resources/memberSign/${member.mem_stamp}"/> 
						<br/>
						<div class="btn btn-danger btn-file">
                  			<i class="fa fa-paperclip"></i> 첨 부 파 일
                   			<input type="file" id="imgInp1" name="file1"/>
                		</div>
					</td>
				</tr>
				<tr>
					<td><b>입&nbsp;&nbsp;&nbsp;사&nbsp;&nbsp;&nbsp;일</b></td>
					<td>
						<input type="text" style="width:100%;" class="form-control" name="mem_jn" value="${member.mem_jn}" readonly="readonly">
					</td>
					<td><b>퇴&nbsp;&nbsp;&nbsp;사&nbsp;&nbsp;&nbsp;일</b></td>
					<td>
						<input type="text" class="form-control" id="inputDate" placeholder="endDate" name="mem_rt" style="width: 150px;" readonly="readonly"><input type="button" id="btn"  style="background-image:url('resources/assets/img/icon-calendar.png'); width: 15px;">
  						<div id="jqxcalendar" style="position: absolute;"></div>
					</td>
				</tr>
				<tr>
					<td><b>부서</b></td>
					<td>
						<select class="form-control" style="width:100%;" name="mem_dep_code">
						<c:choose>
							<c:when test="${member.mem_dep_code == '1'}">
								<option selected="selected" value="1">기획부</option>
								<option value="1" selected="selected">기획부</option>
								<option value="2">인사부</option>
								<option value="3">개발부</option>
								<option value="4">재무부</option>
								<option value="5">마케팅부</option>
								<option value="6">영업부</option>
							</c:when>
							<c:when test="${member.mem_dep_code == '2'}">
								<option value="1">기획부</option>
								<option value="2" selected="selected">인사부</option>
								<option value="3">개발부</option>
								<option value="4">재무부</option>
								<option value="5">마케팅부</option>
								<option value="6">영업부</option>
							</c:when>
							<c:when test="${member.mem_dep_code == '3'}">
								<option value="1">기획부</option>
								<option value="2">인사부</option>
								<option value="3" selected="selected">개발부</option>
								<option value="4">재무부</option>
								<option value="5">마케팅부</option>
								<option value="6">영업부</option>
							</c:when>
							<c:when test="${member.mem_dep_code == '4'}">
								<option value="1">기획부</option>
								<option value="2">인사부</option>
								<option value="3">개발부</option>
								<option value="4" selected="selected">재무부</option>
								<option value="5">마케팅부</option>
								<option value="6">영업부</option>
							</c:when>
							<c:when test="${member.mem_dep_code == '5'}">
								<option value="1">기획부</option>
								<option value="2">인사부</option>
								<option value="3">개발부</option>
								<option value="4">재무부</option>
								<option value="5" selected="selected">마케팅부</option>
								<option value="6">영업부</option>
							</c:when>
							<c:when test="${member.mem_dep_code == '6'}">
								<option value="1">기획부</option>
								<option value="2">인사부</option>
								<option value="3">개발부</option>
								<option value="4">재무부</option>
								<option value="5">마케팅부</option>
								<option value="6" selected="selected">영업부</option>
							</c:when>
					<c:otherwise>
						<option selected="selected" value="1">영업부</option>
					</c:otherwise>
					</c:choose>
					</select>
				</td>
				<td><b>직책</b></td>
				<td>
					<select class="form-control2" name="mem_pos_code" style="width:100%;">
						<c:choose>
							<c:when test="${member.mem_pos_code == '1'}">
								<option value="1" selected="selected">사원</option>
								<option value="2">대리</option>
								<option value="3">과장</option>
								<option value="4">부장</option>
								<option value="5">대표이사</option>
							</c:when>
							<c:when test="${member.mem_pos_code == '2'}">
								<option value="1">사원</option>
								<option value="2" selected="selected">대리</option>
								<option value="3">과장</option>
								<option value="4">부장</option>
								<option value="5">대표이사</option>
							</c:when>
							<c:when test="${member.mem_pos_code == '3'}">
								<option value="1">사원</option>
								<option value="2">대리</option>
								<option value="3" selected="selected">과장</option>
								<option value="4">부장</option>
								<option value="5">대표이사</option>
							</c:when>
							<c:when test="${member.mem_pos_code == '4'}">
								<option value="1">사원</option>
								<option value="2">대리</option>
								<option value="3">과장</option>
								<option value="4" selected="selected">부장</option>
								<option value="5">대표이사</option>
							</c:when>
							<c:when test="${member.mem_pos_code == '5'}">
								<option value="1">사원</option>
								<option value="2">대리</option>
								<option value="3">과장</option>
								<option value="4">부장</option>
								<option value="5" selected="selected">대표이사</option>
							</c:when>
							<c:otherwise>
								<input type="text" class="form-control" id="inputName"
									value="직책없음">
							</c:otherwise>
						</c:choose>
					</select>				</td>
				</tr>
				
				<tr>
					<td><b>권한</b></td>
					<td >					
					<select style="width:100%;" class="form-control2" name="mem_authority">
						<c:choose>
							<c:when test="${member.mem_authority == 'ROLE_USER'}">
								<option selected="selected" value="ROLE_USER">ROLE_USER</option>
								<option value="ROLE_LEADER">ROLE_LEADER</option>
								<option value="ROLE_ADMIN">ROLE_ADMIN</option>
							</c:when>
							<c:when test="${member.mem_authority == 'ROLE_LEADER'}">
								<option value="ROLE_USER">ROLE_USER</option>
								<option selected="selected" value="ROLE_LEADER">ROLE_LEADER</option>
								<option value="ROLE_ADMIN">ROLE_ADMIN</option>
							</c:when>
							<c:when test="${member.mem_authority == 'ROLE_ADMIN'}">
								<option value="ROLE_USER">ROLE_USER</option>
								<option value="ROLE_LEADER">ROLE_LEADER</option>
								<option  selected="selected" value="ROLE_ADMIN">ROLE_ADMIN</option>
							</c:when>
							<c:otherwise>
								<input type="text" class="form-control" id="inputName" value="권한없음">
							</c:otherwise>
						</c:choose>
					</select>
					</td>
					<td colspan="2">
						<img src="resources/assets/img/logo1.png" style="width: 140px; height: 40px; float: right;">
					</td>
				</tr>
	</tbody>			
</table>

			<div>
				<div style="float: right;">
				<br><br><br>
						<input type="button" class="btn btn-danger" value="수정" onclick="return update(this.form);">
					
					<a href="memberManagementList">
						<input type="button" class="btn btn-danger" value="목록">
					</a>
				</div>
			</div>
		</form>
		</div>
 <!-- CK Editor -->
<script src="https://cdn.ckeditor.com/4.5.7/standard/ckeditor.js"></script>

  
</body>
</html>

