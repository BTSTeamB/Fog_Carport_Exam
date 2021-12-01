package PresentationLayer.Controllers;

import PresentationLayer.View;
import ServiceLayer.PageUtility.UserUtility;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/LoginController")
public class LoginController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession httpSession = request.getSession();
        View view = new View();
        UserUtility userUtility = null;
        try
        {
            userUtility = new UserUtility();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

       String logEmail = request.getParameter("LoginUsername");
       String logPassword = request.getParameter("LoginPassword");

        try
        {
            if(userUtility.loginUser(logEmail, logPassword, httpSession) == null)
            {
                view.forwardToJsp("errorPage.jsp", request, response);
            }
            else
            {
                userUtility.loginUser(logEmail, logPassword, httpSession);
                view.forwardToJsp("loginTest.jsp", request, response);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
