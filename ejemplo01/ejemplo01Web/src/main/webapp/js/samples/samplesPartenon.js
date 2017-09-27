function doGetVersionPartenon() {
	// Elementos necesarios para evitar CSFR
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$.ajax({
		type : "POST",
		// Elementos necesarios para evitar CSFR
		beforeSend : function(request) {
			if (token) {
				request.setRequestHeader(header, token);
			}
		},
		url : "getTransactionPartenonVersion.do",
		success : function(response) {
			//console.log('Response', response);
			if (response.status == "SUCCESS") {
				$('#versionTrx').val(response.version);
			} else {
				alert("Error");
			}
		},
		error : function(e) {
			// //console.log('Error', e);
			alert('Error: ' + e);
		}
	});
}

function cleanTrxInputData(){
	$('#formPartenon').attr('action','partenonTest');
	$('#formPartenon').submit();
}

function disableInput(inputId) {
	//console.log('Se deshabilita campo', inputId);
	//console.log('Valor Actual', $('#' + inputId).prop('disabled'));
	$('#' + inputId).prop('disabled', !$('#' + inputId).prop('disabled'));
}


$(document).ready(function(){
	//console.log('Ingresa Document Ready');
	//console.log('Valor Check ', $('#trxVersionCheck').prop('checked'));
	$('#trxVersionInput').prop('disabled', $('#trxVersionCheck').prop('checked'));
	
	//console.log('MetadataQuery', $('#metadataQuery').val());
	if($('#metadataQuery').val() === 'true'){
		$('#metadataPartenonDIV').show();
	} else {
		$('#metadataPartenonDIV').hide();
	}
	
	//console.log('resultadoPartenonQuery', $('#metadataQuery').val());
	if($('#resultadoPartenonQuery').val() === 'true'){
		$('#resultadoPartenonDIV').show();
	} else {
		$('#resultadoPartenonDIV').hide();
	}
	
	//console.log('Mensaje de Error',$('#mensajeError').val());
	if($('#mensajeError').val()  != null && $('#mensajeError').val() != undefined && $('#mensajeError').val() !== ''){
		alert('Error ' + $('#mensajeError').val());
	}
});
