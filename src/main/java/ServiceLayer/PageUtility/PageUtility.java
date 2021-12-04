package ServiceLayer.PageUtility;

import DataAccessLayer.Database;
import DataAccessLayer.Mappers.Facade;
import Entities.PredefinedCarport;
import Entities.PredefinedShed;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class PageUtility
{
    private Database database;
    private Facade facade;

    public PageUtility() throws ClassNotFoundException
    {
        this.database = new Database();
        this.facade = new Facade(database);
    }

    public List<PredefinedShed> getAllPDSheds() throws Exception
    {
        List<PredefinedShed> pdSheds = new ArrayList<>();
        pdSheds = facade.getAllPredefinedShed();
        return pdSheds;
    }

    public List<PredefinedCarport> getAllPDCarports() throws Exception
    {
        List<PredefinedCarport> pdCarportList;
        pdCarportList = facade.getAllPredefinedCarport();
        return pdCarportList;
    }


    public void splitPredefinedCarportList(List<PredefinedCarport> list, HttpSession session)
    {
        List<List<PredefinedCarport>> listOfLists = new ArrayList<>();
        if(list.size() <= 3)
        {
            List<PredefinedCarport> firstSlide = list.subList(0,list.size());
            listOfLists.add(firstSlide);
        }
        if(list.size() > 3 && list.size() <= 6)
        {
            List<PredefinedCarport> secondSlide = list.subList(3,list.size());
            listOfLists.add(secondSlide);
        }
        if(list.size() > 6 && list.size() <= 9)
        {
            List<PredefinedCarport> thirdSlide = list.subList(6,list.size());
            listOfLists.add(thirdSlide);
        }
        if(list.size() > 9 && list.size() <= 12)
        {
            List<PredefinedCarport> fourthSlide = list.subList(9,list.size());
            listOfLists.add(fourthSlide);
        }


        session.setAttribute("listOfLists", listOfLists);
    }



}
