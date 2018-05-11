<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>

<body>
<script type="text/javascript">
	$(document).ready(function(){
		var mem_code = "<c:out value='${loginUser.mem_num}'/>";
		var pro_code = ${project.pro_code}
		$.ajax({
	          type:"post",
	          url:"getOpinion",
	          data :{"pro_code": pro_code},
	          success:function(data){
	        		  var makeTable ="<table style='margin-left:170px;'>";
	        	  $.each(data, function(key, value){
	        		  makeTable +="<tr><td style='padding:10px; width:200px;'>["+value.dep_nm
	        		  +"] "+ value.mem_nm +"</td><td style='width:700px;'>"
	        		  +value.op_opn+
	        		  "</td>"
	        		  if(value.op_mem_code==mem_code){
	        		  makeTable +="<td><button class='btn btn-danger' style='background:none'><img src='resources/assets/img/icon/deleteIcon.png' onclick='deleteOpinion("
	        		  +value.op_code+","+pro_code+");'></button></td><tr>";};
	        		 
	        	  });
	        	  makeTable +="</table>"
	        		  $('#opinionDiv').append(makeTable);
	          },
	          error:function(){
	        	  alert('실패');
	          }
	         });
	});
	function updateBtn(form){
		var pro_code = ${project.pro_code};
		swal({ 
			title: "수정 하시겠습니까?",  
			type: "warning",   showCancelButton: true,   
			confirmButtonColor: "#DD6B55",   
			confirmButtonText: "수정", 
			showCancelButton: true,
			cancelButtonText : "취소",
			closeOnConfirm: false }, 
			function(){
				form.action = "projectUpdate?pro_code="+pro_code;
				form.method="POST";
				form.target="_self";
				form.submit();
				swal("수정 완료");
				});
	};
	
	function deleteOpinion(op_code,pro_code){
		location.href="opinionDelete?op_code="+op_code+"&pro_code="+pro_code;
	};
	
	function getBytes(maxByte) {
		var text = $("#opinion").val();
	    var nbytes = 0;
	    for (i=0; i<text.length; i++) {
	    	   var ch = text.charAt(i);
	    	   if(escape(ch).length > 4) {
	    	    nbytes += 3;
	    	   } else if (ch == '\n') {
	    	    if (msg.charAt(i-1) != '\r') {
	    	     nbytes += 1;
	    	    }
	    	   } else if (ch == '<' || ch == '>') {
	    	    nbytes += 4;
	    	   } else {
	    	    nbytes += 1;
	    	   }
	    	   document.getElementById("maxByte").innerHTML = nbytes+"/300 Byte";
	    	  }
		 if (parseInt(nbytes) > parseInt(maxByte)) {           
	            return 0;
		}else{
			return 1;
		}
	   
};

	function insertOption(form){
		form.action = "insertOption?pro_code="+${project.pro_code};
		form.method = "post";
		form.target = "_self";
		if(getBytes(300)==0){
			swal("글자수 초과!","의견은 최대 300Byte까지 입력할 수 있습니다.","info");
			return false;
		}else{
		form.submit();
		}
	};
	
</script>
<style>
label.nmClass{
margin: 20px;
}
label.nmClass2{
margin-left: 20px;
margin-right: 20px;
margin-top: 20px;
float: left;
}
.proDetail{
width: 800px;
height: 300px;
margin-top: 20px;
resize:none;
}
body th{
text-align: center;
}
</style>
					<div class="box-header">
						<h3 class="box-title"><strong>프로젝트 정보</strong></h3>
						<br/>
						<div class="box box-info"></div>
					</div>
	<form>
  <table class="table table-bordered table-striped" style="width: 1000px; margin-left: 100px;">
  	<tr>
  		<th>프로젝트명  </th>
  		<td style="padding-left: 35px;">${project.pro_nm}</td>
  		</tr>
  		<tr>
  		<th>프로젝트 참여인원  </th>
  		<td style="padding-left: 35px;"><c:forEach var="member" items="${members}">
             ${member.mem_nm }&nbsp;&nbsp;&nbsp;
             </c:forEach>
       </td>
       </tr>
  	<tr>
  		<th>프로젝트 시작일　</th>
  		<td style="padding-left: 35px;">${project.pro_beg_day}</td>
  	</tr>
  	<tr>
  		<th>프로젝트 종료일　</th>
  		<td style="padding-left: 35px;">${project.pro_end_day}</td>
  	</tr>
  	<tr>
  		<th>프로젝트 상세설명</th>
  		<td style="padding-left: 35px;"><textarea class="proDetail" name="proDetail" >${project.pro_dt_mm }</textarea></td>
  	</tr>
  </table>
                  
                    <div class="col-sm-offset-2 col-sm-12" style="padding-left: 900px;">
                    <sec:authorize access="hasAnyRole('ROLE_LEADER', 'ROLE_ADMIN')">
                       <input type="button" class="btn btn-danger" value="수정" onclick="updateBtn(form);">
                       </sec:authorize>
                       <a href="projectSchedule"><input type="button" class="btn btn-danger" value="목록"></a>
                       <a href="pdfPrint?pro_code=${project.pro_code }"><input type="button" class="btn btn-danger" value="PDF 출력" ></a>
                  </div>
                </form>
                <div class="box-header" style="width: 80px;margin-left: 90px;" >
		<h3 class="box-title"><strong>의 견</strong></h3>
	<br/>
 	<div class="box box-info"></div>
	</div>
                <div id="opinionDiv">
                </div>
                <form>
                <div style="margin-top: 30px;margin-left: 170px;">
                <input type="text" name="opinion" id="opinion" size="105" maxlength="300" onkeyup="getBytes(300);">
               <input type="button" class="btn btn-danger" value="의견 등록" onclick="insertOption(this.form);"> <span id="maxByte" style="color: red;">0/300 Byte</span>
                </div>
                </form>
                
</body>
</html>