<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>

</style>
<body>

Space
<form:form method="post" modelAttribute="space" action="/space/form">

    <p hidden><form:input path="id"/></p>

    <rooms for="rooms">Space</rooms>
    <form:input path="rooms" id="rooms"/>
    <form:errors path="rooms" cssClass="error"/>
    <br>
    
    <input type="submit" value="Save">
</form:form>

</body>
</html>