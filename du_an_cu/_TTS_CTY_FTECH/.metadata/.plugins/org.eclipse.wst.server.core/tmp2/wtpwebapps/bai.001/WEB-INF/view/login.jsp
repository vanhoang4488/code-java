<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<script type="text/javascript">
    function submitform(){
    	alert("Sending Json");
        var xhr = new XMLHttpRequest();
        xhr.open(form.method, form.action, true);
        xhr.setRequestHeader("Content-Type", "multipart/form-data; charset=UTF-8");
        xhr.setRequestHeader("Accept", "multipart/form-data");
        var formData = JSON.stringify($("#myForm").serializeArray());
        xhr.send(formData);
    }
</script>
</head>
<body>

	<h1>Chào mừng bạn đến với trang CTV</h1>
	
	<form id="myForm" method="POST" action="${pageContext.request.contextPath }/user/login/">
		<table>
			<tr>
				<td colspan="2"><i style="color:red">${notice }</i></td>
			</tr>
			<tr>
				<td><label for="username">Username</label></td>
				<td><input type="text" name="username" id="username" maxlength="20"/></td>
			</tr>
			<tr>
				<td><label for="password">Password</label></td>
				<td><input type="password" name="password" id="password" maxlength="16"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="login" value="Đăng nhập" onclick="submitform()"></td>
				<td><input type="checkbox" name="rememberPassword" value="rememberPassword">Nhớ mật khẩu</td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/user/changePassword">Đổi mật khẩu</a></td>
				<td><a href="${pageContext.request.contextPath}/user/forgetPassword">Quên mật khẩu</a></td>
			</tr>
		</table>
	</form>
	
	<jsp:include page="../toolbar/_footer.jsp"/>

</body>
</html>