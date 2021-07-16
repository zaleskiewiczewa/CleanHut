<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<table>
    <th>Id</th>
    <th>Clean</th>


        <c:forEach items="${cleans}" var="clean">
    <tr>
        <td>${clean.id}</td>
        <td>${clean.cleaning}</td>
    </tr>

    </c:forEach>
</table>

<a href="/clean/form">Add cleans</a>


</html>