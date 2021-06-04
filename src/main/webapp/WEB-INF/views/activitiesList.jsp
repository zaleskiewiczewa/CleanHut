<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body bgcolor="#20b2aa">
<h1 style="color: blueviolet">Activities</h1>
<h2 style="color:green">List of activities </h2>
<table>
    <th>Id</th>
    <th>Activities</th>
    <th>Delete</th>
    <th>Update</th>
    <tr>
        <c:forEach items="${activities}" var="activities">
        <td>${activities.id}</td>
        <td>${activities.activities}</td>
        <td><a href="/activities/room/${activities.id}">Delete</a></td>
        <td><a href="form/${activities.id}">Update</a></td>
    </tr>

    </c:forEach>
</table>

<a href="form">Add activities</a>

</body>
</html>