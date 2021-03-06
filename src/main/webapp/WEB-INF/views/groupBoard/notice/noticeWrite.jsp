<%--==============================================================
 * 공지사항 등록페이지
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
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>AdminLTE 2 | Editors</title>
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../../dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="../../dist/css/skins/_all-skins.min.css">
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>

<body class="hold-transition skin-blue sidebar-mini">
<script type="text/javascript">
function getBytes(maxByte) {
    var text = $("#inputName").val();
     var nbytes = 0;
     for (i=0; i<text.length; i++) {
           var ch = text.charAt(i);
           if(escape(ch).length > 4) {
            nbytes += 3;
           } else if (ch == '\n') {
            if (msg.charAt(i-1) != '\r') {
             nbytes += 1;
            }
           } else if (ch == '<' || ch == '>') {
            nbytes += 4;
           } else {
            nbytes += 1;
           }
           document.getElementById("maxByte").innerHTML = nbytes+"/100 Byte";
          }
     if (parseInt(nbytes) > parseInt(maxByte)) {           
         return 0;
	}else{
		return 1;
	}
    
};
</script>


    <!-- Main content -->

    <section class="content">
    
        <div class="col-md-12">
        <br/>
         
            <div class="box-header">
              <!-- tools box -->
             <h3 class="box-title"><strong>공지사항 등록</strong></h3>
	<br/>
 	<div class="box box-info"></div>
              <!-- /. tools -->
            </div>
            <!-- /.box-header -->
            <div class="box-body pad">
            
              <form action="noticeWrite" method="post" enctype="multipart/form-data" onsubmit="return check();">
              
            <table>
            	<tr>
            	<td style="width: 100px; text-align: center;"><strong>제목</strong></td>
            	
            	<td><input type="text" onkeyup="getBytes(100)" style="width: 1200px;" class="form-control" id="inputName" name="br_tt"><span id="maxByte">0/100Byte</span></td>
            	
            	</tr>
            	<tr>
            	<td>&nbsp;</td>
            	</tr>
            	<tr>
            	<td style=" width: 100px; vertical-align: text-top; text-align: center;"><strong>내용</strong></td>
            	
            	<td>
            	 <div style="width:1200px;">
                    <textarea id="editor1" rows="10" cols="80" name="br_cont"></textarea>
             <div class="filebox"><input class="upload-name" value="파일선택" disabled="disabled">
								 <label for="ex_filename">파일 등록</label>
								<input type="file" name="file" id="ex_filename" class="upload-hidden">
			</div>
			</div>
            	</td>
            	</tr>

            </table>
            <br/>
           
              
                <!--     <table>
            	<tr>
            	<td style="width: 100px; text-align: center;">파일첨부</td>
            	<td><input type="text" style="width: 1100px;" class="form-control" id="inputName" placeholder="fileUpload"></td>
            	<td> <input type="button" class="btn btn-danger" value="파일등록"></td>
            	</tr>
            	</table> -->
            	<br/>
            	<div style="float: right;"> 
                     <input type="submit" class="btn btn-danger" value="등록">
				<input type="reset" class="btn btn-danger" value="취소" onclick="location.href='/gw/noticeList';">
				</div>
              </form>
            </div>
          </div>
          <!-- /.box -->

         
        <!-- /.col-->
      <!-- ./row -->
    </section>
    <!-- /.content -->
  <!-- /.content-wrapper -->


<!-- jQuery 2.2.3 -->
<script src="../../plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="../../bootstrap/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="../../plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../dist/js/demo.js"></script>
<!-- CK Editor -->
<script src="https://cdn.ckeditor.com/4.5.7/standard/ckeditor.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="../../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="resources/assets/js/groupBoard/notice.js"></script>

</body>
</html>