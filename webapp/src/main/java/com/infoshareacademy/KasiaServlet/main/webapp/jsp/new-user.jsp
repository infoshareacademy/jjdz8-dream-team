<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

</head><
<body>
<div class="container">
    <form action="/user" method="post"  role="form" data-toggle="validator" >
        <c:if test ="${empty action}">
            <c:set var="action" value="add"/>
        </c:if>
        <input type="hidden" id="action" name="action" value="${action}">
        <input type="hidden" id="idUser" name="idUser" value="${user.id}">
        <h2>Dodaj ocene</h2>
        <div>

            <label for="name">Name:</label>
            <input type="text" name="name" id="name" class="form-control" value="${user.name}" required="true" />

            <label for="grade">Grade:</label>
            <input type="text" name="grade" id="grade" class="form-control" value="${user.grade}" required="true"/>


            <br></br>
            <button type="submit" class="btn btn-primary  btn-md">Accept</button>
        </div>
    </form>
</div>
</body>
</html>