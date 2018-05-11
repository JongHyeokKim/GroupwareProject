<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page trimDirectiveWhitespaces="true" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%--==============================================================
 * 설문 수정
 * @author 함박눈
 * @since  2016.08.29.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.08.29.  함박눈      최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
===============================================================--%>
  <!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>AdminLTE 2 | Editors</title>
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

<body class="hold-transition skin-blue sidebar-mini">

<link rel="stylesheet" href="resources/assets/css/jqx.base.css" type="text/css"/>
<script type="text/javascript" src="resources/assets/js/miniCalendar/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="resources/assets/js/miniCalendar/jqxcore.js"></script>
<script type="text/javascript" src="resources/assets/js/miniCalendar/jqxdatetimeinput.js"></script>
<script type="text/javascript" src="resources/assets/js/miniCalendar/jqxcalendar.js"></script>
<script type="text/javascript" src="resources/assets/js/miniCalendar/globalize.js"></script>
 <script type="text/javascript">
  function getFormatDate(date){
		var year = date.getFullYear();                                 //yyyy
		var month = (1 + date.getMonth());                     //M
		month = month >= 10 ? month : '0' + month;     // month 두자리로 저장
		var day = date.getDate();                                        //d
		day = day >= 10 ? day : '0' + day;                            //day 두자리로 저장
		return  year + '-' + month + '-' + day;
	}
  //마감일자
      $(document).ready(function () {
    	  var click = 0;
    	  $("#btn").click(function(){
    		  if(click==1){
    		     $("#jqxcalendar").jqxCalendar({ width: '250px', height: '250px' }).slideToggle();
    		     click=0;
    		  }
    		  else{
    			  $("#jqxcalendar").jqxCalendar({ width: '250px', height: '250px' }).slideDown();
    			  click=1;
    		  }
    	  });
          $('#jqxcalendar').bind('valuechanged', function (event) {
              var date = event.args.date;
              date = getFormatDate(date);
              $("#inputDate").val(date);
              $("#jqxcalendar").jqxCalendar({ width: '250px', height: '250px' }).fadeOut("slow");
          });
      });
      function selected(){
    	  var a = $("#no option:selected").val();
    		var restt=$("#restt").val();
    		var resenrday=$("#inputDate").val();
    		var resextt=$("#resextt").val();
    		var resit1=$("#resit1").val();
    		var resit2=$("#resit2").val();
    		
    		if(a==4){
  			swal("분류 선택",'설문 분류를 선택하시오.',"info");
  			return false;
    		}	
    		
    		else if(restt==""){
    			swal("제목 입력","설문 제목을 입력해주십시오.","warning");
    			return false;
    			
    		}
    		else if(resenrday==""){
    			swal("마감일 선택","설문 마감일을 입력해주십시오.","warning");
    			return false;
    			
    		}
    		else if(resextt==""){
    			swal("질의 선택","설문 질의를 입력해주십시오.","warning");
    			return false;
    		}
    		else if(resit1==""){
    			swal("선택지 입력","첫번째 선택 항목을 입력해주십시오.","warning");
    			return false;
    			
    		}
    		else if(resit2==""){
    			swal("선택지 입력","두번째 선택 항목을 입력해주십시오.","warning");
    			return false;
    			
    		}if(getBytes(100)==0){
	           swal("글자수 초과!","제목은 최대 100Byte까지 입력할 수 있습니다.","warning");
	           return false;
	        }else{
	        form.submit();
	        }
						return true;
    		
    		  		
  	}
  	function getBytes(maxByte) {
  	    var text = $("#restt").val();
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
  	           document.getElementById("maxByte").innerHTML = nbytes+"/100 Byte";
  	          }
  	     if (parseInt(nbytes) > parseInt(maxByte)) {           
  	         return 0;
  		}else{
  			return 1;
  		}
  	    
  	};
       
     
  </script> 
 

    <!-- Main content -->

    <section class="content">
      <div class="row">
        <div class="col-md-12">
        <br/>
      
            <div class="box-header">
              <!-- tools box -->
               <h3 class="box-title"><strong>설문조사 수정</strong></h3>
	<br/>
 	<div class="box box-info"></div>
              <!-- /. tools -->
            </div>
            <!-- /.box-header -->
            <div class="box-body pad">
            
            
           <form action="companySurveyUpdateCom" method="post"  onsubmit="return selected();">
           <input name="res_count1" type="hidden" value="${companySurveyInformation.res_count1}">
				<input name="res_count2" type="hidden" value="${companySurveyInformation.res_count2}">
				<input name="res_prog_st" type="hidden" value="${companySurveyInformation.res_prog_st}">
				<input name="res_code" type="hidden" value="${companySurveyInformation.res_code}">
        	<table >
        	<tr>
        		<th style="width: 70;">설문 분류 &nbsp;&nbsp;&nbsp;</th>
        		<td style="float: left;" style="width: 70;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        		
										<select name="res_res_classi_code" id="no">
        									<option value="4" selected="selected" >선택</option>
											<option value="1">사내복지</option>
											<option value="2">업무환경</option>
											<option value="3">기타</option>
										</select>
										
										</td>
										
        	</tr>
        	<tr><td>　</td></tr>
        	<tr>
        		<th style="width: 70;">설문 제목 <br/><span id="maxByte">0/100Byte</span></th>
        		<td style="float: right;" style="width: 70;"><input type="text" style="width: 800px;" id="restt" onkeyup="getBytes(100)" name="res_tt" class="form-control" placeholder="title" value="${companySurveyInformation.res_tt }"></td>
        	</tr>
        	<tr><td>　</td></tr>
        	<tr>
        		<th style="width: 70;">설문 마감일자 &nbsp;&nbsp; </th>
        		<td style="float: left;" style="width: 70;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        		<input type="text" class="form-control" value="${companySurveyInformation.res_enr_day }" id="inputDate" placeholder="endDate" name="res_enr_day" style="width: 150px;" readonly="readonly"><input type="button" id="btn"  style="background-image:url('resources/assets/img/icon-calendar.png'); width: 15px;">
  					<div id="jqxcalendar"></div></td>
        	</tr>
        	<tr><td>　</td></tr>
        	<tr>
        		<th style="width: 70;">설문 질의 &nbsp;&nbsp; </th>
        		<td style="float: right;" style="width: 70;"><input type="text" style="width: 800px;" maxlength="50" id="resextt" name="res_ex_tt" value="${companySurveyInformation.res_ex_tt }" class="form-control" placeholder="Quest"></td>
        	</tr>
        	<tr><td>　</td></tr>
        	<tr>
        		<th style="width: 70;">설문 문항 &nbsp;&nbsp; </th>
        		<td style="float: left;" style="width: 70;">
        		<input type="radio">&nbsp;&nbsp;<input type="text" style="width: 800px;" maxlength="50" id="resit1" value="${companySurveyInformation.res_it1 }" name="res_it1" class="form-control" placeholder="Yes"></td>
        	</tr>
        	<tr>
        	<td></td>
          		<td colspan="2" style="width: 70;"><div style="float: left;"><input type="radio">&nbsp;&nbsp;<input type="text" id="resit2" maxlength="50" name="res_it2" value="${companySurveyInformation.res_it2 }" style="width: 800px;" class="form-control" placeholder="No"></div><td>
        	<tr>
        	<td></td>
          		<td colspan="2" style="width: 70;"><div style="float: left;"><input type="radio">&nbsp;&nbsp;<input type="text" name="res_it3"  maxlength="50" value="${companySurveyInformation.res_it3 }" style="width: 800px;" class="form-control" placeholder="other"></div><td>
        	</tr>
        	<tr>
        	<td></td>
          		<td colspan="2" style="width: 70;"><div style="float: left;"><input type="radio">&nbsp;&nbsp;<input type="text" name="res_it4" maxlength="50" value="${companySurveyInformation.res_it4 }"  style="width: 800px;" class="form-control" placeholder="other"></div><td>
          		</tr>
      			</table>
      			<div style="float: right;">
      			
       <input type="submit" class="btn btn-danger" value="설문수정">
<input type="button" class="btn btn-danger" value="목록" onclick="location.href='/gw/companySurveyList';">
       </div>
         </form>
          
          
          
          
          
          
            </div>
          </div>
          <!-- /.box -->
        <!-- /.col-->
      </div>
      <!-- ./row -->
    </section>
  

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


  


</body>
</html>
