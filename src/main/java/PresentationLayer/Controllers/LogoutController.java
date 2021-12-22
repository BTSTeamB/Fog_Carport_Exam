package PresentationLayer.Controllers;

import PresentationLayer.View;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutController", value = "/LogoutController")
public class LogoutController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession httpSession = request.getSession();

        httpSession.invalidate();

        //This will change the url to index, but it is slower than redirect.
        //And forward to our indexController and homepage.
        // It is slower because, redirect, unlike forward, requires a round-trip communication with the client.
        response.sendRedirect("index");
        //view.forwardToJsp("index",request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
