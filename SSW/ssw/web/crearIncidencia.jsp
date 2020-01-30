<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Crear incidencia</title>
		<link rel="stylesheet" type="text/css" href="style.css"/>
	</head>
	<body>
		<%@include file="cabecera.jsp"%>
		<div id="cuerpo">
			<form action="crearIncidencia" method="post" enctype="multipart/form-data">
				<div id="incidencia">
					<h3 id="tituloIncidencia">Añadir Incidencia</h3>
					<div class="campo">
						<label class="etiqueta">Titulo: </label><input name="titulo" type="text" class="cuadro" required>
					</div>
					<div class="campo">
						<label class="etiqueta">Lugar: </label><input class="cuadro" name="direccion" type="text" required>
					</div>
					<div class="campo">
						<label class="etiqueta">Tipo de incidencia: </label>
						<select name="tipo" class="cuadro" required>
							<option>
								Soldadura
							</option>
							<option>
								Albañileria
							</option>
							<option>
								Carpinteria
							</option>
							<option>
								Electrica
							</option>
							<option>
								Encofrado
							</option>
							<option>
								Fontaneria
							</option>
							<option>
								Pintura
							</option>
							<option>
								Jardineria
							</option>
						</select>
					</div>
					<div class="campo">
						<label class="etiqueta" >Descripción:</label><textarea  required class="cuadro"rows="2" cols="20" name="descripcion"></textarea>
					</div>
					<div class="campo">
						<label class="etiqueta" >Foto:</label><input id="foto" name="fotoIncidencia" type="file"  class="cuadro">
					</div>
					<p></p>
					<div id="botones">
						<input type="submit" value="Enviar Incidencia" id="enviar">
						<input  type="reset" value="Limpiar" id="reset">
					</div>
				</div>
			</form>
		</div>
		<%@include file="pie.jsp"%>
	</body>
</html>