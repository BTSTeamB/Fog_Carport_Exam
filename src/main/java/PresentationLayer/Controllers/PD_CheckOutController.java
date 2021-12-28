package PresentationLayer.Controllers;

import PresentationLayer.Entities.*;
import PresentationLayer.View;
import ServiceLayer.PageUtility.OrderUtility;
import ServiceLayer.PageUtility.UserUtility;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckOutController", value = "/CheckOutController")
public class PD_CheckOutController extends HttpServlet
{
    View view = new View();
    OrderUtility orderUtility;
    UserUtility userUtility;

    {
        try
        {
            orderUtility = new OrderUtility();
            userUtility = new UserUtility();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null)
        {
            //Hvis der ikke er en kunde i session, så skal der registreres en gæst
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String zip = request.getParameter("zip");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");

            String button = request.getParameter("place order");

            //Fejl-håndtering
            if (request.getParameter("name").equals("") || request.getParameter("address").equals("") || request.getParameter("zip").length() != 4 || request.getParameter("phone").length() != 8 || request.getParameter("email").equals(""))
            {
                if (request.getParameter("name").equals(""))
                {
                    String failMessageName = "- This input needs to be filled out";
                    request.setAttribute("failMessageName", failMessageName);
                } else
                {
                    name = request.getParameter("name");
                    request.setAttribute("inputName", name);
                }

                if (request.getParameter("address").equals(""))
                {
                    String failMessageAddress = "- This input needs to be filled out";
                    request.setAttribute("failMessageAddress", failMessageAddress);
                } else
                {
                    address = request.getParameter("address");
                    request.setAttribute("inputAddress", address);
                }

                if (request.getParameter("zip").length() != 4)
                {
                    String failMessageZip = "- Your zip-code needs to be 4 digits long";
                    request.setAttribute("failMessageZip", failMessageZip);
                } else
                {
                    zip = request.getParameter("zip");
                    request.setAttribute("inputZip", zip);
                }

                if (request.getParameter("phone").length() != 8)
                {
                    String failMessagePhone = "- Your phone-number needs to be 8 digits long";
                    request.setAttribute("failMessagePhone", failMessagePhone);
                } else
                {
                    phone = request.getParameter("phone");
                    request.setAttribute("inputPhone", phone);
                }

                if (request.getParameter("email").equals(""))
                {
                    String failMessageEmail = "- Please enter a valid email";
                    request.setAttribute("failMessageEmail", failMessageEmail);
                } else
                {
                    email = request.getParameter("email");
                    request.setAttribute("inputEmail", email);
                }

                if (button.equals("PD_CO_guest-cookie"))
                {
                    view.forwardToJsp("premade-checkout-guest.jsp", request, response);
                }

                if (button.equals("PD_CO_user_cookie"))
                {
                    view.forwardToJsp("premade-checkout-user.jsp", request, response);
                }
                return;
            }

            user = new User(name, address, zip, phone, email);
            try
            {
                userUtility.registerGuestUser(user);
                user = userUtility.getUserByCredentials(name, address, zip, phone, email);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        try
        {
            orderUtility.createPDOrder(session);
            //Lukker gæstens session, så hvis de skulle kigge på deres ordre,
            // kommer deres oversigt ikke direkte op, som om de er logget på.
            if (user.getIs_guest() == 1)
            {
                session.invalidate();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        view.forwardToJsp("orderComplete.jsp", request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
