<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hiển thị danh sách xe hơi</title>
<style>
	table, td{
		border: 2px solid black;
		border-collapse: collapse;
		text-align: center;
	}
	
	table{
		position: absolute;
          left: 21%;
          top: 20%;
	}
</style>
</head>
<body>
	
	<h1 align="center">Danh sách sản phẩm</h1>
	
	<table>
	<c:forEach items="${carsList }" var="car">
		<tr>
			<%-- Cột hiển thị hình ảnh và task thay đổi hình ảnh --%>
			<td>				
				<img width="200px" height="200px" src="${car.imageUrl}" alt="hình ảnh"/>
				<br/><a href="${pageContext.request.contextPath }/carDetail?carID=${car.carID}">Xem chi tiết</a>
			</td>
			
			<%--- Cột hiển thị thông tin xe ô tô --%>
			<td>
				<b><c:out value="${car.carName }"/></b><br/>
				<p><c:out value="${car.rate }"/></p><br/>
				<pre><c:out value="${car.description }"/></pre><br/>
				<del><c:out value="${car.price+100}"/></del>&ensp;<ins><c:out value="${car.price }"/></ins><br/>
				<i><c:out value="${car.quantily }"/></i><b style="color:red;"> Chiếc</b>
			</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>