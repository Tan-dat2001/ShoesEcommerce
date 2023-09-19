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
                    <a href="web-home">Home<span class="lnr lnr-arrow-right"></span></a>
                    <a href="#">Checkout</a>
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
            <form action="checkout" method="post">
                <div class="row">
                    <div class="col-lg-8">
                        <h3>Thông tin người nhận</h3>
                        <div class="col-md-12 form-group p_star">
                            <input type="text" class="form-control" id="first" name="name" placeholder="Họ tên"
                                   required>
                        </div>
                        <div class="col-md-12 form-group p_star">
                            <input type="text" class="form-control" id="number" name="number" placeholder="phone"
                                   required>
                        </div>
<%--                        <div class="col-md-6 form-group">--%>
<%--                            <input type="text" class="form-control" id="email" name="email" placeholder="Email">--%>
<%--                        </div>--%>
                        <div class="col-md-12 form-group p_star">
                            <input type="text" class="form-control" id="add1" name="address" placeholder="Địa chỉ"
                                   required>
                        </div>

                        <div class="col-md-12 form-group">
                            <textarea class="form-control" name="note" id="message" rows="1" placeholder="Ghi chú"
                                      style="height: 60px;"></textarea>
                        </div>

                        <div class="col-md-12 form-group">
                            <div class="title-delivery" style="    font-size: 18px;
                                color: #222222;
                                border-bottom: 1px solid #eee;
                                padding-bottom: 10px;
                                margin-bottom: 20px;">Phương thức vận chuyển
                            </div>
                            <div class="delivery-method" style="font-size: 16px;">
                                <c:forEach var="delivery" items="${listDelivery}">
                                    <input type="radio" name="delivery" value="${delivery.delivery_id}"
                                           id="${delivery.delivery_id}">
                                    <label for="${delivery.delivery_id}">${delivery.delivery_name} <span
                                            style="margin-left: 150px;">${delivery.delivery_price}</span></label>
                                    <br>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="order_box">
                            <h2>Đơn hàng của bạn</h2>
                            <div class="rounded p-2">
                                <div class="media mb-2 ">
                                    <div class="row">
                                        <c:set var="o" value="${sessionScope.cart}"/>
                                        <c:forEach var="i" items="${o.items}">
                                            <div class="col-lg-12 border-bottom mb-2">
                                                <a class="row" href=""
                                                   style="margin: 0 0 8px 0;font-size: 18px; color: #111111; font-weight: 500;">${i.product.product_name}</a>
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
                                <c:set var="o" value="${sessionScope.cart}"/>
                                <c:set var="total" value="0"/>
                                <c:forEach var="i" items="${o.items}">
                                    <c:set var="itemTotal" value="${i.product.product_price * i.quantity}"/>
                                    <c:set var="total" value="${total + itemTotal}"/>
                                </c:forEach>
                                <li><a href="#">Tổng tạm tính <span>${total}</span></a></li>
                                <li><a href="#">Chi phí vận chuyển <span>Flat rate: $50.00</span></a></li>
                                <li><a href="#">Tổng đơn hàng <span>$2210.00</span></a></li>
                            </ul>

                            <button class="primary-btn" type="submit" style="border: none;">Thanh Toán</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</section>
<!--================End Checkout Area =================-->
</body>
</html>
