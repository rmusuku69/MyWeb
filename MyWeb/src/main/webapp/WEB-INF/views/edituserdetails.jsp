<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form action="updateUserDetails" method="post" modelAttribute="details">

	<table>
	     <tr>
			<td>Id</td>
			<td>
				<form:input path="id" readonly="true" required="required"></form:input>
			</td>
			<td>
				<form:errors path="id" element="div"></form:errors>
			</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>
				<form:input path="name" required="required"></form:input>
			</td>
			<td>
				<form:errors path="name" element="div" ></form:errors>
			</td>
		</tr>

		<tr>
			<td>Email</td>
			<td>
				<form:input path="email" required="required"></form:input>
			</td>
			<td>
				<form:errors path="email" element="div"></form:errors>
			</td>
		</tr>
		<tr>
			<td>Mobile</td>
			<td>
				<form:input path="contact" required="required"></form:input>
			</td>
			<td>
				<form:errors path="contact" element="div" ></form:errors>
			</td>
		</tr>
		<tr>
			<td>Username</td>
			<td>
				<form:input path="username" required="required"></form:input>
			</td>
			<td>
				<form:errors path="username" element="div"></form:errors>
			</td>
		</tr>
		<tr>
			<td>password</td>
			<td>
				<form:input path="password" type="password" readonly="true" required="required"></form:input>
			</td>
			<td>
				<form:errors path="password" element="div"></form:errors>
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="Update"/></td>
		</tr>
	</table>
	
</form:form>