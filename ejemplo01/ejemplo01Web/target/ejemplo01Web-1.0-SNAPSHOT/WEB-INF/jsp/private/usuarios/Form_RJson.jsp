<!DOCTYPE html> 
<!-- Doctype HTML5 Para mayor infomacion https://www.w3.org/QA/2002/04/valid-dtd-list.html -->
<html>
<head>
<meta name="_csrf" content="${_csrf.token}" />
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}" />
<meta charset="UTF-8">
<title>titulo</title>
</head>
<body>
	Ingrese los datos necesarios
	<form action="" method="POST">
		<label for="nombre">Nombre</label>
		<!--  <form:input path="nombre"/> -->
		<input type="text" name="nombre" id="nombre" />
		<label for="nombre">Cliente</label>
		<!-- <form:input path="cliente"/> -->
		<input type="text" name="cliente" id="cliente" />
		 <input	type="submit" name="submit" id="submit" value="Enviar" />
<input type="hidden"
	name="${_csrf.parameterName}"
	value="${_csrf.token}"/>
	
	<span>${errors }</span>
	</form>
</body>
</html>