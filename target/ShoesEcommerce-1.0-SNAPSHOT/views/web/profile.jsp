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
    String name = account.getName();
    String email = account.getEmail();
    String phone = account.getPhone();
    String gender = account.getGender();
    String address = account.getAddress();
    Date dateofbirth = account.getDateofbirth();
    int account_id = account.getAccount_id();

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
<div class="container" style="padding: 0">

    <div class="row">
        <div class="col-xl-3 col-lg-4 col-md-5">
            <div class="sidebar-categories">
                <div class="head">Hồ sơ</div>

                <ul class="main-categories">

                    <li class="main-nav-list">
                        <a href="web-profile">Thông tin tài khoản</a>
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
            <h1 style="text-align: center">Hồ sơ </h1>

            <!-- Start Best Seller -->
            <section class="lattest-product-area pb-40 category-list">

                    <!-- single product -->
                    <form action="update-profile" method="post">

                        <input type="hidden" name="account_id" class="form-control" value="<%=account_id%>" >
                        <div class="mb-3">
                        <label class="mb-2">Email</label>
                        <input type="email" name="email" class="form-control" value="<%=email%>" readonly>
                        </div>
                        <div class="mb-3">
                        <label class="mb-2">Tên</label>
                        <input type="name" name="name" class="form-control" value="<%=name%>" >

                        </div>
                        <div class="mb-3">
                        <label class="mb-2">Giới tính</label>
                        <input type="text" name="gender" class="form-control" value="<%=gender%>" >
                        </div>
                        
                        <div class="mb-3">
                        <label class="mb-2">SĐT</label>
                        <input type="text" name="phone" class="form-control" value="<%=phone%>" >
                        </div>
                        <div class="mb-3">
                        <label class="mb-2">Địa chỉ</label>
                        <input type="text" name="address" class="form-control" value="<%=address%>" >
                        </div>
                        <div class="mb-3">
                        <label class="mb-2">Ngày tháng năm sinh</label>
                        <input type="date" name="dateofbirth" class="form-control" value="<%=dateofbirth%>" >
                        </div>

                        <div class="mb-3">
                            <button type="submit" class="btn btn-outline-primary">Lưu</button>
                        </div>


                    </form>







            </section>
            <!-- End Best Seller -->

        </div>
    </div>
</div>


</body>
</html>


</body>
</html>
