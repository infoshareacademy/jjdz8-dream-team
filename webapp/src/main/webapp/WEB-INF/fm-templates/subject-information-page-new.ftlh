<#include "base-login-user.ftlh">
<#macro content>
    <div class="card" xmlns="http://java.sun.com/jsf/composite">
    <div class="card-header">
        Dane przedmiotu
    </div>
    <#if subject??>
        <div class="row">
        <div class="col-md 6">
        <form>
            <div class="form">
            <div class="form-group col-md-6">
                <label for="name">nazwa</label><br>
                <input id="name" type="text" name="name" value="${subject.name}" disabled><br/><br/>
            </div>

            <div class="form-group col-md-6">
                <label for="topic">temat</label><br>
                <input id="topic" type="text" name="topic" value="${subject.topic}" disabled><br/><br/>
            </div>

            <div class="form-group col-md-6">
                <label for="description">opis</label><br>
                <textarea id="description" name="description"
                          disabled>${subject.description} </textarea><br/><br/>
            </div>
            <div class="form-group col-md-6">
                <label for="isVideo">materiały wideo</label><br>
                <p id="isVideo">Is video: "${isVideo}" </p>
            </div>
        </div>
        </form>
        </div>
            <div class="col-md 6">
                <img src="../../grafika.jpg">
            </div>

        </div>
        <div class="col-md 4">
            <a href="/teacher-account-information"> <input class="btn btn-secondary" type="button"
                                                           value="Back to account data"/></a><br>
        </div><br>

        <div class="col-md 4">
            <a href="/edit-subject?id=${subject.id}"> <input class="btn btn-secondary" type="button"
                                                             value="Edit"/></a><br>
        </div><br>
        <div class="col-md 4">
            <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#exampleModal">
                Delete subject
            </button>
        </div>

        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">delete subject</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        If you are sure about delete this subject please click on confirm button
                    </div>
                    <div class="modal-footer">
                        <button id="delete-subject" type="button" value="${subject.id}" class="btn btn-primary">
                            Confirm
                        </button>
                    </div>
                </div>
            </div>
        </div>

    </#if>
    </div>
</#macro>

<@home/>