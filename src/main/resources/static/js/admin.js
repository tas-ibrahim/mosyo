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
	
	$('.colorSave').on('click', function(){
		
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
	
	$('.offerDelete').on('click', function(){
		
		var msg = "Teklif isteğini silmek istiyor musunuz?";
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
				 
				  blockUI($("#offer_table")) 
				  
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
	
$('.colorDelete').on('click', function(){
		
		var msg = $(this).attr("name") + " rengini silmek istiyor musunuz?";
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
				 
				  blockUI($("#color_table")) 
				  
			     $.ajax({
	                url: url,
	                type: 'get',
	                success: function( data, textStatus, jQxhr ){
	                	
	                	if(data.success)
	                		document.location.reload();
	                	else{
	                		unblockUI($("#color_table"));
	                		bootbox.alert(data.alertMsg)
	                	}
	                },
	                error: function( jqXhr, textStatus, errorThrown ){
	                    console.log( errorThrown );
	                    
	                    unblockUI($("#color_table"));
	                    
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
	
	
});