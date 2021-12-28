package PresentationLayer.Controllers;

import PresentationLayer.Entities.User;
import PresentationLayer.View;
import ServiceLayer.PageUtility.AdminUtility;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerController", value = "/CustomerController")
public class Admin_CustomerController extends HttpServlet
{
    AdminUtility adminUtility;
    View view = new View();

    {
        try
        {
            adminUtility = new AdminUtility();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<User> allUsers = new ArrayList<>();
        try
        {
            allUsers = adminUtility.getAllUsers();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        request.setAttribute("allUsers", allUsers);

        view.forwardToJsp("adminCustomersList.jsp",request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
