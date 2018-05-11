  function getFormatDate(date){
		var year = date.getFullYear();                                 //yyyy
		var month = (1 + date.getMonth());                     //M
		month = month >= 10 ? month : '0' + month;     // month 두자리로 저장
		var day = date.getDate();                                        //d
		day = day >= 10 ? day : '0' + day;                            //day 두자리로 저장
		return  year + '-' + month + '-' + day;
	}
  //마감일자
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
              $("#inputDate").val(date);
              $("#jqxcalendar").jqxCalendar({ width: '250px', height: '250px' }).fadeOut("slow");
          });
      });
     
//
      $(function() {
		$("#imgInp").on("change", function() {
			readURL1(this);
		});
	});
	function readURL1(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#empImg').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}

	$(function() {
		$("#imgInp1").on("change", function() {
			readURL2(this);
		});
	});
	function readURL2(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#signImg').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
  
  
