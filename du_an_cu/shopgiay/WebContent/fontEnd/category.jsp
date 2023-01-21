<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <div class="main-page" id="category">
                <section class="hero-part">
                    <div class="content d-flex justify-content-center align-items-center flex-column">
                        <h2 class="text-center">giày nam</h2>
                        <nav class="bread-crumbs">
                            <ul>
                                <li><a href="#">Trang chủ</a></li>
                                <li><a href="#">Giày nam</a></li>
                            </ul>
                        </nav>
                    </div>
                </section>
                <div class="product-page mb-5">
                    <div class="row">
                        <aside class="col-lg-3 category-filter">
                            <div class="filter-col">
                                <h3>Danh mục sản phẩm</h4>
                                <ul class="cat-filter">
                                    <li><a href="#">Giày đôi</a></li>
                                    <li><a href="#">Giày nam</a></li>
                                    <li><a href="#">Giày nữ</a></li>
                                </ul>
                            </div> 
                            <div class="filter-col">
                                <h3>Lọc theo giá</h4>
                                <ul class="price-filter">
                                    <li><a href="#">Tất cả</a></li>
                                    <li><a href="#">500000 - 1000000</a></li>
                                    <li class="active"><a href="#">1000000 - 1500000</a></li>
                                    <li><a href="#">1500000 - 1000000</a></li>
                                </ul>
                            </div> 
                            <div class="filter-col">
                                <h3>Lọc theo size</h4>
                                <ul class="size-filter">
                                    <li class="active"><a href="#">36</a></li>
                                    <li><a href="#">37</a></li>
                                    <li><a href="#">38</a></li>
                                    <li><a href="#">39</a></li>
                                    <li><a href="#">40</a></li>
                                    <li><a href="#">41</a></li>
                                    <li><a href="#">42</a></li>
                                </ul>
                            </div> 
                        </aside>
                        <div class="col-lg-9">
                            <nav class="d-flex my-nav-tab">
                                <div class="prd-ordering">
                                    <select name="" id="">
                                        <option value="0">Tất cả</option>
                                        <option value="1">Mới nhất</option>
                                        <option value="2">Đắt nhất</option>
                                        <option value="3">Rẻ nhất</option>
                                    </select>
                                </div>
                                <div class="prd-tab ml-auto">
                                    <ul class="d-flex">
                                        <li class="my-tab-item text-center" data-tab="grid-prd"><i class="fa fa-th"></i></li>
                                        <li class="my-tab-item text-center" data-tab="line-prd"><i class="fa fa-th-list"></i></li>
                                    </ul>
                                </div>
                            </nav>
                            <!--grid tab-->
                            <div id="grid-prd" class="my-tab-content">
                                <section class="products text-center">
                                    <div class="row">
                                    <% for(Product p : ResultsUtils.getProduct()) {%>
                                        <div class="col-lg-3 col-6">
                                            <div class="item">
                                                <figure>
                                                    <div class="prd-ftr">
                                                        <span class="hot">hot</span>
                                                        <%if(p.getSale() > 0 ) { %>
                                                            <span class="sale">-<%=p.getSale() %>%</span>
                                                        <%} %>
                                                    </div>
                                                    <a href="product?productID=<%=p.getProductID()%>"><img src="images/<%=p.getImage()[0] %>" alt=""></a>
                                                    <figcaption>
                                                        <div class="prd-ftr-img d-flex justify-content-center">
                                                            <% for(int i=0; i< p.getImage().length; i++) {%>
                                                                <a class="prd-img-trg active" href="#"><img src="images/<%=p.getImage()[i]%>" alt=""></a>
                                                             <% }%>
                                                        </div>
                                                        <h3 class="item-name"><a href="#"><%=p.getProductName() %></a></h3>
                                                        <p class="prd-price">
                                                            <%if(p.getSale() > 0){ %>
                                                               <span class="old-price"><%=p.getPrice() %></span>
                                                               <span class="new-price"><%=p.getPrice() - p.getPrice()*p.getSale()/100 %></span>
                                                               <%} else { %>
                                                               <span class="new-price"><%=p.getPrice() %></span>
                                                             <%} %>
                                                        </p>
                                                    </figcaption>
                                                </figure>
                                            </div>
                                        </div>
                                        <%}%>  
                                    </div>
                                </section>
                            </div>
                            <!--line tab-->
                            <div id="line-prd" class="my-tab-content">
                                <section class="products">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="item">
                                                <figure>
                                                    <div class="prd-ftr">
                                                        <span class="hot">hot</span>
                                                        <span class="sale">-50%</span>
                                                        <span class="sold">hết hàng</span>
                                                    </div>
                                                    <a href="#"><img src="images/prd-5.jpg" alt=""></a>
                                                    <figcaption>
                                                        <div class="prd-ftr-img d-flex justify-content-center">
                                                            <a class="prd-img-trg active" href="#"><img src="images/prd-11.jpg" alt=""></a>
                                                            <a class="prd-img-trg" href="#"><img src="images/prd-7.jpg" alt=""></a>
                                                            <a class="prd-img-trg" href="#"><img src="images/prd-12.jpg" alt=""></a>
                                                            <a class="prd-img-trg" href="#"><img src="images/prd-9.jpg" alt=""></a>
                                                        </div>
                                                        <h3 class="item-name"><a href="#">Giày Thể Thao VPPORT</a></h3>
                                                        <p class="prd-price">
                                                            <span class="old-price">450.000₫</span>
                                                            <span class="new-price">360.000₫</span>
                                                        </p>
                                                    </figcaption>
                                                </figure>
                                            </div>
                                        </div>
                                        <div class="col-lg-12">
                                            <div class="item">
                                                <figure>
                                                    <a href="#"><img src="images/prd-6.jpg" alt=""></a>
                                                    <figcaption>
                                                        <div class="prd-ftr-img d-flex justify-content-center">
                                                            <a class="prd-img-trg active" href="#"><img src="images/prd-11.jpg" alt=""></a>
                                                            <a class="prd-img-trg" href="#"><img src="images/prd-7.jpg" alt=""></a>
                                                            <a class="prd-img-trg" href="#"><img src="images/prd-12.jpg" alt=""></a>
                                                            <a class="prd-img-trg" href="#"><img src="images/prd-9.jpg" alt=""></a>
                                                        </div>
                                                        <h3 class="item-name"><a href="#">Giày Thể Thao VPPORT</a></h3>
                                                        <p class="prd-price">
                                                            <span class="old-price">450.000₫</span>
                                                            <span class="new-price">360.000₫</span>
                                                        </p>
                                                    </figcaption>
                                                </figure>
                                            </div>
                                        </div>
                                        <div class="col-lg-12">
                                            <div class="item">
                                                <figure>
                                                    <a href="#"><img src="images/prd-7.jpg" alt=""></a>
                                                    <figcaption>
                                                        <div class="prd-ftr-img d-flex justify-content-center">
                                                            <a class="prd-img-trg active" href="#"><img src="images/prd-11.jpg" alt=""></a>
                                                            <a class="prd-img-trg" href="#"><img src="images/prd-7.jpg" alt=""></a>
                                                            <a class="prd-img-trg" href="#"><img src="images/prd-12.jpg" alt=""></a>
                                                            <a class="prd-img-trg" href="#"><img src="images/prd-9.jpg" alt=""></a>
                                                        </div>
                                                        <h3 class="item-name"><a href="#">Giày Thể Thao VPPORT</a></h3>
                                                        <p class="prd-price">
                                                            <span class="old-price">450.000₫</span>
                                                            <span class="new-price">360.000₫</span>
                                                        </p>
                                                    </figcaption>
                                                </figure>
                                            </div>
                                        </div>
                                        <div class="col-lg-12">
                                            <div class="item">
                                                <figure>
                                                    <a href="#"><img src="images/prd-8.jpg" alt=""></a>
                                                    <figcaption>
                                                        <div class="prd-ftr-img d-flex justify-content-center">
                                                            <a class="prd-img-trg active" href="#"><img src="images/prd-11.jpg" alt=""></a>
                                                            <a class="prd-img-trg" href="#"><img src="images/prd-7.jpg" alt=""></a>
                                                            <a class="prd-img-trg" href="#"><img src="images/prd-12.jpg" alt=""></a>
                                                            <a class="prd-img-trg" href="#"><img src="images/prd-9.jpg" alt=""></a>
                                                        </div>
                                                        <h3 class="item-name"><a href="#">Giày Thể Thao VPPORT</a></h3>
                                                        <p class="prd-price">
                                                            <span class="old-price">450.000₫</span>
                                                            <span class="new-price">360.000₫</span>
                                                        </p>
                                                    </figcaption>
                                                </figure>
                                            </div>
                                        </div>
                                    </div>
                                </section>
                            </div>
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
        </main>
        <script src="js/jquery-3.4.1.min.js"></script>
        <script src="js/index.js"></script>
    </body>
</html>