<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body bgcolor="#20b2aa">

<h1 style="color: blueviolet">Dates</h1>
<h2 style="color:green">List of dates </h2>
<table>
    <th>Id</th>
    <th>Date</th>
    <th>Rooms</th>

    <tr>
        <c:forEach items="${data}" var="data">
        <td>${data.id}</td>
        <td>${data.dates}</td>
            <td> ${data.rooms}</td>

    </tr>

    </c:forEach>
</table>

<a href="form">Add data</a>

</body>
</html>