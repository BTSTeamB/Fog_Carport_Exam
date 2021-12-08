<%--
  Created by IntelliJ IDEA.
  User: oliverrasoli
  Date: 08/12/2021
  Time: 19.35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Cladding Materials</h3>
<table>
    <tr>
        <th>Material Name</th>
        <th>Length(cm)</th>
        <th>Amount</th>
        <th>Unit</th>
        <th>Description/Instruction</th>
    </tr>
    <c:forEach var="claddingMaterial" items="${requestScope.ordersCladding}">
        <tr>
            <td>${claddingMaterial.name}</td>
            <td>${claddingMaterial.length}</td>
            <td>X - To be Replaced - X</td>
            <td>${claddingMaterial.unit}</td>
            <td>${claddingMaterial.description}</td>
        </tr>
    </c:forEach>
</table>
<h3>Roofing Materials</h3>
<table>
    <tr>
        <th>Material Name</th>
        <th>Length(cm)</th>
        <th>Amount</th>
        <th>Unit</th>
        <th>Description/Instruction</th>
    </tr>
    <c:forEach var="roofingMaterial" items="${requestScope.ordersRoofing}">
        <tr>
            <td>${roofingMaterial.name}</td>
            <td>${roofingMaterial.length}</td>
            <td>X - To be Replaced - X</td>
            <td>${roofingMaterial.unit}</td>
            <td>${roofingMaterial.description}</td>
        </tr>
    </c:forEach>
</table>




</body>
</html>
