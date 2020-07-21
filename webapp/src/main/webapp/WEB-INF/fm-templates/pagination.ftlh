
<div class="container">
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-end">
    <#--    <li class="page-item disabled">
            <a class="page-link" href="#" tabindex="-1">Previous</a>
        </li>-->
        <#list totalPages as currentPage>
            <#if currentPage ??>
                <li class="page-item"><a class="page-link" href="/search?filter=${filter}&input=${input}&page=${currentPage+1}">${currentPage+1}</a></li>
            </#if>
        </#list>

     <#--   <li class="page-item">
            <a class="page-link" href="#">Next</a>
        </li>-->
    </ul>
</nav>
</div>