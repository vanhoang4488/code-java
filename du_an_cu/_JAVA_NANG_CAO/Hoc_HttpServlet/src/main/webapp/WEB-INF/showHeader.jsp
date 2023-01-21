<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Hiển thị Header</title>
	<style>
		table, th, td{
			border: 2px solid black;
			border-collapse: collapse;
		}	
	</style>
</head>
<body>
	
	<jsp:include page="_header.jsp"/>
	
	<h3>Method: </h3>
	<p><c:out value="${pageContext.request.method }"/></p> 
	
	<h3>Uri: </h3>
	<p><c:out value="${pageContext.request.requestURI }"/></p> 
	
	<h3>Protocol: </h3>
	<p><c:out value="${pageContext.request.protocol }"/></p>
     
     <h3>Header: </h3>
	<p><c:out value="${header }"/></p>
     
	<table>
		<tr>
			<th>Tên tiêu đề</th>
			<th>Thông tin tiêu đề</th>
		</tr>
		
		<c:forEach items="${headers }" var="headers">
		<tr>
			<td><c:out value="${headers.headerName}"/></td>
			<td><c:out value="${headers.headerInfo }"/></td>
		</tr>
		</c:forEach>
	</table>	
</body>
</html>