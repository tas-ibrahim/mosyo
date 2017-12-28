$(function() {
	
	$('.phoneNumber').mask('(000) 000 00 00');
	
	$('#saveOfferBtn').click(function(){
		
		var $form = $("#offerForm");
		
		blockUI($('#myModal'))
		
		$form.ajaxSubmit({
	        
	    	timeout: 30 * 1000,

	        success: function (response) {

	        	if (response.success) {
	                
	        		$('#myModal').modal('hide');

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