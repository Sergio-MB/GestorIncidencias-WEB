<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="incidencia" scope="session" class="data.IncidenciaBean"/>
<jsp:useBean id="optan" scope="session" class="data.ListaUsuarios"/>

<!DOCTYPE HTML PUBLIC ".//W3C//DTD HTML 4.01//EN"
    "http.//www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <title>Incidencia</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="../style.css"/>
    </head>
    <body>
        <%@include file="cabecera.jsp"%>
        <div id="cuerpo">

            <div class="tarjeta" id="ValorarIncidencia">
                <img src="../imagen?tipo=i&id=<jsp:getProperty name="incidencia" property="id"/>">				
                <div id="datos">
                    <p>Estado: <jsp:getProperty name="incidencia" property="estado"/></p>
                    <p>Prioridad: <jsp:getProperty name="incidencia" property="prioridad"/></p>
                    <p id="titulo"><jsp:getProperty name="incidencia" property="titulo"/></p>
                    <p id="tipo"><jsp:getProperty name="incidencia" property="tipoIncidencia"/></p>
                    <p><b>Descripcion:<br></b><jsp:getProperty name="incidencia" property="descripcion"/></p>
                    <p><b>Calle: </b><jsp:getProperty name="incidencia" property="direccion"/></p>
                    <p><b>Autor: </b><a href="../perfil/<jsp:getProperty name='incidencia' property='usuario'/>"><jsp:getProperty name="incidencia" property="usuario"/></a></p>
                        <c:if test='${not empty incidencia.autonomo}'>
                        <p><b>Autonomo asignado: </b><a href="../perfil/<jsp:getProperty name='incidencia' property='autonomo'/>"><jsp:getProperty name="incidencia" property="autonomo"/></a></p>
                        </c:if>
                </div>
                <div id="botonesIncidencia">
                    <c:if test="${usuario1.tipo == 'ADMIN'}">
                        <form action="../cargainci/<jsp:getProperty name="incidencia" property="id"/>">
                            <input type="submit" value="Modificar incidencia" id="modificar">
                        </form>
                    </c:if>

					<c:set var="yaOpta" value="false" />
					<c:forEach items="${optan}" var="usu" >
						<c:if test="${usuario1.username eq usu.username}">
							<c:set var="yaOpta" value="true" />
						</c:if>
					</c:forEach>


                    <c:if test="${incidencia.estado == 'Sin asignar' && usuario1.tipo == 'AUTONOMO' && not yaOpta}">
                        <form action="../Apuntarse" method="post">
                            <input type="submit" value="Apuntarse" id="modificar">
                            <input type="hidden" name="incidencia" value="<jsp:getProperty name='incidencia' property="id"/>">
                            <input type="hidden" name="autonomo" value="<jsp:getProperty name='usuario1' property="username"/>">
                        </form>
                    </c:if>
					<c:if test="${incidencia.estado == 'Sin asignar' && usuario1.tipo == 'AUTONOMO' && yaOpta}">
						<form action="" method="post">
                            <input type="submit" value="Ya estas apuntado" disabled>
                        </form>
					</c:if>
                    <c:if test="${usuario1.username == incidencia.autonomo && incidencia.estado == 'Asignada'}">
                        <form method="post" action="../crear_informe.jsp">
                            <input type="submit" value="Crear informe">
                            <input type="hidden" name="idInci" value="<jsp:getProperty name='incidencia' property="id"/>">
                        </form>
                    </c:if>
                </div>
                <c:if test="${not empty incidencia.informe}">
                    <div id="informe">
                        <hr>
                        <h1>Informe</h1><jsp:getProperty name='incidencia' property="informe"/>
                        <hr>
                    </div>
                </c:if>

				<c:if test="${not empty usuario1.username}">
					<form action="../NuevoComentario/<jsp:getProperty name="incidencia" property="id"/>" method="post">

						<div id="comentariosValoracion">
							<b>Comentarios: </b>
							<br>
							<textarea required name="texto" id="areatexto" rows="4"></textarea>
							<input type="submit" value="Enviar comentario" id="enviarComentario">
						</div>
					</c:if>

                </form>
				<c:forEach items="${comentarios}" var="comentario">             
					<hr id="separarComentarios">
					<div id="comentario">
						<b><a href="../perfil/${comentario.usuario}">${comentario.usuario}</a></b><br>
							${comentario.comentario}
					</div>
                </c:forEach>
            </div>

        </div>
        <%@include file="pie.jsp"%>
    </body>
</html>