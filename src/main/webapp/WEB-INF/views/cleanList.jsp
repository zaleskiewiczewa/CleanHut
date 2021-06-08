<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<table>
    <th>Id</th>
    <th>Cleaning</th>

    <tr>
        <c:forEach items="${cleaning}" var="cleaning">
        <td>${cleaning.id}</td>
        <td>${cleaning.cleaning}</td>

    </tr>

    </c:forEach>
</table>

<a href="form">Add cleaning</a>


</html>