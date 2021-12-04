<%--
  Created by IntelliJ IDEA.
  User: oliverrasoli
  Date: 04/12/2021
  Time: 22.56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>View More</title>
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

    <form action="OrderController" method="post">
        <label for="cladding">Choose cladding:</label>
        <select name="cladding" id="cladding">
            <option value="0">Træ</option>
            <option value="1">Sten</option>
            <option value="2">Glas</option>
        </select>

        <label for="roofing">Choose Roofing:</label>
        <select name="roofing" id="roofing">
            <option value="0">Træ</option>
            <option value="1">Sten</option>
            <option value="2">Klink</option>
        </select>

        <button class="button-cards" type="submit" name="act" value="${sessionScope.viewMoreCarport.id}">Read More
        </button>
    </form>
</div>

</body>
</html>
