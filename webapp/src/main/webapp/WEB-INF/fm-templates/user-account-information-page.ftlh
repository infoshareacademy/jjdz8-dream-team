<#include "base-login-user.ftlh">
<#macro content>
    <div class="card">
    <div class="card-header">
        Dane konta
    </div>
    <div class="row">
    <div class="col-md-4">
    <#if message ??>
        <h1>zaloguj się bądź zarejestruj by uzyskać dostęp</h1>
        <a href="../../html_js_css_Jsp_files/login.jsp">
            <input type="button" value="zaloguj"/>
        </a>
        <a href="http://localhost:8080/add-user.jsp">
            <input type="button" value="zarejestruj"/>
        </a>
    </#if>
    <#if user ?? >
        <#include "user-card-with-picture.ftlh">
        </div>
        <div class="col-md-6">
            <#include "information-about-user-form-read-only.ftlh">
            <br>
        </div>
        </div>
        </div><br><br>
    </#if>
</#macro>
<@home/>