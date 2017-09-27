<!DOCTYPE html>
<!-- Doctype HTML5 Para mayor infomacion https://www.w3.org/QA/2002/04/valid-dtd-list.html -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv=" content-language" content="${pageContext.response.locale}">
<meta name="_csrf" content="${_csrf.token}" />
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}" />

<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script src="../js/core/jquery.min.js"></script>
<script src="../js/core/bootstrap.min.js"></script>
<script src="../js/samples/samplesPartenon.js"></script>
<title>Test</title>
</head>
<body class="container">
	<h1>
		Test Partenon<br>
	</h1>
	<div class="row">
		<form class="form-inline">
			<div class="form-group">
				<label for="versionTrx">Version:</label>
				<input class="form-control" type="text" id="versionTrx" readonly="readonly" value="" />
			</div>
			<button type="button" onclick="doGetVersionPartenon()" class="btn btn-danger">Obtener Versi&oacute;n</button>
		</form>
	</div>
	<div class="row top_padding bottom_padding">

		<!-- Formulario de datos de la Trx -->
		<form:form commandName="partenonBean" action="getTransactionPartenon.do" id="formPartenon">

			<div class="col-xs-12 col-md-6 form-horizontal top_padding">
				<h2>Definici&oacute;n Transacci&oacute;n</h2>

				<div class="form-group">
					<label class="col-xs-3" for="trxNombre"><strong>TRANSACCI&Oacute;N</strong> </label>
					<div class="col-xs-9">
						<form:input id="trxNombre" type="text" class="form-control" path="trxNombre" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-3" for="trxOperacion"><strong>OPERACI&Oacute;N</strong> </label>
					<div class="col-xs-9">
						<form:input id="trxOperacion" type="text" class="form-control" path="trxOperacion" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-3" for="trxNombre"><strong>VERSI&Oacute;N</strong> </label>
					<div class="col-xs-7">
						<form:input id="trxVersionInput" class="form-control" type="text" path="trxVersion" />
					</div>
					<div class="col-xs-2">
						<div class="checkbox">
							<label> <form:checkbox id="trxVersionCheck" onchange="disableInput('trxVersionInput')" path="trxVersionDisabled" /> Null
							</label>
						</div>
					</div>
				</div>
				<button class="btn btn-danger" type="button" onclick="cleanTrxInputData()">Limpiar</button>
				<button class="btn btn-danger" type="submit" name="metadata" value="metadata">Obtener definici&oacute;n</button>
			</div>
			<div class="col-xs-12 col-md-6 form-horizontal top_padding" id="metadataPartenonDIV">
				<h2>Metadata</h2>
				<!-- Formulario de datos de entrada del servicio -->
				<c:forEach var="metadataSend" items="${partenonBean.listaMetadataSend }" varStatus="status">
					<div class="form-group">
						<label class="col-xs-3 control-label" for="${metadataSend.fieldName}"><strong>${metadataSend.fieldName}</strong> </label>
						<div class="col-xs-7">
							<form:input id="${metadataSend.fieldName}" type="text" class="form-control " path="listaMetadataSend[${status.index}].value" disabled="${ metadataSend.disabled}" />
						</div>
						<div class="col-xs-2">
							<div class="checkbox">
								<label> <form:checkbox id="${metadataSend.fieldName } + 'Check'" onchange="disableInput('${metadataSend.fieldName}')"
										path="listaMetadataSend[${status.index}].disabled" /> Null
								</label>
							</div>
						</div>
					</div>
				</c:forEach>
				<button type="submit" class="btn btn-danger" name="transaction" value="transaction">Ejecutar</button>
			</div>
		</form:form>
	</div>
	<div id="resultadoPartenonDIV" class="bottom_padding">
		<h2>Scalars</h2>
		<table>
			<tbody>
				<c:forEach var="entry" items="${partenonBean.mapaScalars }">
					<tr>
						<td class="title">
							<b>${entry.key}</b> -
						</td>
						<td class="content">${entry.value}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h2>Resultado</h2>
		<c:choose>
			<c:when test="${not empty partenonBean.listaResultados }">
				<table class="table">
					<thead>
						<tr>
							<c:forEach var="campo" items="${partenonBean.listaResultados[0] }">
								<th>
									<b>${campo}</b>
								</th>
							</c:forEach>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="registro" items="${partenonBean.listaResultados }" begin="1">
							<tr>
								<c:forEach var="campo" items="${registro}">
									<td>${campo}</td>
								</c:forEach>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<c:out value="No se encontraron registros"></c:out>
			</c:otherwise>
		</c:choose>
	</div>

	<input type="hidden" id="metadataQuery" value="<c:if test="${not empty partenonBean.listaMetadataSend }">true</c:if>">
	<input type="hidden" id="resultadoPartenonQuery" value="<c:if test="${not empty partenonBean.mapaScalars }">true</c:if>">

	<c:if test="${not empty partenonBean.codeError && partenonBean.codeError eq 'ERROR'}">
		<input type="hidden" id="mensajeError" value="${partenonBean.messageError}">
	</c:if>
</body>
</html>