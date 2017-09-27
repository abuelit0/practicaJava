<!DOCTYPE html> 
<!-- Doctype HTML5 Para mayor infomacion https://www.w3.org/QA/2002/04/valid-dtd-list.html -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Validación JSR-303 exitosa</title>
		<link href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<link href="${pageContext.servletContext.contextPath}/css/estilosFormulario.css" rel="stylesheet" type="text/css"/>
		<script src="${pageContext.servletContext.contextPath}/js/core/jquery.min.js" type="text/javascript" defer></script>
		<script src="${pageContext.servletContext.contextPath}/js/core/bootstrap.min.js" type="text/javascript" defer></script>
	</head>
	<body>
		<div align="center">
			<h2>Validaci&oacute;n JSR-303 exitosa!</h2>
			Codigo: <span class="correcto">${clienteForm.codigo}</span>
			<br />
			Nombre: <span class="correcto">${clienteForm.nombre}</span>
			<br />
			Apellido: <span class="correcto">${clienteForm.apellido}</span>
			<br />
			Edad: <span class="correcto">${clienteForm.edad}</span>
			<br />
			Email: <span class="correcto">${clienteForm.email}</span>
			<br />
			Mes: <span class="correcto">${clienteForm.mes}</span>
			<br />
			Activo: <span class="correcto">${clienteForm.activo}</span>
		</div>
	</body>
</html>