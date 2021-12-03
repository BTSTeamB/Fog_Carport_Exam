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

        //Skal erstattes med ListListerne som attribut
        session.setAttribute("pdCarports", pdCarports);
        session.setAttribute("pdSheds", pdSheds);


//        //CARPORT: Carousel Page Creator if thers is less than 3 elements in Predefined Carports
//        if(pdCarports.size() > 3)
//        {
//            for (int i = 0; i <3; i++)
//            {
//                String carouselPageStart = "<div class=\"carousel__item\">";
//                String carouselPageEnd = "</div>";
//                session.setAttribute("carouselPageStart"+everyThirdCounter+"", carouselPageStart);
//                session.setAttribute("carouselPageEnd"+everyThirdCounter+"", carouselPageEnd);
//                view.forwardToJsp("index.jsp", request, response);
//            }
//
//        }
//        else
//        {
//            //CARPORT: Carousel Page Creator if there is more than 3
//            if (pdCarports.size() < 3)
//            {
//                while ((pdCarports.size() % 3 == 0))
//                {
//                    everyThirdCounter++;
//                    for (int i = 0; i < everyThirdCounter; i++)
//                    {
//                        String carouselPageStart = "<div class=\"carousel__item\">";
//                        String carouselPageEnd = "</div>";
//                        session.setAttribute("carouselPageStart" + everyThirdCounter + "", carouselPageStart);
//                        session.setAttribute("carouselPageEnd" + everyThirdCounter + "", carouselPageEnd);
//                    }
//
//                }
//            }
        view.forwardToJsp("index.jsp", request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    public void generateCarportCarouselPages(List<PredefinedCarport> carports, HttpSession session)
    {
        List<List<PredefinedCarport>> pdCarportCarouselList = new ArrayList<>();
        if (carports.size() > 3)
        {
            for (int i = 0; i < carports.size(); i++)
            {
                while((i % 3) == 0)
                {
                    List<PredefinedCarport> pdCarports = new ArrayList<>();
                    for (int j = 1; j <= 3; j++)
                    {
                        pdCarports.add(carports.get(i+j));
                    }
                }
                // To be continued
            }
        }
    }

    public void generateShedCarouselListPages(int numOfPages)
    {
        List<List<PredefinedShed>> pdShedCarouselList = new ArrayList<>();
    }
}
