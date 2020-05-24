<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="E-learning web app"/>
    <br>
    <title>E-learning web app by Dream Team</title>
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
            integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
            crossorigin="anonymous"
    />
    <link href="styles.css" rel="stylesheet"/>
    <link href="form.css" rel="stylesheet"/>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand logo" href="index.jsp">E-Learning by DREAM-TEAM</a>
    <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navigation"
    >
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navigation">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link col-sm-4 col-md-2" href="index.jsp">O nas</a>
            </li>

            <li class="nav-item dropdown col-sm-3 col-md-2">
                <a class="nav-link dropdown-toggle data-toggle " href="#"
                   data-toggle="dropdown" role="button" aria-expanded="false"
                   id="submenu" aria-haspopup="true">Nasze usługi</a>

                <div class="dropdown-menu avbar-dark fixed-left bg-dark" aria-labelledby="submenu">
                    <a href="dropdown-item" href="#">Nauka w grupach</a><br>
                    <a href="dropdown-item" href="#">Nauka Indywidualna</a><br>
                    <a href="dropdown-item" href="#">Nauczanie specjalne</a><br>
                    <a href="dropdown-item" href="#">Indywidualne programy nauczania</a></div>
            </li>

            <li class="nav-item col-sm-3 col-md-2"><a class="nav-link" href="edit-user.jsp">Nasze projekty</a></li>
            <li class="nav-item col-sm-3 col-md-3"><a class="nav-link" href="search.jsp">Uczą dla nas  najlepsi</a>
            </li>
            <li class="nav-item col-sm-3 col-md-2"><a class="nav-link" href="ratings.jsp">Postepy uczniów</a></li>
            <li class="nav-item col-sm-3 col-md-2">

                <a class="nav-link dropdown-toggle data-toggle " href="#"
                   data-toggle="dropdown" role="button" aria-expanded="false"
                   id="submenu2" aria-haspopup="true" href="newAccount.jsp">Logowanie</a>

                <div class="dropdown-menu navbar-dark  bg-dark" aria-labelledby="submenu">
                    <a href="logout.jsp">Zaloguj</a><br>
                <a href="newAccount.jsp">utwórz konto</a></div>
            </li>


            <li class="nav-item col-sm-3 col-md-2"><a class="nav-link" href="contact.jsp">Contact</a>
            </li>
        </ul>
    </div>
</nav>
<header class="jumbotron">
    <div class="container">
        <h5 class="display-5">E-learning web app by Dream Team!</h5>
        <p>
            E-learning
        </p>
    </div>
</header>
<script
        src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"
></script>

<script
        src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"
></script>

<script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"
></script>
</body>
</html>
