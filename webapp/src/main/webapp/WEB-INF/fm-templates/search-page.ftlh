<#include "base-search.ftlh">
<#macro content>

    <div class="container">
        <div class="row">
            <#if message ??>
                <p>${message}</p>
            </#if>
                <div class="col-xs-8 col-xs-offset-2">
                    <nav class="navbar navbar-light bg-light">
                        <form class="form-inline" method="post" action="/filter-subjects">
                            <label for="filter">search by   </label>
                             <select class="form-control form-control-lg" id="filter" name="filter">
                                <option value="name">subject name</option>
                                <option value="all">all subjects</option>
                                <option value="topic">subject topic</option>
                                <option value="rangeDescription">subject range description</option>
                                <option value="nickName">teacher nickname</option>
                            </select>
                                <input class="form-control mr-sm-2" type="search" placeholder="Search" name="input" aria-label="Search">
                                <button class="btn btn-secondary" type="submit">Search</button>
                            </form>
                        </nav>
                    </div>
                </div>
        </div>

</#macro>

<@home/>