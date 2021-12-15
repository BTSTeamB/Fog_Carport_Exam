package PresentationLayer.Controllers;

import Entities.Material;
import Entities.Order;
import ServiceLayer.PageUtility.PageUtility;
import ServiceLayer.PageUtility.UserUtility;
import ServiceLayer.PageUtility.carportAlgorithm;
import Entities.User;
import PresentationLayer.View;
import ServiceLayer.PageUtility.OrderUtility;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DesignController", value = "/DesignController")
public class DesignController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        View view = new View();
        OrderUtility orderUtility = null;
        PageUtility pageUtility = null;
        UserUtility userUtility = null;

        User user = (User) session.getAttribute("user");
        double totalPrice = (double) session.getAttribute("totalPrice");
        Double wantedWidth = 0.0;
        Double wantedLength = 0.0;
        int wantedCladding_id = 0;
        int wantedRoofing_id = 0;

        wantedWidth = (Double) session.getAttribute("wantedWidth");
        wantedLength = (Double) session.getAttribute("wantedLength");

        wantedCladding_id = (int) session.getAttribute("wantedCladdingId");
        wantedRoofing_id = (int) session.getAttribute("wantedRoofingId");


        try
        {
            orderUtility = new OrderUtility();
            pageUtility = new PageUtility();
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
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        Order designedOrder = new Order(user.getUser_id(),totalPrice,wantedLength,wantedWidth, wantedCladding_id, wantedRoofing_id);

        try
        {
            orderUtility.createOrder(designedOrder);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        view.forwardToJsp("orderComplete.jsp", request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        View view = new View();
        User user = (User) session.getAttribute("user");
        carportAlgorithm materialAlgorithm = null;
        OrderUtility orderUtility = null;
        PageUtility pageUtility = null;

        // User's choices

        Double wantedWidth = 0.0;
        Double wantedLength = 0.0;
        int selectedCladding = 0;
        int selectedRoofing = 0;


        wantedWidth = Double.valueOf(request.getParameter("width"));
        wantedLength = Double.valueOf(request.getParameter("length"));

        selectedCladding = Integer.parseInt(request.getParameter("cladding"));
        selectedRoofing = Integer.parseInt(request.getParameter("roof"));

        session.setAttribute("wantedWidth",wantedWidth);
        session.setAttribute("wantedLength",wantedLength);

        session.setAttribute("wantedCladdingId", selectedCladding);
        session.setAttribute("wantedRoofingId", selectedRoofing);

        try
        {
            materialAlgorithm = new carportAlgorithm(wantedWidth, wantedLength);
            orderUtility = new OrderUtility();
            pageUtility = new PageUtility();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        List<Material> claddingMaterials = materialAlgorithm.calculateCladdingMaterialList(orderUtility.getCladdingMaterial(selectedCladding));
        List<Material> roofingMaterials = materialAlgorithm.calculateRoofingMaterialList(orderUtility.getRoofingMaterial(selectedRoofing));

        double totalPrice = 0.0;
        for (int i = 0; i < claddingMaterials.size(); i++)
        {
            totalPrice += (claddingMaterials.get(i).getPrice() * claddingMaterials.get(i).getQuantity());
        }
        for (int i = 0; i < roofingMaterials.size(); i++)
        {
            totalPrice += (roofingMaterials.get(i).getPrice() * claddingMaterials.get(i).getQuantity());
        }

        // Rounding off totalPrice so it isn't an insane number
        totalPrice = Math.round(totalPrice*100) / 100;

        String claddingType = pageUtility.getCladdingByID(selectedCladding).getType();
        String roofingType = "";
        try
        {
            roofingType = pageUtility.getRoofingByID(selectedRoofing).getType();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        session.setAttribute("claddingMaterials_calculated", claddingMaterials);
        session.setAttribute("roofingMaterials_calculated", roofingMaterials);
        request.setAttribute("selectedCladdingType", claddingType);
        request.setAttribute("selectedRoofingType", roofingType);
        session.setAttribute("totalPrice", totalPrice);
        if(user == null)
        {
          view.forwardToJsp("checkout-guest.jsp", request, response);
        }
        else
        {
            view.forwardToJsp("checkout-user.jsp", request, response);
        }
    }
}
