<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--==============================================================
 * 설문 상세정보
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
<meta charset="UTF-8">
<title></title>
</head>
<body>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	function checked(){
		var radioNull=0;
		var checkRadio = document.getElementsByName("gender");
		for(var i=0; i<checkRadio.length; i++){
			if(checkRadio[i].checked==true){
				radioNull++;
			}
		}
		if(radioNull==0){
			swal("설문문항 선택 오류!","설문 문항중 한가지를 선택해 주세요.","warning");
		}
			if(checkRadio[0].checked==true){
				location.href="companySurveyAdd?res_code="+${companySurveyInformation.res_code}+"&res_count1=1&res_count2=0&res_count3=0&res_count4=0";
			}else if(checkRadio[1].checked==true){
				location.href="companySurveyAdd?res_code="+${companySurveyInformation.res_code}+"&res_count1=0&res_count2=1&res_count3=0&res_count4=0";
			}else if(checkRadio[2].checked==true){
				location.href="companySurveyAdd?res_code="+${companySurveyInformation.res_code}+"&res_count1=0&res_count2=0&res_count3=1&res_count4=0";
			}else if(checkRadio[3].checked==true){
				location.href="companySurveyAdd?res_code="+${companySurveyInformation.res_code}+"&res_count1=0&res_count2=0&res_count3=0&res_count4=1";
			}
	}
	
	
	  google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawChart);
      
      function drawChart() {
    	  var i = 2;
    	  var restt = document.getElementById("restt").value;
    	  var resextt = document.getElementById("resextt").value;
    	  var it1 = document.getElementById("resit1").value;
    	  var it2 = document.getElementById("resit2").value;
    	  var it3 = document.getElementById("resit3").value;
    	  var it4 = document.getElementById("resit4").value;
    	   if(it3!=""){
    		  i++;
    	  }
    	  if(it4!=""){
    		  i++;
    	  } 
    	  var rescount1 = document.getElementById("rescount1").value;
    	  var rescount2 = document.getElementById("rescount2").value;
    	  var rescount3 = document.getElementById("rescount3").value;
    	  var rescount4 = document.getElementById("rescount4").value;
		
    	  var data = new google.visualization.DataTable();
    	  data.addColumn('string', '항목');
    	  data.addColumn('number', '득표율');
    	  data.addRows(i);
    	  data.setCell(0, 0, it1);
    	  data.setCell(0, 1, parseInt(rescount1));
    	  data.setCell(1, 0, it2);
    	  data.setCell(1, 1, parseInt(rescount2));
    	  if(i>=3){
    	  data.setCell(2, 0, it3);
    	  data.setCell(2, 1, parseInt(rescount3));
    	  }
    	  if(i==4){
    	  data.setCell(3, 0, it4);
    	  data.setCell(3, 1, parseInt(rescount4));
    	  }
        var options = {
         
          bars: 'vertical' // Required for Material Bar Charts.
        };

        var chart = new google.charts.Bar(document.getElementById('barchart_material'));

        chart.draw(data);
      }
