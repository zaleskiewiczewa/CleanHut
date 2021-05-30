<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

Users:
<table>
    <th>ID</th>
    <th>Data</th>
    <th>User</th>
    <th>Activities</th>
    <th>Delete</th>
    <th>Update</th>
    <tr>
        <c:forEach items="${user}" var="user">
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.password}</td>
        <td>${user.email}</td>
        <td><a href="/user/room/${user.id}">Delete</a></td>
        <td><a href="form/${user.id}">Update</a></td>
    </tr>

    </c:forEach>
</table>

<a href="form">Add user</a>

</body>
</html>