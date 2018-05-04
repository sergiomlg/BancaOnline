<%-- 
    Document   : paginaCuenta
    Created on : 19-abr-2018, 11:18:05
    Author     : EzequielRodriguez
--%>
<%@page import="bancaonline.entity.Usuario"%>
<%
    Usuario user=(Usuario) session.getAttribute("user");
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%=  user.getCuentaList().get(0).getIdIBAN() %></h1>
    </body>
</html>
