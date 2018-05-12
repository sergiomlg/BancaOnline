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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio - PostuBank</title>
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
            
            ul.navbar {
                list-style-type: none;
    padding: 0;
    margin: 0;
    position: absolute;
    top: 2em;
    left: 1em;
    width: 9em }
            ul.navbar li {
    background: white;
    margin: 0.5em 0;
    padding: 0.3em;
    border-right: 1em solid black }
  ul.navbar a {
    text-decoration: none }
  a:link {
    color: blue }
  a:visited {
    color: purple }
    </style>
    <body>
        <nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item active" aria-current="page">Home</li>
  </ol>
</nav>
        <h1>Bienvenido, <%= e.getIdEmpleado() %></h1>
        <ul>
            
            <li><a href="inicioTrabajador.jsp">Inicio</a></li> 
            <li><a href="realizarApunte.jsp">Realizar Apunte</a></li>
            
            <li><a href="darAlta.jsp">Dar de alta un nuevo usuario</a></li>
            <li><a href="login.jsp">Cerrar Sesi&oacute;n</a></li>
            
        
        
        </ul>
        
        <br/>
        <br/>
        
        
        <img src="imagenes/imagenes.jpg" />
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    </body>
     <address>Tecnología de Aplicaciones Web.<br>
            Autores: Ezequiel Rodr&iacute;guez, Sergio Fern&aacute;ndez, Juan Fern&aacute;ndez, Ángel Fern&aacute;ndez</address>
</html>
