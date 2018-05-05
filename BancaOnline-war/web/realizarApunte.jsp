<%-- 
    Document   : realizarApunte
    Created on : 19-abr-2018, 11:16:48
    Author     : W10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Realizar Apunte-PostuBank</title>

    </head>
    <style>
        body{
                background-color: lightblue; 
            }
    </style>
    <body>
        <h1>Realizar apunte</h1>
        <form name="apuntes" action="RealizarApunteServlet" method="post">
            Numero de cuenta: <input type="text" name="cuentad"/>
            <br/>
            <br/>
            Saldo a transferir: <input type="text" name="saldo"/>
            <br/>
            <br/>
            Concepto: <input type="text" name="concepto"/>
            <br/>
            <br/>
            <input type="submit" value="Enviar">
            <input type="button" value="Volver atrás" onclick="history.back()" >
        </form>
    </body>
</html>
