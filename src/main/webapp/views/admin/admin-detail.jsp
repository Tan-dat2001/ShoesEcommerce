<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách sản phẩm và thông tin gửi hàng</title>
    <!-- Bao gồm các tệp CSS và JavaScript của Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="app-content pt-3 p-md-3 p-lg-4">
    <div class="container-xl">
        <div class="row g-3 mb-4 align-items-center justify-content-between">
            <div class="col-auto">
                <h1 class="app-page-title mb-0"></h1>
            </div>
            <div class="col-auto">
                <div class="page-utilities">

                </div><!--//table-utilities-->
            </div><!--//col-auto-->
        </div>
<div class="container">
    <div class="row">
        <div class="col-md-7">
            <h1 class="app-page-title mb-0">Đơn hàng sản phẩm</h1>
            <c:forEach items="${detail}" var="d">
            <ul class="list-group">
                    <li class="list-group-item">
                        <c:forEach items="${product}" var="p">
                            <c:if test="${d.product_id eq p.product_id}">
                            <div style="display: inline-block;">
                                <img src="${p.product_image}" alt="${p.product_name} image" style="width: 150px; height: 150px">
                            </div>

                            <div style="display: inline-block; vertical-align: top;">
                                <h3>${p.product_name}</h3>
                                <span>Số lượng: ${d.quantity} </span><br>
                                <span>Giá: ${d.price}</span>
                            </div>
                            </c:if>
                        </c:forEach>
                    </li>
            </ul>
            </c:forEach>
        </div>
        <div class="col-md-5">
            <h1 class="app-page-title mb-0">Thông tin gửi hàng</h1>
            <ul class="list-group">



                    <li class="list-group-item">Tên người nhận: ${info.name}</li>
                    <li class="list-group-item">Địa chỉ nhận hàng: ${info.address}</li>
                    <li class="list-group-item">Số điện thoại:${info.phone}</li>



                    <c:forEach items="${delivery}" var="de">
                        <c:if test="${orders.delivery_id == de.delivery_id}">
                            <li class="list-group-item">Phương thức vận chuyển: ${de.delivery_name}</li>
                        </c:if>
                    </c:forEach>

            </ul>


            <div style="margin-top: 30px;">
                <p>Trạng thái đơn hàng</p>
                <br>

                    <c:if test="${orders.status_id == 1}">
                        <a href="admin-change-status-order?order_id=${orders.order_id}&status_id=2">
                            <button type="button"  class="btn btn-success">Xác nhận</button>
                        </a>
                        <a href="admin-change-status-order?order_id=${orders.order_id}&status_id=3">
                            <button type="button" class="btn btn-info">Đang giao hàng</button>
                        </a>


                        <a  href="admin-change-status-order?order_id=${orders.order_id}&status_id=4">
                            <button type="button" class="btn btn-secondary">Hoàn thành</button>
                        </a>


                        <a  href="admin-change-status-order?order_id=${orders.order_id}&status_id=5">
                            <button type="button" class="btn btn-danger">Huỷ</button>

                        </a>
                    </c:if>
                    <c:if test="${orders.status_id == 2}">
                        <a href="admin-change-status-order?order_id=${orders.order_id}&status_id=3">
                            <button type="button" class="btn btn-info">Đang giao hàng</button>
                        </a>


                        <a  href="admin-change-status-order?order_id=${orders.order_id}&status_id=4">
                            <button type="button" class="btn btn-secondary">Hoàn thành</button>
                        </a>


                        <a  href="admin-change-status-order?order_id=${orders.order_id}&status_id=5">
                            <button type="button" class="btn btn-danger">Huỷ</button>

                        </a>
                    </c:if>
                    <c:if test="${orders.status_id == 3}">
                        <a  href="admin-change-status-order?order_id=${orders.order_id}&status_id=4">
                            <button type="button" class="btn btn-secondary">Hoàn thành</button>
                        </a>


                        <a  href="admin-change-status-order?order_id=${orders.order_id}&status_id=5">
                            <button type="button" class="btn btn-danger">Huỷ</button>

                        </a>
                    </c:if>
                    <c:if test="${orders.status_id == 4}">
                        <h3 style="color: green">Đơn hàng đã hoàn thành</h3>

                    </c:if>
                    <c:if test="${orders.status_id == 5}">
                            <h3 style="color: red">Đơn hàng đã bị huỷ</h3>
                    </c:if>

<%--                        <a href="admin-change-status-order?order_id=${orders.order_id}&status_id=2">--%>
<%--                            <button type="button"  class="btn btn-success">Xác nhận</button>--%>
<%--                        </a>--%>


<%--                        <a href="admin-change-status-order?order_id=${orders.order_id}&status_id=3">--%>
<%--                            <button type="button" class="btn btn-info">Đang giao hàng</button>--%>
<%--                        </a>--%>


<%--                        <a  href="admin-change-status-order?order_id=${orders.order_id}&status_id=4">--%>
<%--                            <button type="button" class="btn btn-secondary">Hoàn thành</button>--%>
<%--                        </a>--%>


<%--                        <a  href="admin-change-status-order?order_id=${orders.order_id}&status_id=5">--%>
<%--                            <button type="button" class="btn btn-danger">Huỷ</button>--%>

<%--                        </a>--%>

<%--                    <div style="margin-top: 15px; margin-left: 170px">--%>
<%--&lt;%&ndash;                        <a href="admin-change-status-order?order_id=${orders.order_id}&status_id=1">&ndash;%&gt;--%>
<%--                            <button type="button" class="btn btn-warning">Đang xử lý</button>--%>

<%--&lt;%&ndash;                        </a>&ndash;%&gt;--%>
<%--                    </div>--%>





            </div>

        </div>
    </div>
</div>
    </div>
</div>
<!-- Bao gồm các tệp JavaScript của Bootstrap (tùy chọn) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.5.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
