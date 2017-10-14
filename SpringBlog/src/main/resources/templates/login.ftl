<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>登录</title>
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
	<form action='/login'>
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