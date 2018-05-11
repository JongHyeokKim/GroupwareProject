//List
 $(function () {
	 $("#example1").DataTable({
		    "bSort" : false
		});
  });


function search(form){
			form.action="companySurveySearch";
			form.method="get";
			form.target="_self";
			form.submit();
			}

