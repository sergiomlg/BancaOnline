<%-- 
    Document   : inicioUsuario
    Created on : 19-abr-2018, 11:15:12
    Author     : EzequielRodriguez
--%>

<%@page import="bancaonline.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario user = (Usuario) session.getAttribute("user");
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INICIO - PostuBank</title>
    </head>
    
        <style>
        body{
                padding-left: 11em;
                background-color: lightblue; 
                font-family: Georgia, "Times New Roman",
          Times, serif;
                list-style-type: none;
                padding: 0;
                margin: 0;
            }
        h1 {
                font-family: Helvetica, Geneva, Arial,
                SunSans-Regular, sans-serif;
            } 
        ul {
                    position: absolute;
                    top: 2em;
                    right: 1em;
                    width: 10em
        }
        ul li {
                    background: white;
                    margin: 0.5em 0;
                    padding: 0.3em;
                    border-left: 1em solid black }
        ul a {
                    text-decoration: none }
        a:link {
                    color: blue }
        a:visited {
                    color: purple }

        </style>
    <body>
        <ul>
            
            <li><a href="inicioUsuario.jsp">Inicio</a></li>
            <li><a href="paginaCuenta.jsp">Cuenta</a></li>
            <li><a href="buscarMovimientos.jsp">Buscar Movimientos</a></li>
            <li><a href="transferencia.jsp">Transferencias</a></li>
            <li><a href="login.html">Cerrar Sesi&oacute;n</a></li>
            
        </ul>
        
        <br/>
        <br/>
        
        <h1>Bienvenido, <%= user.getName() %></h1>
        
       <img src="imagenes/imagenes.jpg" />
    </body>
</html>
