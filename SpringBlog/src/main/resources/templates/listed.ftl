<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>博客列表</title>
<#include "./common/head.ftl">
<style>
	.footer {
	    width: 938px;
	    margin: 40px auto;
	    min-height: 40px;
    }
	  .footer span {
	  	line-height: 40px;
	  }
</style>
</head>
<body>
	<#include "./common/header.ftl">

	<ul class="list-group" style="max-width: 980px; margin: 40px auto;">
		<#list results as blog>
		<li class="list-group-item border-0">
			<div class="card">
				<div class="card-header">
					${blog.title!"#暂无标题#"} 
					<small class="float-right">${blog.date?string("yyyy-MM-dd HH:mm:ss")}</small>
				</div>
				<div class="card-body">
	
						${blog.blog}
	
					
					<a class="float-right text-secondary" href='./paper/${blog.blogid}'>阅读详情 >></a>
				</div>
			</div>
		</li>
		</#list>
	</ul>
	<div class="footer">
		<span class="text-secondary">共${total}篇文章</span>
		<nav class="float-right">
			<ul class="pagination">
				<#list 1..pages as i> <#if i== page>
				<li class="page-item active"><a class="page-link"
					href="?page=${i}">${i}</a></li>
				<#else>
				<li class="page-item "><a class="page-link" href="?page=${i}&pagesize=${pagesize}">${i}</a>
				</li></#if> </#list>
			</ul>
		</nav>
	</div>
</body>
</html>