<#include "base-login-user.ftlh">
<#macro content>
    <div class="card">
    <#if subjects??>
        <table class="table table-hover">
            <tr>
                <th scope="col">subject name</th>
                <th scope="col"></th>
            </tr>
            <#list subjects as subject>
                <#if subject??>
                    <thead>

                    </thead>
                    <tbody>
                    <td>${subject.name}</td>
                    <td>
                        <a href="">
                            <input class="btn btn-primary" type="button" value="show details"/>
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