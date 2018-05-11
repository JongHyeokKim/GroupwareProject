<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--==============================================================
 * 메시지 주소록 페이지
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
<HTML>
<HEAD>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>주소록</title>
</HEAD>
<BODY onresize="parent.resizeTo(870,510)"
	onload="parent.resizeTo(870,510)">
	<link rel="stylesheet" href="treeview/css/zTreeStyle/zTreeStyle.css"
		type="text/css">
	<link rel="stylesheet" href="treeview/css/demoCustom.css"
		type="text/css">
	<link rel="stylesheet" href="treeview/css/emailCss.css" type="text/css">
	<script type="text/javascript" src="treeview/js/jquery.js"></script>
	<script type="text/javascript" src="treeview/js/jquery.ztree.core.js"></script>
	<script type="text/javascript">
		var addressTree;
		var selectedTree;
		var selectedNode = new Array();
		var selectCount = 0;
		var selectTreeSetting = {
			view : {
				selectedMulti : false
			}
		};
		selectedTree = $.fn.zTree.init($("#selectedTree"), selectTreeSetting,
				selectedNode);
		$(function() {
			// zTree configuration information, refer to API documentation (setting details)
			var setting = {
				key : {
					name : "id"
				},
				simpleData : {
					enable : true,
					idKey : "id"
				},
				callback : {
					onClick : myOnClick
				},
				view : {
					selectedMulti : false
				}
			};
			// zTree data attributes, refer to the API documentation (treeNode data details)
			var treeNode;
			var count = 0;
			var classNode = new Array();
			var key;
			$.ajax({
				type : "get",
				url : "getDepart",
				contentType : "application/json",
				success : function(keyData) {
					key = keyData;
					$.ajax({
						type : "get",
						url : "addressData",
						contentType : "application/json",
						success : function(data) {
							$.each(key, function(i, keyName) {
								classNode[count] = {
									name : keyName,
									open : false,
									isParent : true,
									children : data.jsonList[keyName]
								};
								count++;
							});
							addressTree = $.fn.zTree.init($("#addressTree"),
									setting, classNode);
						},
						error : function(error) {
							alert("부서 내 사원 로딩 에러 발생 " + error.message);
						}
					});

				},
				error : function() {
					alert("부서 로딩 에러 발생");
				}
			});
			function myOnClick(event, treeId, treeNode) {
				if (!treeNode.isParent) {
					var imgPath = "memberImages/" + treeNode.mem_img;
					$("")
					$("#mem_num").text(treeNode.id);
					$("#mem_nm").text(treeNode.name);
					$("#dep_nm").text(treeNode.pName);
					$("#mem_em").text(treeNode.mem_em);
					$("#mem_tel").text(treeNode.mem_tel);
					$("#pos_nm").text(treeNode.pos_nm);
					$("#mem_img").attr("src", imgPath);
				}
			}
			;
		});
		function openAllNodes() {
			addressTree.expandAll(true);
		};
		function closeAllNodes() {
			addressTree.expandAll(false);
		};
		function addSelectMember() {
			var memId = $("#mem_num").text();
			if (memId == "") {
				alert("사원이 선택되지 않았습니다.");
			} else if (selectedTree.getNodeByParam("id", memId, null) == null) {
				selectedNode[selectedTree.getNodes().length] = {
					id : memId,
					name : $("#mem_nm").text(),
					email : $("#mem_em").text(),
					isParent : false,
				};
				selectCount++;
				selectedTree = $.fn.zTree.init($("#selectedTree"),
						selectTreeSetting, selectedNode);
			} else {
				alert("이미 추가되있는 사원입니다.");
			}
		}
		function removeSelectMember() {
			var removeNode = selectedTree.getSelectedNodes();
			if (selectedNode[0] != null) {
				selectedTree.removeNode(removeNode[0]);
				selectedNode = selectedTree.getNodes();
				if (selectedTree.getNodes() == null) {
					selectedNode = new Array();
				}
			}
		}
		function finishSetting() {

			var recievers = selectedTree.getNodes();
			window.opener.recievers = recievers;
			$(opener.location).attr("href", "javascript:getMemberValue();");
			window.close();
		}
	</script>
	<style>
#address td tr {
	border: 1px solid black;
}

#address {
	text-align: center;
	height: 50%;
	width: 100%;
	vertical-align: middle;
	border-collapse: collapse;
}

.info-image-height {
	height: 50%;
}

.info-up-width {
	width: 50%;
}

.info-down-left {
	width: 25%;
	height: 35px;
}

.info-down-right {
	width: 75%;
	height: 35px;
}

.info-up {
	height: 35px;
}

#address-down {
	text-align: center;
	height: 50%;
	width: 100%;
	vertical-align: middle;
	border-collapse: collapse;
}
</style>
	<div style="width: auto; float: left; margin-left: 10px;">
		<ul id="addressTree" class="ztree"></ul>
		<div style="text-align: center; margin-top: 10px;">
			<button type="button" class="btn btn-danger" onclick="openAllNodes()">전체열기</button>
			<button type="button" class="btn btn-danger"
				onclick="closeAllNodes()">전체닫기</button>
		</div>
	</div>
	<div style="float: left; width: 40%; margin: 10px;">
		<table id="address" border="1">
			<tr>
				<td class="info-up-width info-image-height" rowspan="4"><img
					id="mem_img" src="treeview/images/defaultUser.png" width="118px"
					height="156px" style="margin: 5px;" /></td>
				<td class="info-up info-up-width">사원번호</td>
			</tr>
			<tr>
				<td id="mem_num" class="info-up info-up-width"></td>
			</tr>
			<tr>
				<td class="info-up info-up-width">사원명</td>
			</tr>
			<tr>
				<td id="mem_nm" class="info-up info-up-width"></td>
			</tr>
		</table>
		<table id="address-down" border="1">
			<tr>
				<td class="info-down-left">부서</td>
				<td id="dep_nm" class="info-down-right"></td>
			</tr>
			<tr>
				<td class="info-down-left">직책</td>
				<td id="pos_nm" class="info-down-right"></td>
			</tr>
			<tr>
				<td class="info-down-left">이메일</td>
				<td id="mem_em" class="info-down-right"></td>
			</tr>
			<tr>
				<td class="info-down-left">연락처</td>
				<td id="mem_tel" class="info-down-right"></td>
			</tr>
		</table>
	</div>
	<div
		style="float: left; width: auto; margin-top: 150px; text-align: center; margin-right: 10px;">
		<button type="button" class="btn btn-danger"
			style="font-size: 5pt; padding: 5px" onclick="addSelectMember();">>></button>
		<br>
		<button type="button" class="btn btn-danger"
			style="font-size: 5pt; padding: 5px" onclick="removeSelectMember();"><<</button>
	</div>
	<div style="float: left; width: auto;">
		<ul id="selectedTree" class="ztree"></ul>
		<div style="text-align: center; margin-top: 10px;">
			<button type="button" class="btn btn-danger"
				onclick="finishSetting();">확인</button>
			<button type="button" class="btn btn-danger"
				onclick="window.close();">취소</button>
		</div>
	</div>

</BODY>
</HTML>