package PresentationLayer.Controllers;

import DataAccessLayer.Database;
import ServiceLayer.Facades.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ClevesDemoServlet", value = "/ClevesDemoServlet")
public class ClevesDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserFacade userFacade = null;
        try {
            userFacade = new UserFacade(new Database());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            userFacade.createUser("Christian","Valby gade 2","2500","20202030","christian.ccsgamers@gmail.com","1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
