package PresentationLayer.Controllers;

import DataAccessLayer.Database;
import Entities.User;
import ServiceLayer.Facades.UserFacade;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserController", value = "/UserController")
public class UserController extends HttpServlet implements ControllerUtil
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession httpSession = request.getSession();
        Database database = null;
        try
        {
            database = new Database();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        UserFacade userFacade = new UserFacade(database);


    }

    @Override
    public String buttonChecker(String buttonName, HttpServletRequest request)
    {
        buttonName = request.getParameter(buttonName);
        return null;
    }

    @Override
    public void loginChecker(User user, HttpSession session)
    {

    }

    @Override
    public void adminChecker(User user, HttpSession session)
    {


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
