<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin bản nhân</title>
</head>
<body>
	<jsp:include page="../toolbar/_header.jsp" />
	<jsp:include page="../toolbar/_menu.jsp" />

	<h1 align="center">Thông tin bản thân</h1>

	<form method="POST"
		action="${pageContext.request.contextPath }/employee">
		<table>

			<tr>
				<td rowspan="4"><img src="<c:url value=''/>" height="200px"
					width="200px"></td>
				<td>Mã nhân viên: ${employee.id }</td>
			</tr>
			<tr>
				<td>Họ và tên <input type="text" name="fullname" id="fullname"
					value="${employee.fullName }" /></td>
			</tr>
			<tr>
				<td>Chức vụ: ${employee.jobTitle }</td>
			</tr>
			<tr>
				<td>Người quản lý: ${employee.reportName }</td>
			</tr>

			<tr>
				<td>Số điện thoại</td>
				<td><input type="text" name="phone" value="${employee.phone }" /></td>
			</tr>

			<tr>
				<td>Email</td>
				<td><input type="text" name="email" value="${employee.email }" /></td>
			</tr>

			<tr>
				<td>Mức lương</td>
				<td><input type="text" name="salary"
					value="${employee.salary }" /></td>
			</tr>

			<tr>
				<td>Ngày sinh</td>
				<td><input type="date" name="birthday"
					value="${employee.birthday }"></td>
			</tr>
			<tr>
				<td>Giới tinh</td>
				<td><input type="text" name="gioiTinh"
					value="${employee.gioiTinh }" /></td>
			</tr>
			<tr>
				<td>Quốc tịch</td>
				<td><input type="text" name="country"
					value="${employee.country }" /></td>
			</tr>
			<tr>
				<td>Tỉnh/Thành phố</td>
				<td><input type="text" name="city" value="${employee.city }" /></td>
			</tr>
			<tr>
				<td>Quận/Huyện</td>
				<td><input type="text" name="district"
					value="${employee.district }" /></td>
			</tr>
			<tr>
				<td>Xã/Phường</td>
				<td><input type="text" name="village"
					value="${employee.village }" /></td>
			</tr>
			<tr>
				<td>Địa chỉ thêm</td>
				<td><input type="text" name="addressExtra"
					value="${employee.addressExtra }"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="sumbint" id="submit"
					value="Thay đổi" /></td>
			</tr>
		</table>
	</form>
	>

	<jsp:include page="../toolbar/_footer.jsp" />

</body>
</html>