<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script>
     function validateForm(){
	 
        var len = document.getElementById('password').value.length;
	 
	    if(len >= 4){
	    	
		   return true;
		 
	    }else{
	        var notice = document.getElementById('notice');
	     
	        notice.innerHTML = "lưu ý: độ dài mật khẩu phải từ  4 - 8 kí tự";
	    	 
		    return false;
	   }
	 
    }
     
</script>
<style>
	*{
	
	}
    .lable{
        display: block;
        padding: 5px;
    }
   
</style>
</head>
<body>

<div id="deal" style="background: white; width:100%" >
     
    	<form method = "POST" action="${pageContext.request.contextPath}/ad/insertEmployee" onsubmit="return validateForm()">
    	   <fieldset style="border: 1px solid green;background: white">
              <legend>Thêm nhân viên</legend>   	        
                <div class="lable">               
                <label for="msnv">MSNV: </label>
    	        <input style="float: right" type="text" name = "msnv" id="msnv" value="" maxlength="8" required/> 
    	        
            </div> 
            <div class="lable"> 
                <label for="password">Password: </label>
    	        <input style="float: right;margin-left: 20px" type="password" name="password"  id="password" value="" maxlength="8" required/> <br />
    	       </div>
               <div class="lable"> 
                <label for="employees">Tên thành viên: </label>
    	        <input style="float: right;margin-left: 20px" type="text" name="employees"  id="employees" value="" maxlength="30" required/> 
    	        </div>
                <div class="lable"> 
                <label for="email">Email: </label>
    	        <input style="float: right" type="email" name="email"  id="email" value="" maxlength="30" required/>
    	        </div>
    	        <div class="lable"> 
    	        Chức vụ:
    	        <select style="float: right; width: 173px;" name="office">
    	        
    	           <option value = "employee" selected>employee</option>
    	           
    	           <option value = "admin" >admin</option>
    	        
    	        </select>
                </div>
                <div class="lable"> 
    	        <label for="salary">Lương: </label>
    	        <input style="float: right" type="number" name="salary" id="salary" min="4000000" value="" required/>
                </div>
                <div class="lable"> 
    	        
    	        <input  style="padding: 5px; background:#07c25f;border: 1px solid #07c25f; width: 60px;color: white"  type="submit" id="spend" name="spend" value="lưu" />
    	           	        
       	        <input style="padding: 5px; background:#07c25f;border: 1px solid #07c25f; width: 60px;color: white"  type="submit" id="delete" name="delete" value="Xóa" form="formchi"/>
                </div>
    	      </fieldset>
    	    </form>
    	 
    	    <p id="notice">${swear}</p>
   
</div  >

</body>
</html>