<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<script type="text/javascript">
	function submintform() {

		
	}
</script>
</head>
<body>
	
	
	<table>
		<tr>
			<td>Username</td>
			<td><input type="text" name="username" class="input" value=""></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password" class="input"
				value="" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" id="login" name="login"
				value="Đăng nhập" /></td>
		</tr>
	</table>
	
	
	<script type="text/javascript">
		
		var button = document.getElementById("login");

		// Thêm sự kiện cho đối tượng
		button.onclick = function() {
			var inputs = document.getElementsByClassName("input");
			
			var sendData = {
				username: inputs[0].value,
				password: inputs[1].value,
			};
			
			var json = JSON.stringify(sendData);
			alert(json);
			var xhr = new XMLHttpRequest();
			
			xhr.onreadystatechange = function(){
				
				if(xhr.readyState == 4 && xhr.status == 200){
					location.reload();
				}
			}
	
			xhr.open("POST", "${pageContext.request.contextPath}/user/login/", true);
			xhr.setRequestHeader("Content-Type", "application/json");
			xhr.setRequestHeader("Accept", "application/json");
			
			xhr.send(json);
			
			
		};
	</script>

</body>
</html>