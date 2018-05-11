<%--==============================================================
 * 관리자 시설등록 information
 * @author 김성수
 * @since  2016.08.30.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일       수정자          수정내용
 *    -------      -------     -------------------
 *    2016.08.30.  	김성수              최초생성
 * Copyright (c) 2016 by DDIT  All right reserved
 * </pre>
===============================================================--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div class="box-header">
   <h3 class="box-title"><strong>사내시설 수정</strong></h3>
	<br/>
 	<div class="box box-info"></div>
		</div>
	<div style="width: 1200px; margin-left: 30px;">
	
	<form name="frm" class="form-horizontal" 
		method="post" enctype="multipart/form-data">
		<div align="center">
			<input type="hidden" id="fac_code" name="fac_code"
				value="${facilityVO.fac_code}">
			<table class="table table-bordered table-hover"
				style="text-align: center; width: 600px">
				<tbody>
					<tr>
						<td style="vertical-align: middle;"><b>시설이미지</b></td>
						<td><img id="blah"
							src="resources/facilityImage/${facilityVO.fac_img}"
							alt="your image" width="200px" height="200px" /> <br />
							<div class="btn btn-danger btn-file">
								<i class="fa fa-paperclip"></i> 첨부 파일 <input type="file"
									id="imgInp" name="file">
							</div></td>
					</tr>


					<tr>
						<td style="vertical-align: middle;"><b>세부이미지</b></td>
						<td>
							<div style="display: inline-block;">
								<img id="blah1"
									src="resources/facilityImage/${facilityVO.fac_img1}"
									style="border: 1px solid #ccc;" alt="your image" width="130px"
									height="130px" /> <br />
								<div class="btn btn-danger btn-file">
									<i class="fa fa-paperclip"></i> 첨부 파일 <input type="file"
										id="imgInp1" name="file1">
								</div>
							</div>
							<div style="display: inline-block;">
								<img id="blah2"
									src="resources/facilityImage/${facilityVO.fac_img2}"
									style="border: 1px solid #ccc;" alt="your image" width="130px"
									height="130px" /> <br />
								<div class="btn btn-danger btn-file">
									<i class="fa fa-paperclip"></i> 첨부 파일 <input type="file"
										id="imgInp2" name="file2">
								</div>
							</div>
						</td>
					</tr>



					<tr>
						<td style="vertical-align: middle;"><b>시설명</b></td>
						<td>
							<div class="col-sm-4">
								<input type="text" class="form-control1" name="fac_name"
									pattern="[a-zA-Z가-힣0-9]{1,10}" maxlength="10" value="${facilityVO.fac_name}">
							</div>
						</td>
					</tr>

					<tr>
						<td style="vertical-align: middle;"><b>상세설명</b></td>
						<td>
							<div class="col-sm-4">
								<input type="text" class="form-control1"
									maxlength="30"  name="fac_desc"
									value="${facilityVO.fac_desc}">
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			<div style="float: right;">
				<button type="button" class="btn btn-danger"  onclick="update(this.form)">수정</button>
				<a href="companyFacilityList">
					<input type="button" class="btn btn-danger" value="목록">
				</a>
			</div>
		</div>
	</form>
	</div>
	<script type="text/javascript" src="resources/assets/js/facility/facility.js"></script>
</body>
</html>
