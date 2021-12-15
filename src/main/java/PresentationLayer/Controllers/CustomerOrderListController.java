package PresentationLayer.Controllers;

import Entities.Order;
import Entities.User;
import PresentationLayer.View;
import ServiceLayer.PageUtility.OrderUtility;
import ServiceLayer.PageUtility.UserUtility;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerOrderListController", value = "/CustomerOrderListController")
public class CustomerOrderListController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        OrderUtility orderUtility = null;
        View view = new View();

        try
        {
           orderUtility = new OrderUtility();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        User user = (User) session.getAttribute("user");

        if(user == null)
        {
            view.forwardToJsp("guestOrLogin.jsp", request, response);
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

            request.setAttribute("usersOrders", usersOrders);
            view.forwardToJsp("customerOrderList.jsp", request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        View view = new View();
        OrderUtility orderUtility = null;
        UserUtility userUtility = null;

        try
        {
            userUtility = new UserUtility();
            orderUtility = new OrderUtility();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

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

        //If Redirect doesn't work
//        List<Order> usersOrders = orderUtility.getOrderListById(orderGuest.getUser_id());
//
//        try
//        {
//            orderUtility.setCladdingRoofingTypes(usersOrders);
//        } catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//        request.setAttribute("usersOrders", usersOrders);
//        view.forwardToJsp("customerOrderList.jsp", request, response);
    }
}