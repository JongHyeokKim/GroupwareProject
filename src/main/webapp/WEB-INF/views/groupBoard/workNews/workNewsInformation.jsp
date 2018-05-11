<%--==============================================================
 * 사내뉴스 상세정보
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
    <%@ page trimDirectiveWhitespaces="true" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>

<body>
 <div class="col-md-12">
         <br/>
            <div class="box-header">
              <!-- tools box -->
             <h3 class="box-title"><strong>사내소식</strong></h3>
	<br/>
 	<div class="box box-info"></div>
              <!-- /. tools -->
            </div>
             <table id="example1" class="table table-bordered table-striped">
				<thead>
					<tr>
						<th style="text-align: center;">글번호</th>
						<th style="text-align: center;">${workNewsInformation.br_wrt_num}</th>
						<th style="text-align: center;">작성자</th>
						<th style="text-align: center;">${workNewsInformation.mem_nm}</th>
						<th style="text-align: center;">작성일</th>
						<th style="text-align: center;">${workNewsInformation.br_writ_day}</th>
					<tr/>
					<tr>
						<th style="text-align: center;">제목</th>
						<th colspan="6">${workNewsInformation.br_tt}</th>
					</tr>
				</thead>
				<tbody>
        			<tr>
        			<td colspan="6" style="height:400px; vertical-align: text-top;">${workNewsInformation.br_cont}</td>
        			</tr>
        			</tbody>
        			</table>          
            
           <div style="float: right;">
           <sec:authorize access="hasAnyRole('ROLE_ADMIN')">     
<a href="workNewsUpdate?br_wrt_num=${workNewsInformation.br_wrt_num}"><input type="button" class="btn btn-danger" value="수정"></a>
<a href="workNewsDelete?br_wrt_num=${workNewsInformation.br_wrt_num}"><input type="button" class="btn btn-danger" value="삭제"></a>
</sec:authorize>
<input type="button" class="btn btn-danger" value="목록" onclick="location.href='/gw/workNewsList';">
</div>
</div>
</body>
</html>
