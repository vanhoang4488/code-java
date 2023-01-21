<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>

	<jsp:include page="_header.jsp"/>

	<h1 align="center">Chào mừng bạn đến trang chủ</h1>

	<a href="${pageContext.request.contextPath }/userdetail">Xem thông tin người dùng</a><br/>
	<a href="${pageContext.request.contextPath }/carsList">Hiển thị danh sách xe hơi.</a><br/>
	<a href="${pageContext.request.contextPath }/interServlet">Xem thông tin các Servlet</a><br/>
	<a href="${pageContext.request.contextPath }/Parameters">Xem thông tin các tham số gửi theo request về Server</a><br/>
	<a href="${pageContext.request.contextPath }/session">Xem thông tin trong Session</a><br/>
	<a href="${pageContext.request.contextPath }/header">Ví dụ về Header</a><br/>
	<a href="${pageContext.request.contextPath }/showHeader">Xem thông tin về Header</a><br/>
</body>
</html>