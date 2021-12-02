package PresentationLayer.Controllers;

import PresentationLayer.View;
import ServiceLayer.PageUtility.UserUtility;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterController", value = "/RegisterController")
public class RegisterController extends HttpServlet
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
        } catch (ClassNotFoundException  e)
        {
            e.printStackTrace();
        }

        String userName = request.getParameter("name");
        String userAddress = request.getParameter("address");
        String userZipCode = request.getParameter("zip-code");
        String userEmail = request.getParameter("RegEmail");
        String userPassword = request.getParameter("RegPassword");
        String userPhoneNum = request.getParameter("phone");

        try
        {
            userUtility.registerUser(userName,userAddress, userZipCode, userEmail, userPassword, userPhoneNum);
        } catch (Exception e)
        {
            e.printStackTrace();
            String errorMsg = "Whoops something went wrong!";
            request.setAttribute("errorMsg", errorMsg);
            view.forwardToJsp("errorPage.jsp", request, response);
        }

        //Debug Prints
        System.out.println("Bruger indsat!");
        System.out.println("Her er noget info");
        System.out.println("- - - - - - - - - -");
        System.out.println("Name: " + userName);
        System.out.println("Address: " + userAddress);
        System.out.println("ZipCode: " + userZipCode);
        System.out.println("Email: " + userEmail);
        System.out.println("Pass: " + userPassword);
        System.out.println("PhoneNum: " + userPhoneNum);

        try
        {
            if(userUtility.loginUser(userEmail, userPassword, httpSession) == null)
            {
            view.forwardToJsp("errorPage.jsp", request, response);
            }
            else
            {
            userUtility.loginUser(userEmail, userPassword, httpSession);
            view.forwardToJsp("index.jsp", request, response);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
