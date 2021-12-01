package ServiceLayer.PageUtility;

import DataAccessLayer.Database;
import Entities.Order;
import Entities.User;
import ServiceLayer.Facades.UserFacade;

import javax.servlet.http.HttpSession;

public class UserUtility
{
    private Database database;
    private UserFacade userFacade;

    public UserUtility() throws ClassNotFoundException
    {
        this.database = new Database();
        this.userFacade = new UserFacade(database);
    }
    public void registerUser(String name, String address, String zipCode, String email, String password, String phoneNumber) throws Exception
    {
        userFacade.createUser(name, address, zipCode, email, password, phoneNumber);
    }
    public User loginUser(String email, String password, HttpSession session) throws Exception
    {
        User loggedInUser;
        loggedInUser = userFacade.getUser(email, password);
        if(loggedInUser != null)
        {
            session.setAttribute("user", loggedInUser);
            return loggedInUser;
        }
        if(loggedInUser == null)
        {
            return loggedInUser;
        }
        return null;
    }


    public void logoutUser()
    {
        //TODO: Make log out
    }
}
