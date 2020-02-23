<%@ page contentType="text/html; UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<html>

<head>

</head>

<body>

<table>
    <td>ID</td>
    <td>Name</td>
    <td>Age</td>

    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
        </tr>
    </c:forEach>
</table>

<f:form method="post" modelAttribute="user">
    <f:input path="name"/>
    <f:input path="age"/>
</f:form>
</body>
</html>