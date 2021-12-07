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

    public void editUser(HttpServletRequest request, HttpSession httpSession) throws Exception
    {
        User tmpUser = (User) httpSession.getAttribute("user");
        int find_id = tmpUser.getUser_id();
        String newName = request.getParameter("editName");
        String newAddress = request.getParameter("editAddress");
        String newZipCode = request.getParameter("editZip-Code");
        String newEmail = request.getParameter("editEmail");
        String newPassword = request.getParameter("editPassword");
        String newPhoneNumber = request.getParameter("editPhone");

        if(newName.isEmpty() || newName == null)
        {
            newName = tmpUser.getName();
        }
        if(newAddress.isEmpty() || newAddress == null)
        {
            newAddress = tmpUser.getAddress();
        }
        if(newZipCode.isEmpty() || newZipCode == null)
        {
            newZipCode = tmpUser.getZipCode();
        }
        if(newEmail.isEmpty() || newEmail == null)
        {
            newEmail = tmpUser.getEmail();
        }
        if(newPassword.isEmpty() || newPassword == null)
        {
            newPassword = tmpUser.getPassword();
        }
        if(newPhoneNumber.isEmpty() || newPhoneNumber == null)
        {
            newPhoneNumber = tmpUser.getPhoneNumber();
        }


        facade.editUser(find_id, newName, newAddress, newZipCode, newEmail, newPassword, newPhoneNumber);
        User newUser = facade.getUserById(find_id);
        httpSession.setAttribute("user", newUser);
    }

    public void registerGuestUser(User user) throws Exception
    {
        facade.createGuestUser(user.getIs_guest(),user.getName(), user.getAddress(), user.getZipCode(), user.getPhoneNumber(), user.getEmail(), user.getPassword());
    }

    public void registerUser(String name, String address, String zipCode, String phoneNumber, String email, String password) throws Exception
    {
        facade.createUser(name, address, zipCode,  phoneNumber,email, password);
    }
    public User loginUser(String email, String password, HttpSession session) throws Exception
    {
        // TODO: Få den her metode til at tage imod en HttpServletRequest istedet for session
        // til at skrive fejl besked og smide i request scope
        User loggedInUser;
        loggedInUser = facade.getUser(email, password);
        if(loggedInUser != null)
        {
            String changeSignInButton = "style='display: none;'";
            String changeDropDownButton = "display: block;";
            String changeDropDownMenu = "<div class=\"dropdown-content\">\n" +
                    "            <!--Den her skal have display NONE hvis de er ikke logget på. HELE Stylingen skal slettes hvis de er logget på -->\n" +
                    "            <a href=\"account.jsp\">Account</a>\n" +
                    "            <a href=\"LogoutController\">Sign-out</a>\n" +
                    "        </div>";
            session.setAttribute("changeSignInButton", changeSignInButton);
            session.setAttribute("changeDropDownButton", changeDropDownButton);
            session.setAttribute("changeDropDownMenu", changeDropDownMenu);
            session.setAttribute("user", loggedInUser);
            return loggedInUser;
        }
        else if(loggedInUser == null)
        {
            return loggedInUser;
        }
        return null;
    }

    public User getUserByLogin(String email, String password) throws Exception
    {
        User tmpUser;
        return tmpUser = facade.getUser(email, password);
    }


    public void logoutUser()
    {
        //TODO: Make log out
    }
}
