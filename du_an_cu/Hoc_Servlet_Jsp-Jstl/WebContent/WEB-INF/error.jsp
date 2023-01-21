<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  page isErrorPage = "true" import = "java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error :((</title>
</head>
<body>
	<h1>Something are wrong!!1</h1>
	<%
		java.util.Date date = new java.util.Date();
		System.out.println("Now is " + date.toString());
		System.out.println(exception.getMessage());
		exception.printStackTrace();
	%>
</body>
</html>