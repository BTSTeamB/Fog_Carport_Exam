package PresentationLayer.Controllers;

import Entities.Material;
import Entities.Order;
import ServiceLayer.PageUtility.*;
import Entities.User;
import PresentationLayer.View;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileWriter;
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

            String button = request.getParameter("place order");

            if(request.getParameter("name").equals("") || request.getParameter("address").equals("") || request.getParameter("zip").length() != 4 || request.getParameter("phone").length() != 8|| request.getParameter("email").equals(""))
            {
                if(request.getParameter("name").equals(""))
                {
                    String failMessageName = "- This input needs to be filled out";
                    request.setAttribute("failMessageName", failMessageName);
                } else
                {
                    name = request.getParameter("name");
                    request.setAttribute("inputName",name);
                }

                if(request.getParameter("address").equals(""))
                {
                    String failMessageAddress = "- This input needs to be filled out";
                    request.setAttribute("failMessageAddress", failMessageAddress);
                } else
                {
                    address = request.getParameter("address");
                    request.setAttribute("inputAddress",address);
                }

                if(request.getParameter("zip").length() != 4)
                {
                    String failMessageZip = "- Your zip-code needs to be 4 digits long";
                    request.setAttribute("failMessageZip", failMessageZip);
                } else
                {
                    zip = request.getParameter("zip");
                    request.setAttribute("inputZip",zip);
                }

                if(request.getParameter("phone").length() != 8)
                {
                    String failMessagePhone = "- Your phone-number needs to be 8 digits long";
                    request.setAttribute("failMessagePhone", failMessagePhone);
                } else
                {
                    phone = request.getParameter("phone");
                    request.setAttribute("inputPhone", phone);
                }

                if(request.getParameter("email").equals(""))
                {
                    String failMessageEmail = "- Please enter a valid email";
                    request.setAttribute("failMessageEmail", failMessageEmail);
                } else
                {
                    email = request.getParameter("email");
                    request.setAttribute("inputEmail",email);
                }

                if(button.equals("CO_guest-cookie"))
                {
                    view.forwardToJsp("checkout-guest.jsp", request, response);
                }

                if(button.equals("CO_user_cookie"))
                {
                    view.forwardToJsp("checkout-user.jsp", request, response);
                }
                return;
            }

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

        if(user.getIs_guest() == 1)
        {
            session.invalidate();
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



        String button = request.getParameter("calculate");
        if(request.getParameter("width") == null || request.getParameter("length") == null || (request.getParameter("cladding") == null || request.getParameter("roof") == null))
        {
            if(button.equals("flatCookie"))
            {
                String failMessage = "You forgot to fill out some or all '*' marked fields";
                request.setAttribute("failMessage", failMessage);
                view.forwardToJsp("designFlat.jsp", request, response);
                return;
            }

            if(button.equals("gableCookie"))
            {
                String failMessage = "You forgot to fill out some or all '*' marked fields";
                request.setAttribute("failMessage", failMessage);
                view.forwardToJsp("designGable.jsp", request, response);
                return;
            }
        }


        wantedWidth = Double.valueOf(request.getParameter("width"));
        wantedLength = Double.valueOf(request.getParameter("length"));

        wantedShedWidth = Double.valueOf(request.getParameter("tool-room-width"));
        wantedShedLength = Double.valueOf(request.getParameter("tool-room-length"));

        selectedCladding = Integer.parseInt(request.getParameter("cladding"));
        selectedRoofing = Integer.parseInt(request.getParameter("roof"));

        session.setAttribute("wantedWidth",wantedWidth);
        session.setAttribute("wantedLength",wantedLength);

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
                selectedCladding = 3;
            }
            else if(selectedCladding == 2)
            {
              selectedCladding = 4;
            }
        }

        session.setAttribute("wantedCladdingId", selectedCladding);
        session.setAttribute("wantedRoofingId", selectedRoofing);

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

        drawCarport drawCarport = new drawCarport(wantedWidth.intValue(), wantedLength.intValue(), wantedShedWidth.intValue(), wantedShedLength.intValue());

        drawCarport.drawCarportProduct();

        //TODO: Leg lidt med noget filewriter

        //Path : "/Users/oliverrasoli/IntellJWork/" skal ændres til hvad der passer til droplet
        File file = new File("/Users/oliverrasoli/IntellJWork/Eksamen_FogCarport/src/main/webapp/Resources/invoice-svg/CustomersCarport.svg");
        FileWriter writer = new FileWriter(file);
        writer.write(drawCarport.getSvg().toString());
        writer.flush();
        writer.close();

        session.setAttribute("svgDrawing", drawCarport.getSvg().toString());

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
