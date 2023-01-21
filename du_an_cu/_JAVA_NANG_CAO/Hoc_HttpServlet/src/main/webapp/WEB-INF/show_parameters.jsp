<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Hiển thị tham số</title>
<style>
	table, th, td{
		border: 2px solid black;
		border-collapse: collapse;
	}
</style>
</head>
<body bgcolor='#FDF5E6'>

	<jsp:include page="_header.jsp"/>

	<h1 align='center'>${title}</h1>
	<table>
		<tr bgcolor='#FFAD00'>
			<th>Parameter Name</th>
			<th>Parameter Value</th>
		</tr>
		
		<c:forEach items="${parameters}" var="parameters">
		<tr>
			<td rowspan="${parameters.valuesLength }"><c:out value="${parameters.name }" /></td>
			<td><c:out value="${parameters.values[0] }" /></td>
		</tr>
		
		<%-- tham số có nhiều giá trị --%>
		<c:if test="${parameters.valuesLength > 1 }">
		<c:set scope="request" var="i" value="0" />
			<c:forEach items="${parameters.values }" var="value">
				<c:choose>
				<%-- đánh dấu, giá trị đầu tiên không in ra nữa. --%>
				<c:when test="${i==0 }">
					<c:set scope="request" var="i" value="1"></c:set>
				</c:when>
				
				<%-- In ra tiếp từ giá trị thứ 2 --%>
				<c:otherwise>
					<tr>
						<td><c:out value="${value }" /></td>
					</tr>
				</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:if>
		</c:forEach>
	</table>	
</body>
</html>