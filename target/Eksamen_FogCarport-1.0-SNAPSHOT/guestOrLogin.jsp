<%--
  Created by IntelliJ IDEA.
  User: oliverrasoli
  Date: 08/12/2021
  Time: 18.26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Please enter your information to view your orders</h3>
<form action="CustomerOrderListController" method="post">
    <label>Name</label>
    <br>
    <input type="text" name="guestOrderName" id="guestOrderName">
    <br>
    <label>Address</label>
    <br>
    <input type="text" name="guestOrderAddress" id="guestOrderAddress">
    <br>
    <label>Zip-Code</label>
    <br>
    <input type="text" name="guestOrderZipCode" id="guestOrderZipCode">
    <br>
    <label>Phone Number</label>
    <br>
    <input type="text" name="guestOrderPhoneNum" id="guestOrderPhoneNum">
    <br>
    <label>Email</label>
    <br>
    <input type="text" name="guestOrderEmail" id="guestOrderEmail">
    <br>
    <button type="submit">Submit guest data</button>
</form>

<form>
    <h3>Or if you already have an account, sign in here</h3>
</form>
</body>
</html>