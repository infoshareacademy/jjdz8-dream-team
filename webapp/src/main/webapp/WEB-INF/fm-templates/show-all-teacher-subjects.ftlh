<#include "base-login-user.ftlh">
<#macro content>
    <div class="row">
    <div class="col-md-12">
    <#if message ??>
        <h1>zaloguj się bądź zarejestruj by uzyskać dostęp</h1>
        <a href="../../html_js_css_Jsp_files/login.jsp">
            <input type="button" value="zaloguj"/>
        </a>
        <a href="http://localhost:8080/add-user.jsp">
            <input type="button" value="zarejestruj"/>
        </a>
    </#if>
        <#if user.subjects ??>
            <div class="alert alert-dark" role="alert">
                Twoje aktywne przedmioty
            </div>
            <table class="table table-bordered table-hover ">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">nazwa przedmiotu</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <#list user.subjects as subject>
                    <#if subject??>
                        <tbody>
                        <td>${subject.name}</td>
                        <td>
                            <a href="http://localhost:8080/subjects?id=${subject.id}">
                                <input class="btn btn-secondary" type="button" value="pokaż szczegóły"/>
                            </a>
                            <button type="button" class="btn btn-danger" data-toggle="modal"
                                    data-target="#subjectModal${subject.id}">
                                usuń przedmiot
                            </button>
                            <div class="modal fade" id="subjectModal${subject.id}" tabindex="-1" role="dialog"
                                 aria-labelledby="#exampleModalLabel${subject.id}"
                                 aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel${subject.id}">usuń przedmiot</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            Jesteś pewny, że chcesz usunąć ten przedmiot: ${subject.name}?
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">nie
                                            </button>
                                            <button id="delete-subject${subject.id}" type="button" value="${subject.id}" name="id"
                                                    class="delete-subject btn btn-primary" >
                                                tak
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </td>
                        </tbody>
                    </#if>
                </#list>
            </table>
        </#if>
        <br>
</#macro>
<@home/>