<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>博客列表</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
	
	<style>
		form {
			width: 200px;
			margin: 200px auto;
		}
	</style>
</head>
<body>
	<a href='./write'><h2>写文章</h2></a>
	<ul>
	<#list results as blog>
	   <li>
	   		<a href='./paper?id=${blog.blogid}'>
	   			<h3>${blog.title!"#暂无标题#"} <small>${blog.date?string("yyyy-MM-dd HH:mm:ss")}</small></h3>
	   		</a>
	   		
	   </li> 
	</#list>
	</ul>
	<p>共${total}条数据</p>
	<nav aria-label="Page navigation example">
	  <ul class="pagination">
	  	<#list 1..pages as i>
	  		<#if i == page>
		    	<li class="page-item active">
		    		<a class="page-link" href="?page=${i}">${i}</a>
		    	</li>
	    	<#else>
				<li class="page-item ">
	    			<a class="page-link" href="?page=${i}">${i}</a>
	    		</li>
	    	</#if>
	    </#list>
	  </ul>
	</nav>
</body>
</html>