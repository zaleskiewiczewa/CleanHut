<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
Data
<form:form method="post" modelAttribute="data" action="/data/form">

    <p hidden><form:input path="id"/></p>

    <label for="dates">Data</label>
    <form:input path="dates" id="dates"/>
    <form:errors path="dates" cssClass="error"/>
    <br>

    <input type="submit" value="Save">

</form:form>

</body>
</html>