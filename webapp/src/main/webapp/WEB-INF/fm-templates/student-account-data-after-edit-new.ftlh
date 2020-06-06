<#include "base-login-user.ftlh">
<#macro content>
    <div class="card">
        <div class="card-header">
            Dane logowania
        </div>
        <div class="row">
            <div class="col-md-4">
            <#--    <#if message ??>
                    <h1>You have to login or registry first</h1>
                    <a href="http://localhost:8080/logout-form.jsp">
                        <input type="button" value="login"/>
                    </a>
                    <a href="http://localhost:8080/add-user.jsp">
                        <input type="button" value="registry"/>
                    </a>
                </#if>-->
                <#if user ?? >
               <#include "user-card-with-picture.ftlh">
            </div>
            <div class="col-md-6">
                <form  method="post" action="http://localhost:8080/edit-student-account">
              <#include "user-form-content-after-edit.ftlh">
                </form>
            </div>
            </#if>
        </div>
    </div>
    </div>
</#macro>

<@home/>




