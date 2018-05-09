<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>PostuBank</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            body{
                padding-top: 200px;
                width: 200px;
                margin: 0 auto;
                background-color: lightblue; 
            }
            form {
              margin: auto;
              width: 70%;
              max-width: 500px;
              background: #f0f0f5;
              padding: 40px;
              border: 1px solid rgba(0,0,0,0.2);
            }
            
           
            
        </style>
        
        
            
    </head>
    
    <body>
        
        <form name="transferencia" action="LoginServlet" method="post">
        
        Usuario: <input type="text" name="usuario"/>
        <br/>
        <br/>
        Contrase&ntilde;a: <input type="password" name="contra"/>
        <br/>
        <br/>
        <input type="submit" value="Enviar">
        <br/>
        <font color="red">Usuario o contraseña erróneo!</font>
        </form>
    </body>
</html>

