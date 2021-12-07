package PresentationLayer.Controllers;

import Entities.*;
import PresentationLayer.View;
import ServiceLayer.PageUtility.OrderUtility;

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
        View view = new View();

        try
        {
            orderUtility = new OrderUtility();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }


        if(user == null)
        {
            response.sendRedirect("orderAsGuest.jsp");
        }
        else
        {
            try
            {
                orderUtility.createPDOrder(session);
                if(user.getIs_guest() == 1)
                {
                    session.invalidate();
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }


            view.forwardToJsp("OrderSent.jsp", request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
