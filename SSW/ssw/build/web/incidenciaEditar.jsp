<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="incidencia" scope="session" class="data.IncidenciaBean"/>
<jsp:useBean id="optan" scope="session" class="data.ListaUsuarios"/>

<!DOCTYPE html>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Modificar incidencia</title>
        <link rel="stylesheet" type="text/css" href="../style.css"/>
    </head>
    <body>

        <%@include file="cabecera.jsp"%>

        <div id="cuerpo">
            <form action="../editarincidencia/<jsp:getProperty name="incidencia" property="id"/>" method="post" enctype="multipart/form-data">
				<input type="hidden" name="estado" value="<jsp:getProperty name="incidencia" property="estado"/>"/>
                <div id="incidencia">
                    <h3 id="tituloIncidencia">Modificar Incidencia</h3>
                    <div class="campo">

                        <label class="etiqueta" >Titulo: </label><input id="titulo"  required name="titulo" type="text" class="cuadro" value="<jsp:getProperty name="incidencia" property="titulo"/>">

                    </div>
                    <div class="campo">
                        <label class="etiqueta"  >Lugar: </label><input class="cuadro" required name="direccion" type="text" value="<jsp:getProperty name="incidencia" property="direccion"/>">

                    </div>

                    <div class="campo">
                        <label class="etiqueta"  >Tipo de incidencia: </label>
                        <select required name="tipo" class="cuadro">
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
                        <label class="etiqueta" >Descripción:</label><textarea  required class="cuadro"rows="2" cols="20" name="descripcion"><jsp:getProperty name="incidencia" property="descripcion"/></textarea>
                    </div>
                    <div class="campo">
                        <label class="etiqueta" >Foto:</label><input id="foto" name="foto" type="file"  class="cuadro" >
                    </div>

					<c:if test="${empty incidencia.autonomo}">
						<div class="campo">
							<label class="etiqueta">Autonomo asignado: </label>
							<select required name="autonomo" class="cuadro">
								<option selected="selected">
									Sin asignar
								</option>
								<c:if test="${not empty optan}">
									<c:forEach items="${optan}" var="usuario">
										<option value="<c:out value="${usuario.username}"/>">
											<c:out value="${usuario.nombre}"/> <c:out value="${usuario.apellidos}"/>
										</option>
									</c:forEach>
								</c:if>
							</select>
						</div>
					</c:if>

                    <div class="campo">
                        <label class="etiqueta"  >Asignar prioridad: </label>
                        <select required name="prioridad" >
                            <option>Leve</option>
                            <option>Media</option>
                            <option>Grave</option>
                            <option>Urgente</option>
                        </select>
                    </div>

                    <p></p>
                    <div id="botones">


                        <input type="submit" value="Enviar Incidencia" id="enviar"><input  type="reset" value="Limpiar" id="reset">



                    </div>
                </div>
            </form>
        </div>
        <%@include file="pie.jsp"%>
    </body>
</html>