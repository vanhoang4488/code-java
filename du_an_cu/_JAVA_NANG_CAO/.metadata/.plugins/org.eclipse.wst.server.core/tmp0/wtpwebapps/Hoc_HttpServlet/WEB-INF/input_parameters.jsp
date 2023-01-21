<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Nhập tham số</title>
</head>
<body bgcolor='#FDF5E6'>
	
	<jsp:include page="_header.jsp"/>

	<h1 align='center'>Một biểu mẫu nhập thông tin đơn giản</h1>
	<form method="post" action="${pageContext.request.contextPath }/Parameters">
		<table>
			<tr>
				<td><label for="itemNum">Item Number: </label></td>
			    <td><input type="text" name="itemNum" id="itemNum" value=""/></td>
			</tr>
			<tr>
				<td><label for="quantity">Quantity: </label></td>
				<td><input type="text" name="quantity" id="quantity" value=""/></td>
			</tr>
			<tr>
				<td><label for="price">Price: </label></td>
				<td><input type="number" name="price" id="price" min="1" max="9999999" /></td>
			</tr>
			<tr>
				<td><label for="firstName">First Name: </label></td>
				<td><input type="text" name="firstName" id="lastName" value=""/></td>
			</tr>
			<tr>
				<td><label for="lastName">Last Name: </label></td>
				<td><input type="text" name="lastName" id="lastName" value=""/></td>
			</tr>
			<tr>
				<td><label for="inital">Middle Inital: </label></td>
				<td><input type="text" name="inital" id="inital" value=""/></td>
			</tr>
			<tr>
				<td><label for="address">Địa chỉ: </label></td>
				<td><textarea name="address" id="address" rows='3' cols='40'></textarea></td>
			</tr>
			<c:forTokens items="Visa,Master Card,American Express,Discover,Java SmartCard" delims="," var="name">
				<tr>
					<td><input type="radio" name="cardType" id="${name }" value="${name }" /></td>
					<td><label for="${name }"><c:out value="${name }"/></label></td>
				</tr>
			</c:forTokens>
			<c:forTokens items="Easy,Normal,Hard,Very Hard,Lengendery" delims="," var="name">
				<tr>
					<td><input type="checkbox" name="mode" id="${name }" value="${name }" checked="checked" /></td>
					<td><label for="${name }"><c:out value="${name }" /></label></td>
				</tr>
			</c:forTokens>
			<tr>
				<td><label for="cardNum1">Credit Card Number: </label></td>
				<td><input type="password" name="cardNum" id="cardNum1" value="" /></td>
			</tr>
			<tr>
				<td><label for="cardNum2">Repeat Credit Card Number: </label></td>
				<td><input type="password" id="cardNum2" value="" /></td>
			</tr>
			<tr>
				<td colspan='2'><input type="submit" name="submit" value="Duyệt"/></td>
			</tr>
		</table>
	</form>
</body>
</html>