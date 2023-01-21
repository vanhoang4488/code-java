<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
   <div id="sodu">
       <p>Tổng chi: <b>${Sum.totalex} </b> </p>  
       <p>Tổng thu: <b>${Sum.totalre} </b> </p>  
       <p>Số dư hiện tại: <b>${Sum.currbalance} </b> </p>  
   </div>
   <hr />
   <div id="thanh_cong_cu" style="padding: 5px;">
      <a href="${pageContext.request.contextPath}/quanlychi" >Quản lí chi</a> <br />
      <a href="${pageContext.request.contextPath}/quanlythu">Quản lí thu</a> <br />
      <a href="${pageContext.request.contextPath}/bent" >Xu hướng</a> <br />
       <a href="${pageContext.request.contextPath}/plan" >Kế hoạch</a> <br />
   </div>
</body>
</html>