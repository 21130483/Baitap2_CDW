<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Welcome</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/listTours.css">
    <script src="<%=request.getContextPath()%>/js/listTours.js"></script>


</head>
<body>
<h2>Các Chương trình DU LỊCH</h2>
<table>
    <thead>
    <tr>
        <th>Chương trình</th>
        <th>Lịch Khởi hành</th>
        <th>Giá</th>
        <th>Đặt</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="tour" items="${tours}">
        <tr>
            <td>
                <a href="/tours/${tour.id}">${tour.description}</a><br/>
                    ${tour.days}
            </td>
            <td>${tour.departureSchedule}</td>
            <td class="price">
                <fmt:formatNumber value="${tour.price}" type="number" pattern="#,##0"/> đ
            </td>
            <td><button class="order-button"  onclick="goToBook(${tour.id})">Đặt tour</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
