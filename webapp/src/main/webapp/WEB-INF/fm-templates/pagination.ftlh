
<div class="container">
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-end">
        <#list totalPages as currentPage>
            <#if currentPage ??>
                <li class="page-item"><a class="page-link" href="/search?filter=${filter}&input=${input}&page=${currentPage}">${currentPage}</a></li>
            </#if>
        </#list>
    </ul>
</nav>
</div>