<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                <h1>Shopping Cart</h1>
                <nav class="d-flex align-items-center">
                    <a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
                    <a href="category.html">Cart</a>
                </nav>
            </div>
        </div>
    </div>
</section>
<!-- End Banner Area -->

<!--================Cart Area =================-->
<section class="cart_area">
    <div class="container">
        <div class="cart_inner">
            <div class="table-responsive">
                <form action="checkout" method="get">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Sản phẩm</th>
                        <th scope="col">Size</th>
                        <th scope="col">Giá</th>
                        <th scope="col">Số lượng</th>
                        <th scope="col">Tổng tiền</th>
                        <th scope="col">Xóa sản phẩm</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:set var="o" value="${sessionScope.cart}" />
                        <c:forEach var="i" items="${o.items}" >
                            <tr class="product-item-custom">
                                <td>
                                    <div class="media">
                                        <div class="d-flex">
                                            <img src="${i.product.product_image}" alt="Ảnh giày" class="img-custom">
                                        </div>
                                        <div class="media-body">
                                            <p>${i.product.product_name}</p>
                                        </div>
                                    </div>
                                </td>
                                <td>
                                    <h5>${i.size}</h5>
                                </td>
                                <td>
                                    <h5 class="product-price" >${i.product.product_price} đ</h5>
                                </td>
                                <td>
                                    <div class="product_count">
                                        <input type="text" name="quantity" id="sst" maxlength="12" value="${i.quantity}" title="Quantity:"
                                               class="input-text qty">
                                        <button class="increase items-count increase-custom" type="button">
                                            <a href="processNum?num=1&productId=${i.product.product_id}&size=${i.size}"><i class="lnr lnr-chevron-up"></i></a>
                                        </button>
                                        <button class="reduced items-count reduced-custom" type="button">
                                            <a href="processNum?num=-1&productId=${i.product.product_id}&size=${i.size}"><i class="lnr lnr-chevron-down"></i></a>
                                        </button>
                                    </div>
                                </td>
                                <td>
    <%--                                <h5 class="total-price" >${i.product.product_price*i.quantity} đ</h5>--%>
                                    <h5 class="total-price" >${i.price*i.quantity}</h5>

                                </td>
                                <td style="text-align: center;">
                                    <a class="remove-custom" href="process-cart?productId=${i.product.product_id}">
                                        <i class="fa-solid fa-xmark"></i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
<%--                <h2>${messageCart}</h2>--%>
<%--                <c:set  var="total" value="0"/>--%>
<%--                <c:forEach var="i" items="${sessionScope.listItem}">--%>
<%--                    <c:set var="total" value="${total + i.product.product_price*i.quantity}"/>--%>
<%--                </c:forEach>--%>
                <div class="sub-total">
                    <h5 >Tổng tạm tính:
                        <c:set var="o" value="${sessionScope.cart}"/>
                        <c:set var="total" value="0"/>
                        <c:forEach var="i" items="${o.items}">
                            <c:set var="itemTotal" value="${i.product.product_price * i.quantity}" />
                            <c:set var="total" value="${total + itemTotal}" />
                        </c:forEach>
                        <span id="total-amount">${total}</span>
                    </h5>
                </div>

                <div class="checkout_btn_inner d-flex align-items-center proceed-custom">
                    <a class="gray_btn" href="web-home">Tiếp tục mua sắm</a>
                    <button class="primary-btn" href="checkout" type="submit" style="border: none">Thanh toán</button>
                </div>
                </form>

            </div>
        </div>
    </div>
</section>

<!--================End Cart Area =================-->
</body>
</html>
