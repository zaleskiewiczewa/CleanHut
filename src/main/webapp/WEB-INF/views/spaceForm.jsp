<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body bgcolor="#20b2aa">
<h1 style="color: blueviolet">Spaces/rooms</h1>
<h2 STYLE="color: blue" >
<form:form method="post" modelAttribute="space" action="/space/form">

    <p hidden><form:input path="id"/></p>

    <label for="rooms">Space</label>
    <form:input path="rooms" id="rooms"/>
    <form:errors path="rooms" cssClass="error"/>
    <br>

    <input type="submit" value="Save">
</form:form>
</h2>.
</body>
</html>