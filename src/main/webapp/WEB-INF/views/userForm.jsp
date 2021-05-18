<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>

</style>
<body>

{
background-color: black;
color: white;
}
Author
<form:form method="post" modelAttribute="users" action="/user/form">

    <p hidden><form:input path="id"/></p>

    <label for="login">Login</label>
    <form:input path="login" id="login"/>
    <form:errors path="login" cssClass="error"/>
    <br>

    <label for="password">Password</label>
    <form:input path="password" id="password"/>
    <form:errors path="password" cssClass="error"/>
    <br>

    <label for="email">Email</label>
    <form:input path="email" id="email"/>
    <form:errors path="email" cssClass="error"/>
    <br>
    <input type="submit" value="Save">
</form:form>

</body>
</html>