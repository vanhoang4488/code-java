<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lỗi rồi :((</title>
</head>
<body>

	<jsp:include page="../toolbar/_menu.jsp"/>
	
	<h1 align="center">Đã xảy ra lỗi, Vui lòng thử lại!!1</h1>
	
	<h3>Mã lỗi:</h3>
	<p>${exception.message }</p><br/>
	
	<b>Lỗi cụ thể như sau:</b>
	<pre>
		${out.println(exception.toString)}
	</pre>
	
	<jsp:include page="../toolbar/_footer.jsp"/>
	
</body>
</html>