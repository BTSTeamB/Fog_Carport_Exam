package PresentationLayer.Controllers;

import Entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface ControllerUtil
{
    public String buttonChecker(String buttonName, HttpServletRequest request);

    public void loginChecker(User user, HttpSession session);

    public void adminChecker(User user, HttpSession session);

}
