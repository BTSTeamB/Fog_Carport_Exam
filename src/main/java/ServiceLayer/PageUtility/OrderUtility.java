package ServiceLayer.PageUtility;

import DataAccessLayer.Database;
import DataAccessLayer.Mappers.Facade;
import Entities.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class OrderUtility
{
    private Database database;
    private Facade facade;

    public OrderUtility() throws ClassNotFoundException
    {
        this.database = new Database();
        this.facade = new Facade(database);
    }

    //Order
    public void createPDOrder(HttpSession session) throws Exception
    {
        PredefinedCarport pdCarport = (PredefinedCarport) session.getAttribute("viewMoreCarport");
        User user = (User) session.getAttribute("user");
        Cladding cladding = (Cladding) session.getAttribute("chosenCladding");
        Roofing roofing = (Roofing) session.getAttribute("chosenRoofing");
        Order order = new Order
                (user.getUser_id(), pdCarport.getPrice(),
                pdCarport.getLength(), pdCarport.getWidth(),
                cladding.getCladding_id(), roofing.getRoofing_id());


        System.out.println("ORDER INFO");
        System.out.println(order.getUser_id());
        System.out.println(order.getCarport_length());
        System.out.println(order.getCarport_width());
        System.out.println(order.getCladding_id());
        System.out.println(order.getRoofing_id());


        createOrder(order);
    }

    public void createOrder(Order order) throws Exception
    {
        facade.createOrder(order);
    }


}
