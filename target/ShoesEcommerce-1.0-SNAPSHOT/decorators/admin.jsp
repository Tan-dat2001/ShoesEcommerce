<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 7/11/2023
  Time: 5:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html
        lang="en"
        class="light-style layout-menu-fixed"
        dir="ltr"
        data-theme="theme-default"
        data-assets-path="../assets/"
        data-template="vertical-menu-template-free"
>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta name="description" content="Portal - Bootstrap 5 Admin Dashboard Template For Developers">
    <meta name="author" content="Xiaoying Riley at 3rd Wave Media">
    <link rel="shortcut icon" href="/template/admin/favicon.ico">

    <!-- FontAwesome JS-->
    <script defer src="/template/admin/assets/plugins/fontawesome/js/all.min.js"></script>

    <!-- App CSS -->
    <link id="theme-style" rel="stylesheet" href="/template/admin/assets/css/portal.css">
</head>
<body class="app">


<%@include file="/common/admin/header.jsp"%>


<div class="app-wrapper">
    <dec:body/>
    <%@include file="/common/admin/footer.jsp"%>
</div>





<script src="/template/admin/assets/plugins/popper.min.js"></script>
<script src="/template/admin/assets/plugins/bootstrap/js/bootstrap.min.js"></script>


<!-- Page Specific JS -->
<script src="/template/admin/assets/js/app.js"></script>
</body>
</html>
