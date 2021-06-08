<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<table>
    <th>Id</th>
    <th>Clean</th>

    <tr>
        <c:forEach items="${clean}" var="clean">
        <td>${clean.id}</td>
        <td>${clean.clean}</td>

    </tr>

    </c:forEach>
</table>

<a href="form">Add clean</a>


</html>