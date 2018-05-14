<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de sesión</title>
    </head>
    <body>
        <h1>Inicio de sesión</h1>
        <form action="ValidarServlet" method="post">
            <input type="text" name="txtNombre" placeholder="Nombre de usuario"/><br/>
            <input type="password" name="txtPass" placeholder="Contraseña"/><br/>
            <input type="submit" value="Iniciar Sesión">
        </form>
    </body>
</html>
