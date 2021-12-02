<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="Resources/css/navbar-style.css"/>
    <link rel="stylesheet" href="Resources/css/index-style.css"/>
    <link rel="stylesheet" href="Resources/css/card-style.css"/>
    <link rel="stylesheet" href="Resources/css/scrollbar-style.css">
    <link rel="stylesheet" href="Resources/css/login-popup-style.css">
    <link rel="stylesheet" href="Resources/css/register-popup-style.css">
    <link rel="icon" href="Resources/images/fog-logo.png">
    <script src="https://kit.fontawesome.com/de65582ff0.js" crossorigin="anonymous"></script>
    <script defer src="Resources/js/popup.js"></script>
    <script defer src="Resources/js/carousel.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <title>Fog trælast og byggecenter</title>
</head>
<body>
<nav>
    <div class="nav-logo">
        <img class="nav-logo-item logoPicture" src="Resources/images/fog-logo.png" alt=""/>
        <h4 class="nav-logo-item logoHeader">TRÆLAST & BYGGECENTER</h4>
    </div>
    <ul class="nav-links">
        <li><a class="home" href="index.jsp">Home</a></li>
        <li><a href="">About</a></li>
        <li><a href="#">Design</a></li>
    </ul>
    <div class="dropdown">
        <a class="sign-in" onclick="openLoginForm()" ${sessionScope.changeSignInButton}>SIGN-IN</a>
        <!--Skal være BLOCK hvis bruger er ikke logget på. Skal være NONE hvis de er logget på -->
        <button class="dropbtn" style='display: none; ${sessionScope.changeDropDownButton}'>&#xf007; ${sessionScope.user.getName()}
            <!--Den her skal være display NONE hvis de ikke er logget på. BLOCK hvis de er logget på. -->
            <i class="fa fa-caret-down"></i>
        </button>
        ${sessionScope.changeDropDownMenu}
    </div>
</nav>

<!-- Login PopUp -->
<div class="login-popup-overlay"></div>
<div id="login-popup">
    <div class="form">
        <div class="login-avatar">
            <img src="Resources/images/fog-logo.png" alt="">
        </div>
        <div class="header">
            Member login
        </div>
        <form action="LoginController" method="post">
            <div class="login-element">
                <label for="LoginUsername">E-mail</label>
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

<!-- Register PopUp -->
<div class="register-popup-overlay"></div>
<div id="register-popup">
    <div class="form">
        <div class="register-avatar">
            <img src="Resources/images/fog-logo.png" alt="">
        </div>
        <div class="header">
            Member register
        </div>
        <form action="RegisterController" method="post">
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
            <div class="login">
                <h2>Already have an account? <a class="login-link" onclick="openLoginForm()"> Login</a></h2>
            </div>
        </form>
    </div>
</div>

<section id="first-section">
    <div class="text-video-overlay">
        <h1>FOG Carporte</h1>
        <h2>Caporte der holder i længden</h2>
    </div>
    <div class="button-container">
        <button class="button-container-item bt1">DESIGN DIN EGEN</button>
        <button onclick="document.getElementById('second-section').scrollIntoView();" class="button-container-item bt2">
            KØB FÆRDIGLAVET
        </button>
    </div>
    <div class="video-container">
        <video class="video" loop autoplay muted preload="auto" src="Resources/videos/v1.mp4"></video>
    </div>
    <div class="arrow bounce">
        <a class="fas fa-chevron-down" href="index.jsp#second-section"></a>
    </div>
</section>

<section id="second-section">
    <div class="background-wrap">
        <div class="header">
            <h1>Prepared carport</h1>
        </div>
        <div class="carousel">
            <div class="carousel__item">

                <div class="cards">
                    <div class="image">
                        <img src="Resources/images/carport1.png" alt="picture of carport">
                    </div>
                    <div class="title">
                        <h1>DKK 16.498,00</h1>
                    </div>
                    <div class="des">
                        <p>CARPORT DOBBELT 6,00X4,80 M CAR01DU UDEN MIDTERSTOLPE FLADT TAG</p>
                        <form action="OrderController" method="get">
                            <button class="button-cards">Purchase</button>
                        </form>
                    </div>
                </div>

                <div class="cards">
                    <div class="image">
                        <img src="Resources/images/carport2.png" alt="picture of carport">
                    </div>
                    <div class="title">
                        <h1>DKK 33.498,00</h1>
                    </div>
                    <div class="des">
                        <p>CARPORT ENKELT 3,60X8,10M CARL01HR MED REDSKABSRUM 3,05X3,20M</p>
                        <button class="button-cards">Purchase</button>
                    </div>
                </div>

                <div class="cards">
                    <div class="image">
                        <img src="Resources/images/carport3.png" alt="picture of carport">
                    </div>
                    <div class="title">
                        <h1>DKK 28.498,00</h1>
                    </div>
                    <div class="des">
                        <p>CARPORT CP01DUR 6,00 x 7,80 mtr. incl. 2,10 x 5,10 mtr. redskabsrum</p>
                        <button class="button-cards">Purchase</button>
                    </div>
                </div>
            </div>

            <div class="carousel__item">
                <div class="cards">
                    <div class="image">
                        <img src="Resources/images/carport4.png" alt="picture of carport">
                    </div>
                    <div class="title">
                        <h1>DKK 6.498,00</h1>
                    </div>
                    <div class="des">
                        <p>CARPORT ENKELT 3,60X8,10M CARL01HR MED REDSKABSRUM 3,05X3,20M</p>
                        <button class="button-cards">Purchase</button>
                    </div>
                </div>

                <div class="cards">
                    <div class="image">
                        <img src="Resources/images/carport5.png" alt="picture of carport">
                    </div>
                    <div class="title">
                        <h1>DKK 46.395,00</h1>
                    </div>
                    <div class="des">
                        <p>Dobbelt carport i galvaniseret stål HORIZONTAL Træfarve</p>
                        <button class="button-cards">Purchase</button>
                    </div>
                </div>

                <div class="cards">
                    <div class="image">
                        <img src="Resources/images/carport6.png" alt="picture of carport">
                    </div>
                    <div class="title">
                        <h1>DKK 55.998,00</h1>
                    </div>
                    <div class="des">
                        <p>Dobbelt carport i galvaniseret stål HORIZONTAL Træfarve</p>
                        <button class="button-cards">Purchase</button>
                    </div>
                </div>
            </div>

            <div class="carousel__item">
                <div class="cards">
                    <div class="image">
                        <img src="Resources/images/carport3.png" alt="picture of carport">
                    </div>
                    <div class="title">
                        <h1>Title Name</h1>
                    </div>
                    <div class="des">
                        <p>CARPORT CP01DUR 6,00 x 7,80 mtr. incl. 2,10 x 5,10 mtr. redskabsrum</p>
                        <button class="button-cards">Purchase</button>
                    </div>
                </div>
            </div>

            <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
            <a class="next" onclick="plusSlides(1)">&#10095;</a>
        </div>

        <div style="text-align:center">
            <span class="dot" onclick="currentSlide(1)"></span>
            <span class="dot" onclick="currentSlide(2)"></span>
            <span class="dot" onclick="currentSlide(3)"></span>
        </div>
    </div>
</section>

<section id="third-section">
    <div class="background-wrap">
        <img class="background" src="Resources/images/thirdSectionBackground.png" alt="background of carport">

        <div class="header">
            <h1>Design your own carport</h1>
        </div>
    </div>
</section>
</body>
</html>