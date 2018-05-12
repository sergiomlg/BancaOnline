<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<% 
    String error= (String)request.getAttribute("error");
%>
<html>
    
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <title>PostuBank</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            body{
                
                background-color: lightblue; 
                font-family: Georgia, "Times New Roman",
          Times, serif;
            }
            form {
              margin: auto;
              width: 70%;
              max-width: 500px;
              background: #f0f0f5;
              padding: 40px;
              border: 1px solid rgba(0,0,0,0.2);
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
        
        
            
    </head>
    <body class="text-center">
    <form class="form-signin" name="login" action="LoginServlet" method="post">
      <img class="mb-4" src="imagenes/imagenes.jpg" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Introduce tus datos</h1>
      <label for="inputEmail" class="sr-only">Usuario</label>
      <input type="text" name="usuario" class="form-control" placeholder="Usuario"/>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" name="contra" class="form-control" placeholder="Password" required=""/>
      <button class="btn btn-lg btn-primary btn-block" type="submit" value="Enviar">Sign in</button>
      <% if(error !=null){ %>
      <font color="red">Usuario o contraseña err&oacute;neo!</font>
        <% }  %>
      <p class="mt-5 mb-3 text-muted">© 2017-2018</p>
    </form>
  
    
  
        
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    </body>
</html>

