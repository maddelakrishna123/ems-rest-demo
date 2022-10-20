<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management System - Rest Client</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="header">

<h1 class="title">Employee Management System - Rest Client</h1>
</div>
<div class="login-form">
<h4 class="error">${errMsg}</h4>
<h3>Login Page</h3>
<form action="login" method="post">

<table>
<tr>
<td>User Name</td>
<td><input type="text" name="username"></td>
</tr>

<tr>
<td>Password</td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="Login"></td>
</tr>
</table>



</form>

Not Registered Yet? <a href="register">Create account here</a>
</div>

</body>
</html>