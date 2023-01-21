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
<style>
.lable{
	margin-bottom: 10px;
}
.clearfix:after {
    content: ".";
    visibility: hidden;
    display: block; 
    clear: both;
}
</style>
</head>
<body onload="startAssign()">

<div>
   <form id="formchooseday" method = "POST" action="${pageContext.request.contextPath}/ad/quanlychi" >
        
        <input style="margin: 20px;  color:#07c25f;border:1px solid #07c25f" type="date" id="chooseday1" name="chooseday1" value="${date1}" onchange="check()"/>
        
        <input style="margin-left: 20px;margin-right:20px; color:#07c25f;border:1px solid #07c25f " type="date" id="chooseday2" name="chooseday2" value="${date2}" onchange="check()"/> 
        
        <input style="padding: 4px; width: 120px;margin-left: 20px  color:#07c25f;border:1px solid #07c25f" type="text" name="search_text" size="10" value="" required/> 
        
        <input style="padding: 4px; background:#07c25f;border: 1px solid #07c25f; width: 60px;color: white" type="submit" name="search" value="Search"/>
       
   </form> 

</div>
<div id="deal" style="background: #E0E0E0;" >

     
     
    	<form method = "POST" action="${pageContext.request.contextPath}/ad/insertSpending">
    	   <fieldset style="border: 1px solid #07c25f">
              <legend >Giao dịch</legend> 
				<div class="lable">
			  <label for="date">Ngày chi</label>
				<input style="float: right;border: 1px solid #07c25f;color:#07c25f;margin-left: 40px;margin-right: 20px;width: 175px;" type="date" name = "date" id="date" value="" required/>   
			</div>
			<div class="lable">       
    	        <label for="msnv">MSNV</label>
    	        <input style="float: right;border: 1px solid #07c25f;color:#07c25f;margin-left: 40px;margin-right: 20px;padding: 4px;" type="text" name = "msnv" id="msnv" value="" maxlength="8" required/> <br />
			</div>
			<div class="lable">  
    	        <label for="category">Danh mục</label>
    	        <input style="float: right;border: 1px solid #07c25f;color:#07c25f;margin-left: 40px;margin-right: 20px;padding: 4px;" type="text" name="category" id="category" value="" maxlength="20" required/>
			 </div>  
			 <div class="lable">   
    	        <label  for="employees">Người chi</label>
    	        <input style="float: right;border: 1px solid #07c25f;color:#07c25f;margin-left: 40px;margin-right: 20px;padding: 4px;" type="text" name="employees"  id="employees" value="" maxlength="30" required/> <br />
			 </div>
			 <div class="lable">     
    	        <label for="price">Số tiền</label>
    	        <input style="float: right;border: 1px solid #07c25f;color:#07c25f;margin-left: 40px;margin-right: 20px;padding: 4px;" type="number" name="price" id="price" min="0" max="${Sum.currbalance}"value="" required/>
			</div>
			<div class="lable">  
    	        <label for="purpose">Mục đích</label>
    	        <input style="float: right;;border: 1px solid #07c25f;color:#07c25f;margin-left: 40px;margin-right: 20px;padding: 4px;" type="text" name="purpose" id="purpose" value="" maxlength="200" required/><br />
			</div>
			<div class="lable">  	
    	        <input style="padding: 5px; background:#07c25f;border: 1px solid #07c25f; width: 60px;color: white" type="submit" id="spend" name="spend" value="lưu" />
    	           	        
       	        <input style="padding: 5px; background:#07c25f;border: 1px solid #07c25f; width: 60px;color: white" type="submit" id="delete" name="delete" value="Xóa" form="formchi"/>
    	      
    	        <input style="padding: 5px; background:#07c25f;border: 1px solid #07c25f; width: 60px;color: white" type="button" value="In" onclick="window.print()"/>
			</div>
			</fieldset>
    	    </form>
    	    <p>${swear}</p>
    
      
</div>

</body>
</html>