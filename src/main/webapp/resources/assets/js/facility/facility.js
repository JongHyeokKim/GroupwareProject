/**
 * 
 */
        $(function() {
            $("#imgInp").on('change', function(){
                readURL(this);
            });
        });

        function readURL(input) {
            if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                    $('#blah').attr('src', e.target.result);
                }

              reader.readAsDataURL(input.files[0]);
            }
        }
        //
        $(function() {
            $("#imgInp1").on('change', function(){
                readURL1(this);
            });
        });

        function readURL1(input) {
            if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                    $('#blah1').attr('src', e.target.result);
                }

              reader.readAsDataURL(input.files[0]);
            }
        }
        //
                $(function() {
            $("#imgInp2").on('change', function(){
                readURL2(this);
            });
        });

        function readURL2(input) {
            if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                    $('#blah2').attr('src', e.target.result);
                }

              reader.readAsDataURL(input.files[0]);
            }
        }
/*        
        //수정
        function update(form){
        	var code = $("#fac_code").val();
        	if(confirm("수정하시겠습니까?")==true){
        		swal("수정되었습니다","","success");
        	}else{
        		location.href = "adminFacilityUpdateForm?fac_code"+code;
        	}
        	
        }
*/
        function update(form){
    		
			swal({
				title : "수정",
				text : "수정하시겠습니까?",
				type : "warning",
				showCancelButton : true,
				confirmButtonColor : "#DD6B55",
				confirmButtonText : "예",
				cancelButtonText : "아니오",
				closeOnConfirm : false
			}, function() {
				swal({
					title : "수정하였습니다.",
					type : "success"
				},function(){
					form.action="adminFacilityUpdate"
					form.submit();
				});
			});
	}
        
        function cancle(form){
        	form.action="companyFacilityList";
        	form.submit();
        }

        //나의 예약 취소
        function myCancle() {
			var code = $("#reserv_code").val();			
			swal({
				title : "예약취소",
				text : "예약을 취소하시겠습니까?",
				type : "warning",
				showCancelButton : true,
				confirmButtonColor : "#DD6B55",
				confirmButtonText : "예",
				cancelButtonText : "아니오",
				closeOnConfirm : false
			}, function() {
				swal({
					title : "취소되었습니다.",
					type : "success"
				},function(){
					location.href = "reserveCancel?reserv_code=" + code;
				});
			});
			
			
		}

        function facDelete(){
        	swal("삭제되었습니다","","success");
        }

        
    	//시설등록
    	 function onSubmit(){
    	    	
    	    	if($("#imgInp").val()==""){
    	    		swal("시설 이미지 필수입니다.","","info");
    	    		return false;
    	    	}else if($("#imgInp1").val()==""){
    	    		swal("세부 이미지1 필수입니다.","","info");
    	    		return false;
    	    	}else if($("#imgInp2").val()==""){
    	    		swal("세부 이미지2 필수입니다.","","info");
    	    		return false;
    	    	}else if($("#facName").val()==""){
    	    		swal("시설명 필수입니다.","","info");
    	    		return false;
    	    	}else if($("#facDesc").val()==""){
    	    		swal("상세설명 필수입니다.","","info");
    	    		return false;
    	    	}else{
    	   			swal("등록되었습니다","","success");
    	   			return true;
    	    	}
    	    }

