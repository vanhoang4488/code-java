<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp" %>
<%@ page import = "utils.CookieUtils" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cookie Demo</title>
</head>
<body>
	
	<%
		CookieUtils.demoUserCookie(request, response, out);
	%>
	
	<a href="">Try again!!</a>
	
</body>
</html>