<#include "base-login-user.ftlh">
<#macro content>
    <#if dataAccept ??>
        <div class="alert alert-success" role="alert">
            Twoje dane zostały poprawnie zmienione
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </#if>
    <#if incorrectParameters ??>
        <div class="alert alert-danger" role="alert">
            Podany nickname lub email są zajęte przez innego użytkownika, spróbuj jeszcze raz
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </#if>
    <#if emptyParameters ??>
        <div class="alert alert-danger" role="alert">
            Pola nie mogą pozostać puste, spróbuj jeszcze raz
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </#if>
    <div class="card">
        <div class="card-header">
            Dane logowania
        </div>
        <div class="row">
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
                <#if user ?? >
                <#include "user-card-with-picture.ftlh">
            </div>
            <div class="col-md-6">
                <#include "user-form-content-after-edit.ftlh">
            </div>
            </#if>
        </div>
    </div>
</#macro>

<@home/>




