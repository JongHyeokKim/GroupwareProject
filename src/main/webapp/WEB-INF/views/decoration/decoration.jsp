<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<html>
<head>
<meta charset="UTF-8">
<title>Shop<decorator:title /></title>
   <style type="text/css">
      #a{text-align: center;}
      #b{text-align:right;}
   </style>
   <decorator:head />
</head>
<body>
   <div style="width:100%; height:100%;">
      <jsp:include page="top.jsp" />
      
      
      <center>
	      <div style="width:100%; height:100%;">
	         <decorator:body />
	      </div>
      </center>
      
      <jsp:include page="bottom.jsp" />

   </div>
</body>
</html>