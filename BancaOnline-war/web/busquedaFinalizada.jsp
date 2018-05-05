<%-- 
    Document   : busquedaFinalizada
    Created on : 19-abr-2018, 11:22:10
    Author     : EzequielRodriguez
--%>
<%@page import="bancaonline.entity.Movimiento"%>

<%@page import="java.util.List"%>
<%
    List<Movimiento> resultado = (List<Movimiento>) request.getAttribute("movimientosEncontrados");
    
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%= resultado.size() %></h1>
    </body>
</html>
