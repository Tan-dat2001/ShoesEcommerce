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
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Sản phẩm</th>
                        <th scope="col">Kích thước</th>
                        <th scope="col">Giá</th>
                        <th scope="col">Số lượng</th>
                        <th scope="col">Tổng tiền</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:set var="o" value="${sessionScope.cart}" />
                    <c:forEach var="i" items="${o.items}" >
                        <tr>
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
                                <h5>${i.product.product_price} đ</h5>
                            </td>
                            <td>
                                <div class="product_count">
                                    <input type="text" name="qty" id="sst" maxlength="12" value="1" title="Quantity:"
                                           class="input-text qty">
                                    <button onclick="var result = document.getElementById('sst'); var sst = result.value; if( !isNaN( sst )) result.value++;return false;"
                                            class="increase items-count increase-custom" type="button"><i class="lnr lnr-chevron-up"></i></button>
                                    <button onclick="var result = document.getElementById('sst'); var sst = result.value; if( !isNaN( sst ) &amp;&amp; sst > 0 ) result.value--;return false;"
                                            class="reduced items-count reduced-custom" type="button"><i class="lnr lnr-chevron-down"></i></button>
                                </div>
                            </td>
                            <td>
                                <h5>${i.product.product_price*i.quantity} đ</h5>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
                <c:set  var="total" value="0"/>
                <c:forEach var="i" items="${sessionScope.listItem}">
                    <c:set var="total" value="${total + i.product.product_price*i.quantity}"/>
                </c:forEach>
                <div class="sub-total">
                    <h5>Tổng tạm tính: ${total} đ</h5>
                </div>

                <div class="checkout_btn_inner d-flex align-items-center proceed-custom">
                    <a class="gray_btn" href="web-home">Tiếp tục mua sắm</a>
                    <a class="primary-btn" href="#">Thanh toán</a>
                </div>

            </div>
        </div>
    </div>
</section>
<!--================End Cart Area =================-->
</body>
</html>
