package ServiceLayer.PageUtility;

import DataAccessLayer.Database;
import DataAccessLayer.Mappers.Facade;
import PresentationLayer.Entities.Order;
import PresentationLayer.Entities.User;

import java.util.List;

public class AdminUtility
{
    private Database database;
    private Facade facade;

    public AdminUtility() throws ClassNotFoundException
    {
        this.database = new Database();
        this.facade = new Facade(database);
    }

    public List<User> getAllUsers() throws Exception
    {
        return facade.getAllUsers();
    }

    public List<Order> getAllOrders()
    {
        return facade.getAllOrders();
    }
}
