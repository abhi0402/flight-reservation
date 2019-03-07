<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
<h3>Login:</h3>
<font color="red">${msg }</font>
<form action="userLogin" method="post">
Email:<input type="text" name="email" /><br><br>
Password:<input type="password" name="password" /><br><br>
<input type="submit" value="Login">
</form>
</body>
</html>