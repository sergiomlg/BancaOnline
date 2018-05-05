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
        <title>JSP Page</title>
    </head>
    
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
