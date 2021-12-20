package PresentationLayer.Controllers;

import Entities.Order;
import PresentationLayer.View;
import ServiceLayer.PageUtility.AdminUtility;
import ServiceLayer.PageUtility.PageUtility;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerOrderController", value = "/CustomerOrderController")
public class OrderController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        AdminUtility adminUtility = null;
        PageUtility pageUtility = null;
        View view = new View();

        try
        {
            pageUtility = new PageUtility();
            adminUtility = new AdminUtility();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        List<Order> allOrders = new ArrayList<>();

        allOrders = adminUtility.getAllOrders();



        //Set cladding / roofing types here

        for (int i = 0; i < allOrders.size(); i++)
        {
            allOrders.get(i).setCladdingType(pageUtility.getCladdingByID(allOrders.get(i).getCladding_id()).getType());
            try
            {
                allOrders.get(i).setRoofingType(pageUtility.getRoofingByID(allOrders.get(i).getRoofing_id()).getType());
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }


        request.setAttribute("allOrders", allOrders);

        view.forwardToJsp("adminOrdersList.jsp",request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
