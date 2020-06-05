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
        <div class="container">
            <#if message ??>
                <h1>You have to login or registry first</h1>
                <a href="http://localhost:8080/logout.jsp">
                    <input type="button" value="login"/>
                </a>
                <a href="http://localhost:8080/newAccount.jsp">
                    <input type="button" value="registry"/>
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