<%-- 
    Document   : BuscarMovimientos
    Created on : 19-abr-2018, 11:19:10
    Author     : EzequielRodriguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movimientos - PostuBank</title>
    </head>
    <body>
        <style>
            body{
                background-color: lightblue; 
            }
            
            input[type=text] {
            background-color: white;
}
            
        </style>
        
        <ul>
            <li><a href="inicioTrabajador.jsp">Inicio</a></li>
            <li><a href="login.jsp">Cerrar Sesi&oacute;n</a></li>
        </ul>
        
        <h1>Buscar Movimientos</h1>

        <form action="BMovimientoServlet" method="post">
        Introduce el concepto que desea buscar: <input type ="content-box-gray" name="concepto"/>
        <input type="submit" value="Enviar"/>

        </form>
    </body>
</html>
