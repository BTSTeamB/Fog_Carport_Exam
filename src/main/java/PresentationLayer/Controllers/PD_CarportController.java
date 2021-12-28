package PresentationLayer.Controllers;

import PresentationLayer.Entities.*;
import PresentationLayer.View;
import ServiceLayer.PageUtility.PageUtility;
import sun.jvm.hotspot.debugger.Page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderController", value = "/OrderController")
//Skiftede navn til PD_CarportController, da den kun bliver brugt til at håndtere PreDefined ordre
//Prøvede at ændre name og values her, men det gav fejl i HTTP Request.

public class PD_CarportController extends HttpServlet
{
    View view = new View();
    PageUtility pageUtility;

    {
        try
        {
            pageUtility = new PageUtility();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        List<PredefinedCarport> pdCarportList = new ArrayList<>();

        //Get'eren her, samler alt data'en og smider det i en produkt-oversigt side.

        pdCarportList = (List<PredefinedCarport>) session.getAttribute("AllPDCarports");

        int chosenCarport = (Integer.parseInt(request.getParameter("act")));

        List<Cladding> claddingList = new ArrayList<>();
        List<Roofing> roofingList = new ArrayList<>();

        claddingList = pageUtility.getAllCladdings();
        claddingList = claddingList.subList(0,2);

        roofingList = pageUtility.getAllRoofings();
        roofingList = roofingList.subList(0,2);


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
        User user = (User) session.getAttribute("user");

        //Værdier som indikere hvilken beklædning/tag brugeren har valgt

        int claddingType = (Integer.parseInt(request.getParameter("cladding")));
        int roofingType = (Integer.parseInt(request.getParameter("roofing")));


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
