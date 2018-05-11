/**
 * 
 */

//주소검색
		$(function() {
			$("#postcodify_search_button").postcodifyPopUp();
		});
/*		function onSubmit() {
			if ($(".postcodify_address").val() == "") {
				return false;
			} else {
				return true;
			}
		}*/

// 사원 및 서명 이미지
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

		
		
		
		
		
		