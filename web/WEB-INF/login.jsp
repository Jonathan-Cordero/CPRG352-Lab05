<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="POST" action="">
            <label for="username">Username: </label>
            <input type="text"  name="username" value=${username}><br>
            <label for="password">Password: </label>
            <input type="password"  name="password" value=${password}><br>
            <input type="Submit" value="Login">
        </form>
            <p>${error}</p>
            <p>${logout}</p>
    </body>
</html>
