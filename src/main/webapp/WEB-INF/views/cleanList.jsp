<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<table>
    <th>Id</th>
    <th>Clean</th>


        <c:forEach items="${cleans}" var="clean">
    <tr>
        <td>${cleans.id}</td>
        <td>${cleans.clean}</td>
    </tr>

    </c:forEach>
</table>

<a href="form">Add cleans</a>


</html>