<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
  <div style="background-color:#b5dcb3; height:28px ;width:100%; float: right; padding: 10px; text-align: right;">
 
     <!-- User store in session with attribute: loginedUser -->
    <b>${user.userName}</b>
    
    <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
    <a href="${pageContext.request.contextPath}/changePassword">Đổi mật khẩu</a>
  </div>
</body>
</html>