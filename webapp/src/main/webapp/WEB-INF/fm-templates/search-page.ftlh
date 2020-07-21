<#include "base-search.ftlh">
<#macro content>

    <div class="container">
        <div class="row">
            <#if message ??>
                <p>${message}</p>
            </#if>
            <div class="col-xs-8 col-xs-offset-2">
                <nav class="navbar navbar-light bg-light">
                    <form class="form-inline" method="get" action="/search">
                        <label for="filter">search by </label>
                        <select class="form-control form-control-lg" id="filter" name="filter">
                            <option value="name">subject name</option>
                            <option value="all">all subjects</option>
                            <option value="topic">subject topic</option>
                            <option value="rangeDescription">subject range description</option>
                        </select>
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" name="input"
                               aria-label="Search">
                        <button class="btn btn-secondary" type="submit">Search</button>
                    </form>
                </nav>
            </div>
        </div>
    </div>
    <#if searchMessage ??>
        <div class="alert alert-danger" role="alert">
            ${searchMessage}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </#if>
    <#if subjects ??>
        <div class="container">
            <table class="table table-bordered table-hover ">
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
                            <a href="http://localhost:8080/subjects?id=${subject.id}&afterSearch=true">
                                <input class="btn btn-secondary" type="button" value="pokaż szczegóły"/>
                            </a>
                        </td>
                        </tbody>
                    </#if>
                </#list>
            </table>
        </div>

    </#if>

</#macro>

<@home/>