/**
 * Javascript de modulo de samples. Ejemplo de uso de componente de Configuracion
 */
function doUsoConfig() {
		
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
			url: "/ejemplo01Web/samples/usoConfig.do",
			success: function(response){
				if(response.status == "SUCCESS"){
					alert("Exito!! Por favor, revisa tus logs");
				 }else{
					 alert("Error");
				    
				 }
			 },
			 error: function(e){
				 alert('Error: ' + e);
		 }
	});
}

/**
 * Javascript de modulo de samples. Ejemplo de uso de componente de Logging
 */
function doUsoLogging() {
		
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
			url: "/ejemplo01Web/samples/usoLogging.do",
			success: function(response){
				if(response.status == "SUCCESS"){
					alert("Exito!! Por favor, revisa tus logs");
				 }else{
					 alert("Error");
				    
				 }
			 },
			 error: function(e){
				 alert('Error: ' + e);
		 }
	});
}


/**
 * Javascript de modulo de samples. Ejemplo de uso de componente de IsbanDataAccess Database
 */
function doUsoIsbanDataAccessDatabase() {
		
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
			url: "/ejemplo01Web/samples/usoIsbanDataAccessDatabase.do",
			success: function(response){
				if(response.status == "SUCCESS"){
					alert("Exito!! Por favor, revisa tus logs");
				 }else{
					 alert("Error");
				    
				 }
			 },
			 error: function(e){
				 alert('Error: ' + e);
		 }
	});
}


/**
 * Javascript de modulo de samples. Ejemplo de uso de componente de IsbanDataAccess MQ
 */
function doUsoIsbanDataAccessMq() {
		
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
			url: "/ejemplo01Web/samples/usoIsbanDataAccessMq.do",
			success: function(response){
				if(response.status == "SUCCESS"){
					alert("Exito!! Por favor, revisa tus logs");
				 }else{
					 alert("Error");
				    
				 }
			 },
			 error: function(e){
				 alert('Error: ' + e);
		 }
	});
}

/**
 * Javascript de modulo de samples. Ejemplo de uso de componente de IsbanDataAccess Cics
 */
