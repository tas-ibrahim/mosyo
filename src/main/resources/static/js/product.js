$(function() {
	
	$("img.lazy").lazyload({
	    effect : "fadeIn"
	});
	
	$('.productOffer').on('click', function(){
		
		   $('#myModal').removeData('bs.modal');
	       $('#myModal').modal({remote: $(this).attr('href') });
	       $('#myModal').modal('show');
			
	       return false;
	       
		});
	
	$(document).on('click', '.fa-facebook', function () {
	
	//$('.share.facebook').on('click', function(){
		
		var url = "http://www.facebook.com/sharer.php?u=" +document.location.origin +  $(this).attr("share_url");
		
		shareWindow(url);
		
	});

});