</script>
	  
	<div class="col-md-12">
		<br />  
		
			<div class="box-header">
				<!-- tools box -->
 <h3 class="box-title"><strong>설문조사</strong></h3>
	<br/>
 	<div class="box box-info"></div>
				<!-- /. tools -->
			</div>
			
				<input name="res_count1" type="hidden" value="${companySurveyInformation.res_count1}">
				<input name="res_count2" type="hidden" value="${companySurveyInformation.res_count2}">
				<input name="res_res_classi_code" type="hidden" value="${companySurveyInformation.res_res_classi_code}">
				<table id="example1" class="table table-bordered table-striped">
					<thead>
						<tr>
						
							<th style="text-align: center; width: 10%;">글번호</th>
							<th style="text-align: center;">${companySurveyInformation.res_code}</th>
							<th style="text-align: center; width: 10%;">설문자</th>
							<th style="text-align: center; width: 15%; ">${companySurveyInformation.mem_nm}</th>
							<th style="text-align: center; width: 10%;">진행현황</th>
							<th style="text-align: center; width: 30%;">
							<c:choose>
								<c:when test="${companySurveyInformation.res_prog_st==1}"><label>진행중</label></c:when>
								<c:when test="${companySurveyInformation.res_prog_st==2}"><label>설문마감</label></c:when>
								
							
							</c:choose>
							</th>
							<th style="text-align: center; width: 10%;"">작성일</th>
							<th style="text-align: center;">${companySurveyInformation.res_wrt_day}</th>
						<tr />
						<tr>
							<th style="text-align: center;">설문분류</th>
							<th style="text-align: center;">${companySurveyInformation.res_classi_nm}</th>
							<th style="text-align: center;">설문명</th>
							<th style="text-align: center;" colspan="3">${companySurveyInformation.res_tt}</th>
							<th style="text-align: center;">마감일자</th>
							<th style="text-align: center;">${companySurveyInformation.res_enr_day}</th>
						<tr />
						</table>
					
						<table style="height: 300px;">
						<tr>
							<th>
							&nbsp;&nbsp;&nbsp;&nbsp;
							${companySurveyInformation.res_ex_tt}
							</th>
						</tr>
						<tr>
							<td>
							
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="gender" value="res_count1">&nbsp;&nbsp;
							${companySurveyInformation.res_it1}
							</td>
						</tr>
						<tr>
							<td>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="gender" value="res_count2">&nbsp;&nbsp;
							${companySurveyInformation.res_it2}
							</td>
						
						</tr>
						<tr>
							<td>
								<c:choose>
								<c:when test="${companySurveyInformation.res_it3!=null}">
										&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="radio" name="gender" value="res_count3">&nbsp;&nbsp;${companySurveyInformation.res_it3}
								</c:when>
									
								</c:choose>
							</td>
						</tr>
						<tr>
							<td>
									<c:choose>
											<c:when test="${companySurveyInformation.res_it4!=null}">
												&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="radio" name="gender" value="res_count4">&nbsp;&nbsp;${companySurveyInformation.res_it4}
											</c:when>
											
								</c:choose>
							</td>
						</tr>
						</table>
						
						
						
						
						
						<c:choose>
			<c:when test="${companySurveyInformation.res_prog_st==2}">
			<table style="height: 300px; overflow: scroll;">
			
			<div class="col-md-12">
				<br />
			<div class="box box-info">
			<div class="box-header">
				<!-- tools box -->

				<!-- /. tools -->
			</div>
			
			 <div id="barchart_material" style="width: 900px; height: 200px;">
			 </div>
			</div>
			 
			<input type="hidden" id="resextt" value="${companySurveyInformation.res_ex_tt }">
			<input type="hidden" id="restt" value="${companySurveyInformation.res_tt }">
			<input type="hidden" id="resit1" value="${companySurveyInformation.res_it1 }">
			<input type="hidden" id="resit2" value="${companySurveyInformation.res_it2 }">
			<input type="hidden" id="resit3" value="${companySurveyInformation.res_it3 }">
			<input type="hidden" id="resit4" value="${companySurveyInformation.res_it4 }">
			<input type="hidden" id="rescount1" value="${companySurveyInformation.res_count1 }">
			<input type="hidden" id="rescount2" value="${companySurveyInformation.res_count2 }">
			<input type="hidden" id="rescount3" value="${companySurveyInformation.res_count3 }">
			<input type="hidden" id="rescount4" value="${companySurveyInformation.res_count4 }">
			</div>
			
			
			</table>
			</c:when>
			</c:choose>

			
			
				
		<c:choose>
			<c:when test="${companySurveyInformation.res_prog_st==1}">
				
			
		<c:if test="${checkVO==null}">
		
		<button class="btn btn-danger" style="float: right;" id="addbtn" onclick="checked()">설문제출
		</button>
		<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_LEADER')">
		<a href="companySurveyDelete?res_code=${companySurveyInformation.res_code}"><input type="button" class="btn btn-danger" style="float: right;" value="설문삭제"></a>
	
		<a href="companySurveyUpdate?res_code=${companySurveyInformation.res_code}">
		<input type="button" style="float: right;" class="btn btn-danger" value="설문수정">
		</a>
		</sec:authorize>
		</c:if>
		<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_LEADER')">
		<a href="companySurveyDeadline?res_code=${companySurveyInformation.res_code}&res_prog_st=${companySurveyInformation.res_prog_st}&res_count1=${companySurveyInformation.res_count1}&res_count2=${companySurveyInformation.res_count2}&res_count3=${companySurveyInformation.res_count3}&res_count4=${companySurveyInformation.res_count4}">
		<input type="button" style="float: right;" class="btn btn-danger" value="설문마감"></a>
		
		</sec:authorize>
		</c:when>
		</c:choose>	
		
		<input type="button" style="float: right;" class="btn btn-danger" value="목록"
			onclick="location.href='/gw/companySurveyList';">
			
		
		</div>
	


</body>
</html>