<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <jsp:useBean id="helloBean" class="javaBean.HelloBean" ></jsp:useBean>
    
    <h3>Say Hello:</h3>
    <jsp:getProperty property="hello" name="helloBean" />
    <h1>Say again Hello:</h1>
    <jsp:setProperty property="name" name="helloBean" value="hoang"/>
    <jsp:getProperty property="hello" name="helloBean"/>
</body>
</html>