<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Resources/css/navbar-style.css" />
    <link rel="stylesheet" href="Resources/css/scrollbar-style.css">
    <link rel="stylesheet" href="Resources/css/login-popup-style.css">
    <link rel="stylesheet" href="Resources/css/register-popup-style.css">
    <link rel="stylesheet" href="Resources/css/materialList-style.css">
    <link rel="icon" href="Resources/images/fog-logo.png">
    <script src="https://kit.fontawesome.com/de65582ff0.js" crossorigin="anonymous"></script>
    <script defer src="Resources/js/popup.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <title>Material List</title>
</head>
<body>
<nav>
    <div class="nav-logo">
        <img class="nav-logo-item logoPicture" src="Resources/images/fog-logo.png" alt="Fog logo"/>
        <h4 class="nav-logo-item logoHeader">TRÆLAST & BYGGECENTER</h4>
    </div>
    <ul class="nav-links">
        <li><a class="home" href="index.jsp">Home</a></li>
        <li><a href="CustomerOrderListController">Orders</a></li>
    </ul>
    <div class="dropdown">
        <a class="sign-in" onclick="openLoginForm()" ${sessionScope.changeSignInButton}>SIGN-IN</a>
        <!--Skal være BLOCK hvis bruger er ikke logget på. Skal være NONE hvis de er logget på -->
        <button class="dropbtn" style='display: none; ${sessionScope.changeDropDownButton}'>
            &#xf007; ${sessionScope.user.getName()}
            <!--Den her skal være display NONE hvis de ikke er logget på. BLOCK hvis de er logget på. -->
            <i class="fa fa-caret-down"></i>
        </button>
        ${sessionScope.changeDropDownMenu}
    </div>
</nav>

<div class="login-popup-overlay"></div>
<div id="login-popup">
    <div class="form">
        <div class="login-avatar">
            <img src="Resources/images/fog-logo.png" alt="Fog logo">
        </div>
        <div class="header">
            Member login
        </div>
        <form action="LoginController" method="post">
            <div class="login-element">
                <label for="LoginUsername">E-mail</label>
                <label for="LoginUsername" style="display: none;">Wrong email address or password</label>
                <input type="email" name="LoginUsername" id="LoginUsername" placeholder="&#xf0e0;  insert email address">
            </div>
            <div class="login-element">
                <label for="LoginPassword">Password</label>
                <input type="password" name="LoginPassword" id="LoginPassword" placeholder="&#xf577; insert password">
            </div>
            <div class="login-element">
                <button>Login &#xf105;</button>
            </div>
            <div class="register">
                <h2>Need an account? <a class="register-link" onclick="openRegisterForm()"> Register</a></h2>
            </div>
        </form>
    </div>
</div>

<div class="register-popup-overlay"></div>
<div id="register-popup">
    <div class="form">
        <div class="register-avatar">
            <img src="Resources/images/fog-logo.png" alt="Fog logo">
        </div>
        <div class="header">
            Member register
        </div>
        <form action="RegisterController" method="post"></form>
        <div class="register-element">
            <label for="name">Name</label>
            <input type="text" name="name" id="name" placeholder="&#xf007;  insert name">

            <label for="address">Address</label>
            <input type="text" name="address" id="address" placeholder="&#xf015; insert address">

            <label for="zip-code">zip-code</label>
            <input type="number" name="zip-code" id="zip-code" placeholder="&#xf276; insert zip-code">
        </div>

        <div class="register-element">
            <label for="RegEmail">E-mail</label>
            <input type="email" name="RegEmail" id="RegEmail" placeholder="&#xf0e0;  insert email address">

            <label for="RegPassword">Password</label>
            <input type="password" name="RegPassword" id="RegPassword" placeholder="&#xf577; insert password">

            <label for="phone">Phone</label>
            <input type="number" name="phone" id="phone" placeholder="&#xf10b; insert phone number">
        </div>


        <div class="register-element">
            <button>Register &#xf105;</button>
        </div>
        </form>
        <div class="login">
            <h2>Already have an account? <a class="login-link" onclick="openLoginForm()"> Login</a></h2>
        </div>
    </div>
</div>

<h1 class="material-list-header">All Customers in Fog's Database</h1>
<div class="material-list-container">
    <table>
        <tr>
            <th>User ID</th>
            <th>Is Admin</th>
            <th>Is Guest</th>
            <th>Name</th>
            <th>Address</th>
            <th>Zip Code</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Password</th>
        </tr>
        <c:forEach var="customer" items="${requestScope.allUsers}">
            <tr>
                <td>${customer.user_id}</td>
                <td>${customer.is_admin}</td>
                <td>${customer.is_guest}</td>
                <td>${customer.name}</td>
                <td>${customer.address}</td>
                <td>${customer.zipCode}</td>
                <td>${customer.phoneNumber}</td>
                <td>${customer.email}</td>
                <td>${customer.password}</td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>