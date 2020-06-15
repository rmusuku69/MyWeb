<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.buttons { 
  width: 30%;
  table-layout: fixed;
}
.buttons input { 
  width: 30%;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="left">
<table class="buttons">

<tr><td><form action="/controller/"><input type="submit" value="Home"></form></td></tr>
<tr><td><form action="/controller/careers"><input type="submit" value="Careers"></form></td></tr>
<tr><td><form action="/controller/aboutus"><input type="submit" value="About Us"></form></td></tr>

</table>


</div>
</body>
</html>