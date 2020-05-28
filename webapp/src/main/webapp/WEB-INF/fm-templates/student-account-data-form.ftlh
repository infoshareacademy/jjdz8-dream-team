<!DOCTYPE html>
<html lang="en">
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
</head>
<body>
<#include "menu.ftlh" >
<#include "headerJambutron.ftlh">
<main role="main">
    <div class="container">
        <div class="row">
            <div class="col-6">
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
                <h1> Hello <strong>${user.nickName}!</strong></h1>
                <div class="form">
                    <form method="post" action="http://localhost:8080/edit-student-account">
                        NickName: <input type="text" name="nickName"  value="${user.nickName}" /><br/><br/>
                        email: <input type="text" name="email"  value="${user.email}"/><br/><br/>
                        <label>Enter old password to confirm changes</label><br>
                        old password: <input type="password" name="oldPassword" value=""/><br/><br/>
                        <label>Enter new password if you want change password</label>
                        <p style="color: crimson">format(8-20 characters,at
                            lest one digit,<br>lower
                            and upper chase character, special character[@,!*$...]</p><br>
                        new password: <input type="password" name="newPassword" value=""/><br/><br/>
                        <input class="btn btn-primary" type="submit" name="save" value="edit"/><br/><br/>
                    </form>
                </div>
            </div>
        </div>
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
            Delete account
        </button>

        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">delete account</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        If you are sure about delete this account please click on confirm button
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button id="delete-user" type="button" value="${user.id}" class="btn btn-primary">Confirm</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
                <a href="/logout">
                    <input type="button" class="btn btn-primary" value="logout"/>
                </a>
                </#if>
            </div>
        </div>
</main>

<script src="../../delete-student.js"></script>
<#include "jsScripts.ftlh">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>