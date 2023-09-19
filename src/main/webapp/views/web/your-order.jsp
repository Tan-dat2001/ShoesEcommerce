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
                <h1>Hồ sơ</h1>
                <nav class="d-flex align-items-center">
                    <a href="web-home">Trang chủ<span class="lnr lnr-arrow-right"></span></a>
                    <a href="#">Đơn hàng của bạn</a>
                </nav>
            </div>
        </div>
    </div>
</section>
<div class="container" style="padding: 0; margin: 60px auto;">
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
            <h1 style="text-align: center">Đơn hàng của bạn </h1>

            <div class="content-panel">
                <c:forEach var="o" items="${listOrder}">
                    <div class="bg-white card mb-4 order-list shadow-sm">
                        <div class="gold-members p-4">
                            <a href="#"> </a>
                            <div class="media">
                                <div class="media-body">
                                    <a href="#">
                            <span class="float-right text-info">Mã đơn hàng: #${o.order_id}
                                <i class="icofont-check-circled text-success"></i>
                            </span>
                                    </a>
                                    <c:forEach var="info" items="${infoDelivery}">
                                        <c:if test="${o.order_id == info.order_id}">
                                            <h3 class="mb-2" style="font-weight:bold;"> Người nhận: ${info.name}</h3>
                                            <p class="mb-1">Số điện thoại: ${info.phone}</p>
                                            <p class=" mb-1"><i class="icofont-location-arrow"></i>
                                                Địa chỉ: ${info.address}
                                            </p>
                                        </c:if>
                                    </c:forEach>

                                    <p class=" mb-1">Ngày đặt hàng: ${o.order_date}</p>
                                    <div class="row">
                                        <div class="col-6">
                                            <p class="mb-1">Thanh toán: <span
                                                    class="text-danger">${o.payment_transaction}</span></p>
                                        </div>
                                        <div class="col-6 text-right">
                                            <c:forEach var="st" items="${orderStatus}">
                                                <c:if test="${st.status_id == o.status_id}">
                                                    <c:set var="status" value="${st.status_name }"/>
                                                </c:if>
                                            </c:forEach>
                                            <p class="mb-1 ">Trạng thái: <span class="text-danger">${status}</span></p>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="float-right">
                                        <a class="btn btn-sm btn-outline-primary" href="orderDetail-page?orderId=${o.order_id}"><i
                                                class="icofont-headphone-alt"></i> Xem chi tiết</a>
                                        <!-- <a	class="btn btn-sm btn-primary" href="#"><i
                                            class="icofont-refresh"></i> Mua Lại</a> -->
                                    </div>
                                    <p class="mb-0 text-black text-primary pt-2">
                                <span class="text-black font-weight-bold"
                                      style="color:#f37a27;"> Tổng thanh toán: ${o.total_amount} đ</span>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>


</div>
</body>
</html>
