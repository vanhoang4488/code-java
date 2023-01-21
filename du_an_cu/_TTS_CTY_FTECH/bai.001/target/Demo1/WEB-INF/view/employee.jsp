<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách nhân viên</title>
</head>
<body>

	<jsp:include page="../toolbar/_header.jsp" />
	<jsp:include page="../toolbar/_menu.jsp" />

	<h1 align="center">Danh sách nhân viên</h1>

	<div style="text-align: right">
		<a href=""><img src="<c:url value=''/>" height="20px" width="20px" /></a>
		<input type="text" name="findId" id="findId" value="" />
	</div>

	<table>
		<tr>
			<th></th>
			<th>stt</th>
			<th>Mã nhân viên</th>
			<th>Tên nhân viên</th>
			<th>Ngày sinh</th>
			<th>Giới tính</th>
			<th>Quốc tịch</th>
			<th>Số điện thoại</th>
			<th>Email</th>
			<th>Tên người quản lý</th>
			<th>Chức vụ</th>
			<th>Mức lương</th>
		</tr>

		<c:forEach items="${employees }" var="emp">
			<tr>
				<td><input type="checkbox" name="${emp.id}" id="element${page}" /></td>
				<td></td>
				<td>${emp.id }</td>
				<td>${emp.fullName }</td>
				<td>${emp.birthday }</td>
				<td>${emp.gioiTinh }</td>
				<td>${emp.country }</td>
				<td>${emp.phone }</td>
				<td>${emp.email }</td>
				<td>${emp.reportName }</td>
				<td>${emp.jobTitle }</td>
				<td>${emp.salary }</td>
			</tr>
		</c:forEach>

	</table>

	<input type="number" name="page" id="page" value="${page}" />

	<jsp:include page="../toolbar/_footer.jsp" />

</body>
</html>