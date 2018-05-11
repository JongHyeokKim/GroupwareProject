<%--==============================================================
 * 파일관리 상세보기
 * @author 김준학
 * @since  2016.08.31.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.08.31.   김준학      최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
===============================================================--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

				<section class="content">
					<div class="row">
						<div class="col-xs-12">
							 
								<div class="box-header">
								<h3 class="box-title"><strong>파일함</strong></h3>
								<br/>
 								<div class="box box-info"></div>
								</div>
								<!-- /.box-header -->
								<div class="box-body">
									<table id="example2" class="table table-bordered table-striped" style="width: 1200px; margin-left: 20px;">
										<thead>
											<tr style="text-align: center;">
												<th style="text-align: center;">등록일</th>
												<td>${groupFileInfo.doc_date}</td>
												<th style="text-align: center;">작성자</th>
												<td>${groupFileInfo.mem_nm}</td>
											</tr>
										</thead>
										<tbody>
										
											<tr style="text-align: center;">
												<th style="text-align: center;">제목</th>
												<td>${groupFileInfo.doc_nm}</td>
												<th style="text-align: center;">파일 내려받기</th>
												<td><a href="groupFileDownload?doc_code=${groupFileInfo.doc_code}">${groupFileInfo.doc_file} &nbsp<i class="fa fa-fw fa-download"></i></a></td>
											</tr>
											<tr>
												<td colspan="4" style="height:400px; vertical-align: text-top;">${groupFileInfo.doc_cont}</td>
											</tr>
										</tbody>
									</table>
									<br/>
								</div>
								<!-- /.box-body -->
							<div style="float: right; margin-right: 65px;">
								<sec:authorize access="hasAnyRole('ROLE_ADMIN,ROLE_LEADER')">
									<a href="groupFileUpdate?doc_code=${groupFileInfo.doc_code}">
											<input type="button" class="btn btn-danger" value="수정">
										</a>
										<a href="gropuFileDelete?doc_code=${groupFileInfo.doc_code}">
											<input type="button" class="btn btn-danger" value="삭제">
										</a>
										</sec:authorize>
										<c:set value='${loginUser.mem_authority}' var="auto"/>
									<c:if test="${loginUser.mem_num==groupFileInfo.doc_mem_num&& auto=='ROLE_USER'}">
										<a href="groupFileUpdate?doc_code=${groupFileInfo.doc_code}">
											<input type="button" class="btn btn-danger" value="수정">
										</a>
										<a href="gropuFileDelete?doc_code=${groupFileInfo.doc_code}">
											<input type="button" class="btn btn-danger" value="삭제">
										</a>
									</c:if>
								
								<a href=groupFileList><input type="button"
									class="btn btn-danger" value="목록"></a>
							</div>
						</div>
					</div>
				</section>
			

	<!-- /.box -->
          
</body>
</html>

