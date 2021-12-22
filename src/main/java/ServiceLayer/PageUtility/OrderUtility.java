package ServiceLayer.PageUtility;

import DataAccessLayer.Database;
import DataAccessLayer.Mappers.Facade;
import Entities.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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


        createOrder(order);
    }

    public void createOrder(Order order) throws Exception
    {
        facade.createOrder(order);
    }

    public Order getOrderByOrderId(int id)
    {
        return facade.getOrderByOrderId(id);
    }

    public List<Order> getOrderListById(int user_id)
    {
        return facade.getOrderListById(user_id);
    }

    public List<Material> getCladdingMaterial(int cladding_id)
    {
        //Material Lists
        List<CladdingMaterialLine> cmlList = facade.getAllCMLBySpecificId(cladding_id);
        List<Material> claddingMaterials = new ArrayList<>();

        for (CladdingMaterialLine claddingMaterialLine : cmlList)
        {
            try
            {
                claddingMaterials.add(facade.getMaterialById(claddingMaterialLine.getMaterialId()));
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return claddingMaterials;
    }

    public List<Material> getRoofingMaterial(int roofing_id)
    {
        //Material Lists
        List<RoofingMaterialLine> rmlList = facade.getAllRMLBySpecificId(roofing_id);
        List<Material> roofingMaterialList = new ArrayList<>();

        for (RoofingMaterialLine roofingMaterialLine : rmlList)
        {
            try
            {
                roofingMaterialList.add(facade.getMaterialById(roofingMaterialLine.getMaterialId()));
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return roofingMaterialList;
    }

    public List<Order> setCladdingRoofingTypes(List<Order> orders) throws Exception
    {
        for (Order order : orders)
        {
            order.setCladdingType(facade.receiveCladdingById(order.getCladding_id()).getType());
            order.setRoofingType(facade.receiveRoofingById(order.getRoofing_id()).getType());
        }

        return orders;
    }
}
