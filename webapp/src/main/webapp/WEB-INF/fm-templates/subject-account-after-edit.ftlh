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
                    <a href="http://localhost:8080/chooseWhoIsLogin.jsp">
                        <input type="button" value="login"/>
                    </a>
                    <a href="http://localhost:8080/add-user.jsp">
                        <input type="button" value="register"/>
                    </a>
                </#if>
                <#if user ?? >
                    <div class="form">
                        <form method="post" action="http://localhost:8080/add-subject">
                            <#if emptyName ??><p style="color: crimson">name cannot be empty</p>
                                Name: <input type="text" name="name" value=""/><br/><br/>
                                <br/><br/>
                            <#elseif name ??> name: <input type="text" name="name" value="${name}"><br/><br/>-->
                            </#if>

                            <#if emptyTopic ??><p style="color: crimson">topic cannot be empty</p>
                                topic: <input type="text" name="topic" value=""/><br/><br/>
                                <br/><br/>
                            <#elseif topic ??> topic: <input type="text" name="topic" value="${topic}"><br/><br/>
                            </#if>

                            <#if emptyDescription ??><p style="color: crimson">description cannot be empty</p>
                                description: <input type="text" name="description" value=""/><br/><br/>
                                <br/><br/>
                            <#elseif description ??> description: <input type="text" name="description"
                                                                         value="${description}"><br/><br/>
                            </#if>

                            <input type="submit" name="save" value="edit"/><br/><br/>
                        </form>
                    </div>
                </#if>
                <a href="/logout"> <input type="button" value="Logout"/></a>
            </div>
        </div>

    </div>
</main>

<script src="../../delete-subject.js"></script>
<script src="../../delete-teacher.js"></script>
<#include "jsScripts.ftlh">
</body>
</html>