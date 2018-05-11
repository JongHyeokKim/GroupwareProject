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
<script type="text/javascript">
	function transUpMethod(data){
		  location.href="transDocumentWriteRepeat?transDocNum="+data;
	}
</script>
<style type="text/css">
        .hoverEvent:hover td{
			background-color: #B2EBF4 !important;
	}
</style>
<%int countWrite=0; %>
	<div style="height: 350px; width: 100%; margin-top: 20px;">
		<div class="col-md-3 sizetest" style="width: 30%;">
			<div class="box box-default">
				<div class="box-header with-border">
					<h3 class="box-title">
						<a onclick="location.href='/gw/transientStorageList';"><b>임시문서함</b></a>
					</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
					</div>
					<!-- /.box-tools -->
				</div>
				<!-- /.box-header -->
			<div class="box-body" style="padding-left: 0px;">
					<table id="example1" class="table table-bordered table-striped">
						<thead>
							<tr >
								<th style="text-align: center">글 제목</th>
								<th style="text-align: center">글 내용</th>
								<th style="text-align: center">상태</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="doneLoop" value="false" />

							<c:forEach items="${getDocumentList1}" var="allList"
								varStatus="counting">
								<c:if test="${not doneLoop}">
									<c:if test="${allList.sig_doc_sig_st_num==1}">
										<tr class="hoverEvent" onclick="window.open('/gw/detailTransientStorage?docNum=${allList.sig_doc_num}&classiNum=${allList.sig_doc_classi}','','width=735,height=825,top=50,left=480');">
											<td style="text-align: center"><b>${allList.sig_doc_tt}</b></td>
											<c:if test="${fn:length(allList.sig_doc_cont)>7}">
												<td><c:out value="${fn:substring(allList.sig_doc_cont,0,7) }" />...</td>
											</c:if>
											<c:if test="${fn:length(allList.sig_doc_cont)<=7}">
												<td style="text-align: center"><c:out value="${allList.sig_doc_cont}" /></td>
											</c:if>
											<td style="text-align: center">${allList.sig_st_nm}</td>
										</tr>

										<%
											countWrite++;
										%>
										<%
											if (countWrite == 5) {
										%>
										<c:set var="doneLoop" value="true" />
										<%
											}
										%>
									</c:if>
								</c:if>
							</c:forEach>
								<%
										countWrite=0;
								 %>
						</tbody>
					</table>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>


		<div class="col-md-3" style="width: 33%;">
			<div class="box box-default">
				<div class="box-header with-border">
					<h3 class="box-title">
						<a onclick="location.href='/gw/ongoingDocumentList';"><b>진행중인문서함</b></a>
					</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
					</div>
					<!-- /.box-tools -->
				</div>
				<!-- /.box-header -->
			<div class="box-body" style="padding-left: 0px;">
					<table id="example1" class="table table-bordered table-striped">
						<thead>
							<tr>
								<th style="text-align: center">글 제목</th>
								<th style="text-align: center">글 내용</th>
								<th style="text-align: center">상태</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="doneLoop" value="false" />

							<c:forEach items="${getDocumentListWait}" var="allList"
								varStatus="counting">
								<c:if test="${not doneLoop}">
									<c:if test="${allList.sig_doc_sig_st_num==5}">
										<tr class="hoverEvent"  onclick="window.open('/gw/detailOngoingDocument?docNum=${allList.sig_doc_num}&classiNum=${allList.sig_doc_classi}','','width=735,height=825,top=50,left=480');">
											<td style="text-align: center"><b>${allList.sig_doc_tt}</b></td>

											<c:if test="${fn:length(allList.sig_doc_cont)>7}">
												<td style="text-align: center"><c:out value="${fn:substring(allList.sig_doc_cont,0,7) }" />...</td>
											</c:if>
											<c:if test="${fn:length(allList.sig_doc_cont)<=7}">
												<td style="text-align: center"><c:out value="${allList.sig_doc_cont}" /></td>
											</c:if>
											<td style="text-align: center">${allList.sig_st_nm}</td>
										</tr>

										<%
											countWrite++;
										%>
										<%
											if (countWrite == 5) {
										%>
										<c:set var="doneLoop" value="true" />
										<%
											}
										%>
									</c:if>
								</c:if>
							</c:forEach>
							<c:forEach items="${getDocumentList2}" var="allList"
								varStatus="counting">
								<c:if test="${not doneLoop}">
									<c:if test="${allList.sig_doc_sig_st_num==2}">
										<tr class="hoverEvent">
											<td style="text-align: center"><b><a onclick="window.open('/gw/detailOngoingDocument?docNum=${allList.sig_doc_num}&classiNum=${allList.sig_doc_classi}','','width=735,height=825,top=50,left=480');">${allList.sig_doc_tt}</a></b></td>

											<c:if test="${fn:length(allList.sig_doc_cont)>7}">
												<td style="text-align: center"><c:out value="${fn:substring(allList.sig_doc_cont,0,7) }" />...</td>
											</c:if>
											<c:if test="${fn:length(allList.sig_doc_cont)<=7}">
												<td style="text-align: center"><c:out value="${allList.sig_doc_cont}" /></td>
											</c:if>
											<td style="text-align: center">${allList.sig_st_nm}</td>
										</tr>

										<%
											countWrite++;
										%>
										<%
											if (countWrite == 5) {
										%>
										<c:set var="doneLoop" value="true" />
										<%
											}
										%>
									</c:if>
								</c:if>
							</c:forEach>
						</tbody>
							<%
								countWrite=0;
							%>
					</table>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>


		<div class="col-md-3" style="width: 36%;">
		
			<div class="box box-default">
				<div class="box-header with-border">
					<h3 class="box-title">
						<a onclick="location.href='/gw/finalizationDocumentList';"><b>최종승인문서함</b></a>
					</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
					</div>
					<!-- /.box-tools -->
				</div>
				<!-- /.box-header -->
				<div class="box-body" style="padding-left: 0px;">
					<table id="example1" class="table table-bordered table-striped">
						<thead>
							<tr>
								<th style="text-align: center">글 제목</th>
								<th style="text-align: center">글 내용</th>
								<th style="text-align: center">상태</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="doneLoop" value="false" />

							<c:forEach items="${getDocumentList3}" var="allList"
								varStatus="counting">
								<c:if test="${not doneLoop}">
									<c:if test="${allList.sig_doc_sig_st_num==3}">
										<tr class="hoverEvent" onclick="window.open('/gw/detailFinalizationDocument?docNum=${allList.sig_doc_num}&classiNum=${allList.sig_doc_classi}','','width=735,height=825,top=50,left=480')">
											<td style="text-align: center"><b>${allList.sig_doc_tt}</b></td>

											<c:if test="${fn:length(allList.sig_doc_cont)>7}">
												<td style="text-align: center"><c:out value="${fn:substring(allList.sig_doc_cont,0,7) }" />...</td>
											</c:if>
											<c:if test="${fn:length(allList.sig_doc_cont)<=7}">
												<td style="text-align: center"><c:out value="${allList.sig_doc_cont}" /></td>
											</c:if>
											<td style="text-align: center">${allList.sig_st_nm}</td>
										</tr>

										<%
											countWrite++;
										%>
										<%
											if (countWrite == 5) {
										%>
										<c:set var="doneLoop" value="true" />
										<%
											}
										%>
									</c:if>
								</c:if>
							</c:forEach>
									<%
											countWrite=0;
									 %>
						</tbody>
					</table>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>
	</div>
	<div style="height: 350px; width: 100%;">
		<div class="col-md-3" style="width: 50%;">
			<div class="box box-default ">
				<div class="box-header with-border">
					<h3 class="box-title">
						<a onclick="location.href='/gw/projectSchedule';"><b>프로젝트 현황</b></a>
					</h3>
					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
					</div>
					<!-- /.box-tools -->
				</div>
				<!-- /.box-header -->
				<div class="box-body" style="padding-left: 0px;">
					<table id="example1" class="table table-bordered table-striped">
						<thead>
							<tr>
								<th style="text-align: center; width:140px; ">프로젝트 명</th>
								<th style="text-align: center; width:119px;">프로젝트 시작일</th>
								<th style="text-align: center; width:119px;">프로젝트 종료일</th>
								<th style="text-align: center; width:180px;">Progress</th>
								<th style="text-align: center; width:60px;">진행률</th>
							</tr>
						</thead>
							<c:forEach var="project" items="${projectList }" >
						<tr class="hoverEvent" onclick="location.href='projectSupervise?pro_code=${project.pro_code}'">
							<c:if test="${fn:length(project.pro_nm)>7}">
												<td style="text-align: center"><b><c:out value="${fn:substring(project.pro_nm,0,7) }" />...</b></td>
											</c:if>
											<c:if test="${fn:length(project.pro_nm)<=7}">
												<td style="text-align: center"><b><c:out value="${project.pro_nm}" /></b></td>
											</c:if>
							<td style="text-align: center">${project.pro_beg_day }</td>
							<td style="text-align: center">${project.pro_end_day }</td>
							<td>
								<div class="${project.progress }">
									<div class="${project.progress2 }"
										style="width: ${project.percent}%"></div>
								</div>
							</td>
							<td><span class="${project.color }" style="margin-left: 10px;">${project.percent}%</span></td>
						</tr>
						</c:forEach>
					</table>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>
		<div class="col-md-3" style="width: 50%;">
			<div class="box box-default ">
				<div class="box-header with-border">
					<h3 class="box-title">
						<a onclick="location.href='/gw/noticeList';"><b>공지사항</b></a>
					</h3>
					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
					</div>
					<!-- /.box-tools -->
				</div>
				<!-- /.box-header -->
				<div class="box-body" style="padding-left: 0px;">
					<table id="example1" class="table table-bordered table-striped">
						<thead>
							<tr>
								<th style="width: 50%; text-align: center;">글 제목</th>
								<th style="text-align: center;">글 내용</th>
								<th style="text-align: center;">등록일</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="doneLoop" value="false" />

							<c:forEach items="${noticeList}" var="noticeList"
								varStatus="counting">
								<c:if test="${not doneLoop}">
										<tr class="hoverEvent"  onclick="location.href='noticeInformation?br_wrt_num=${noticeList.br_wrt_num}'">
										<c:if test="${fn:length(project.pro_nm)>7}">
												<td style="text-align: center">
											<b><c:out value="${fn:substring(noticeList.br_tt,0,7) }" />...</b></td>
											</c:if>
											<c:if test="${fn:length(project.pro_nm)<=7}">
												<td style="text-align: center"><b><c:out value="${noticeList.br_tt}" /></b></td>
											</c:if>
								
											<td style="text-align: center;">${noticeList.mem_nm}</td>
											<td style="text-align: center;">${noticeList.br_writ_day}</td>
										</tr>
										<%
											countWrite++;
										%>
										<%
											if (countWrite == 8) {
										%>
										<c:set var="doneLoop" value="true" />
										<%
											}
										%>
								</c:if>
							</c:forEach>
								<%
										countWrite=0;
								 %>
						</tbody>
					</table>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>
	</div>
</body>
</html>