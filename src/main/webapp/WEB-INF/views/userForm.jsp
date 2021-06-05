<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body bgcolor="#20b2aa">
<h1 style="color: blueviolet">Users</h1>
<h2 STYLE="color: blue" >
<form:form method="post" modelAttribute="user" action="/user/form">

    <p hidden><form:input path="id"/></p>

    <label for="name">Name</label>
    <form:input path="name" id="name"/>
    <form:errors path="name" cssClass="name"/>
    <br>

    <label for="password">Password</label>
    <form:input path="password" id="password"/>
    <form:errors path="password" cssClass="password"/>
    <br>

    <label for="email">Email</label>
    <form:input path="email" id="email"/>
    <form:errors path="email" cssClass="email"/>
    <br>

    <form:select itemValue="id" itemLabel="name"
                 path="activities" items="${activities}"/>
    <br>



    <input type="submit" value="Save">
</form:form>
</h2>
</body>
</html>