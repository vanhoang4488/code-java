<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, demo.beans.Pair" %>
<%@ page errorPage ="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
  <%
    ArrayList<Pair> pair = (ArrayList<Pair>)request.getAttribute("Pair");
    String maxKey = "";
    int maxValue = 0;
    if(!pair.isEmpty() && pair != null){
    	maxKey = pair.get(0).getKey();
        maxValue = pair.get(0).getValue();    
        for(int x =1; x< pair.size(); x++){
        	if(pair.get(x).getValue() > maxValue){
        		maxKey = pair.get(x).getKey();
        		maxValue =  pair.get(x).getValue();
        	}
        }

    }
  %>
    
  <h3>Biểu đồ chi tiêu trong tháng</h3>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['category', 'percent'],
          <%for(int i=0; i<pair.size(); i++){%>['<%=pair.get(i).getKey()%>',<%=pair.get(i).getValue()%>]<%=i+1<pair.size()? ',' : ' '%><%}%>
        ]);

        var options = {
		  'width': 380,
		  'height': 250,
          pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('bieudo_thu'));
        chart.draw(data, options);
      }
    </script>
    
    <div id="bieudo_thu" ></div>
      
    <ul>
      <h4>Khoản thu nhiều nhất: </h4> 
      <li><span id="alls"><%=maxKey%>: <%=maxValue%> </span> </li>
      <h4>Các khoản thu: </h4>
      <c:if test="${not empty Pair}">
      <c:forEach items="${Pair}" var="pa">
         <li><span id="ingore">${pa.key}: </span> ${pa.value}</li>
      </c:forEach>
      </c:if>
    </ul>
    
</body> 
</html>