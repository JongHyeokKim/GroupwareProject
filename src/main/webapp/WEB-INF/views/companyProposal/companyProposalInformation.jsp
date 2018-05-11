<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--==============================================================
 * 제안 상세정보
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
	<div class="col-md-12">
		<br />
			<div class="box-header">
				<!-- tools box -->
<h3 class="box-title"><strong>제안서</strong></h3>
	<br/>
 	<div class="box box-info"></div>
				<!-- /. tools -->
			</div>
			<form action="companyProposalCheck" method="get">
				<input name="prop_code" type="hidden" value="${companyProposalInformation.prop_code}">
				<table id="example1" class="table table-bordered table-striped">
					<thead>
						<tr>
							<th style="text-align: center;">글번호</th>
							<th style="text-align: center;">${companyProposalInformation.prop_code}</th>
							<th style="text-align: center;">작성자</th>
							<th style="text-align: center;">${companyProposalInformation.mem_nm}</th>
							<th style="text-align: center;">작성일</th>
							<th style="text-align: center;">${companyProposalInformation.prop_day}</th>
						<tr />
						<tr>
							<th style="text-align: center;">제목</th>
							<th colspan="3">${companyProposalInformation.prop_tt}</th>
							<th style="text-align: center;">처리현황</th>
							<th style="text-align: center;">
							<c:choose>
									
									<c:when test="${companyProposalInformation.prop_st=='1' }">
									<label name="companyProposal">진행중&nbsp;&nbsp;</label>
										<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_LEADER')">
										<select name="prop_st">
											<option value="2" selected="selected">처리완료</option>
											<option value="3">반려</option>
										</select>
										</sec:authorize>
									</c:when>
									
									<c:when test="${companyProposalInformation.prop_st=='2' }">
										<label name="companyProposal">처리완료</label>
									</c:when>
									<c:when test="${companyProposalInformation.prop_st=='3'}">
										<label name="companyProposal">반려</label>
									</c:when>
								</c:choose></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="6" style="height: 400px; vertical-align: text-top;">${companyProposalInformation.prop_cont}</td>
						</tr>
					</tbody>
				</table>
				
				<c:choose>
					<c:when test="${companyProposalInformation.prop_st=='1' }">
					<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_LEADER')">
						<input type="submit" class="btn btn-danger" style="float: right;" name="hiddenBtn" value="제안평가">
						</sec:authorize>
						<c:if test="${companyProposalInformation.prop_mem_num==loginUser.mem_num}">
				
				
							<a href="companyProposalUpdate?prop_code=${companyProposalInformation.prop_code}">
						<input type="button" name="hiddenBtn" style="float: right;" class="btn btn-danger" value="수정"></a>
						<a href="companyProposalDelete?prop_code=${companyProposalInformation.prop_code}">
				<input type="button" class="btn btn-danger" style="float: right;" value="삭제"></a>
						</c:if>
					</c:when>
					
				</c:choose>
				
				
				<input type="button" class="btn btn-danger" style="float: right;" value="목록" onclick="location.href='/gw/companyProposalList';">
			</form>
		</div>


</body>
</html>