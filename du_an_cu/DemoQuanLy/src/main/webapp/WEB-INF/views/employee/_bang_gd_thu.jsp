<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script>
     
    function checkTime(i) {
       
	   if (i < 10) {
            i = "0" + i;
        }
        return i;
     }
    
    function checkMonth(){
    	
        var today = new Date();
    	
    	var month = today.getMonth() + 1;
    	
    	var year = today.getFullYear();
    	
    	month = checkTime(month);
    	
    	var monthYear = year + "-" + month;
    	
    	return monthYear;
    }
    
    function checkFirstDay(){
        
    	var date1 = checkMonth() + "-01";
    	
    	return date1;
    }
    
    function checkToday(){
    	var today = new Date();
    	
    	var day = today.getDate();
    	
    	day = checkTime(day);
    	
    	var date2 = checkMonth() + "-" + day;
    	
    	return date2;
    }
    
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
    
    function startAssign(){
    	
    	var date = document.getElementById('date');
    	
        var date1 = checkFirstDay();
    	
    	var date2 = checkToday();
    	
    	date.min = date1;
    	
    	date.max = date2; 

    	startSubmit();
    }
    
    function startSubmit(){
    	var firstday = checkFirstDay();
    	
    	var chooseday1 = document.getElementById('chooseday1').value;
    	
       	var chooseday2 = document.getElementById('chooseday2').value;
       	
       	var spend = document.getElementById('spend'); 
       	
       	var erase = document.getElementById('delete');
   
       	if(chooseday1 < firstday){
       		
       		spend.disabled = true;
       		
       		erase.disabled = true;
       	}
    }
    
</script>
</head>
<body onload="startAssign()">

<div>
   <form id="formchooseday" method = "POST" action="${pageContext.request.contextPath}/ad/quanlythu" >
        
        <input type="date" id="chooseday1" name="chooseday1" value="${date1}" onchange="check()"/>
        
        <input type="date" id="chooseday2" name="chooseday2" value="${date2}" onchange="check()"/> 
        
      
   </form> 
</div>
</body>
</html>