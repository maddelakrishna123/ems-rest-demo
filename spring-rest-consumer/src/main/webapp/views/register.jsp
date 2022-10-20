<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management System - Rest Client</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="login-form">
${message}
<h1>Employee Management System - Rest Client</h1>

<div>
<h3>Registration Page</h3>
<form action="register" method="post">

<table>
<tr>
<td>Full Name</td>
<td><input type="text" name="name"></td>
</tr>


<tr>
<td>User Name</td>
<td><input type="text" name="username"></td>
</tr>

<tr>
<td>Password</td>
<td><input type="password" name="password"></td>
</tr>

<tr>
<td>Email</td>
<td><input type="email" name="email"></td>
</tr>

<tr>
<td>Mobile</td>
<td><input type="number" name="mobile"></td>
</tr>
<tr>
<td>Age</td>
<td><input type="number" name="age"></td>
</tr>

<tr>
<td>Salary</td>
<td><input type="number" name="salary"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="Register"></td>
</tr>
</table>



</form>

Do you have account ? <a href="login">login</a>
</div>
</div>
</body>
</html>