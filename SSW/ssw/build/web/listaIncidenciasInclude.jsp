<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:forEach items="${lista}" var="incidencia">
	<div class="tarjeta" id="listaIncidencia">
		<a href="incidencia/<c:out value="${incidencia.id}"/>"><img src="imagen?tipo=i&id=<c:out value="${incidencia.id}"/>"></a>
		<div id="datos">
			<p><a href="incidencia/<c:out value="${incidencia.id}"/>"><c:out value="${incidencia.tipoIncidencia}"/></a></p>
			<p><a href="incidencia/<c:out value="${incidencia.id}"/>"><c:out value="${incidencia.titulo}"/></a></p>
			<p><c:out value="${incidencia.descripcion}"/></p>
			<p><c:out value="${incidencia.direccion}"/></p>
			<div id="infoIncidencia">
				<div id="estado" class="<c:out value="${incidencia.estado}"/>">
					<a href="busqueda?estado=<c:out value='${incidencia.estado}'/>"><c:out value='${incidencia.estado}'/></a>
				</div>
			</div>
		</div>

	</div>
</c:forEach>