<%-- 
    Document   : darAlta
    Created on : 19-abr-2018, 11:13:15
    Author     : W10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <h1>Crear cliente nuevo</h1>
           <form action="DarAltaServlet" method="post">
            <table>
                <tr>
                    <td>Usuario:</td>
                    <td><input type="text" name="user" max="30" maxlength="30"/></td>                    
                </tr>
                <tr>
                    <td>Contraseña:</td>
                    <td><input type="text" name="password" max="30" maxlength="30"/></td>
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
                        
                    </td>                    
                </tr>
                 <tr>
                    <td>Fecha Nacimiento:</td>
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
        </form>             
    </body>
</html>
