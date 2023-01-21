<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date, java.text.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <% 
      Date date = new Date();
      DateFormat datedf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss SSS");
    %>
    
    <h2>Current time:</h2> <%=datedf.format(date) %>
</body>
</html>