<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuario" scope="session" class="data.Usuario"/>

<!DOCTYPE HTML PUBLIC ".//W3C//DTD HTML 4.01//EN"
    "http.//www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <title>Editar perfil</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="../style.css"/>
    </head>
    <body>
        <%@include file="cabecera.jsp"%>
        <div id="cuerpo">
            <div id="menu-lateral">
                <ul>
                    <a href="../index.jsp" id="primer_elemento">
                        <li>Portada</li>
                    </a>
                    <div class="divisor_h"></div>
                    <a href="../busqueda.html">
                        <li>Busqueda</li>
                    </a>
                    <a href="../ListaDeIncidencias.jsp">
                        <li>Lista completa</li>
                    </a>
                    <a href="../crearIncidencia.html">
                        <li>Crear incidencia</li>
                    </a>
                </ul>
                <hr>
            </div>
            <div id="contenido">
                <div id="modificarPerfilForm">
                    <h1>Editar perfil de usuario</h1><hr><br>

                    <form action="../edicion/<jsp:getProperty name="usuario" property="username"/>" method="post" enctype="multipart/form-data">
                        <table cellspacing="5" border="0">
                            <tr>
                                <td align="right">Nombre de usuario:</td>
                                <td align="left"><label id="name"><jsp:getProperty name="usuario" property="username"/></label></td>
                            </tr>
                            <tr>
                                <td align="right">Contraseña:</td>
                                <td align="left"><input id ="pwd" type="password" name="pwd" required value="<jsp:getProperty name="usuario" property="password"/>"></td>
                            </tr>
                            <tr>
                                <td align="right">Nombre:</td>
                                <td align="left"><input type="text" name="nombre" required value="<jsp:getProperty name="usuario" property="nombre"/>"></td>
                            </tr>
                            <tr>
                                <td align="right">Apellidos:</td>
                                <td align="left"><input type="text" name="apellidos" required value="<jsp:getProperty name="usuario" property="apellidos"/>"></td>
                            </tr>
                            <tr>
                                <td align="right">DNI:</td>
                                <td align="left"><input type="text" name="dni" required value="<jsp:getProperty name="usuario" property="dni"/>"></td>
                            </tr>
                            <tr>
                                <td align="right">Codigo Postal:</td>
                                <td align="left"><input type="text" name="cp" required value="<jsp:getProperty name="usuario" property="cp"/>"></td>
                            </tr>
                            <tr>
                                <td align="right">Correo electrónico:</td>
                                <td align="left"><input type="text" name="email" required value="<jsp:getProperty name="usuario" property="email"/>"></td>
                            </tr>


                            <c:if test="${usuario.autonomo}">

                                <tr>
                                    <td align="right">Especialidad</td>
                                    <td align="left">
                                        <select name="tipo" class="cuadro" >
                                            <option>
                                                <jsp:getProperty name="usuario" property="especialidad"/>
                                            </option>
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
                                        </select></td>
                                </tr>
                                <tr>
                                    <td align="right">Descripcion</td>
                                    <td align="left"><textarea  required class="cuadro" rows="2" cols="20" name="descripcion"><jsp:getProperty name="usuario" property="descripcion"/></textarea></td>
                                </tr>
                                <tr>
                                    <td align="right">Telefono</td>
                                    <td align="left"><input required type="text" name="tlfn" value="<jsp:getProperty name="usuario" property="telefono"/>"></td>
                                </tr>
                            </c:if>
                            <tr>
                                <td align="right" rowspan="2"> Añadir foto :</td>
                                <td align="left" rowspan="2"><input type=file name="fotoUser" src="imagen?tipo=u&id=<jsp:getProperty name="usuario" property="username"/>"></td>
                            </tr>
                            <tr>
                                <td><br></td>
                                <td><br></td>
                            </tr>

                            
                            <tr>
                                <td colspan="2"> 
                                    <input type="submit" value="Guardar cambios" id="registraruser"></td>
                            </tr>
                        </table></form>
                </div>
            </div>
        </div>
        <%@include file="pie.jsp"%>
    </body>
</html>
