<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Person Information</title>
</head>
<body>

<h2>Congratulate, now you can login</h2>

<form action="/loginByNickName" method="get">
    <input type="nickname" placeholder="Enter user nickname" name="nickname">
    <input type="submit" name="sumbit" value="Get User Page">
</form>


</body>
</html>