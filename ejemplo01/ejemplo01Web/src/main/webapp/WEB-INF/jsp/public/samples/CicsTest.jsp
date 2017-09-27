<!DOCTYPE html> 
<!-- Doctype HTML5 Para mayor infomacion https://www.w3.org/QA/2002/04/valid-dtd-list.html -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
	<head>
		<meta http-equiv="Content-Type"     content="text/html; charset=ISO-8859-1">
		<meta http-equiv=" content-language" content="${pageContext.response.locale}">
		<meta name="_csrf" content="${_csrf.token}" />
		<!-- default header name is X-CSRF-TOKEN -->
		<meta name="_csrf_header" content="${_csrf.headerName}" />
		<title>Prueba Validacion</title>
		<link href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<link href="${pageContext.servletContext.contextPath}/css/estilosFormulario.css" rel="stylesheet" type="text/css"/>
		<script src="${pageContext.servletContext.contextPath}/js/core/jquery.min.js" type="text/javascript" defer></script>
		<script src="${pageContext.servletContext.contextPath}/js/core/bootstrap.min.js" type="text/javascript" defer></script>
		<script src="${pageContext.servletContext.contextPath}/js/samples/samplesAgave.js" type="text/javascript" defer></script>
	</head>
	<body>
		<div class="container">
			<div class="row">
			  	<div class="col-md-12">
				<h2>CICS Test</h2>
				<form:form name="cics"  commandName="cicsForm"  action="../samples/usoIsbanDataAccessCics.do">
					<div class="form-group">
						<label for="transaccion">Usuario (8 posiciones)</label>
						<form:input type="text" path="usuario"  id="usuario"  class="form-control" value="DEIFSNMX" />
						<form:errors path="transaccion"  cssClass="error" />
						<br />
						<label for="transaccion">Transaccion (4 posiciones)</label>
						<form:input type="text" path="transaccion"  id="transaccion"  class="form-control" value="B401" />
						<form:errors path="transaccion"  cssClass="error" />
						<br />						
						<label for="longitud">Longitud (4 posiciones, favor de rellenar con 0 a la izquierda)</label>
						<form:input type="text" path="longitud"  id="longitud"  class="form-control" value="123" />
						<form:errors path="longitud"  cssClass="error" />
						<br />						
						<label for="trama">Mensaje (N posiciones)</label>
						<form:input type="text" path="trama"  id="trama"  class="form-control"  value="60503379403                                                                                " />
						<form:errors path="trama"  cssClass="error" />
						<br />
						<label for="respuesta">Respuesta</label>
						<form:textarea path="respuesta" id="respuesta" readonly="true" class="form-control"  />
						<br />
						<button  type="button" onclick="doUsoIsbanDataAccessCics()" class="btn btn-primary" >Probar</button>
						<br />
						<div id="error" class="error"></div>
				    </div>
				</form:form>
				</div>
			</div>
		</div>
	</body>
</html>