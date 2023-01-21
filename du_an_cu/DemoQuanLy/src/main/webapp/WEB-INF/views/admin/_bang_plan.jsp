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
    
    function checkToday(){
    	var today = new Date();
    	
    	var day = today.getDate() + 1 ;
    	
    	day = checkTime(day);
    	
    	var date2 = checkMonth() + "-" + day;
    	
    	return date2;
    }
    

    function startAssign(){
    	
    	var date = document.getElementById('date');
    	
    	var date2 = checkToday();
    	
    	date.min = date2;
       
    }
  
    
</script>
</head>
<body onload="startAssign()">

<div id="deal" style="background: white" >
     
     <div style="float: left">
    	<form method = "POST" action="${pageContext.request.contextPath}/ad/insertPlan">
    	   <fieldset>
              <legend>Giao dịch</legend> 
    	        <label for="date">Ngày chi</label>
    	        <input type="date" name = "date" id="date" value="" required/>   	        
    	        <label for="msnv">MSNV</label>
    	        <input type="text" name = "msnv" id="msnv" value="17020769" maxlength="8" required/> <br />
    	        
    	        <label for="category">Danh mục</label>
    	        <input type="text" name="category" id="category" value="" maxlength="20" required/>
    	        
    	        <label for="employees">Người chi</label>
    	        <input type="text" name="employees"  id="employees" value="Nguyễn Văn Hoàng" maxlength="30" required/> <br />
    	        
    	        <label for="price">Số tiền</label>
    	        <input type="number" name="price" id="price" min="0" max="${Sum.currbalance}"value="" required/>
    	        
    	        <label for="purpose">Mục đích</label>
    	        <input type="text" name="purpose" id="purpose" value="" maxlength="200" required/><br />
    	         
    	        <input type="submit" id="spend" name="spend" value="lưu" />
    	           	        
       	        <input type="submit" id="delete" name="delete" value="Xóa" form="formchi"/>
    	      
    	        <input type="button" value="In" onclick="window.print()"/>
    	      </fieldset>
    	    </form>
    	    <p>${swear}</p>
    	</div>
      
</div>

</body>
</html>