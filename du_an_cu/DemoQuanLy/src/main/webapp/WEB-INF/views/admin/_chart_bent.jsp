<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, demo.beans.Income" %>
<%@ page errorPage ="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
    
   function check(){
    
	var  value1 = document.getElementById('chooseday1').value;
    
	var  value2 = document.getElementById('chooseday2').value;


	if(value1 < value2){
		
		if(value1 != null && value1 != ""){
        	
    		if(value2 != null && value2 != ""){
        	      			
    			document.getElementById('formchooseday').submit();
        	}
         }
	    } 
    }
</script>

 <%
    ArrayList<Income> in = (ArrayList<Income>)request.getAttribute("Income");
    
  %>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawVisualization);

      function drawVisualization() {
        // Some raw data (not necessarily accurate)
        var data = google.visualization.arrayToDataTable([
          ['Month', 'Chi', 'Thu', 'Thu nhập ròng'],
          
          <%for(int i=0; i<in.size(); i++){%>['<%=in.get(i).getMonth()%>',<%=in.get(i).getTotalex()%>, <%=in.get(i).getTotalre()%>, <%=in.get(i).getNetincome()%>]<%=i+1<in.size()? ',' : ' '%><%}%>
          
        ]);

        var options = {
          title : 'Biểu đồ thu/chi các tháng',
		  'height': 580 ,
		  'width': 750 ,
          seriesType: 'bars',
          series: {2: {type: 'line'}}
        };

        var chart = new google.visualization.ComboChart(document.getElementById('chart'));
        chart.draw(data, options);
      }
</script>
</head>
<body>
  <form id="formchooseday" action="${pageContext.request.contextPath}/ad/bent">
    
    <input type="date" id="chooseday1" name="chooseday1" value="${date1}" onchange="check()"/>
        
    <input type="date" id="chooseday2" name="chooseday2" value="${date2}" onchange="check()"/> 
  
  </form>
<div>
  <div style="float: left" id="chart"></div>
  
  <div>
       
       <table border = "1">
          <tr>
           <th>Tháng</th>
           <th>Tổng chi</th>
           <th>Tổng thu</th>
           <th>Thu nhập dòng</th>
           
          </tr> 
          
          <c:forEach items="${Income}" var="in">
               <tr>
                  <td>${in.month}</td>
                  <td>${in.totalex}</td>
                  <td>${in.totalre}</td>
                  <td>${in.netincome}</td>
          </c:forEach>
       </table>
       
  </div>
  
</div>  
</body>
   
</html>
	