if (typeof jQuery != 'undefined') {

    jQuery.fn.exist = function () {
        return this.length != 0;
    };

    jQuery.fn.getFormObj = function () {
        var form = $(this);
        var data = {};

        if (!form.is('form')) return data;

        form.serializeArray().map(function (x) {
            if(x.value.length > 0) data[x.name] = x.value;
        });
        return data;
    };

    jQuery.isNothing = function (a) {
        return !a || typeof(a) === 'undefined' || a === 'undefined' || a == '';
    };
    
}

function shareWindow(url) {
	
	window.open(url, "_blank", "resizable=no, top=300, left=390, width=450, height=400");

}
	

function blockUI(e, centerY) {
	var el = $(e);
	el.block({
		message: '<img src="/static/image/ajax-loading.gif" alt="">',
		centerY: centerY != undefined ? centerY : true,
		css: {
			top: '10%',
			border: 'none',
			padding: '2px',
			backgroundColor: 'none'
		},
		overlayCSS: {
			backgroundColor: '#000',
			opacity: 0.05,
			cursor: 'wait'
		}
	});
}

// Wrapper function to unblock elements (finish loading)
function unblockUI (el) {
	$(el).unblock({
		onUnblock: function () {
			//$(el).removeAttr("style");
		}
	});
}