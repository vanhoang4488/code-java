<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="shopgiay.beans.Item" %>
<%@ page import="shopgiay.utils.MyUtils" %>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>VP Shoes</title>
        <link rel="shortcut icon" type="image/png" href="images/favicon.ico"/>
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <main>
            <!--header-->
            <header id="header">
                <div class="container-fluid">
                    <h1 class="logo"><a href="${pageContext.request.contextPath}"><img src="images/favicon.ico" alt=""></a></h1>
                    <nav>
                        <ul class="main-menu d-flex">
                            <li><a href="#">giày nam</a></li>
                            <li><a href="#">giày nữ</a></li>
                            <li><a href="#">giày đôi</a></li>
                            <li><a href="#">flash sale</a></li>
                        </ul>
                    </nav>
                    <div class="header-module d-flex">
                        <div class="search-icon">
                            <i class="fa fa-search fa-2x" aria-hidden="true"></i>
                        </div>
                        <div class="cart-icon">
                            <i class="fa fa-shopping-bag fa-2x" aria-hidden="true"></i>
                            <span class="cart-numb">0</span>
                        </div>
                    </div>
                </div>
            </header>
            <!--end header-->
            <div class="main-page" id="cart-page">
                <h2 class="bg-light text-center p-5 mb-5">Giỏ hàng</h2>
                <form action="" method="post">
                    <div class="container">
                        <table class="cart-table mb-5" cellpadding="1">
                            <thead>
                                <tr>
                                    <th colspan="2">Sản phẩm</th>
                                    <th>Giá</th>
                                    <th>Số lượng</th>
                                    <th>Tổng</th>
                                    <th></th>
                                </tr>
                            </thead>
    
                            <tbody>
                                <c:forEach items="${CookieCart.cartItems}" var="items">
                                <tr>                                  
                                    <td class="prd-thumbnail"><img src="images/${items.value.image }" alt=""></td>
                                    <td>${ items.value.productName }-Size:${items.value.size }</td>
                                    <td>${items.value.price }</td>
                                    <td>
                                        <div class="quantity d-flex justify-content-center align-items-center">
                                            <button name="cart_action" value="decrease-${items.value.productID }-${items.value.size }" class="decrease" ></button>
                                            <input type="text" value="${items.value.quantity }" name="${items.value.productID }">
                                            <button name="cart_action" value="increase-${items.value.productID }-${items.value.size }" class="increase" ></button>
                                        </div>
                                    </td>
                                    <td>${items.value.price * items.value.quantity }</td>
                                    <td><a href="#" title="xóa"><i class="fa fa-times-circle-o" aria-hidden="true"></i></a></td>
                                </tr>
                                </c:forEach>
                            </tbody>
                           
                        </table>
                        <div class="cart-summary d-flex justify-content-center align-items-center mb-5">
                  
                            <a href="shop">Thanh toán</a>
                        </div>
                    </div>
                </form>   
            </div>

            <!--footer-->
            <footer id="footer">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="item">
                                <a href="#" class="logo"><img src="images/favicon.ico" alt=""></a>
                                <ul>
                                    <li><span>Hotline</span> 0123456789</li>
                                    <li><span>Cơ sở 1</span> Số 144 Xuân thủy - Cầu giấy - Hà Nội</li>
                                    <li><span>Cơ sở 2</span> Số 144 Xuân thủy - Cầu giấy - Hà Nội</li>
                                    <li><span>Cơ sở 3</span> Số 144 Xuân thủy - Cầu giấy - Hà Nội</li>
                                    <li><span>Cơ sở 4</span> Số 144 Xuân thủy - Cầu giấy - Hà Nội</li>
                                    <li><span>Cơ sở 5</span> Số 144 Xuân thủy - Cầu giấy - Hà Nội</li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-2">
                            <div class="item">
                                <h4>hỗ trợ</h4>
                                <ul>
                                    <li><a href="#">Lorem Ipsum is simply dummy text</a></li>
                                    <li><a href="#">Lorem Ipsum is simply dummy text</a></li>
                                    <li><a href="#">Lorem Ipsum is simply dummy text</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-2">
                            <div class="item">
                                <h4>dịch vụ</h4>
                                <ul>
                                    <li><a href="#">Lorem Ipsum is simply dummy text</a></li>
                                    <li><a href="#">Lorem Ipsum is simply dummy text</a></li>
                                    <li><a href="#">Lorem Ipsum is simply dummy text</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="item">
                                <h4>vpshoes trên facbook</h4>
                                
                            </div>
                        </div>
                    </div>
                </div>
            </footer>
            <div class="copy text-center">
                <span>&copy; 2019</span>
            </div>
            <!--end footer-->
            <!--search page-->
            <div class="page-fixed page-search justify-content-center align-items-center flex-column">
                <div class="wrapper">
                    <nav>
                        <ul class="search-menu d-flex">
                            <li><a href="#">Tất cả sản phẩm</a></li>
                            <li><a href="#">giày nam</a></li>
                            <li><a href="#">giày nữ</a></li>
                            <li><a href="#">giày đôi</a></li>
                        </ul>
                    </nav>
                    <form action="" class="d-flex justify-content-center align-items-center">
                        <button type="submit"></button>
                        <input type="text" name="" placeholder="Tìm kiếm">
                        <button type="reset"></button>
                    </form>
                </div>
                <span class="close-page"><i class="fa fa-times fa-3x" aria-hidden="true"></i></span>
            </div>
            <!--end search page-->
            <!--cart page-->
            <!-- <div class="page-fixed cart-page d-flex justify-content-center align-items-center flex-column">

            </div> -->
            <!--end cart page-->
        </main>
        <script src="js/jquery-3.4.1.min.js"></script>
        <script src="js/index.js"></script>      
    </body>
</html>
