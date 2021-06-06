<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body bgcolor="#20b2aa">
<h1 style="color: blueviolet">Space</h1>
<h2 style="color:green">List of rooms </h2>
<table>
    <th>Id</th>
    <th>Space</th>

    <tr>
        <c:forEach items="${space}" var="rooms">
        <td>${rooms.id}</td>
        <td>${rooms.rooms}</td>

    </tr>

    </c:forEach>
</table>

<a href="form">Add space</a>

</body>
</html>