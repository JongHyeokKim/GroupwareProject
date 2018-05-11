<%--==============================================================
 * 승인한 문서함
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
					<h3 class="box-title"><strong>결재 승인 문서함</strong></h3>
	<br/>
 	<div class="box box-info"></div>
					</div>
            <!-- /.box-header -->
            <div style="margin-left: 80px; width: 1200px;">
            <div class="box-body">
              <table id="example1" class="table table-bordered table-striped" style="width:90%">
               <thead>
					<tr>
						<th class="center">글 번호</th>
						<th  class="center">글 제목</th>
						<th  class="center">글 내용</th>
						<th  class="center">등록일</th>
						<th class="center">상태</th>
					</tr>
				</thead>
                <tbody>
                <c:forEach items="${getMyApprovalDocumentList}" var="approvalList">
					<tr class="hoverEvent" onclick="window.open('/gw/detailDocumentApproval?docNum=${approvalList.sig_doc_num}&classiNum=${approvalList.sig_doc_classi}&checking=','','width=735,height=825,top=50,left=480');">
						<td  class="center">${approvalList.sig_doc_num}</td>
						<td>${approvalList.sig_doc_tt}</td>
						<td>${approvalList.sig_doc_cont}</td>
						<td  class="center">${approvalList.sig_doc_day}</td>
						<td  class="center">${approvalList.sig_st_nm}</td>
					</tr>
				</c:forEach>
              </tbody>
              </table>
            </div>
            </div>
            <!-- /.box-body -->

</body>
</html>