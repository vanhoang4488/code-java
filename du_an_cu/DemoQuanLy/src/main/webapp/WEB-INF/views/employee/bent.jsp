<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage ="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<div style="width:100%">
  <%@ include file="_header.jsp" %> 
   
  <div style="background-color:#aaa; height:613px;width:253px;float:left;">
      <%@ include file="_options_bar.jsp" %>
  </div>
  
  
  <div style="background-color:#eee; height:613px;width:1080px;float:left;">
       <%@ include file="_chart_bent.jsp" %>
       
  </div>
  
</div>
  
</body>
</html>