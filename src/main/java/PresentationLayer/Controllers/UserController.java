package PresentationLayer.Controllers;


import DataAccessLayer.Mappers.Facade;
import Entities.User;
import PresentationLayer.View;
import ServiceLayer.PageUtility.UserUtility;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserController", value = "/UserController")
public class UserController extends HttpServlet
{
    View view = new View();
    UserUtility userUtility;

    {
        try
        {
            userUtility = new UserUtility();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        view.forwardToJsp("account.jsp", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession httpSession = request.getSession();

        userUtility.editUser(request, httpSession);


        view.forwardToJsp("account.jsp", request, response);
    }

}
