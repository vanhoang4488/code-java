<%@ page language="java" contentType="text/html;charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<html>
	<head>
		<meta charset = "Utf-8" />
		<title>Page has Error</title>
	</head>
	<body>
		<h2>Page has Error</h2>
		<%
			int i = 1000/0;
		%>
	</body>
</html>