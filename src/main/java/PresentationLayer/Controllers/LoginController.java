package PresentationLayer.Controllers;

import PresentationLayer.Entities.PredefinedCarport;
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

        try
        {
            userUtility = new UserUtility();
            pageUtility = new PageUtility();
            pdCarports = pageUtility.getAllPDCarports();
        } catch (Exception e)
        {
            e.printStackTrace();
        }


        //Har sgu glemt hvorfor den her ligger her
        pageUtility.splitPredefinedCarportList(pdCarports, httpSession);

       String logEmail = request.getParameter("LoginUsername");
       String logPassword = request.getParameter("LoginPassword");

        try
        {
            //Forsøg på noget fejl-håndtering
            if(userUtility.loginUser(logEmail, logPassword, httpSession) == null)
            {
                String loginFailMessage = "Wrong email or password, try again!";
                request.setAttribute("loginFailMessage", loginFailMessage);

                //TODO: Make a proper error page in our modal.
                //Through some research we can conclude that it has to be done via JS, we will wait till 3rd semester

                view.forwardToJsp("errorPage.jsp", request, response);
            }
            else
            {
                //Logger brugeren ind
                userUtility.loginUser(logEmail, logPassword, httpSession);
                view.forwardToJsp("index.jsp", request, response);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}


