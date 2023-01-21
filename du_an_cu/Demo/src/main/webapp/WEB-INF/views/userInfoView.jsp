<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Thông tin người dùng</title>
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<h3>Xin chào: ${user.userName }</h3>
	
	Người dùng: <b>${user.userName }</b>
	<br />
	Giới tính: ${user.gender }
	<br />
	
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>