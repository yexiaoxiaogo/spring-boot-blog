<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

	
	<div class="collapse navbar-collapse" id="navbarToggler">
		<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
		  <li class="nav-item">
		    <a class="nav-link" href="/unlisted">首页</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="/listed">我的文章</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="http://localhost:8888/test">天气</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="/write">写文章</a>
		  </li>
		</ul>
		
		<#if user??>
			<span>${user.username} <a  class="mr-4 ml-2" href="/logout">登出</a></span>
		<#else>
			<span> <a class="btn-link mr-3" href="/login">登录</a><a class="btn-link mr-4" href="/register">注册</a></span>
		</#if>
		
		<form class="form-inline my-2 my-lg-0" action="/search">
	      <input class="form-control mr-sm-2" type="text" name="keyword" placeholder="请输入文章关键词" aria-label="Search">
	      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
	    </form>
    </div>
</nav>
<script>
	Array.from(document.querySelectorAll('.nav-item')).map(ele => {
		if (ele.querySelector('a').href == location.href) {
			ele.classList.add('active');
		}
	});
</script>