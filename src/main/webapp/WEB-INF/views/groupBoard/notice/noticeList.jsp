<%--==============================================================
 * 공지사항 리스트
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

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	
	<style type="text/css">

   .hoverEvent:hover td{
         background-color: #B2EBF4 !important;
   }
#example1_filter {
	display: none !important;
}

#example1_info {
	display: none !important;
}
</style>
	<script src="resources/assets/js/groupBoard/notice.js"></script>
	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-xs-12">

				
					<div class="box-header">
						<h3 class="box-title"><strong>공지사항</strong></h3>
						<br/>
						<div class="box box-info"></div>
					</div>
					
					<div style="margin-left:30px; width: 1200px;">
					<!-- /.box-header -->
					<div class="box-tools" style="float: right;">
						<form>
							<div class="input-group input-group-sm" style="width: 200px;">
								<input type="text" name="key" class="form-control pull-right"
									placeholder="search">

								<div class="input-group-btn">
									<button class="btn btn-default" onclick="search(this.form);">
										<i class="fa fa-search"></i>
									</button>
								</div>
							</div>
						</form>
						
					</div>
					
					<!-- /.box-header -->
					<div class="box-body">
						<table id="example1" class="table table-bordered table-striped">
							<thead>
								<tr class="hoverEvent" style="font-size: 17px;">
									<th style="width: 10%; text-align: center;">글번호</th>
									<th style="width: 70%; text-align: center;">제목</th>
									<th style="width: 10%; text-align: center;">작성자</th>
									<th style="width: 10%; text-align: center;">작성일</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${noticeList}" var="noticeList">
									<tr class="hoverEvent">
										<td style="text-align: center;">${noticeList.br_wrt_num}</td>
										<td><a href="noticeInformation?br_wrt_num=${noticeList.br_wrt_num}">${noticeList.br_tt}</a></td>
										<td style="text-align: center;">${noticeList.mem_nm}</td>
										<td style="text-align: center;">${noticeList.br_writ_day}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
						<div>
							<input type="button" style="float: right;" class="btn btn-danger"
								value="공지사항등록" onclick="location.href='/gw/noticeWrite';">
						</div>
						</sec:authorize>
					</div>
					<!-- /.box-body -->
				
				<!-- /.box -->
			</div>
			<!-- /.col -->
		</div>
		</div>
		<!-- /.row -->
	</section>
</body>
</html>

