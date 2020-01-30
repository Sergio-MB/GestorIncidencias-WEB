<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuario1" scope="session" class="data.Usuario"/>
<!DOCTYPE html>
<div id="cabecera">
    <div id="logo">
        <a href="<%=request.getContextPath()%>/index">
            <img src="<%=request.getContextPath()%>/img/logo.svg">
            <h1>UrbanFix</h1>
        </a>
    </div>

    <c:if test="${usuario1.username != null}">
        <div id="login">
            <a href="<%=request.getContextPath()%>/perfil/<jsp:getProperty name="usuario1" property="username"/>">
                <img src="<%=request.getContextPath()%>/imagen?tipo=u&id=<jsp:getProperty name="usuario1" property="username"/>">
                <div id="info">
                    <h1><jsp:getProperty name="usuario1" property="username"/></h1>
                    <br>
                    <a href="<%=request.getContextPath()%>/logout">
                        Cerrar sesion
                    </a>
                </div>
            </a>
        </div>

    </c:if>
    <c:if test="${usuario1.username == null}">
        <a href="<%=request.getContextPath()%>/login.jsp">
            <div id="login">
                <img src="<%=request.getContextPath()%>/img/usuario.svg">
                <h1>Registro / Login</h1>
            </div>
        </a>
    </c:if>
</div>
<div id="menu">
    <ul>
        <a href="<%=request.getContextPath()%>/index" id="primer_elemento">
            <li>Portada</li>
        </a>
        <div class="divisor_h"></div>
        <a href="<%=request.getContextPath()%>/busqueda">
            <li>Busqueda</li>
        </a>
        <a href="<%=request.getContextPath()%>/ListaIncidencias">
            <li>Lista de incidencias</li>
        </a>
		<c:if test="${not empty usuario1.username}">
			<a href="<%=request.getContextPath()%>/crearIncidencia.jsp">
				<li>Crear incidencia</li>
			</a>
		</c:if>
        <a href="<%=request.getContextPath()%>/ListaU">
            <li>Lista de usuarios</li>
        </a>
    </ul>
</div>
