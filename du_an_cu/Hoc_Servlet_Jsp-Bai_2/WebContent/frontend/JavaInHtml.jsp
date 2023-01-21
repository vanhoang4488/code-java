<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.Random, java.text.*"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bai 2</title>
</head>
<body>
	<%
		Random random = new Random();
	
	 	int randomInt = random.nextInt(3);
	 	
	 	if(randomInt == 0){
	 		out.println("<h1>Random value = " + randomInt + "</h1>");
	 	}else if(randomInt == 1){
	 		out.println("<h2>Random value = " + randomInt + "</h2>");
	 	}else {
	 		out.println("<h3>Random value = " + randomInt + "</h3>");
	 	}
	%>
	
	<a href="<%= request.getRequestURI()%>">Try Again</a>
</body>
</html>