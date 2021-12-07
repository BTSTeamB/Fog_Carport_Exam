package PresentationLayer.Controllers;

import DataAccessLayer.Database;
import DataAccessLayer.Mappers.Facade;
import Entities.*;
import PresentationLayer.View;
import ServiceLayer.PageUtility.PageUtility;

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

        System.out.println(claddingList.size());
        System.out.println(roofingList.size());

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
        try
        {
             pageUtility = new PageUtility();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        View view = new View();

        //values to indicate what cladding/roofing user selected

        int claddingType = (Integer.parseInt(request.getParameter("cladding")));
        int roofingType = (Integer.parseInt(request.getParameter("roofing")));

        System.out.println("USER SELECTED THESE VALUES");
        System.out.println("CLADDING: "+claddingType);
        System.out.println("ROOFING: "+roofingType);

        //Material Lists
        List<CladdingMaterialLine> cmlList = pageUtility.getAllCMLBySpecificId(claddingType);
        List<Material> claddingMaterialList = new ArrayList<>();
//        int cml_count = 0; //FOOBAR

//        System.out.println("- - - - - GENERATING LIST FOR CLADDING - - - - -");
        for (CladdingMaterialLine claddingMaterialLine : cmlList)
        {
            try
            {
                claddingMaterialList.add(pageUtility.getMaterialById(claddingMaterialLine.getMaterialId()));
//                System.out.println(claddingMaterialList.get(cml_count).getName());
//                cml_count++;
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
//        System.out.println("CLADDING MATERIAL LIST SIZE: "+claddingMaterialList.size());

        List<RoofingMaterialLine> rmlList = pageUtility.getAllRMLBySpecificId(roofingType);
        List<Material> roofingMaterialList = new ArrayList<>();
//        int rml_count = 0;//FOOBAR

//        System.out.println("- - - - - GENERATING LIST FOR ROOFING - - - - -");
        for (RoofingMaterialLine roofingMaterialLine : rmlList)
        {
            try
            {
                roofingMaterialList.add(pageUtility.getMaterialById(roofingMaterialLine.getMaterialId()));
//                System.out.println(roofingMaterialList.get(rml_count).getName());
//                rml_count++;
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
//        System.out.println("ROOFING MATERIAL LIST SIZE: "+roofingMaterialList.size());



        //Making Cladding/Roofing objects so we can throw their "type" value into the session
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

        System.out.println("INFO FROM CLADDING SELECTED BY USER, RETRIEVED BY DB");
        System.out.println(cladding.getCladding_id());
        System.out.println(cladding.getType());
        System.out.println("INFO FROM ROOFING SELECTED BY USER, RETRIEVED BY DB");
        System.out.println(roofing.getRoofing_id());
        System.out.println(roofing.getType());

        session.setAttribute("chosenCladding", cladding);
        session.setAttribute("chosenRoofing", roofing);

        //These ifs are to check the ids in the MaterialLine tabel in our DB
        //And get a material list and display it for the user at checkout.

//        if(claddingType == 1)
//        {
//            pageUtility.getAllCMLBySpecificId(claddingType);
//        }
//        else if(claddingType == 2)
//        {
//
//        }
//
//        if(roofingType == 1)
//        {
//
//        }
//        else if(roofingType == 2)
//        {
//
//        }


        view.forwardToJsp("orderSummary.jsp", request, response);
    }
}
