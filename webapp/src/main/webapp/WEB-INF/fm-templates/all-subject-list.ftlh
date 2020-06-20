<#include "base-login-user.ftlh">
<#macro content>
    <div class="card">
        <#if message ??>
            <td>    ${message}</td>
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
        <#if users ??>
            <table class="table table-hover">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">subject name</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <#list users as user>
                    <#if user ??>
                        <tbody>
                        <#if message ??>
                            <td>${message}</td>
                        </#if>
                        <td>${user.nickName}</td>
                        <td>
                            <a href="/subject-details?teacherId=${user.id}">
                                <input class="btn btn-secondary" type="button" value="show subjects"/>
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