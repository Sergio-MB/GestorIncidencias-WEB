<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listaI" scope="session" class="data.IncidenciaBean"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Portada</title>
        <link rel="stylesheet" type="text/css" href="style.css"/>
    </head>
    <body>
        <%@include file="cabecera.jsp"%>
        <div id="cuerpo">
            <div id="contenido">
                <h1><a href="lista.html">Incidencias sin asignar</a></h1>
				<div class="lista">
					<c:forEach items="${listaI}" var="incidencia">
						<c:if test="${incidencia.estado == 'Sin asignar'}">
							<div class="tarjeta">
								<a href="incidencia/<c:out value="${incidencia.id}"/>"><img src="imagen?tipo=i&id=<c:out value="${incidencia.id}"/>"></a>
								<div id="datos">
									<h2><c:out value="${incidencia.tipoIncidencia}"/></h2>
									<h1><c:out value="${incidencia.titulo}"/></h1>
									<h2><c:out value="${incidencia.direccion}"/></h2>
								</div>

								<div id="info">
									<div id="comentarios"></div>
									<div id="estado" class="<c:out value="${incidencia.estado}"/>">
										<a><c:out value="${incidencia.estado}"/></a>
									</div>
								</div>
							</div>
						</c:if>
					</c:forEach>
                    &nbsp;
                </div>  
                <hr>
                <h1><a href="lista.html">Incidencias solucionadas</a></h1>
                <div class="lista">
					<c:forEach items="${listaI}" var="incidencia">
						<c:if test="${incidencia.estado == 'Solucionada'}">


							<div class="tarjeta">
								<a href="incidencia/<c:out value="${incidencia.id}"/>"><img src="imagen?tipo=i&id=<c:out value="${incidencia.id}"/>"></a>
								<div id="datos">
									<h2><c:out value="${incidencia.tipoIncidencia}"/></h2>
									<h1><c:out value="${incidencia.titulo}"/></h1>
									<h2><c:out value="${incidencia.direccion}"/></h2>
								</div>

								<div id="info">
									<div id="comentarios"></div>
									<div id="estado" class="<c:out value="${incidencia.estado}"/>">
										<a><c:out value="${incidencia.estado}"/></a>
									</div>
								</div>
							</div>
						</c:if>
					</c:forEach>
                    &nbsp;
                </div>
            </div>
        </div>
        <%@include file="pie.jsp"%>
    </body>
</html>