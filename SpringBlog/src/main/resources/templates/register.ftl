<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>注册</title>
	<#include "./common/head.ftl">
	<style>
		form.register {
		    width: 300px;
		    margin: 200px auto;
		    padding: 40px;
		    box-shadow: 0 0 6px 1px #ccc;
		    border-radius: 5px;
		}
		form.register .btn {
		    width: 100%;
		}
	</style>
</head>
<body>
<#include "./common/header.ftl">
	<form class="register">
	<h5 class="text-center mb-4">注册账号</h5>
		<div class='form-group'>
			<input class="form-control" name="username" id="username" placeholder="请输入你的用户名" onblur="check(this)" />
		</div>
		<div class='form-group'>
			<input type='password' class="form-control" name="password" id="password" placeholder="请输入你的密码" />
		</div>
		<div class='form-group text-center'>
			<button class='btn btn-primary' id="register" >注册</button>
		</div>
	</form>

	<script>
		$('form').on('submit', function(e) {
			e.preventDefault();
			e.stopPropagation()
			fetch('/register', {
        			method: 'post',
        			body: JSON.stringify({
            			username: document.querySelector('#username').value,
            			password: document.querySelector('#password').value,
            		}),
            		credentials: "include",
            		headers: {
       
            			'Content-Type': 'application/json'
            		}
        		})
				.then(function(r) {
					return r.json();
				})
				.then(function(r) {
					alert('注册成功');
					location.href = './login';
				});
		});
	</script>
	<script type="text/javascript">
		function check(input) {
			//http://localhost:8080/username?username=119
			fetch('/username?username=' + input.value).then(function(response) {
				return response.json();
			}).then(function(data) {
				console.log(data);
				if (data.code === 1) {
					alert('用户名已被注册')
					document.querySelector('#register').disabled = true;
				} else {
					document.querySelector('#register').disabled = false;
				}
			})

		}
	</script>
</body>
</html>