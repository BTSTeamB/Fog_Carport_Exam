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
        List<PredefinedCarport> pdCarports = null;
        List<PredefinedShed> pdSheds = null;

        int everyThirdCounter = 0;
        String carouselPageNum = "CarouselPageNum" + everyThirdCounter + "";

        try
        {
            pageUtility = new PageUtility();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        try
        {
            pdCarports = pageUtility.getAllPDCarports();
            pdSheds = pageUtility.getAllPDSheds();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        //TODO: Make a method inside this method that generates HTML code.
        // Cus it wont work normally in the html page with foreach by JSTL
        pageUtility.generateCarouselPages(pdCarports, session);

        view.forwardToJsp("index.jsp", request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }


}
