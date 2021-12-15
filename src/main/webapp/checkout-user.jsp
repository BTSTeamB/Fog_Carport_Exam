<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="Resources/images/fog-logo.png">
    <link rel="stylesheet" href="Resources/css/scrollbar-style.css">
    <link rel="stylesheet" href="Resources/css/checkout-user-style.css">
    <link rel="stylesheet" href="Resources/css/login-popup-style.css">
    <link rel="stylesheet" href="Resources/css/register-popup-style.css">
    <link rel="stylesheet" href="Resources/css/navbar-style.css">
    <script defer src="Resources/js/popup.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://kit.fontawesome.com/de65582ff0.js" crossorigin="anonymous"></script>
    <title>Checkout</title>
</head>
<body>
    <nav>
        <div class="nav-logo">
          <img class="nav-logo-item logoPicture" src="Resources/images/fog-logo.png" alt="Fog logo"/>
          <h4 class="nav-logo-item logoHeader">TRÆLAST & BYGGECENTER</h4>
        </div>
        <ul class="nav-links">
          <li><a class="home" href="index.jsp">Home</a></li>
          <li><a href="">About</a></li>
          <li><a href="designFlat.jsp">Orders</a></li>
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
        </form>
        <div class="login">
          <h2>Already have an account? <a class="login-link" onclick="openLoginForm()"> Login</a></h2>
        </div>
      </div>
    </div>

    <div class="checkout-container">
        <div class="checkout-left">
            <div class="checkout-header">
                <h2>CHECKOUT</h2> 
                <div class="checkout-sign-in-container">
                    <div class="checkout-sign-in">
                        
                    </div>
                </div>
                <br>
            <br>
            <h2>ACCOUNT INFORMATION</h2>
            <br>
            <hr class="guest-line">
            <div class="guest-information">
              <form action="orderComplete.jsp">
                <label for="name">Name</label>
                <input type="text" name="name" id="account-name" placeholder="Brugers navn skal stå her">
                <i class="fas fa-pen-square"></i>
               

                <label for="account-address">Adress</label>
                <input type="text" name="adress" id="account-address" placeholder="Brugers adresse skal stå her">
                <i class="fas fa-pen-square"></i>
              
                <label for="account-zip">Zip-code</label>
                <input type="number" name="zip" id="account-zip" placeholder="Brugers zip-code skal stå her">
                <i class="fas fa-pen-square"></i>
                
                <label for="account-email">E-mail</label>
                <input type="email" name="email" id="account-email" placeholder="brugers email skal stå her">
                <i class="fas fa-pen-square"></i>
            
                <label for="account-phone">Phone</label>
                <input type="number" name="phone" id="account-phone" placeholder="brugers telefon nummer skal stå her">
                <i class="fas fa-pen-square"></i>

                <button class="checkout-button" type="submit">Place Order</button>
              </form>
              <p class="tip-text">OBS. if you type your guest credentials you will stil be able to view your order</p>
          </div>
            </div>
        </div>
        <div class="checkout-right">
           <div class="order-summary">
               <div class="order-header">
                    <h3>ORDER SUMMARY</h3>
                </div>
               <div class="item-subtotal">
                   <div class="item-subtotal-container">
                        <p class="p-space"><span class="span-left">Item Subtotal</span> <span class="span-right">DKK 10000,000</span></p>
                        <p class="p-space"><span class="span-left">Shipping*</span> <span class="span-right">Free</span></p> 
                        <p><span class="span-left">standard</span></p>
                    </div>
               </div>
               <div class="order-total">
                <p><span class="span-left">ORDER TOTAL</span> <span class="span-right">DKK 10000,000</span></p>
               </div>
               <hr class="horizontal-line">
           </div>
           <br>
           <div class="cart-summary">
              <div class="order-header">
                <div class="order-left">
                  <h3>CART SUMMARY</h3>
                  <img class="small-image" src="Resources/images/carport1.0.jpg" alt="">
                </div>    
                <div class="order-right">
                  <p class="item-name">carport 1</p>
                  <p class="small-p">width / height</p>
                  <p class="small-p">cladding / roofing</p>
                  <p class="small-p">DKK 10000,000</p>
                </div>
              </div>
           </div>
        </div>
    </div>
</body>
</html>