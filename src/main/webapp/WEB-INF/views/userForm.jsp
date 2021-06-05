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

    <form>
        <select name="space">
            <option value="B">Week 23</option>
            <option value="K">Week 24</option>
            <option value="R">Week 25</option>
            <option value="L">Week 26</option>
            <option value="M">Week 27</option>
            <option value="T">Week 28</option>
        </select>
    </form>

    <form>
        <select name="space">
            <option value="B">Bathroom</option>
            <option value="K">Kitchen</option>
            <option value="R">Room 1</option>
            <option value="L">Living Room</option>
            <option value="M">Corridor</option>
        </select>
    </form>
    <input type="submit" value="Save">
</form:form>
</h2>
</body>
</html>