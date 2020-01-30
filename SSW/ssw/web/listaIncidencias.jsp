<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC ".//W3C//DTD HTML 4.01//EN"
	"http.//www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<title>Lista de Incidencias</title>
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css" href="style.css"/>
	</head>
	<body>
		<%@include file="cabecera.jsp"%>
		<div id="cuerpo">
			<div id="contenido">
				<h1>Lista de incidencias</h1>
				<div class="listaInci">
					<%@include file="listaIncidenciasInclude.jsp"%>
				</div>
			</div>
		</div>
		<%@include file="pie.jsp"%>

	</body>
</html>
