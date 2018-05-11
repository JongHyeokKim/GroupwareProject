<!-- 조회 -->
<div class="box box-primary">
            <div class="box-body box-profile">
           

              <h3 class="profile-username text-center">개인정보조회</h3>

              <p class="text-muted text-center">Software Engineer</p>

              <ul class="list-group list-group-unbordered">
                <li class="list-group-item">
                  <b>Followers</b> <a class="pull-right">1,322</a>
                </li>
                <li class="list-group-item">
                  <b>Following</b> <a class="pull-right">543</a>
                </li>
                <li class="list-group-item">
                  <b>Friends</b> <a class="pull-right">13,287</a>
                </li>
              </ul>

              <a href="/gw/personalInformationUpdate" class="btn btn-primary btn-block"><b>개인정보수정</b></a>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->

<!-- 양식수정 -->
■ 기본정보
  <div class="tab-pane" id="settings">
                <form action="personalInformation" class="form-horizontal" method="post">
                  <div class="form-group">
                    <label for="inputName" class="col-sm-2 control-label">Name</label>

                    <div class="col-sm-10">
                      <input type="email" class="form-control" id="inputName" placeholder="Name">
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="inputEmail" class="col-sm-2 control-label">Email</label>

                    <div class="col-sm-10">
                      <input type="email" class="form-control" id="inputEmail" placeholder="Email">
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="inputName" class="col-sm-2 control-label">Name</label>

                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="inputName" placeholder="Name">
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="inputExperience" class="col-sm-2 control-label">Experience</label>

                    <div class="col-sm-10">
                      <textarea class="form-control" id="inputExperience" placeholder="Experience"></textarea>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="inputSkills" class="col-sm-2 control-label">Skills</label>

                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="inputSkills" placeholder="Skills">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                      <div class="checkbox">
                        <label>
                          <input type="checkbox"> I agree to the <a href="#">terms and conditions</a>
                        </label>
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                      <button type="submit" class="btn btn-danger">Submit</button>
                    </div>
                  </div>
                </form>
              </div>
              
<!-- 에디터  -->
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

설문등록페이지입니다.
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-md-12">
          <div class="box box-info">
            <div class="box-header">
              <!-- tools box -->
             
              <!-- /. tools -->
            </div>
            <!-- /.box-header -->
            <div class="box-body pad">
              <form>
                    <textarea id="editor1" name="editor1" rows="10" cols="80">
                    </textarea>
              </form>
            </div>
          </div>
          <!-- /.box -->

         
        <!-- /.col-->
      </div>
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
<script>
  $(function () {
    // Replace the <textarea id="editor1"> with a CKEditor
    // instance, using default configuration.
    CKEDITOR.replace('editor1');
    //bootstrap WYSIHTML5 - text editor
    $(".textarea").wysihtml5();
  });
</script>

	<input type="button" class="btn btn-danger" value="설문등록" onclick="location.href='/gw/companySurveyList';">
<input type="button" class="btn btn-danger" value="취소" onclick="location.href='/gw/companySurveyList';">



</body>
</html>



