<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register User</title>
</head>
<body>
<h3>User Registration</h3>
<form action="registerUser" method="post">
First Name:<input type="text" name="firstName" /><br><br>
Last Name:<input type="text" name="lastName" /><br><br>
Email:<input type="email" name="email" /><br><br>
Password:<input type="password" name="password" /><br><br>
Confirm Password:<input type="password" name="confirmPassword" /><br><br>
<input type="submit" value="Register">
</form>

</body>
</html>