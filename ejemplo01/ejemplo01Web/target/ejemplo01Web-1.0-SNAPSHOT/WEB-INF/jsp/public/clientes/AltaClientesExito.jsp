<!DOCTYPE html>
<!-- Doctype HTML5 Para mayor infomacion https://www.w3.org/QA/2002/04/valid-dtd-list.html -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Validación JSR-303 exitosa</title>
		<link href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.servletContext.contextPath}/css/estilosFormulario.css" rel="stylesheet" type="text/css"/>
		<script src="${pageContext.servletContext.contextPath}/js/core/jquery.min.js" type="text/javascript" defer></script>
		<script src="${pageContext.servletContext.contextPath}/js/core/bootstrap.min.js" type="text/javascript" defer></script>
	</head>
	<body>
		<div align="center">
			<h2>Validaci&oacute;n JSR-303 exitosa!</h2>
			<table>
				<c:forEach items="${clientesForm.clientes}" var="cliente"
					varStatus="status">
					<tr>
						<td>
							Codigo: <span class="correcto">${cliente.codigo}</span></td>
						<td>
							<br /> Nombre: <span class="correcto">${cliente.nombre}</span>
						</td>
						<td>
							<br /> Apellido: <span class="correcto">${cliente.apellido}</span>
						</td>
						<td>
							<br /> Edad: <span class="correcto">${cliente.edad}</span>
						</td>
						<td>
							<br /> Email: <span class="correcto">${cliente.email}</span>
						</td>
						<td>
							<br /> Mes: <span class="correcto">${cliente.mes}</span>
						</td>
						<td>
							<br /> Activo: <span class="correcto">${cliente.activo}</span>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>