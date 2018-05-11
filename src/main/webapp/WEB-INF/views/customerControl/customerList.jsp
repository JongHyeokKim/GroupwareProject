<%--==============================================================
 * 거래처 관리 리스트 출력 및 등록,엑셀출력
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

<div style="overflow: hidden;">
				<div class="box-header">
					<h3 class="box-title"><strong>거래처 관리</strong></h3>
	<br/>
 	<div class="box box-info"></div>
					</div>
					<br />
					<div style="margin-left:30px; width: 1200px;">
					<div style="margin-right: 10px; float: right; ">
						<form>
							<div style="float: left;">
								<select class="form-control2" name="searchKey2">
									<option value="담당사원" selected="selected">담당사원</option>
									<option value="업체명">업체명</option>
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
						<br />
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<table id="example1" class="table table-bordered table-striped">
							<thead>
								<tr class="hoverEvent" style="font-size: 17px;">
									<th style="width: 50; text-align: center;" >업체명</th>
									<th style="width: 10%; text-align: center;">담당사원명</th>
									<th style="width: 20%; text-align: center;">전화번호</th>
									<th style="width: 30%; text-align: center;">이메일</th>
								</tr>
							</thead>
							

								<c:forEach items="${accountList}" var="account">
									<tr class="hoverEvent" onclick="javascript:location.href='customerInformation?ac_code=${account.ac_code}'">
										<td style="text-align: center;">${account.ac_nm}</td>
										<td style="text-align: center;">${account.mem_nm}</td>
										<td style="text-align: center;">${account.ac_tel}</td>
										<td style="text-align: center;">${account.ac_em}</td>
									</tr>
								</c:forEach>
							
						</table>
						</div>
					<div style="float: right;">
						<a href="javascript:location.href='customerListExcel'">
						 <input	type="button" class="btn btn-danger" value="출력">
						 </a>
						  <a href="customerWrite"> <input type="button"	class="btn btn-danger" value="업체등록"></a>
					</div>
					</div>
					</div>
	<script type="text/javascript" src="resources/assets/js/customer/customer.js"></script>

</body>
</html>