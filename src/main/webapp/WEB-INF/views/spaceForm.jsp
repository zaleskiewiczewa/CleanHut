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

    <space for="space">Space</space>
    <form:input path="space" id="space"/>
    <form:errors path="space" cssClass="error"/>
    <br>
    
    <input type="submit" value="Save">
</form:form>

</body>
</html>