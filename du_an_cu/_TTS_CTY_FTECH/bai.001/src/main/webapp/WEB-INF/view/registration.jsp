<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký tài khoản nhân viên</title>
</head>
<body>
	
	<jsp:include page="../toolbar/_header.jsp"/>
	<jsp:include page="../toolbar/_menu.jsp"/>

	<h1 align="center">Đăng ký tài khoản nhân viên</h1>
	
	<form method="post" action="${pageContext.request.contextPath }/admin/register">
		<table>
			<tr>
				<td><label for="username">Username: </label></td>
				<td><input type="text" name="username" id="username" value="${employee.username}"/></td>
			</tr>
			<tr>
				<td><label for="password">Password: </label></td>
				<td><input type="password" name="password" id="password" value="${employee.password}"/></td>
			</tr>
			<tr>
				<td><label for="id">Id: </label></td>
				<td><input type="text" name="id" id="id" value="${employee.id}"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="register" value="Đăng ký"/>
				</td>
			</tr>
		</table>
	</form>

	<jsp:include page="../toolbar/_footer.jsp"/>
</body>
</html>