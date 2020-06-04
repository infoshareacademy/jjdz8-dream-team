<#include "base-login-user.ftlh">
<#macro content>
    <div class="card">
        <div class="card-header">
            Subject details
        </div>
        <div class="row">
            <div class="col-md-6">
                <#if message ??>
                    <#if message ??>
                        <td>    ${message}</td>
                    </#if>
                </#if>

            <#if subject??>
                <div class="form">
                    <div class="form-group col-md-6">
                        name: <input type="text" name="name" value="${subject.name}" disabled><br/><br/>
                    </div>

                    <div class="form-group col-md-6">
                        topic: <input type="text" name="topic" value="${subject.topic}" disabled><br/><br/>
                    </div>

                    <div class="form-group col-md-6">
                        description: <textarea  name="description" disabled>${subject.description} </textarea><br/><br/>
                    </div>

                    <div class="form-group col-md-6">
                        <p >Is video: "${isVideo}" </p>
                    </div>
                </div>
            </div>
                    <div class="col-md-6">
                        <#include "user-card-with-picture.ftlh">
                    </div>
            </#if>

    </div>
    </div>
</#macro>

<@home/>