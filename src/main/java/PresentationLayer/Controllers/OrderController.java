package PresentationLayer.Controllers;

import DataAccessLayer.Database;
import DataAccessLayer.Mappers.Facade;
import Entities.Cladding;
import Entities.Material;
import Entities.PredefinedCarport;
import Entities.Roofing;
import PresentationLayer.View;
import ServiceLayer.PageUtility.PageUtility;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
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
        String act = request.getParameter("act");

        List<Cladding> claddingList = new ArrayList<>();
        List<Roofing> roofingList = new ArrayList<>();

        claddingList = pageUtility.getAllCladdings();
        roofingList = pageUtility.getAllRoofings();

        System.out.println(claddingList.size());
        System.out.println(roofingList.size());

        request.setAttribute("claddingList", claddingList);
        request.setAttribute("roofingList", roofingList);


        for (int i = 0; i < pdCarportList.size(); i++)
        {
            String idChecker = String.valueOf(pdCarportList.get(i).getId());
            if(act.equals(idChecker))
            {
                PredefinedCarport pdCarport = pdCarportList.get(i);
                session.setAttribute("viewMoreCarport", pdCarport);
                view.forwardToJsp("viewMoreFOOBAR.jsp", request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        PageUtility pageUtility = null;
        try
        {
             pageUtility = new PageUtility();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        View view = new View();

        //Hardcoded in case dynamic doesn't work
        Material claddingMat = new Material((Integer.parseInt(request.getParameter("cladding"))));
        Material roofingMat = new Material((Integer.parseInt(request.getParameter("roofing"))));

        if(claddingMat.getMaterial_id() == 0)
        {
            claddingMat.setName("Træ Beklædning");
            claddingMat.setDescription("Flot træ, skåret af vores bedste praktikanter");
            claddingMat.setPrice(255.5);
            claddingMat.setLength(18.2);
            claddingMat.setHeight(3.2);
            claddingMat.setWidth(4.12);
        }
        else if(claddingMat.getMaterial_id() == 1)
        {
            claddingMat.setName("Sten Beklædning");
            claddingMat.setDescription("Flot beklædning med symmetriske sten-plader");
            claddingMat.setPrice(680.0);
            claddingMat.setLength(18.2);
            claddingMat.setHeight(3.2);
            claddingMat.setWidth(4.12);
        }
        else if(claddingMat.getMaterial_id() == 2)
        {
            claddingMat.setName("Glas Beklædning?");
            claddingMat.setDescription("Hvad er en glas carport lol");
            claddingMat.setPrice(10000.0);
            claddingMat.setLength(69.2);
            claddingMat.setHeight(420.2);
            claddingMat.setWidth(80085.12);
        }

        if(roofingMat.getMaterial_id() == 0)
        {
            roofingMat.setName("Træ Tag");
            roofingMat.setDescription("Flot træ, skåret af vores bedste praktikanter");
            roofingMat.setPrice(255.5);
            roofingMat.setLength(18.2);
            roofingMat.setHeight(3.2);
            roofingMat.setWidth(4.12);
        }
        else if(roofingMat.getMaterial_id() == 1)
        {
            roofingMat.setName("Sten Tag");
            roofingMat.setDescription("Flot beklædning med symmetriske sten-plader");
            roofingMat.setPrice(680.0);
            roofingMat.setLength(18.2);
            roofingMat.setHeight(3.2);
            roofingMat.setWidth(4.12);
        }
        else if(roofingMat.getMaterial_id() == 2)
        {
            roofingMat.setName("Klink Tag");
            roofingMat.setDescription("Det kan noget");
            roofingMat.setPrice(812.1);
            roofingMat.setLength(69.2);
            roofingMat.setHeight(420.2);
            roofingMat.setWidth(4.8);
        }

        System.out.println(claddingMat.getMaterial_id());
        System.out.println(roofingMat.getMaterial_id());

        Cladding cladding = new Cladding(claddingMat);
        Roofing roofing = new Roofing(roofingMat);

        System.out.println("- - - - - - - - - - - - - - - - - - -");
        System.out.println("Cladding");
        System.out.println("- - - - - - - - - - - - - - - - - - -");
        System.out.println(cladding.getMaterial().getName());
        System.out.println(cladding.getMaterial().getDescription());
        System.out.println(cladding.getMaterial().getPrice());
        System.out.println("- - - - - - - - - - - - - - - - - - -");
        System.out.println("Roofing");
        System.out.println("- - - - - - - - - - - - - - - - - - -");
        System.out.println(roofing.getMaterial().getName());
        System.out.println(roofing.getMaterial().getDescription());
        System.out.println(roofing.getMaterial().getPrice());
        System.out.println("- - - - - - - - - - - - - - - - - - -");

        request.setAttribute("chosenCladding", cladding);
        request.setAttribute("chosenRoofing", roofing);


        // DYNAMIC METHODS

        //Anden dynamisk metode hvor man laver en cladding objekt med kun id, så via det objekt
        //henter man mere data til den via databasen, så når man har sit materiale,
        //så kan man sette sit materiale objekt i klassen. (SMART?)

//        int chosenCladding = Integer.parseInt(request.getParameter("cladding"));
//        int chosenRoofing = Integer.parseInt(request.getParameter("roofing"));
//        Cladding tmpCladding = new Cladding(chosenCladding);
//        System.out.println("Got tmpCladding!");
//        Cladding mIdClad = pageUtility.getCladdingByObject(tmpCladding);
//        System.out.println("Got mIdClad!");
//        try
//        {
//            mIdClad.setMaterial(pageUtility.getMaterialById(mIdClad.getMaterial_id()));
//            System.out.println("Material set!");
//        } catch (Exception e)
//        {
//            e.printStackTrace();
//        }




            //Dynamic method, ignore until u get to view database tabels
//        PredefinedCarport orderSummaryCarport = (PredefinedCarport) session.getAttribute("viewMoreCarport");
//        try
//        {   Cladding tmpCladding;
//            Roofing tmpRoofing;
//            tmpCladding = pageUtility.getCladdingByID(Integer.parseInt(request.getParameter("cladding")));
//            Cladding cladding = new Cladding(tmpCladding.getCladding_id(), new Material(tmpCladding.getMaterial_id()));
//            tmpRoofing = pageUtility.getRoofingByID(Integer.parseInt(request.getParameter("roofing")));
//            Roofing roofing = new Roofing(tmpRoofing.getRoofing_id(), new Material(tmpRoofing.getMaterial_id()));
//            request.setAttribute("chosenCladding", cladding);
//            request.setAttribute("chosenRoofing", roofing);
//        } catch (Exception e)
//        {
//            e.printStackTrace();
//        }

        view.forwardToJsp("orderSummary.jsp", request, response);
    }
}
