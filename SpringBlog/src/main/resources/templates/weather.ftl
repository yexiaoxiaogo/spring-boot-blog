<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" />
<title>杭州天气历史记录</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
</head>
<body class='p-4'>
	<h3 class='my-4 text-center'>杭州市天气历史记录</h3>
	<table class='table table-striped'>
		<thead>
			<tr>
				<th>城市</th>
				<th>白天天气</th>
				<th>夜间天气</th>
				<th>最高温</th>
				<th>最低温</th>
				<th>日期</th>
			</tr>
		</thead>
		<tbody>
		<#list weatherlist as weather>
			<tr>
				<td> ${weather.city.cityname} </td>
				<td> ${weather.txt_d} </td>
				<td> ${weather.txt_n} </td>
				<td> ${weather.max} </td>
				<td> ${weather.min} </td>
				<td> ${weather.date} </td>
			</tr>
		</#list>
		</tbody>
	</table>
</body>
</html>