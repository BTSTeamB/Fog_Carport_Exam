<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Resources/css/navbar-style.css"/>
    <link rel="icon" href="Resources/images/fog-logo.png">
    <link rel="stylesheet" href="Resources/css/login-popup-style.css">
    <link rel="stylesheet" href="Resources/css/register-popup-style.css">
    <link rel="stylesheet" href="Resources/css/design-style.css">
    <script defer src="Resources/js/popup.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://kit.fontawesome.com/de65582ff0.js" crossorigin="anonymous"></script>
    <title>Carport with erection</title>
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

<div class="con">
    <div class="pre-text">
        <div class="pre-text-header">
            <h2>QUICK-BUILD OFFER - CARPORT WITH FLAT ROOF</h2>
        </div>
        <div class="pre-text-des">
            <span>
              With a specially developed computer program, we can quickly calculate the price and print a sketch on a carport within our standard program.
            </span>
        </div>
        <div class="video-container">
            <video class="video" loop autoplay muted preload="auto" src="Resources/videos/desginVideo.mp4"></video>
        </div>
    </div>
    <div class="input-text">
        <div class="input-text-header">
            <h2> Fill in the form below carefully and click on "Calculate"</h2>
        </div>
        <div class="input-text-des">
            <span>
              Fields marked * MUST BE FILLED!
            </span>
        </div>
    </div>

    <div class="input-con">
        <form action="DesignController" method="post">
            <div class="section-select">
                <label for="carport_width">Caport width</label>
                <select name="width" id="carport_width">
                    <optgroup label="Width">
                        <option value="" disabled selected hidden>Width*</option>
                        <option value="240">240cm</option>
                        <option value="270">270cm</option>
                        <option value="300">300cm</option>
                        <option value="330">330cm</option>
                        <option value="360">360cm</option>
                        <option value="390">390cm</option>
                        <option value="420">420cm</option>
                        <option value="450">450cm</option>
                        <option value="480">480cm</option>
                        <option value="510">510cm</option>
                        <option value="540">540cm</option>
                        <option value="570">570cm</option>
                        <option value="600">600cm</option>
                    </optgroup>
                </select>
                <label for="carport_roof">Carport roof</label>
                <select name="roof" id="carport_roof">
                    <optgroup label="Roof">
                        <option value="" disabled selected hidden>Roof*</option>
                        <option value="3">Gable-roof, Concrete tiles</option>
                        <option value="4">Gable-roof, Tile roof shingles</option>
                    </optgroup>
                </select>
                <label for="tool-room-width">Tool room width</label>
                <select name="tool-room-width" id="tool-room-width">
                    <optgroup label="tool-room-width">
                        <option value="0">Do not want tool room</option>
                        <option value="210">210cm</option>
                        <option value="240">240cm</option>
                        <option value="270">270cm</option>
                        <option value="300">300cm</option>
                        <option value="330">330cm</option>
                        <option value="360">360cm</option>
                        <option value="390">390cm</option>
                        <option value="420">420cm</option>
                        <option value="450">450cm</option>
                        <option value="480">480cm</option>
                        <option value="510">510cm</option>
                        <option value="540">540cm</option>
                        <option value="570">570cm</option>
                        <option value="600">600cm</option>
                    </optgroup>
                </select>
            </div>

            <div class="section-select">
                <label for="carport_length">Carport length</label>
                <select name="length" id="carport_length">
                    <optgroup label="Length">
                        <option value="" disabled selected hidden>Length*</option>
                        <option value="240">240cm</option>
                        <option value="270">270cm</option>
                        <option value="300">300cm</option>
                        <option value="330">330cm</option>
                        <option value="360">360cm</option>
                        <option value="390">390cm</option>
                        <option value="420">420cm</option>
                        <option value="450">450cm</option>
                        <option value="480">480cm</option>
                        <option value="510">510cm</option>
                        <option value="540">540cm</option>
                        <option value="570">570cm</option>
                        <option value="600">600cm</option>
                        <option value="630">630cm</option>
                        <option value="660">660cm</option>
                        <option value="690">690cm</option>
                        <option value="720">720cm</option>
                        <option value="750">750cm</option>
                        <option value="780">780cm</option>
                    </optgroup>
                </select>
                <label for="carport_cladding">Carport cladding</label>
                <select name="cladding" id="carport_cladding">
                    <optgroup label="Cladding">
                        <option value="" disabled selected hidden>Cladding*</option>
                        <option value="1">Wooden Cladding</option>
                        <option value="2">Stone Cladding</option>
                    </optgroup>
                </select>
                <label for="tool-room-length">Tool room length</label>
                <select name="tool-room-length" id="tool-room-length">
                    <optgroup label="tool-room-length">
                        <option value="0">Do not want tool room</option>
                        <option value="210">150cm</option>
                        <option value="240">180cm</option>
                        <option value="270">210cm</option>
                        <option value="240">240cm</option>
                        <option value="270">270cm</option>
                    </optgroup>
                </select>
            </div>
            <br>
            <button type="submit">Calculate</button>
        </form>
    </div>
    <br>
</div>
</div>
</body>
</html>