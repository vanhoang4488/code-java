<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <style>
        * {
            text-decoration: none;
        }

        p {
            color: green;
        }

        span {
            color: #ff7733;
        }
        a{
            color: green;
        }
        a:hover,
        a:active{
        color: white;
        }
        .nav{
            display: block;
            padding: 5px 10px 5px 10px;
            margin: 5px 10px 8px 10px;
             background: linear-gradient(87deg,#2dce89 0,#2dcecc 100%)!important;
             color:white;
            border-radius:30px;
            -webkit-box-shadow: 3px 2px 5px 0px rgba(19,207,63,1);
-moz-box-shadow: 3px 2px 5px 0px rgba(19,207,63,1);
box-shadow: 3px 2px 5px 0px rgba(19,207,63,1);
        }
        .nav:hover,
        .nav:active{
            background: linear-gradient(87deg,#2dce89 0,#2dcecc 100%)!important;
            padding: 5px 10px 5px 10px;
            margin: 5px 10px 5px 10px;
            transition: 1s;
            border-radius: 20px;
        }
       
    </style>
</head>

<body>
    <div id="sodu">
        <p>Tổng chi: <span>${Sum.totalex} </span> </p>
        <p>Tổng thu: <span>${Sum.totalre} </span> </p>
        <p>Số dư hiện tại: <span>${Sum.currbalance} </span> </p>
    </div>
    <hr />
    <div id="thanh_cong_cu" style="padding: 5px;-webkit-box-shadow: 3px 2px 5px 0px rgba(19,207,63,1);
-moz-box-shadow: 3px 2px 5px 0px rgba(19,207,63,1);
box-shadow: 3px 2px 5px 0px rgba(19,207,63,1);background:white">
        <div class="nav">
            <a href="${pageContext.request.contextPath}/ad/quanlychi">Quản lí chi</a> 
        </div>
        <div class="nav">
            <a href="${pageContext.request.contextPath}/ad/quanlythu">Quản lí thu</a> 
        </div>
        <div class="nav">
            <a href="${pageContext.request.contextPath}/ad/bent">Xu hướng</a>
        </div>
        <div class="nav">
            <a href="${pageContext.request.contextPath}/ad/plan">Kế hoạch</a>
        </div>
        <div class="nav">
            <a href="${pageContext.request.contextPath}/ad/manager">Quản lí hồ sơ</a>
        </div>
    </div>
</body>

</html>