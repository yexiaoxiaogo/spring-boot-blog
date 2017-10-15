<!DOCTYPE html>
<html>
<head>

<title>${title}</title>
<#include "./common/head.ftl">
<style>
	.blog {
		margin-top: 50px;
	}
</style>
</head>
<body>
	<#include "./common/header.ftl">
	<div class="blog w980">
	<h3>${title}</h3>	
	<div>${blog}</div>		
	</div>
</body>
</html>