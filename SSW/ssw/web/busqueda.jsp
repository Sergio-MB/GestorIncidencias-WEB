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
				<h1>Busqueda</h1>
				<form action="busqueda" method="post">
					<div id="busqueda">
						<div id="texto">
							<input id="caja" type="text" name="titulo">
							<input id="boton" type="submit" value="Buscar">
						</div>
						<div id="listas">
						<select name="estado">
							<option value="">Estado</option>
							<option value="">Todo</option>
							<option value="SIN_ASIGNAR">Sin asignar</option>
							<option value="EN_PROGRESO">En progreso</option>
							<option value="SOLUCIONADA">Solucionada</option>
							<option value="SIN_APROBAR">Sin aprobar</option>
							<option value="INVALIDA">Invalida</option>
						</select>
						<select name="tipo">
							<option value="">Tipo</option>
							<option value="">Todo</option>
							<option value="SOLDADURA">Soldadura</option>
							<option value="ALBAÑILERIA">Albañileria</option>
							<option value="CARPINTERIA">Carpinteria</option>
							<option value="ELECTRICA">Electrica</option>
							<option value="ENCOFRADO">Encofrado</option>
							<option value="FONTANERIA">Fontaneria</option>
							<option value="PINTURA">Pintura</option>
							<option value="JARDINERIA">Jardineria</option>
						</select>
						</div>
					</div>
				</form>
				<div class="listaInci">
					<%@include file="listaIncidenciasInclude.jsp"%>
				</div>
			</div>
		</div>
		<%@include file="pie.jsp"%>
	</body>
</html>
