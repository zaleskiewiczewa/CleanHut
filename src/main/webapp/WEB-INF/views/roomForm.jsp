<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form:form method="post" modelAttribute="room" action="/room/form">

    <p hidden><form:input path="id"/></p>

    <label for="room">Room</label>
    <form:input path="room" id="room"/>

    <br>

    <input type="submit" value="Save">
</form:form>

</body>
</html>