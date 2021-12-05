package ServiceLayer.PageUtility;

import DataAccessLayer.Database;
import DataAccessLayer.Mappers.Facade;
import Entities.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderUtility
{
    private Database database;
    private Facade facade;

    public OrderUtility() throws ClassNotFoundException
    {
        this.database = new Database();
        this.facade = new Facade(database);
    }

    public void generateOrder(HttpSession session) throws Exception
    {
        PredefinedCarport pdCarport = (PredefinedCarport) session.getAttribute("viewMoreCarport");
        User user = (User) session.getAttribute("user");
        Cladding cladding = (Cladding) session.getAttribute("chosenCladding");
        Roofing roofing = (Roofing) session.getAttribute("chosenRoofing");
        double totalPrice = pdCarport.getPrice() + cladding.getMaterial().getPrice() + roofing.getMaterial().getPrice();
        Order order = new Order
                (user.getUser_id(), totalPrice,
                pdCarport.getLength(), pdCarport.getWidth(),
                cladding.getCladding_id(), roofing.getRoofing_id());

        createOrder(order);
    }

    public void createOrder(Order order) throws Exception
    {
        facade.createOrder(order);
    }

}
