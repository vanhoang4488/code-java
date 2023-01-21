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
            <div>
 
            <!--header-->
            <header id="header" >
                <div class="container-fluid">
                    <div class="nav-icon">
                        <i class="fa fa-bars fa-3x"></i>
                    </div>
                    <div style="position:relative">
                        <ul class="main-menu nav-sm">
                                    <li><a href="category">giày nam</a></li>
                                    <li><a href="category">giày nữ</a></li>
                                    <li><a href="category">giày đôi</a></li>
                                    <li><a href="category">flash sale</a></li>
                        </ul>
                    </div>
                    <h1 class="logo"><a href="${pageContext.request.contextPath}"><img src="images/favicon.ico" alt=""></a></h1>
                    <nav>
                        <ul class="main-menu d-flex">
                            <li><a href="category">giày nam</a></li>
                            <li><a href="category">giày nữ</a></li>
                            <li><a href="category">giày đôi</a></li>
                            <li><a href="category">flash sale</a></li>
                        </ul>
                    </nav>
                    <div class="header-module d-flex">
                        <div class="search-icon">
                            <i class="fa fa-search fa-2x" aria-hidden="true"></i>
                        </div>
                        <div class="cart-icon">
                            <i class="fa fa-shopping-bag fa-2x" aria-hidden="true"></i>
                            <span class="cart-numb">2</span>
                        </div>
                        <div class="quick-cart">
                            <div class="item d-flex">
                                <a href="#"><img src="images/prd-1.jpg" alt=""></a>
                                <div class="item-cart-summary">
                                    <h4>Giày thể thao Sport</h4>
                                    <p>1.000.000đ</p>
                                </div>
                            </div>
                            <div class="item d-flex">
                                <a href="#"><img src="images/prd-4.jpg" alt=""></a>
                                <div class="item-cart-summary">
                                    <h4>Giày thể thao Sport</h4>
                                    <p>1.000.000đ</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
            <!--end header-->
                <section class="hero-part ">
                        <div class="header__text ">
                            <div class="content d-flex justify-content-center align-items-center flex-column">
                                <p class="sub-title">đang diễn ra</p>
                                <h2 class="text-center main-title">big member day 25/10 <br> 30% - 50% off</h2>
                            </div>
                            <div href="#newProduct" class="header__icon" id="header__icon" style="transition: 0.8s ease">
                                <p class="header__icon--text">Mua ngay</p>
                                <i class="fa fa-cart-plus fa-4x header__icon--custom"></i>
                            </div>      
                        </div>

                        <div class="header__image">
                            <div class="img_news">
                                <img class="mySlides" src="./images/news1.jpg"  alt="">
                                <img class="mySlides" src="./images/news3.jpg" alt="">
                                <i class="fa fa-angle-double-left fa-3x" style="position: absolute;display: block;top: 50%;background: none;opacity: 0.6;color: orangered;"></i>
                                <i class="fa fa-angle-double-right fa-3x" style="position: absolute; display: block;top: 50%;right: 0;background: none;opacity: 0.6;color: orangered;"></i>
                                <i class="dot" style="display:block; position:absolute; background: none;border: 1px solid orangered;padding: 5px ;border-radius: 50%;bottom: 2%;left: 49%;"></i>
                                <i class="dot" style="display:block; position:absolute; background: none;border: 1px solid orangered;padding: 5px ;border-radius: 50%;bottom: 2%;left: 51%;"></i>
                            </div>
                        </div>
                </section>
                <!--sản phẩm mới nhất-->
                <section class="products" class="mb-5" id="newProduct">
                    <div class="container text-center">
                        <h2 class="title">top sản phẩm <span>mới nhất</span></h2>
                        <div class="row">
                        <% for(Product p : ResultsUtils.getNewProduct()) {%>
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
                    </div>
                </section>
                <!--end sản phẩm mới nhất-->
                <!--danh mục sản phẩm-->
                <section class="featured-categories"  class="mb-5">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-4">
                                <div class="item">
                                    <figure>
                                        <img src="images/ft-cat-1.jpg" alt="">
                                        <figcaption class="d-flex justify-content-center align-items-center flex-column">
                                            <h3><a href="#">giày nam</a></h3>
                                            <a class="my-btn" href="./category.html">xem thêm</a>
                                        </figcaption>
                                    </figure>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="item">
                                    <figure>
                                        <img src="images/ft-cat-2.jpg" alt="">
                                        <figcaption class="d-flex justify-content-center align-items-center flex-column">
                                            <h3><a href="#">giày nữ</a></h3>
                                            <a class="my-btn" href="">xem thêm</a>
                                        </figcaption>
                                    </figure>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="item">
                                    <figure>
                                        <img src="images/ft-cat-3.jpg" alt="">
                                        <figcaption class="d-flex justify-content-center align-items-center flex-column">
                                            <h3><a href="#">giày đôi</a></h3>
                                            <a class="my-btn" href="">xem thêm</a>
                                        </figcaption>
                                    </figure>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <!--end danh mục-->
                <!--sản phẩm bán chạy-->
                <section class="products"  class="mb-5">
                    <div class="container text-center">
                        <h2 class="title">sản phẩm <span>bán chạy</span></h2>
                        <div class="row">
                        <% for(Product p : ResultsUtils.getProducts()) {%>
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
                                                <a class="prd-img-trg active" href="#"><img src="images/<%=p.getImage()[i] %>" alt=""></a>
                                            <%} %>    
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
                            <%} %>
                            
                        </div>
                    </div>
                </section>
                <!--end sản phẩm bán chạy-->
                <!--cảm nhận khách hàng-->
                <section class="customers">
                    <div class="container">
                        <h2 class="title text-center">cảm nhận <span>khách hàng</span></h2>
                        <div class="row">
                            <div class="col-lg-4">
                                <div class="item">
                                    <figure class="d-flex flex-column align-items-center">
                                        <figcaption class="text-justify">
                                            <h4 class="mb-4"><span>Hoàng Thảo</span></h4>
                                            <blockquote>
                                               Đây là lần đầu tiên mình mua giày ở đây nhưng cực kỳ ưng luôn :)) giày êm chân, chất xịn và bền, sẽ ủng hộ shop nhiều    
                                            </blockquote>
                                        </figcaption>
                                        <img src="images/ava1.jpg" alt="">
                                    </figure>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="item">
                                    <figure class="d-flex flex-column align-items-center">
                                        <figcaption class="text-justify">
                                            <h4 class="mb-4"><span>Trần Thảo My</span></h4>
                                            <blockquote>
                                               Shop phục vụ rất tận tình, uy tín và chuyên nghiệp, hi vọng shop sẽ càng ngày càng phát triển hơn
                                            </blockquote>
                                        </figcaption>
                                        <img src="images/ava2.jpg" alt="">
                                    </figure>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="item">
                                    <figure class="d-flex flex-column align-items-center">
                                        <figcaption>
                                            <h4 class="mb-4"><span>Ngần Nguyễn</span></h4>
                                            <blockquote class="text-justify">
                                               Wao, không thể tin được, đi giày vào cái là mình cảm giác cao thêm 10 phân vậy, lúc ngủ cũng không muốn bỏ ra luôn
                                            </blockquote>
                                        </figcaption>
                                        <img src="images/ava3.jpg" alt="">
                                    </figure>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <!--end cảm nhận-->
                <!--video-->
                <section class="featured-video" >
                    <div class="container" >
                        <div class="row">
                            <div class="col-lg-5">
                                <div class="item text-right">
                                    <div class="clearfix">
                                        <em>Hơn 6 năm phát triển, VPShoes luôn mang đến những mẫu giày chất lượng tốt nhất với giá cả hợp lí nhất đến tay người tiêu dùng với hệ thống cửa hàng Số 1 Hà Nội và bán online khắp Việt Nam.</em>
                                    </div>
                                    <p><span class="d-block">12345</span>Số sản phẩm đã bán</p>
                                    <p><span class="d-block">6789</span>Khách hàng đã mua</p>
                                </div>
                            </div>
                            <div class="col-lg-7">
                                <iframe width="100%" height="auto" src="https://www.youtube.com/embed/aF9n1r4pnKw?autoplay=0" frameborder="1" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                            </div>
                        </div>
                    </div>
                </section>
                <!--end video-->
                <!--tin tức-->
                <section class="news">
                    <div class="container">
                        <h2 class="title text-center">tin tức <span>trong tuần</span></h2>
                        <div class="row">
                            <div class="col-lg-4">
                                <div class="item text-left">
                                    <figure>
                                        <a href="#"><img src="images/news1.jpg" alt=""></a>
                                        <figcaption>
                                            <h4 class="item-name"><a href="#">Michelle Obama khoe được Gucci tặng cả "shop" giày</a></h4>
                                            <a href="#" class="my-btn">xem thêm</a>
                                        </figcaption>
                                    </figure>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="item text-left">
                                    <figure>
                                        <a href="#"><img src="images/news2.jpg" alt=""></a>
                                        <figcaption>
                                            <h4 class="item-name"><a href="#">Lệ Hằng hướng dẫn phối quần Jeen và giày cao cổ
                                            </a></h4>
                                            <a href="#" class="my-btn">xem thêm</a>
                                        </figcaption>
                                    </figure>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="item text-left">
                                    <figure>
                                        <a href="#"><img src="images/news3.jpg" alt=""></a>
                                        <figcaption>
                                            <h4 class="item-name"><a href="#">Adidas bất ngờ giảm giá trước tình hình căng thẳng Mỹ - Trung</a></h4>
                                            <a href="#" class="my-btn">xem thêm</a>
                                        </figcaption>
                                    </figure>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <!--end tin tức-->
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
        <script>
            var slideIndex = 0;
            carousel();

            function carousel() {
                var i;
                var x = document.getElementsByClassName("mySlides");
                var y = document.getElementsByClassName("dot");
                for (i = 0; i < x.length; i++) {
                    x[i].style.display = "none";
                    y[i].style.background ="none";
                }
                slideIndex++;
                if (slideIndex > x.length) {slideIndex = 1} {
                x[slideIndex-1].style.display = "block";
                y[slideIndex-1].style.background ="red";
                }
                setTimeout(carousel, 2000); // Change image every 2 seconds
                }    
            function clickButton() {
                var z = document.getElementById("header__icon");
                z.setAttribute("style","h")
            }    
        </script>
    </body>
</html>
