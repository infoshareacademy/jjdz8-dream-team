
<div class="container">
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-end">
    <#--    <li class="page-item disabled">
            <a class="page-link" href="#" tabindex="-1">Previous</a>
        </li>-->
        <#list 1..totalPages as currentPage>
            <#if currentPage ??>
                <li class="page-item"><a class="page-link" href="/search?page=${currentPage}">${currentPage}</a></li>
            </#if>
        </#list>

     <#--   <li class="page-item">
            <a class="page-link" href="#">Next</a>
        </li>-->
    </ul>
</nav>
</div>