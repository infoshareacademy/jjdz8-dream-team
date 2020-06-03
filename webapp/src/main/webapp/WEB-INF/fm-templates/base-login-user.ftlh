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
         <@content/>
        </div>
    </main>
    <#include "jsScripts.ftlh">
    </body>
    </html>
</#macro>