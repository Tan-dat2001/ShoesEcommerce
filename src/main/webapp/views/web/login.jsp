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
                    <a href="login">Đăng nhập</a>
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
                        <h4>Bạn chưa có tài khoản?</h4>

                        <a class="primary-btn" href="register">Tạo tài khoản</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="login_form_inner">
                    <h3>Đăng nhập</h3>
                    <form class="row login_form" action="login" method="post" id="contactForm" novalidate="novalidate">
                        <div class="col-md-12 form-group">
                            <input type="text" class="form-control" id="email" name="email" placeholder="Email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Email'">
                        </div>
                        <div class="col-md-12 form-group">
                            <input type="password" class="form-control" id="password" name="password" placeholder="Mật khẩu" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Mật khẩu'">
                        </div>
                        <div class="col-md-12 form-group">
                            <div class="creat_account">
                                <input type="checkbox" id="f-option2" name="selector">
                                <label for="f-option2">Duy trì đăng nhập</label>
                            </div>
                        </div>
                        <div class="col-md-12 form-group">
                            <p class="error-message">${errorMessage}</p>
                            <button type="submit" value="submit" class="primary-btn">Đăng nhập</button>
                            <a href="#">Quên mật khẩu?</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>



<%--<script src="js/vendor/jquery-2.2.4.min.js"></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--<script src="js/vendor/bootstrap.min.js"></script>--%>
<%--<script src="js/jquery.ajaxchimp.min.js"></script>--%>
<%--<script src="js/jquery.nice-select.min.js"></script>--%>
<%--<script src="js/jquery.sticky.js"></script>--%>
<%--<script src="js/nouislider.min.js"></script>--%>
<%--<script src="js/jquery.magnific-popup.min.js"></script>--%>
<%--<script src="js/owl.carousel.min.js"></script>--%>
<%--<!--gmaps Js-->--%>
<%--<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>--%>
<%--<script src="js/gmaps.min.js"></script>--%>
<%--<script src="js/main.js"></script>--%>
</body>
</html>
