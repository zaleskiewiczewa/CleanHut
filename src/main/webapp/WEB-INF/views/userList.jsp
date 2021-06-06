<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body bgcolor="#20b2aa">
<h1 style="color: blueviolet">Users</h1>
<h2 STYLE="color: blue" >List of users</h2>
<table>
    <th>Id</th>
    <th>Data</th>
    <th>Name</th>
    <th>Password</th>
    <th>Email</th>

    <tr>
        <c:forEach items="${user}" var="users">
        <td>${users.id}</td>
        <td>${users.name}</td>
        <td>${users.password}</td>
        <td>${users.email}</td>

    </tr>

    </c:forEach>
</table>

<a href="form">Add user</a>

</body>
</html>