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
          <li><a href="">About</a></li>
          <li><a href="#">Orders</a></li>
        </ul>
        <div class="dropdown">
          <a class="sign-in" onclick="openLoginForm()">SIGN-IN</a>
          <button class="dropbtn">&#xf007; Username
            <i class="fa fa-caret-down"></i>
          </button>
          <div class="dropdown-content">
            <a href="account.jsp">Account</a>
            <a href="UserController">Sign-out</a>
          </div>
        </div>
      </nav>

      <div class="container">
        <div class="sidenav">
          <div class="sidenav-container">
          <img class="logo-image" src="Resources/images/fog-logo.png" alt="picture of fog logo">
          <h1>Account details</h1>

      <form action="RegisterController" method="post"></form>
        <div class="edit-element">
          <label for="editName">Name</label>
          <input type="text" name="editName" id="editName" placeholder="skal have brugerens navn">

          <label for="editAddress">Adress</label>
          <input type="text" name="editAddress" id="editAddress" placeholder="skal have brugerens adresse">

          <label for="editZip-code">zip-code</label>
          <input type="number" name="editZip-code" id="editZip-code" placeholder="skal have brugerens zip-code">
        </div>

        <div class="edit-element up">
          <label for="editEmail">E-mail</label>
          <input type="email" name="editEmail" id="editEmail" placeholder="skal have brugers email">

          <label for="editPassword">Password</label>
          <input type="password" name="editPassword" id="editPassword" placeholder="********">

          <label for="editPhone">Phone</label>
          <input type="number" name="editPhone" id="editPhone" placeholder="skal have brugerens nummer">
        </div>

        <div class="edit-element">
          <button class="discard">Discard changes</button>
          <button class="save">Save changes</button>
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