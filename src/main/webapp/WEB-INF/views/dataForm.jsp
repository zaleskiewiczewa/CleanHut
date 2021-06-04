<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body bgcolor="#20b2aa">

<h1 style="color: blueviolet">Dates</h1>
<form:form method="post" modelAttribute="data" action="/data/form">
<h2 STYLE="color: blue" >

    <p hidden><form:input path="id"/></p>

    <label for="dates">Data</label>
    <form:input path="dates" id="dates"/>
    <form:errors path="dates" cssClass="error"/>
    <br>

    <label for="space">Choose space</label>
    <select id="space">
        <option value="B">Bathroom</option>
        <option value="K">Kitchen</option>
        <option value="R">Room 1</option>
        <option value="L">Living Room</option>
    </select>

    <input type="submit" value="Save">

</form:form>
</h2>
</body>
</html>