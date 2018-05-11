<%--==============================================================
 * 전체 문서 메인리스트
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
<script type="text/javascript">
	function transUpMethod(data){
		location.href="transDocumentWriteRepeat?transDocNum="+data;
	}
</script>
<style type="text/css">
    .hoverEvent:hover td{
			background-color: #B2EBF4 !important;
	}
	.center{
	text-align:center;
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
							<tr>
								<th class="center">글 제목</th>
								<th class="center">글 내용</th>
								<th class="center">등록일</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="doneLoop" value="false" />

							<c:forEach items="${getDocumentList1}" var="allList"
								varStatus="counting">
								<c:if test="${not doneLoop}">
									<c:if test="${allList.sig_doc_sig_st_num==1}">
										<tr class="hoverEvent" onclick="window.open('/gw/detailTransientStorage?docNum=${allList.sig_doc_num}&classiNum=${allList.sig_doc_classi}','','width=735,height=825,top=50,left=480');">
											<td class="center"><b>${allList.sig_doc_tt}</b></td>
											
											<c:if test="${fn:length(allList.sig_doc_cont)>7}">
												<td class="center"><c:out value="${fn:substring(allList.sig_doc_cont,0,7) }" />...</td>
											</c:if>
											<c:if test="${fn:length(allList.sig_doc_cont)<=7}">
												<td class="center"><c:out value="${allList.sig_doc_cont}" /></td>
											</c:if>
											
											<td class="center">${allList.sig_doc_day}</td>
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
			<div class="box box-default ">
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
								<th class="center">글 제목</th>
								<th class="center">글 내용</th>
								<th class="center">등록일</th>
								<th class="center">상태</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="doneLoop" value="false" />

							<c:forEach items="${getDocumentListWait}" var="allList"
								varStatus="counting">
								<c:if test="${not doneLoop}">
									<c:if test="${allList.sig_doc_sig_st_num==5}">
										<tr class="hoverEvent" onclick="window.open('/gw/detailOngoingDocument?docNum=${allList.sig_doc_num}&classiNum=${allList.sig_doc_classi}','','width=735,height=825,top=50,left=480');">
											<td class="center"><b>${allList.sig_doc_tt}</b></td>

											<c:if test="${fn:length(allList.sig_doc_cont)>7}">
												<td class="center"><c:out value="${fn:substring(allList.sig_doc_cont,0,7) }" />...</td>
											</c:if>
											<c:if test="${fn:length(allList.sig_doc_cont)<=7}">
												<td class="center"><c:out value="${allList.sig_doc_cont}" /></td>
											</c:if>

											<td class="center">${allList.sig_doc_day}</td>
											<td class="center">${allList.sig_st_nm}</td>
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
										<tr class="hoverEvent" onclick="window.open('/gw/detailOngoingDocument?docNum=${allList.sig_doc_num}&classiNum=${allList.sig_doc_classi}','','width=735,height=825,top=50,left=480');">
											<td class="center"><b>${allList.sig_doc_tt}</b></td>

											<c:if test="${fn:length(allList.sig_doc_cont)>7}">
												<td class="center"><c:out value="${fn:substring(allList.sig_doc_cont,0,7) }" />...</td>
											</c:if>
											<c:if test="${fn:length(allList.sig_doc_cont)<=7}">
												<td class="center"><c:out value="${allList.sig_doc_cont}" /></td>
											</c:if>

											<td class="center">${allList.sig_doc_day}</td>
											<td class="center">${allList.sig_st_nm}</td>
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


		<div class="col-md-3" style="width: 36%;">
			<div class="box box-default ">
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
								<th class="center">글 제목</th>
								<th class="center">글 내용</th>
								<th class="center">등록일</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="doneLoop" value="false" />

							<c:forEach items="${getDocumentList3}" var="allList"
								varStatus="counting">
								<c:if test="${not doneLoop}">
									<c:if test="${allList.sig_doc_sig_st_num==3}">
										<tr class="hoverEvent" onclick="window.open('/gw/detailFinalizationDocument?docNum=${allList.sig_doc_num}&classiNum=${allList.sig_doc_classi}','','width=735,height=825,top=50,left=480')">
											<td class="center"><b>${allList.sig_doc_tt}</b></td>

											<c:if test="${fn:length(allList.sig_doc_cont)>7}">
												<td class="center"><c:out value="${fn:substring(allList.sig_doc_cont,0,7) }" />...</td>
											</c:if>
											<c:if test="${fn:length(allList.sig_doc_cont)<=7}">
												<td class="center"><c:out value="${allList.sig_doc_cont}" /></td>
											</c:if>

											<td class="center">${allList.sig_doc_day}</td>
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
						<a onclick="location.href='/gw/returnDocumentList';"><b>반려문서함</b></a>
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
								<th class="center">글 제목</th>
								<th class="center">글 내용</th>
								<th class="center">등록일</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="doneLoop" value="false" />

							<c:forEach items="${getDocumentList4}" var="allList"
								varStatus="counting">
								<c:if test="${not doneLoop}">
									<c:if test="${allList.sig_doc_sig_st_num==4}">
										<tr class="hoverEvent" onclick="window.open('/gw/detailReturnDocument?docNum=${allList.sig_doc_num}&classiNum=${allList.sig_doc_classi}','','width=735,height=825,top=50,left=480')">
											<td class="center"><b>${allList.sig_doc_tt}</b></td>

											<c:if test="${fn:length(allList.sig_doc_cont)>7}">
												<td class="center"><c:out value="${fn:substring(allList.sig_doc_cont,0,7) }" />...</td>
											</c:if>
											<c:if test="${fn:length(allList.sig_doc_cont)<=7}">
												<td class="center"><c:out value="${allList.sig_doc_cont}" /></td>
											</c:if>

											<td class="center">${allList.sig_doc_day}</td>
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


		<div class="col-md-3" style="width: 50%;">
			<div class="box box-default ">
				<div class="box-header with-border">
					<h3 class="box-title">
						<a onclick="location.href='/gw/documentApprovalList';"><b>결재할 문서함</b></a>
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
								<th class="center">글 제목</th>
								<th class="center">글 내용</th>
								<th class="center">등록일</th>
								<th class="center">상태</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="doneLoop" value="false" />

							<c:forEach items="${getApprovalDocList}" var="allList"
								varStatus="counting">
								<c:if test="${not doneLoop}">
									<c:if test="${allList.sig_doc_sig_st_num==5||allList.sig_doc_sig_st_num==2}">
											<tr class="hoverEvent" onclick="window.open('/gw/detailDocumentApproval?docNum=${allList.sig_doc_num}&classiNum=${allList.sig_doc_classi}&checking=1','','width=735,height=825,top=50,left=480')">
												<td class="center"><b>${allList.sig_doc_tt}</b></td>
					
													<c:if test="${fn:length(allList.sig_doc_cont)>7}">
														<td class="center"><c:out value="${fn:substring(allList.sig_doc_cont,0,7) }" />...</td>
								        			</c:if>
								        			<c:if test="${fn:length(allList.sig_doc_cont)<=7}">
														<td class="center"><c:out value="${allList.sig_doc_cont}" /></td>
													</c:if>
												
												<td class="center">${allList.sig_doc_day}</td>
												<td class="center">${allList.sig_st_nm}</td>
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


</body>
</html>