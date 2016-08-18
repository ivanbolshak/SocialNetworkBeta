<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Person Information</title>
</head>
<body>

<h2>Login By User NickName</h2>

<form action="/loginByNickName" method="get">
    <input type="nickname" placeholder="Enter user nickname" name="nickname">
    <input type="submit" name="sumbit" value="Get User Page">
</form>
<br>
<br>
<form action="/adduser" method="get">
    <table>
        <tr>
            <td>Nickname</td>
            <td><input type="text" placeholder="Enter user nickname" name="nickname"></td>
        </tr>
        <tr>
            <td>First name</td>
            <td><input type=text placeholder="Enter You first name" name="firstName"></td>
        </tr>
        <tr>
            <td>Last name</td>
            <td><input type="text" placeholder="Enter you last name" name="lastName"></td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td><input type="text" placeholder="Enter you birtday" name="birthday"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Registration">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="reset" value="Clean form">
            </td>
        </tr>

    </table>

</form>



</body>
</html>