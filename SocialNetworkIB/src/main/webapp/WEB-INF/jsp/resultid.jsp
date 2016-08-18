<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Person Information Result</title>
</head>
<body>

<h2>Submitted Person Information</h2>
<table>
    <tr>
        <td>ID</td>
        <td>${id}</td>
    </tr>
    <tr>
        <td>First Name</td>
        <td>${first_name}</td>
    </tr>
    <tr>
        <td>Last Name</td>
        <td>${last_name}</td>
    </tr>
    <tr>
        <td>Birthday</td>
        <td>${birthday}</td>
    </tr>
    <tr>
        <td>NickName</td>
        <td>${nickname}</td>
    </tr>
</table>
</body>
</html>