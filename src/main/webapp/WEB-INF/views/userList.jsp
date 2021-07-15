<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>


<table>
    <th>Id</th>
    <th>Data</th>
    <th>Name</th>
    <th>Password</th>
    <th>Email</th>
    <tr>
        <c:forEach items="${user}" var="user">
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.password}</td>
        <td>${user.email}</td>
    </tr>

    </c:forEach>
</table>

<a href="form">Add user</a>


</html>