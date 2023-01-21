<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin chi tiết công việc</title>
</head>
<body>

	<jsp:include page="../toolbar/_header.jsp" />
	<jsp:include page="../toolbar/_menu.jsp" />

	<form method="POST" action="${pageContext.request.contextPath }/work">

		<div style="text-align: right">
			<input type="submit" name="submit" value="<img src=''/>" />
		</div>

		<h1 align="center">Bản kế hoạch công việc</h1>
		<table>

			<tr>
				<td>Mã công việc:</td>
				<td><input type="text" name="id" value="${work.id}"></td>
			</tr>
			<tr>
				<td>Trạng thái công việc:</td>
				<td><input type="text" name="heading" value="${work.status}"></td>
			</tr>
			<tr>
				<td>Tên công việc:</td>
				<td><input type="text" name="heading" value="${work.heading}"></td>
			</tr>
			<tr>
				<td>Người lên kế hoạch:</td>
				<td><input type="text" name="createdName"
					value="${work.createdName }"></td>
			</tr>
			<tr>
				<td>Ngày được tạo:</td>
				<td><input type="datetime" name="createdDate"
					value="${work.createdDate }"></td>
			</tr>
			<tr>
				<td>Ngày bắt đầu</td>
				<td><input type="datetime" name="beginedDate"
					value="${work.beginedDate }"></td>
			</tr>
			<tr>
				<td>Ngày kết thúc</td>
				<td><input type="datetime" name="enedDate"
					value="${work.endedDate }" /></td>
			</tr>
			<tr>
				<td>Hạn định:</td>
				<td><input type="datetime" name="deadline"
					value="${work.deadline }" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<h3>Nội dung công việc</h3> <textarea name="content" cols="10"
						rows="5">
					${work.content }
				</textarea>
				</td>
			</tr>

		</table>

		<h1 align="center">Bảng phân công công việc</h1>

		<table>
			<tr>
				<th></th>
				<th>Mã nhân viên</th>
				<th>Tên nhân viên</th>
				<th>Chức vụ</th>
			</tr>

			<c:forEach items="${workassgins }" var="workassgin">
				<tr>
					<td><input type="checkbox" name=""
						name="elemnt"></td>
					<td>${workassgin.employeeId }</td>
					<td>${workassgin.officeId}</td>
					<td>${employee.beginedDate}</td>
					<td>${employee.endedDate }</td>
				</tr>
			</c:forEach>

		</table>

	</form>

	<jsp:include page="../toolbar/_footer.jsp" />

</body>
</html>