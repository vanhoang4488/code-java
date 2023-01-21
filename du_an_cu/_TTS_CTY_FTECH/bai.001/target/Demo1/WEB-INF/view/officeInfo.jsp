<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin phòng ban</title>
</head>
<body>

	<jsp:include page="../toolbar/_header.jsp"/>
	<jsp:include page="../toolbar/_menu.jsp"/>
	
	<h1> Giới thiệu phòng ban: ${office.officeName }</h1>
	<form method="POST" action="${pageContext.request.contextPath }/office">
	
	<div>
		<input type="submit" name="submit" value="Lưu"/>
	</div>
	
	<table>
		<tr>
			<td colspan="2"><i style="color:red">${notice }</i></td>
		</tr>
		<tr>
			<td rowspan="2"><img src="<c:url value=''/>" height="60px" width="60px"/></td>
			<td>Mã phòng ban: ${office.id}</td>
		</tr>
		<tr>
			<td><input type="text" name="officeName" value="${office.officeName} }"></td>
		</tr>
		<tr>
			<td rowspan="3"><img src="<c:url value=''/>" height="60px" width="60px"/></td>
			<td>Mã người quản lý: <input type="text" name="managerId" value="${office.managerId}"></td>
		</tr>
		<tr>
			<td>Người quản lý: <input type="text" name="managerName" value="${office.managerName}"></td>
		</tr>
		<tr>
			<td>Ngày nhân chức: <input type="datetime" name="officeName" value="${office.dateOfTalkingOffice} "></td>
		</tr>
		<tr>
			<td colspan="2">
				<h3 align="center">Chi tiết về phòng ban</h3>
				<textarea name="description" cols="10" rows="5">
				</textarea>
			</td>
		</tr>
	</table>
	</form>
	
	<jsp:include page="../toolbar/_footer.jsp"/>
</body>
</html>