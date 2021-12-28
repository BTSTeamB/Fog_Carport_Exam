package PresentationLayer.Controllers;

import PresentationLayer.Entities.Order;
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
public class Admin_CustomerOrderController extends HttpServlet
{
    AdminUtility adminUtility;
    PageUtility pageUtility;
    View view = new View();

    {
        try
        {
            adminUtility = new AdminUtility();
            pageUtility = new PageUtility();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
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