<!-- 리스트 -->
 <div class="box">
            <div class="box-header">
              <h3 class="box-title">근태정보조회</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>Rendering engine</th>
                  <th>Browser</th>
                  <th>Platform(s)</th>
                  <th>Engine version</th>
                  <th>CSS grade</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                  <td>Trident</td>
                  <td>Internet
                    Explorer 4.0
                  </td>
                  <td>Win 95+</td>
                  <td> 4</td>
                  <td>X</td>
                </tr>
                <tr>
                  <td>Trident</td>
                  <td>Internet
                    Explorer 5.0
                  </td>
                  <td>Win 95+</td>
                  <td>5</td>
                  <td>C</td>
                </tr>
                <tr>
                  <td>Trident</td>
                  <td>Internet
                    Explorer 5.5
                  </td>
                  <td>Win 95+</td>
                  <td>5.5</td>
                  <td>A</td>
                </tr>
                <tr>
                  <td>Trident</td>
                  <td>Internet
                    Explorer 6
                  </td>
                  <td>Win 98+</td>
                  <td>6</td>
                  <td>A</td>
                </tr>
                <tr>
                  <td>Trident</td>
                  <td>Internet Explorer 7</td>
                  <td>Win XP SP2+</td>
                  <td>7</td>
                  <td>A</td>
                </tr>
                <tr>
                  <td>Trident</td>
                  <td>AOL browser (AOL desktop)</td>
                  <td>Win XP</td>
                  <td>6</td>
                  <td>A</td>
                </tr>
              
              </table>
            </div>
            <!-- /.box-body -->
          </div>
        <input type="button" class="btn btn-danger" onClick="location.href='/gw/main';" value="홈으로">
        <input type="button" class="btn btn-danger" value="검색">
        <input type="button" class="btn btn-danger" value="조회">
        
        <!-- 문서 내용 -->
        <div class="box-body no-padding">
              <div class="mailbox-read-info">
                <h3>기안양식제목</h3>
                <h5>From: help@example.com
                  <span class="mailbox-read-time pull-right">15 Feb. 2016 11:03 PM</span></h5>
              </div>
              <!-- /.mailbox-read-info -->
              <div class="mailbox-controls with-border text-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-default btn-sm" data-toggle="tooltip" data-container="body" title="Delete">
                    <i class="fa fa-trash-o"></i></button>
                  <button type="button" class="btn btn-default btn-sm" data-toggle="tooltip" data-container="body" title="Reply">
                    <i class="fa fa-reply"></i></button>
                  <button type="button" class="btn btn-default btn-sm" data-toggle="tooltip" data-container="body" title="Forward">
                    <i class="fa fa-share"></i></button>
                </div>
                <!-- /.btn-group -->
                <button type="button" class="btn btn-default btn-sm" data-toggle="tooltip" title="Print">
                  <i class="fa fa-print"></i></button>
              </div>
              <!-- /.mailbox-controls -->
              <div class="mailbox-read-message">
                <p>내용부</p>

                <p>Keffiyeh blog actually fashion axe vegan, irony biodiesel. Cold-pressed hoodie chillwave put a bird
                  on it aesthetic, bitters brunch meggings vegan iPhone. Dreamcatcher vegan scenester mlkshk. Ethical
                  master cleanse Bushwick, occupy Thundercats banjo cliche ennui farm-to-table mlkshk fanny pack
                  gluten-free. Marfa butcher vegan quinoa, bicycle rights disrupt tofu scenester chillwave 3 wolf moon
                  asymmetrical taxidermy pour-over. Quinoa tote bag fashion axe, Godard disrupt migas church-key tofu
                  blog locavore. Thundercats cronut polaroid Neutra tousled, meh food truck selfies narwhal American
                  Apparel.</p>

                <p>Raw denim McSweeney's bicycle rights, iPhone trust fund quinoa Neutra VHS kale chips vegan PBR&amp;B
                  literally Thundercats +1. Forage tilde four dollar toast, banjo health goth paleo butcher. Four dollar
                  toast Brooklyn pour-over American Apparel sustainable, lumbersexual listicle gluten-free health goth
                  umami hoodie. Synth Echo Park bicycle rights DIY farm-to-table, retro kogi sriracha dreamcatcher PBR&amp;B
                  flannel hashtag irony Wes Anderson. Lumbersexual Williamsburg Helvetica next level. Cold-pressed
                  slow-carb pop-up normcore Thundercats Portland, cardigan literally meditation lumbersexual crucifix.
                  Wayfarers raw denim paleo Bushwick, keytar Helvetica scenester keffiyeh 8-bit irony mumblecore
                  whatever viral Truffaut.</p>

                <p>Post-ironic shabby chic VHS, Marfa keytar flannel lomo try-hard keffiyeh cray. Actually fap fanny
                  pack yr artisan trust fund. High Life dreamcatcher church-key gentrify. Tumblr stumptown four dollar
                  toast vinyl, cold-pressed try-hard blog authentic keffiyeh Helvetica lo-fi tilde Intelligentsia. Lomo
                  locavore salvia bespoke, twee fixie paleo cliche brunch Schlitz blog McSweeney's messenger bag swag
                  slow-carb. Odd Future photo booth pork belly, you probably haven't heard of them actually tofu ennui
                  keffiyeh lo-fi Truffaut health goth. Narwhal sustainable retro disrupt.</p>

                <p>Skateboard artisan letterpress before they sold out High Life messenger bag. Bitters chambray
                  leggings listicle, drinking vinegar chillwave synth. Fanny pack hoodie American Apparel twee. American
                  Apparel PBR listicle, salvia aesthetic occupy sustainable Neutra kogi. Organic synth Tumblr viral
                  plaid, shabby chic single-origin coffee Etsy 3 wolf moon slow-carb Schlitz roof party tousled squid
                  vinyl. Readymade next level literally trust fund. Distillery master cleanse migas, Vice sriracha
                  flannel chambray chia cronut.</p>

                <p>Thanks,<br>Jane</p>
              </div>
              <!-- /.mailbox-read-message -->
            </div>
	<input type="button" class="btn btn-danger" value="수정" onclick="location.href='/gw/draftdocumentAdminUpdate';">
	<input type="button" class="btn btn-danger" value="삭제" onclick="location.href='/gw/draftdocumentAdminList';" >
	<input type="button" class="btn btn-danger" value="기안문서양식함으로 돌아가기" onclick="location.href='/gw/draftdocumentAdminList';">
	
     
