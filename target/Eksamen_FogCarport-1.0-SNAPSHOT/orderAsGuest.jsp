<%--
  Created by IntelliJ IDEA.
  User: oliverrasoli
  Date: 05/12/2021
  Time: 00.11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<label> Order as Guest</label>
<form action="GuestController" method="post">
    <input type="text" name="guestName" id="guestName">
    <br>
    <input type="text" name="guestAddress" id="guestAddress">
    <br>
    <input type="text" name="guestZipCode" id="guestZipCode">
    <br>
    <input type="text" name="guestEmail" id="guestEmail">
    <br>
    <input type="text" name="guestPhoneNum" id="guestPhoneNum">
    <br>
    <button type="subtmit">Submit guest data</button>
</form>

</body>
</html>
