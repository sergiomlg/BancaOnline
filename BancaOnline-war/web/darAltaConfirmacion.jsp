<%-- 
    Document   : darAltaConfirmacion
    Created on : 19-abr-2018, 11:15:37
    Author     : W10
--%>

<%@page import="bancaonline.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    Usuario user=(Usuario) request.getAttribute("us");
    
    %>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AltaConfirmacion</title>
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
        <ul>
            <li><a href="inicioTrabajador.jsp">Inicio</a></li>
            <li><a href="login.html">Cerrar Sesi&oacute;n</a></li>
        </ul>
        <h1> Confirmacion del Alta </h1>
        
        
        <table style="width:35%">
            <tr>
                <th>Numero de Cuenta</th>
                <th><%= user.getCuentaList().get(0).getIdIBAN()%></th>
            </tr>
            <tr>
                <td>Usuario</td>
                <td><%= user.getIdUsuario()%></td>
            </tr>
            <tr>
                <td>Contraseña</td>
                <td><%= user.getPassword()%></td>
                
            </tr>
            
            <tr>
                <td>Nombre</td>
                <td><%= user.getName()%></td>
                
            </tr>
            
            <tr>
                <td>Apellidos</td>
                <td><%= user.getSurname()%></td>
                
            </tr>
            <tr>
                <td>Fecha de nacimiento</td>
                <td><%= user.getFechaNac().toString()%></td>
                
            </tr>
            <tr>
                <td>Direccion</td>
                <td><%= user.getDireccion()%></td>
                
            </tr>
            <tr>
                <td>Telefono</td>
                <td><%= user.getTlf().toString()%></td>
                
            </tr>
            <tr>
                <td>Correo electronico</td>
                <td><%= user.getEmail()%></td>
                
            </tr>
 
        </table>
                <a href="inicioTrabajor.jsp">Volver al inicio</a>
                
                 <address>Tecnología de Aplicaciones Web.<br>
            Autores: Ezequiel Rodr&iacute;guez, Sergio Fern&aacute;ndez, Juan Fern&aacute;ndez, Ángel Fern&aacute;ndez</address>
                
                
                
                <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    </body>
</html>
