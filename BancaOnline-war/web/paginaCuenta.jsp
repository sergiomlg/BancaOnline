<%-- 
    Document   : paginaCuenta
    Created on : 19-abr-2018, 11:18:05
    Author     : EzequielRodriguez
--%>
<%@page import="bancaonline.entity.Usuario"%>
<%
    Usuario user=(Usuario) session.getAttribute("user");
    
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cuentas-PostuBank</title>
        <style>
        table, th, td {
        border: 1px solid black;
        }
     
        body{
                background-color: lightblue; 
                font-family: Georgia, "Times New Roman",
          Times, serif;
            }
        </style>
    </head>
    <body>
        <ul>

            <li><a href="inicioUsuario.jsp">Inicio</a></li>
            <li><a href="login.html">Cerrar Sesi&oacute;n</a></li>
        </ul>
        <br/>
        <h1>Cuentas</h1>
        <br/>
        
        <table style="width:35%">
            <tr>
                <th>Numero de Cuenta</th>
                <th>Saldo</th> 
                <th>Acciones</th>
            </tr>
            <tr>
                <td><%= user.getCuentaList().get(0).getIdIBAN() %></td>
                <td><%= user.getCuentaList().get(0).getSaldo() +" $" %></td>
                <td><a href="transferencia.jsp">Realizar Transferencia</a></td>
                </tr>
 
        </table>
                <h1>Numero de movimientos realizados: <%= user.getCuentaList().get(0).getMovimientoList().size() %></h1>
                <br/>
                <br/>
                <input type="button" value="Volver atrás" onclick="history.back()" >
    </body>
</html>
