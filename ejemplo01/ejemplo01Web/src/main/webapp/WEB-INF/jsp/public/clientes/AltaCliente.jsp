<!DOCTYPE html> 
<!-- Doctype HTML5 Para mayor infomacion https://www.w3.org/QA/2002/04/valid-dtd-list.html -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<meta http-equiv="Content-Type"     content="text/html; charset=ISO-8859-1">
		<meta http-equiv=" content-language" content="${pageContext.response.locale}">
		<title>Prueba Validacion</title>
		<link href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<link href="${pageContext.servletContext.contextPath}/css/estilosFormulario.css" rel="stylesheet" type="text/css"/>
		<script src="${pageContext.servletContext.contextPath}/js/core/jquery.min.js" type="text/javascript" defer></script>
		<script src="${pageContext.servletContext.contextPath}/js/core/bootstrap.min.js" type="text/javascript" defer></script>
	</head>
	<body>
		<div class="container">
			<div class="row">
			  	<div class="col-md-12">
				<h2>Ejemplo de Validaci&oacute;n JSR-303</h2>
					<form:form name="login" action="../clientes/guardarCliente.do" commandName="clienteForm">
						<div class="form-group">
							<br />
							<label for="codigo">Codigo</label>
							<form:input type="number" path="codigo"  id="codigo"  class="form-control" />
							<form:errors path="codigo"  cssClass="error" />
							
							<br />	
							<label for="nombre">Nombre</label>
							<form:input type="text"   path="nombre"  id="nombre"  class="form-control"  />
							<form:errors path="nombre"  cssClass="error" />
							
							<br />		
							<label for="apellido">Apellido</label>
							<form:input type="text"  path="apellido"  id="apellido"  class="form-control" />
							<form:errors path="apellido"  cssClass="error"/>
							
							<br />
							<label for="edad">Edad</label>
							<form:input type="number" path="edad" id="edad"  class="form-control" />
							<form:errors path="edad"  cssClass="error"/>
							
							<br />
							<label for="email">Email</label>
							<form:input type="email"  path="email"  id="email"  class="form-control" />
							<form:errors path="email"  cssClass="error"/>
			
							<br />
							<label for="mes">Mes</label>
							<form:select  path="mes"  id="mes"  class="form-control" >
								<form:option value="" selected disabled>Seleccione</form:option>
								<form:option value="01" >Enero</form:option>
								<form:option value="02" >Febrero</form:option>
								<form:option value="03" >Marzo</form:option>
								<form:option value="04" >Abril</form:option>
								<form:option value="05" >Mayo</form:option>
								<form:option value="06" >Junio</form:option>
								<form:option value="07" >Julio</form:option>
								<form:option value="08" >Agosto</form:option>
								<form:option value="09" >Septiembre</form:option>
								<form:option value="10" >Octubre</form:option>
								<form:option value="11" >Noviembre</form:option>
								<form:option value="12" >Diciembre</form:option>
							</form:select>
							<form:errors path="mes"  cssClass="error"/>
							
							<br />
							<div class="checkbox">
								<label for="activo">
									<form:checkbox path="activo" id="activo" />
									Activo
								</label>
								<form:errors path="activo"  cssClass="error" />
							</div>
							<button  type="submit" class="btn btn-primary" >Entrar</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</body>
</html>