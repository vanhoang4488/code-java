<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage = "error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>c_set Example</title>
</head>
<body>
	<h2>c:set Example</h2>
	
	<c:set scope="request" var="greeting" value="Hello every body"/>
	
	Greeting : <c:out value="${greeting }"/>
	<br /> <br />
	
	<c:remove scope="request" var="greeting"/>
	After remove:
	<br />
	
	Greeting:<c:out value="greeting"/>
</body>
</html>