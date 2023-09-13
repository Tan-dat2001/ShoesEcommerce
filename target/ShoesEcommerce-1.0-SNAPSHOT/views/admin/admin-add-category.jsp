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
                    <h1 class="app-page-title mb-0">Thêm mới danh mục</h1>
                </div>
            </div>

            <div class="card">
                <div class="card-body">
                    <form action="admin-add-category" method="post">
                        <div class="row">
                            <div class="col-lg-3 col-sm-6 col-12">
                                <div class="form-group">

                                    <label>Tên danh mục</label>
                                    <input class="input-custom" type="text" name="category_name">
                                </div>
                            </div>

                                <div class="form-group">
                                    <button type="submit" class="btn-submit">Thêm mới</button>
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
