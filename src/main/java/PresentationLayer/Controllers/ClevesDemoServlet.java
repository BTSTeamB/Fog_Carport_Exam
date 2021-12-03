package PresentationLayer.Controllers;

import DataAccessLayer.Database;
import DataAccessLayer.Mappers.Facades;
import Entities.Material;


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

        Facades facades = null;

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(sdf3.format(timestamp));
        String timestampmsg = sdf3.format(timestamp);


        try {

            facades = new Facades(new Database());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            // facades.deleteUnit("Bære stolpe");
            //facades.createCladding(4);
            //facades.editUser(1,"christian","nyuholmasalle","2610","20202020","christian@gmail.com","1234");
            //facades.createPredefinedCarport(200,200);
            //facades.editPredefinedCarport(1,300,300);
            // facades.deletePredefinedCarport(1);
            //facades.createPredefinedCarport(200,300);
            //facades.receviePredefinedCarport(3);
            //facades.recevieUnit(1);
           // facades.recevieRoofing(2, facades.recevieMaterial(4));
            //facades.creatMaterial("")
           // facades.editCladding(2,4);
            facades.recevieOrder(1);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
