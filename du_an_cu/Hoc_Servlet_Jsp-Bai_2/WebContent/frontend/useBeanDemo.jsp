<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="helloBean" class="servlet.HelloBean">jsp:useBean</jsp:useBean>
	
	<h3>Say Hello:</h3>
	<jsp:getProperty name="helloBean" property="hello" />
	
	<jsp:setProperty name="helloBean" property="name" value="JSP" />
	<h3>Say Hello after setName</h3>
	<jsp:getProperty name="helloBean" property="hello" />
</body>
</html>