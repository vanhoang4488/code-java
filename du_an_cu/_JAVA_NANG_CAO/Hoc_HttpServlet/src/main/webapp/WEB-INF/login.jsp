<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<form method="Post" action="${pageContext.request.contextPath }/login">
	<table>
		<tr>
			<td><label for="username">Username: </label></td>
			<td><input type="text" name="username" id="username" value="${user.username }"/></td>
		</tr>
		<tr>
			<td><label for="password">Password: </label></td>
			<td><input type="password" name="password" id="password" value="${user.password }"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<p style="color:red">${notice }</p>
			</td>
		</tr>
		<tr>
			<td align="left"><input type="submit" name="submit" value="Đăng nhập"/></td>
			<td align="right">
				<input type="checkbox" name="rememberLogin" id="rememberLogin" value="1" checked="checked"/>
				<label for="rememberLogin">Nhớ mật khẩu</label> 
			</td>
			
		</tr>
		<tr>
			<td align="left"><a href="${pageContext.request.contextPath }/registration">Đăng ký</a></td>
			<td align="right">
				<a href="${contextPage.request.contextPath }/forgetPass">Quên mật khẩu</a>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>