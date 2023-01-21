<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <jsp:element name="data">
 
  <h3>Please view source of this page</h3>
  
  <%--  Tạo đối tượng Employee và sét giá trị cho các field của nó --%>
  
  <jsp:useBean id="emp"
      class="javaBean.Employee">
  
      <jsp:setProperty name="emp" property="empNo" value="E01" />
      <jsp:setProperty name="emp" property="empName" value="Smith" />
  
  </jsp:useBean>
  
  
  <jsp:element name="employee">
      <jsp:attribute name="empNo" trim="true">
          <jsp:getProperty name="emp" property="empNo" />        
      </jsp:attribute>
      <jsp:body>
          <jsp:getProperty name="emp" property="empName" />        
      </jsp:body>    
  </jsp:element>
  
</jsp:element>
</body>
</html>