<!DOCTYPE html> 
<!-- Doctype HTML5 Para mayor infomacion https://www.w3.org/QA/2002/04/valid-dtd-list.html -->
	<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@ page import="mx.isban.agave.configuracion.Configuracion"%>

	<script src="${pageContext.servletContext.contextPath}/lf/${LyFBean.lookAndFeel}/js/global.js"           type="text/javascript"></script>
	<script src="${pageContext.servletContext.contextPath}/lf/${LyFBean.lookAndFeel}/js/menu/dynamicMenu.js" type="text/javascript"></script>
	<link href="${pageContext.servletContext.contextPath}/lf/${LyFBean.lookAndFeel}/css/menu/estilos.css"            rel="stylesheet" type="text/css">
	<link href="${pageContext.servletContext.contextPath}/lf/${LyFBean.lookAndFeel}/css/menu/elementos_interfaz.css" rel="stylesheet" type="text/css">

<!-- <body onload="initialize('${param.menuItem}', '${param.menuSubitem}'); addMenuItem('eight','Mi opcion dinamica','','', 'true', 'true'); disabledMenuItem('three'); disabledMenuItem('fiveDotTwo');"> -->
<body onload="initialize('${param.menuItem}', '${param.menuSubitem}'); enabledMenuItems('${LyFBean.idsMenuPerfil}', '${LyFBean.tipoMenu}', '${LyFBean.tipoIdsMenu}'); estableceAyuda('${param.helpPage}')">
	<div id="top04">
		<c:if test="${LyFBean.menuHabilitado}">
			<div class="frameMenuContainer">
				<ul id="mainMenu">
					<li id="principal" class="startMenuGroup"> 
						<a href="../principal/inicio.do">             
							<span>${principal}</span>
						</a>
					</li>
					<li id="idMenuModUsuarios" class="withSubMenus startMenuGroup">
						<a href="javascript:selectMenuItem('idMenuModUsuarios')"><span>${lblNombreModulo}</span></a>
						<ul>
							<li id="submenuConsultaUsuarios" class="withSubMenu startMenuGroup">
								<a href="../usuarios/consultaUsuarios.do"> &gt;
									<span class="subMenuText">${lblConsultaUsuarios}</span>
								</a>
							</li>
						</ul>
					</li>
				</ul>
			
				<div id="menuFooter">
					<div></div>
				</div>
	
			</div>
		</c:if>
	</div>
<!-- </div>  -->
<!-- </body> -->
<!-- </html> -->
<div id="content_container">
