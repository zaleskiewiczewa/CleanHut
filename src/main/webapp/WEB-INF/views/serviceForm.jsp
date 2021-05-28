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

    <services for="services">Service</services>
    <form:input path="services" id="services"/>
    <form:errors path="services" cssClass="services"/>
    <br>

    <input type="submit" value="Save">
</form:form>

</body>
</html>