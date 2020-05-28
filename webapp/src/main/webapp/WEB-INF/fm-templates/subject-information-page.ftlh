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
                                        <button id="delete-subject" type="button" value="${subject.id}" class="btn btn-primary">Confirm</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </#if>
            </div>
        </div>
    </div>
</main>
<script src="../../delete-subject.js"></script>
<script src="../../forAddedendDeletedsubjectrange.js"></script>
<#include "jsScripts.ftlh">
</body>
</html>