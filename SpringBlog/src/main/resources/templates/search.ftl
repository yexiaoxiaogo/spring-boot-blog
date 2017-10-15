<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>博客列表</title>
<#include "./common/head.ftl">
<style>
	.footer {
	    width: 938px;
	    margin: 0 auto 40px;
	    min-height: 40px;
    }
	  .footer span {
	  	line-height: 40px;
	  }
</style>
</head>
<body>
	<#include "./common/header.ftl">
	<h3 class='w980' style='padding-left: 20px;'>搜索关键词："${keyword}"，共搜索到${total}篇文章</h3>
	<ul class="list-group" style="max-width: 980px; margin: 40px auto;">
		<#list results as blog>
		<li class="list-group-item border-0">
			<div class="card">
				<div class="card-header">
					${blog.title!"#暂无标题#"} 
					<small class="float-right">${blog.date?string("yyyy-MM-dd HH:mm:ss")}</small>
				</div>
				<div class="card-body">
					${blog.blog!"#暂无内容#"}
					<a class="float-right text-secondary" href='./paper/${blog.blogid}'>阅读详情 >></a>
				</div>
			</div>
		</li>
		</#list>
	</ul>
	<div class="footer">
		<nav class="float-right">
			<ul class="pagination">
				<#list 1..(pages+1) as i> <#if i== page>
				<li class="page-item active"><a class="page-link"
					href="?page=${i}">${i}</a></li>
				<#else>
				<li class="page-item "><a class="page-link" href="?keyword=${keyword}&page=${i}">${i}</a>
				</li></#if> </#list>
			</ul>
		</nav>
	</div>
</body>
</html>