<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/9/2023
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
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
                    <h1 class="app-page-title mb-0" style="color: #0da95f">Thêm mới sản phẩm</h1>
                </div>
            </div>

            <div class="card">
                <div class="card-body">
                    <form action="admin-add-product" method="post">
                        <div class="row">
                            <div class="col-12">
                                <div style="font-size: 16px; color:red; margin-bottom: 20px;">${errorMessageQuantity}</div>
                            </div>
                            <div class="col-lg-3 col-sm-6 col-12">
                                <div class="form-group">
                                    <label>Tên sản phẩm</label>
                                    <input class="input-custom" type="text" name="productName">
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-6 col-12">
                                <div class="form-group">
                                    <label>Giá tiền</label>
                                    <input class="input-custom" type="text" name="productPrice">
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-6 col-12">
                                <div class="form-group">
                                    <label>Loại sản phẩm</label>
                                    <select class="selected-custom" name="selectedCategory">
                                        <option value="">Chọn thể loại</option>
                                        <c:forEach var="category" items="${listCategory}">
                                            <option value="${category.category_id}">${category.category_name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-6 col-12">
                                <div class="form-group">
                                    <label>Tổng số lượng sản phẩm</label>
                                    <input class="input-custom" type="number" inputmode="numeric" name="quantity"
                                           value="0">
                                </div>
                            </div>
                            <div class="col-lg-12 ">
                                <div class="form-group">
                                    <label>Hình ảnh 1</label>
                                    <input class="input-custom" type="text" name="image1">
                                </div>
                            </div>
                            <div class="col-lg-12 2">
                                <div class="form-group">
                                    <label>Hình ảnh 2</label>
                                    <input class="input-custom" type="text" name="image2">
                                </div>
                            </div>
                            <div class="col-lg-12 ">
                                <div class="form-group">
                                    <label>Hình ảnh 3</label>
                                    <input class="input-custom" type="text" name="image3">
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-group">
                                    <label>Mô tả sản phẩm</label>
                                    <textarea class="form-control" name="description"></textarea>
                                </div>
                            </div>
                            <div class="col-12" style="margin-bottom: 20px; color: #0da95f; font-weight: 700">Nhập số lượng mỗi size của sản phẩm</div>
                            <div class="col-lg-4 col-sm-6 col-12">
                                <div class="form-group">
                                    <label>Size 38</label>
                                    <input class="input-custom" type="number" inputmode="numeric" name="size38"
                                           value="0">
                                </div>
                            </div>
                            <div class="col-lg-4 col-sm-6 col-12">
                                <div class="form-group">
                                    <label>Size 39</label>
                                    <input class="input-custom" type="number" inputmode="numeric" name="size39"
                                           value="0">
                                </div>
                            </div>
                            <div class="col-lg-4 col-sm-6 col-12">
                                <div class="form-group">
                                    <label>Size 40</label>
                                    <input class="input-custom" type="number" inputmode="numeric" name="size40"
                                           value="0">
                                </div>
                            </div>
                            <div class="col-lg-4 col-sm-6 col-12">
                                <div class="form-group">
                                    <label>Size 41</label>
                                    <input class="input-custom" type="number" inputmode="numeric" name="size41"
                                           value="0">
                                </div>
                            </div>
                            <div class="col-lg-4 col-sm-6 col-12">
                                <div class="form-group">
                                    <label>Size 42</label>
                                    <input class="input-custom" type="number" inputmode="numeric" name="size42"
                                           value="0">
                                </div>
                            </div>
                            <div class="col-lg-4 col-sm-6 col-12">
                                <div class="form-group">
                                    <label>Size 43</label>
                                    <input class="input-custom" type="number" inputmode="numeric" name="size43"
                                           value="0">
                                </div>
                            </div>
                            <div class="col-lg-4 col-sm-6 col-12">
                                <div class="form-group">
                                    <button type="submit" class="btn-submit">Thêm mới</button>
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
