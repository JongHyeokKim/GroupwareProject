/**
 * 
 */
  	
	//검색
	function search(form) {
		form.action = "customerSearch";
		form.method = "get";
		form.target = "_self";
		form.submit();
	}
	
	//페이징.
	
	$(function () {
	    $("#example1").DataTable();
	  });
