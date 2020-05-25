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
                            NickName: <input type="text"  name="nickName" value=""/><br/><br/>
                            <br/><br/>
                        <#else> NickName: <input type="text" name="nickName" value="${user.nickName}"><br/><br/>
                        </#if>

                        <#if emptyEmail ??><p style="color: crimson">email cannot be empty</p>
                            email: <input type="text" name="email"  value=""/><br/><br/>
                            <br/><br/>
                        <#else> email: <input type="text" name="email" value="${user.email}"><br/><br/>
                        </#if>

                        <#if emptyPassword ??><p style="color: crimson">password cannot be empty</p>
                            password: <input type="password" name="password" required="required" value=""/><br/><br/>
                            <br/><br/>
                        <#else> password: <input type="password" name="password" value="${user.password}"><br/><br/>
                        </#if>

                        <input type="submit" name="save" value="edit"/><br/><br/>
                    </form>
                    <a href="/logout" > <input type="button" value="Logout"/></a>

                </div>
            </div>
        </div>
                </#if>
            </div>
        </div>
    </div>
</main>

<script src="../../delete.js"></script>
<script src="../../delete-user.js"></script>
<#include "jsScripts.ftlh">
</body>
</html>