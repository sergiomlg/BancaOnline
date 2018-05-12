<%-- 
    Document   : realizarApunte
    Created on : 19-abr-2018, 11:16:48
    Author     : W10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String mensaje = (String)request.getAttribute("mensaje"); %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Realizar Apunte-PostuBank</title>

    </head>
     <style>
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
    <body>
        <nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="inicioTrabajador.jsp">Home</a></li>
    <li class="breadcrumb-item active" aria-current="page">Realizar Apunte</li>
  </ol>
</nav>
        <h1>Realizar apunte</h1>
        <form name="apuntes" action="RealizarApunteServlet" method="post">
            </br>
            </br>
            
            <table>
                <tr>
                    <td>Numero de cuenta:</td>
                    <td> <input type="text" name="cuentad"/></td>
                </tr>
                <tr>
                    <td> Saldo a transferir(Introduzca delante un (-) si desea quitar dinero:</td>
                    <td> <input type="text" name="saldo"/></td>
                </tr>
                <tr>
                    <td>Concepto: </td>
                    <td><input type="text" name="concepto"/></td>
                </tr>               
            </table>
            
        
            <input type="submit" value="Enviar">
            <input type="button" value="Volver atrás" onclick="history.back()" >
        </form>
        <% if(mensaje != null){ %>
         <font color="red"><%= mensaje.toString() %></font>
        <% } %>
        <address>Tecnología de Aplicaciones Web.<br>
            Autores: Ezequiel Rodr&iacute;guez, Sergio Fern&aacute;ndez, Juan Fern&aacute;ndez, Ángel Fern&aacute;ndez</address>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    </body>
</html>
