<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Person Information</title>
</head>
<body>

<h2>Person information</h2>

<form action="/findbyid" method="get">
    <input type="ID" placeholder="Enter user id" name="id">
    <input type="submit" name="sumbit" value="Get User Info">
</form>


</body>
</html>