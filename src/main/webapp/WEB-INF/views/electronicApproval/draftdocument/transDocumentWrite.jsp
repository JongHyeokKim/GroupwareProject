<%--==============================================================
 * 임시 저장문서 작성 폼
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../../dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="../../dist/css/skins/_all-skins.min.css">
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>

<body class="hold-transition skin-blue sidebar-mini" style="z-index: 0;">
<!-- jQuery 2.2.3 -->
<script src="../../plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="../../bootstrap/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="../../plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../dist/js/demo.js"></script>
<!-- CK Editor -->
<script src="https://cdn.ckeditor.com/4.5.7/standard/ckeditor.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script type="text/javascript">
var htmlCode = "";
var htmlCodeView = "";
var sig_mem = new Array();
 $(function () {
	    // Replace the <textarea id="editor1"> with a CKEditor
	    // instance, using default configuration.
	    CKEDITOR.replace('editor1');
	    //bootstrap WYSIHTML5 - text editor
	    $(".textarea").wysihtml5();
 });
	
 function info_chk(frm) {
		if(htmlCode==""){
			swal("결재자 에러!", "결재자가 선택되지 않았습니다.", "error");
		}else if(htmlCode!=""){
			if($("#sig_doc_period").val()!="0" && $("#sig_doc_tt").val()!=""){
						swal({
			    			title : "상신!",
			    			text : "작성한 문서가 정상적으로 상신 되었습니다.",
			    			type : "success"
			    		},
			    		function(){
			    			frm.submit();
			    			return true;
			    		});
			}else{
				swal({
	    			title : "정보를 모두 채워주세요.",
	    			text : "필수 정보가 입력되지 않았습니다.",
	    			type : "error"
	    		},
	    		function(){
	    			return false;
	    		});
			}
			
		}
		
	}
	function info_chk2(frm) {
		swal({
			title : "임시저장!",
			text : "결재자 및 문서보존 기한은 저장되지 않습니다.",
			type : "info"
		},
		function(){
			frm.action = "transDocumentWriteRepeatUpdate";
			frm.submit();
			return true;
		});
		
	}
	function finishSigMemSetting(){
		htmlCode = "";
		htmlCodeView = "";
		$("#sigMemTd").html(htmlCode);
		$("#sigMemView").html(htmlCode);
		for(i=0; i<sig_mem.length; i++){
			htmlCodeView += "<input type='text' class='form-control signWidth' value='" +(i+1)+". ["+sig_mem[i].position+"] "+sig_mem[i].name+"' readonly='readonly'>";
			if(i!=sig_mem.length-1){
				htmlCode += "<br>";
			}
			htmlCode += "<input type='hidden' name='signMem"+"' value='"+sig_mem[i].id+"'>";
			htmlCode += "<input type='hidden' name='signMemPos"+"' value='"+sig_mem[i].position+"'>";
		}
		$("#sigMemTd").append(htmlCode);
		$("#sigMemView").append(htmlCodeView);
	}
	function signMemPlus(){
		swal({
			title : "결재자 추가",
			text : "결재 순서대로 결재자를 추가해주세요. 결재자는 4명이상 추가되지 않습니다.",
			type : "info"
		},
		function(){
			window.open('/gw/draftAddressBook','','top=200,left=300');
		});
	}
