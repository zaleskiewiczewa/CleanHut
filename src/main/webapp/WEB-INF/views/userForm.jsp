<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>


<form:form method="post" modelAttribute="user" action="/user/form">

    <p hidden><form:input path="id"/></p>

    <label for="name">Name</label>
    <form:input path="name" id="name"/>

    <br>

    <label for="password">Password</label>
    <form:input path="password" id="password"/>

    <br>

    <label for="email">Email</label>
    <form:input path="email" id="email"/>

    <br>

    <form:select itemValue="id" itemLabel="clean"
                 path="clean" items="${clean}"/>
    <br>

    <form:select itemValue="id" itemLabel="week" multiple="true"
                 path="week" items="${week}"/>


    <input type="submit" value="Save">
</form:form>

</body>
</html>