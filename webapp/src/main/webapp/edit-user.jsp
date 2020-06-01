<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pl">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta
            name="description"
            content="Edit user: teacher or student"
    />
    <title>Add-user</title>
    <link href="styles.css" rel="stylesheet"/>
    <link href="form.css" rel="stylesheet"/>
</head>

<body>
<jsp:include page="menu.jsp"/>

<main>
<jsp:include page="edit-user-form.jsp"/>
</main>
<jsp:include page="footer.jsp"/>

</body>
</html>