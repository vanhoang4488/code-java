<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Hiển thị thông tin người dùng</title>
<style>
	table, th, td{
		border: 2px solid black;
		border-collapse: collapse;
	}
</style>
</head>
<body>
	
	<table>
		<tr>
			<td><label for="memberID">MemberID: </label></td>
			<td><c:out value="${user.memberID }"/></td>
		</tr>
		<tr>
			<td><label for="firstName">First Name: </label></td>
			<td><c:out value="${user.firstName }"/></td>
		</tr>
		<tr>
			<td><label for="lastName">Last Name: </label></td>
			<td><c:out value="${user.lastName }"/></td>
		</tr>
		<tr>
			<td><label for="age">Age: </label></td>
			<td><c:out value="${user.age }"/></td>
		</tr>
		<tr>
			<td><label for="gender">Gender: </label></td>
			<td><c:out value="${user.gender }"/></td>
		</tr>
		<tr>
			<td><label for="city">City: </label></td>
			<td><c:out value="${user.city }"/></td>
		</tr>
		<tr>
			<td><label for="address">Address: </label></td>
			<td><c:out value="${user.address }"/></td>
		</tr>
		<tr>
			<td><label for="pin">Pin: </label></td>
			<td><c:out value="${user.pin }"/></td>
		</tr>
		<tr>
			<td><label for="email">Email: </label></td>
			<td><c:out value="${user.email }"/></td>
		</tr>
		<tr>
			<td><label for="phone">Phone: </label></td>
			<td><c:out value="${user.phone }"/></td>
		</tr>
		<tr>
			<td><label for="salary">Salary: </label></td>
			<td><c:out value="${user.salary }"/></td>
		</tr>
	</table>
</body>
</html>