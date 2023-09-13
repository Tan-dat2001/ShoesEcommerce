<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="app-content pt-3 p-md-3 p-lg-4">
    <div class="container-xl">
        <div class="page-header ">
            <div class="row g-3 mb-4 align-items-center justify-content-between">
                <div class="col-auto">
                    <h1 class="app-page-title mb-0" style="color: #0da95f">Chỉnh sửa sản phẩm</h1>
                </div>
            </div>

            <div class="card">
                <div class="card-body">
                    <form action="admin-edit-product" method="post">
                        <div class="row">
                            <div class="col-12">
                                <div style="font-size: 16px; color:red; margin-bottom: 20px;">${errorMessageQuantity}</div>
                            </div>
                            <div class="col-lg-3 col-sm-6 col-12">
                                <div class="form-group">
                                    <label>Tên sản phẩm</label>
                                    <input class="input-custom" type="text" name="productName" value="${product.product_name}">
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-6 col-12">
                                <div class="form-group">
                                    <label>Giá tiền</label>
                                    <input class="input-custom" type="text" name="productPrice" value="${product.product_price}">
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-6 col-12">
                                <div class="form-group">
                                    <label>Loại sản phẩm</label>
                                    <select class="selected-custom" name="selectedCategory">
                                        <c:forEach var="category" items="${listCategory}">
                                            <c:if test="${category.category_id == product.category_id}">
                                                <option value="${category.category_id}">${category.category_name}</option>
                                            </c:if>
                                        </c:forEach>
                                        <option value="">Chọn thể loại</option>
                                        <c:forEach var="category" items="${listCategory}">
                                            <c:choose>
                                                <c:when test="${category.category_id == product.category_id}">
                                                    <!-- Bỏ qua tùy chọn này nếu category_id trùng với product.category_id -->
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${category.category_id}">${category.category_name}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>

                                    </select>
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-6 col-12">
                                <div class="form-group">
                                    <label>Tổng số lượng sản phẩm</label>
                                    <input class="input-custom" type="number" inputmode="numeric" name="quantity"
                                           value="${product.quantity}">
                                </div>
                            </div>
                            <div class="col-lg-12 ">
                                <div class="form-group">
                                    <label>Hình ảnh 1</label>
                                    <input class="input-custom" type="text" name="image1" value="${image.image1}">
                                </div>
                            </div>
                            <div class="col-lg-12 2">
                                <div class="form-group">
                                    <label>Hình ảnh 2</label>
                                    <input class="input-custom" type="text" name="image2" value="${image.image2}">
                                </div>
                            </div>
                            <div class="col-lg-12 ">
                                <div class="form-group">
                                    <label>Hình ảnh 3</label>
                                    <input class="input-custom" type="text" name="image3" value="${image.image3}">
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-group">
                                    <label>Mô tả sản phẩm</label>
                                    <textarea class="form-control" name="description">${product.product_desc}</textarea>
                                </div>
                            </div>
                            <div class="col-12" style="margin-bottom: 20px; color: #0da95f; font-weight: 700">Nhập số lượng mỗi size của sản phẩm</div>
<%--                            <c:set var="size" value="38"/>--%>
                            <c:forEach var="psc" items="${listPSC}">
                                <div class="col-lg-4 col-sm-6 col-12">
                                    <div class="form-group">
                                        <c:forEach var="size" items="${listSize}">
                                            <c:if test="${size.id == psc.size_id}">
                                                <label>Size ${size.name}</label>
                                                <input class="input-custom" type="number" inputmode="numeric" name="size${size.name}"
                                                       value="${psc.quantity}">
                                            </c:if>

                                        </c:forEach>

                                    </div>
                                </div>
                            </c:forEach>
<%--                            <div class="col-lg-4 col-sm-6 col-12">--%>
<%--                                <div class="form-group">--%>
<%--                                    <label>Size 38</label>--%>
<%--                                    <input class="input-custom" type="number" inputmode="numeric" name="size38"--%>
<%--                                           value="0">--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="col-lg-4 col-sm-6 col-12">--%>
<%--                                <div class="form-group">--%>
<%--                                    <label>Size 39</label>--%>
<%--                                    <input class="input-custom" type="number" inputmode="numeric" name="size39"--%>
<%--                                           value="0">--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="col-lg-4 col-sm-6 col-12">--%>
<%--                                <div class="form-group">--%>
<%--                                    <label>Size 40</label>--%>
<%--                                    <input class="input-custom" type="number" inputmode="numeric" name="size40"--%>
<%--                                           value="0">--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="col-lg-4 col-sm-6 col-12">--%>
<%--                                <div class="form-group">--%>
<%--                                    <label>Size 41</label>--%>
<%--                                    <input class="input-custom" type="number" inputmode="numeric" name="size41"--%>
<%--                                           value="0">--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="col-lg-4 col-sm-6 col-12">--%>
<%--                                <div class="form-group">--%>
<%--                                    <label>Size 42</label>--%>
<%--                                    <input class="input-custom" type="number" inputmode="numeric" name="size42"--%>
<%--                                           value="0">--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="col-lg-4 col-sm-6 col-12">--%>
<%--                                <div class="form-group">--%>
<%--                                    <label>Size 43</label>--%>
<%--                                    <input class="input-custom" type="number" inputmode="numeric" name="size43"--%>
<%--                                           value="0">--%>
<%--                                </div>--%>
<%--                            </div>--%>
                            <div class="col-lg-3 col-sm-6 col-12">
                                <div class="form-group">
                                    <label style="color: #0da95f; font-size: 16px;">Trạng thái</label>
                                    <select class="selected-custom" name="selectedStatus">
                                        <c:if test="${product.status == 'enabled'}">
                                            <option value="enabled">enabled</option>
                                            <option value="disabled">disabled</option>
                                        </c:if>
                                        <c:if test="${product.status == 'disabled'}">
                                            <option value="disabled">disabled</option>
                                            <option value="enabled">enabled</option>
                                        </c:if>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-4 col-sm-6 col-12">
                                <div class="form-group">
                                    <input name="productId" value="${product.product_id}" type="hidden">
                                    <button type="submit" class="btn-submit">Lưu thay đổi</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
