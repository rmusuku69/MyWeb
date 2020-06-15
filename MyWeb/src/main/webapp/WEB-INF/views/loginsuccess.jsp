<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>success</title>
</head>
<body>

<h2>Hi  ${arraylist[0]} ...! Welcome</h2>
<table>
<tr><td><b>Name&nbsp;&nbsp;&nbsp;:</b></td> <td>${arraylist[0]}</td></tr>
<tr><td><b>Email&nbsp;&nbsp;:</b></td><td>${arraylist[1]}</td></tr>
<tr><td><b>Contact:</b></td><td>${arraylist[2]}</td></tr>
<tr><td><a href="viewall">View All Employees</a>
</table>

<p>Search For User Details :</p>	
		<form:form action="${pageContext.request.contextPath}/search"
			method="post" modelAttribute="search">
			<table border="0" cellpadding="10" cellspacing="">
				<tr>
					<td>Search :</td>
					<td><form:input path="searchParam" required="required"/></td>
					<td>
						<form:select path="searchCriteria" required="required">
							<form:option value="" label="--- Select ---" />
							<form:options items="${fields}" />
						</form:select>
					</td>
				</tr>
				<tr>
					<td colspan="1" align="right"><input type="submit"
						value="Search" /></td>
					<td><input type="reset" value="Reset" /></td>
				</tr>

			</table>
		</form:form>
</body>
</html>