<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>

</style>
<body>


Service
<form:form method="post" modelAttribute="service" action="/service/form">

    <p hidden><form:input path="id"/></p>

    <service for="service">Service</service>
    <form:input path="service" id="service"/>
    <form:errors path="service" cssClass="service"/>
    <br>

    <input type="submit" value="Save">
</form:form>

</body>
</html>