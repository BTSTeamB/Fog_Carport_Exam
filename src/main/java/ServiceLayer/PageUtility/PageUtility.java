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
        List<PredefinedCarport> pdCarportList = new ArrayList<>();
        pdCarportList = facade.getAllPredefinedCarport();
        return pdCarportList;
    }

    public void generateCarouselPages(int numOfPages, int numOfSlides, List<PredefinedCarport> list)
    {
        ArrayList<List<PredefinedCarport>> listOfLists = new ArrayList<>();
        listOfLists = splitArrayLists(numOfPages, numOfSlides, list);



    }

    public ArrayList<List<PredefinedCarport>> splitArrayLists (int numOfLists, int subListSize,List<PredefinedCarport> list)
    {
        ArrayList<List<PredefinedCarport>> listOfLists = new ArrayList<>();

        //Dividend
        int bigListSize = list.size();

        //Divider
        int numOfSubLists = numOfLists;

        //Modulo
        int modulo = bigListSize % numOfSubLists;

        //Checks if list that needs to be split can be split.
        if (list.size() >= 2)
        {
            System.out.println("List can be split!");
            System.out.println("List will be split into: "+numOfLists+" sub-lists");
            System.out.println("Sub Lists size will be max: "+subListSize);

            for (int i = 1; i <= list.size(); i++)
            {
                //Loop that only will work if the rest value is 0
                if ((bigListSize % i) == 0)
                {
                    ArrayList<PredefinedCarport> subList = new ArrayList<>();
                    //Nested loop that retrieves elements in the parameter list.
                    //Its max is equal to the size you define.
                    for (int j = 0; j < subListSize; j++)
                    {
                        subList.add(list.get(j));

                        //To empty parameter list.
                    }
                    //Adds said list into super list.
                    listOfLists.add(subList);
                }
                //If super list size reaches the number of lists we need in it. We break out.
                if(listOfLists.size() == numOfLists)
                {
                    break;
                }
            }

        }
        else
        {
            System.out.println("List cant be split!");
        }


        System.out.println("Data on our lists");
        System.out.println("Size of super list: "+listOfLists.size());

        for (int i = 0; i < listOfLists.size(); i++)
        {
            for (int j = 0; j < listOfLists.get(i).size(); j++)
            {
                System.out.println("From sublist: "+i);
                System.out.println(listOfLists.get(i).get(j));
            }
        }
        return listOfLists;
    }
}
