<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>系统登录</title>
</head>
<body>

	<form action="login" method="post">
		<table align="center" border="1">
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="登录" />
				</td>			
			</tr>
		</table>
	
	</form>

</body>
</html>