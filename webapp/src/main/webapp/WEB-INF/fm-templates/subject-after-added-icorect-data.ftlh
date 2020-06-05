<#include "base-login-user.ftlh">
<#macro content>
    <div class="card">
        <div class="card-header">
            Dane przedmiotu
        </div>

        <#if message ??>
            <div class="col-md-6">
                <h1>You have to login or registry first</h1>
                <a href="http://localhost:8080/chooseWhoIsLogin.jsp">
                    <input type="button" class="btn btn-secondary" value="login"/>
                </a>
                <a href="http://localhost:8080/add-user.jsp">
                    <input type="button" class="btn btn-secondary" value="registry"/>
                </a>
            </div>
        </#if>
        <#if user ?? >
            <div class="form">
                <form method="post" action="http://localhost:8080/add-subject">
                    <#if emptyName ??>
                        <div class="form-group col-md-6">
                            <p style="color: crimson">name cannot be empty</p>
                            <label for="name">nazwa</label><br>
                            <input id="name" type="text" class="form-control" name="name">
                        </div>
                    <#elseif name ??>
                        <div class="form-group col-md-6">
                            <label for="name2">nazwa</label><br>
                            <input id="name2" type="text" name="name" value="${name}"><br/><br/>
                        </div>
                    </#if>

                    <#if emptyTopic ??>
                        <div class="form-group col-md-6">
                            <p style="color: crimson">topic cannot be empty</p>
                            <label for="topic">temat</label><br>
                            <input id="topic" type="text" name="topic" value=""/><br/><br/>
                        </div>
                    <#elseif topic ??>
                        <div class="form-group col-md-6">
                            <label for="topic2">temat</label><br>
                            <input id="topic2" type="text" name="topic" value="${topic}"><br/><br/>
                        </div>
                    </#if>

                    <#if emptyDescription ??>
                        <div class="form-group col-md-6">
                            <p style="color: crimson">description cannot be empty</p>
                            <label for="description">temat</label><br>
                            <textarea id="description" type="text" name="description"></textarea><br/><br/>
                        </div>
                    <#elseif description ??>
                        <div class="form-group col-md-6">
                            <label for="description2">temat</label><br>
                            <textarea id="description2" type="text" name="description"
                                                   value="${description}"></textarea><br/><br/>
                        </div>
                    </#if>
                    <div class="form-group col-md-6">
                        <p>video materials</p>
                        <select id="isVideo" name="isVideo">
                            <option value="true">yes</option>
                            <option value="false">no</option>
                        </select>
                    </div>
                    <div class="form-group col-md-6">
                        <input class="btn btn-secondary" type="submit" name="save" value="save"/><br/><br/>
                    </div>
                </form>
            </div>
        </#if>
    </div>
</#macro>

<@home/>