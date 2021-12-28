package PresentationLayer.Controllers;

import PresentationLayer.Entities.Order;
import PresentationLayer.Entities.User;
import PresentationLayer.View;
import ServiceLayer.PageUtility.OrderUtility;
import ServiceLayer.PageUtility.PageUtility;
import ServiceLayer.PageUtility.UserUtility;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerOrderListController", value = "/CustomerOrderListController")
public class CustomerOrderListController extends HttpServlet
{
    View view = new View();
    OrderUtility orderUtility;
    UserUtility userUtility;

    {
        try
        {
            orderUtility = new OrderUtility();
            userUtility = new UserUtility();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        if(user == null)
        {
            view.forwardToJsp("orderGuest.jsp", request, response);
        }
        else
        {
            List<Order> usersOrders = orderUtility.getOrderListById(user.getUser_id());

            try
            {
                orderUtility.setCladdingRoofingTypes(usersOrders);
            } catch (Exception e)
            {
                e.printStackTrace();
            }

            if (user.getIs_guest() == 1)
            {
                session.invalidate();
            }

            request.setAttribute("usersOrders", usersOrders);
            request.setAttribute("customerName", user.getName());
            view.forwardToJsp("orders.jsp", request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();

        String guestName = request.getParameter("guestOrderName");
        String guestAddress = request.getParameter("guestOrderAddress");
        String guestZipCode = request.getParameter("guestOrderZipCode");
        String guestPhoneNum = request.getParameter("guestOrderPhoneNum");
        String guestEmail = request.getParameter("guestOrderEmail");

        User orderGuest = null;
        try
        {
            orderGuest = userUtility.getUserByCredentials(guestName, guestAddress, guestZipCode, guestPhoneNum, guestEmail);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        session.setAttribute("user", orderGuest);
        response.sendRedirect("CustomerOrderListController");

    }
}
