<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.Random, java.text.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <%
       Random random = new Random();
       int randomlt = random.nextInt(3);
       if(randomlt == 0){
     %>
     <h1>Value Random = <%=randomlt%></h1>
     <%
       }else if(randomlt == 1) {
     %>
     <h2>Value Random = <%=randomlt%></h2>
     <%
       }else {
     %>
     <h3>Value Random = <%=randomlt%></h3>
     <%
       } 
     %>
     <a href="<%=request.getRequestURI() %>">Try again</a>
     
</body>
</html>