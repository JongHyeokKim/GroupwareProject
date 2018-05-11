<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title></title>
</head>
<body style="overflow: none;">
	<script type="text/javascript" src="treeview/js/jquery.js"></script>
	<script type="text/javascript" src="treeview/js/jquery.form.js"></script>
	<script type="text/javascript">
		var recievers = new Array();
		var recieversMail = new Array();
		function onSend(){
		 	if($("#emailFile").val()!=""){
				$("#emailFile").attr("name","emailFile");
			}
		 	if($("#recievers").val()!=""){
				$("#sendForm").ajaxForm({
						beforeSend:function(){
					        $(".wrap-loading").removeClass('display-none');
					    }
					    ,complete:function(){
					        $(".wrap-loading").addClass('display-none');
					    },
						url : "emailSend",
						dataType : "text",
						success : function(data) {
							var result = data;
							if(result=="Mail Successfully Send"){
								swal({
										title: "메일 전송 성공!",
										text: "메일이 성공적으로 전송되었습니다.\n메인화면으로 돌아갑니다.",
										type: "success",
									}, function(){location.href="main";});
							}else if(result=="Authentication Error"){
								swal("계정 인증 실패!", "메일 계정 인증에 실패했습니다.\n비밀번호를 확인해주세요.", "warning");
							}else if(result=="Address Error"){
								swal("메일 전송 실패!", "메일 전송에 실패했습니다.\n수신자 메일 중 유효하지않은 주소가 존재합니다.", "error");
							}
						},
						error : function() {
							swal("메일 전송 에러!", "메일 전송에 실패했습니다.\n메일 전송 중 에러가 발생했습니다.", "error");
						}
				}).submit();
		 	}else{
		 		swal("수신자 설정 오류!", "설정된 수신자가 없습니다.\n주소록을 통해 우측 선택영역으로 추가해 주십시오.", "error");
		 	}
		
		}
		
		function finishAddressSetting(){
			var recieversName="";
			var htmlCode="";
			$("#recievers").val("");
			$("#receiveDiv").html("");
			for(i=0; i<recievers.length; i++){
				recieversName += recievers[i].name;
				htmlCode+="<input name='emailRecievers' type='hidden' value='"+recievers[i].email+"'>";
				if(i!=recievers.length-1){
					recieversName+=", ";
				}
				recieversMail[i] = recievers[i].email;
			}
			$("#recievers").val(recieversName);
			$("#receiveDiv").html(htmlCode);
		};
		
		function getFileName(fileObj){
			var filePath = fileObj.value;
			var fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
			$("#attachFileName").val(fileName);
		};
		
	</script>
<style>
	.email-label{
		width:9%;
		text-align: center;
	}
	.email-pass-label{
		width:16%;
		text-align: center;
	}
	.wrap-loading{ /*화면 전체를 어둡게 합니다.*/
	    position: fixed;
	    left:0;
	    right:0;
	    top:0;
	    bottom:0;
	    background: rgba(0,0,0,0.2); /*not in ie */
	    filter: progid:DXImageTransform.Microsoft.Gradient(startColorstr='#20000000', endColorstr='#20000000');    /* ie */
	    
	}
    .wrap-loading div{ /*로딩 이미지*/
        position: fixed;
        top:50%;
        left:50%;
        margin-left: -21px;
        margin-top: -21px;
    }
    .display-none{ /*감추기*/
        display:none;
    }
</style>
                 <div class="box-header">
              <!-- tools box -->
             <h3 class="box-title"><strong>메일보내기</strong></h3>
	<br/>
 	<div class="box box-info"></div>
              <!-- /. tools -->
            </div>
            <!-- /.box-header -->
            <div style="margin-left:30px; width: 1200px;">
 
        
             <form id="sendForm" action="emailSend" method="post">
          
            <div class="box-body">
              <div class="form-group">
              	<input id="returnState" type="hidden" value="${returnState }">
              	<label class="email-label">내 메일 주소</label>
                <input name="emailAddress" class="form-control" style="width:40%;" value="${loginUser.mem_em }" readonly="readonly">
                <label class="email-pass-label">메일 계정 비밀번호 입력</label>
                <input name="emailPassword" type = "password" class="form-control" style="width:25%;" value="" placeholder="Mail Account Password" required>
              </div>
              <div class="form-group">
              	<label class="email-label">받는 사람</label>
                <input id="recievers" name="emailRecieversNames" class="form-control" style="width:76%;" placeholder="To:" readonly="readonly" required>
                 <button type="button" class="btn btn-danger" onclick="window.open('/gw/emailAddressBook','','width=300,height=500,top=300,left=400');">주소록</button>
              </div>
              <div id="receiveDiv"></div>
              <div class="form-group">
              	<label class="email-label">제목</label>
                <input name="emailTitle" class="form-control" style="width:82%;" placeholder="Subject:" required="required">
              </div>
              <div class="form-group" style="padding-left:110px;">
                    <textarea name="emailContent" id="compose-textarea" class="form-control" style="height: 400px; width: 90%;" required></textarea>
              </div>
              <div class="form-group" style="padding-left:110px;">
                <div class="btn btn-danger btn-file">
                  <i class="fa fa-paperclip"></i> 첨부 파일
                   <input type="file" id="emailFile" onchange="getFileName(this);">
                </div>
                  <input id="attachFileName" name="emailFileName" class="form-control" style="width:50%;" readonly="readonly" value="">
              </div>
            </div>
           <div class="wrap-loading display-none">
    			<div><img width="50px" height="50px" src="treeview/images/spinner.gif" /></div>
			</div>
            <!-- /.box-body -->
           
              <div style="float: right;">
                <button type="button" class="btn btn-danger" onclick="location.href='/gw/main';">Home</button>
                <button type="button" class="btn btn-danger" onclick="onSend();"><i class="fa fa-envelope-o"></i> 보내기</button>
              </div>
              <button type="reset" style="margin-left:133px;" class="btn btn-danger"><i class="fa fa-times"></i> 초기화</button>
            
             </form>
            <!-- /.box-footer -->
          </div>
          <!-- /. box -->
          
        
        <!-- /.col -->

</body>
</html>