<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>Person Information</title>
</head>
<body>

<h2>Person information</h2>

<form:form method="post" action="/add">
	<table>
		<tr>
			<td> <form:label path="id">ID</form:label></td>
			<td> <form:input path="id"/></td>
		</tr>
		<tr>
			<td> <form:label path="firstName">First Name</form:label></td>
			<td> <form:input path="firstName"/></td>
		</tr>
		<tr>
			<td> <form:label path="lastName">Last Name</form:label></td>
			<td> <form:input path="lastName"/></td>
		</tr>
		<tr>
			<td> <form:label path="birthday">Birthday</form:label></td>
			<td> <form:input path="birthday"/></td>
		</tr>
		<tr>
			<td> <form:label path="nickname">Nickname</form:label></td>
			<td> <form:input path="nickname"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Submit"/>
			</td>
		</tr>
	</table>

</form:form>

</body>
</html>