function doUsoIsbanDataAccessCics() {
		
		// Elementos necesarios para evitar CSFR
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		var transaccion = $('#transaccion').val();
		var usuario = $('#usuario').val();
		var trama = $('#trama').val();
		var longitud = $('#longitud').val();
		$("#respuesta").html("");
		var ceros = "0000";
		
		if(longitud.length>=1 && longitud.length<4){
			longitud = '' + ceros.substring(0,4-longitud.length) + longitud;
		}
		$.ajax({
			type: "POST",
			// Elementos necesarios para evitar CSFR
			beforeSend: function (request)
            {
				if(token){
					request.setRequestHeader(header, token);
				}
            },
            data: 
            	"transaccion=" + encodeURIComponent(transaccion) + 
            	"&usuario=" + encodeURIComponent(usuario) + 
            	"&trama=" + encodeURIComponent(trama)+
            	"&longitud=" + encodeURIComponent(longitud),
			url: "/ejemplo01Web/samples/usoIsbanDataAccessCics.do",
			success: function(response){
				if(response!=null && response.respuesta!=null){
					$("#respuesta").val(JSON.stringify(response.respuesta));
					$('#error').hide('slow');					
				 }else{
					 $('#error').html("");
					 var errorInfo = "";
					 for(var i =0 ; i < response.respuesta.length ; i++){
						errorInfo += "<br>" + (i + 1) +". " + response.respuesta[i];
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

/**
 * Javascript de modulo de samples. Ejemplo de uso de componente de IsbanDataAccess Cics
 * con Template
 */
function doUsoIsbanDataAccessCicsTemplate() {
		
		/* Elementos necesarios para evitar CSFR */
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");		
		var idTemplate = $('#idTemplate').val();
		var codOper = $('#codOper').val();
		var typeHeader = $('#typeHeader').val();
		var strRequestHeader = "";
		var dataFormTemplateCics = "";
		
		var paramIn = $('#paramIn').val();
		
		var countParam = 0;
		if(typeHeader!=null && typeHeader!="" && typeHeader=="PS7"){			
			var fieldCheckArray = [
			                       "typeHeader","usr390","trxName",
			                       "gstCmt","numbSeq","typeHead",
			                       "typeProc","keyFunc","indPaperDoc",
			                       "indPreformat"];
			if($("#typeHeader").val().length > 0){
				for(i=0;i<fieldCheckArray.length;i++){
					if($('#'+fieldCheckArray[i]).val().length>0){
						countParam++;
						if(countParam>1){
							strRequestHeader = strRequestHeader + "&" + fieldCheckArray[i]+ "=" + encodeURIComponent($('#'+fieldCheckArray[i]).val());
						}
						else{
							strRequestHeader = fieldCheckArray[i]+ "=" + encodeURIComponent($('#'+fieldCheckArray[i]).val());
						}
					}
				}			
			}
		}
		else if(typeHeader!=null && typeHeader!="" && typeHeader=="PS8"){
			var fieldCheckArray = [
			                       "typeHeader","usr390","trxName",
			                       "gstCmt","numbSeq","typeHead",
			                       "typeProc","keyFunc","indPaperDoc",
			                       "indPreformat","codCanal","ip",
			                       "idTransac","nutc","typeClient",
			                       "idClient","typeAuth","typeSign",
			                       "codeApp","msgVersion","useInfra",
			                       "dataApp"];
			if($("#typeHeader").val().length > 0){
				for(i=0;i<fieldCheckArray.length;i++){
					if($('#'+fieldCheckArray[i]).val().length>0){
						countParam++;
						if(countParam>1){
							strRequestHeader = strRequestHeader + "&" + fieldCheckArray[i]+ "=" + encodeURIComponent($('#'+fieldCheckArray[i]).val());
						}
						else{
							strRequestHeader = fieldCheckArray[i]+ "=" + encodeURIComponent($('#'+fieldCheckArray[i]).val());
						}
					}
				}			
			}
		}

		var dataFormTemplateCics = "";
		if(strRequestHeader.length>0){
			dataFormTemplateCics = 
				"idTemplate="+ encodeURIComponent($('#idTemplate').val()) +
				"&codOper="+ encodeURIComponent($('#codOper').val()) +
				"&" + strRequestHeader + 
				"&paramIn=" + encodeURIComponent(paramIn);
		}
		else{
			dataFormTemplateCics = 
				"idTemplate="+ encodeURIComponent($('#idTemplate').val()) +
				"&codOper="+ encodeURIComponent($('#codOper').val()) +
				"&paramIn=" + encodeURIComponent(paramIn);
		}
		
		$("#respuesta").val("");		
		
		$.ajax({
			type: "POST",
			/* Elementos necesarios para evitar CSFR */
			beforeSend: function (request)
            {
				if(token){
					request.setRequestHeader(header, token);
				}
            },
            data: dataFormTemplateCics,
			url: "usoIsbanDataAccessTemplateCics.do",
			success: function(response){
				console.log('Respuesta Consulta Template',response);
				if (response != null && response.respuesta != null
					&& response.respuesta.codeError != null
					&& response.respuesta.codeError == "DAE000") {
					$("#respuesta").val(JSON.stringify(response.respuesta));
					$('#error').hide('slow');
					
				}else{
					 $('#error').html("");					 
					 $('#error').show('slow');
					 $('#error').html("Por favor corrija el env\u00EDo:\n" + JSON.stringify(response));
				 }
			 },
			 error: function(e){
				 alert('Error: ' + e);
		 }
	});
}


/**
 * Javascript de modulo de samples. Ejemplo de uso de componente de Mensajeria
 */
function doUsoMensajeria() {
		
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
			url: "/ejemplo01Web/samples/usoMensajeria.do",
			success: function(response){
				if(response.status == "SUCCESS"){
					alert("Exito!! Por favor, revisa tus logs");
				 }else{
					 alert("Error");
				    
				 }
			 },
			 error: function(e){
				 alert('Error: ' + e);
		 }
	});
}

/**
 * Javascript de modulo de samples. Ejemplo de uso de componente de Auditoria
 */
function doUsoAuditoria() {
		
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
			url: "/ejemplo01Web/samples/usoAuditoria.do",
			success: function(response){
				if(response.status == "SUCCESS"){
					alert("Exito!! Por favor, revisa tus logs");
				 }else{
					 alert("Error");
				    
				 }
			 },
			 error: function(e){
				 alert('Error: ' + e);
		 }
	});
}


/**
 * Javascript de modulo de samples. Ejemplo de uso de componente de cache
 */
function doUsoCache() {
		
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
			url: "/ejemplo01Web/samples/usoCache.do",
			success: function(response){
				if(response.status == "SUCCESS"){
					alert("Exito!! Por favor, revisa tus logs");
				 }else{
					 alert("Error");
				    
				 }
			 },
			 error: function(e){
				 alert('Error: ' + e);
		 }
	});
}


function redirectPage(page){
	window.open(page);
	
}

/*
 * Valida si una cadena de texto cumple 
 * con el formato JSON
 */
function isJsonString(text) {
	if(!(text===undefined) && text!=null && text!=''){
		var strCadena = ''+text; 
		strCadena = strCadena.trim();
		if (strCadena!='' && /^[\],:{}\s]*$/.test(strCadena.replace(/\\["\\\/bfnrtu]/g, '@').
				replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g, ']').
				replace(/(?:^|:|,)(?:\s*\[)+/g, ''))) {
				return true;
		}
		else{
			return false;
		}
	}
	else{
		return false;
	}
}
