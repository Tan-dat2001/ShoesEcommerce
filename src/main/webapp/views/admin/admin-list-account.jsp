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
                <h1 class="app-page-title mb-0">Tài khoản người dùng</h1>
            </div>
            <div class="col-auto">
                <div class="page-utilities">
<%--                    <div class="row g-2 justify-content-start justify-content-md-end align-items-center">--%>
<%--                        <div class="col-auto">--%>


<%--                        </div><!--//col-->--%>
<%--                        <div class="col-auto">--%>

<%--                            <select class="form-select w-auto">--%>
<%--                                <option selected value="option-1">All</option>--%>
<%--                                <option value="option-2">This week</option>--%>
<%--                                <option value="option-3">This month</option>--%>
<%--                                <option value="option-4">Last 3 months</option>--%>

<%--                            </select>--%>
<%--                        </div>--%>
<%--                        <div class="col-auto">--%>
<%--                            <a class="btn app-btn-secondary" href="#">--%>
<%--                                <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-download me-1"--%>
<%--                                     fill="currentColor" xmlns="http://www.w3.org/2000/svg">--%>
<%--                                    <path fill-rule="evenodd"--%>
<%--                                          d="M.5 9.9a.5.5 0 0 1 .5.5v2.5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2.5a.5.5 0 0 1 1 0v2.5a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-2.5a.5.5 0 0 1 .5-.5z"/>--%>
<%--                                    <path fill-rule="evenodd"--%>
<%--                                          d="M7.646 11.854a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V1.5a.5.5 0 0 0-1 0v8.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3z"/>--%>
<%--                                </svg>--%>
<%--                                Download CSV--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                    </div><!--//row-->--%>
                </div><!--//table-utilities-->
            </div><!--//col-auto-->
        </div><!--//row-->


<div class="tab-pane fade show active" id="orders-all" role="tabpanel" aria-labelledby="orders-all-tab">
    <div class="app-card app-card-orders-table shadow-sm mb-5">
        <div class="app-card-body">
            <div class="table-responsive">

                <table class="table app-table-hover mb-0 text-left">
                    <thead>
                    <tr>
                        <th class="cell">ID</th>
                        <th class="cell" style="width: 200px">Email</th>
                        <th class="cell">Họ tên</th>
                        <th class="cell">Giới tính</th>
                        <th class="cell">Sinh nhật</th>
                        <th class="cell">Địa chỉ</th>
                        <th class="cell">SĐT</th>
                        <th class="cell">Quyền</th>
                        <th class="cell">Mở/Khoá</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${acc}" var="a">
                        <tr>
                            <td class="cell">${a.account_id}</td>
                            <td class="cell" style="width: 200px"><span
                                    class="truncate">${a.email}</span></td>
                            <td class="cell">${a.name} </td>
                            <td class="cell">${a.gender} </td>
                            <td class="cell">${a.dateofbirth} </td>
                            <td class="cell">${a.address} </td>
                            <td class="cell">${a.phone} </td>

                            <td class="cell">${a.role} </td>
                            <td class="cell">
                                <c:choose>
                                    <c:when test="${a.status eq 'disable'}">
                                        <a style="color: red" href="admin-change-status-account?account_id=${a.account_id}&status=${a.status}">
                                            <i class="fa-solid fa-circle-xmark"></i>
                                        </a>
                                    </c:when>
                                    <c:when test="${a.role eq 'admin'}">
                                        <i class="fa-regular fa-circle-check"></i>
                                    </c:when>

                                    <c:otherwise>
                                        <a  style="color: green" href="admin-change-status-account?account_id=${a.account_id}&status=${a.status}">
                                            <i class="fa-regular fa-circle-check"></i>
                                        </a>
                                    </c:otherwise>
                                </c:choose>

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

<%--            <c:forEach var="i" begin="1" end="${endPage}">--%>
<%--                <li class="page-item"><a class="page-link ${index == i ? 'active-pagination':''}"--%>
<%--                                         href="admin-product?index=${i}">${i}</a></li>--%>
<%--            </c:forEach>--%>

        </ul>

    </nav><!--//app-pagination-->

</div><!--//tab-pane-->
    </div>
</div>
</body>
</html>
