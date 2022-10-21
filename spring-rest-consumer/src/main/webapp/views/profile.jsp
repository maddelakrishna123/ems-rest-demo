<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMS -Portal</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="header">

<div class="menus">
<span class="user-username">Welcome , ${username}</span>
<ul>
<li> <a href="userhome">Home</a> </li>
  <li> <a href="profile">View Profile</a> </li>
  <li> <a href="logout">Logout</a> </li>
</ul>
</div>


</div>
hello ${emp}

<div class="login-form">
<form:form action="profile" method="post" modelAttribute="emp">

<table>
<form:input type="hidden" path="id"/>
<tr>
<td>Full Name</td>
<td><form:input path="name"/></td>
</tr>


<tr>
<td>User Name</td>
<td><form:input path="username" readonly="true"/></td>
</tr>

<tr>
<td>Password</td>
<td><form:input type="password" path="password" readonly="true"/></td>
</tr>

<tr>
<td>Email</td>
<td><form:input path="email"/></td>
</tr>

<tr>
<td>Mobile</td>
<td><form:input path="mobile"/></td>
</tr>
<tr>
<td>Age</td>
<td><form:input type="number" path="age"/></td>
</tr>

<tr>
<td>Salary</td>
<td><form:input type="number"  path="salary"/></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="Update"></td>
</tr>
</table>



</form:form>

</div>

</body>
</html>