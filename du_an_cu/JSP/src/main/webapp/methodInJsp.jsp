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
		
		public int sum (int a, int b){
			return a + b;
		}
	
	%>
	
	<h1> 1 + 2 = <%= sum(1, 2) %></h1>

</body>
</html>