<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello Jsp</h1>
	<%
		java.util.Date date = new java.util.Date();
	%>
	
	<h2>
		Now is
		<%= date.toString() %>
	</h2>
	
	<%
		out.println("<h3>Hello World</h3>");
	
		String serverName = request.getServerName();
		
		out.println(serverName);
		
		response.sendRedirect("http://eclipse.org");
	%>
</body>
</html>