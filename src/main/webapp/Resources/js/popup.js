//LOGIN MODAL
function openLoginForm() {
    document.body.classList.add("showLoginForm");
    document.body.classList.remove("showRegisterForm");
}
function closeLoginForm() {
    document.body.classList.remove("showLoginForm");
}

$(document).click(function (event) {
    //if you click on anything except the modal itself or the "open modal" link, close the modal
    if (!$(event.target).closest("#login-popup,.sign-in,.login-link").length) {
        closeLoginForm();
    }
});


//REGISTER MODAL
function openRegisterForm() {
    document.body.classList.add("showRegisterForm");
    document.body.classList.remove("showLoginForm");
}
function closeRegisterForm() {
    document.body.classList.remove("showRegisterForm");
}

$(document).click(function (event2) {
    //if you click on anything except the modal itself or the "open modal" link, close the modal
    if (!$(event2.target).closest("#register-popup,.register-link").length) {
        closeRegisterForm();
    }
});