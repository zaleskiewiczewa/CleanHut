<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

Spaces
<table>
    <th>ID</th>
    <th>Data</th>
    <th>User</th>
    <th>Activities</th>
    <tr>
        <c:forEach items="${space}" var="space">
        <td>${space.id}</td>
        <td>${space.data}</td>
        <td>${space.user}</td>
            <td>${space.activities}</td>
        <td><a href="/space/room/${space.id}">Delete</a></td>
        <td><a href="form/${space.id}">Update</a></td>
    </tr>

    </c:forEach>
</table>

<a href="form">Add space</a>

</body>
</html>