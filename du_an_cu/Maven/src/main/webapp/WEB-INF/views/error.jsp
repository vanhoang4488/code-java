<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%@ page import="java.io.*" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lỗi</title>
</head>
<body>

	<h1>Một vài lỗi đã xảy ra</h1>
	<%=exception.getMessage() %>
	
	<h3>Chi tiết:</h3>
	<%
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		exception.printStackTrace(pw);
		out.println("<pre>");
		out.println(pw);
		out.println("</pre>");
		sw.close();
		pw.close();
	%>

</body>
</html>