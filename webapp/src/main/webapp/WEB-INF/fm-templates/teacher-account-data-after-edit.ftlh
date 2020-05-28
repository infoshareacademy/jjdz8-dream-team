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
                    <form method="post" action="http://localhost:8080/edit-teacher-account">
                        <#if emptyNickname ??><p style="color: crimson">nickname cannot be empty</p>
                            NickName: <input type="text" name="nickName" value=""/><br/><br/>
                            <br/><br/>
                        <#else> NickName: <input type="text" name="nickName" value="${user.nickName}"><br/><br/>
                        </#if>

                        <#if emptyEmail ??><p style="color: crimson">email cannot be empty</p>
                            email: <input type="text" name="email" value=""/><br/><br/>
                            <br/><br/>
                        <#else> email: <input type="text" name="email" value="${user.email}"><br/><br/>
                        </#if>

                        <#if wrongPassword ??><p style="color: crimson">wrong password,please try again</p><br>
                            <label>Please enter old password to confirm</label>
                            old password: <input type="password" name="oldPassword" value=""/><br/><br/>
                            <br/><br/>
                        <#else><label>please enter old password to confirm</label>
                            old password: <input type="password" name="oldPassword" value=""/><br/><br/>
                            <br/><br/>
                        </#if>

                        <#if wrongPasswordFormat ??>
                            <p style="color: crimson">wrong format(8-20 characters,at
                            lest one digit,<br>lower
                            and upper chase character, special character[@,!*$...]</p>
                            new password: <input type="password" name="newPassword" value=""/><br/><br/>
                            <br/><br/>
                        <#else>
                            <label>enter new password if you want change</label>
                            new password: <input type="password" name="newPassword" value=""><br/><br/>
                        </#if>

                        <input type="submit" name="save" value="edit"/><br/><br/>
                    </form>
                    <a href="/logout"> <input type="button" value="Logout"/></a>

                </div>
            </div>
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