<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
</head>
<body>
	<h1 align="center">Đăng ký thông tin người dùng</h1>
	<form method="post" action="${pageContext.request.contextPath }/registration">
	<table>
		<tr>
			<td><label for="username">UserName: </label></td>
			<td><input type="text" name="username" id="username" value="${username }" maxlength="50" placeholder="8-50 ký tự."/></td>
		</tr>
		<tr>
			<td><label for="password">Mật khẩu: </label></td>
			<td><input type="password" name="password" id="password" maxlength="16" placeholder="8-16 ký tự"/></td>
		</tr>
		<tr>
			<td><label for="rePassword">Nhập lại mật khẩu: </label></td>
			<td><input type="password" name="rePassword" id="rePassword" maxlength="16"/></td>
		</tr>
		<tr>
			<td><label for="firstName">First Name: </label></td>
			<td><input type="text" name="firstName" id="firstName" value="${firstName }" maxlength="30"/></td>
		</tr>
		<tr>
			<td><label for="lastName">Last Name: </label></td>
			<td><input type="text" name="lastName" id="lastName" value="${lastName }" maxlength="30"/></td>
		</tr>
		<tr>
			<td><label for="birthday">Ngày sinh: </label></td>
			<td><input type="date" name="birthday" id="birthday" value="${birthday }"/></td>
		</tr>
		<tr>
			<td><label for="gender">Giới tính: </label></td>
			<td>
				<select name="gender" id="gender">
					<option value="0">--</option>
					<option value="nam">Nam</option>
					<option value="nu">Nữ</option>
				</select>
			</td>
		</tr>
		<tr>
			<td><label for="city">Thành phố: </label></td>
			<td>
				<select name="city" id="city">
					<option value="0">Chọn thành phố sinh sống</option>
					<option value="Thái Bình">Thái Bình</option>
					<option value="Hà Nội">Hà Nội</option>
					<option value="Hưng Yên">Hưng Yên</option>
					<option value="Hải Dương">Hải Dương</option>
					<option value="Hải Phòng">Hải Phòng</option>
					<option value="Tp.Hồ Chí Minh">Thành phố Hồ Chí Minh</option>
				</select>
			</td>
		</tr>
		<tr>
			<td><label for="addres">Địa chỉ: </label></td>
			<td><input type="text" name="address" id="address" value="${address }" placeholder="Xã/Phường - Quận/Huyện"/></td>
		</tr>
		<tr>
			<td><label for="pin">Pin: </label></td>
			<td><input type="number" name="pin" id="pin" value="${pin }" min="1000000" max="9999999" placeholder="7 chữ số"/></td>
		</tr>
		<tr>
			<td><label for="email">Email: </label></td>
			<td><input type="email" name="email" id="email" value="${email }"/></td>
		</tr>
		<tr>
			<td><label for="phone">Phone &lt;+84&gt;: </label></td>
			<td><input type="text" name="phone" id="phone" value="${phone }" maxlength="10"/></td>
		</tr>
		<tr>
			<td><label for="salary">Salary: </label></td>
			<td><input type="number" name="salary" id="salary" value="${salary}" max="99999999999999999999999999"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<p style="color:red;">${notice }</p>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="submit" value="Đăng ký"/>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>