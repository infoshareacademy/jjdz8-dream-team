<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html"
      xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script
            src="https://code.jquery.com/jquery-3.5.0.js"
            integrity="sha256-r/AaFHrszJtwpe+tHyNi/XCfMxYpbsRg2Uqn0x3s2zc="
            crossorigin="anonymous"></script>
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
            integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
            crossorigin="anonymous"
    />
    <link href="styles.css" rel="stylesheet"/>
    <link href="../../styles-to-teacher-account-info-page.css">
</head>
<body>
<#include "menuWithLogout.ftlh" >
<#include "headerJambutron.ftlh">
<main role="main">
    <div class="container">
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-4">
                    <#if message ??>
                        <h1>You have to login or registry first</h1>
                        <a href="http://localhost:8080/temporary-login.jsp">
                            <input type="button" value="login"/>
                        </a>
                        <a href="http://localhost:8080/add-user.jsp">
                            <input type="button" value="registry"/>
                        </a>
                    </#if>
                    <#if user ?? >
                    <div class="card" style="width: 18rem;">
                        <img src="https://bootdey.com/img/Content/avatar/avatar1.png" class="card-img-top" alt="Daniel Adams">
                        <div class="card-body">
                            <h5 class="card-title">${user.nickName}</h5>
                            <span class="author-card-info"> date of joining</span><br><br>
                            <h5 class="author-card-details">Shortly about me</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-">
                    <form  method="post" action="http://localhost:8080/edit-student-account">
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="inputEmail4">nickname</label>
                                <input type="text" class="form-control" id="inputEmail4" name="nickName" placeholder="${user.nickName}">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="inputEmail4">Email</label>
                                <input type="email" class="form-control" id="inputEmail4" name="email" placeholder="${user.email}" >
                            </div>
                        </div>
                        <div class="form-row">

                            <div class="form-group col-md-6">
                                <label for="inputPassword4">old password</label>
                                <input type="password" class="form-control" id="inputPassword4" name="oldPassword">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="inputPassword4">new password</label>
                                <input type="password" class="form-control" id="inputPassword4" name="newPassword" placeholder="Password" >
                            </div>
                            <div class="form-group col-md-6">
                                <label for="inputPassword4">repeated password</label>
                                <input type="password" class="form-control" id="inputPassword4" name="repeatedPassword" placeholder="Password">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">edit</button>
                    </form>
                </div>
                </#if>
            </div>
        </div>
    </div>
</main>

<script src="../../delete-subject.js"></script>
<script src="../../delete-teacher.js"></script>
<#include "jsScripts.ftlh">
</body>
</html>