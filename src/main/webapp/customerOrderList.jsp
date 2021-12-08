<%--
  Created by IntelliJ IDEA.
  User: oliverrasoli
  Date: 08/12/2021
  Time: 18.02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Your orders</title>
    <link rel="stylesheet" href="Resources/css/DEMO_customerOrderList.css"/>
</head>
<body>
<h1>Welcome back ${sessionScope.user.name}</h1>
<p>This is your overview of your orders</p>

<table>
    <tr>
        <th>Order Number</th>
        <th>Price</th>
        <th>Carport Length</th>
        <th>Carport Width</th>
        <th>Cladding Type</th>
        <th>Roofing Type</th>
    </tr>
    <c:forEach var="userOrder" items="${requestScope.usersOrders}">
        <tr>
            <td>
            <form action="MaterialListController" method="get">
                <input type="submit" value="${userOrder.order_id}" name="selectedOrder">
            </form>
            </td>
            <td>${userOrder.price}</td>
            <td>${userOrder.carport_length}</td>
            <td>${userOrder.carport_width}</td>
            <td>${userOrder.claddingType}</td>
            <td>${userOrder.roofingType}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
