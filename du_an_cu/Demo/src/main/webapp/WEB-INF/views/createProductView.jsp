<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm sản phẩm</title>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	
	<form method="GET" action="${pageContext.request.contextPath }/createProduct"> 
		<table>
			<tr>
				<th><label for="code">Code: </label></th>
				<td><input type="text" id="code" name="code" value="${code }" /></td>
			</tr>
			<tr>
				<th><label for="name">Name: </label></th>
				<td><input type="text" id="name" name="name" value="${name }" /></td>
			</tr>
			<tr>
				<th><label for="price">Price: </label></th>
				<td><input type="number" id="price" name="price" value="${price }" /></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="Thêm"/>
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