<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:forTokens example</title>
</head>
<body>
 
<h2>c:forTokens example</h2>
 
 
<c:forTokens items="Tom,Jerry,Donald" delims="," var="name">
  <c:out value="${name}"/><p>
</c:forTokens>
 
</body>
</html>