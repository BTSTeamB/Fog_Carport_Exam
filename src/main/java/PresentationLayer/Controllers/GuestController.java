package PresentationLayer.Controllers;

import Entities.User;
import PresentationLayer.View;
import ServiceLayer.PageUtility.UserUtility;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GuestController", value = "/GuestController")
public class GuestController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        UserUtility userUtility = null;
        View view = new View();

        try
        {
            userUtility = new UserUtility();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        String name = request.getParameter("guestName");
        String address = request.getParameter("guestAddress");
        String zipCode = request.getParameter("guestZipCode");
        String email = request.getParameter("guestEmail");
        String phoneNumber = request.getParameter("guestPhoneNum");




        User user = new User(name, address, zipCode ,phoneNumber, email);

        try
        {
            userUtility.registerGuestUser(user);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("Guest registered!");
        System.out.println("Here is his info:");
        System.out.println(user.getName());
        System.out.println(user.getAddress());
        System.out.println(user.getZipCode());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getPhoneNumber());

        try
        {
            user = userUtility.getUserByLogin(user.getEmail(), user.getPassword());
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        session.setAttribute("user", user);

        response.sendRedirect("CheckOutController");
    }
}
