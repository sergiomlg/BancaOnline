<%-- 
    Document   : darAltaConfirmacion
    Created on : 19-abr-2018, 11:15:37
    Author     : W10
--%>

<%@page import="bancaonline.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    Usuario user=(Usuario) session.getAttribute("us");
    
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AltaConfirmacion</title>
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
    </body>
</html>
