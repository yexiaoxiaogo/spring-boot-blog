<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  
	<a class="navbar-brand" href="#">个人博客</a>
	
	<div class="collapse navbar-collapse" id="navbarToggler">
		<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
		  <li class="nav-item">
		    <a class="nav-link active" href="/unlisted">首页</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="/listed">我的文章</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="/weather">天气</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="/write">写文章</a>
		  </li>
		</ul>
		
		<#if user??>
			<span>${user.username} <a href="/logout">登出</a></span>
		<#else>
			<span>请登录</span>
		</#if>
		
		<form class="form-inline my-2 my-lg-0" action="/search">
	      <input class="form-control mr-sm-2" type="text" name="keyword" placeholder="请输入文章关键词" aria-label="Search">
	      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
	    </form>
    </div>
</nav>