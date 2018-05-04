<%-- 
    Document   : inicioTrabajador
    Created on : 19-abr-2018, 11:07:49
    Author     : W10
--%>
<%@page import="bancaonline.entity.Empleado"%>
<%
    Empleado e= (Empleado) session.getAttribute("empleado");
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <ul>
            
            <li><a href="inicioTrabajador.jsp">Inicio</a></li> 
            
            <li><a href="realizarApunte.jsp">Realizar Movimientos</a></li>
            <li><a href="darAlta.jsp">Dar de alta un nuevo usuario</a></li>
            <li><a href="login.html">Cerrar Sesi&oacute;n</a></li>
            
        
        
        </ul>
        
        <br/>
        <br/>
        
        <h1>Bienvenido, <%= e.getIdEmpleado() %></h1>
    </body>
</html>
