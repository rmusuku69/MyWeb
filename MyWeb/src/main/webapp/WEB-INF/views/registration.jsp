<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>registration</title>
</head>
<body>
<center>
<form:form action="registerVerify" method="post" modelAttribute="registrationDetails">
<table>
<tr><td>Name</td> <td><form:input path="name" required="required"/></td> <td><font color="red"><form:errors path="name" element="div"/></font></td></tr>
<tr><td>Email</td><td><form:input path="email" required="required"/></td> <td><font color="red"><form:errors path="email" element="div"/></font></td></tr>
<tr><td>Contact</td><td><form:input path="contact" required="required"/></td> <td><font color="red"><form:errors path="contact" element="div"/></font></td></tr>
<tr><td>Username</td><td><form:input path="username" required="required"/></td> <td><font color="red"><form:errors path="username" element="div"/></font></td></tr>
<tr><td>Password</td><td><form:input path="password" type="password" required="required"/></td> <td><font color="red"><form:errors path="password" element="div"/></font></td></tr>
</table>
<input type="submit" value="Submit"/>
</form:form>
</center>
</body>
</html>