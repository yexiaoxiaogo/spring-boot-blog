<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>登录</title>
	<#include "./common/head.ftl">
	<style>
		form.login {
			width: 200px;
			margin: 200px auto;
		}
	</style>
</head>
<body>
	<#include "./common/header.ftl">
	<form class="login" action='/login'>
		<div class='form-group'>
			<input class="form-control" name="username" placeholder="请输入你的账号" />
		</div>
		<div class='form-group'>
			<input type='password' class="form-control" name="password" placeholder="请输入你的密码" />
		</div>
		<div class='form-group text-center'>
			<button class='btn btn-primary'>登录</button>
		</div>
		<div class='form-group text-right'>
			<a class='' href='./register'>注册</a>
		</div>
	</form>
</body>
</html>