<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="listau" scope="session" class="data.ListaUsuarios"/>
<!DOCTYPE html>
<!DOCTYPE HTML PUBLIC ".//W3C//DTD HTML 4.01//EN"
    "http.//www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <title>Usuarios</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="style.css"/>
    </head>
    <body>
        <%@include file="cabecera.jsp"%>
        <div id="cuerpo">
            <div id="contenido">
                <div class="listaUsuarios">
					<c:forEach items="${listau}" var="usuario">
						<div class="tarjeta" id="listaUsuarios">
							<a href="perfil/<c:out value="${usuario.username}"/>"><img src="imagen?tipo=u&id=<c:out value="${usuario.username}"/>"></a>
							<div id="datos">
								<p>
									<c:out value="${usuario.nombre}"/>
								</p>
								<p>
									<c:out value="${usuario.apellidos}"/>
								</p>

							</div>
						</div>
					</c:forEach>
                </div>
            </div>
        </div>
    </div>
	<%@include file="pie.jsp"%>
</body>
</html>

