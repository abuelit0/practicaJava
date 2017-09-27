<!DOCTYPE html> 
<!-- Doctype HTML5 Para mayor infomacion https://www.w3.org/QA/2002/04/valid-dtd-list.html -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
	<head>
		<meta http-equiv="Content-Type"     content="text/html; charset=ISO-8859-1">
		<meta http-equiv=" content-language" content="es-MX">

		<title>Pagina de Error Generico</title>
		
		<link href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<script src="${pageContext.servletContext.contextPath}/js/core/bootstrap.min.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/js/core/jquery.min.js" type="text/javascript"></script>
			
	<style type="text/css">
	  .center {text-align: center; margin-left: auto; margin-right: auto; margin-bottom: auto; margin-top: auto;}
	  .turn-gray{background-color: #DEDEDE; }
	</style>		
</head>
<body>
	

<div class="container">
  <div class="row">
    <div class="span12">
      <div class="hero-unit center turn-gray">
          <br />
          <h1>Oops... sucedió un <font face="Tahoma" color="red"> error. </font></h1>
          <br />
          <p>Por favor, contacta al área correspondiente informando el error</p>
          <br />
          <br />
          <img src="${pageContext.servletContext.contextPath}/img/logo_santander_transparent.png" alt="Santander" />
          <br />
          <br />
          <br />
        </div>
        
    </div>
  </div>
</div>

	</body>
</html>