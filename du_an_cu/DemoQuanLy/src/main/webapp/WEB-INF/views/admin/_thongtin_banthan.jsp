<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, demo.beans.UserAccount" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>   
   .second{
       float: right;
       margin: 3px 15px 3px 10px;
   }

   .first{
       float: left;
       margin: 3px 15px 6px 10px;
   }
</style>
<script>
     function setOffice(){
    	 
    	 var e = document.getElementById('office');
    	 
    	 e.value = "${acc.office}";
     }

</script>
</head>
<body onload="setOffice()">

  <div style="height:613px;width:40%;float:left;">
      <p>${swear}</p>
      
      <input type="submit" name="luu" value="Ghi nhận"/> 
      <fieldset>             
             <legend>Thông tin cá nhân</legend> 
                <div style="float: left; width: 164px; height: 164px; border:1px solid brown;">
                     
                     <img src="${acc.imageData}" width="163px" height="163px" />
                                     
                </div>
                
                <div style="float:right;">
                    <form method="get" action="${pageContext.request.contextPath}/ad/userInfo" > 
                    <label for="msnv" class="first">Mã nhân viên: </label>
    	            <input type="text" class="second" name = "msnv" id="msnv" value="${acc.msnv}" maxlength="8" size="20"  required/> <br />
                     	
                    <input type="hidden" name="oldmsnv" value="${acc.msnv}" /> 	
                     	        
    	            <label for="userName" class="first">Họ và tên: </label>
    	            <input type="text" class="second" name = "userName" id="userName" value="${acc.userName}" maxlength="30"  size="20" required /> <br />
    	        
    	            <label for="birthday" class="first">Ngày sinh: </label>
    	            <input type="date" class="second" name = "birthday" id="birthday" value="${info.birthday}" size="20" disabled/> <br/>
    	        
    	            <label for="gender" class="first" >Giới tính: </label>
    	            <input type="text" class="second" name = "gender" id="gender" value="${info.gender}" size="20" disabled/> <br />
    	        
    	            <label for="office" class="first" >Chức vụ: </label>
    	           
    	            <select name="office" id="office" class="second" style="width:170px;">
    	        
    	              <option value = "employee" selected>employee</option>
    	           
    	              <option value = "admin" >admin</option>
    	        
    	            </select>
    	            
    	            <br/>
    	            
    	            <label for="salary" class="first">Lương: </label>
    	            <input type="text" class="second" name = "salary" id="salary" value="${acc.salary}" max="1000000000" size="20" required /> <br />
    	            
    	            <label for="numberPhone" class="first">Số điện thoại: </label>
    	            <input type="text" class="second" name = "numberPhone" id="numberPhone" value="${info.numberPhone}" size="20" disabled/> <br />
    	        
    	            <label for="email" class="first">Gmail liên hệ: </label>
    	            <input type="email" class="second" name = "email" id="email" value="${acc.email}" maxlength="30" size="20" required /> <br />
                   </form> 
                </div>
                
                
                 
                <div style="clear:both">
                   <form method="post" action="${pageContext.request.contextPath}/ad/userInfo?msnv=${acc.msnv}"  enctype="multipart/form-data" > 
                     
                      <input type="submit" name="save" value="Save"/> 
                     
                     <input type="file" id="file" name="file" />
                  
                  </form>
                </div>
                          
          </fieldset>
          
        
          
          <fieldset style="float: right; padding: 5px 5px 5px 90px;">
             <legend>Thông tin cơ bản</legend>
                  <div >
                 <label for="nationality" class="first">Quốc tịch: </label>
    	         <input type="text" class="second" name = "nationality" id="nationality" value="${info.nationality}" size="40" disabled/> <br />
                 
                 <label for="nation" class="first">Dân tộc: </label>
    	         <input type="text" class="second" name = "nation" id="nation" value="${info.nation}" size="40" disabled/> <br />
          
                 <label for="religion" class="first">Tôn giáo: </label>
    	         <input type="text" class="second"  name = "religion" id="religion" value="${info.religion}" size="40" disabled/> <br />
    	         
    	         <label for="cmnd" class="first">Số cmnd: </label>
    	         <input type="text" class="second"  name = "cmnd" id="cmnd" value="${info.cmnd}" size="40" disabled/> <br />
          
                 <label for="range" class="first">Ngày cấp: </label>
    	         <input type="text" class="second"  name = "range" id="range" value="${info.range}" size="40" disabled/> <br />
    	         
    	         <label for="issued" class="first">Nới cấp: </label>
    	         <input type="text" class="second"  name = "issued" id="issued" value="${info.issued}" size="40" disabled/> <br />
    	         
    	         </div>
          </fieldset>
          
          <fieldset style="float: right; padding: 5px 5px 5px 48px;">
             <legend>Quê quán</legend>
                 <div>
                 <label for="oldcountry" class="first" >Quốc gia: </label>
    	         <input type="text" class="second" name = "oldcountry" id="oldcountry" value="${info.oldcountry}" size="40" disabled/> <br />
                 
                 <label for="oldcity" class="first">Tỉnh/Thành phố: </label>
    	         <input type="text" class="second" name = "oldcity" id="oldcity" value="${info.oldcity}" size="40" disabled/> <br />
          
                 <label for="oldjet" class="first">Quận/Huyện: </label>
    	         <input type="text" class="second" name = "oldjet" id="oldjet" value="${info.oldjet}" size="40" disabled/> <br />
    	         
    	         <label for="oldward" class="first">Phường/Xã: </label>
    	         <input type="text" class="second" name = "oldward" id="oldward" value="${info.oldward}" size="40" disabled/> <br />
          
    	         </div>
          </fieldset>
  </div>
  
  <div style="height:613px;width:40%;float:left;">
      <fieldset style="float: right; padding: 5px 5px 5px 48px;">
             <legend>Nơi ở hiện tại</legend>
                 <div>
                 <label for="newcountry" class="first" >Quốc gia: </label>
    	         <input type="text" class="second" name = "newcountry" id="newcountry" value="${info.newcountry}" size="40" disabled/> <br />
                 
                 <label for="newcity" class="first">Tỉnh/Thành phố: </label>
    	         <input type="text" class="second" name = "newcity" id="newcity" value="${info.newcity}" size="40" disabled/> <br />
          
                 <label for="newjet" class="first">Quận/Huyện: </label>
    	         <input type="text" class="second" name = "newjet" id="newjet" value="${info.newjet}" size="40" disabled/> <br />
    	         
    	         <label for="newward" class="first">Phường/Xã: </label>
    	         <input type="text" class="second" name = "newward" id="newward" value="${info.newward}" size="40" disabled/> <br />
          
    	         </div>
          </fieldset>
          
       <fieldset style="float: right; padding: 5px 5px 5px 65px;">
           <legend>Gia đình</legend>
               <label for="userFamily" class="first" >Vợ/Chồng: </label>
    	       <input type="text" class="second" name = "userFamily" id="userFamily" value="${family.userFamily}" size="40" disabled/> <br />     
         
               <label for="birthdayFamily" class="first" >Ngày sinh: </label>
    	       <input type="text" class="second" name = "birthdayFamily" id="birthdayFamily" value="${family.birthdayFamily}" size="40" disabled/> <br />
                      
         
               <label for="jobFamily" class="first" >Nghề nghiệp: </label>
    	       <input type="text" class="second" name = "jobFamily" id="jobFamily" value="${family.jobFamily}" size="40" disabled/> <br />
               
               <label for="phoneFarmily" class="first" >Số điện thoại: </label>
    	       <input type="text" class="second" name = "phoneFarmily" id="phoneFarmily" value="${family.phoneFamily}" size="40" disabled/> <br />
               
               <label for="child" class="first" >Con cái: </label>
               <textarea rows="15" cols="41" class="second" id="child" name="chind" style="resize: none;" disabled>
                    
                    
               </textarea>
       </fieldset>   
  </div>
</body>
</html>