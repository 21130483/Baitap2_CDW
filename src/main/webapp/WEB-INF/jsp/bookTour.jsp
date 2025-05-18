<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đặt tour</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bookTour.css" />
</head>
<body>
<div class="container">
    <h3>Đặt tour : <span class="tour-name">${tour.description}</span> ${tour.days}</h3>

    <form:form method="post" modelAttribute="bookingForm" action="/book">
        <form:hidden path="tour.id"/>
        <fieldset>
            <legend>Thông tin khách hàng</legend>
            <div class="form-group">
                <label>Họ tên: (*)</label>
                <form:input path="customer.name"/>
            </div>
            <div class="form-group">
                <label>Địa chỉ:</label>
                <form:input path="customer.address"/>
            </div>
            <div class="form-group">
                <label>E-mail: (*)</label>
                <form:input path="customer.email" type="email"/>
            </div>
            <div class="form-group">
                <label>Điện thoại:</label>
                <form:input path="customer.phone"/>
            </div>
        </fieldset>

        <fieldset>
            <legend>Thông tin chuyến đi:</legend>
            <div class="form-group">
                <label>Ngày khởi hành: (*)</label>
                <form:input path="departureDate" type="date"/>
            </div>
            <div class="form-group">
                <label>Số người lớn: (*)</label>
                <form:input  path="noAdults" type="number" min="0"/>
            </div>
            <div class="form-group">
                <label>Số trẻ em:</label>
                <form:input path="noChildren" type="number" min="0"/>
            </div>
        </fieldset>

        <div class="buttons">
            <input type="submit" value="Gửi"/>
            <input type="button" value="Hủy" onclick="window.location.href='/';" />

        </div>
    </form:form>
</div>
</body>
</html>
