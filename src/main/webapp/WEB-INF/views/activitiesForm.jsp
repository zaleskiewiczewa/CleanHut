<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>

</style>
<body>


Activities
<form:form method="post" modelAttribute="activities" action="/activities/form">

    <p hidden><form:input path="id"/></p>

    <label for="activities">Activities</label>
    <form:input path="activities" id="qctivities"/>
    <form:errors path="activities" cssClass="activities"/>
    <br>

    <input type="submit" value="Save">
</form:form>

</body>
</html>