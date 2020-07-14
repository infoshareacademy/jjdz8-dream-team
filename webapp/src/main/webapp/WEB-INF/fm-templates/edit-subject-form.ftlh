<#include "base-login-user.ftlh">
<#macro content>
<#if subject ??>
 <#if incorrectForm ??>
        <div class="alert alert-danger" role="alert">
            ${incorrectForm}.Spróbuj jeszcze raz
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </#if>
    <div class="card">
        <div class="card-header">
            Dane przedmiotu
        </div>
        <br>
            <div class="form col-md-12">
                <form id="edit-subject-form">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="name">kategoria przedmiotu</label><br>
                            <input id="name" type="text" name="name"  value="${subject.name}"> <br/><br/>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="topic">temat</label><br>
                            <input id="topic" type="text" name="topic"  value="${subject.topic}"><br/>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <p>video materials</p>
                            <select id="isVideo" name="isVideo">
                                <option value="true">tak</option>
                                <option value="false">nie</option>
                            </select>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="videoLink">link do wideo materiałów</label><br>
                            <input id="videoLink" type="text" name="videoLink" <#if subject.videoLink?has_content> value="${subject.videoLink}" </#if>
                                   ><br/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="description">Opis przedmiotu</label><br>
                            <textarea id="description"
                                      name="description" content="${subject.description}" >${subject.description}</textarea><br/>
                        </div>
                    </div>
                    <input type="hidden" name="userId" value="${user.id}"/><br/>
                    <input type="hidden" name="id" value="${subject.id}"/><br/>
                    <div class="form-group col-md-6">
                        <input class="btn btn-primary" type="submit" name="save" value="zatwierdź"/><br/>
                    </div>
                </form>
            </div>
    </div>
    </#if>
</#macro>
<@home/>