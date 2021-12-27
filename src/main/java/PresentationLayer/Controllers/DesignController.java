package PresentationLayer.Controllers;

import PresentationLayer.Entities.Material;
import PresentationLayer.Entities.Order;
import ServiceLayer.PageUtility.*;
import PresentationLayer.Entities.User;
import PresentationLayer.View;
import ServiceLayer.Pdf;

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
        UserUtility userUtility = null;

        //Henter info fra JSP'en
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



        //instantierer utility classes
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
            //Henter bruger data hvis der ikke er en bruger logget på
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String zip = request.getParameter("zip");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");

            String button = request.getParameter("place order");

            //Fejl håndtering
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
                //Smider gæstbrugeren i DB
                userUtility.registerGuestUser(user);
                user = userUtility.getUserByCredentials(name, address, zip, phone, email);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        //Laver Designed Ordre
        Order designedOrder = new Order(user.getUser_id(),totalPrice,wantedLength,wantedWidth, wantedCladding_id, wantedRoofing_id);
        //Henter styklisterne som har været igennem algoritmen
        List<Material> printCladding = (List<Material>) session.getAttribute("claddingMaterials_calculated");
        List<Material> printRoofing = (List<Material>) session.getAttribute("roofingMaterials_calculated");

        try
        {
            //Afrunder handlen, smider ordren i databasen
            orderUtility.createOrder(designedOrder);
            //Laver materiale listen om til en pdf fil
            String pdfListPath = getServletContext().getRealPath("/");
            pdfListPath = String.format("%s", pdfListPath.replace(".","."));
            pdfListPath = pdfListPath + "Resources/invoice-pdf/MaterialList.pdf";

            Pdf pdfList = new Pdf(printCladding, printRoofing, pdfListPath);
            pdfList.generatePdfList();

            //Laver SVG-koden om til en PNG via Batik biblioteket
            String svgPath = getServletContext().getRealPath("/");
            svgPath = String.format("%s", svgPath.replace(".","."));
            svgPath = svgPath + "Resources/invoice-svg/CustomersCarport.svg";

            String pngPath = getServletContext().getRealPath("/");
            pngPath = String.format("%s", pngPath.replace(".", "."));
            pngPath = pngPath + "Resources/invoice-pdf/Customers-Carport.png";

            Pdf pdfSvgToPng = new Pdf(svgPath, pngPath);
            pdfSvgToPng.makeSvgIntoPng();

            //Sender emailen afsted til kunden
            Emailer emailer = new Emailer(user.getEmail(), pdfListPath, pngPath);
            emailer.sendmail();

            //Den gider simpelthen ikke sende en email hvis applikationen kører via Tomcat/Server
            //Lokalt vil den gerne virke...
            //Har prøvet at gøre alle paths dynamiske ud fra servletContext, med endda System.getProperty("user.dir")
            //for at få det korrekte directory. Men intet virker:(


        } catch (Exception e)
        {
            e.printStackTrace();
        }

        //Hvis kunden er en gæst, så invaliderer vi deres session.
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

        // Brugerens beslutninger i DesignCarport

        Double wantedWidth = 0.0;
        Double wantedLength = 0.0;
        Double wantedShedWidth = 0.0;
        Double wantedShedLength = 0.0;
        int selectedCladding = 0;
        int selectedRoofing = 0;



        // Fejl håndtering

        //String er sat til knappen's værdi inde på JSP'en
        String button = request.getParameter("calculate");
        if(request.getParameter("width") == null || request.getParameter("length") == null || (request.getParameter("cladding") == null || request.getParameter("roof") == null))
        {
            //Hvis knappen har "flatCookie" som værdi, så bliver du sendt tilbage til flat siden
            if(button.equals("flatCookie"))
            {
                String failMessage = "You forgot to fill out some or all '*' marked fields";
                request.setAttribute("failMessage", failMessage);
                view.forwardToJsp("designFlat.jsp", request, response);
                return;
            }

            //Hvis knappen har "flatCookie" som værdi, så bliver du sendt tilbage til flat siden
            if(button.equals("gableCookie"))
            {
                String failMessage = "You forgot to fill out some or all '*' marked fields";
                request.setAttribute("failMessage", failMessage);
                view.forwardToJsp("designGable.jsp", request, response);
                return;
            }
        }


        //Tager inputsne fra JSP og laver dem om til datatypen Double.
        wantedWidth = Double.valueOf(request.getParameter("width"));
        wantedLength = Double.valueOf(request.getParameter("length"));

        wantedShedWidth = Double.valueOf(request.getParameter("tool-room-width"));
        wantedShedLength = Double.valueOf(request.getParameter("tool-room-length"));

        //Undtagen her, her bliver den til int
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

        //Checker om brugeren vil have et skur. Hvis de vil,
        // så ændrer cladding id'et til at vælge de rigtige materialer på DB
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

        //Smider den valgte beklædning og tag ind i session
        session.setAttribute("wantedCladdingId", selectedCladding);
        session.setAttribute("wantedRoofingId", selectedRoofing);

        List<Material> claddingMaterials = materialAlgorithm.calculateCladdingMaterialList(orderUtility.getCladdingMaterial(selectedCladding));
        List<Material> roofingMaterials = materialAlgorithm.calculateRoofingMaterialList(orderUtility.getRoofingMaterial(selectedRoofing));


        //Regner prisen sammen for hele carporten
        double totalPrice = 0.0;
        for (int i = 0; i < claddingMaterials.size(); i++)
        {
            totalPrice += (claddingMaterials.get(i).getPrice() * claddingMaterials.get(i).getQuantity());
        }
        for (int i = 0; i < roofingMaterials.size(); i++)
        {
            totalPrice += (roofingMaterials.get(i).getPrice() * claddingMaterials.get(i).getQuantity());
        }

        // Runder totalPrice af så det ikke bliver til et kæmpe decimal-nummer
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

        DrawCarport drawCarport = new DrawCarport(wantedWidth.intValue(), wantedLength.intValue(), wantedShedWidth.intValue(), wantedShedLength.intValue());

        drawCarport.drawCarportProduct();


        //Path : "/Users/oliverrasoli/IntellJWork/" skal ændres til hvad der passer til droplet
        //Skriver SVG koden ind i en fil
        String svgPath = getServletContext().getRealPath("/");
        svgPath = String.format("%s", svgPath.replace(".","."));
        svgPath = svgPath + "Resources/invoice-svg/CustomersCarport.svg";

        File file = new File(svgPath);
        FileWriter writer = new FileWriter(file);
        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
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
