<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>c_out example</title>
</head>
<body>
	<h2>c:out example</h2>
	<c:out value="${'this is true: 10 gt 1' }"/>
	
	<br />
	Tag: <c:out value="${'<atag>, &' }"/>
</body>
</html>