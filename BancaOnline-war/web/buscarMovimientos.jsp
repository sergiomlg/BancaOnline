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
            .button {
            background-color: #4FAF50;
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            }
            .content-box-gray {
            background-color: #e2e2e2;
            border: 1px solid #bdbdbd;
            margin: 0 0 25px;
            overflow: hidden;
            padding: 20px;
            }
            
        </style>
        <h1>Buscar Movimientos</h1>
        <form action="BMovimientoServlet" method="post">
        Introduce el concepto que desea buscar: <input type ="content-box-gray" name="concepto"/>
        <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
