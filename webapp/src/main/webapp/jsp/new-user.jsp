<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Add user grade</title>
</head>
<body>
<div class="container">
    <form action="${pageContext.request.contextPath}/user" method="post" role="form" data-toggle="validator">
        <c:if test="${empty action}">
            <c:set var="action" value="add"/>
        </c:if>
        <h2>Dodaj ocene</h2>
        <div>

            <label for="name">Name:</label>
            <input type="text" name="name" id="name" class="form-control" required="true"/>

            <label for="grade">Grade:</label>
            <input type="text" name="grade" id="grade" class="form-control" required="true"/>

            <input type="hidden" id="action" name="action" value="${action}">

            <br/>
            <br/>
            <button type="submit" class="btn btn-primary  btn-md">Accept</button>
        </div>
    </form>
</div>
</body>
</html>