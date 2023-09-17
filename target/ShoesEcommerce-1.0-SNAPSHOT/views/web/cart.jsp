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
                                    <input type="text" name="qty" id="sst" maxlength="12" value="${i.quantity}" title="Quantity:"
                                           class="input-text qty">
                                    <button class="increase items-count increase-custom" type="button">
                                        <i class="lnr lnr-chevron-up"></i>
                                    </button>
                                    <button class="reduced items-count reduced-custom" type="button">
                                        <i class="lnr lnr-chevron-down"></i>
                                    </button>
                                </div>
                            </td>
                            <td>
<%--                                <h5 class="total-price" >${i.product.product_price*i.quantity} đ</h5>--%>
                                <h5 class="total-price" ></h5>

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
                    <h5 >Tổng tạm tính: <span id="total-amount"></span></h5>
                </div>

                <div class="checkout_btn_inner d-flex align-items-center proceed-custom">
                    <a class="gray_btn" href="web-home">Tiếp tục mua sắm</a>
                    <a class="primary-btn" href="checkout">Thanh toán</a>
                </div>

            </div>
        </div>
    </div>
</section>

<script>
    document.addEventListener('DOMContentLoaded', function() {
        var productItems = document.querySelectorAll('.product-item-custom');
        // var priceItems = document.querySelectorAll('.total-price');
        var totalAmountElement = document.getElementById('total-amount');

        // Tạo một mảng lưu giá tiền của từng sản phẩm
        var productPrices = [];
        var totalPrices = [];
        productItems.forEach(function(item) {
            var quantityInput = item.querySelector('.qty');
            var increaseButton = item.querySelector('.increase');
            var reduceButton = item.querySelector('.reduced');
            var priceElement = item.querySelector('.product-price');
            var totalPriceElement = item.querySelector('.total-price');

            // Lấy giá tiền ban đầu của sản phẩm
            var price = parseFloat(priceElement.textContent.replace('0 đ', '').replace(/\./g, '').replace(',', '.'));
            var totalPrice =parseFloat(priceElement.textContent.replace('0 đ', '').replace(/\./g, '').replace(',', '.'));
            priceElement.textContent = formatCurrency(price);
            // totalPriceElement.textContent = formatCurrency(totalPrice);
            //thêm giá của item vào mảng
            productPrices.push(price);
            //cập nhật tổng giá tiền của item
            updateTotalPrice(priceElement,totalPriceElement,quantityInput.value);

            //đặt biết gán tổng giá trị của 1 item
            let priceEle = 0;
            for(let i=0; i<quantityInput.value;i++){
                priceEle += price;
                totalPrices.push(priceEle); //thêm vào mảng
            }
            updateTotalAmount(totalPrices);

            increaseButton.addEventListener('click', function() {
                var currentQuantity = parseInt(quantityInput.value);
                if (!isNaN(currentQuantity)) {
                    quantityInput.value = currentQuantity + 1;
                    updateTotalPrice(priceElement, totalPriceElement, quantityInput.value);
                    let price = parseFloat(priceElement.textContent.replace('0 đ', '').replace(/\./g, '').replace(',', '.'));
                    totalPrices.push(price);
                    updateTotalAmount(totalPrices);
                }
            });

            reduceButton.addEventListener('click', function() {
                var currentQuantity = parseInt(quantityInput.value);
                if (!isNaN(currentQuantity) && currentQuantity > 1) {
                    quantityInput.value = currentQuantity - 1;
                    updateTotalPrice(priceElement, totalPriceElement, quantityInput.value);
                    // let price = parseFloat(priceElement.textContent.replace('0 đ', '').replace(/\./g, '').replace(',', '.'));
                    totalPrices.pop();
                    updateTotalAmount(totalPrices);
                }
            });
        });

        function updateTotalPrice(priceElement, totalPriceElement, quantity) {
            var price = parseFloat(priceElement.textContent.replace('0 đ', '').replace(/\./g, '').replace(',', '.'));
            if (!isNaN(price)) {
                var total = price * quantity;
                totalPriceElement.textContent = formatCurrency(total);
            }
        }

        function updateTotalAmount(prices) {
            var total = prices.reduce(function(sum, price) {
                return sum + price;
            }, 0);
            totalAmountElement.textContent = formatCurrency(total);
        }


        function formatCurrency(amount) {
            return new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND', minimumFractionDigits:0}).format(amount);
        }
    });

</script>
<!--================End Cart Area =================-->
</body>
</html>
