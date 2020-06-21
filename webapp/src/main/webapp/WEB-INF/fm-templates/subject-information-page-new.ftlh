<#include "base-login-user.ftlh">
<#macro content>
    <div class="card">
    <div class="card-header">
        Dane przedmiotu
    </div>
    <#if emptyForm ??>
        <div class="col-md-12">
            <div class="alert alert-danger" role="alert">
                pola nie mogą pozostać puste, spróbuj jeszcze raz
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </div>
    </#if>
    <#if subject??>
        <div class="form col-md-12">
            <form>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="name">nazwa</label><br>
                        <input id="name" type="text" name="name" value="${subject.name}" disabled><br/><br/>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="topic">temat</label><br>
                        <input id="topic" type="text" name="topic" value="${subject.topic}" disabled><br/><br/>
                    </div>

                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="description">opis</label><br>
                        <textarea id="description" name="description"
                                  disabled>${subject.description} </textarea><br/><br/>
                    </div>
                </div>
                <#if subject.videoLink ??>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="isVideo">materiały wideo</label><br>
                            <p id="isVideo">załączono materiały wideo: "${isVideo}" </p>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="videoLink">link do wideo materiałów</label><br>
                            <input id="videoLink" type="text" name="videoLink" value="${subject.videoLink}"
                                   disabled><br/><br/>
                        </div>
                    </div>
                </#if>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <a href="/edit-subject?id=${subject.id}"> <input class="btn btn-primary" type="button"
                                                                         value="edytuj"/></a><br>
                    </div>
                    <br>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <a href="/show-subjects"> <input class="btn btn-secondary" type="button"
                                                         value="Wróć"/></a><br>
                    </div>
                    <br>
                </div>

            </form>
        </div>
        </div>


    <#--    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
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
                        Jesteś pewny, że chcesz usunąć ten przedmiot: ${subject.name}?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">nie</button>
                        <button id="delete-subject" type="button" value="${subject.id}" class="btn btn-primary">
                            tak
                        </button>
                    </div>
                </div>
            </div>
        </div>-->

    </#if>
    </div>
</#macro>

<@home/>