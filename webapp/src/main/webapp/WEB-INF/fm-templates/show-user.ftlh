<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="description" content="E-learning web app"/>
    <title>E-learning web app by Dream Team</title>
    <#include "style.ftlh">
</head>
<body>
<#include "menu.ftlh">
<main role="main">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
<div>
</div>
                <h3>Sesje</h3>
                <h1>Hello <strong>${user.login}!</strong> from ftl</h1>

            </div>
        </div>
    </div>
</main>
<#include "footer.ftlh">
<#include "js.ftlh">
</body>
</html>
