<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>
	
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	
	<h3>Trang chủ</h3>
	
	<i>Đây là một demo nhỏ sử dụng jsp, Servlet,jsp, jdbc</i>
	
	<b>Các trang hiện có:</b>
	<ul>
		<li> <a href="${pageContext.request.contextPath }/login">Đăng nhập</a> </li>
		<li> <a href="${pageContext.request.contextPath }/userInfo">Thông tin người dùng</a></li>
		<li> <a href="${pageContext.request.contextPath }/productList">Danh sách sản phẩm</a> </li>
		<li> <a href="${pageContext.request.contextPath }/createProduct">Tạo sản phẩm</a> </li>
		<li> <a href="${pageContext.request.contextPath }/editProduct">Sửa sản phẩm</a> </li>
		<li> <a href="${pageContext.request.contextPath }/deleteProduct">Xóa sản phẩm</a> </li>
	</ul>
	
	<jsp:include page="_footer.jsp"></jsp:include>
	
</body>
</html>