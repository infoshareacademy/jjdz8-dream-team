<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="../../range.css">
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet"
          id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
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
                <#if subject??>
                    <h1><strong>${subject.name}</strong></h1>
                    <form method="post" action="http://localhost:8080/edit-subject">
                        <#if emptyName ??><p style="color: crimson">Name cannot be empty</p>
                            name: <input type="text"  name="name" value=""/><br/><br/>
                            <br/><br/>
                        <#else> name: <input type="text" name="name" value="${subject.name}"><br/><br/>
                        </#if>

                        <#if emptyTopic ??><p style="color: crimson">Topic cannot be empty</p>
                            topic: <input type="text"  name="topic" value=""/><br/><br/>
                            <br/><br/>
                        <#else> topic: <input type="text" name="topic" value="${subject.topic}"><br/><br/>
                        </#if>

                        <#if emptyDescription ??><p style="color: crimson">Description cannot be empty</p>
                            description: <input type="text"  name="description" value=""/><br/><br/>
                            <br/><br/>
                        <#else> description: <input type="text" name="description" value="${subject.description}"><br/><br/>
                        </#if>
                        <p>Viedeo materials: ${isVideo}</p>
                        <select id="isVideo" name="isVideo">
                            <option value="true">yes</option>
                            <option value="false">no</option>
                        </select>
                        <input type="hidden" name="id" value="${subject.id}"/><br/><br/>
                        <input type="submit" name="edit" value="edit"/><br/><br/>
                    </form>

                </#if>
            </div>
        </div>
    </div>
</main>
<script src="../../forAddedendDeletedsubjectrange.js"></script>
<#include "jsScripts.ftlh">
</body>
</html>