<%--==============================================================
 * 기안 문서
 * @author 박진우
 * @since  2016.08.31.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.08.31.  박진우      최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
===============================================================--%>
<%@page import="com.itextpdf.text.log.SysoLogger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기안서</title>
</head>

<body class="hold-transition skin-blue sidebar-mini" onresize="parent.resizeTo(735,870)" onload="parent.resizeTo(735,870)">
<link rel="stylesheet" href="treeview/css/emailCss.css" type="text/css">
<script src="treeview/js/sweetalert.min.js"></script>
<link rel="stylesheet" type="text/css" href="treeview/css/sweetalert.css"/>
<script type="text/javascript" src="treeview/js/jquery.js"></script>
<script type="text/javascript">
	function transUpdate(){
		var sig_doc_num = $("#sig_doc_num").text();
		swal({
			title : "서류를 수정합니다!",
			text : "수정 페이지로 이동합니다.",
			type : "info"
		},
		function(){
			 $(opener.location).attr("href", "javascript:transUpMethod("+sig_doc_num+");");
		     self.close();
		});
	}
	
	function signUp(){
		var sig_doc_num = $("#sig_doc_num").text();
		var sig_lin_dt_pref = $("#sig_lin_dt_pref").val();
		var ok_sign = "1";
		
		$.ajax({
		        url:"documentOk",
		        type:'GET',
		        contentType : "application/json",
		        data: {
		        	"sig_doc_num" : sig_doc_num,
		        	"sig_lin_dt_pref" : sig_lin_dt_pref,
		        	"ok_sign" : ok_sign
		        },
		        success:function(){
		        	swal({
		    			title : "승인!",
		    			text : "정상적으로 승인 처리 되었습니다.",
		    			type : "success"
		    		},
		    		function(){
		    			window.opener.location.reload();
			            self.close();
		    		});		            
		        }
		    });
	}

	function backUp(){
	 	var inputString = prompt('반려 사유를 입력하세요.', '-');
		var sig_doc_num = $("#sig_doc_num").text();
		var sig_lin_dt_pref = $("#sig_lin_dt_pref").val();
		var ok_sign = "2";
		$.ajax({
		        url:"documentNo",
		        type:'GET',
		        contentType : "application/json",
		        data: {
		        	"sig_doc_num" : sig_doc_num,
		        	"sig_lin_dt_pref" : sig_lin_dt_pref,
		        	"ok_sign" : ok_sign,
		        	"inputString" : inputString
		        },
		        success:function(){
		        	
		        	swal({
		    			title : "반려",
		    			text : "정상적으로 반려 처리 되었습니다.",
		    			type : "error"
		    		},
		    		function(){
		    			window.opener.location.reload();
			            self.close();
		    		});	
		        }
		    });
	}
	
	function backDoc(){
		var sig_doc_num = $("#sig_doc_num").text();
		$.ajax({
			url:"backDocument",
			type:"GET",
			contentType:"application/json",
			data:{
				"sig_doc_num" : sig_doc_num
			},
			success:function(){
 				swal({
 					title : "회수",
 					text : "문서를 정상적으로 회수하였습니다.",
 					type : "info"
 				},
 				function(){
 					window.opener.location.reload();
 					self.close();
 				});
			}
		});
	}
</script>

<style>
	td{
		height: 35px;
	}  
	
	.h{
		background-color: lightgrey;
	}

