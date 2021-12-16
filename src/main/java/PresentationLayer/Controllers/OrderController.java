package PresentationLayer.Controllers;

import DataAccessLayer.Database;
import DataAccessLayer.Mappers.Facade;
import Entities.*;
import PresentationLayer.View;
import ServiceLayer.PageUtility.OrderUtility;
import ServiceLayer.PageUtility.PageUtility;
import ServiceLayer.PageUtility.carportAlgorithm;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderController", value = "/OrderController")
public class OrderController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        List<PredefinedCarport> pdCarportList = new ArrayList<>();
        PageUtility pageUtility = null;

        try
        {
           pageUtility = new PageUtility();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        View view = new View();

        pdCarportList = (List<PredefinedCarport>) session.getAttribute("AllPDCarports");

        int chosenCarport = (Integer.parseInt(request.getParameter("act")));

        List<Cladding> claddingList = new ArrayList<>();
        List<Roofing> roofingList = new ArrayList<>();

        claddingList = pageUtility.getAllCladdings();
        roofingList = pageUtility.getAllRoofings();


        request.setAttribute("claddingList", claddingList);
        request.setAttribute("roofingList", roofingList);


        //Gets selected Carport
        for (int i = 0; i < pdCarportList.size(); i++)
        {
            int idChecker = pdCarportList.get(i).getId();
            if(chosenCarport == idChecker)
            {
                PredefinedCarport pdCarport = pdCarportList.get(i);
                session.setAttribute("viewMoreCarport", pdCarport);
                view.forwardToJsp("product.jsp", request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        PageUtility pageUtility = null;
        OrderUtility orderUtility = null;
        carportAlgorithm carportAlgorithm = null;
        User user = (User) session.getAttribute("user");
        try
        {
            orderUtility = new OrderUtility();
             pageUtility = new PageUtility();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        View view = new View();

        //values to indicate what cladding/roofing user selected

        int claddingType = (Integer.parseInt(request.getParameter("cladding")));
        int roofingType = (Integer.parseInt(request.getParameter("roofing")));

//        //Not currently being used
        //TODO: Make this list appear nicely in the order summary page.
//        List<Material> claddingMaterials = orderUtility.getCladdingMaterial(claddingType);
//        List<Material> roofingMaterials = orderUtility.getRoofingMaterial(roofingType);

        //Making Cladding/Roofing objects, so we can throw their "type" value into the session
        // and retrieve it on OrderSum
        Cladding cladding = pageUtility.getCladdingByID(claddingType);
        Roofing roofing = null;
        try
        {
            roofing = pageUtility.getRoofingByID(roofingType);
        } catch (Exception e)
        {
            e.printStackTrace();
        }


        session.setAttribute("chosenCladding", cladding);
        session.setAttribute("chosenRoofing", roofing);

        PredefinedCarport pdCarport = (PredefinedCarport) session.getAttribute("viewMoreCarport");

        if (user == null)
        {
            view.forwardToJsp("premade-checkout-guest.jsp", request, response);
        }
        else
        {
            view.forwardToJsp("premade-checkout-user.jsp", request, response);
        }
    }
}
