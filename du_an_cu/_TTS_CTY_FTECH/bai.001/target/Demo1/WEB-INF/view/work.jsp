<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách công việc</title>
</head>
<body>

	<jsp:include page="../toolbar/_header.jsp" />
	<jsp:include page="../toolbar/_menu.jsp" />

	<h1 align="center">Danh sách công việc</h1>

	<div style="text-align: right">
		<a href=""><img src="<c:url value=''/>" height="20px" width="20px" /></a>
		<input type="text" name="findId" id="findId" value="" />
	</div>

	<table>
		<tr>
			<th></th>
			<th>stt</th>
			<th>Mã công việc</th>
			<th>Trạng thái công việc</th>
			<th>Tiêu đề công việc</th>
			<th>Nội dung công việc</th>
			<th>Ngày được tạo</th>
			<th>Ngày bắt đầu</th>
			<th>Ngày kết thúc</th>
			<th>Deadline</th>
			<th>Mã người tạo</th>
			<th>Tên người tạo</th>
		</tr>

		<c:forEach items="${works }" var="work">
			<tr>
				<td><input type="checkbox" name="${work.id}"
					id="element${page}" /></td>
				<td></td>
				<td>${work.id }</td>
				<td>${work.status }</td>
				<td>${work.heading }</td>
				<td>${work.content }</td>
				<td>${work.createdDate }</td>
				<td>${work.beginedDate }</td>
				<td>${work.endedDate }</td>
				<td>${work.deadline }</td>
				<td>${work.createdId }</td>
				<td>${work.createName }</td>
			</tr>
		</c:forEach>

	</table>

	<input type="number" name="page" id="page" value="${page}" />

	<jsp:include page="../toolbar/_footer.jsp" />

</body>
</html>