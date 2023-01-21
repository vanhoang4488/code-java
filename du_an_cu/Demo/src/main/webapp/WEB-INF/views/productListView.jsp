<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách sản phẩm</title>
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	<h2>Danh sách sản phẩm</h2>
	
	<table style="border:1px;">
		<tr>
			<td>Code</td>
			<td>Name</td>
			<td>Price</td>
		</tr>
		<c:forEach items="${productList }" var="list">
		<tr>
			<td>${list.code }</td>
			<td>${list.name }</td>
			<td>${list.price }</td>
		</tr>
		</c:forEach>
	</table>
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>