<#if pageResult.listData?size &gt; 0 >
	<#list pageResult.listData as data>
		<tr>
			<td>${data.createUser.username }</td>
			<td>${data.title}</td>
			<td class="text-info">${data.currentRate}%</td>
			<td class="text-info">${data.bidRequestAmount}</td>
			<td>${data.returnTypeDisplay}</td>
			<td>
				<div class="">
					${data.persent!"0"} %
				</div>
			</td>
			<td>
				<#if data.hasExpType>
					<a class="btn btn-danger btn-sm" href="/expBorrow_info?id=${data.id}">查看</a>
				<#else>
					<a class="btn btn-danger btn-sm" href="/borrow_info?id=${data.id}">查看</a>
				</#if>
			</td>
		</tr>
	</#list>
<#else>
	<tr>
		<td colspan="7" align="center">
			<p class="text-danger">目前没有符合要求的标</p>
		</td>
	</tr>
</#if>

<script type="text/javascript">
	$(function(){
		$("#page_container").empty().append($('<ul id="pagination" class="pagination"></ul>'));
		$("#pagination").twbsPagination({
			totalPages:${pageResult.totalPage},
			currentPage:${pageResult.currentPage},
			initiateStartPageClick:false,
			onPageClick : function(event, page) {
				$("#currentPage").val(page);
				$("#searchForm").submit();
			}
		});
	});
</script>