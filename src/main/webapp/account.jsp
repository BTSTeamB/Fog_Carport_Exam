<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Resources/css/navbar-style.css">
    <link rel="stylesheet" href="Resources/css/account-style.css">
    <link rel="icon" href="Resources/images/fog-logo.png">
    <script src="https://kit.fontawesome.com/de65582ff0.js" crossorigin="anonymous"></script>
    <title>Account</title>
</head>
<body>
<nav>
    <div class="nav-logo">
        <img class="nav-logo-item logoPicture" src="Resources/images/fog-logo.png" alt=""/>
        <h4 class="nav-logo-item logoHeader">TRÆLAST & BYGGECENTER</h4>
    </div>
    <ul class="nav-links">
        <li><a href="index.jsp">Home</a></li>
        <li><a href="#">Design</a></li>
        <li><a href="OrderController">Orders</a></li>
    </ul>
    <div class="dropdown">
        <a class="sign-in" onclick="openLoginForm()" style="display: none;">SIGN-IN</a>
        <!--Skal være BLOCK hvis bruger er ikke logget på. Skal være NONE hvis de er logget på -->
        <button class="dropbtn" style='display: block;'>&#xf007; ${sessionScope.user.getName()}
            <!--Den her skal være display NONE hvis de ikke er logget på. BLOCK hvis de er logget på. -->
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
            <!--Den her skal have display NONE hvis de er ikke logget på. HELE Stylingen skal slettes hvis de er logget på -->
            <a href="account.jsp">Account</a>
            <a href="LogoutController">Sign-out</a>\
        </div>
    </div>
</nav>

<div class="container">
    <div class="sidenav">
        <div class="sidenav-container">
            <img class="logo-image" src="Resources/images/fog-logo.png" alt="picture of fog logo">
            <h1>Account details</h1>

            <form action="UserController" method="post">
            <div class="edit-element">
                <label for="editName">Name</label>
                <input type="text" name="editName" id="editName" placeholder="${sessionScope.user.getName()}">

                <label for="editAddress">Address</label>
                <input type="text" name="editAddress" id="editAddress" placeholder="${sessionScope.user.getAddress()}">

                <label for="editZip-Code">zip-code</label>
                <input type="text" name="editZip-Code" id="editZip-Code"
                       placeholder="${sessionScope.user.getZipCode()}">
            </div>

            <div class="edit-element up">
                <label for="editEmail">E-mail</label>
                <input type="email" name="editEmail" id="editEmail" placeholder="${sessionScope.user.getEmail()}">

                <label for="editPassword">Password</label>
                <input type="password" name="editPassword" id="editPassword" placeholder="********">

                <label for="editPhone">Phone</label>
                <input type="text" name="editPhone" id="editPhone" placeholder="${sessionScope.user.getPhoneNumber()}">
            </div>

            <div class="edit-element">
                <form action="UserController" method="get" style="display: inline;">
                    <button class="discard" type="reset">Discard changes</button>
                </form>
                <button class="save" type="submit">Save changes</button>
            </div>
            </form>
        </div>
    </div>
    <div class="bgrnd">
        <div class="color-overlay"></div>
        <img class="background-image" src="Resources/images/accountBackground.jpeg" alt="picture of a car inside car">
    </div>
</div>
</body>
</html>