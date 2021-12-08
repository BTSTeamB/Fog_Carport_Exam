<%--
  Created by IntelliJ IDEA.
  User: oliverrasoli
  Date: 07/12/2021
  Time: 16.03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Resources/css/navbar-style.css"/>
    <link rel="stylesheet" href="Resources/css/login-popup-style.css">
    <link rel="stylesheet" href="Resources/css/register-popup-style.css">
    <link rel="stylesheet" href="Resources/css/product-style.css">
    <link rel="icon" href="Resources/images/fog-logo.png">
    <script defer src="Resources/js/popup.js"></script>
    <script src="https://kit.fontawesome.com/de65582ff0.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script defer src="Resources/js/carousel.js"></script>
    <title>Product</title>
</head>
<body>
<nav>
    <div class="nav-logo">
        <img class="nav-logo-item logoPicture" src="Resources/images/fog-logo.png" alt="Fog logo"/>
        <h4 class="nav-logo-item logoHeader">TRÆLAST & BYGGECENTER</h4>
    </div>
    <ul class="nav-links">
        <li><a class="home" href="index.jsp">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="CustomerOrderListController">Orders</a></li>
    </ul>
    <div class="dropdown">
        <a class="sign-in" onclick="openLoginForm()">SIGN-IN</a>
        <button class="dropbtn" style='display: none;'>&#xf007; Username
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content" style="display: none;">
            <a href="account.jsp">Account</a>
            <a href="LogoutController">Sign-out</a>
        </div>
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
                <input type="email" name="LoginUsername" id="LoginUsername"
                       placeholder="&#xf0e0;  insert email address">
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

            <label for="address">Adress</label>
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

<div class="container">
    <div class="carousel">
        <div class="carousel__item">
            <img src="${sessionScope.viewMoreCarport.imgUrl}" alt="image of carport1">
        </div>
        <div class="carousel__item">
            <img src="${sessionScope.viewMoreCarport.seeMoreUrl1}" alt="image of carport2">
        </div>
        <div class="carousel__item">
            <img src="${sessionScope.viewMoreCarport.seeMoreUrl2}" alt="image of carport2">
        </div>
        <a class="prev" onclick="plusSlides(-1)">&#xf137;</a>
        <a class="next" onclick="plusSlides(1)">&#xf138;</a>
    </div>
    <div class="option-widget">
        <div class="header-container">
            <h1>Carport 1</h1>
        </div>
        <div class="des-container">
            <p>
                Estimated delivery: 11 days
            </p>
        </div>
        <div class="list-container">
            <ul class="item-container">
                <li class="list-item">
                    <div class="item">
                        ${sessionScope.viewMoreCarport.width}
                        <span class="item-value">cm</span>
                    </div>
                    <div class="item-title">
                        <span class="title-value">Width</span>
                    </div>
                </li>
                <li class="list-item">
                    <div class="item">
                        ${sessionScope.viewMoreCarport.length}
                        <span class="item-value">m</span>
                    </div>
                    <div class="item-title">
                        <span class="title-value">Length</span>
                    </div>
                </li>
                <li class="list-item">
                    <div class="item">
                        3
                        <span class="item-value">m</span>
                    </div>
                    <div class="item-title">
                        <span class="title-value">Height</span>
                    </div>
                </li>
            </ul>
        </div>
        <div class="user-choice">
            <form action="OrderController" method="post">
                <fieldset class="form-field" id="cladding">
                    <div class="cladding">
                        <h2>Cladding</h2>
                        <div class="cladding-item">
                            <div class="donate-now">
                                <ul style="list-style-type: none;">
                                    <c:forEach var="cladding" items="${requestScope.claddingList}">
                                    <li>
                                        <input type="radio" name="cladding" value="${cladding.cladding_id}" id="${cladding.type}">
                                        <label class="donate-item label-left" for="${cladding.type}}">${cladding.type}</label>
                                        <label class="donate-item label-right" for="${cladding.type}"></label>
                                    </li>
                                        <br>
                                        <br>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                </fieldset>
                <br>
                <br>
                <fieldset class="form-field" id="roofing">
                    <div class="roofing">
                        <h2>Roofing</h2>
                        <div class="roofing-item">
                            <div class="donate-now">
                                <ul style="list-style-type: none;">
                                    <c:forEach var="roofing" items="${requestScope.roofingList}">
                                        <li>
                                            <input type="radio" name="roofing" value="${roofing.roofing_id}" id="${roofing.type}">
                                            <label class="donate-item label-left" for="${roofing.type}">${roofing.type}</label>
                                            <label class="donate-item label-right" for="${roofing.type}"></label>
                                        </li>
                                        <br>
                                        <br>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                </fieldset>
                <div class="button-container">
                    <button type="submit" class="button-container-item">Continue</button>
                </div>
            </form>
        </div>

        <br>

        <br>
        <div class="des-container2">
            <h2 class="des-header">Description</h2>
            <br>
            <p>
                Krister er en carport til din bil, og den giver dig samtidig et smart, laftekonstrueret redskabsskur på
                8 kvm,
                hvor du kan opbevare sommer-/vinterdæk, biltilbehør, havemøbler og cykler. Bilen bliver beskyttet af
                sadeltaget og
                to vægge, der forhindrer sneen i at fyge, og som derudover kan bruges til at sætte hylder og kroge på,
                så man får ekstra
                opbevaringsmuligheder. Taget på Krister har en høj bæreevne i forhold til sne, til forskel fra den
                lignende model Lennart.
                <br>
                <br>
                Bygningen leveres som et byggesæt. Du får selv lov at samle carporten ved hjælp af vores
                monteringsvejledning og de
                medfølgende skruer og søm. Er du en lille smule handy, eller har gode venner, bliver det et cool
                projekt.
                <br>
                <br>
                Redskabsskuret har et gulv i form af brædder på bjælker. I carportdelen skal du selv vælge, om du vil
                lægge betonplader, asfaltere eller ønsker grus. Du vælger også selv tagbelægning og farve, da der ikke
                medfølger
                tagpap, tagplader, shingel eller tegl, og træet er desuden ubehandlet. Du ved bedst, hvilke farver og
                materialer der
                passer til grunden.
            </p>
        </div>
        <div class="whitespace">

        </div>

    </div>
</div>
</body>
</html>