</body>
</html>

<!-- 메인 / 전체문서함 -->
<div style="height: 350px;width:100%; margin-top: 20px;">
		<div class="col-md-3 sizetest">
			<div class="box box-default collapsed-box">
				<div class="box-header with-border">
					<h3 class="box-title">
						<a onclick="location.href='/gw/transientStorageList';">임시문서함</a>
					</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-widget="collapse">
							<i class="fa fa-plus"></i>
						</button>
					</div>
					<!-- /.box-tools -->
				</div>
				<!-- /.box-header -->
				<div class="box-body">The body of the box</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>


		<div class="col-md-3">
			<div class="box box-default collapsed-box">
				<div class="box-header with-border">
					<h3 class="box-title">
						<a onclick="location.href='/gw/ongoingDocumentList';">진행중인문서함</a>
					</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-widget="collapse">
							<i class="fa fa-plus"></i>
						</button>
					</div>
					<!-- /.box-tools -->
				</div>
				<!-- /.box-header -->
				<div class="box-body">The body of the box</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>


		<div class="col-md-3">
			<div class="box box-default collapsed-box">
				<div class="box-header with-border">
					<h3 class="box-title">
						<a onclick="location.href='/gw/finalizationDocumentList';">최종승인문서함</a>
					</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-widget="collapse">
							<i class="fa fa-plus"></i>
						</button>
					</div>
					<!-- /.box-tools -->
				</div>
				<!-- /.box-header -->
				<div class="box-body">The body of the box</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>
	</div>





	<div style="height:350px; width:100%;">
		<div class="col-md-3">
			<div class="box box-default collapsed-box">
				<div class="box-header with-border">
					<h3 class="box-title">
						<a onclick="location.href='/gw/returnDocumentList';">반려문서함</a>
					</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-widget="collapse">
							<i class="fa fa-plus"></i>
						</button>
					</div>
					<!-- /.box-tools -->
				</div>
				<!-- /.box-header -->
				<div class="box-body">The body of the box</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>


		<div class="col-md-3">
			<div class="box box-default collapsed-box">
				<div class="box-header with-border">
					<h3 class="box-title">
						<a onclick="location.href='/gw/documentApprovalList';">결재할문서함</a>
					</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-widget="collapse">
							<i class="fa fa-plus"></i>
						</button>
					</div>
					<!-- /.box-tools -->
				</div>
				<!-- /.box-header -->
				<div class="box-body">The body of the box</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>
	</div>
<!-- 
작은달력소스
	<body>
<link rel="stylesheet" href="css/jqx.base.css" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/jqxcore.js"></script>
<script type="text/javascript" src="js/jqxdatetimeinput.js"></script>
<script type="text/javascript" src="js/jqxcalendar.js"></script>
<script type="text/javascript" src="js/globalize.js"></script>
<div id='content'>
  <script type="text/javascript">
  function getFormatDate(date){
		var year = date.getFullYear();                                 //yyyy
		var month = (1 + date.getMonth());                     //M
		month = month >= 10 ? month : '0' + month;     // month 두자리로 저장
		var day = date.getDate();                                        //d
		day = day >= 10 ? day : '0' + day;                            //day 두자리로 저장
		return  year + '-' + month + '-' + day;
	}
      $(document).ready(function () {
    	  var click = 0;
    	  $("#btn").click(function(){
    		  if(click==1){
    		     $("#jqxcalendar").jqxCalendar({ width: '250px', height: '250px' }).slideToggle();
    		     click=0;
    		  }
    		  else{
    			  $("#jqxcalendar").jqxCalendar({ width: '250px', height: '250px' }).slideDown();
    			  click=1;
    		  }
    	  });
          $('#jqxcalendar').bind('valuechanged', function (event) {
              var date = event.args.date;
              date = getFormatDate(date);
              $("#text").val(date);
              $("#jqxcalendar").jqxCalendar({ width: '250px', height: '250px' }).fadeOut("slow");
          });
      });
  </script>  
  <input type="button" id="btn"  style="background-image:url('images/icon-calendar.png'); width: 15px;">
  <div id='jqxcalendar'></div>
  <input type="text" id='text'>
</div>
</body> -->