<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <!DOCTYPE html>
<html>
<head>
      <meta charset="utf-8" />
      
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
   
    <title>Grand Destiny GroupWare</title>
   
</head>
<body> -->
<script type="text/javascript">
   function attendanceCheckIn() {
      $.ajax({
        type : "get",
        url : "attendanceCheckIn",
        success : function(data){
           if(data=="1"){
        	   swal("출근 체크 완료!", "정상적으로 출근 처리되었습니다.", "success");
           }else if(data=="2"){
        	   swal("출근 체크 실패!", "오늘은 이미 출근 체크했습니다.", "error");
           }else{
        	   swal("통신 에러!", "출근 체크 과정에 에러가 발생했습니다.", "error");
           }
        },
        error : function(){
        	swal("통신 에러!", "출근 체크 과정에 에러가 발생했습니다.", "error");
        }
      });
   }
   
   function attendanceCheckOut() {
         $.ajax({
           type : "get",
           url : "attendanceCheckOut",
           success : function(data){
              if(data=="1"){
            	  swal("퇴근 체크 완료!", "정상적으로 퇴근 처리되었습니다.", "success");
               }else if(data=="0"){
            	   swal("퇴근 체크 실패!", "퇴근은 출근 기록이 존재할 때만 가능합니다.", "error");
               }else{
            	  swal("통신 에러!", "출근 체크 과정에 에러가 발생했습니다.", "error");
               }
           },
           error : function(){
        	   swal("통신 에러!", "출근 체크 과정에 에러가 발생했습니다.", "error");
           }
         });
      }

</script>
<style type="text/css">
/* The alert message box */
.alert {
    padding: 20px;
    background-color: #f44336; /* Red */
    color: white;
    margin-bottom: 15px;
}

/* The close button */
.closebtn {
    margin-left: 15px;
    color: white;
    font-weight: bold;
    float: right;
    font-size: 22px;
    line-height: 20px;
    cursor: pointer;
    transition: 0.3s;
}

/* When moving the mouse over the close button */
.closebtn:hover {
    color: black;
}
</style>
<nav class="navbar-default navbar-side" role="navigation" style="width: 240px;">
   <div class="sidebar-collapse">
      <ul class="nav" id="main-menu">
         <li class="text-center" style="border-bottom: none;">
         <li class="sideBarText" style="display: inline-block; margin-top: 22px;">
         <img style="width:75px; height:100px; margin-left: 10px; float: left;" id="photo" src="resources/memberManagementImage/${loginUser.mem_img}" />
         	<div style="float: left;">
         	<strong style="color: #999; margin-left: 10px;">이름&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;: ${loginUser.mem_nm }</strong> <br /> <strong
            	style="color: #999; margin-left: 10px;">직급&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;: ${loginUser.pos_nm}</strong> <br /> <strong style="color: #999; margin-left: 10px;"> 부서명&nbsp;&nbsp; : ${loginUser.dep_nm} </strong> <br /> <br />
         	</div> 
         	<div style="text-align: center;">
             <input id="checkInBtn" type="button" class="btn btn-danger" value="출근" onclick="attendanceCheckIn();" style="margin-right: 10px; margin-bottom: 15px;"  />
             <input id="checkOutBtn" type="button" class="btn btn-danger" value="퇴근 " onclick="attendanceCheckOut();" style="margin-bottom: 15px;"/>
             </div>
         </li>

         <li class="sideBarText"><a href="/gw/personalInformation"><i class="fa fa-laptop fa-3x"></i>마이페이지<span class="fa arrow"></span></a>

            <ul class="nav nav-second-level">
               <li><a href="/gw/personalInformation">개인정보수정</a></li>
             <!--   <li><a href="/gw/severancePay">퇴직금조회</a></li> -->
               <li><a href="/gw/certificate">증명서출력</a></li>
               <li><a href="/gw/diligenceCheck">근태정보조회</a></li>
            </ul>
         </li>
         
		<li class="sideBarText"><a href="/gw/snsForm"><i class="fa fa-desktop fa-3x"></i>SNS</a></li>

         <li class="sideBarText"><a href="/gw/documentMain"><i class="fa fa-sitemap fa-3x"></i> 전자결재<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
               <li><a href="/gw/draftDocumentWriteForm">기안문서</a></li>
               <li><a href="#">문서함<span class="fa arrow"></span></a>
                  <ul class="nav nav-third-level">
                     <li><a href="/gw/documentMain">전체 문서함</a></li>
                     <li><a href="/gw/transientStorageList">임시보관 문서</a></li>
                     <li><a href="/gw/ongoingDocumentList">진행중인 문서</a></li>
                     <li><a href="/gw/finalizationDocumentList">최종승인 문서</a></li>
                     <li><a href="#">반려 문서<span class="fa arrow"></span></a>
                        <ul class="nav nav-four-level">
                           <li><a href="/gw/returnMydocumentList">반려한 문서</a></li>
                           <li><a href="/gw/returnDocumentList">반려된 문서</a></li>
                        </ul></li>
                     <li><a href="#">결재 문서<span class="fa arrow"></span></a>
                        <ul class="nav nav-four-level">
                           <li><a href="/gw/approvalMyDocumentList">결재 승인 문서</a></li>
                           <li><a href="/gw/documentApprovalList">결재 대기 문서</a></li>
                        </ul></li>

                  </ul></li>
            </ul></li>

         <li class="sideBarText"><a href="/gw/workSchedule"><i class="fa fa-dashboard fa-3x"></i>&nbsp;프로젝트<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
               <li><a href="/gw/workSchedule">전체일정</a></li>
               <li><a href="/gw/employeeSchedule">개인업무일정</a></li>
               <li><a href="/gw/projectSchedule?">프로젝트관리</a></li>
            </ul></li>


         <li class="sideBarText"><a href="/gw/customerList"><i class="fa fa-desktop fa-3x"></i>거래처관리</a></li>


         <li class="sideBarText"><a href="/gw/noticeList"><i class="fa fa-qrcode fa-3x"></i>&nbsp;&nbsp;&nbsp;게 시 판<span class="fa arrow"></span></a>
            <ul class="nav nav-second-level">
               <li><a href="/gw/noticeList">공지사항</a></li>
               <li><a href="/gw/workNewsList">사내소식</a></li>
               <li><a href="/gw/welfareInformation">사내복지</a></li>
            </ul></li>

         <li class="sideBarText"><a href="/gw/companySurveyList"><i class="fa fa-bar-chart-o fa-3x"></i>커뮤니티<span class="fa arrow"></span></a>

            <ul class="nav nav-second-level">
               <li><a href="/gw/companySurveyList">설문조사</a></li>
               <li><a href="/gw/companyProposalList">제안서</a></li>
               <li><a href="/gw/groupFileList">파일관리</a></li>
            </ul></li>
         <li class="sideBarText"><a href="/gw/companyFacilityList"><i class="fa fa-table fa-3x"></i>시설예약</a></li>
         <c:if test="${memberVO.mem_authority=='ROLE_ADMIN'}">
            <li class="sideBarText" style="border-bottom: none;"><a href="/gw/adminDepartment"><i class="fa fa-edit fa-3x"></i>관리자<span class="fa arrow"></span></a>
               <ul class="nav nav-second-level">
                  <li><a href="memberManagementList">사원관리</a></li>
                  <li><a href="/gw/attendanceList">근태관리</a></li>
               </ul></li>
         </c:if>
      </ul>
   </div>
</nav>
<!-- </body>
</html> -->