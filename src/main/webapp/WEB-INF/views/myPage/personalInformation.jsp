<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%--==============================================================
 * 개인정보조회 페이지
 * @author 이준수
 * @since  2016.09.01.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *     수정일              수정자                    수정내용
 *    -------      -------     -------------------
 *   2016.09.01.    이준수                     최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
===============================================================--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>개인정보조회</title>
</head>


<body>
	<div class="box-header">
		<h3 class="box-title">
			<strong>개인정보 조회</strong>
		</h3>
		<br />
		<div class="box box-info"></div>
	</div>
	<br />
	<div style="margin-left: 30px; width: 1200px;">
		<div style="margin-left: 250px;">
			<table class="table table-bordered table-hover"
				style="margin-left: 45px; width: 700px; height: 450px; text-align: center;">
				<tbody>
					<tr>
						<td style="vertical-align: middle; font-size: large;" colspan="3"><strong>개
								인 정 보</strong></td>
					</tr>
					<tr>
						<td rowspan="4" style="width: 20%;"><img
							class="media-object img-circle"
							style="width: 150px; height: 150px;"
							src="resources/memberManagementImage/${memberVO.mem_img}">
						</td>
						<td style="vertical-align: middle;" width="20%"><b>사 원 명</b></td>
						<td style="vertical-align: middle;" width="20%">${memberVO.mem_nm}</td>
					</tr>
					<tr>
						<td style="vertical-align: middle;"><b>부&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;서</b></td>
						<td style="vertical-align: middle;">${memberVO.dep_nm}</td>
					</tr>
					<tr>
						<td style="vertical-align: middle;"><b>직&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;급</b></td>
						<td style="vertical-align: middle;">${memberVO.pos_nm}</td>
					</tr>
					<tr>
						<td style="vertical-align: middle;"><b>전 화 번 호</b></td>
						<td style="vertical-align: middle;">${memberVO.mem_tel}</td>
					</tr>
					<tr>
						<td style="vertical-align: middle; font-size: large;" colspan="3"><strong>퇴
								직 금 정 보</strong></td>
					</tr>
					<tr>
						<td style="vertical-align: middle;" rowspan="3"><img
							class="media-object" style="width: 140px; height: 50px;"
							src="resources/assets/img/logo1.png"></td>
						<td style="vertical-align: middle;"><b>근 속 일 수</b></td>
						<td style="vertical-align: middle;">${member.work_day}일</td>
					</tr>
					<tr>
						<td style="vertical-align: middle;"><b>근 속 년 수</b></td>
						<td style="vertical-align: middle;">${member.work_year}년</td>
					</tr>
					<tr>
						<td style="vertical-align: middle;"><b>예상 퇴직급여</b></td>
						<td style="vertical-align: middle;"><b style="color: blue">${member.serverance_pay}
								원</b></td>
					</tr>
				</tbody>
			</table>
			<input type="button" style="float: right;" class="btn btn-danger"
				value="개인정보수정"
				onclick="location.href='/gw/personalInformationUpdateForm';">
		</div>
		>
	</div>
</body>
</html>