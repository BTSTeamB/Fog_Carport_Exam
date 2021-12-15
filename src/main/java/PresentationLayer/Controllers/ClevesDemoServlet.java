package PresentationLayer.Controllers;

import DataAccessLayer.Database;
import DataAccessLayer.Mappers.Facades;
import Entities.SVG;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@WebServlet(name = "ClevesDemoServlet", value = "/ClevesDemoServlet")
public class ClevesDemoServlet extends HttpServlet {

    private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        SVG svg = new SVG(0, 0, "0 0 800 800", 100, 100);
        svg.addRect(155, 0, 600.0, 780.0);
        svg.addRect(155, 35, 4.5, 780);
        svg.addRect(155, 565, 4.5, 780);
        for (int x = 1; x < 16; x++) {
            svg.addRect(100 + 55 * x, 0, 600.0, 4.8);
        }
        svg.text("7,50 m");
        svg.text2("6,00 m ");

        svg.addRect(260, 32, 10.0, 10.0);
        svg.addRect(570, 32, 10.0, 10.0);
        svg.addRect(700, 32, 10.0, 10.0);
        svg.addRect(910, 32, 10.0, 10.0);


        svg.addRect(260, 562, 10.0, 10.0);
        svg.addRect(570, 562, 10.0, 10.0);
        svg.addRect(700, 562, 10.0, 10.0);
        svg.addRect(910, 562, 10.0, 10.0);

        svg.addLine(154, 0, 750, 600);
        svg.addLine(750, 0, 154, 600);
        svg.addLine1(100,100,100,600);
        svg.addLine1(150,700,850,700);
        // svg.addSvg(svg = new SVG(0,0,"0 0 800 600", 100 ,100));
        svg.addArrowsEnd("endArrow",10,10,12,6);
        svg.addArrowsStart("beginArrow", 10, 10, 0, 6);

        request.setAttribute("svgdrawing", svg.toString());

        request.getRequestDispatcher("/WEB-INF/SVG.jsp").forward(request, response);


    }
}
