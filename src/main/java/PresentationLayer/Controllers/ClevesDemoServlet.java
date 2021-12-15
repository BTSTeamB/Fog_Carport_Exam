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
        int længde = 900;//brugernes valg
        int brede = 700;//brugerns valg
        int stolper = 0;
        int lægter = 0;


        if (længde >= 400 || længde <= 780) {
            stolper = 3;
        }
        if (længde < 400) {
            stolper = 2;
        }
        if(længde <280 ){
            længde = 280;
        }
        if(længde >780){
            længde =780;
        }
        if(brede <280){
            brede = 280;

        }
        if(brede > 600){
            brede = 600;
        }

        SVG svg = new SVG(0, 0, "0 0 800 800", 100, 100);

        svg.addRect(155, 0, brede, længde);
        svg.addRect(155, 35, 4.5, længde);
        svg.addRect(155, brede - 35, 4.5, længde);


        lægter = længde / 55;


        //lægter
        for (int x = 1; x < lægter; x++) {
            svg.addRect(155 + 55 * x, 0, brede, 4.8);
        }

        //stolper up
        for (int x = 1; x <= stolper; x++) {

            svg.addRect(32 + 250 * x, 32, 10.0, 10.0);
        }
        //stopler down
        for (int x = 1; x <= stolper; x++) {

            svg.addRect(32 + 250 * x, brede - 38, 10.0, 10.0);
        }

        svg.text2(155 + (længde / 2), brede + 75, længde + "cm");
        svg.text(75, brede / 2, brede + "cm");


        //striped-lines
        svg.addLine(290,38, stolper, brede);
        svg.addLine(779, 40, 291, 562);

        //arrow-lines
        svg.addLine1(100, 0, 100, brede);
        svg.addLine1(150, brede + 30, længde + 155, brede + 30);

        svg.addArrowsEnd("endArrow", 10, 10, 12, 6);
        svg.addArrowsStart("beginArrow", 10, 10, 0, 6);


        request.setAttribute("svgdrawing", svg.toString());
        request.getRequestDispatcher("/WEB-INF/SVG.jsp").forward(request, response);


    }
}