</style>  
	<!-- Main content -->
	
	<div class="row" style="margin: none;">
	<div style="text-align: center;">
		<h1>기&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;안&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;서</h1>
	</div>    
		
		<table border="1" style="width: 100%; border:3px solid black; border-collapse: collapse;">
			<tr style="height: 35px; text-align: center;">
				<td style="width: 15%;" class="h"><b>문 서 번 호</b></td>
				<td style="width: 25%;">SIG09DO30C<span id="sig_doc_num" >${getDocumentDetail.sig_doc_num}</span></td>
				<td style="width: 5%;" rowspan="6" class="h"><b>결</b><br><br><b>재</b></td>
				<td style="width: 10%;" class="h"><b>담&nbsp;&nbsp;&nbsp;&nbsp;당</b></td>
				<td style="width: 10%;" class="h"><b>
					<c:if test="${signList[0].sig_lin_dt_pos!=null}">
						${signList[0].sig_lin_dt_pos}
					</c:if>
					<c:if test="${signList[0].sig_lin_dt_pos==null}">
						-
					</c:if>
				</b></td>
				<td style="width: 10%;" class="h"><b>
					<c:if test="${signList[1].sig_lin_dt_pos!=null}">
						${signList[1].sig_lin_dt_pos}
					</c:if>
					<c:if test="${signList[1].sig_lin_dt_pos==null}">
						-
					</c:if>
				</b></td>
				<td style="width: 10%;" class="h"><b>
					<c:if test="${signList[2].sig_lin_dt_pos!=null}">
						${signList[2].sig_lin_dt_pos}
					</c:if>
					<c:if test="${signList[2].sig_lin_dt_pos==null}">
						-
					</c:if>
				</b></td>
				<td style="width: 10%;" class="h"><b>
					<c:if test="${signList[3].sig_lin_dt_pos!=null}">
						${signList[3].sig_lin_dt_pos}
					</c:if>
					<c:if test="${signList[3].sig_lin_dt_pos==null}">
						-
					</c:if>
				</b></td>
			</tr>
			<tr style="height: 30px; text-align: center;">
				<td class="h"><b>보 존 년 한</b></td>
				<td>${getDocumentDetail.sig_doc_period}</td>
				<td>
					-
				</td>
				<td>
					<c:if test="${signList[0].mem_nm!=null}">
						${signList[0].mem_nm}
					</c:if>
					<c:if test="${signList[0].mem_nm==null}">
						-
					</c:if>
				</td>
				<td>
					<c:if test="${signList[1].mem_nm!=null}">
						${signList[1].mem_nm}
					</c:if>
					<c:if test="${signList[1].mem_nm==null}">
						-
					</c:if>
				</td>
				<td>
					<c:if test="${signList[2].mem_nm!=null}">
						${signList[2].mem_nm}
					</c:if>
					<c:if test="${signList[2].mem_nm==null}">
						-
					</c:if>
				</td>
				<td>
					<c:if test="${signList[3].mem_nm!=null}">
						${signList[3].mem_nm}
					</c:if>
					<c:if test="${signList[3].mem_nm==null}">
						-
					</c:if>
				</td>
			</tr>
			<tr style="height: 30px; text-align: center;">
				<td class="h"><b>기 안 일 자</b></td>
				<td>${getDocumentDetail.sig_doc_day }</td>
				<td rowspan="2">&nbsp;<br>&nbsp;
				</td>
				<td rowspan="2"><c:if test="${okStamp[0].mem_stamp!=null}"><img src="resources/memberSign/${okStamp[0].mem_stamp}" width="50px" height="50px"></c:if>
				</td>
				<td rowspan="2"><c:if test="${okStamp[1].mem_stamp!=null}"><img src="resources/memberSign/${okStamp[1].mem_stamp}" width="50px" height="50px"></c:if>
				</td>
				<td rowspan="2"><c:if test="${okStamp[2].mem_stamp!=null}"><img src="resources/memberSign/${okStamp[2].mem_stamp}" width="50px" height="50px"></c:if>
				</td>
				<td rowspan="2"><c:if test="${okStamp[3].mem_stamp!=null}"><img src="resources/memberSign/${okStamp[3].mem_stamp}" width="50px" height="50px"></c:if>
				</td>
			</tr>
			<tr style="height: 25px; text-align: center;">
				<td class="h"><b>기 안 부 서</b></td>
				<td>${getDocumentDetail.dep_nm}</td>
			</tr>
			<tr style="height: 35px; text-align: center;">
				<td class="h"><b>기 &nbsp;&nbsp;안 &nbsp;&nbsp;자</b></td>
				<td><b>${getDocumentDetail.mem_nm}</b></td>
				<td colspan="5" rowspan="2"><b>위임 전결 실행 기준표
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;에 의거 <br>직책
					:
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					성명 :
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					전결</b>
				</td>
			</tr>
			<tr style="height: 35px; text-align: center;">
				<c:if test="${returnComment.mem_nm!=null}">
					<td class="h"><b>반 &nbsp;&nbsp;려 &nbsp;&nbsp;자</b></td>
					<td><b>${returnComment.mem_nm}</b></td>
				</c:if>
				<c:if test="${returnComment.mem_nm==null}">
					<td><b>최종결재자</b></td>
					<c:if test="${approvalName.mem_nm!=null}">
						<td>${approvalName.mem_nm }</td>
					</c:if>
					<c:if test="${approvalName.mem_nm==null }">
						<td>-</td>
					</c:if>
				</c:if>
			</tr>
			<tr style="height: 35px; text-align: center;">
				<c:if test="${returnComment.mem_nm!=null}">
					<td class="h"><b>제 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</b></td>
					<td colspan="4">${getDocumentDetail.sig_doc_tt}</td>
					<td colspan="3"><b>반 려 사 유</b></td>
				</c:if>
				<c:if test="${returnComment.mem_nm==null}">
					<td><b>제목</b></td>
					<td colspan="7">${getDocumentDetail.sig_doc_tt}</td>
				</c:if>
			</tr>
			<tr>
				<c:if test="${returnComment.mem_nm!=null}">
					<td colspan="5">
						<textarea rows="40" cols="60" style="border:0px" readonly="readonly">${getDocumentDetail.sig_doc_cont }</textarea>
					</td>
					<td colspan="3">
						<textarea rows="40" cols="30" style="border:0px" readonly="readonly">${returnComment.sig_lin_dt_comm }</textarea>
					</td>
				</c:if>
				<c:if test="${returnComment.mem_nm==null}">
					<td colspan="8">
						<textarea rows="40" cols="110" style="border:0px" readonly="readonly">${getDocumentDetail.sig_doc_cont }</textarea>
					</td>
				</c:if>
			</tr>
		</table>
		<input id="sig_lin_dt_pref" type="hidden" value="${okPref.sig_lin_dt_pref}"/>
			<c:if test="${getDocumentDetail.sig_doc_sig_st_num==1}">
				<input type="button" class="btn btn-danger" value="수정" onclick="transUpdate();">
			</c:if>
		<c:if test="${checking!=null}">
			<c:if test="${getDocumentDetail.sig_doc_sig_st_num!=1 }">
				<c:if test="${getDocumentDetail.sig_doc_sig_st_num!=3}">
						<input type="button" class="btn btn-danger" value="승인" onclick="signUp();"/>
						<input type="button" class="btn btn-danger" value="반려" onclick="backUp();"/>
				</c:if>
			</c:if>
		</c:if>
			<c:if test="${getDocumentDetail.sig_doc_mem_num==loginUser.mem_num}">
				<c:if test="${getDocumentDetail.sig_doc_sig_st_num==5}">
					<input type="button" class="btn btn-danger" value="회수" onclick="backDoc();"/>  
				</c:if>
			</c:if>
	</div>
	<div style="margin-bottom: 20px; ">
		<img src="resources/assets/img/logo1.png" style="float: right; width: 120px; height: 40px; 
					margin-top: 20px;"></div>
</body>
</html>