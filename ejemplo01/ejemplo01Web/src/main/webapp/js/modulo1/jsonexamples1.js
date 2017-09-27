function preventDefault(form) {
	$(form).submit(function(event) {
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		$.ajax({
			url : "postAjax",
			type : "POST",
			beforeSend: function (request)
            {
				if(token){
					request.setRequestHeader(header, token);
				}
            },
			data : $(form).serialize(), // Stringified Json Object
			async : false, // Cross-domain requests and dataType:
			// "jsonp" requests do not support
			// synchronous operation
			cache : false, // This will force requested pages not to be
			// cached by the browser
			processData : false, // To avoid making query String instead of
			// JSON
			success : function(resposeJsonObject) {
				alert(JSON.stringify(resposeJsonObject));
			},
			error : function(xhr, ajaxOptions, thrownError) {
				alert(xhr.status+':'+ thrownError+"\n"+xhr.responseText);
			}
		});

		event.preventDefault();
	});
}
function showValuesForm(form) {
	var str = $(form).serialize();
	alert(str);
}