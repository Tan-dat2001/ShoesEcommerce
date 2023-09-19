<%@ page import="com.shoesecom.Model.Account" %>
<%@ page import="java.sql.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>


<%
    HttpSession s = request.getSession();
    Account account = (Account) s.getAttribute("account");

    //int account_id = account.getAccount_id();

%>
<section class="banner-area organic-breadcrumb">
    <div class="container">
        <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
            <div class="col-first">
                <h1>profile</h1>
                <nav class="d-flex align-items-center">
                    <a href="web-home">Home<span class="lnr lnr-arrow-right"></span></a>
                    <a href="web-category">Shop<span class="lnr lnr-arrow-right"></span></a>
                    <a href="web-category">Fashon Category</a>
                </nav>
            </div>
        </div>
    </div>
</section>
<!-- End Banner Area -->
<div class="container" style="padding: 0;margin: 60px auto;">

    <div class="row">
        <div class="col-xl-3 col-lg-4 col-md-5">
            <div class="sidebar-categories">
                <div class="head">Hồ sơ</div>

                <ul class="main-categories">

                    <li class="main-nav-list">
                        <a href="web-profile">Thông tin tài khoản</a>
                        <a href="your-order">Đơn hàng của bạn</a>
                        <a href="update-pass">Đổi mật khẩu</a>
                        <a href="log-out">Đăng xuất</a>
                    </li>

                </ul>


            </div>

        </div>
        <div class="sidebar-filter mt-50">
            <div class="sidebar-categories"></div>
        </div>

        <div class="col-xl-9 col-lg-8 col-md-7">
            <h1 style="text-align: center">Đổi mật khẩu </h1>

<%--            <!-- Start Best Seller -->--%>
<%--            <section class="lattest-product-area pb-40 category-list">--%>

                <!-- single product -->
                <form action="update-pass" method="post">
                    <div class="mb-3">
                        <label class="mb-2">Mật khẩu cũ</label>
                        <input type="password" class="form-control" name="old-password">
                    </div>
                    <div class="mb-3">
                        <label class="mb-2">Mật khẩu mới</label>
                        <input type="password" class="form-control" name="new-password">
                    </div>
                    <div class="mb-3">
                        <label class="mb-2">Xác nhận mật khẩu</label>
                        <input type="password" class="form-control" name="confirm-password">
                    </div>
                        <input type="hidden" value="${account.account_id}" name="account_id">
                    <button type="submit" class="btn btn-outline-primary">Lưu</button>
                    <div class="mb-3" style="color: red;font-size: 20px;">${error1}</div>
                    <div class="mb-3" style="color: red;font-size: 20px;">${error2}</div>
                </form>







<%--            </section>--%>
            <!-- End Best Seller -->

        </div>
    </div>
</div>


</body>
</html>


</body>
</html>
