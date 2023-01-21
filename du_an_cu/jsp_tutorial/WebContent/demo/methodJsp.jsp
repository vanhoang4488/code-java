<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <%!
      public int cong(int a, int b){
	    return a+b;
      } 
   
      public int tru(int a, int b){
    	 return a-b;  
      }
    %>
    
    <h1> value = <%=cong(3,5) %></h1>
</body>
</html>