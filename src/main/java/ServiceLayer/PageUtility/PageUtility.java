package ServiceLayer.PageUtility;

import DataAccessLayer.Database;
import DataAccessLayer.Mappers.Facade;
import Entities.PredefinedCarport;
import Entities.PredefinedShed;

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
        List<PredefinedCarport> pdCarportList = new ArrayList<>();
        pdCarportList = facade.getAllPredefinedCarport();
        return pdCarportList;
    }
}
