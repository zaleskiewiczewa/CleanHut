<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    error {
        background-color: red;
    }
</style>
<body>


<form:form method="post" modelAttribute="room" action="/room/form">

    <p hidden><form:input path="id"/></p>

    <label for="room">Room</label>
    <form:input path="room" id="room"/>
    <form:errors path="room" cssClass="error"/>

    <br>

    <input type="submit" value="Save">
</form:form>

</body>
</html>