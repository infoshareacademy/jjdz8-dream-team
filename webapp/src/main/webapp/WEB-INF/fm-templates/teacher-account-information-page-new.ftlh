<#include "base-login-user.ftlh">
<#macro content>
    <div class="card">
    <div class="card-header">
        Login data
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
    <#if user ?? >
        <#include "user-card-with-picture.ftlh">
        </div>
        <div class="col-md-6">
            <#include "information-about-user-form-read-only.ftlh">
            <br>
            <a href="/teacher"><input class="btn btn-primary" type="button"
                                                          value="edit account"></a>
        </div>

        </div>
        </div>

        <#if subjects??>
            <table class="table table-hover">
                <tr>
                    <th scope="col">subject name</th>
                    <th scope="col">edit</th>
                </tr>
                    <#list subjects as subject>
                        <#if subject??>
                            <thead>

                            </thead>
                            <tbody>
                            <td>${subject.name}</td>
                            <td>
                                <a href="http://localhost:8080/subject?id=${subject.id}">
                                    <input class="btn btn-primary" type="button" value="show details"/>
                                </a>
                            </td>
                            </tbody>

                        </#if>
                    </#list>
            </table>
        </#if>
        <br>
        <a href="../../add-subject.html">
            <input class="btn btn-primary" type="button" value="add new subject"/>
        </a>
    </#if>
</#macro>

<@home/>