</script>
<style type="text/css">	
.h{
	background-color: lightgrey;
}
#oneImg:hover{	
	z-index:2;
	position:absolute;
	left:120px;
	top:-10px;
	
	width:500px;
	height:670px;
	
}
.signWidth{
width:220px;
margin-bottom: 10px;
}
</style>
<div style="z-index: 1; overflow: hidden;">

	<div style="float: left" class="col-md-3 sizetest box box-default collapsed-box box-header with-border">
		
		<div>
				<div class="box-tools">
					<input type="button" id="signBtn" class="btn btn-default"
						style="float: right;" value="결재자 추가"
						onclick="signMemPlus();">
						<br/>
				</div>
				<br>
				<div id="sigMemView" class="box-tools"></div>
				<c:if test="${getDocumentDetail.sig_doc_classi==1}">
					<div style="width: 300px; height: 470px;">
						<img id="oneImg" style="width: 300px; height: 470px;" src="resources/assets/img/inserDoc.png">
					</div>
				</c:if>
				<c:if test="${getDocumentDetail.sig_doc_classi==2}">
					<div style="width: 300px; height: 470px;">
						<img id="twoImg" style="width: 300px; height: 470px;" src="resources/assets/img/inserDoc2.png">
					</div>
				</c:if>
			</div>
	</div>

	<c:choose>
		<c:when test="${getDocumentDetail.sig_doc_classi==1}">
			<div class="writeMargin" style="overflow: hidden">
				<div id="one"  class="box-body">
					<!-- Main content -->
					<form action="transDocumentWriteRepeatChange">
						<div class="row" style="margin-left: 20px">
							<table border="1" style="width: 70%">
						<tr style="height: 30px;">
							<td>
								<input type="hidden" name="sig_doc_classi" value="1">
								<select class="form-group col-sm-10 form-control" style="width: 190px;" name="sig_doc_period">
								<option selected="selected">보존 기한</option>
								<option value="6개월">6개월</option>
								<option value="1년">1년</option>
								<option value="2년">2년</option>
								<option value="5년">5년</option>
								<option value="10년">10년</option>
								<option value="영구보존">영구보존</option>
							</select>
							</td>
							
						</tr>
						<tr style="height: 30px;">
							<td>
							<label style="width:80px;">기안자</label>
							<input type="text" placeholder="기   안   자" value="${getDocumentDetail.mem_nm}" disabled="disabled">

							<label style="width:80px;">기안 일자</label>
							<input type="text" placeholder="기 안 일 자" value="${getDocumentDetail.sig_doc_day}" disabled="disabled" name="sig_doc_day"></td>

						</tr>

						<tr style="height: 35px;">
							
							<td>
							<label style="width:80px;">제     목</label>
							<input type="text" style="width:400px;" value="${getDocumentDetail.sig_doc_tt}" placeholder="제    목" name="sig_doc_tt">
							</td>
						</tr>
						<tr>
							<td>
							 <textarea id="editor1" rows="60" cols="20" name="sig_doc_cont" placeholder="내용을 입력하세요.">${getDocumentDetail.sig_doc_cont}</textarea>
							</td>
						</tr>
					</table>
								<div style="float: right; margin-right: 320px;margin-top: 10px; letter-spacing: 5px;">
									<input type="button" class="btn btn-danger" value="상신" onclick='return info_chk(this.form)'>
									<input type="reset" class="btn btn-danger" value="재작성">
									<input type="button" class="btn btn-danger" value="임시저장" onclick='return info_chk2(this.form);'>
								</div>
						</div>
						 <div id="sigMemTd"></div>
						 <input type="hidden" value="${getDocumentDetail.sig_doc_mem_num}"name="sig_doc_mem_num">
						 <input type="hidden" value="${getDocumentDetail.sig_doc_num}" name="sig_doc_num">
						 <input type="hidden" value="${getDocumentDetail.sig_doc_sig_lin_num}" name="sig_doc_sig_lin_num">
						 <input type="hidden" value="${getDocumentDetail.sig_doc_sig_st_num}" name="sig_doc_sig_st_num" value="5">
					</form>
				</div>
			</div>
		</c:when>
		<c:when test="${getDocumentDetail.sig_doc_classi==2}">
			<div class="writeMargin">
				<div id="two"  class="box-body">
					<!-- Main content -->
					<form action="transDocumentWriteRepeatChange">
						<div class="row" style="margin-left: 150px">
							<table border="1" style="width: 60%">
								<tr style="height: 30px;">
									<td>휴가 계획서<input type="hidden" name="sig_doc_classi_num"
										value="2"></td>
								</tr>
								<tr style="height: 30px;">
									<td><select class="form-group col-sm-10 form-control"
										style="width: 190px;" name="sig_doc_period">
											<option selected="selected">휴가종류</option>
											<option value="연차">연차</option>
											<option value="월차">월차</option>
											<option value="경조휴가">경조휴가</option>
											<option value="공가">공가</option>
											<option value="병가">병가</option>
											<option value="조퇴">조퇴</option>
											<option value="결근">결근</option>
											<option value="기타">기타</option>
									</select></td>
								</tr>
								<tr style="height: 30px;">
									<td><input type="text" placeholder="기 안 일 자"
										name="sig_doc_day"></td>
								</tr>
								<tr style="height: 35px;">
									<td><input type="text" placeholder="기   안   자"></td>
								</tr>

								<tr style="height: 35px;">
									<td><input type="text" placeholder="휴 가 일 수"
										name="sig_doc_tt">일</td>
								</tr>
								<tr>
									<td><textarea rows="30" cols="20" placeholder="사        유"
											name="sig_doc_cont"></textarea></td>
								</tr>
								<tr>
									<td><input type="text" name="sig_doc_sig_st_num" value="5"
										hidden="hidden"></td>
								</tr>
							</table>
							<input type="submit" value="상신"> <input type="reset" value="재작성">
							<input type="button" value="임시저장" onclick='return info_chk2(this.form);'> 
						</div>
					</form>
					
				</div>
			</div>
		</c:when>
		<c:when test="${getDocumentDetail.sig_doc_classi==3}">
			<div class="writeMargin">
				<div id="three" >
					<p>threebbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb</p>
				</div>

			</div>
		</c:when>
	</c:choose>
	</div>
</body>
</html>