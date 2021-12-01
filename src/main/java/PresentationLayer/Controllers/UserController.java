package PresentationLayer.Controllers;

import Entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserController", value = "/UserController")
public class UserController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession httpSession = request.getSession();
        User user;

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String zipCode = request.getParameter("zip-code");
        String phoneNumber = request.getParameter("phone");
        String email = request.getParameter("RegEmail");
        String password = request.getParameter("RegPassword");

        user = new User(name, address, zipCode, phoneNumber, email, password, false);

        //FOOBAR
        System.out.println("REGISTERED TEST USER:");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: "+ user.getEmail());
        System.out.println("Password: "+ user.getPassword());
        System.out.println("PhoneNumber: " + user.getPhoneNumber());
        System.out.println("Address: " + user.getAddress());
        System.out.println("Zip-Code: " + user.getZipCode());
    }
}
