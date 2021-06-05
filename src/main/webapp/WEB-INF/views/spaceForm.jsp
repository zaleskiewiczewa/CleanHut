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
    <form:errors path="rooms" cssClass="rooms"/>
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

    <input type="submit" value="Save">
</form:form>
</h2>
</body>
</html>