package PresentationLayer.Controllers;

import Entities.PredefinedCarport;
import Entities.PredefinedShed;
import PresentationLayer.View;
import ServiceLayer.PageUtility.PageUtility;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "IndexController", value = "/IndexController")
public class IndexController extends HttpServlet
{
    View view = new View();
    PageUtility pageUtility;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        List<PredefinedCarport> pdCarports = new ArrayList<>();
        List<PredefinedShed> pdSheds = new ArrayList<>();

        try
        {
            pageUtility = new PageUtility();
            pdCarports = pageUtility.getAllPDCarports();
            System.out.println("List size in Controller");
            System.out.println(pdCarports.size());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("List size outside of try");
        System.out.println(pdCarports.size());
        pageUtility.splitPredefinedCarportList(pdCarports, session);

        List<PredefinedCarport> tmpPDC = new ArrayList<>();
        tmpPDC = (List<PredefinedCarport>) session.getAttribute("listOfLists");

        System.out.println("list size after method");
        System.out.println(tmpPDC.size());

        view.forwardToJsp("index.jsp", request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

}
