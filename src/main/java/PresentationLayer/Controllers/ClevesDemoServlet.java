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
        int længde = 720;//brugernes valg
        int brede = 600;//brugerns valg
        int stolper = 0;
        int lægter = 0;
        int shedLængde = 240;
        int shedbrede = 600;
        int shedStolper = 0;

        if (længde >= 720 && længde <= 780) {
            stolper = 5;
        } else if (længde >= 570 && længde < 720) {
            stolper = 4;
        } else if (længde >= 450 && længde < 570) {
            stolper = 3;
        } else if (længde < 450) {
            stolper = 2;


        }
        if (længde < 240) {
            længde = 240;
        }
        if (længde > 780) {
            længde = 780;
        }
        if (brede < 240) {
            brede = 240;

        }
        if (brede > 600) {
            brede = 600;
        }

        SVG svg = new SVG(0, 0, "0 0 800 800", 100, 100);
        boolean shed = true;

        if (shed == false) {

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

                svg.addRect(55 + ((længde / stolper) * x), 32, 10.0, 10.0);
            }

            //stopler down
            for (int x = 1; x <= stolper; x++) {

                svg.addRect(55 + ((længde / stolper) * x), brede - 38, 10.0, 10.0);
            }

            svg.text2(155 + (længde / 2), brede + 75, længde + "cm");
            svg.text(75, brede / 2, brede + "cm");


            //striped-lines
            svg.addLine(55 + ((længde / stolper) * 1), 35, 55 + ((længde / stolper) * stolper), (brede / stolper) + brede - 160);
            svg.addLine(55 + ((længde / stolper) * 1), brede - 38, 55 + ((længde / stolper) * stolper), 40);

            //arrow-lines
            svg.addLine1(100, 0, 100, brede);
            svg.addLine1(150, brede + 30, længde + 155, brede + 30);

            svg.addArrowsEnd("endArrow", 10, 10, 12, 6);
            svg.addArrowsStart("beginArrow", 10, 10, 0, 6);
        }







        if (shed == true) {
            svg.addRect(155, 0, brede, længde);
            svg.shed(55 + ((længde / stolper) * (stolper - 1)), 35, shedbrede - 70, shedLængde-30);
            svg.addRect(155, 35, 4.5, længde);
            svg.addRect(155, brede - 35, 4.5, længde);




            for (int x = 1; x <= 1; x++) {
                svg.addRect(55 + ((længde / stolper) * (stolper - 1)), shedbrede / 2, 10.0, 10.0);
                svg.addRect(55 + ((længde / stolper) * (stolper - 1)) + (shedLængde-30), shedbrede / 2, 10.0, 10.0);
            }



            for (int x = 1; x <= 1; x++) {
                svg.addRect(55 + ((længde / stolper) * (stolper - 1)) + (shedLængde-30), shedbrede - 35, 10.0, 10.0);
                svg.addRect(55 + ((længde / stolper) * (stolper - 1)) + (shedLængde-30), 35, 10.0, 10.0);
            }




            lægter = længde / 55;
            //lægter
            for (int x = 1; x < lægter; x++) {
                svg.addRect(155 + 55 * x, 0, brede, 4.8);
            }

            //stolper up
            for (int x = 1; x <= stolper - 1; x++) {

                svg.addRect(55 + ((længde / stolper) * x), 32, 10.0, 10.0);
            }



            if (shedbrede != brede) {
                for (int x = 1; x <= stolper; x++) {

                    svg.addRect(55 + ((længde / stolper) * x), brede - 38, 10.0, 10.0);
                    svg.addRect(55 + ((længde / stolper) * (stolper - 1)), shedbrede - 32, 10.0, 10.0);
                }
            }
            //stopler down
            if (shedbrede == brede) {
                for (int x = 1; x <= stolper - 1; x++) {

                    svg.addRect(55 + ((længde / stolper) * x), brede - 38, 10.0, 10.0);
                }
            }



            svg.text2(155 + (længde / 2), brede + 75, længde + "cm");
            svg.text(75, brede / 2, brede + "cm");


            //striped-lines
            svg.addLine(55 + ((længde / stolper) * 1), 35, 55 + ((længde / stolper) * (stolper - 1)), (brede / stolper) + brede - 160);
            svg.addLine(55 + ((længde / stolper) * 1), brede - 38, 55 + ((længde / stolper) * (stolper - 1)), 40);

            //arrow-lines
            svg.addLine1(100, 0, 100, brede);
            svg.addLine1(150, brede + 30, længde + 155, brede + 30);

            svg.addArrowsEnd("endArrow", 10, 10, 12, 6);
            svg.addArrowsStart("beginArrow", 10, 10, 0, 6);

        }


//tegning fra siden
        SVG svg1 = new SVG(800, 800, "0 0 2000 2000", 1000, 1000);

        svg1.addRect(800, 800, brede, længde);


        request.setAttribute("svgdrawing", svg.toString());
        request.setAttribute("svgTEgningFromSide", svg.toString());
        request.getRequestDispatcher("/WEB-INF/SVG.jsp").forward(request, response);


    }
}
