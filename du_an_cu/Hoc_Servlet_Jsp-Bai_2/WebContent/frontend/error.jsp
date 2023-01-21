<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isErrorPage = "true" import = "java.io.*" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Sorry, Website Error :((</h1>
	<%
		java.util.Date date = new java.util.Date();
		System.out.println("Now is " + date.toString());
		System.out.println(exception.getMessage());
		exception.printStackTrace();
	%>
</body>
</html>