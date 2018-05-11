<%--==============================================================
 * 파일 관리 리스트
 * @author 김준학
 * @since  2016.08.29.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.08.29.   김준학      최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
===============================================================--%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<script>
  $(function () {
	  $("#example1").DataTable({
		    "bSort" : false
		});
  });
</script>
<style type="text/css">
	#example1_filter{
		display : none !important;
	}
	.hoverEvent:hover td{
         background-color: #B2EBF4 !important;
   }
	#example1_info{
		display : none !important;
	}
	.center{
		text-align: center;
	}
</style>
<script type="text/javascript">
		//검색 할때 쓰이는거
		function search(form) {
			form.action = "fileSearch";
			form.method = "get";
			form.target = "_self";
			form.submit();
		}
	</script>
	
	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-xs-12">

				
					<div class="box-header">
					<h3 class="box-title"><strong>파일함</strong></h3>
	<br/>
 	<div class="box box-info"></div>
					</div>
					<br />
				<div style="margin-left:30px; width: 1200px;">
					<!-- /.box-header -->
					<div class="box-tools" style="margin-right: 10px; float: right;">

						<form>
							<div style="float: left;">
								<select class="form-control2" name="searchKey2">
									<option value="제목" selected="selected">제목</option>
									<option value="작성자">작성자</option>
								</select>
							</div>

							<div class="input-group input-group-sm" style="width: 200px;">
								<input type="text" name="searchKeyword"
									class="form-control pull-right" placeholder="search">

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
									<th class="center">번호</th>
									<th class="center">제목</th>
									<th class="center">파일</th>
									<th class="center">작성자</th>
									<th class="center">작성일</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${groupFileList}" var="file">
									<tr class="hoverEvent" onclick="javascript:location.href='groupFileInformation?doc_code=${file.doc_code}'">
										<td class="center">${file.doc_code}</td>
										<td class="center">${file.doc_nm}</td>
										<td class="center"><a href="groupFileDownload?doc_code=${file.doc_code}">${file.doc_file} &nbsp <i class="fa fa-fw fa-download"></i></i></a></td>
										<td class="center">${file.mem_nm}</td>
										<td class="center">${file.doc_date}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div style="float: right;">
							<a href="groupFileWrite"> <input type="button"
								class="btn btn-danger" value="등록"></a>
						</div>
					</div>
					<!-- /.box-body -->
				
				<!-- /.box -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
		</div>
	</section>


</body>
</html>