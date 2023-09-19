<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                <h1>Product Details Page</h1>
                <nav class="d-flex align-items-center">
                    <a href="web-home">Home<span class="lnr lnr-arrow-right"></span></a>
                    <a href="#">Shop<span class="lnr lnr-arrow-right"></span></a>
                    <a href="#">product-details</a>
                </nav>
            </div>
        </div>
    </div>
</section>
<!-- End Banner Area -->
<!--================Single Product Area =================-->
<div class="product_image_area">
    <div class="container">
        <div class="row s_product_inner">
            <div class="col-lg-6">
                <div class="s_Product_carousel">
                    <div class="single-prd-item">
                        <img class="img-fluid"  alt="" src="${image.image1}">
                    </div>
                    <div class="single-prd-item">
                        <img class="img-fluid"  alt="" src="${image.image2}">
                    </div>
                    <div class="single-prd-item">
                        <img class="img-fluid" alt="" src="${image.image3}">
                    </div>
                </div>
            </div>
            <div class="col-lg-5 offset-lg-1">
                <form action="addtocart" method="get">
                    <div class="s_product_text">
                        <h3>${product.product_name}</h3>
                        <%--productPrice được format và setAttribute ở ProductDetailController--%>
                        <h2 id="formatted-price">${productPrice}</h2>
                        <h5 class="product-purchases">Đã bán: ${product.purchases}</h5>
                        <%--                    <ul class="list">--%>
                        <%--                        <li><a class="active" href="#"><span>Category</span> : Household</a></li>--%>
                        <%--                        <li><a href="#"><span>Availibility</span> : In Stock</a></li>--%>
                        <%--                    </ul>--%>

                        <div class="container-size" style="margin-top: 32px; color:#000;">
                            <div class="select-size">Chọn kích cỡ</div>
                            <div class="product-size">
                                <div class="product-item-size">
                                    <input type="radio" id="size35" name="size" value="35">
                                    <label for="size35">35</label><br>
                                </div>
                                <div class="product-item-size">
                                    <input type="radio" id="size36" name="size" value="36">
                                    <label for="size36">36</label><br>
                                </div>
                                <div class="product-item-size">
                                    <input type="radio" id="size37" name="size" value="37">
                                    <label for="size37">37</label>
                                </div>
                                <div class="product-item-size">
                                    <input type="radio" id="size38" name="size" value="38">
                                    <label for="size38">38</label>
                                </div>
                                <div class="product-item-size">
                                    <input type="radio" id="size39" name="size" value="39">
                                    <label for="size39">39</label>
                                </div>
                                <div class="product-item-size">
                                    <input type="radio" id="size40" name="size" value="40">
                                    <label for="size40">40</label>
                                </div>
                                <div class="product-item-size">
                                    <input type="radio" id="size41" name="size" value="41">
                                    <label for="size41">41</label>
                                </div>
                                <div class="product-item-size">
                                    <input type="radio" id="size42" name="size" value="42">
                                    <label for="size42">42</label>
                                </div>
                            </div>
                        </div>
                        <div class="product_count">
                            <%--@declare id="qty"--%><label for="qty">Quantity:</label>
                            <input type="text" name="quantity" id="sst" maxlength="12" value="1" title="Số lượng:"
                                   class="input-text qty">
                            <button
                                    onclick="var result = document.getElementById('sst'); var sst = result.value; if( !isNaN( sst )) result.value++;return false;"
                                    class="increase items-count increase-custom" type="button"><i class="lnr lnr-chevron-up"></i></button>
                            <button
                                    onclick="var result = document.getElementById('sst'); var sst = result.value; if( !isNaN( sst ) &amp;&amp; sst > 1 ) result.value--;return false;"
                                    class="reduced items-count reduced-custom" type="button"><i class="lnr lnr-chevron-down"></i></button>
                        </div>
                        <div class="card_area d-flex align-items-center">
                            <button class="primary-btn" type="submit" style="border: none">Thêm vào giỏ hàng</button>
                        </div>
                        <!-- Thêm phần tử ẩn để lưu giá trị kích cỡ -->
                        <input type="hidden" name="selectedSize" id="selected-size">
                        <input type="hidden" name="productId" value="${product.product_id}">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!--================End Single Product Area =================-->
<!--================Product Description Area =================-->
<section class="product_description_area">
    <div class="container">
        <div class="nav nav-tabs">
            <div class="nav-item">
                <div class="description-title" aria-selected="true">Mô tả</div>
            </div>
        </div>
        <div class="tab-content">
            <div class="description-content">
                <p>${product.product_desc}</p>
            </div>
            <div class="single-prd-item image-custom">
                    <img class="img-fluid" style="width: 100%" alt="" src="${image.image1}">
            </div>

            <div class="single-prd-item image-custom">
                <img class="img-fluid" style="width: 100%" alt="" src="${image.image2}">
            </div>

            <div class="single-prd-item image-custom">
                <img class="img-fluid" style="width: 100%" alt="" src="${image.image3}">
            </div>
        </div>
    </div>
</section>
<!--================End Product Description Area =================-->
<script>
    document.addEventListener('DOMContentLoaded', function() {
        var radioButtons = document.querySelectorAll('input[name="size"]');
        var selectedSizeInput = document.getElementById('selected-size');

        radioButtons.forEach(function(radioButton) {
            radioButton.addEventListener('change', function() {
                if (this.checked) {
                    selectedSizeInput.value = this.value;
                }
            });
        });
    });
</script>

</body>
</html>
