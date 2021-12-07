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

        try
        {
            pageUtility = new PageUtility();
            pdCarports = pageUtility.getAllPDCarports();

            //Makes sure to cap the list at 15
            if(pdCarports.size() > 15)
            {
                pdCarports = pdCarports.subList(0,15);
            }
            session.setAttribute("AllPDCarports", pdCarports);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        pageUtility.splitPredefinedCarportList(pdCarports, session);

        view.forwardToJsp("index.jsp", request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

}
