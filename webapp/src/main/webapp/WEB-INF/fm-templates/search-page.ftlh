<#include "base-search.ftlh">
<#macro content>

    <div class="container">
        <div class="row">
            <#if message ??>
                <p>${message}</p>
            </#if>
            <div class="col-xs-8 col-xs-offset-2">
                <div class="input-group">
                    <div class="input-group-btn search-panel">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                            <span id="search_concept">Filter by</span> <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#contains">Teacher Nickname</a></li>
                            <li><a href="#its_equal">Subject name</a></li>
                            <li><a href="#greather_than">subject topic</a></li>
                            <li><a href="#less_than">subject description</a></li>
                            <li><a href="#less_than">has video lessons</a></li>
                            <li class="divider"></li>
                            <li><a href="/filter-subjects?filter=all">Averything</a></li>
                        </ul>
                    </div>
                    <input type="hidden" name="search_param" value="all" id="search_param">
                    <input type="text" class="form-control" name="x" placeholder="Search term...">
                    <span class="input-group-btn">
                    <button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search"></span></button>
                </span>
                </div>
            </div>
        </div>
    </div>

</#macro>

<@home/>