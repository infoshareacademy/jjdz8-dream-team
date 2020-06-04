<#include "base-login-user.ftlh">
<#macro content>
    <div class="card">
        <div class="card-header">
            Subject details
        </div>
        <#if message ??>
            <#if message ??>
                <td>    ${message}</td>
            </#if>
        </#if>

        <#if subject??>
            <div class="row">
                <div class="col-md-6">
                    <div class="form">
                        <div class="form-group col-md-6">
                            name: <input type="text" name="name" value="${subject.name}" disabled><br/><br/>
                        </div>

                        <div class="form-group col-md-6">
                            topic: <input type="text" name="topic" value="${subject.topic}" disabled><br/><br/>
                        </div>

                        <div class="form-group col-md-6">
                            description: <textarea name="description"
                                                   disabled>${subject.description} </textarea><br/><br/>
                        </div>

                        <div class="form-group col-md-6">
                            video lessons: <input type="text" name="isVideo" value="${isVideo}" disabled><br/><br/>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <#include "user-card-with-picture.ftlh">
                </div>
            </div>
        </#if>
        <#if subjects??>
            <table class="table table-hover">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">subject name</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <#list subjects as subject>
                    <#if subject??>
                        <tbody>
                        <#if message ??>
                            <td>${message}</td>
                        </#if>
                        <td>${subject.name}</td>
                        <td>
                            <a href="/subject-details?id=${subject.id}">
                                <input class="btn btn-secondary" type="button" value="show details"/>
                            </a>
                        </td>
                        </tbody>
                    </#if>
                </#list>
            </table>
        </#if>
    </div>
</#macro>

<@home/>