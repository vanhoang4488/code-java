<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hiển thị thông tin Servlet</title>
</head>
<body>

	<jsp:include page="_header.jsp"/>

	<table>
		<tr>
			<th>Tên Servlet</th>
			<th>Tên lớp tạo Servlet</th>
			<th>Thông tin Servlet</th>
		</tr>
		<c:forEach items="${inforServlets}" var="inforServlet">
		<tr>
			<td><c:out value="${inforServlet.servletName }"/></td>
			<td><c:out value="${inforServlet.servletClass }"/></td>
			<td><c:out value="${inforServlet.servletInfo }"/></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>