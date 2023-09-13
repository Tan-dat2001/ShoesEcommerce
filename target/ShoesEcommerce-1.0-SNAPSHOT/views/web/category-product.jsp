<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh mục sản phẩm</title>
</head>
<body id="category">


<!-- Start Banner Area -->
<section class="banner-area organic-breadcrumb">
    <div class="container">
        <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
            <div class="col-first">
                <h1>Shop Category page</h1>
                <nav class="d-flex align-items-center">
                    <a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
                    <a href="#">Shop<span class="lnr lnr-arrow-right"></span></a>
                    <a href="category.html">Fashon Category</a>
                </nav>
            </div>
        </div>
    </div>
</section>
<!-- End Banner Area -->
<div class="container" style="padding: 0">
    <div class="row">
        <div class="col-xl-3 col-lg-4 col-md-5">
            <div class="sidebar-categories">
                <div class="head">Browse Categories</div>

                <ul class="main-categories">
                    <c:forEach items="${category}" var="c">
                        <li class="main-nav-list">
                            <a href="product-category?categoryId=${c.category_id}">${c.category_name}</a>
                        </li>
                    </c:forEach>
                </ul>

            </div>
            <div class="sidebar-filter mt-50">
                <div class="top-filter-head">Product Filters</div>
                <%--                <div class="common-filter">--%>
                <%--                    <div class="head">Brands</div>--%>
                <%--                    <form action="#">--%>
                <%--                        <ul>--%>
                <%--                            <li class="filter-list"><input class="pixel-radio" type="radio" id="apple" name="brand"><label for="apple">Apple<span>(29)</span></label></li>--%>
                <%--                            <li class="filter-list"><input class="pixel-radio" type="radio" id="asus" name="brand"><label for="asus">Asus<span>(29)</span></label></li>--%>
                <%--                            <li class="filter-list"><input class="pixel-radio" type="radio" id="gionee" name="brand"><label for="gionee">Gionee<span>(19)</span></label></li>--%>
                <%--                            <li class="filter-list"><input class="pixel-radio" type="radio" id="micromax" name="brand"><label for="micromax">Micromax<span>(19)</span></label></li>--%>
                <%--                            <li class="filter-list"><input class="pixel-radio" type="radio" id="samsung" name="brand"><label for="samsung">Samsung<span>(19)</span></label></li>--%>
                <%--                        </ul>--%>
                <%--                    </form>--%>
                <%--                </div>--%>
                <%--                <div class="common-filter">--%>
                <%--                    <div class="head">Color</div>--%>
                <%--                    <form action="#">--%>
                <%--                        <ul>--%>
                <%--                            <li class="filter-list"><input class="pixel-radio" type="radio" id="black" name="color"><label for="black">Black<span>(29)</span></label></li>--%>
                <%--                            <li class="filter-list"><input class="pixel-radio" type="radio" id="balckleather" name="color"><label for="balckleather">Black--%>
                <%--                                Leather<span>(29)</span></label></li>--%>
                <%--                            <li class="filter-list"><input class="pixel-radio" type="radio" id="blackred" name="color"><label for="blackred">Black--%>
                <%--                                with red<span>(19)</span></label></li>--%>
                <%--                            <li class="filter-list"><input class="pixel-radio" type="radio" id="gold" name="color"><label for="gold">Gold<span>(19)</span></label></li>--%>
                <%--                            <li class="filter-list"><input class="pixel-radio" type="radio" id="spacegrey" name="color"><label for="spacegrey">Spacegrey<span>(19)</span></label></li>--%>
                <%--                        </ul>--%>
                <%--                    </form>--%>
                <%--                </div>--%>
                <div class="common-filter">
                    <div class="head">Price</div>

                    <form id="price-form" action="product-rangePrice" method="post">
                        <div class="price-range-area">
                            <div id="price-range"></div>
                            <div class="value-wrapper d-flex">
                                <div class="price">Price:</div>
                                <div id="lower-value" name="lowerValue"></div>
                                <input type="hidden" id="lower-value-input" name="lowerValue">
                                <div class="to">to</div>
                                <div id="upper-value" name="upperValue"></div>
                                <input type="hidden" id="upper-value-input" name="upperValue">
                            </div>

                            <input type="submit" value="Chọn">
                        </div>

                    </form>
                </div>
            </div>
        </div>
        <div class="col-xl-9 col-lg-8 col-md-7">
            <!-- Start Filter Bar -->
            <div class="filter-bar d-flex flex-wrap align-items-center">
                <div class="sorting">
                    <select>
                        <option value="1">Default sorting</option>
                        <option value="1">Default sorting</option>
                        <option value="1">Default sorting</option>
                    </select>
                </div>
                <div class="sorting mr-auto">
                    <select>
                        <option value="1">Show 12</option>
                        <option value="1">Show 12</option>
                        <option value="1">Show 12</option>
                    </select>
                </div>
                <div class="pagination">
                    <a href="#" class="prev-arrow"><i class="fa fa-long-arrow-left" aria-hidden="true"></i></a>
                    <c:forEach begin="1" end="${endP}" var="i">
                        <a href="" class="active">${i}</a>
                    </c:forEach>


                    <a href="#" class="next-arrow"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></a>
                </div>
            </div>
            <!-- End Filter Bar -->
            <!-- Start Best Seller -->
            <section class="lattest-product-area pb-40 category-list">
                <div class="row">
                    <!-- single product -->

                    <c:forEach items="${product}" var="p">
                        <c:if test="${p.status == 'enabled'}">
                            <div class="col-lg-4 col-md-6">
                                <div class="single-product">
                                    <img class="img-fluid" style="height: 320px;" src="${p.product_image}" alt="">
                                    <div class="product-details">
                                        <h6>${p.product_name}</h6>
                                        <div class="price">
                                            <h6 class="formatted-price">${p.product_price}</h6>
                                            <h6 class="l-through formatted-price">${p.product_price*1.2}</h6>
                                        </div>
                                        <div class="prd-bottom">

                                                <%--                                    <a href="addtocart?productId=${p.product_id}&quantity=1" class="social-info">--%>
                                                <%--                                        <span class="ti-bag"></span>--%>
                                                <%--                                        <p class="hover-text">Thêm vào giỏ</p>--%>
                                                <%--                                    </a>--%>
                                            <a href="product-detail?productId=${p.product_id}" class="social-info">
                                                <span class="lnr lnr-move"></span>
                                                <p class="hover-text">Xem chi tiết</p>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </section>
            <!-- End Best Seller -->

        </div>
    </div>
</div>

<%--<script>--%>
<%--    document.addEventListener('DOMContentLoaded', function() {--%>
<%--        // Lấy tất cả các phần tử có class "formatted-price"--%>
<%--        var formattedPriceElements = document.querySelectorAll('.formatted-price');--%>

<%--        // Lặp qua tất cả các phần tử để định dạng giá trị--%>
<%--        formattedPriceElements.forEach(function(element) {--%>
<%--            var priceText = element.textContent;--%>
<%--            var price = parseFloat(priceText.replace('0.0 đ', '').replace(/\./g, '').replace(',', '.'));--%>

<%--            // Kiểm tra xem giá có hợp lệ không--%>
<%--            if (!isNaN(price)) {--%>
<%--                // Định dạng giá và cập nhật nội dung của phần tử--%>
<%--                var formattedPrice = formatCurrency(price);--%>
<%--                element.textContent = formattedPrice;--%>
<%--            }--%>
<%--        });--%>
<%--    });--%>

<%--    // Hàm để định dạng số tiền sang tiền Việt Nam--%>
<%--    function formatCurrency(amount) {--%>
<%--        return new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(amount);--%>
<%--    }--%>
<%--</script>--%>
</body>

</html>
