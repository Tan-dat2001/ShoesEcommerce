<%@ page import="com.shoesecom.Model.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Start Header Area -->
<%
    Account account = (Account) session.getAttribute("account");
%>
<header class="header_area sticky-header">
    <div class="main_menu">
        <nav class="navbar navbar-expand-lg navbar-light main_box">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <a class="navbar-brand logo_h" href="web-home"><img src="<c:url value="/template/web/img/logo.png"/>"
                                                                    alt=""></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
                    <ul class="nav navbar-nav menu_nav ml-auto">
                        <li class="nav-item "><a class="nav-link" href="web-home">Trang chủ</a></li>
                        <li class="nav-item submenu dropdown">
                            <a class="nav-link" href="web-category">Sản phẩm</a>
                            <!-- <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                             aria-expanded="false">Sản phẩm</a> -->
                            <!-- <ul class="dropdown-menu">
                                <li class="nav-item"><a class="nav-link" href="category.html">Shop Category</a></li>
                                <li class="nav-item"><a class="nav-link" href="single-product.html">Product Details</a></li>
                                <li class="nav-item"><a class="nav-link" href="checkout.html">Product Checkout</a></li>
                                <li class="nav-item"><a class="nav-link" href="cart.html">Shopping Cart</a></li>
                                <li class="nav-item"><a class="nav-link" href="confirmation.html">Confirmation</a></li>
                            </ul> -->
                        </li>
                        <!-- <li class="nav-item submenu dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                             aria-expanded="false">Blog</a>
                            <ul class="dropdown-menu">
                                <li class="nav-item"><a class="nav-link" href="blog.html">Blog</a></li>
                                <li class="nav-item"><a class="nav-link" href="single-blog.html">Blog Details</a></li>
                            </ul>
                        </li> -->
                        <li class="nav-item"><a class="nav-link" href="">Giới thiệu</a></li>
                        <li class="nav-item submenu dropdown">



                                    <c:if test="${not empty account}">
                                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button"
                                           aria-haspopup="true"
                                           aria-expanded="false">${account.getName()}</a>

                                    </c:if>




                            <c:if test="${empty account}">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button"
                                   aria-haspopup="true"
                                   aria-expanded="false">Tài khoản</a>

                            </c:if>

                        <ul class="dropdown-menu">
                            <c:if test="${not empty account}">
                                <li class="nav-item"><a class="nav-link" href="">Hồ sơ</a></li>
                                <li class="nav-item"><a class="nav-link" href="log-out">Đăng xuất</a></li>
                            </c:if>
                            <c:if test="${empty account}">
                                <li class="nav-item nav-boxshadow"><a class="nav-link" href="login">Đăng nhập</a></li>
                            </c:if>
                        </ul>
                        </li>
                        <!-- <li class="nav-item"><a class="nav-link" href="contact.html">Contact</a></li> -->
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="nav-item"><a href="#" class="cart"><span class="ti-bag"></span></a></li>
                        <li class="nav-item">
                            <button class="search"><span class="lnr lnr-magnifier" id="search"></span></button>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <div class="search_input" id="search_input_box">
        <div class="container">
            <form class="d-flex justify-content-between">
                <input type="text" class="form-control" id="search_input" placeholder="Search Here">
                <button type="submit" class="btn"></button>
                <span class="lnr lnr-cross" id="close_search" title="Close Search"></span>
            </form>
        </div>
    </div>
</header>
<!-- End Header Area -->

