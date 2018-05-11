<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page trimDirectiveWhitespaces="true" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%--==============================================================
 * 설문 리스트
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

<script src="resources/assets/js/companySurvey/companySurvey.js"></script>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-xs-12">
			
					<div class="box-header">
					 <h3 class="box-title"><strong>설문조사</strong></h3>
	<br/>
 	<div class="box box-info"></div>
					</div>
					<div style="margin-left:30px; width: 1200px;">
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
						<br />
					</div>

					<!-- /.box-header -->
					<div class="box-body">
						<table id="example1" class="table table-bordered table-striped">
							<thead>
								<tr class="hoverEvent" style="font-size: 17px;">
									<th style="width: 50; text-align: center;">글번호</th>
									<th style="width: 10%; text-align: center;">설문분류</th>
									<th style="width: 40%; text-align: center;">설문명</th>
									<th style="width: 25; text-align: center;">설문진행현황</th>
									<th style="width:10%; text-align: center;">작성자</th>
									<th style="width: 10; text-align: center;">작성일</th>
									<th style="width: 10; text-align: center;">마감일</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${companySurveyList}" var="companySurveyList">
									<tr class="hoverEvent">
										<td style="text-align: center;">${companySurveyList.res_code}</td>
										<td style="text-align: center;">${companySurveyList.res_classi_nm}</td>
										<td><a
											href="companySurveyInformation?res_code=${companySurveyList.res_code}">${companySurveyList.res_tt}</a></td>
										<td style="text-align: center;"><c:choose>
												<c:when test="${companySurveyList.res_prog_st==1}">
													<label>진행중</label>
												</c:when>
												<c:when test="${companySurveyList.res_prog_st==2}">
													<label>설문마감</label>
												</c:when>
											</c:choose></td>
										<td style="text-align: center;">${companySurveyList.mem_nm}</td>
										<td style="text-align: center;">${companySurveyList.res_wrt_day}</td>
										<td style="text-align: center;">${companySurveyList.res_enr_day}</td>

									</tr>

								</c:forEach>
						</table>
						<div style="float: right;">
						<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_LEADER')">
							<input type="button" class="btn btn-danger" value="설문등록"
								onclick="location.href='/gw/companySurveyWrite';">
								</sec:authorize>
								 <input
								type="button" class="btn btn-danger"
								onClick="location.href='/gw/main';" value="홈으로">
						</div>
					</div>
					<!-- /.box-body -->
				
				<!-- /.box -->
			</div>
		</div>
		</div>
	</section>


</body>
</html>