package PresentationLayer.Controllers;

import Entities.*;
import PresentationLayer.View;
import ServiceLayer.PageUtility.OrderUtility;
import ServiceLayer.PageUtility.UserUtility;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckOutController", value = "/CheckOutController")
public class CheckOutController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        OrderUtility orderUtility = null;
        UserUtility userUtility = null;
        View view = new View();

        try
        {
            orderUtility = new OrderUtility();
            userUtility = new UserUtility();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        if(user == null)
        {
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String zip = request.getParameter("zip");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");

            user = new User(name, address, zip,phone, email);
            try
            {
                userUtility.registerGuestUser(user);
                user = userUtility.getUserByCredentials(name, address, zip, phone, email);
                session.setAttribute("user", user);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
            try
            {
                orderUtility.createPDOrder(session);
                if(user.getIs_guest() == 1)
                {
                    session.invalidate();
                    response.sendRedirect("index");
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }


            view.forwardToJsp("orderComplete.jsp", request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
