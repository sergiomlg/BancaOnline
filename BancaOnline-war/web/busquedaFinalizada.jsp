<%-- 
    Document   : busquedaFinalizada
    Created on : 19-abr-2018, 11:22:10
    Author     : EzequielRodriguez
--%>
<%@page import="org.apache.jasper.tagplugins.jstl.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="bancaonline.entity.Movimiento"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <%
        List<Movimiento> movimientos = (List<Movimiento>) request.getAttribute("movimientosEncontrados");
        
     %>
            
    <body>

        <ul>
            <li><a href="inicioUsuario.jsp">Inicio</a></li>
            <li><a href="login.html">Cerrar Sesi&oacute;n</a></li>
        </ul>
        
        
        <%for(Movimiento m : movimientos){
            
        %>
            
        <h1>Movimiento <%= m .getConcepto()%> encontrado</h1>
        
        <table border="1">
            <tr>
                <th>Id Movimiento</th>
                <th><%= m.getIdCodigo().toString() %></th>
            </tr>
            
            <tr>
                <th>Fecha </th>
                <th><%= m.getFecha().toString() %></th>
            </tr>
            
            <tr>
                <th>Concepto</th>
                <th><%= m.getConcepto() %></th>
            </tr>
            
            <tr>
                <th>Cantidad</th>
                <th><%= m.getCantidad().toString() %></th>
            </tr>
            
            <tr>
                <th>IBAN </th>
                <th><%= m.getIban().getIdIBAN() %></th>
            </tr>
            
        </table>
        
        
        
        <%
        } %>
        

    </body>
</html>
