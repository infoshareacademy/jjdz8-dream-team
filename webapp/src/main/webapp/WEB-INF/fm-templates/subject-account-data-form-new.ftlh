<#include "base-login-user.ftlh">
<#macro content>
    <div class="card">
        <div class="card-header">
            Dane przedmiotu
        </div>

        <div class="col-md-4">
            <#if message ??>
                <h1>You have to login or registry first</h1>
                <a href="http://localhost:8080/chooseWhoIsLogin.jsp">
                    <input type="button" class="btn btn-secondary" value="login"/>
                </a>
                <a href="http://localhost:8080/add-user.jsp">
                    <input type="button" class="btn btn-secondary" value="registry"/>
                </a>
            </#if>
        </div>
        <br>
        <#if subject??>
            <div class="form col-md-12">
                <form method="post" action="http://localhost:8080/edit-subject">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="name">nazwa przedmiotu</label><br>
                            <input id="name" type="text" name="name" value="${subject.name}"><br/><br/>
                        </div>

                        <div class="form-group col-md-6">
                            <label for="topic">temat</label><br>
                            <input id="topic" type="text" name="topic" value="${subject.topic}"><br/><br/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="description">Opis przedmiotu</label><br>
                            <textarea id="description" type="text"
                                      name="description">${subject.description}</textarea><br/><br/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <p>video materials</p>
                            <select id="isVideo" name="isVideo">
                                <option value="true">yes</option>
                                <option value="false">no</option>
                            </select>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="videoLink">link do wideo materiałów</label><br>
                            <input id="videoLink" type="text" name="videoLink"
                                   value="tu bedzie link do wideo"><br/><br/>
                        </div>
                    </div>
                    <input type="hidden" name="id" value="${subject.id}"/><br/><br/>
                    <div class="form-group col-md-6">
                        <input class="btn btn-primary" type="submit" name="save" value="save"/><br/><br/>
                    </div>
                </form>
            </div>
        </#if>
    </div>
</#macro>
<@home/>