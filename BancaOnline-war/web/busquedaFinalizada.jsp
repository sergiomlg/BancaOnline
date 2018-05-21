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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busqueda Finalizada</title>
    </head>
    
    <style>
        body{
                background-color: lightblue; 
                font-family: Georgia, "Times New Roman",
          Times, serif;
            }
            
            h1{
                font-family: Helvetica, Geneva, Arial,
          SunSans-Regular, sans-serif;
            }
            address {
    margin-top: 1em;
    padding-top: 1em;
    border-top: thin dotted }
    </style>
    <%
        List<Movimiento> movimientos = (List<Movimiento>) request.getAttribute("movimientosEncontrados");
        
     %>
            
    <body>

        <ul>
            <li><a href="inicioUsuario.jsp">Inicio</a></li>
            <li><a href="login.jsp">Cerrar Sesi&oacute;n</a></li>
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
                <th>Cuenta Destino </th>
                <% if(m.getCuenta()==null){ %>
                    <th><%= m.getIban().getIdIBAN() %></th>
                <% } else { %>
                    <th>PostuBank</th>
                <% } %>
            </tr>
            
        </table>
        
        
        
        <%
        } %>
        
 <address>Tecnología de Aplicaciones Web.<br>
            Autores: Ezequiel Rodr&iacute;guez, Sergio Fern&aacute;ndez, Juan Fern&aacute;ndez, Ángel Fern&aacute;ndez</address>
        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    </body>
</html>
