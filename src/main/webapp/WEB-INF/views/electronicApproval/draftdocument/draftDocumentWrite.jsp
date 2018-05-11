<%--==============================================================
 * 문서 작성 폼
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
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
		    CKEDITOR.replace('editor2');
		    //bootstrap WYSIHTML5 - text editor
		    $(".textarea").wysihtml5();
		  });
	
		function selectEvent(sel) {
			if (sel.value == "0") {
				$("#one").hide();
				$("#two").hide();
				$("#three").hide();
				$("#signBtn").hide();
				$("#oneDoc").hide();
				$("#twoDoc").hide();
				$("#emptyImg").show();
			}
			if (sel.value == "1") {
				$("#one").show()
				$("#two").hide();
				$("#three").hide();
				$("#signBtn").show();
				$("#oneDoc").show();
				$("#twoDoc").hide();
				$("#emptyImg").hide();
			}
			if (sel.value == "2") {
				$("#one").hide()
				$("#two").show();
				$("#three").hide();
				$("#signBtn").show();
				$("#oneDoc").hide();
				$("#twoDoc").show();
				$("#emptyImg").hide();
			}
			if (sel.value == "3") {
				$("#one").hide()
				$("#two").hide();
				$("#three").show();
				$("#signBtn").show();
				$("#oneDoc").hide();
				$("#twoDoc").hide();
				$("#emptyImg").hide();
			}

		}
		
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
			if ($("#sig_doc_tt").val() != "") {
				swal({
					title : "임시저장!",
					text : "결재자 및 문서보존 기한은 저장되지 않습니다.",
					type : "info"
				}, function() {
					frm.action = "transDocumentWriteForm";
					frm.submit();
					return true;

				});
			} else {
				swal({
					title : "정보를 모두 채워주세요.",
					text : "필수 정보가 입력되지 않았습니다.",
					type : "error"
				}, function() {
					return false
				});
			}

		}

	function finishSigMemSetting() {
		htmlCode = "";
		htmlCodeView = "";
		$("#sigMemTd").html(htmlCode);
		$("#sigMemView").html(htmlCode);
		for (i = 0; i < sig_mem.length; i++) {
			htmlCodeView += "<input type='text' class='form-control signWidth' value='"
					+ (i + 1)
					+ ". ["
					+ sig_mem[i].position
					+ "] "
					+ sig_mem[i].name + "' readonly='readonly'>";
			if (i != sig_mem.length - 1) {
				htmlCode += "<br>";
			}
			htmlCode += "<input type='hidden' name='signMem"+"' value='"+sig_mem[i].id+"'>";
			htmlCode += "<input type='hidden' name='signMemPos"+"' value='"+sig_mem[i].position+"'>";
		}
		$("#sigMemTd").append(htmlCode);
		$("#sigMemView").append(htmlCodeView);
	}
	function signMemPlus() {
		swal({
			title : "결재자 추가",
			text : "결재 순서대로 결재자를 추가해주세요. 결재자는 4명이상 추가되지 않습니다.",
			type : "info"
		}, function() {
			window.open('/gw/draftAddressBook', '', 'top=200,left=300');
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
		left:250px;
		top:-10px;
		
		width:500px;
		height:620px;
	}
	#twoImg:hover{	
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
	table{
		border-collapse:none;
		border : 3px solid black;
		
	}
	
	</style>
	<div class="box-header">
						<h3 class="box-title"><strong>기안문서등록</strong></h3>
				
					</div>
<div style="z-index: 1; overflow: hidden; height:800px;">
		<div style="float: left"
			class="col-md-3 sizetest box box-default collapsed-box box-header with-border">
			
			<div>
				<div class="box-tools">
					<select name="sig_doc_classi"
						onChange="javascript:selectEvent(this)"
						class="form-group col-sm-10 form-control">
						<option value="0" selected="selected">작성문서 선택</option>
						<option value="1">기안서</option>
						<option value="2">휴가계획서</option>
						<option value="4">출장신청서</option>
						<option value="5">출장보고서</option>
						<option value="6">교육신청서</option>
						<option value="7">지출결의서</option>
						<option value="8">재직증명신청서</option>
					</select>
					<input type="button" id="signBtn" class="btn btn-default"
						   style="float: right; display: none;" value="결재자 추가" onclick="signMemPlus();">
				</div>
				<br>
				<div id="sigMemView" class="box-tools"></div>
				<div id="oneDoc" style="margin-top:20px; width: 300px; height: 470px; display: none;">
					<img id="oneImg" src="resources/assets/img/inserDoc.png">
				</div>
				<div id="twoDoc" style="width: 300px; height: 470px; display: none;">
					<img id="twoImg" src="resources/assets/img/inserDoc2.png">
				</div>
			</div>
		</div>



		<div class="writeMargin" style="overflow: hidden; margin-left: 400px;">
			<img id="emptyImg" style="margin-top: 30px;" src="resources/assets/img/emptyImg.png">
		<div id="one" style="display: none;" class="box-body">
			<!-- Main content -->
			<form action="draftDocumentWrite">
				<div class="row" style="margin-left: 20px">
					<table style="width: 60%">
						<tr style="height: 30px;">
							<td>
							
								<input type="hidden" name="sig_doc_classi" value="1">
								<select id="sig_doc_period" class="form-group col-sm-10 form-control" style="width: 190px; float: right;" name="sig_doc_period">
								<option value="0" selected="selected">보존 기한</option>
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
							&nbsp;&nbsp;
							<label style="width:80px;">기안자</label>
							<input type="text" placeholder="기   안   자" value="${mem_nm}" disabled="disabled">

							<label style="width:80px;">기안 일자</label>
							<input type="text" placeholder="기 안 일 자" value="${today}" disabled="disabled" name="sig_doc_day"></td>

						</tr>

						<tr style="height: 35px;">
							
							<td>&nbsp;&nbsp;
							<label style="width:80px;">제     목</label>
							<input id="sig_doc_tt" type="text" style="width:400px;" placeholder="제    목" name="sig_doc_tt" maxlength="25">
							</td>
						</tr>
						<tr>
							<td>
							 <textarea id="editor1" rows="60" cols="20" name="sig_doc_cont" placeholder="내용을 입력하세요."></textarea>
							</td>
						</tr>
						<tr>
							<td><input type="text" name="sig_doc_sig_st_num" value="5"
								hidden="hidden"></td>
						</tr>
					</table>
					<div style="float: right; margin-right: 420px;margin-top: 10px; letter-spacing: 5px;">
					<input type="button" class="btn btn-danger" value="상신" onclick='return info_chk(this.form)'> <input type="reset" class="btn btn-danger" value="재작성">
					<input type="button" class="btn btn-danger" value="임시저장" onclick='return info_chk2(this.form);'>
					</div> 
				</div>
			  <div id="sigMemTd"></div>
							<input type="hidden" value="${mem_num}" name="sig_doc_mem_num">
							<input type="hidden" value="${today}" name="sig_doc_day">
			</form>
		</div>

		<div id="two" style="display: none;" class="box-body">
			<!-- Main content -->
			<form action="draftDocumentWrite">
				<div class="row" style="margin-left: 20px">
					<table border="1" style="width: 70%">
						<tr style="height: 30px;">
							<td>
								<input type="hidden" name="sig_doc_classi" value="1">
								<select class="form-group col-sm-10 form-control" style="width: 190px;" name="sig_doc_period">
									<option selected="selected">휴가종류</option>
									<option value="1">연차</option>
									<option value="2">월차</option>
									<option value="3">경조휴가</option>
									<option value="4">공가</option>
									<option value="5">병가</option>
									<option value="6">조퇴</option>
									<option value="7">결근</option>
									<option value="8">기타</option>
								</select>
							</td>
							
						</tr>
						<tr style="height: 30px;">
							<td>
							<label style="width:80px;">기안자</label>
							<input type="text" placeholder="기   안   자" value="${mem_nm}" disabled="disabled">

							<label style="width:80px;">기안 일자</label>
							<input type="text" placeholder="기 안 일 자" value="${today}" disabled="disabled" name="sig_doc_day"></td>

						</tr>

						<tr style="height: 35px;">
							
							<td>
							<label style="width:80px;">휴 가 일 수</label>
							<input type="text" placeholder="2002-01-01 ~ 2002-01-05" name="sig_doc_tt">
							</td>
						</tr>
						<tr>
							<td>
							 <textarea id="editor2" rows="40" cols="20" name="sig_doc_cont" placeholder="사        유"></textarea>
							</td>
						</tr>
						<tr>
							<td><input type="text" name="sig_doc_sig_st_num" value="5"
								hidden="hidden"></td>
						</tr>
					</table>
					<div style="float: right; margin-right: 420px;margin-top: 10px; letter-spacing: 5px;">
					<input type="button" class="btn btn-danger" value="상신" onclick='return info_chk(this.form)'> <input type="reset" class="btn btn-danger" value="재작성">
					<input type="button" class="btn btn-danger" value="임시저장" onclick='return info_chk2(this.form);'>
					</div> 
				</div>
			  <div id="sigMemTd"></div>
							<input type="hidden" value="${mem_num}" name="sig_doc_mem_num">
							<input type="hidden" value="${today}" name="sig_doc_day">
			</form>
		</div>

		<div id="three" style="display: none;">
			<p>threebbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb</p>
		</div>

	</div>
	</div>
</body>
</html>
