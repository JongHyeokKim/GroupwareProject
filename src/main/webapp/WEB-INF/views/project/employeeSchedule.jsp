<%@page import="com.groupware.project.service.IProjectService"%>
<%@page import="com.groupware.project.service.ProjectServiceImpl"%>
<%@page import="com.groupware.project.controller.ProjectController"%>
<%@page import="com.groupware.dto.MemberVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<% Date day = new Date();
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
String today = format.format(day);
%>
<%--==============================================================
 * 개인 일정 페이지
 * @author 정준호
 * @since  2016.09.01.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *     수정일              수정자                    수정내용
 *    -------      -------     -------------------
 *   2016.09.03.    정준호                     최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
===============================================================--%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
</head>
<body>
<style>
body {
	/* margin: 40px 10px; */
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 850px;
	margin: 0 auto;
}
</style>
<script>
var choicePro;
	$(document).ready(function() {
			$.ajax({
	          type:"get",
	          url:"getEmployeeSchedule",
	          dataType:"json",
	          success:function(data){  
	        	  $.each(data, function(key, value){
	        		  eventData = {
	          					id:value.mem_sch_code,
	          					title:value.mem_sch_tt,
	          					content:value.mem_sch_mm,
	          					start:value.mem_sch_beg_day,
	          					end:value.mem_sch_end_day,
	          					procode:value.mem_sch_pro_code
	          				};
	        			 $('#calendar').fullCalendar('renderEvent', eventData, true);
	        		});
	          },
	          error:function(){
		          alert("에러입니다.");
	          }
		});
		var arr = new Array();
		var obj = new Object();
		var id=1;
 		var title="일정명";
 		var content="일정내용";
		$('#calendar').fullCalendar({
			theme: true,
			header: {
				left: 'today',
				center: 'prev, title, next',
				right: 'month,agendaWeek,agendaDay'
			},
			defaultDate: '<%= today %>',
			selectable: true,
			selectHelper: true,
 		select: function(start, end) {
			$("#Name2").val("");
			$("#Content2").val("");
 			$("#StartDt2").val("" + start.format("YYYY-MM-DD"));
 	        $("#EvtStartDt2").val("" + start.toLocaleString());
 	        $("#EndDt2").val("" + end.format("YYYY-MM-DD"));
 	        $("#EvtEndDt2").val("" + end.toLocaleString());
 	       document.getElementById("members").innerHTML = "";
			document.getElementById("memCode").innerHTML = "";
 	        $("#ModalAdd2").dialog(
 	        {
 	            title: "일정 등록",
 	            width: 500,
 	            modal: true,
 	            buttons: [
 	                      {
 	                    	  text:"등록",
 	                    	  click: function(){
 	                   	      obj.title=$('#Name2').val();
 	                   	      obj.content=$('#Content2').val();
 	                   	      obj.start=$("#StartDt2").val();;
 	                   	      obj.end=$("#EndDt2").val();
 	                   	  var stDate = new Date(obj.start);
   						var endDate = new Date(obj.end);
   						var btMs = endDate.getTime() - stDate.getTime();
   						var startCheck = obj.start.match(/\d{4}[- /.]((0[13578]|1[02])[- /.](0[1-9]|[12][0-9]|3[01])|(0[469]|11)[- /.](0[1-9]|[12][0-9]|30)|02[- /.](0[1-9]|1\d|2[0-8]))|(\d{2}(0[48]|[2468][048]|[13579][26])|([02468][048]|[1359][26])00)[- /.]02[- /.]29/g);
	 	                    var endCheck = obj.end.match(/\d{4}[- /.]((0[13578]|1[02])[- /.](0[1-9]|[12][0-9]|3[01])|(0[469]|11)[- /.](0[1-9]|[12][0-9]|30)|02[- /.](0[1-9]|1\d|2[0-8]))|(\d{2}(0[48]|[2468][048]|[13579][26])|([02468][048]|[1359][26])00)[- /.]02[- /.]29/g);
	              	  if(obj.title==""){
	 	                   	swal("오류!","일정명을 입력하세요.","error");
	                 			  return false;
	                 		  }else if(obj.content==""){
	                 				swal("오류!","일정 메모를 입력하세요.","error");
	                 			  return false;
	                 		  }else if(obj.start==""){
	                 				swal("오류!","일정 시작일을 입력하세요.","error");
	                 			  return false;
	                 		  }else if(obj.end==""){
	                 				swal("오류!","일정 종료일을 입력하세요.","error");
	                  			  return false;
	                  		  }else if(!startCheck){
	                  			swal("오류!","시작일을 형식에 맞게 입력하세요.(YYYY-MM-DD)","error");
	                 			 return false;
	                 		  }else if(!endCheck){
	                 			 swal("오류!","종료일을 형식에 맞게 입력하세요.(YYYY-MM-DD)","error");
	                  			 return false;
	                 		  }else if(obj.start==obj.end){
	                 			 swal("오류!","일정 시작일과 종료일이 같습니다.","error");
	                 			  return false;
	                 		  }else if(btMs<0){
	                 			 swal("오류!","일정 시작일보다 종료일이 빠릅니다.","error");
	                 			  return false;
	                 		  }else if(obj.title.length>25){
	                 			 swal("오류!","일정명이 너무 깁니다.","error");
	                 			  return false;
	                 		  }else if(obj.content.length>20){
	                 			swal("오류!","일정 메모가 너무 깁니다","error");
	                			  return false;
	                 		  }
 	                   	      arr.push(obj);
 	                   	   if (title) {
 	          				eventData = {
 	          					title: obj.title,
 	          					start: obj.start,
 	          					content: obj.content,
 	          					end: obj.end,
 	          					id:obj.id
 	          				};
 	          			}
 	                   	   $.ajax({
 	                   		   type:"get",
 	                   		   url:"employeeInsetCalendar",
 	                   		   data:{"paramData" : JSON.stringify(arr)},
 	                   		   success:function(data){
 	                   			location.reload();
 	                   		   },
 	                   		   error:function(){
 	                   			   alert("에러입니다.");
 	                   		   }
 	                   	});
 	                    		$('#ModalAdd2').dialog("close",true);
 	                    	  }
 	                      }
                    ] 	                
 	        });
			}, 
			eventClick: function(event, jsEvent, view) {
				$("#Name").val(event.title);
				$("#StartDt").val(event.start.format("YYYY-MM-DD"));
				$("#EndDt").val(event.end.format("YYYY-MM-DD"));
				$("#Content").val(event.content);
				obj.title=event.title;
  				obj.content=event.content;
  				obj.start=event.start;
  				obj.end=event.end;
  				arr.push(obj);
  				 $.ajax({
 					type : "post", 
 					url : "getProjectMembers2",
 					dataType : 'json',
 					data : {"pro_code" : event.procode},
 					success : function(data) {
 						document.getElementById("members").innerHTML = "";
 						document.getElementById("memCode").innerHTML = "";
 						 $.each(data, function(key, value){
 							document.getElementById("members").innerHTML += value.mem_nm+" ";
 							document.getElementById("memCode").innerHTML += value.mem_num+",";
 						 });   
 						},
 					 error:function(){
             			   alert("에러입니다.");
             		   }
 					}); 
  			var auto = "<c:out value='${loginUser.mem_authority}'/>";
  			   if((auto == "ROLE_LEADER" ||auto == "ROLE_ADMIN")||(event.procode==null && auto== "ROLE_USER")){
				$.ajax({
			          type:"get",
			          url:"employFindId",
			          data:{"paramData":JSON.stringify(arr)},
			          success:function(data){
				$("#ModalAdd").dialog(
			 	        {
			 	            title: "일정 관리",
			 	            width: 500,
			 	            modal: true,
			 	            buttons: [
			 	                        {
			 	                    	  text:"수정",
			 	                    	  click:function(){
			 	                    		 obj.title=$('#Name').val();
			 	 	                   	     obj.content=$('#Content').val();
			 	 	                   	     obj.start=$("#StartDt").val();
			 	 	       				     obj.end=$("#EndDt").val();
			 	 	       				 var stDate = new Date(obj.start);
			 	   						var endDate = new Date(obj.end);
			 	   						var btMs = endDate.getTime() - stDate.getTime();
			 		                   	  
			 	   					var startCheck = obj.start.match(/\d{4}[- /.]((0[13578]|1[02])[- /.](0[1-9]|[12][0-9]|3[01])|(0[469]|11)[- /.](0[1-9]|[12][0-9]|30)|02[- /.](0[1-9]|1\d|2[0-8]))|(\d{2}(0[48]|[2468][048]|[13579][26])|([02468][048]|[1359][26])00)[- /.]02[- /.]29/g);
		 	 	                    var endCheck = obj.end.match(/\d{4}[- /.]((0[13578]|1[02])[- /.](0[1-9]|[12][0-9]|3[01])|(0[469]|11)[- /.](0[1-9]|[12][0-9]|30)|02[- /.](0[1-9]|1\d|2[0-8]))|(\d{2}(0[48]|[2468][048]|[13579][26])|([02468][048]|[1359][26])00)[- /.]02[- /.]29/g);
			 		                   if(obj.title==""){
			 		 	                   	swal("오류!","일정명을 입력하세요.","error");
			 		                 			  return false;
			 		                 		  }else if(obj.content==""){
			 		                 				swal("오류!","일정 메모를 입력하세요.","error");
			 		                 			  return false;
			 		                 		  }else if(obj.start==""){
			 		                 				swal("오류!","일정 시작일을 입력하세요.","error");
			 		                 			  return false;
			 		                 		  }else if(obj.end==""){
			 		                 				swal("오류!","일정 종료일을 입력하세요.","error");
			 		                  			  return false;
			 		                  		  }else if(!startCheck){
			 		                  			swal("오류!","시작일을 형식에 맞게 입력하세요.(YYYY-MM-DD)","error");
			 		                 			 return false;
			 		                 		  }else if(!endCheck){
			 		                 			 swal("오류!","종료일을 형식에 맞게 입력하세요.(YYYY-MM-DD)","error");
			 		                  			 return false;
			 		                 		  }else if(obj.start==obj.end){
			 		                 			 swal("오류!","일정 시작일과 종료일이 같습니다.","error");
			 		                 			  return false;
			 		                 		  }else if(btMs<0){
			 		                 			 swal("오류!","일정 시작일보다 종료일이 빠릅니다.","error");
			 		                 			  return false;
			 		                 		  }else if(obj.title.length>25){
			 		                 			 swal("오류!","일정명이 너무 깁니다.","error");
			 		                 			  return false;
			 		                 		  }else if(obj.content.length>20){
			 		                 			swal("오류!","일정 메모가 너무 깁니다","error");
			 		                			  return false;
			 		                 		  }
			 	 	       				arr.push(obj);
			 	 	       			if (title) {
	 	  	  	          				eventData = { 
	 	  	  	          					title: obj.title,
	 	  	  	          					start: obj.start,
	 	  	  	          					content: obj.content,
	 	  	  	          					end: obj.end,
	 	  	  	          				};
	 	  	  	          			}
		 	            			        	 $.ajax({
					 	  	                   		   type:"get",
					 	  	                   		   url:"employeeModifyCalendar",
					 	  	                   		   data:{"paramData":JSON.stringify(arr), "id":data},
					 	  	                   		   success:function(){
					 	  	                   			swal("수정 완료");
					 	  	                   			location.reload();
					 	  	                   		   },
					 	  	                   		   error:function(){
					 	  	                   			   alert("에러입니다");
					 	  	                   		   }
		 	            			        	 });
		 	            			        	 $('#ModalAdd').dialog("close",true);
		 	            			        	$('#calendar').fullCalendar( 'refetchEvents' );
			 	                    	  }
			 	                        }, 
			 	                        {
			 	                    	  text:"삭제",
			 	                    	  click:function(){
			 	                    		obj.title=event.title;
			 	            				obj.content=event.content;
			 	            				obj.start=event.start;
			 	            				obj.end=event.end;
			 	            				arr.push(obj);
			 	            				$.ajax({
			 	            			          type:"get",
			 	            			          url:"employFindId",
			 	            			          data:{"paramData":JSON.stringify(arr)},
			 	            			          success:function(data){
			 	            			        	  var id = data;
			 	                    		 $.ajax({
			 	  	                   		   type:"get",
			 	  	                   		   url:"employeeDeleteCalendar",
			 	  	                   		   data:{"id":id},
			 	  	                   		   success:function(){
			 	  	                   			swal("삭제 완료");
			 	  	                   			location.reload();
			 	  	                   		   },
			 	  	                   		   error:function(){
			 	  	                   			   alert("에러입니다.");
			 	  	                   		   }
			 	  	                   	});
			 	            			          },
			 	            			          error:function(){
			 	            				          alert("에러입니다.");
			 	            			          }
			 	            				});
			 	                    		  $('#ModalAdd').dialog("close");
			 	                    	  }
			 	                        }
			                    ] 	              
			 	        });
			          },
	  			         error:function(){
	                   			   alert("에러입니다.");
	                   		   }
	  			          });
  			   }else if(auto=="ROLE_USER"){
				$("#Name3").val(event.title);
				$("#StartDt3").val(event.start.format("YYYY-MM-DD"));
				$("#EndDt3").val(event.end.format("YYYY-MM-DD"));
				$("#Content3").val(event.content);
				  $.ajax({
						type : "post", 
						url : "getProjectMembers",
						dataType : 'json',
						data : {"pro_code" : event.id},
						success : function(data) {
							document.getElementById("members3").innerHTML = "";
							document.getElementById("memCode3").innerHTML = "";
							 $.each(data, function(key, value){
								document.getElementById("members3").innerHTML += value.mem_nm+" ";
								document.getElementById("memCode3").innerHTML += value.mem_num+",";
							 });   
							},
						 error:function(){
	            			   alert("에러입니다.");
	            		   }
						}); 
  				$.ajax({
			          type:"get",
			          url:"findId",
			          data:{"paramData":JSON.stringify(arr)},
			          success:function(data){
				$("#ModalAdd3").dialog(
			 	        {
			 	            title: "프로젝트 관리",
			 	            width: 500,
			 	            modal: true,
			 	                                   
			 	        });
			          },
	  			         error:function(){
	                   			   alert("에러입니다.");
	                   		   }
	  			          });
  				}
		    },
		 
			editable: true,
			eventLimit: true, // allow "more" link when too many events
		});
		
	});

