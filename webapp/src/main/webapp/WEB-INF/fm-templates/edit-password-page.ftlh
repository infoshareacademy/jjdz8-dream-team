<#include "base-login-user.ftlh">
<#macro content>
    <#if correctPassword ??>
        <div class="col-md-12">
            <div class="alert alert-info" role="alert">
                Twoje hasło zostało poprawnie zmienione!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </div>
    </#if>
    <#if incorrectPassword ??>
        <div class="col-md-12">
            <div class="alert alert-danger" role="alert">
                Nieprawidłowe hasło!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </div>
    </#if>
    <#if emptyParameters ??>
        <div class="col-md-12">
            <div class="alert alert-danger" role="alert">
                Przy zmianie hasła wszystkie pola muszą zostać uzupełnione
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
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
                <#include "edit-password-form.ftlh">
            </div>
        </div>
        </#if>
    </div>
    </div>
</#macro>

<@home/>