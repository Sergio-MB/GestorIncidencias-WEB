<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuario" scope="session" class="data.Usuario"/>

<!DOCTYPE HTML PUBLIC ".//W3C//DTD HTML 4.01//EN"
    "http.//www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <title>Perfil</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="../style.css"/>
    </head>
    <body>
        <%@include file="cabecera.jsp"%>
        <div id="cuerpo">

            <div id="menu-lateral">
				
					<ul>
						<a href="../MisIncidencias?id=<jsp:getProperty name="usuario" property="username"/>&t=c">
							<li>Inci. Creadas</li>
						</a>
					</ul>
				<c:if test="${usuario.autonomo}">
					<ul>
						<a href="../MisIncidencias?id=<jsp:getProperty name="usuario" property="username"/>&t=a">
							<li>Inci. Asignadas</li>
						</a>
					</ul>
				</c:if>
			</div>

			<div  id="contenido">
				<img class="imagenUsuarioPerfil" src="../imagen?tipo=u&id=<jsp:getProperty name="usuario" property="username"/>">
				<div id="datosUser">
					<table cellspacing="5" border="0">
						<tr>
							<td align="right">Usuario:</td>
							<td align="left"><label id="name"><jsp:getProperty name="usuario" property="username"/></label></td>
						</tr>
						<tr>
							<td align="right">Nombre:</td>
							<td align="left"><label id="name"><jsp:getProperty name="usuario" property="nombre"/></label></td>
						</tr>
						<tr>
							<td align="right">Apellidos:</td>
							<td align="left"><label id="primerApe"><jsp:getProperty name="usuario" property="apellidos"/></label></td></label></td>
						</tr>
						<tr>
							<td align="right">DNI:</td>
							<td align="left"><label id="dni"><jsp:getProperty name="usuario" property="dni"/></label></td></label></td>
						</tr>
						<tr>
							<td align="right">Codigo Postal:</td>
							<td align="left"><label id="cp"><jsp:getProperty name="usuario" property="cp"/></label></td></label></td>
						</tr>
						<c:if test="${usuario.autonomo}">
							<tr>
								<td align="right">Telefono</td>
								<td align="left"><label id="cp"><jsp:getProperty name="usuario" property="telefono"/></label></td></label></td>
							</tr>
							<tr>
								<td align="right">Especialidad</td>
								<td align="left"><label id="cp"><jsp:getProperty name="usuario" property="especialidad"/></label></td></label></td>
							</tr>
							<tr>
								<td align="right">Descripcion</td>
								<td align="left"><label id="cp"><jsp:getProperty name="usuario" property="descripcion"/></label></td></label></td>
							</tr>
						</c:if>
						<hr>
						<tr>
							<td align="left">
								<form action="../carga/<jsp:getProperty name="usuario" property="username"/>">
									<input type="submit" value="Editar perfil" id="goEditarPerfil">
								</form>
							</td>
						</tr>

					</table>
				</div>
			</div>
		</div>
		<%@include file="pie.jsp"%>
	</body>
</html>
