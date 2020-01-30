<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Iniciar Sesion</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <script type="text/javascript" src="validaciones.js"></script>
    </head>
    <body>
        <%@include file="cabecera.jsp"%>
        <div id="cuerpo">
            <div id="contenidoLogin">
                <form action="logeo" method="post">
                    <table id="formulario">
                        <thead>
                        <caption id="tituloLogin">Iniciar Sesion</caption>
                        </thead>
                        <tbody>
                            <tr>
                                <td align="right" colspan="2">
                                    <label >Usuario: </label><input id="user" name="usuario" type="text"></td>

                            </tr>

                            <tr>
                                <td align="right" colspan="2"><label  >Contrañesa: </label><input id="pass" name="pwd" type="password"></td>
                            </tr>

                            <tr id="botones">
                                <td align="right"  colspan="1">
                                    <p></p>
                                    <input type="submit" id="iniciar"  value="Iniciar sesion"><input  type="reset" value="Limpiar">
                                </td>
                            </tr>

                            <tr >
                                <td align="left" id="registrarse"><a href="registrar_autonomo.jsp">Alta autonomo</a></td>
                                <td align="right" id="registrarse"><a href="registrar_user.jsp">Registrarse</a></td>

                            </tr>


                        </tbody>

                    </table>
                </form>
                <div id="loginfail">
					<p></p>
                </div>
            </div>
        </div>
        <%@include file="pie.jsp"%>
    </body>
</html>
