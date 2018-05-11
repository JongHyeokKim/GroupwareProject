<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<HTML>
 <HEAD>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
 
 </HEAD>
<BODY> 
  <link rel="stylesheet" href="treeview/css/demo.css" type="text/css">
  <link rel="stylesheet" href="treeview/css/zTreeStyle/zTreeStyle.css" type="text/css">
  <link rel="stylesheet" href="treeview/css/zTreeStyle/zTreeStyle.css" type="text/css">
  <script type="text/javascript" src="treeview/js/jquery.js"></script>
  <script type="text/javascript" src="treeview/js/jquery.ztree.core.js"></script>
  <script type="text/javascript">
  
   $(function(){
	   var zTreeObj;
	   // zTree configuration information, refer to API documentation (setting details)
	   var setting = {
		   key:{
			   name:"id"
		   },
		   simpleData:{
			   enable:true,
			   idKey:"id"
		   },
		   callback:{
			   onClick:myOnClick
		   },
		   view:{
			   selectedMulti:true
		   },
	   };
	   // zTree data attributes, refer to the API documentation (treeNode data details)
	   var treeNode;
	   var count=0;
	   var classNode = new Array();
	   var key;
	   $.ajax({
		   type:"get",
		   url:"getDepart",
		   contentType:"application/json",
		   success:function(keyData){
			   key = keyData;
			   $.ajax({
				   type:"get",
				   url:"addressData",
				   contentType:"application/json",
				   success:function(data){
					  $.each(key, function(i,keyName){
							classNode[count]={name:keyName, open:false, isParent:true, children:data.jsonList[keyName]};
							count++;
					  });
					      zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, classNode);
				   },
				   error:function(error){
					   alert("에러발생 "+error.message);
				   }
			   });
			   
		   },
		   error:function(){
			   alert("키 에러");
		   }
	   });
	   function myOnClick(event, treeId, treeNode) {
		   if(!treeNode.isParent){
		    	alert("ID : " + treeNode.id+"\nPid : "+ treeNode.pId);
		   }
		};
	   
	});
  </script>  
<div>
   <ul id="treeDemo" class="ztree"></ul>
</div>
</BODY>
</HTML>