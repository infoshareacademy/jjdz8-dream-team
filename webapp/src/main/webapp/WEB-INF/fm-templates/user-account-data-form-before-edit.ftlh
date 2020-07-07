<#include "base-login-user.ftlh">
<#macro content>
    <#if incorrectParameters ??>
        <div class="alert alert-danger" role="alert">
            Zostawiłeś puste pole lub twój nickname lub email nie są unikalne. Spróbuj jeszcze raz...
        </div>
    </#if>
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
                <#include "user-form-content-before-edit.ftlh">
            </div>
            </#if>
        </div>
    </div>
</#macro>

<@home/>