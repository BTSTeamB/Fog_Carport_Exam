package PresentationLayer.Controllers;

import Entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SuperController", value = "/SuperController")
public class SuperController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    public String buttonChecker(String buttonName, HttpServletRequest request)
    {
        return null;
    }

    public void loginChecker(User user, HttpSession session)
    {

    }

    public void adminChecker(User user, HttpSession session)
    {

    }
}
