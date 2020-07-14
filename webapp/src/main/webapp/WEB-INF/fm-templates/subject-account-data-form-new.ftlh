<#include "base-login-user.ftlh">
<#macro content>
 <#if incorrectForm ??>
        <div class="alert alert-danger" role="alert">
            ${incorrectForm}.Spróbuj jeszcze raz
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </#if>
<#--    <#if emptyName ??>
        <div class="alert alert-danger" role="alert">
            ${emptyName}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </#if>
    <#if emptyTopic ??>
        <div class="alert alert-danger" role="alert">
            ${emptyTopic}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </#if>
    <#if emptyDescription ??>
        <div class="alert alert-danger" role="alert">
            ${emptyDescription}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </#if>
    <#if emptyVideoLink ??>
        <div class="alert alert-danger" role="alert">
            ${emptyVideoLink}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </#if>-->
    <div class="card">
        <div class="card-header">
            Dane przedmiotu
        </div>
        <br>
            <div class="form col-md-12">
                <form method="post" action="/add-subject">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <#if emptyName ??><p style="color: red">pole nie może pzostać puste</p></#if>
                            <label for="name">kategoria przedmiotu</label><br>
                            <input id="name" type="text" name="name" <#if name ??> value="${name}" </#if><br/><br/>
                        </div>
                        <div class="form-group col-md-6">
                            <#if emptyTopic ??><p style="color: red">pole nie może pzostać puste</p></#if>
                            <label for="topic">temat</label><br>
                            <input id="topic" type="text" name="topic" <#if topic ??> value="${topic}" </#if>><br/>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <p>materiały video</p>
                            <select id="isVideo" name="isVideo">
                                <option value="true">tak</option>
                                <option value="false">nie</option>
                            </select>
                        </div>
                        <div class="form-group col-md-6">
                            <#if emptyVideoLink ??><p style="color: red"> jeżeli zaznaczyłeś dostepność matariałów video to pole nie może pzostać puste</p></#if>
                            <label for="videoLink">link do wideo materiałów</label><br>
                            <input id="videoLink" type="text" name="videoLink"
                                   ><br/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <#if emptyDescription ??><p style="color: red">pole nie może pzostać puste</p></#if>
                            <label for="description">Opis przedmiotu</label><br>
                            <textarea id="description" type="text"
                                      name="description" <#if description ??> value="${description}" </#if>></textarea><br/>
                        </div>
                    </div>
                    <input type="hidden" name="id" value="${user.id}"/><br/>
                    <#if subject??><input type="hidden" name="subjectId" value="${subject.id}"/><br/></#if>
                    <div class="form-group col-md-6">
                        <input class="btn btn-primary" type="submit" name="save" value="zatwierdź"/><br/>
                    </div>
                </form>
            </div>
    </div>
</#macro>
<@home/>