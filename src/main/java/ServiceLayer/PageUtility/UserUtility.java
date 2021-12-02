package ServiceLayer.PageUtility;

import DataAccessLayer.Database;
import DataAccessLayer.Mappers.Facade;
import Entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserUtility
{
    private Database database;
    private Facade facade;

    public UserUtility() throws ClassNotFoundException
    {
        this.database = new Database();
        this.facade = new Facade(database);
    }

    public void editUser(HttpServletRequest request, HttpSession httpSession)
    {
        User tmpUser = (User) httpSession.getAttribute("user");
        int find_id = tmpUser.getUser_id();
        String newName = request.getParameter("editName");
        String newAddress = request.getParameter("editAddress");
        String newZipCode = request.getParameter("editZip-Code");
        String newEmail = request.getParameter("editEmail");
        String newPassword = request.getParameter("editPassword");
        String newPhoneNumber = request.getParameter("editPhone");

        if(newName.isEmpty())
        {
            newName = tmpUser.getName();
        }
        if(newAddress.isEmpty())
        {
            newAddress = tmpUser.getAddress();
        }
        if(newZipCode.isEmpty())
        {
            newZipCode = tmpUser.getZipCode();
        }
        if(newEmail.isEmpty())
        {
            newEmail = tmpUser.getEmail();
        }
        if(newPassword.isEmpty())
        {
            newPassword = tmpUser.getPassword();
        }
        if(newPhoneNumber.isEmpty())
        {
            newPhoneNumber = tmpUser.getPhoneNumber();
        }


        facade.editUser(find_id, newName, newAddress, newZipCode, newEmail, newPassword, newPhoneNumber);
    }

    public void registerUser(String name, String address, String zipCode, String email, String password, String phoneNumber) throws Exception
    {
        facade.createUser(name, address, zipCode, email, password, phoneNumber);
    }
    public User loginUser(String email, String password, HttpSession session) throws Exception
    {
        // TODO: Få den her metode til at tage imod en HttpServletRequest istedet for session
        User loggedInUser;
        loggedInUser = facade.getUser(email, password);
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
