<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>



        <form:form method="post" modelAttribute="cleaning" action="/cleaning/form">

            <p hidden><form:input path="id"/></p>

            <label for="cleaning">Cleaning</label>
            <form:input path="cleaning" id="cleaning"/>

            <br>

            <input type="submit" value="Save">
        </form:form>

</body>
</html>
