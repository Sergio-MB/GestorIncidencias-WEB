<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="incidencia" scope="request" class="data.IncidenciaBean"/>
<!DOCTYPE html>
<!DOCTYPE HTML PUBLIC ".//W3C//DTD HTML 4.01//EN"
    "http.//www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <title>Crear informe</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="style.css"/>
    </head>
    <body>
        <%@include file="cabecera.jsp"%>
        <div id="cuerpo">
            <div id="contenido">
				<div id="formulario-informe">
					<h1>Informe</h1>
					<form action="AgregarInforme" method="post">
						<div id="descripcion"> 
							<div class="campo">
								<textarea name="informe" rows="20" maxlength="254" placeholder="Introducir un informe de la reparacion..."></textarea><br>
								<input type="submit" value="Enviar informe">
								<input type="hidden" name="id" value="${param.idInci}">
							</div>
					</form>
				</div>
            </div>
        </div>
    </div>
	<%@include file="pie.jsp"%>
</body>
</html>