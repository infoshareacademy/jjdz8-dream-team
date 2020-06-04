<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta
            name="description"
            content="Ratings of teaschers"
    />
    <title>Add-user</title>
    <link href="styles.css" rel="stylesheet"/>
    <link href="form.css" rel="stylesheet"/>
</head>
<main>
<body>
<jsp:include page="menu.jsp"/>
<header>
    <h1>Ratings</h1>
    <p>
        Use bellow form.
    </p>
</header>

    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th>#</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Username</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">1</th>
            <td>Mark</td>
            <td>Otto</td>
            <td>@mdo</td>
        </tr>
        <tr>
            <th scope="row">2</th>
            <td>Jacob</td>
            <td>Thornton</td>
            <td>@fat</td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>Larry</td>
            <td>the Bird</td>
            <td>@twitter</td>
        </tr>
        </tbody>
    </table>

</main>
<footer>
    <p>E-learning web app - all rights reserved;-)</p>
</footer>
</body>
</html>