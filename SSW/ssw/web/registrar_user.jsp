<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC ".//W3C//DTD HTML 4.01//EN"
	"http.//www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<title>Registrar usuario</title>
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css" href="style.css"/>
		<script type="text/javascript" src="validacionesUser.js"></script>
	</head>
	<body>
		<%@include file="cabecera.jsp"%>
		<div id="cuerpo">
			<div id="contenido">
				<div id="RegistroForm">
					<h1>Formulario creación usuario</h1><hr><br>
					<form action="registro" method="post" enctype="multipart/form-data" >
						<input type="hidden" name="tipo" value="NORMAL">
						<table cellspacing="5" border="0">
							<tr>
								<td align="right">Nombre de usuario:</td>
								<td align="left"><input type="text" name="username" id="usernombre"></td>
							</tr>
							<tr>
								<td align="right">Contraseña:</td>
								<td align="left"><input type="password" name="pwd" id="pass"></td>
							</tr>
							<tr>
								<td align="right">Nombre:</td>
								<td align="left"><input type="text" name="nombre" id="nom"></td>
							</tr>
							<tr>
								<td align="right">Apellidos:</td>
								<td align="left"><input type="text" name="apellidos" id="ape"></td>
							</tr>
							<tr>
								<td align="right">DNI:</td>
								<td align="left"><input type="text" name="dni" id="nif"></td>
							</tr>
							<tr>
								<td align="right">Codigo Postal:</td>
								<td align="left"><input type="text" name="cp" id="cp"></td>
							</tr>
							<tr>
								<td align="right">Correo electrónico:</td>
								<td align="left"><input type="text" name="email" id="correo"></td>
							</tr>

							<tr>
								<td align="right" rowspan="2"> Añadir foto :</td>
								<td align="left" rowspan="2"><input type=file name="fotoUser"></td>
							</tr>
							<tr>
								<td><br></td>
								<td><br></td>
							</tr>

							<tr>
								<td align="right"> <input type="reset" value="Limpiar formulario"></td>
								<td align="middle"> <input type="submit" id="registraruser" value="Registrar"></td>
							</tr>

						</table></form>
					<div id="loginfail">
						<p ></p>
					</div> 
				</div>
			</div>
		</div>
		<%@include file="pie.jsp"%>
	</body>
</html>
