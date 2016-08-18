<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h3>All users in Data Base</h3>

<c:if test="${not empty lists}">
    <ul>
        <c:forEach var="obj" items="${lists}">
            <li>${obj.firstName}</li>
            <li>${obj.lastName}</li>
            <li>${obj.nickname}</li>
            <br>
        </c:forEach>
    </ul>
</c:if>

</body>
</html>