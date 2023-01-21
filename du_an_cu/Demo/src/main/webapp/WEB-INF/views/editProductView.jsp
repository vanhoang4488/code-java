<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sửa thông tin sản phẩm</title>
</head>
<body>
	
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	
	<h3>Sửa sản phẩm</h3>
	
	
		<form method="post" action="${pageContext.request.contextPath }/editProduct">
			<input type="hidden" name="code" value="${product.code }" />
			<table style="border:0px;">
				<tr>
					<td>Code</td>
					<td style="color:red;">${product.code }</td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" value="${product.name }"/></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="text" name="price" value="${ product.price}"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Sửa"/>
						<a href="${pageContext.request.contextPath }/productList">Quay lại</a>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<p>${errorString }</p>
					</td>
				</tr>
			</table>
		</form> 
	
	
	<jsp:include page="_footer.jsp"></jsp:include>
	
</body>
</html>