<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jstl c_choose</title>
</head>
<body>
	<h2>c:choose, c:when, c:otherwise example</h2>
	<c:choose>
		<c:when test="${param.color=='red' }">
			<p style="color:red;">RED COLOR</p>
		</c:when>
		
		<c:when test="${param.color=='blue' }">
			<p style="color:blue;">BLUE COLOR</p>
		</c:when>
		
		<c:otherwise>
			<b>Other color</b>
		</c:otherwise>
	</c:choose>
</body>
</html>