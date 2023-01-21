<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hiển thị chi tiết thông tin ô tô</title>
<style type="text/css">
	table{
		position: absolute;
		left: 27%;
		top: 20%;
	}
	
	table, td{
		text-align:center;
	}
</style>
</head>
<body>

	<h1 align="center">Thông tin chi tiết xe: <b style="color:red;">${car.carName }</b></h1>

	<table>
		<tr>
			<td>
				<img width="300px" height="300px" src="${car.imageUrl }" alt="hình ảnh"/>
			</td>
		</tr>
		<tr>
			<td>
				<form method="Post" action="${pageContext.request.contextPath }/carDetail" enctype="application/x-www-form-urlencoded">
					<input type="hidden" name="carID" value="${car.carID }"/>
					<input type="file" name="imageUrl" value=""/>
					<input type="submit" name="submit" value="Đổi ảnh"/>
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<p style="color:red;">${notice }</p><br/>
				<b>${car.carName }</b>
			</td>
		</tr>
		<tr>
			<td>
				<p>${car.rate }</p>
			</td>
		</tr>
		<tr>
			<td>
				<pre>${car.description }</pre>
			</td>
		</tr>
		<tr>
			<td>
				<del>${car.price + 100 }</del>
				&ensp;
				<ins>${car.price }</ins>
			</td>
		</tr>
		<tr>
			<td>
				<b>${car.quantily } Chiếc</b>
			</td>
		</tr>
	</table>
	
</body>
</html>