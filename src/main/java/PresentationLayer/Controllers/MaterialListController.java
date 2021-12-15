package PresentationLayer.Controllers;

import Entities.Material;
import ServiceLayer.PageUtility.carportAlgorithm;
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
        OrderUtility orderUtility = null;
        View view = new View();
        carportAlgorithm materialAlgorithm = null;
        Order order = null;

        try
        {
            orderUtility = new OrderUtility();
            order = orderUtility.getOrderByOrderId(Integer.parseInt(request.getParameter("selectedOrder")));
            materialAlgorithm = new carportAlgorithm(order.getCarport_width(), order.getCarport_length());
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        List<Material> claddingMaterials = materialAlgorithm.calculateCladdingMaterialList(orderUtility.getCladdingMaterial(order.getCladding_id()));
        List<Material> roofingMaterials = materialAlgorithm.calculateRoofingMaterialList(orderUtility.getRoofingMaterial(order.getRoofing_id()));

        request.setAttribute("ordersCladding", claddingMaterials);
        request.setAttribute("ordersRoofing", roofingMaterials);

        view.forwardToJsp("orderMaterialList.jsp", request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {


    }
}
