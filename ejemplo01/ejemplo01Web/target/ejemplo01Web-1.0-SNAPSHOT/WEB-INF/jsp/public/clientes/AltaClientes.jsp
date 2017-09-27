<!DOCTYPE html>
<!-- Doctype HTML5 Para mayor infomacion https://www.w3.org/QA/2002/04/valid-dtd-list.html -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv=" content-language" content="${pageContext.response.locale}">
		<title>Prueba Validacion</title>
		<link href="${pageContext.servletContext.contextPath}/css/estilosFormulario.css" rel="stylesheet" type="text/css"/>
		<link href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<script src="${pageContext.servletContext.contextPath}/js/core/jquery.min.js" type="text/javascript" defer></script>
		<script src="${pageContext.servletContext.contextPath}/js/core/bootstrap.min.js" type="text/javascript" defer></script>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2>Ejemplo de Validación JSR-303 lista</h2>
					<form:form name="login" action="../clientes/guardarClientes.do"
						commandName="clientesForm">
						<div class="form-group">
							<table>
								<tr>
									<th>No.</th>
									<th>Name</th>
									<th>Lastname</th>
									<th>Email</th>
									<th>Phone</th>
								</tr>
								<c:forEach items="${clientesForm.clientes}" var="cliente"
									varStatus="status">
									<tr>
										<td align="center">
											<label for="clientes[${status.index}].codigo">Codigo</label> 
											<form:input type="number"  path="clientes[${status.index}].codigo"
												id="clientes[${status.index}].codigo" class="form-control" />
											<form:errors path="clientes[${status.index}].codigo" cssClass="error" /></td>
										<td>
											<label for="clientes[${status.index}].nombre">Nombre</label>
											<form:input type="text" path="clientes[${status.index}].nombre"
												id="clientes[${status.index}].nombre" class="form-control" />
											<form:errors path="clientes[${status.index}].nombre" cssClass="error" /></td>
										<td>
											<label for="clientes[${status.index}].apellido">Apellido</label>
											<form:input type="text" path="clientes[${status.index}].apellido"
												id="clientes[${status.index}].apellido" class="form-control" />
											<form:errors path="clientes[${status.index}].apellido" cssClass="error" /></td>
										<td>
											<label for="clientes[${status.index}].edad">Edad</label>
											<form:input type="number" path="clientes[${status.index}].edad"
												id="clientes[${status.index}].edad" class="form-control" /> 
											<form:errors path="clientes[${status.index}].edad" cssClass="error" /></td>
										<td>
											<label for="clientes[${status.index}].email">Email</label>
											<form:input type="email" path="clientes[${status.index}].email"
												id="clientes[${status.index}].email" class="form-control" />
											<form:errors path="clientes[${status.index}].email" cssClass="error" /></td>
										<td>
											<label for="clientes[${status.index}].mes">Mes</label>
											<form:select path="clientes[${status.index}].mes" id="clientes[${status.index}].mes"
												class="form-control">
												<form:option value="" selected disabled>Seleccione</form:option>
												<form:option value="01">Enero</form:option>
												<form:option value="02">Febrero</form:option>
												<form:option value="03">Marzo</form:option>
												<form:option value="04">Abril</form:option>
												<form:option value="05">Mayo</form:option>
												<form:option value="06">Junio</form:option>
												<form:option value="07">Julio</form:option>
												<form:option value="08">Agosto</form:option>
												<form:option value="09">Septiembre</form:option>
												<form:option value="10">Octubre</form:option>
												<form:option value="11">Noviembre</form:option>
												<form:option value="12">Diciembre</form:option>
											</form:select> 
											<form:errors path="clientes[${status.index}].mes" cssClass="error" /></td>
										<td>
											<div class="checkbox">
												<label for="clientes[${status.index}].activo"> <form:checkbox
														path="clientes[${status.index}].activo" id="clientes[${status.index}].activo" />
													Activo
												</label>
												<form:errors path="clientes[${status.index}].activo" cssClass="error" />
											</div>
										</td>
									</tr>
								</c:forEach>
							</table>
							<button type="submit" class="btn btn-primary">Entrar</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</body>
</html>