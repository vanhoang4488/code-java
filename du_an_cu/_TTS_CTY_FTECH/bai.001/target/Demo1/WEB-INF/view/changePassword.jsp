<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đổi mật khẩu</title>
</head>
<body>

	<jsp:include page="../toolbar/_header.jsp">
	<jsp:include page="../toolbar/_menu.jsp">
	
	<h1 align="center">Đổi mật khẩu</h1>
	
	<form method="post" action="${pageContext.request.contextPath }/user/changePassword">
		<table>
			<tr>
				<td colspan="2"><i style="color:red">${notice }</i></td>
			</tr>
			<tr>
				<td><label for="oldPass">Mật khẩu cũ</label></td>
				<td><input type="password" name="oldPass" id="oldPass"/></td>
			</tr>
			<tr>
				<td><label for="newPass">Mật khẩu mới</label></td>
				<td><input type="password" name="newPass" id="newPass"/></td>
			</tr>
			<tr>
				<td><label for="reversenewPass">Xác nhận mật khẩu</label></td>
				<td><input type="password" id="reversenewPass"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="change" value="Đổi mật khẩu"/>
				</td>
			</tr>
		</table>
	</form>
	
	<jsp:include page="../toolbar/_footer.jsp"/>
	
</body>
</html>