<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui" />
    <meta name="format-detection" content="telephone=no" />
    <meta name="format-detection" content="address=no" />

    <meta name="description" content="" />
    <meta name="keywords" content="" />

    <title>소팩소개 :: Software Factory</title>

    <%@ include file="styles.jsp" %>

</head>
<body>

<!-- Header -->
<header class="container header">
    <div class="row">
        <div class="col-lg-6 col-md-6 col-sm-6 logo">
            <a href="<c:url value="/"/>">소프트웨어<span>팩토리</span></a>
            <div class="small-logo">SoFAC : <i>Software Factory</i></div>
        </div>
    </div>
</header>
<!-- #End Header -->

<!-- 404 -->
<section class="container text-center error-page mb40">
    <span class="error-404">404</span>
    <h3>Oops! Page not found...</h3>
    <p>Looks like the page you're looking for was moved or never existed.<br/>Make sure you typed the correct URL or
        followed a valid link.</p>
    <a href="<c:url value="/"/>" class="btn btn-primary mt30 mb30">Home page</a>
</section>
<!-- #End 404 -->

<%@ include file="javascript.jsp" %>

</body>
</html>