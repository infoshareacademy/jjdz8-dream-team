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
        <a href="../../login.jsp">
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
            <a href="/user"><input class="btn btn-secondary" type="button"
                                      value="edytuj"></a>

            <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#exampleModal">
                usuń konto
            </button>
            <#if roleTeacher ??>
                <a href="../../add-subject-k.html">
                    <input class="btn btn-secondary" type="button" value="dodaj nowy przedmiot"/>
                </a>
            </#if >

        </div>

        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Usuń konto</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                       Jesteś pewny, że chcesz usunąć konto?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">nie</button>
                        <button id="delete-user" type="button" value="${user.id}" class="btn btn-primary">
                            tak
                        </button>


                    </div>
                </div>
            </div>
        </div>


        </div>
        </div><br><br>

        <#if subjects??>
            <div class="alert alert-dark" role="alert">
                Twoje aktywne przedmioty
            </div>
            <table class="table table-bordered table-hover " >
                <thead class="thead-dark">
                <tr>
                    <th scope="col">nazwa przedmiotu</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <#list subjects as subject>
                    <#if subject??>
                        <tbody>
                        <td>${subject.name}</td>
                        <td>
                            <a href="http://localhost:8080/subject?id=${subject.id}">
                                <input class="btn btn-secondary" type="button" value="show details"/>
                            </a>
                        </td>
                        </tbody>
                    </#if>
                </#list>
            </table>
        </#if>
        <br>

    </#if>
</#macro>

<@home/>