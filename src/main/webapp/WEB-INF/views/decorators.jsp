<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GD Group Ware</title>
<!-- BOOTSTRAP STYLES-->
 
 <link href="resources/sns/css/sns.css" rel="stylesheet" />
<link href="resources/assets/css/AdminLTE.css" rel="stylesheet" />
<link href="resources/assets/css/bootstrap.css" rel="stylesheet" />
<link href="resources/assets/css/style.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="resources/assets/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="resources/assets/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<!-- JQUERY SCRIPTS -->
<script src="resources/assets/js/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="resources/assets/js/bootstrap.min.js"></script>
<!-- METISMENU SCRIPTS -->
<script src="resources/assets/js/jquery.metisMenu.js"></script>
<!-- MORRIS CHART SCRIPTS -->
<script src="resources/assets/js/morris/raphael-2.1.0.min.js"></script>
<script src="resources/assets/js/morris/morris.js"></script>
<!-- CUSTOM SCRIPTS -->
<!-- 캘린더 js css -->
<script src="resources/assets/js/custom.js"></script>

<link rel='stylesheet' href='resources/assets/css/jquery-ui.min.css' />
<link href='resources/assets/css/fullcalendar.css' rel='stylesheet' />
<link href='resources/assets/css/fullcalendar.print.css'
	rel='stylesheet' media='print' />
<script src='resources/assets/js/scheduler/moment.min.js'></script>
<script src='resources/assets/js/scheduler/jquery-1.12.4.js'></script>
<script src='resources/assets/js/scheduler/fullcalendar.js'></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- DataTables -->
<script src='resources/assets/js/dataTables/jquery.dataTables.js'></script>
<script src='resources/assets/js/dataTables/dataTables.bootstrap.min.js'></script>
<!-- SlimScroll -->
<script src='resources/assets/js/slimScroll/jquery.slimscroll.min.js'></script>
<!-- <script src="resources/assets/js/app.min.js"></script> -->
<!-- Sweet Alert -->
<script src="treeview/js/sweetalert.min.js"></script>
<link rel="stylesheet" type="text/css" href="treeview/css/sweetalert.css"/>
<!-- sns -->
<script src="resources/sns/js/jquery.nicescroll.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
* {
	list-style-type: none;
}

ul#le {
	overflow: hidden;
	padding: 0px;
}

ul#le>li {
	float: left;
}

#left {
	
}

#right {
	
}

@media ( min-width :300px) {
}
</style>
</head>


<body style="overflow: scroll">
	<div>
		<%@ include file="header.jsp"%>
	</div>

	<div class="med">
		<div style="float: left; width: auto;">
			<ul id="le">
				<li><%@ include file="left.jsp"%></li>
			</ul>
		</div>
		<div style="width: 82%; height: 100%; float: left">
			<div style="margin-left: 40px; margin-top: 40px; overflow: auto">
				<decorator:body />
			</div>
		</div>
	</div>
</body>
</html>