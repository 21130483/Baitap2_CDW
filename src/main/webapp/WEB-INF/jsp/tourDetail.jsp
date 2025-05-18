<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi tiết tour</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tourDetail.css" />
    <script src="${pageContext.request.contextPath}/js/listTours.js"></script>
</head>
<body>
<div class="container">
    <h2>Chương trình chi tiết:</h2>

    <div class="tour-content">
        ${tour.details}
    </div>

    <div class="actions">
        <button class="btn-order" onclick="goToBook(${tour.id})">Đặt tour</button>
        <a href="/" class="back-link">CHƯƠNG TRÌNH TOUR</a>
    </div>
</div>
</body>
</html>
