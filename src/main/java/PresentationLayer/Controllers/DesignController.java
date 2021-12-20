package PresentationLayer.Controllers;

import Entities.Material;
import Entities.Order;
import ServiceLayer.PageUtility.*;
import Entities.User;
import PresentationLayer.View;

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
        List<Material> printCladding = (List<Material>) session.getAttribute("claddingMaterials_calculated");
        List<Material> printRoofing = (List<Material>) session.getAttribute("roofingMaterials_calculated");

        try
        {
            orderUtility.createOrder(designedOrder);
            //Sends Email of material list to client
            Pdf pdf = new Pdf(printCladding, printRoofing);
            pdf.generatePdf();
            Emailer emailer = new Emailer(user.getEmail());
            emailer.sendmail();
            //Sends blueprint Image to client

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
        Double wantedShedWidth = 0.0;
        Double wantedShedLength = 0.0;
        int selectedCladding = 0;
        int selectedRoofing = 0;


        wantedWidth = Double.valueOf(request.getParameter("width"));
        wantedLength = Double.valueOf(request.getParameter("length"));

        wantedShedWidth = Double.valueOf(request.getParameter("tool-room-width"));
        wantedShedLength = Double.valueOf(request.getParameter("tool-room-length"));

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

        if(wantedShedLength > 0 && wantedShedWidth > 0)
        {
            if(selectedCladding == 1)
            {
                //TODO: Lave selectedCladding om til den der tilsvarer cladding material line som har skur materialer med i databasen
            }
            else if(selectedCladding == 2)
            {
                //TODO: Same shit here.
            }
        }

        List<Material> claddingMaterials = materialAlgorithm.calculateCladdingMaterialList(orderUtility.getCladdingMaterial(selectedCladding));
        List<Material> roofingMaterials = materialAlgorithm.calculateRoofingMaterialList(orderUtility.getRoofingMaterial(selectedRoofing));

        //If that checks if shedWidth / shedLength is over 0
        if(wantedShedLength > 0 && wantedShedWidth > 0)
        {
            try
            {
                claddingMaterials.add(pageUtility.getMaterialById(28));
                claddingMaterials.add(pageUtility.getMaterialById(29));
                claddingMaterials.add(pageUtility.getMaterialById(38));
                claddingMaterials.add(pageUtility.getMaterialById(39));
            } catch (Exception e)
            {
                e.printStackTrace();
            }

            for (int i = 0; i < claddingMaterials.size(); i++)
            {
                if (claddingMaterials.get(i).getName().equals("Pressure Impregnated Board"))
                {
                    claddingMaterials.get(i).setQuantity(claddingMaterials.get(i).getQuantity() * 2);
                }
                if(claddingMaterials.get(i).getName().equals("Pressure Impregnated Post"))
                {
                    if(wantedWidth.equals(wantedShedWidth))
                    {
                        claddingMaterials.get(i).setQuantity(claddingMaterials.get(i).getQuantity() + 4);
                    }
                    else
                    {
                    claddingMaterials.get(i).setQuantity(claddingMaterials.get(i).getQuantity() + 5);
                    }

                }
            }
        }

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

        drawCarport drawCarport = new drawCarport(wantedWidth.intValue(), wantedLength.intValue(), wantedShedWidth.intValue(), wantedShedLength.intValue());

        drawCarport.drawCarportProduct();

        request.setAttribute("svgDrawing", drawCarport.getSvg().toString());


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
