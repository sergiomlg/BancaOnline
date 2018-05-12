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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cuentas-PostuBank</title>
        <style>
        table, th, td {
        border: 1px solid black;
        }
     
        body{
                padding-left: 11em;
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
    </head>
    <body>
        <nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="inicioUsuario.jsp">Home</a></li>
    <li class="breadcrumb-item active" aria-current="page">Cuenta</li>
  </ol>
</nav>
        <ul>

            <li><a href="inicioUsuario.jsp">Inicio</a></li>
            <li><a href="login.jsp">Cerrar Sesi&oacute;n</a></li>
        </ul>
        <br/>
        <h1>Cuentas</h1>
        <br/>
        
        <table style="width:35%">
            <tr>
                <th>N&uacute;mero de Cuenta</th>
                <th>Saldo</th> 
                <th>Acciones</th>
            </tr>
            <tr>
                <td><%= user.getCuentaList().get(0).getIdIBAN() %></td>
                <td><%= user.getCuentaList().get(0).getSaldo() +" $" %></td>
                <td><a href="transferencia.jsp">Realizar Transferencia</a></td>
                </tr>
 
        </table>
                
                 <address>Tecnología de Aplicaciones Web.<br>
            Autores: Ezequiel Rodr&iacute;guez, Sergio Fern&aacute;ndez, Juan Fern&aacute;ndez, Ángel Fern&aacute;ndez</address>
                 
                 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    </body>
</html>
