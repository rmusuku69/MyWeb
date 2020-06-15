<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<body>

<center>
<p><font color="red">${msg}</font></p>
<form action="login" method="post">
<table>
<tr><td>Username</td> <td><input name="username" type="text" required/></td></tr>
<tr><td>Password</td> <td><input name="password" type="password" required/></td></tr>
<tr><td><input type="submit" value="Submit" /></td></tr>
</table>
</form>
</center>

</body>
</html>