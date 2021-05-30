<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

Dates:
<table>
    <th>ID</th>
    <th>Date</th>
    <th>Delete</th>
    <th>Update</th>
    <tr>
        <c:forEach items="${data}" var="data">
        <td>${data.id}</td>
        <td>${data.dates}</td>
        <td><a href="/data/room/${data.id}">Delete</a></td>
        <td><a href="form/${data.id}">Update</a></td>
    </tr>

    </c:forEach>
</table>

<a href="form">Add data</a>

</body>
</html>