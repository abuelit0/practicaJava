/**
 * Javascript de modulo de domicilios. Ejemplo de validacion ajax con JSR 303.
 */
function doAjax() {
		var calle = $('#calle').val();
		var colonia = $('#colonia').val();
		var municipio = $('#municipio').val();
		var numeroInt = $('#numeroInt').val();
		var numeroExt = $('#numeroExt').val();
		var codigoPostal = $('#codigoPostal').val();
		var estado = $('#estado').val();
		var activo = $('#activo').prop('checked');
		// Elementos necesarios para evitar CSFR
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		
		$.ajax({
			type: "POST",
			// Elementos necesarios para evitar CSFR
			beforeSend: function (request)
            {
				if(token){
					request.setRequestHeader(header, token);
				}
            },
			url: "/ejemplo01Web/domicilios/guardarDomicilio.do",
			data: "calle=" + calle + "&colonia=" + colonia + "&municipio=" + municipio + "&numeroInt=" + numeroInt + "&numeroExt=" + numeroExt + "&codigoPostal=" + codigoPostal + "&estado=" + estado+ "&activo=" + activo,
			success: function(response){
				if(response.status == "SUCCESS"){
					alert("Exito!!");
					$('#error').hide('slow');
				 }else{
				     $('#error').html("");
					 var errorInfo = "";
					 for(var i =0 ; i < response.result.length ; i++){
						errorInfo += "<br>" + (i + 1) +". " + response.result[i];
					 }
					$('#error').show('slow');
					 $('#error').html("Por favor corrija los siguiente errores: " + errorInfo);
					 
				 }
			 },
			 error: function(e){
				 alert('Error: ' + e);
		 }
	});
}