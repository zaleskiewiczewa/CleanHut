<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>


<table>
    <th>Id</th>
    <th>Week</th>
    <th>Room</th>
    <th>Password</th>
    <th>Email</th>

    <tr>
        <c:forEach items="${week}" var="week">
        <td>${week.id}</td>
        <td>${week.week}</td>
        <td>${week.name}</td>

    </tr>

    </c:forEach>
</table>

<a href="form">Add week</a>


</html>