<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

</head>

<body>

    <h2>Nauczyciele2</h2>


    <form action="/user" method="post" id="userForm" role="form" >
        <c:choose>
            <c:when test="${not empty userList}">
                <table  class="table table-striped">
                    <thead>
                    <tr>
                        <td>id</td>
                        <td>Name</td>
                        <td>Grade</td>

                    </tr>
                    </thead>
                    <c:forEach var="user" items="${userList}">
                        <c:set var="classSucess" value=""/>
                        <c:if test ="${idUser == user.id}">
                            <c:set var="classSucess" value="info"/>
                        </c:if>
                        <tr class="${classSucess}">
                            <td>${user.id}</td>
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
    </form>
    <form action ="jsp/new-user.jsp">
        <br></br>
        <button type="submit" class="btn btn-primary  btn-md">Nowy Nauczyciel</button>
    </form>
</body>
</html>