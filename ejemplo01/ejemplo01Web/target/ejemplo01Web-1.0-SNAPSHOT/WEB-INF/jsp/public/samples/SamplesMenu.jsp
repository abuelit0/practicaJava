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
					<h2>Ejemplos de uso de componentes AGAVE</h2>
					<div class="form-group">
						<button  type="button"  onclick="doUsoConfig()"  class="btn btn-primary" >Configuracion</button>
						<br />
						<button  type="button"  onclick="doUsoLogging()"  class="btn btn-primary" >Logging</button>
						<br />
						<button  type="button"  onclick="doUsoIsbanDataAccessDatabase()"  class="btn btn-warning" >IsbanDataAccess Database</button>
						<br />
						<button  type="button"  onclick="doUsoIsbanDataAccessMq()"  class="btn btn-warning" >IsbanDataAccess MQ</button>
						<br />
						<button  type="button"  onclick="redirectPage('${pageContext.servletContext.contextPath}/samples/cicsTest')"  class="btn btn-warning" >IsbanDataAccess CICS</button>
						<br />
						<button  type="button"  onclick="redirectPage('${pageContext.servletContext.contextPath}/samples/partenonTest')"  class="btn btn-warning" >IsbanDataAccess Partenon</button>
						<br />
						<button  type="button"  onclick="doUsoMensajeria()"  class="btn btn-primary" >Mensajeria</button>
						<br />
						<button  type="button"  onclick="doUsoAuditoria()"  class="btn btn-primary" >Auditoria</button>
						<br />
						<button  type="button"  onclick="doUsoCache()"  class="btn btn-primary" >Cache</button>
						<br />
						<button  type="button"  onclick="redirectPage('${pageContext.servletContext.contextPath}/clientes/alta')"  class="btn btn-success" >Validaci&oacute;n JSR 303</button>
						<br />
						<button  type="button"  onclick="redirectPage('${pageContext.servletContext.contextPath}/clientes/altas')"  class="btn btn-success" >Validaci&oacute;n JSR 303 (Lista de objetos)</button>
						<br />
						<button  type="button"  onclick="redirectPage('${pageContext.servletContext.contextPath}/domicilios/alta')"  class="btn btn-success" >Validaci&oacute;n JSR 303 (AJAX)</button>
						<br />
						<div id="error" class="error"></div>
				    </div>
				</div>
			</div>
		</div>
	</body>
</html>