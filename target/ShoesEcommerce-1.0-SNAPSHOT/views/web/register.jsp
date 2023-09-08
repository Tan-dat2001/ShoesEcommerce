<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
<section class="banner-area organic-breadcrumb">
    <div class="container">
        <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
            <div class="col-first">
                <h1>Đăng nhập/Đăng ký</h1>
                <nav class="d-flex align-items-center">
                    <a href="web-home">Trang chủ<span class="lnr lnr-arrow-right"></span></a>
                    <a href="login">Đăng ký</a>
                </nav>
            </div>
        </div>
    </div>
</section>
<!-- End Banner Area -->

<!--================Login Box Area =================-->
<section class="login_box_area section_gap">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <div class="login_box_img">
                    <img class="img-fluid" src="<c:url value="/template/web/img/login.jpg" />" alt="">
                    <div class="hover">
                        <h4>Đã có tài khoản</h4>

                        <a class="primary-btn" href="login">Đăng nhập</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="login_form_inner">
                    <h3>Đăng ký</h3>
                    <form class="row login_form" action="register" method="post" id="contactForm" >
                        <div class="col-md-12 form-group">
                            <input type="text" class="form-control" id="email" name="email" placeholder="Email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Email'" required >

                        </div>
                        <div class="col-md-12 form-group">
                            <input type="password" class="form-control" id="password" name="password" placeholder="Mật khẩu" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Mật khẩu'" required >
                        </div>

                        <div class="col-md-12 form-group">
                            <input type="text" class="form-control" id="name" name="name" placeholder="Họ Tên" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Họ Tên'" required >
                        </div>
                        <div class="col-md-12 form-group">
                            <input type="text" class="form-control" id="gender" name="gender" placeholder="Giới tính" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Giới tính'">
                        </div>
                        <div class="col-md-12 form-group">
                            <input type="text" class="form-control" id="address" name="address" placeholder="Địa chỉ" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Địa chỉ'" required >
                        </div>

                        <div class="col-md-12 form-group">
                            <input type="text" class="form-control" id="phone" name="phone" placeholder="SĐT" onfocus="this.placeholder = ''" onblur="this.placeholder = 'SĐT'" required >
                        </div>
                        <div class="col-md-12 form-group">
                            <input type="Date" class="form-control" id="date" name="date" placeholder="Sinh nhật" required >
                        </div>
                        <div class="col-md-12 form-group">
                            <p class="error-message">${errorMessage}</p>
                            <button type="submit" value="submit" class="primary-btn">Đăng ký</button>

                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>




</body>
</html>