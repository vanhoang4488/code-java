<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
     function startsend(){
    	 document.getElementById('formsend').submit();  
    	 
     }
</script>
</head>
<body onload="startsend()">
<div>
    <h1>Quên mật khẩu</h1>
    <form id="formsend" action="https://formspree.io/hoangie2k62@gmail.com" method="POST" >
    <input type="text" name="address" value="Phòng quản lí thu/chi bộ môn công nghệ phần mềm" style="display:none">    
    
    <label for="userName">User Name: </label>
    <input type="text" name="userName" value="${msnv}" maxlength="8" required> <br />
    
    <input type="email" name="email" value="${email}" style="display:none">
    
    <input type="text" name="password" value="${password}" style="display:none">    
    
    <input type="submit" name="subforget" value="Gửi" disabled/>
       
    <a href="${pageContext.request.contextPath}/demo/views/login/loginInfo.jsp">Cancel</a>
    
    </form>
</div>
</body>
</html>