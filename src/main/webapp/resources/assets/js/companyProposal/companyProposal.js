//list
$(function() {
	 $("#example1").DataTable({
		    "bSort" : false
		});
	});
	     function search(form){
			form.action="companyProposalSearch";
			form.method="get";
			form.target="_self";
			form.submit();
			}
	//update
	     
	     $(function () {
	    	    // Replace the <textarea id="editor1"> with a CKEditor
	    	    // instance, using default configuration.
	    	    CKEDITOR.replace('editor1');
	    	    //bootstrap WYSIHTML5 - text editor
	    	    $(".textarea").wysihtml5();
	    	  });
	    	  function check(){
	    			
	    			var inputName=$("#inputName").val();
	    			var cont = CKEDITOR.instances.editor1.getData();
	    			
	    			if(inputName==""){	
	    				swal("제목 확인","제목을 입력해주십시오","warning");
	    					
	    					return false;
	    				}
	    			 else if(cont==""){
	    					swal("내용 확인","제목을 입력해주십시오","warning");
	    					return false;
	    			 }if(getBytes(100)==0){
	  	  	           swal("글자수 초과!","제목은 최대 100Byte까지 입력할 수 있습니다.","warning");
		  	           return false;
		  	        }else{
		  	        form.submit();
		  	        }
		  						return true;
	    	  }
	    	  
	    	  //write
	    	