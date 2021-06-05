<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body bgcolor="#20b2aa">
<h1 style="color: blueviolet">Rooms</h1>
<h2 style="color:green">List of rooms </h2>
<table>
    <th>Id</th>
    <th>Rooms</th>
    <th>Dates</th>
    <th>Delete</th>
    <th>Update</th>
    <tr>
        <c:forEach items="${rooms}" var="rooms">
        <td>${rooms.id}</td>
        <td>${rooms.rooms}</td>
            <td>${rooms.data}</td>
        <td><a href="/rooms/room/${rooms.id}">Delete</a></td>
        <td><a href="form/${rooms.id}">Update</a></td>
    </tr>

    </c:forEach>
</table>

<a href="form">Add rooms</a>


</body>
</html>