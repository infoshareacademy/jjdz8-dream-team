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
                    <form method="post" action="http://localhost:8080/edit-subject">
                        <#if emptyName ??>
                            <div class="form-group col-md-6">
                                <p style="color: crimson">name cannot be empty</p>
                                Name: <input type="text" class="form-control"  name="name">
                            </div>
                        <#elseif name ??>
                            <div class="form-group col-md-6">
                                name: <input type="text" name="name" value="${name}"><br/><br/>
                            </div>
                        </#if>

                        <#if emptyTopic ??>
                            <div class="form-group col-md-6">
                                <p style="color: crimson">topic cannot be empty</p>
                                topic: <input type="text" name="topic" value=""/><br/><br/>
                            </div>
                        <#elseif topic ??>
                            <div class="form-group col-md-6">
                                topic: <input type="text" name="topic" value="${topic}"><br/><br/>
                            </div>
                        </#if>

                        <#if emptyDescription ??>
                            <div class="form-group col-md-6">
                                <p style="color: crimson">description cannot be empty</p>
                                description: <input type="text" name="description" value=""/><br/><br/>
                            </div>
                        <#elseif description ??>
                            <div class="form-group col-md-6">
                                description: <textarea type="text" name="description" value="${description}"></textarea><br/><br/>
                            </div>
                        </#if>
                        <div class="form-group col-md-6">
                            <p>video materials</p>
                            <select id="isVideo" name="isVideo">
                                <option value="true">yes</option>
                                <option value="false">no</option>
                            </select>
                        </div>
                        <input type="hidden" name="id" value="${subject.id}"/><br/><br/>
                        <div class="form-group col-md-6">
                            <input class="btn btn-primary" type="submit" name="save" value="edit"/><br/><br/>
                        </div>
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