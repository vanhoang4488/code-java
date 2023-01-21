<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div style="background:#E0E0E0;height:55px;padding:5px">
	<div style="float:left">
		<h1>My site</h1>
	</div>
	
	<div style="float:right;padding:10px;text-align:right;">
		<!--Hiển thị thông tin đăng nhập của người dùng -->
		Hello<b>${loginUser.userName}</b>
		<br/>
		Search <input name="search">
	</div>
</div>