<%--==============================================================
 * 휴가 계획서
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
</head>
<style>
		.lightGray{
			background-color: lightGray;
		}
</style>

<body class="hold-transition skin-blue sidebar-mini">

	<!-- Main content -->	
	<div class="row" style="margin-left: 45px;">
		<table border="1" style="width: 95%; height:850px; border:2px solid black; border-collapse:collapse;">
			<tr style="height: 40px; text-align: center;">
				<td colspan="2" rowspan="2" style="width: 20%; font-size:30px;"><b>휴 가 신 청 서</b></td>
				<td rowspan="2" style="width: 5%" class="lightGray"><b>결</b><br><b>재</b></td>
				<td style="width: 17%" class="lightGray"><b>담 당</b></td>
				<td style="width: 17%" class="lightGray"><b>과 장</b></b></td>
				<td style="width: 17%" class="lightGray"><b>부 장</b></td>
			</tr>
			<tr style="height: 30px; text-align: center;">
				<td><br><br></td>
				<td><br><br></td>
				<td><br><br></td>
			</tr>
			<tr style="height: 40px; text-align: center;">
				<td style="width: 20%" class="lightGray"><b>부       서</b></td>
				<td colspan="6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
			<tr style="height: 40px; text-align: center;">
				<td style="width: 20%" class="lightGray"><b>성       명</b></td>
				<td colspan="6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
			<tr style="height: 40px; text-align: center;">
				<td style="width: 20%" class="lightGray"><b>직       급</b></td>
				<td colspan="6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
			<tr style="height: 40px; text-align: center;">
				<td style="width: 20%" class="lightGray"><b>비 상 연 락 처</b></td>
				<td colspan="6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
			<tr style="height: 40px; text-align: center;">
				<td class="lightGray"><b>휴 가 종 류</b></td>
				<td colspan="6"></td>
			</tr>
			<tr style="height: 40px; text-align: center;">
				<td class="lightGray"><b>휴 가 기 간</b></td>
				<td colspan="6"></td>
			</tr>
			<tr style="height: 200px; text-align: center;">
					<td class="lightGray"><b>휴 가 사 유</b></td>
					<td colspan="5"></td>
			</tr>
			<tr style="height: 40px; text-align: center;">
				<td colspan="6">
					<textarea rows="15" cols="20" style="width: 100%; border:0px; overflow: hidden;" readonly="readonly">


		위와 같이 휴가계획서를 제출하오니 허락하여 주시기 바랍니다.
			
			

						
						
						
						소 속 : 
								
						성 명 : 			(인)
						
						   		  년    월    일
						

					</textarea>
				</td>
			</tr>
		</table>
		<div style="float:right; margin-top:10px;">
			<img src="resources/assets/img/logo1.png" width="120px" height="40px">
		</div>
	</div>
</body>
</html>