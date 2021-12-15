package PresentationLayer.Controllers;

import Entities.Material;
import Entities.Order;
import PresentationLayer.View;
import ServiceLayer.PageUtility.OrderUtility;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MaterialListController", value = "/MaterialListController")
public class MaterialListController extends HttpServlet
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

        Order order = orderUtility.getOrderByOrderId(Integer.parseInt(request.getParameter("selectedOrder")));
        List<Material> claddingMaterials = orderUtility.getCladdingMaterial(order.getCladding_id());
        List<Material> roofingMaterials = orderUtility.getRoofingMaterial(order.getRoofing_id());

        request.setAttribute("ordersCladding", claddingMaterials);
        request.setAttribute("ordersRoofing", roofingMaterials);

        view.forwardToJsp("orderMaterialList.jsp", request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {



    }
}
