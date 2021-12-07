package ServiceLayer.PageUtility;

import DataAccessLayer.Database;
import DataAccessLayer.Mappers.Facade;
import Entities.*;

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


    public List<PredefinedCarport> getAllPDCarports() throws Exception
    {
        List<PredefinedCarport> pdCarportList;
        pdCarportList = facade.getAllPredefinedCarport();
        return pdCarportList;
    }


    public void splitPredefinedCarportList(List<PredefinedCarport> list, HttpSession session)
    {
        List<List<PredefinedCarport>> listOfLists = new ArrayList<>();

        System.out.println("list size in method");
        System.out.println(list.size());

        if(list.size() <= 3)
        {
            List<PredefinedCarport> firstSlide = list.subList(0,list.size());
            listOfLists.add(firstSlide);
        }
        if(list.size() > 3 && list.size() <= 6)
        {
            List<PredefinedCarport> firstSlide = list.subList(0,3);
            List<PredefinedCarport> secondSlide = list.subList(3,list.size());
            listOfLists.add(firstSlide);
            listOfLists.add(secondSlide);
        }
        if(list.size() > 6 && list.size() <= 9)
        {
            List<PredefinedCarport> firstSlide = list.subList(0,3);
            List<PredefinedCarport> secondSlide = list.subList(3,6);
            List<PredefinedCarport> thirdSlide = list.subList(6,list.size());
            listOfLists.add(firstSlide);
            listOfLists.add(secondSlide);
            listOfLists.add(thirdSlide);
        }
        if(list.size() > 9 && list.size() <= 12)
        {
            List<PredefinedCarport> firstSlide = list.subList(0,3);
            List<PredefinedCarport> secondSlide = list.subList(3,6);
            List<PredefinedCarport> thirdSlide = list.subList(6,9);
            List<PredefinedCarport> fourthSlide = list.subList(9,list.size());
            listOfLists.add(firstSlide);
            listOfLists.add(secondSlide);
            listOfLists.add(thirdSlide);
            listOfLists.add(fourthSlide);
        }
        System.out.println("Size of list number 1:");
        System.out.println(listOfLists.get(0).size());
        System.out.println("IDs inside this list");
        System.out.println(listOfLists.get(0).get(0).getId());
        System.out.println(listOfLists.get(0).get(1).getId());
        System.out.println(listOfLists.get(0).get(2).getId());
        System.out.println("Size of list number 2:");
        System.out.println(listOfLists.get(1).size());
        System.out.println("IDs inside this list");
        System.out.println(listOfLists.get(1).get(0).getId());
        System.out.println(listOfLists.get(1).get(1).getId());
        System.out.println(listOfLists.get(1).get(2).getId());
        System.out.println("Size of list number 3:");
        System.out.println(listOfLists.get(2).size());
        System.out.println("IDs inside this list");
        System.out.println(listOfLists.get(2).get(0).getId());
        System.out.println(listOfLists.get(2).get(1).getId());
        System.out.println(listOfLists.get(2).get(2).getId());

        session.setAttribute("listOfLists", listOfLists);
    }


    public List<PredefinedShed> getAllPDSheds() throws Exception
    {
        List<PredefinedShed> pdSheds = new ArrayList<>();
        pdSheds = facade.getAllPredefinedShed();
        return pdSheds;
    }

    public Cladding getCladdingByObject(Cladding cladding)
    {
        Cladding tmpCladding = facade.receiveCladdingByObject(cladding);
        return tmpCladding;
    }

    public Cladding getCladdingByID(int claddingId)
    {
        Cladding cladding = facade.receiveCladdingById(claddingId);
        return cladding;
    }

    public List<Cladding> getAllCladdings()
    {
        List<Cladding> claddingList = facade.receiveAllCladding();
        return claddingList;
    }

    public Roofing getRoofingByObject(Roofing roofing) throws Exception
    {
        Roofing tmpRoofing = facade.receiveRoofingByObject(roofing);
        return tmpRoofing;
    }

    public Roofing getRoofingByID(int roofingId) throws Exception
    {
        Roofing roofing = facade.receiveRoofingById(roofingId);
        return roofing;
    }

    public List<Roofing> getAllRoofings()
    {
        List<Roofing> roofingList = facade.receiveAllRoofing();
        return roofingList;
    }

    public Material getMaterialById(int material_id) throws Exception
    {
        Material tmpMaterial = facade.getMaterialById(material_id);
        return tmpMaterial;
    }

    //CladdingMaterialLine
    public void createCML(int claddingId, int materialId) throws Exception
    {
        facade.createCML(claddingId, materialId);
    }

    public List<CladdingMaterialLine> getAllCMLBySpecificId(int id)
    {
        return facade.getAllCMLBySpecificId(id);
    }

    //RoofingMaterialLine
    public void createRML(int roofingId, int materialId) throws Exception
    {
        facade.createRML(roofingId, materialId);
    }

    public List<RoofingMaterialLine> getAllRMLBySpecificId(int id)
    {
        return facade.getAllRMLBySpecificId(id);
    }

}
