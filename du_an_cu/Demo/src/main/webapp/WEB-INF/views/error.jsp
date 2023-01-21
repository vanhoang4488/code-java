<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ page import="java.io.*" %>    
<!DOCTYPE html>
<html>
<head>
<title>Error</title>
</head>
<body>
	<h1>Trang bị lỗi :((</h1>
	
	Message:<%=exception.getMessage() %>
	
	<%
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		exception.printStackTrace(pw);
		out.println("<pre>");
		out.println(sw);
		out.println("</pre>");
		pw.close();
		sw.close();
	%>
</body>
</html>