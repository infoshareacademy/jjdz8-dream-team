<#ftl encoding="utf-8">
<#macro content>
</#macro>

<#macro home>
    <!DOCTYPE html>
    <html lang="pl" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html"
          xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
    <#include "headhtml.ftlh">
    <body>
    <#include "menu-with-login.ftlh" >
    <#include "headerJambutron.ftlh">
    <main role="main">
        <div class="container">
            <#if message ??>
                <h1>zaloguj się bądź zarejestruj by uzyskać dostęp</h1>
                <a href="../../html_js_css_Jsp_files/login.jsp">
                    <input type="button" class="btn btn-secondary" value="zaloguj"/>
                </a>
                <a href="http://localhost:8080/newAccount.jsp">
                    <input type="button" class="btn btn-secondary" value="zarejestruj"/>
                </a>
            <#else>
                <@content/>
            </#if>
        </div>
    </main>
    <#include "jsScripts.ftlh">
    </body>
    </html>
</#macro>