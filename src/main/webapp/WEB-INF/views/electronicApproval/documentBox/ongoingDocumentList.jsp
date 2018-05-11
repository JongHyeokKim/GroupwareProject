<%--==============================================================
 * 진행 중 문서함
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<script>
  $(function () {
    $("#example1").DataTable();
  });
  $(function () {
    $("#example2").DataTable();
  });
  
</script>
<style type="text/css">
	.hoverEvent:hover td{
			background-color: #B2EBF4 !important;
	}
	#example1_filter{
		display : none !important;
	}
	#example1_info{
		display : none !important;
	}
	#example2_filter{
		display : none !important;
	}
	#example2_info{
		display : none !important;
	}
		.center{
	text-align: center;
	}
</style>
	<div class="box-header">
					<h3 class="box-title"><strong>진행중인 문서함</strong></h3>
	<br/>
 	<div class="box box-info"></div>
					</div>
					<div style="margin-left: 75px; width: 1245px;">
		<!-- /.box-header -->
		<div class="box-body" style="width: 40%; display: inline-block; float: left; ">
			<table id="example1" class="table table-bordered table-striped">
				<thead>
					<tr>
						<th class="center" style="width: 15%">글 번호</th>
						<th class="center" style="width: 25%">글 제목</th>
						<th class="center" style="width: 25%">글 내용</th>
						<th class="center" style="width: 20%">등록일</th>
						<th class="center" style="width: 15%">상태</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${getDocumentList}" var="onGoingList">
					<tr class="hoverEvent" onclick="window.open('/gw/detailOngoingDocument?docNum=${onGoingList.sig_doc_num}&classiNum=${onGoingList.sig_doc_classi}','','width=735,height=825,top=50,left=480');">
						<td class="center">${onGoingList.sig_doc_num}</td>
						<c:if test="${fn:length(onGoingList.sig_doc_tt)>7}">
							<td><c:out value="${fn:substring(onGoingList.sig_doc_tt,0,7) }" />...</td>
						</c:if>
						<c:if test="${fn:length(onGoingList.sig_doc_tt)<=7}">
							<td><c:out value="${onGoingList.sig_doc_tt}" /></td>
						</c:if>

						<c:if test="${fn:length(onGoingList.sig_doc_cont)>7}">
							<td><c:out value="${fn:substring(onGoingList.sig_doc_cont,0,7) }" />...</td>
						</c:if>
						<c:if test="${fn:length(onGoingList.sig_doc_cont)<=7}">
							<td><c:out value="${onGoingList.sig_doc_cont}" /></td>
						</c:if>

						<td class="center">${onGoingList.sig_doc_day}</td>
						<td class="center">${onGoingList.sig_st_nm}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			
		</div>
		<div class="box-body" style="width: 40%; display: inline-block;margin-left: 40px;">
			<table id="example2" class="table table-bordered table-striped">
				<thead>
					<tr>
						<tr>
						<th class="center" style="width: 15%">글 번호</th>
						<th class="center" style="width: 25%">글 제목</th>
						<th class="center" style="width: 25%">글 내용</th>
						<th class="center" style="width: 20%">등록일</th>
						<th class="center" style="width: 15%">상태</th>
					</tr>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${getDocumentListWait}" var="onGoingList">
					<tr class="hoverEvent" onclick="window.open('/gw/detailOngoingDocument?docNum=${onGoingList.sig_doc_num}&classiNum=${onGoingList.sig_doc_classi}','','width=500,height=800,top=300,left=400');">
					
						<td class="center">${onGoingList.sig_doc_num}</td>
						<c:if test="${fn:length(onGoingList.sig_doc_tt)>7}">
							<td><c:out value="${fn:substring(onGoingList.sig_doc_tt,0,7) }" />...</td>
						</c:if>
						<c:if test="${fn:length(onGoingList.sig_doc_tt)<=7}">
							<td><c:out value="${onGoingList.sig_doc_tt}" /></td>
						</c:if>
						<c:if test="${fn:length(onGoingList.sig_doc_cont)>7}">
							<td><c:out value="${fn:substring(onGoingList.sig_doc_cont,0,7) }" />...</td>
						</c:if>
						<c:if test="${fn:length(onGoingList.sig_doc_cont)<=7}">
							<td><c:out value="${onGoingList.sig_doc_cont}" /></td>
						</c:if>
						<td class="center">${onGoingList.sig_doc_day}</td>
						<td class="center">${onGoingList.sig_st_nm}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			
		</div>
		</div>
		<!-- /.box-body -->
	



</body>
</html>