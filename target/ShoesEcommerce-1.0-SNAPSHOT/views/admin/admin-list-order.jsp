<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body class="app">


<div class="app-content pt-3 p-md-3 p-lg-4">
    <div class="container-xl">
        <div class="row g-3 mb-4 align-items-center justify-content-between">
            <div class="col-auto">

                <h1 class="app-page-title mb-0">Đơn đặt hàng</h1>


            </div>
        </div><!--//row-->





        <div class="tab-content" id="orders-table-tab-content">
            <div class="tab-pane fade show active" id="orders-all" role="tabpanel" aria-labelledby="orders-all-tab">
                <div class="app-card app-card-orders-table shadow-sm mb-5">
                    <div class="app-card-body">
                        <div class="table-responsive">

                            <table class="table app-table-hover mb-0 text-left">
                                <thead>
                                <tr>
                                    <th class="cell"style="width: 80px">STT</th>
                                    <th class="cell" style="width: 80px">ID Đặt hàng</th>
                                    <th class="cell" style="width: 80px">Mã khách hàng</th>
                                    <th class="cell">Ngày đặt hàng</th>
                                    <th class="cell">Tổng tiền</th>
                                    <th class="cell"style="width: 120px">Thanh toán</th>
                                    <th class="cell" style="width: 100px">Vận chuyển</th>
                                    <th class="cell" style="width: 100px">Trạng thái</th>
                                    <th class="cell" style="width: 100px">Ghi chú</th>
                                    <th class="cell">Ngày cập nhật</th>
                                    <th class="cell">Tác vụ</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${orders}" var="o" varStatus="loop">
                                    <tr>

                                        <td class="cell" style="text-align: center">${loop.index + 1}</td>

                                        <td class="cell" style="text-align: center">#${o.order_id}</td>
                                        <td class="cell" style="text-align: center">#${o.account_id}</td>
                                        <td class="cell">${o.order_date}</td>
                                        <td class="cell">${o.total_amount} đ</td>
                                        <c:forEach items="${payment}" var="pay">
                                            <c:if test="${o.payment_id eq pay.payment_id}">
                                                <td class="cell" style="text-align: center; color: #6a12c9">${pay.payment_name}</td>
                                            </c:if>
                                        </c:forEach>

                                        <c:forEach items="${delivery}" var="de">
                                            <c:if test="${o.delivery_id eq de.delivery_id}">
                                                <td class="cell" style="text-align: center; color: #0a58ca">${de.delivery_name}</td>
                                            </c:if>
                                        </c:forEach>
                                        <c:forEach items="${status}" var="s">
                                            <c:if test="${o.status_id eq s.status_id}">
<%--                                                <td class="cell" style="text-align: center; color: #0da95f"> <span class="badge bg-success"> ${s.status_name}</span></td>--%>
                                                <c:if test="${o.status_id == 1 }">
                                                    <td class="cell" style="text-align: center; color: #0da95f"> <span class="badge bg-warning"> ${s.status_name}</span></td>
                                                </c:if>
                                                <c:if test="${o.status_id == 2 }">
                                                    <td class="cell" style="text-align: center; color: #0da95f"> <span class="badge bg-success"> ${s.status_name}</span></td>
                                                </c:if>
                                                <c:if test="${o.status_id == 3 }">
                                                    <td class="cell" style="text-align: center; color: #0da95f"> <span class="badge bg-info"> ${s.status_name}</span></td>
                                                </c:if>
                                                <c:if test="${o.status_id == 4 }">
                                                    <td class="cell" style="text-align: center; color: #0da95f"> <span class="badge bg-secondary"> ${s.status_name}</span></td>
                                                </c:if>
                                                <c:if test="${o.status_id == 5 }">
                                                    <td class="cell" style="text-align: center; color: #0da95f"> <span class="badge bg-danger"> ${s.status_name}</span></td>
                                                </c:if>

                                            </c:if>

                                        </c:forEach>



                                        <td class="cell" style="text-align: center">${o.order_note}</td>
                                        <td class="cell">${o.updateAt}</td>


                                        <td class="cell"><a href="admin-list-detail?orderId=${o.order_id}">Xem</a>

                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div><!--//table-responsive-->

                    </div><!--//app-card-body-->
                </div><!--//app-card-->
                <nav class="app-pagination">
                    <ul class="pagination justify-content-center">

                        <c:forEach var="i" begin="1" end="${endPage}">
                            <li class="page-item"><a class="page-link ${index == i ? 'active-pagination':''}"
                                                     href="admin-product?index=${i}">${i}</a></li>
                        </c:forEach>

                    </ul>

                </nav><!--//app-pagination-->

            </div><!--//tab-pane-->


        </div><!--//tab-content-->


    </div><!--//container-fluid-->
</div><!--//app-content-->

</body>
</html>
