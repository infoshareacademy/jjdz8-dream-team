<#macro content>
</#macro>

<#macro home>
<!DOCTYPE html>
    <html lang="en" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html"
          xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
        <script
                src="https://code.jquery.com/jquery-3.5.0.js"
                integrity="sha256-r/AaFHrszJtwpe+tHyNi/XCfMxYpbsRg2Uqn0x3s2zc="
                crossorigin="anonymous"></script>
        <link
                rel="stylesheet"
                href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
                integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
                crossorigin="anonymous"
        />
        <link href="styles.css" rel="stylesheet"/>
        <link href="../../styles-to-teacher-account-info-page.css">
    </head>
    <body>
    <#include "menuWithLogout.ftlh" >
    <#include "headerJambutron.ftlh">
    <main role="main">
        <div class="container">
         <@content/>
        </div>
    </main>
    <script src="../../delete-subject.js"></script>
    <script src="../../delete-teacher.js"></script>
    <#include "jsScripts.ftlh">
    </body>
    </html>
</#macro>