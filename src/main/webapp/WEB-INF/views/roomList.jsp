<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<table>
    <th>Id</th>
    <th>Room</th>

    <tr>
        <c:forEach items="${room}" var="rooms">
        <td>${rooms.id}</td>
        <td>${rooms.rooms}</td>

    </tr>

    </c:forEach>
</table>

<a href="form">Add room</a>


</html>