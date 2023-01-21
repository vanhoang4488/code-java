<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
</head>
<body>

	<h1 align="center">Quên mật khẩu</h1>
	
	<form method="post" action="${pageContext.request.contextPath }/user/forgetPassword">
		<table>
			<tr>
				<td colspan="2"><i style="color:red">${notice }</i></td>
			</tr>
			<tr>
				<td><label for="username">Username</label></td>
				<td><input type="text" name="username" id="username"/></td>
			</tr>
			<tr>
				<td><label for="email">email</label></td>
				<td><input type="text" name="email" id="email"/></td>
			</tr>
			<tr>
				<td><input type="text" name="captcha"></td>
				<td>${captcha }</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="findAgainPass" value="Gửi"/>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>