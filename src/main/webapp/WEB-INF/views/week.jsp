<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

Week
<form:form method="post" modelAttribute="week" action="/week/form">

    <p hidden><form:input path="id"/></p>

    <label for="week">Week</label>
    <form:input path="week" id="week"/>
    <form:errors path="week" cssClass="error"/>
    <br>

    <input type="submit" value="Save">
</form:form>

</body>
</html>
