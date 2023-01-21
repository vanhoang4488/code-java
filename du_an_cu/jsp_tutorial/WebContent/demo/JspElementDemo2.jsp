<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        <data>
 
  <h3>Please view source of this page</h3>
  
  <%--  Tạo đối tượng Employee và sét giá trị cho các field của nó --%>
  
  <jsp:useBean id="emp"
      class="javaBean.Employee">
  
      <jsp:setProperty name="emp" property="empNo" value="E01" />
      <jsp:setProperty name="emp" property="empName" value="Smith" />
  
  </jsp:useBean>    
  
  <employee empNo="<%=emp.getEmpNo()%>">
      <%=emp.getEmpName()%>    
  </employee>
  
</data>
</body>
</html>