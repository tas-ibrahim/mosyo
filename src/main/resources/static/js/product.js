$(function() {
	
	$("img.lazy").lazyload({
	    effect : "fadeIn"
	});
	
	$('.productSave').on('click', function(){
		
	   $('#myModal').removeData('bs.modal');
       $('#myModal').modal({remote: $(this).attr('href') });
       $('#myModal').modal('show');
		
       return false;
       
	});

	$('.productOffer').on('click', function(){
		
		   $('#myModal').removeData('bs.modal');
	       $('#myModal').modal({remote: $(this).attr('href') });
	       $('#myModal').modal('show');
			
	       return false;
	       
		});
	
	$('.productDelete').on('click', function(){
		
		var msg = $(this).attr("code") + " kodlu ürünü silmek istiyor musunuz?";
		var url = $(this).attr("href")
		
		bootbox.confirm({ 
		  size: "small",
		  message: msg,
		  
		  buttons: {
		        confirm: {
		            label: 'Evet',
		            className: 'btn-success'
		        },
		        cancel: {
		            label: 'Hayır',
		            className: 'btn-danger'
		        }
		    },
		  
		  callback: function(result){
			  
			  if(result){
				 
				  blockUI($("#product_table")) 
				  
			     $.ajax({
	                url: url,
	                type: 'get',
	                success: function( data, textStatus, jQxhr ){
	                	document.location.reload();
	                },
	                error: function( jqXhr, textStatus, errorThrown ){
	                    console.log( errorThrown );
	                    return true
	                }
		         });
				  
			  }
			  else
				  return true
		  }
		});
		
		return false
		
	});
	
	$(document).on('click', '.fa-facebook', function () {
	
	//$('.share.facebook').on('click', function(){
		
		var url = "http://www.facebook.com/sharer.php?u=" +document.location.origin +  $(this).attr("share_url");
		
		shareWindow(url);
		
	});

});