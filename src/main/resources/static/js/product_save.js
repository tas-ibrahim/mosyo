$(function() {

$('#saveProductBtn').click(function(){
		
		var $form = $("#saveProductForm");
		
		blockUI($('#myModal'))
		
		$form.ajaxSubmit({
	        
	    	timeout: 30 * 1000,

	        success: function (response) {

	        	if (response.success) {
	                
	        		document.location.reload();

	            } else {
	            	
	            	unblockUI($('#myModal'))
	            	
	                var validator = $form.validate();
	                var conf = {};
	                $.each(response.errors, function (i, o) {
	                    conf[o.field] = o.error;
	                });
	                validator.showErrors(conf); // show errors
	            }
	        }
	    });

		return false;
		
	});


});