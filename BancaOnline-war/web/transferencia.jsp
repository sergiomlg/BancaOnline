<%-- 
    Document   : transferencia
    Created on : 19-abr-2018, 11:16:21
    Author     : EzequielRodriguez
--%>

<%@page import="bancaonline.entity.Cuenta"%>
<%@page import="bancaonline.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transferencias-PostuBank</title>
    </head>
    
    <style>
        body{
                background-color: lightblue; 
            }
    </style>
    
    <body>
        <ul>

            <li><a href="inicioUsuario.jsp">Inicio</a></li>
            <li><a href="login.html">Cerrar Sesi&oacute;n</a></li>
        </ul>
        
        <br/>
        
        <h1>Transferencias</h1>
        
        <form name="login" action="TransferenciaServlet" method="post">
        Numero de cuenta destino: <input type="text" name="cuentad"/>
        <br/>
        <br/>
        Saldo a transferir: <input type="text" name="saldo"/>
        <br/>
        <br/>
        Concept: <input type="text" name="concepto"/>
        <br/>
        <br/>
        <input type="submit" value="Enviar">
        </form>
    </body>
</html>
