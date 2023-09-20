<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<section class="banner-area organic-breadcrumb">
    <div class="container">
        <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
            <div class="col-first">
                <h1>Chi tiết đơn hàng</h1>
                <nav class="d-flex align-items-center">
                    <a href="web-home">Trang chủ<span class="lnr lnr-arrow-right"></span></a>
                    <a href="#">Chi tiết đơn hàng</a>
                </nav>
            </div>
        </div>
    </div>
</section>
<div class="container" style="padding: 0;margin: 60px auto;">

    <div class="row">
        <div class="col-xl-3 col-lg-4 col-md-5">
            <div class="sidebar-categories">
                <div class="head">Hồ sơ</div>
                <ul class="main-categories">
                    <li class="main-nav-list">
                        <a href="web-profile">Thông tin tài khoản</a>
                        <a href="your-order">Đơn hàng của bạn</a>
                        <a href="update-pass">Đổi mật khẩu</a>
                        <a href="log-out">Đăng xuất</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="sidebar-filter mt-50">
            <div class="sidebar-categories"></div>
        </div>

        <div class="col-xl-9 col-lg-8 col-md-7">
            <h1 style="text-align: center">Chi tiết đơn hàng </h1>
<%--            <c:set var="info" value="${infoDelivery}" />--%>
<%--            <c:set var="o" value="${orderInfo}" />--%>
            <!-- Start body order-detail -->
            <section class="h-100 h-custom">
<%--                <div class="container py-5 h-100">--%>
                    <div class="row d-flex justify-content-center align-items-center h-100">
                        <div class="col-lg-8 col-xl-6" style="min-width: 900px;">
                            <div class="card border-top border-bottom border-3"
                                 style="border-color: #f37a27 !important;">
                                <div class="card-body p-5">

                                    <p class="lead fw-bold mb-1" style="color: #f37a27;">Chi tiết
                                        đơn hàng</p>
                                    <div class="row">
                                        <div class="col ">
                                            <p class="small">Người nhận:</p>
                                            <p>${infoDelivery.name}</p>
                                        </div>
                                        <div class="col">
                                            <p class="small">Ngày đặt hàng:</p>
                                            <p>${orderInfo.order_date}</p>
                                        </div>
                                        <div class="col ">
                                            <p class="small ">Số điện thoại:</p>
                                            <p>${infoDelivery.phone}</p>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-3 small ">
                                            <p>Địa chỉ:</p>
                                        </div>
                                        <div class="col-9 ">
                                            <p>${infoDelivery.address}</p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <p class="small col-12">
                                            Ghi chú: <span style="font-size: 18px; font-weight: normal;">${infoDelivery.note}</span>
                                        </p>
                                    </div>
                                    <c:forEach var="od" items="${orderDetails}">
                                        <div class="mx-n5 px-4 py-4 mb-1"
                                             style="background-color: #f2f2f2;">
                                            <div class="row">
                                                <div class="col-md-8 col-lg-9">
                                                    <c:forEach var="p" items="${products}">
                                                        <c:if test="${p.product_id == od.product_id}">
                                                            <p>${p.product_name}</p>
                                                        </c:if>
                                                    </c:forEach>
                                                </div>
                                                <div class="col-md-4 col-lg-3">
                                                    <p>x${od.quantity}</p>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-8 col-lg-9">
                                                    <p class="mb-0">Đơn giá:</p>
                                                </div>
                                                <c:forEach var="p" items="${products}">
                                                    <c:if test="${p.product_id == od.product_id}">
                                                        <div class="col-md-4 col-lg-3">
                                                            <p class="mb-0">${p.product_price} đ</p>
                                                        </div>
                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-8 col-lg-9">
                                                    <p class="mb-0">Thành tiền:</p>
                                                </div>
                                                <div class="col-md-4 col-lg-3">
                                                    <p class="mb-0">${od.total_amount}đ</p>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>


                                    <div class="row my-4">
                                        <div class="col-md-4 offset-md-8 col-lg-3 offset-lg-9">
                                            <p class="lead fw-bold mb-0" style="color: #f37a27;">Tổng
                                                thanh toán: ${orderInfo.total_amount} đ</p>
                                        </div>
                                    </div>
                                    <p class="mt-4 pt-2 mb-0">
                                        Liên lạc chúng tôi: <a href="#!" style="color: #f37a27;">+84
                                        901172380</a>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
<%--                </div>--%>
            </section>
        </div>
    </div>
</div>

</body>
</html>
