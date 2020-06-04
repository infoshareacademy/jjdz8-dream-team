<#include "base-search.ftlh">
<#macro content>

    <div class="container">
        <div class="row">
            <#if message ??>
                <p>${message}</p>
            </#if>
            <form method="post" action="/filter-subjects">
                <div class="col-xs-8 col-xs-offset-2">
                    <div class="input-group">
                        <div class="form-group col-md-6">
                            <p>Search by</p>
                            <select id="filter" name="filter">
                                <option value="name">subject name</option>
                                <option value="all">all subjects</option>
                                <option value="topic">subject topic</option>
                                <option value="rangeDescription">subject range description</option>
                                <option value="nickName">teacher nickname</option>
                                <option value="ranking">subjects ranking</option>
                            </select>
                        </div>
                        <div class="form-group col-md-6">
                            <input type="text" class="form-control" name="input" placeholder="Search term...">
                            <span class="input-group-btn">
                    <button class="btn btn-default" type="submit"><span
                                class="glyphicon glyphicon-search"></span></button>
                </span>
                        </div>
                    </div>
                </div>
            </form>
        </div>

    </div>

</#macro>

<@home/>