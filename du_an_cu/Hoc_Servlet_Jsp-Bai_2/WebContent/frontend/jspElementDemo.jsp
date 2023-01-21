<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<?xml version="1.0" ?>    
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:element name="data">
		<h3>Hello jsp:element</h3>
	
		<jsp:useBean id="emp" class="servlet.Employee">
			<jsp:setProperty name="emp" property="empNo" value="EO1"/>
			<jsp:setProperty name="emp" property="empName" value="Hoang"/>
		</jsp:useBean>
	
		<jsp:element name="employee">
			<jsp:attribute name="empNo" trim="true">
				<jsp:getProperty name="emp" property="empNo"/>
			</jsp:attribute>
		
			<jsp:body>
				<jsp:getProperty name="emp" property="empName"/>
			</jsp:body>
		</jsp:element>
	</jsp:element>
</body>
</html>