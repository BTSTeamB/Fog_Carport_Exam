package PresentationLayer.Controllers;

import Entities.PredefinedCarport;
import Entities.PredefinedShed;
import PresentationLayer.View;
import ServiceLayer.PageUtility.PageUtility;
import ServiceLayer.PageUtility.UserUtility;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        PageUtility pageUtility = null;
        List<PredefinedCarport> pdCarports = new ArrayList<>();
        List<PredefinedShed> pdSheds = new ArrayList<>();

        try
        {
            userUtility = new UserUtility();
            pageUtility = new PageUtility();
            pdCarports = pageUtility.getAllPDCarports();
        } catch (Exception e)
        {
            e.printStackTrace();
        }


        pageUtility.splitPredefinedCarportList(pdCarports, httpSession);

       String logEmail = request.getParameter("LoginUsername");
       String logPassword = request.getParameter("LoginPassword");

        try
        {
            if(userUtility.loginUser(logEmail, logPassword, httpSession) == null)
            {
                String loginFailMessage = "Wrong email or password, try again!";
                request.setAttribute("loginFailMessage", loginFailMessage);
                //TODO: Make a proper error page in our modal.
                view.forwardToJsp("errorPage.jsp", request, response);
            }
            else
            {
                userUtility.loginUser(logEmail, logPassword, httpSession);
                view.forwardToJsp("index.jsp", request, response);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}


