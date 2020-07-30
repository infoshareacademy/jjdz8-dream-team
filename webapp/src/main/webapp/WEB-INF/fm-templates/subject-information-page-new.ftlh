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
                <#if subject.videoLink?has_content>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="isVideo">materiały wideo</label><br>
                            <p id="isVideo">załączono materiały wideo</p>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="videoLink">link do wideo materiałów</label><br>
                            <a href="${subject.videoLink}">
                                <input id="videoLink" type="text" name="videoLink" value="${subject.videoLink}"
                                       disabled><br/><br/>
                            </a>
                        </div>
                    </div>
                </#if>
                    <#if subject.material ??>
                      <a href="/subject/material?id=${subject.id}">
                          <input type="button" class="btn btn-secondary" value="pokaż materiał">
                      </a>
                    </#if>


                <div class="form-row">
                    <#if afterSearch ??>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <p>dane nauczyciela: nickname ${subject.user.nickName} </p>
                            </div>
                            <div class="form-group col-md-6">
                                <a href="/search?filter=user&input=${subject.user.nickName}"> <input
                                            class="btn btn-primary" type="button"
                                            value="pokaż wszystkie przedmioty tego nauczyciela"/></a><br>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <a href="/search"> <input class="btn btn-primary" type="button"
                                                      value="wróc do wyszukiwania"/></a><br>
                        </div>
                    <#else >
                        <div class="form-group col-md-6">
                            <a href="/subjects/edit?id=${subject.id}"> <input class="btn btn-primary" type="button"
                                                                              value="edytuj"/></a><br>
                        </div>
                    </#if>

                    <br>
                </div>


            </form>
        </div>
        </div>
    </#if>
    </div>
</#macro>

<@home/>