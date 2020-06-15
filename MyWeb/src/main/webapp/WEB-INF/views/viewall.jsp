<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p><i>${msg}</i></p>
<table border="1" cellpadding="10" cellspacing="">
	<tr>
		<th>EmpID</th>
		<th>Name</th>
		<th>Email</th>
		<th>Mobile</th>
		<th>Username</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach items="${list}" var="emp">
		<tr>
			<td>${emp.id}</td>
			<td>${emp.name}</td>
			<td>${emp.email}</td>
			<td>${emp.contact}</td>
			<td>${emp.username}</td>
			<td><a href="showEditUserDetails?id=${emp.id}">Edit</a></td>
			<td><a href="deleteUser?id=${emp.id}">Delete</a></td>
		</tr>
	</c:forEach>
</table>