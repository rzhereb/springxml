<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>

</head>

<body>

<table border="1">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Age</td>
    </tr>
    <c:forEach items="${userList}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.age}</td>
        </tr>
    </c:forEach>
</table>

<form:form method="post" modelAttribute="user">
    <table>
        <tr>
            <td><spring:message text="Name"/></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><spring:message text="Age"/></td>
            <td><form:input path="age"/></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="Add User"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>