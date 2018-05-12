    <%@page import="java.util.List"%>
<%-- 
    Document   : darAlta
    Created on : 19-abr-2018, 11:13:15
    Author     : W10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    List<String> errores = (List<String>)request.getAttribute("errores");
    
    String error= (String)request.getAttribute("error");

%>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dar de Alta</title>
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
    <li class="breadcrumb-item active" aria-current="page">Dar de alta</li>
  </ol>
</nav>
          <h1>Crear cliente nuevo</h1>
           <form name="login2" action="DarAltaServlet" method="post">
            <table>
                <tr>
                    <td>Usuario:</td>
                    <td><input type="text" name="user" max="30" maxlength="30"/></td>                    
                </tr>
                <tr>
                    <td>Contraseña:</td>
                    <td><input type="password" name="password" max="30" maxlength="30"/></td>
                </tr>
                 <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="name" max="30" maxlength="30"/></td>
                </tr>
                
                 <tr>
                    <td>Apellidos:</td>
                    <td><input type="text" name="apellidos" max="30" maxlength="30"/></td>
                </tr>
                 
                <tr>
                    <td>E-mail:</td>
                    <td><input type="text" name="email"/></td>                    
                </tr>
                <tr>
                    <td>Direccion:</td>
                    <td><input type="text" name="domicilio1"/>
                        
                </tr>                    
                </tr>
                 <tr>
                    <td>Fecha Nacimiento: (formato yyyy-mm-dd)</td>
                    <td><input type="text" name="fechaNac" max="30" maxlength="30"/></td>
                </tr>
                <tr>
                    <td>Telefono:</td>
                    <td><input type="text" name="telefono"/></td>                    
                </tr>
                <tr>
                    <td>Numero de cuenta:</td>
                    <td><input type="text" name="ncuenta"/></td>
                </tr>
              </table>
            <input type="submit" value="Enviar" />
              <% if(errores !=null){
                    for(String e : errores){%>
                <font color="red"> <%= e + "\n" %> </font>
                <% }}  %>
                
                <% if(error !=null){
                    for(String e : errores){%>
                <font color="red"> <%= e + "\n" %> </font>
                <% }}  %>
        </form>  
         <address>Tecnología de Aplicaciones Web.<br>
            Autores: Ezequiel Rodr&iacute;guez, Sergio Fern&aacute;ndez, Juan Fern&aacute;ndez, Ángel Fern&aacute;ndez</address>
        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    </body>
</html>
