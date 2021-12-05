<%--
  Created by IntelliJ IDEA.
  User: oliverrasoli
  Date: 02/12/2021
  Time: 20.48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Title</title>
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

    <label>Cladding of your choice:</label>
    <div>
        <p>${sessionScope.chosenCladding.material.name}</p>
    </div>

    <br>

    <label>Roofing of your choice:</label>
    <div>
        <p>${sessionScope.chosenRoofing.material.name}</p>
    </div>

    <form action="CheckOutController" method="get">
        <button class="button-cards" name="act">Bestil</button>
    </form>
</div>


</body>
</html>
