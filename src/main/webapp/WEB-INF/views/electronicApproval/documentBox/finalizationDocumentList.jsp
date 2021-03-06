<%--==============================================================
 * 결재 완료된 문서함
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
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	.center{
	text-align: center;
	}
</style>


<div class="box-header">
					<h3 class="box-title"><strong>최종승인문서함</strong></h3>
	<br/>
 	<div class="box box-info"></div>
					</div>
					<div style="margin-left: 80px; width: 1200px;">
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example1" class="table table-bordered table-striped" style="width:90%">
                <thead>
					<tr>
						<th class="center">글 번호</th>
						<th class="center">글 제목</th>
						<th class="center">글 내용</th>
						<th class="center">등록일</th>
						<th class="center">상태</th>
					</tr>
				</thead>
                <tbody>
                <c:forEach items="${getDocumentList}" var="finalList">
					<tr class="hoverEvent" onclick="window.open('/gw/detailFinalizationDocument?docNum=${finalList.sig_doc_num}&classiNum=${finalList.sig_doc_classi}','','width=735,height=825,top=50,left=480')">
						<td class="center">${finalList.sig_doc_num}</td>
						<td><b><a style="color: black;">${finalList.sig_doc_tt}</a></b></td>

						<c:if test="${fn:length(finalList.sig_doc_cont)>7}">
							<td><c:out value="${fn:substring(finalList.sig_doc_cont,0,7) }" />...</td>
						</c:if>
						<c:if test="${fn:length(finalList.sig_doc_cont)<=7}">
							<td><c:out value="${finalList.sig_doc_cont}" /></td>
						</c:if>

						<td class="center">${finalList.sig_doc_day}</td>
						<td class="center">${finalList.sig_st_nm}</td>
					</tr>
				</c:forEach>
              </tbody>
              </table>
            </div>
            </div>
            <!-- /.box-body -->

	
</body>
</html>