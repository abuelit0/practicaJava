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
		<script src="${pageContext.servletContext.contextPath}/js/core/bootstrap.min.js" type="text/javascript" defer></script>
		<script src="${pageContext.servletContext.contextPath}/js/core/jquery.min.js" type="text/javascript" defer></script>
		<script src="${pageContext.servletContext.contextPath}/js/domicilios/altaDomicilio.js" type="text/javascript" defer></script>
	</head>
	<body>
		<div class="container">
			<div class="row">
			  	<div class="col-md-12">
				<h2>Ejemplo de Validaci&oacute;n AJAX JSR-303</h2>
					<form:form name="login" action="../domicilios/guardarDomicilio.do" commandName="domicilioForm">
						<div class="form-group">
							 <label for="calle">Calle</label>
							 <form:input type="text" path="calle" id="calle"  class="form-control"  />
							 <label for="colonia">Colonia</label>
							 <form:input type="text"   path="colonia" id="colonia" class="form-control"  />
							 <label for="municipio">Municipio</label>
							 <form:input type="text"  path="municipio"  id="municipio" class="form-control"  />
							 <label for="numeroInt">Numero Interior</label>
							 <form:input type="number" path="numeroInt"  id="numeroInt"   class="form-control"  />
							 <label for="numeroExt">Numero Exterior</label>
							 <form:input type="number" path="numeroExt"  id="numeroExt" class="form-control"  />
							 <label for="codigoPostal">Codigo Postal</label>
							 <form:input type="number"  path="codigoPostal"  id="codigoPostal"  class="form-control"  />
							 <label for="estado">Estado</label>
							 <form:select  path="estado"  id="estado"  class="form-control" >
								<form:option value="" selected disabled>Seleccione</form:option>
								<form:option value="DF" >Distrito Federal</form:option>
								<form:option value="DF" >Estado de M&eacute;xico</form:option>
								<form:option value="JAL" >Jalisco</form:option>
								<form:option value="NL" >Nuevo Le&oacute;n</form:option>
								<form:option value="PUE" >Puebla</form:option>
								<form:option value="QRO" >Quer&eacute;taro</form:option>
								<form:option value="SLP" >San Luis Potos&iacute;</form:option>
								<form:option value="Otro" >Otro</form:option>
							</form:select>
							<div class="checkbox">
								<label for="activo">
									<input type="checkbox" id="activo" />
									Activo
								</label>
							</div>
							<button  type="button"  onclick="doAjax()"  class="btn btn-primary" >Entrar</button>
							<br />
							<div id="error" class="error"></div>
					    </div>
					</form:form>
				</div>
			</div>
		</div>
	</body>
</html>