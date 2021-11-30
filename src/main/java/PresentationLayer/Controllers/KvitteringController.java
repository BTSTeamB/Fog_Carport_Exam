package PresentationLayer.Controllers;

import Entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "KvitteringController", value = "/KvitteringController")
public class KvitteringController extends HttpServlet implements ControllerUtil
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    public String buttonChecker(String buttonName, HttpServletRequest request)
    {
        return null;
    }

    @Override
    public void loginChecker(User user, HttpSession session)
    {

    }

    @Override
    public void adminChecker(User user, HttpSession session)
    {

    }
}
