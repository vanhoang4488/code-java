<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="shopgiay.beans.Product" %>
<%@ page import="shopgiay.utils.ResultsUtils" %>
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
            <p>${notice}</p>
            <header id="header">
                <div class="container-fluid">
                    <h1 class="logo"><a href="#"><img src="images/favicon.ico" alt=""></a></h1>
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
                            <i class="fa fa-shopping-bag fa-2x" aria-hidden="true" onclick="location.href='cart';"></i>
                            <span class="cart-numb"><c:if test="${CookieCart.count == null }">0</c:if>${CookieCart.count}</span>
                        </div>
                    </div>
                </div>
            </header>
            <!--end header-->
            <div class="main-page" id="product">
                <div class="product-page mb-5">
                    <nav class="bread-crumbs">
                        <ul>
                            <li><a href="#">Trang chủ</a></li>
                            <li><a href="#">Giày nam</a></li>
                        </ul>
                    </nav>
                    <div class="row">
                        <div class="col-lg-6">
                            <%Product p = ResultsUtils.getProductDetails(request.getParameter("productID")); %>
                            <div id="img_product">
                                <img src="images/<%=p.getImage()[0] %>" alt="" width="774" height="774">
                            </div>
                        </div>
                        <aside class="col-lg-6">
                            <div class="prd-summary">
                                <h2 class="prd-title mt-5 mb-5"><%=p.getProductName() %></h2>
                                <p class="prd-desc mb-5"> <%=p.getDescription() %></p>
                                <p class="prd-price mb-5">
                                    <%if(p.getSale() > 0){ %>
                                         <span class="old-price"><%=p.getPrice() %></span>
                                         <span class="new-price"><%=p.getPrice() - p.getPrice()*p.getSale()/100 %></span>
                                         <%} else { %>
                                         <span class="new-price"><%=p.getPrice() %></span>
                                    <%} %>
                                </p>
                                <div class="prd-ftr-img d-flex mb-5">
                                    <% for(int i=0; i< p.getImage().length; i++) {%>
                                         <a class="prd-img-trg" href="#img_product"><img src="images/<%=p.getImage()[i]%>" alt=""></a>
                                    <% }%>
                                </div>
                                <div class="filter-col mb-5">
                                    <ul class="size-filter">                      
                                        <% for(int i =0; i< p.getSize().length; i++) {%>
                                             <li><a onclick="document.getElementById('size_product').value= '<%=p.getSize()[i] %>"><%=p.getSize()[i] %></a></li>
                                        <%}%>
                                    </ul>
                                </div>
                                <form action="addToCart" method="POST">
                                <div class="add-to-cart d-flex">
                                    <div class="quantity d-flex justify-content-center align-items-center">
                                        <button class="decrease" onclick="var x = document.getElementById('quantity'); if(x.value > 1){x.value-- }" type="button"></button>
                                       
                                        <input type="text" id="quantity"  name="quantity" value="1" >
                                        
                                        <button class="increase" onclick="var x = document.getElementById('quantity'); if(x.value > 0){x.value++ }" type="button"></button>
                                    </div>                                                        
                                     <button type="submit">mua ngay</button>
                                     <input type="hidden" name = "productID" value="<%=p.getProductID() %>" />
                                     <input type="hidden" name = "productName" value="<%=p.getProductName() %>" />
                                     <input type="hidden" name = "price" value="<%=p.getPrice() %>" />
                                     <input type="hidden" id ="size_product" name = "size" value="<%=p.getSize()[0] %>"/>   
                                     <input type="hidden" id ="image_product" name = "image_product" value="<%=p.getImage()[0] %>"/>                                           
                                </div>
                                </form>
                            </div>
                        </aside>
                        <div class="col-lg-12">
                            <section class="products text-center related-products">
                                <h3 class="text-left mb-5">Sản phẩm liên quan</h3>
                                <div class="row">
                                   <% for(Product pr : ResultsUtils.getProductRelated(request.getParameter("productID"), p.getPrice())) {%>
                                    <div class="col col-6">
                                        <div class="item">
                                            <figure>
                                                <div class="prd-ftr">
                                                    <span class="hot">hot</span>
                                                    <%if(pr.getSale() > 0 ) { %>
                                                           <span class="sale">-<%=pr.getSale() %>%</span>
                                                    <%} %>
                                                </div>
                                                <a href="product?productID=<%=pr.getProductID()%>"><img src="images/<%=pr.getImage()[0] %>" alt=""></a>
                                                <figcaption>
                                                    <div class="prd-ftr-img d-flex justify-content-center">
                                                        <% for(int i=0; i< pr.getImage().length; i++) {%>
                                                           <a class="prd-img-trg active" href="#"><img src="images/<%=pr.getImage()[i]%>" alt=""></a>
                                                        <% }%>
                                                    </div>
                                                    <h3 class="item-name"><a href="#"><%=pr.getProductName() %></a></h3>
                                                    <p class="prd-price">
                                                        <%if(p.getSale() > 0){ %>
                                                             <span class="old-price"><%=pr.getPrice() %></span>
                                                             <span class="new-price"><%=pr.getPrice() - p.getPrice()*p.getSale()/100 %></span>
                                                        <%} else { %>
                                                           <span class="new-price"><%=pr.getPrice() %></span>
                                                        <%} %>
                                                    </p>
                                                </figcaption>
                                            </figure>
                                        </div>
                                    </div>
                                    <%} %>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
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
                <span>&copy; 2019 </span>
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
            <c:if test="${notice != null}">
                 <script>
                      alert("${notice}");
                 </script>
            </c:if>
        </main>
        <script src="js/jquery-3.4.1.min.js"></script>
        <script src="js/index.js"></script>
    </body>
</html>