<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>

</style>
<body>


Data
<form:form method="post" modelAttribute="data" action="/data/form">

    <p hidden><form:input path="id"/></p>

    <data for="data">Data</data>
    <form:input path="data" id="data"/>
    <form:errors path="data" cssClass="error"/>
    <br>

</form:form>

</body>
</html>