</script>
				<div class="box-header">
						<h3 class="box-title"><strong>개인업무 일정</strong></h3>
						<br/>
						<div class="box box-info"></div>
					</div>
	<div id='calendar'></div>
	<div id="ModalAdd" style="display: none; width: 400px;">
		<div id="AddEvent" style="width: 400px;">
			일정 명:&nbsp; <input id="Name" type="text" style="width: 200px;" /><br /><span style="color: red;">25자 이내</span><br />
			<br /> 내용:&nbsp;&nbsp; <input id="Content" type="text" style="width: 360px;" /><br><span style="color: red;">20자 이내</span><br />
			<br /> 시작일:&nbsp;&nbsp; <input	id="StartDt" type="text" style="width: 360px;" /><span calss="dayFormat" style="color: red;">YYYY-MM-DD</span><br />
			<br /> 종료일:&nbsp;&nbsp; <input id="EndDt" type="text" style="width: 360px;" /><span calss="dayFormat" style="color: red;">YYYY-MM-DD</span><br />
			<br /> 프로젝트 인원:<div id="members"></div> <div id="memCode" hidden="hidden"></div><br />
			<br /> <br />
		</div>
	</div>
	<div id="ModalAdd2" style="display: none; width: 400px;">
		<div id="AddEvent" style="width: 400px;">
			일정 명:&nbsp; <input id="Name2" type="text" style="width: 200px;" /><br><span style="color: red;">25자 이내</span><br />
			<br /> 내용:&nbsp;&nbsp; <input id="Content2" type="text" style="width: 360px;" /><br><span style="color: red;">20자 이내</span><br />
			<br /> 시작일:&nbsp;&nbsp; <input	id="StartDt2" type="text" style="width: 360px;" /><span calss="dayFormat" style="color: red;">YYYY-MM-DD</span><br />
			<br /> 종료일:&nbsp;&nbsp; <input id="EndDt2" type="text" style="width: 360px;" /><span calss="dayFormat" style="color: red;">YYYY-MM-DD</span><br />
			<br /> <br />
		</div>
	</div>
	<div id="ModalAdd3" style="display: none; width: 400px;">
		<div id="AddEvent" style="width: 400px;">
			프로젝트 명:&nbsp; <input id="Name3" type="text" style="width: 200px;" /><br />
			<br /> 프로젝트 메모:&nbsp;&nbsp; <input id="Content3" type="text" style="width: 360px;" /><br />
			<br /> 시작일:&nbsp;&nbsp; <input	id="StartDt3" type="text" style="width: 360px;" /><span calss="dayFormat" style="color: red;">YYYY-MM-DD</span><br />
			<br /> 종료일:&nbsp;&nbsp; <input id="EndDt3" type="text" style="width: 360px;" /><span calss="dayFormat" style="color: red;">YYYY-MM-DD</span><br />
			<br /> 프로젝트 인원:<div id="members3"></div> <div id="memCode3" hidden="hidden"></div><br />
			<br /> <br />
		</div>
	</div>
</body>
</html>