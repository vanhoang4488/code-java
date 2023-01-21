<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp" %>    
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Processing</title>
</head>
<body>
	<h3>Parameter value: </h3>
	<%
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String gender = request.getParameter("gender");
		
		String[] address = request.getParameterValues("address");
	%>
	
	UserName: <%= userName%> <br />
	Password: <%= password%> <br />
	FirstName: <%= firstName%> <br />
	LastName: <%= lastName%> <br />
	
	Gender: <%= gender %> <br />
	
	<%
		if(address != null){
			for(String addr : address){
	%>
	
	Address: <%= addr %> <br />
	
	<% }} %>
</body>
</html>