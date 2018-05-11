<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page trimDirectiveWhitespaces="true" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%--==============================================================
 * 제안리스트 
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

<style type="text/css">
#example1_filter {
	display: none !important;
}

#example1_info {
	display: none !important;
}
.hoverEvent:hover td{
         background-color: #B2EBF4 !important;
   }
</style>
<script src="resources/assets/js/companyProposal/companyProposal.js"></script>
	<section class="content">
		<div class="row">
			<div class="col-xs-12">
	
		<div class="box-header">
   <h3 class="box-title"><strong>제안서</strong></h3>
	<br/>
 	<div class="box box-info"></div>
		</div>
		<div style="margin-left:30px; width: 1200px;">
		<div class="box-tools" style="float: right;">
<form>
				<div class="input-group input-group-sm" style="width: 200px;">
					<input type="text" name="key"
						class="form-control pull-right" placeholder="search">

					<div class="input-group-btn">
						<button class="btn btn-default" onclick="search(this.form);">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
			</form>
			<br />
		</div>

		<!-- /.box-header -->
		<div class="box-body">
			<table id="example1" class="table table-bordered table-striped" >
				<thead>
					<tr class="hoverEvent" style="font-size: 17px;">
						<th style="width: 8%; text-align: center;">글번호</th>
						<th style="width: 58%; text-align: center;">제목</th>
						<th style="width: 10%; text-align: center;">처리현황</th>
						<th style="width: 10%; text-align: center;">작성자</th>
						<th style="width: 10%; text-align: center;">작성일</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${companyProposalList}" var="companyProposalList">
						<tr class="hoverEvent">
							<td style="text-align: center;">${companyProposalList.prop_code}</td>
							<td><a
								href="companyProposalInformation?prop_code=${companyProposalList.prop_code}">${companyProposalList.prop_tt}</a></td>
							<td style="text-align: center;">
								<c:choose>
									<c:when test="${companyProposalList.prop_st=='1' }">처리중</c:when>
									<c:when test="${companyProposalList.prop_st=='2' }">처리완료</c:when>
									<c:when test="${companyProposalList.prop_st=='3' }">반려</c:when>
								</c:choose>
							</td>
							<td style="text-align: center;">${companyProposalList.mem_nm}</td>
							<td style="text-align: center;">${companyProposalList.prop_day}</td>
						</tr>
					</c:forEach>
			</table>
		<div style="float: right;">
<input type="button" class="btn btn-danger" value="제안등록"  onclick="location.href='/gw/companyProposalWrite';">
        </div>
		</div>
		</div>
		</div>
		</div>
		</section>
		<!-- /.box-body -->

</body>
</html>
