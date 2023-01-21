<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h1>Vd cif</h1>
    
    <c:forEach items="${department}"  var="dept">
    <c:if test="${not empty dept.employees}">
       <h2>${dept.deptName}</h2>
       <ul>
           <c:forEach items="${dept.employees }" var="emp">
              <li>
                 ${emp.empName } - (${emp.job }) 
              </li>
           </c:forEach>
       </ul>
    </c:if>
    </c:forEach>
    
</body>
</html>