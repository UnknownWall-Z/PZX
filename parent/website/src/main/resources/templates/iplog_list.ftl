<#list pageResult.listData as item>
    <tr>
    <td>${item.username}</td>
    <td>${item.loginTime?string("yyyy-MM-dd HH:mm:ss")}</td>
    <td>${item.ip}</td>
    <td>${item.stateDisplay}</td>
    </tr>
</#list>
<script type="text/javascript">
    $(function () {
        $("#page_container").empty().append($('<ul id="pagination" class="pagination"></ul>'));
        $("#pagination").twbsPagination({
            totalPages:${pageResult.totalPage},
            startPage:${pageResult.currentPage},
            visiblePages:5,
            first : "首页",
            prev : "上一页",
            next : "下一页",
            last : "最后一页",
            onPageClick:function (event,page) {
                $("#currentPage").val(page);
                $("#searchForm").submit();
            }
        })
    });
</script>