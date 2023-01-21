<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	
	<h3>Xóa sản phẩm</h3>
	<form method="GET" action="${pageContext.request.contextPath}/deleteProduct">
		
		<table>
			<tr>
				<td><label for="code">Mã sản phẩm:</label></td>
				<td><input type="text" id="code" name="code" value=""/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="Xóa"/>
					<a href="${pageContext.request.contextPath}/productList }">Quay lại</a>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<p>${errorString}</p>
				</td>
			</tr>
		</table>
		
	</form>
	
	<jsp:include page="_footer.jsp"></jsp:include>
	
</body>
</html>