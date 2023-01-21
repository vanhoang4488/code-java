<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage ="error.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin thành viên</title>
</head>
<body>
<div style="height: 100%; width: 100%;">
  
  <%@ include file="_header.jsp" %> 
   
      <div style="width: 20%; height: 613px; background-color:PaleGoldenRod; float: left">
      <%@ include file="_options_bar.jsp" %>
     </div>
     
      <%@ include file="_thongtin_banthan.jsp" %> 
    

</div>
</body>
</html>