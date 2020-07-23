<#ftl encoding="utf-8">
<#macro content>
</#macro>

<#macro home>
    <!DOCTYPE html>
    <html lang="pl" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html"
          xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
    <#include "headhtml.ftlh">
    <body>
    <#include "menuWithLogout.ftlh" >
    <#include "headerJambutron.ftlh">
    <main role="main">

        <#if message ??>
            <h1>zaloguj się bądź zarejestruj by uzyskać dostęp</h1>
            <a href="../../html_js_css_Jsp_files/login.jsp">
                <input type="button" class="btn btn-secondary" value="zaloguj"/>
            </a>
            <a href="http://localhost:8080/newAccount.jsp">
                <input type="button" class="btn btn-secondary" value="zarejestruj"/>
            </a>
        <#elseif user ??>
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <div class="list-group">
                            <a href="/account-info" class="list-group-item list-group-item-action">Twoje konto</a>
                            <a href="/user" class="list-group-item list-group-item-action">Edytuj dane</a>
                            <a href="/edit-user" class="list-group-item list-group-item-action">Zmień hasło</a>
                            <#if user.role == "TEACHER">
                                <a href="/add-subject" class="list-group-item list-group-item-action">Dodaj
                                    przedmiot</a>
                                <a href="/subjects" class="list-group-item list-group-item-action">Pokaż moje
                                    przedmioty</a>
                            </#if>
                            <a href="" class="list-group-item list-group-item-action" data-toggle="modal"
                               data-target="#exampleModal">Usuń konto</a>
                            <#include "modal-to-delete-user.ftlh">
                        </div>
                    </div>
                    <div class="col-md-9">
                        <@content/>
                    </div>
                </div>
            </div>
        </#if>
        <#if material ??>
            <@content/>
        </#if>

    </main>
    <#include "jsScripts.ftlh">
    </body>
    </html>
</#macro>