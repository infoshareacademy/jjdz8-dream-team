<#include "base-login-user.ftlh">
<#macro content>
    <div class="card">
    <div class="card-header">
        Dane logowania
    </div>
    <#if subject??>
        <div class="form">
            <div class="col-md-6">
                <div class="col-md-6">
                    name: <input type="text" name="name" value="${subject.name}" disabled><br/><br/>
                </div>

                <div class="col-md-6">
                    topic: <input type="text" name="topic" value="${subject.topic}" disabled><br/><br/>
                </div>

                <div class="md-6">
                    description: <textarea name="description" disabled>${subject.description} </textarea><br/><br/>
                </div>

                <div class="col-md-6">
                    <p>Is video: "${isVideo}" </p>
                </div>
            </div>
            <div class="form-group col-md-4">
                <a href="/edit-subject?id=${subject.id}"> <input class="btn btn-primary" type="button"
                                                                 value="Edit"/></a>
            </div>
            <div class="form-group col-md-4">
                <a href="/teacher-account-information"> <input class="btn btn-primary" type="button"
                                                               value="Back to account data"/></a>
            </div>
            <!-- Button trigger modal -->
            <div class="form-group col-md-4">

                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                    Delete subject
                </button>
            </div>
        </div>

        <!-- Modal -->
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
        </div>
    </#if>
</#macro>

<@home/>