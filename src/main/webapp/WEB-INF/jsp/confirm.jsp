<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Xác nhận đặt tour</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/confirm.css">
</head>
<body>

<div class="container">
    <h2>Xác nhận thông tin đặt tour</h2>

    <table border="1" cellpadding="10">
        <tr>
            <td><strong>Họ tên khách hàng:</strong></td>
            <td>${booking.customer.name}</td>
        </tr>
        <tr>
            <td><strong>Email:</strong></td>
            <td>${booking.customer.email}</td>
        </tr>
        <tr>
            <td><strong>Số điện thoại:</strong></td>
            <td>${booking.customer.phone}</td>
        </tr>
        <tr>
            <td><strong>Ngày khởi hành:</strong></td>
            <%--        <td><fmt:formatDate value="${booking.departureDate}" pattern="dd/MM/yyyy" /></td>--%>
            <td>${booking.departureDate}</td>
        </tr>
        <tr>
            <td><strong>Số người lớn:</strong></td>
            <td>${booking.noAdults}</td>
        </tr>
        <tr>
            <td><strong>Số trẻ em:</strong></td>
            <td>${booking.noChildren}</td>
        </tr>
        <tr>
            <td><strong>Tên tour:</strong></td>
            <td>${booking.tour.description}</td>
        </tr>
        <tr>
            <td><strong>Giá tour:</strong></td>
            <td>${booking.tour.price}</td>
        </tr>
    </table>

    <br>
    <form action="confirm" method="post">
        <!-- Hidden fields to preserve data -->
        <input type="hidden" name="tour.id" value="${booking.tour.id}" />
        <input type="hidden" name="customer.email" value="${booking.customer.email}" />
        <input type="hidden" name="customer.phone" value="${booking.customer.phone}" />
        <input type="hidden" name="departureDate" value="${booking.departureDate}" />
        <input type="hidden" name="noAdults" value="${booking.noAdults}" />
        <input type="hidden" name="noChildren" value="${booking.noChildren}" />
        <input type="hidden" name="tour.name" value="${booking.tour.description}" />
        <input type="hidden" name="tour.price" value="${booking.tour.price}" />

        <input type="submit" value="Xác nhận" />
        <a href="javascript:history.back()">Quay lại chỉnh sửa</a>
    </form>
</div>


</body>
</html>
