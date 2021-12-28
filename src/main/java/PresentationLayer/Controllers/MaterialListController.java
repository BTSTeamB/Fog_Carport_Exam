package PresentationLayer.Controllers;

import PresentationLayer.Entities.Material;
import ServiceLayer.PageUtility.carportAlgorithm;
import PresentationLayer.Entities.Order;
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
    View view = new View();
    OrderUtility orderUtility;

    {
        try
        {
            orderUtility = new OrderUtility();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        carportAlgorithm materialAlgorithm = null;
        Order order = null;

        try
        {
            //Henter ordrens detaljer ud fra den valgte ordres id
            order = orderUtility.getOrderByOrderId(Integer.parseInt(request.getParameter("selectedOrder")));
            System.out.println(order.getCladding_id());
            materialAlgorithm = new carportAlgorithm(order.getCarport_width(), order.getCarport_length());
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        List<Material> claddingMaterials = materialAlgorithm.calculateCladdingMaterialList(orderUtility.getCladdingMaterial(order.getCladding_id()));
        List<Material> roofingMaterials = materialAlgorithm.calculateRoofingMaterialList(orderUtility.getRoofingMaterial(order.getRoofing_id()));

        request.setAttribute("ordersCladding", claddingMaterials);
        request.setAttribute("ordersRoofing", roofingMaterials);

        view.forwardToJsp("materialList.jsp", request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    }
}
