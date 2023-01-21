<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <!-- <div>
                        <div class="top-page" style="float: right;margin-right: 20px;">
                            <div class="my-btn login-btn">Trợ giúp</div>
                            <div class="my-btn login-btn">Đăng ký</div>
                            <div class="my-btn login-btn">Đăng nhập</div>
                        </div>
                        <div class="clearfix"></div>
                    </div> -->
            <!--header-->
            <header id="header">
                <div class="container-fluid">
                    <h1 class="logo"><a href="#"><img src="images/logo.png" alt=""></a></h1>
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
            <div class="main-page" id="product">
                <div class="product-page mb-5">
                    <nav class="bread-crumbs">
                        <ul>
                            <li><a href="#">Trang chủ</a></li>
                            <li><a href="#">Tìm kiếm</a></li>
                        </ul>
                    </nav>
                    <div class="row">
                        <aside class="col-lg-3">
                            <div class="filter-col">
                                <h3>Danh mục sản phẩm</h4>
                                <ul class="cat-filter">
                                    <li><a href="#">Giày đôi</a></li>
                                    <li><a href="#">Giày nam</a></li>
                                    <li><a href="#">Giày nữ</a></li>
                                </ul>
                            </div> 
                        </aside>
                        <div class="col-lg-9">
                            <nav class="d-flex mb-4 h3">Kết quả tìm kiếm:<span class="ml-2"> giày XX</span></nav>
                            <section class="products text-center">
                                <div class="row">
                                    <div class="col-lg-3 col-6">
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
                                    <div class="col-lg-3 col-6">
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
                                    <div class="col-lg-3 col-6">
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
                                    <div class="col-lg-3 col-6">
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

            <!--footer-->
            <footer id="footer">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="item">
                                <a href="#" class="logo"><img src="images/logo-light.png" alt=""></a>
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