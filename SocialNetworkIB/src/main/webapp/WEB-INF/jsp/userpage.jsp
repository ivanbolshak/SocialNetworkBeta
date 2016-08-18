<%--<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Person Page</title>
</head>
<body>

<h2>Person Page</h2>
<table>
   <form method="get" action="/logout">
       <input type="submit" value="Log Out">
   </form>
    <tr>
        <td>NickName: </td>
        <td>${nickname}</td>
    </tr>

    <tr>
        <td>First Name: </td>
        <td>${first_name}</td>
    </tr>
    <tr>
        <td>Last Name: </td>
        <td>${last_name}</td>
    </tr>
    <tr>
        <td>Birthday: </td>
        <td>${birthday}</td>
    </tr>

</table>
    <%----------------------------------    --%>
    <%-----------------------------------------%>

    <c:if test="${not empty usersPosts}">

        <ul>
            <c:forEach var="obj" items="${usersPosts}">
                <form action="/deletepost" method="get">
                <br>----------------------
                <br> Post title<br>
                <li>${obj.title}</li>
                <br> Post content<br>
                <li>${obj.content}</li>

                    <input type="hidden" name="postid" value="${obj.id}" >
                    <input type="hidden" name="nickname" value=${nickname} >
                    <input type="submit" value="Delete post">
                </form>
                <br>
            </c:forEach>
        </ul>
    </c:if>

<br>
-----------------------------<br>
Add new post
<br>
<form action="/addpost" method="get">
    <table>
        <tr>
            <td>Title</td>
            <td><input type="text" placeholder="title" name="postTitle"> </td>
        </tr>
        <tr>
            <td>Contetnt</td>
            <td><input type="text" width="20" placeholder="content" name="postContent"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Create new post"></td>

        </tr>


    </table>
    <input type="hidden" name="nickname" value=${nickname}>

</form>

</body>
</html>