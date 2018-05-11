<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	function mainmove() {
		location.href="gw/main";
	}
</script>
<title></title>
</head>
<body>

<div class="box-header">
            <h3 class="box-title"><strong>퇴직금 조회</strong></h3>
						<br/>
						<div class="box box-info"></div>
            </div>
            <br/>
<table class="table table-bordered table-hover" style="text-align: center; margin-left:50px; width: 1200px;">
	<tbody>
	<tr>
	<td rowspan="6" style="vertical-align: middle; width: 150px;"><strong>사원이미지</strong></td>
	</tr>

	<tr>
	<td rowspan="5" style="width: 300px;"><img class="media-object img-circle"
					src="resources/memberManagementImage/${memberVO.mem_img}"></td>
	</tr>
	<tr>
		<td style="vertical-align: middle;"><strong>사원명</strong></td>
		<td style="vertical-align: middle;">${member.mem_nm}</td>
	</tr>
	<tr>
		<td style="vertical-align: middle;"><strong>근속일수</strong></td>
		<td style="vertical-align: middle;">${member.work_day} 일</td>
	</tr>
	<tr>
		<td style="vertical-align: middle;"><strong>근속년수</strong></td>
		<td style="vertical-align: middle;">${member.work_year} 년</td>
	</tr>
	<tr>
		<td style="vertical-align: middle;"><strong>예상퇴직급여액</strong></td>
		<td style="vertical-align: middle;">${member.serverance_pay} 원</td>
	</tr>
	</tbody>
	</table>
 
       
</body>
</html>