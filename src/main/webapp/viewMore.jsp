<%--
  Created by IntelliJ IDEA.
  User: oliverrasoli
  Date: 04/12/2021
  Time: 20.52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>viewMore</title>
</head>
<body>

<div class="image">
    <img src="${sessionScope.viewMoreCarport.imgUrl}" alt="picture of carport">
</div>
<div class="title">
    <h1>${sessionScope.viewMoreCarport.price}</h1>
</div>
<div class="des">
    <p>Length: ${sessionScope.viewMoreCarport.length}cm - - Width: ${sessionScope.viewMoreCarport.width}cm</p>

    <label for="cladding">Choose cladding:</label>


    <select name="cladding" id="cladding">
    <c:forEach var="cladding" items="${requestScope.claddingList}">
        <option value="${cladding.cladding_id}">${cladding.material.name}</option>
        </c:forEach>
    </select>

    <label for="roofing">Choose Roofing:</label>
    <select name="roofing" id="roofing">
        <c:forEach var="roofing" items="${requestScope.roofingList}">
            <option value="${roofing.roofing_id}">${roofing.material.name}</option>
        </c:forEach>
    </select>

    <form action="OrderController" method="post">
        <button class="button-cards" name="act" value="${sessionScope.viewMoreCarport.id}">Read More</button>
    </form>
</div>


</body>
</html>
