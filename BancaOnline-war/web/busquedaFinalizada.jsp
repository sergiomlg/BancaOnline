<%-- 
    Document   : busquedaFinalizada
    Created on : 19-abr-2018, 11:22:10
    Author     : EzequielRodriguez
--%>

<%@page import="bancaonline.entity.Movimiento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
        Movimiento mov = (Movimiento) session.getAttribute("movimiento");
        
     %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <style>
        body{
                background-color: lightblue; 
            }
    </style>      
    <body>
        
        <ul>
            <li><a href="inicioTrabajador.jsp">Inicio</a></li>
            <li><a href="login.html">Cerrar Sesi&oacute;n</a></li>
        </ul>
        
        
        <h1>Movimiento <%= mov .getConcepto()%> encontrado</h1>
        
        <table>
            <tr>
                <th>Id Movimiento</th>
                <th><%= mov.getIdCodigo().toString() %></th>
            </tr>
            
            <tr>
                <th>Fecha </th>
                <th><%= mov.getFecha().toString() %></th>
            </tr>
            
            <tr>
                <th>Concepto</th>
                <th><%= mov.getConcepto() %></th>
            </tr>
            
            <tr>
                <th>Cantidad</th>
                <th><%= mov.getCantidad().toString() %></th>
            </tr>
            
            <tr>
                <th>IBAN </th>
                <th><%= mov.getIban().getIdIBAN() %></th>
            </tr>
            
        </table>
    </body>
</html>
