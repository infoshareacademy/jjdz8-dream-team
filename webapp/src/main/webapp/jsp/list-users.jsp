<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Nauczyciele</title></head>
<body>

<h2>Nauczyciele</h2>

    <jsp:useBean id="userList" scope="request" type="com.infoshareacademy.domain.Users"/>
    <c:choose>
        <c:when test="${not empty userList}">
            <table class="table table-striped">
                <thead>
                <tr>
<%--                    <td>id</td>--%>
                    <td>Name</td>
                    <td>Grade</td>
                </tr>
                </thead>
                <c:forEach var="user" items="${userList.users}">
                    <c:set var="classSucess" value=""/>
                    <c:if test="${idUser == user.id}">
                        <c:set var="classSucess" value="info"/>
                    </c:if>
                    <tr class="${classSucess}">
<%--                        <td>${user.id}</td>--%>
                        <td>${user.name}</td>
                        <td>${user.grade}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <br>
            <div class="alert alert-info">
                Nie ma takiego nauczyciela
            </div>
        </c:otherwise>
    </c:choose>
<form action="${pageContext.request.contextPath}/user" method="post" id="userForm" role="form">
    <br/>
    <button type="submit" class="btn btn-primary  btn-md">Nowy Nauczyciel</button>
</form>
</body>
</html>