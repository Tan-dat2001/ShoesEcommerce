<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/17/2023
  Time: 8:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- Start Banner Area -->
<section class="banner-area organic-breadcrumb">
    <div class="container">
        <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
            <div class="col-first">
                <h1>Checkout</h1>
                <nav class="d-flex align-items-center">
                    <a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
                    <a href="single-product.html">Checkout</a>
                </nav>
            </div>
        </div>
    </div>
</section>
<!-- End Banner Area -->
<!--================Checkout Area =================-->
<section class="checkout_area section_gap">
    <div class="container">

        <div class="billing_details">
            <div class="row">
                <div class="col-lg-8">
                    <h3>Thông tin người nhận</h3>
                    <form class="row contact_form" action="#" method="post" novalidate="novalidate">
                        <div class="col-md-12 form-group p_star">
                            <input type="text" class="form-control" id="first" name="name">
                            <span class="placeholder" data-placeholder="Tên"></span>
                        </div>
                        <div class="col-md-6 form-group p_star">
                            <input type="text" class="form-control" id="number" name="number">
                            <span class="placeholder" data-placeholder="Số điện thoại"></span>
                        </div>
                        <div class="col-md-6 form-group">
                            <input type="text" class="form-control" id="email" name="email" placeholder="Email">
                        </div>
                        <div class="col-md-12 form-group p_star">
                            <input type="text" class="form-control" id="add1" name="address">
                            <span class="placeholder" data-placeholder="Địa chỉ"></span>
                        </div>

                        <div class="col-md-12 form-group">
                            <textarea class="form-control" name="note" id="message" rows="1" placeholder="Ghi chú"></textarea>
                        </div>

                        <div class="col-md-12 form-group">
                            <div class="title-delivery" style="    font-size: 18px;
                                color: #222222;
                                border-bottom: 1px solid #eee;
                                padding-bottom: 10px;
                                margin-bottom: 20px;">Phương thức vận chuyển</div>
                            <div class="delivery-method" style="font-size: 16px;">
                                <input type="radio" name="fast-delivery" value="GHN" id="fastDelivery">
                                <label for="fastDelivery">Giao hàng nhanh</label>
                                <br>
                                <input type="radio" name="standard-delivery" value="GHTC" id="standardDelivery">
                                <label for="standardDelivery">Giao hàng tiêu chuẩn</label>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-lg-4">
                    <div class="order_box">
                        <h2>Đơn hàng của bạn</h2>
                        <div class="rounded p-2">
                            <div class="media mb-2 ">
                                <div class="row">
                                    <c:set var="o" value="${sessionScope.cart}"/>
                                    <c:forEach var="i" items="${o.items}">
                                        <div class="col-lg-12 border-bottom mb-2" >
                                            <a class="row" href="" style="margin: 0 0 8px 0;font-size: 18px; color: #111111; font-weight: 500;">${i.product.product_name}</a>
                                            <div class="small text-muted row" style="font-size: 14px;">
                                                <p class="col-md-8">Giá: ${i.price}</p>
                                                <p class="col-md-4">Sl: x${i.quantity} </p>
                                                <p class="col-md-8">Tổng: ${i.price*i.quantity} đ</p>
                                                <p class="col-md-4">Size: ${i.size}</p>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                        <ul class="list list_2">
                            <li><a href="#">Tổng tạm tính <span>$2160.00</span></a></li>
                            <li><a href="#">Chi phí vận chuyển <span>Flat rate: $50.00</span></a></li>
                            <li><a href="#">Tổng đơn hàng <span>$2210.00</span></a></li>
                        </ul>

                        <a class="primary-btn" href="#">Thanh Toán</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--================End Checkout Area =================-->
</body>
</html>
