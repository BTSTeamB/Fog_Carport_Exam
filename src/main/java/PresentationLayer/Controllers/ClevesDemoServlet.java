package PresentationLayer.Controllers;

import DataAccessLayer.Database;
import DataAccessLayer.Mappers.Facades;


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

            facades.createCladding(4);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
