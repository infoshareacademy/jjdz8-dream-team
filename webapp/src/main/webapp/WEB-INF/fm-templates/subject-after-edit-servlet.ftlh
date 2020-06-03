<#include "base-login-user.ftlh">
<#macro content>
    <div class="card">
        <div class="card-header">
            Dane logowania
        </div>
        <div class="row">
            <div class="col-md-4">
                <#if message ??>
                    <h1>You have to login or registry first</h1>
                    <a href="http://localhost:8080/chooseWhoIsLogin.jsp">
                        <input type="button" value="login"/>
                    </a>
                    <a href="http://localhost:8080/add-user.jsp">
                        <input type="button" value="registry"/>
                    </a>
                </#if>
            </div>
            <div class="col-md-6">
                <form  method="post" action="http://localhost:8080/edit-subject">
                    <#if emptyName ??>
                        <div class="form-group col-md-6">
                            <p style="color: crimson">name cannot be empty</p>
                            Name: <input type="text" class="form-control"  name="name">
                        </div>
                    <#elseif name ??>
                        <div class="form-group col-md-6">
                            name: <input type="text" name="name" value="${name}"><br/><br/>
                        </div>
                    </#if>

                    <#if emptyTopic ??>
                        <div class="form-group col-md-6">
                            <p style="color: crimson">topic cannot be empty</p>
                            topic: <input type="text" name="topic" value=""/><br/><br/>
                        </div>
                    <#elseif topic ??>
                        <div class="form-group col-md-6">
                            topic: <input type="text" name="topic" value="${topic}"><br/><br/>
                        </div>
                    </#if>

                    <#if emptyDescription ??>
                        <div class="form-group col-md-6">
                            <p style="color: crimson">description cannot be empty</p>
                            description: <input type="text" name="description" value=""/><br/><br/>
                        </div>
                    <#elseif description ??>
                        <div class="form-group col-md-6">
                            description: <textarea type="text" name="description" >${description}</textarea><br/><br/>
                        </div>
                    </#if>
                    <div class="form-group col-md-6">
                        <p>video materials</p>
                        <select id="isVideo" name="isVideo">
                            <option value="true">yes</option>
                            <option value="false">no</option>
                        </select>
                    </div>
                    <input type="hidden" name="id" value="${subject.id}"/><br/><br/>
                    <div class="form-group col-md-6">
                        <input class="btn btn-primary" type="submit" name="save" value="save"/><br/><br/>
                    </div>
                </form>
            </div>
        </div>
    </div>
    </div>
</#macro>

<@home/>