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
                String loginFailMessage = "Wrong email or password, try again!";
                request.setAttribute("loginFailMessage", loginFailMessage);
                view.forwardToJsp("errorPage.jsp", request, response);
            }
            else
            {
                userUtility.loginUser(logEmail, logPassword, httpSession);
                String changeSignInButton = "style='display: none;'";
                String changeDropDownButton = "display: block;";
                String changeDropDownMenu = "<div class=\"dropdown-content\">\n" +
                        "            <!--Den her skal have display NONE hvis de er ikke logget på. HELE Stylingen skal slettes hvis de er logget på -->\n" +
                        "            <a href=\"account.jsp\">Account</a>\n" +
                        "            <a href=\"LogoutController\">Sign-out</a>\n" +
                        "        </div>";
                changeButton("changeSignInButton", changeSignInButton, httpSession);
                changeButton("changeDropDownButton", changeDropDownButton, httpSession);
                changeButton("changeDropDownMenu", changeDropDownMenu, httpSession);
                view.forwardToJsp("index.jsp", request, response);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void changeButton(String attributeCaller, String attribute, HttpSession session)
    {
        session.setAttribute(attributeCaller, attribute);
    }
}


