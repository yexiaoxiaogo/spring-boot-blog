<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>登录</title>
	<#include "./common/head.ftl">
	<style>
		form.login {
    width: 300px;
    margin: 200px auto;
    padding: 40px;
    box-shadow: 0 0 6px 1px #ccc;
    border-radius: 5px;
		}
		form.login .btn {
		    width: 100%;
		   }
	</style>
</head>
<body>
	<#include "./common/header.ftl">
	<form class="login" action='/login'>
		<h5 class="text-center mb-4">登录账号</h5>
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