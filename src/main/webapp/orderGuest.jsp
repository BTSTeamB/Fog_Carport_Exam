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
    <link rel="stylesheet" href="Resources/css/order-guest-style.css">
    <link rel="icon" href="Resources/images/fog-logo.png">
    <script src="https://kit.fontawesome.com/de65582ff0.js" crossorigin="anonymous"></script>
    <script defer src="Resources/js/popup.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <title>Order</title>
</head>
<body>
    <nav>
        <div class="nav-logo">
          <img class="nav-logo-item logoPicture" src="Resources/images/fog-logo.png" alt="Fog logo"/>
          <h4 class="nav-logo-item logoHeader">TRÆLAST & BYGGECENTER</h4>
        </div>
        <ul class="nav-links">
          <li><a class="home" href="index">Home</a></li>
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
          <div class="login">
            <h2>Already have an account? <a class="login-link" onclick="openLoginForm()"> Login</a></h2>
          </div>
        </div>
      </div>

      <div class="order-container">
        <div class="order-container-guest">
          <h1>View order</h1>
          <form action="CustomerOrderListController" method="post">
            <label for="guestOrderName">Name</label>
            <input type="text" name="guestOrderName" id="guestOrderName">
            
            <label for="guestOrderAddress">Address</label>
            <input type="text" name="guestOrderAddress" id="guestOrderAddress">
          
            <label for="guestOrderZipCode">zip-code</label>
            <input type="number" name="guestOrderZipCode" id="guestOrderZipCode">
            
            <label for="guestOrderEmail">E-mail</label>
            <input type="email" name="guestOrderEmail" id="guestOrderEmail">
        
            <label for="guestOrderPhoneNum">Phone</label>
            <input type="number" name="guestOrderPhoneNum" id="guestOrderPhoneNum">

            <p>have an account?<a onclick="openLoginForm()"> sign in</a></p>

            <button class="checkout-button" type="submit">View Order</button>
          </form>
        </div>
      </div>
</body>
</html>