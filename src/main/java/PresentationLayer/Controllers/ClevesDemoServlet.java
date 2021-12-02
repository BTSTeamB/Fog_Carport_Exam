package PresentationLayer.Controllers;

import DataAccessLayer.Database;
import DataAccessLayer.Mappers.OrderMapper;
import Entities.Cladding;
import ServiceLayer.Facades.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
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
        OrderFacade orderFacade =null;
        UserFacade userFacade = null;
        MaterialFacade materialFacade = null;
        CladdingFacade claddingFacade =null;
        RoofingFacade roofingFacade =null;
        UnitFacade unitFacade = null;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(sdf3.format(timestamp));
        String timestampmsg =sdf3.format(timestamp);


        try {
            //unitFacade = new UnitFacade(new Database());
            //roofingFacade = new RoofingFacade(new Database());
            //claddingFacade = new CladdingFacade(new Database());
            //materialFacade = new MaterialFacade(new Database());
            orderFacade = new OrderFacade(new Database());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {

            //unitFacade.creatUnit("Bære stolpe");
            //roofingFacade.createRoofing(4);
           // claddingFacade.createCladding(4);
            orderFacade.createOrder(1,300.50,20,30,1,1,0,0);
            //materialFacade.creatMaterial("sten","Denne sten er sej",200.00,1,23.0,23.9,9.0);
            //userFacade.createUser("Christian","Valby gade 2","2500","20202030","christian.ccsgamers@gmail.com","1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
