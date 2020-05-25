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
                    <h1><strong>${subject.name}!</strong></h1>
                    <div class="form">
                        <label>Name:</label>
                        <input type="text" name="name"  value="${subject.name}" disabled /><br/><br/>
                        topic: <input type="text" name="topic"  value="${subject.topic}" disabled/><br/><br/>
                        description: <input type="text" name="description"  value="${subject.description}" disabled/><br/><br/>
                        <p aria-readonly="true">Is video: "${isVideo}" </p>

                        <a href="/edit-subject?id=${subject.id}"> <input type="button" value="Edit"/></a>

                        <button class="delete-subject" id="${subject.id}" type="submit" value="${subject.id}">delete
                        </button>
                    </div>
                </#if>
            </div>
        </div>
    </div>
</main>
<script src="../../forAddedendDeletedsubjectrange.js"></script>
<#include "jsScripts.ftlh">
</body>
</html>