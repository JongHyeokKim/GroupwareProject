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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
</head>
<body>
<style type="text/css">
        .hoverEvent:hover td{
			background-color: #B2EBF4 !important;
	}
</style>
						<div class="box-header">
						<h3 class="box-title"><strong>프로젝트 관리</strong></h3>
						<br/>
						<div class="box box-info"></div>
					</div>
			<!-- /.box-header -->
			<div class="box-body">
			<form>
			<div class="input-group input-group-sm" style="width: 200px; margin-left: 1030px;margin-bottom: 20px;">
				<input type="text" name="pro_nm" class="form-control pull-right" placeholder="search">
					<div class="input-group-btn">
						<button class="btn btn-default" onclick="search(this.form);"><i class="fa fa-search"></i></button>
					</div>
			</div>
			</form>
				<table class="table table-bordered table-striped" style="margin-left:30px; width: 1200px;">
						<thead>
						<tr style="font-size: 17px;" class="hoverEvent">
							<th style="width: 200px; text-align: center">프로젝트명</th>
							<th style="width: 250px; text-align: center">프로젝트 메모</th>
							<th style="width: 250px; text-align: center">프로젝트 시작일</th>
							<th style="width: 250px; text-align: center">프로젝트 종료일</th>
							<th style="text-align: center">Progress</th>
							<th style="width: 40px">Label</th>
						</tr>
						</thead>
						<c:forEach var="project" items="${projectList}" >
						<tr class="hoverEvent" onclick="location.href='projectSupervise?pro_code=${project.pro_code}'">
						<c:if test="${fn:length(project.pro_nm)>7}">
							<td style="text-align: center"><c:out value="${fn:substring(project.pro_nm,0,7) }" />...</td>
						</c:if>
						<c:if test="${fn:length(project.pro_nm)<=7}">
							<td style="text-align: center"><c:out value="${project.pro_nm}" /></td>
								</c:if>
								
								<c:if test="${fn:length(project.pro_mm)>14}">
							<td style="text-align: center"><c:out value="${fn:substring(project.pro_mm,0,14) }" />...</td>
						</c:if>
						<c:if test="${fn:length(project.pro_mm)<=14}">
							<td style="text-align: center"><c:out value="${project.pro_mm}" /></td>
								</c:if>
							<td style="text-align: center">${project.pro_beg_day }</td>
							<td style="text-align: center">${project.pro_end_day }</td>
							<td>
								<div class="${project.progress }">
									<div class="${project.progress2 }"
										style="width: ${project.percent}%"></div>
								</div>
							</td>
							<td><span style="margin-left: 10px;" class="${project.color }">${project.percent}%</span></td>
						</tr>
						</c:forEach>
				</table>
			</div>
			<!-- /.box-body -->
			<div class="box-footer clearfix" style="margin-right: 48%;">
				<ul class="pagination pagination-sm no-margin pull-right">
					${paging}
				</ul>
			</div>
		</div>
		<!-- /.box -->
</body>
</html>