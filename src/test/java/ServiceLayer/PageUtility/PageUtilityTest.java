package ServiceLayer.PageUtility;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PageUtilityTest
{

    @Test
    void generateShedCarouselListPages()
    {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
//        splitLists(4, 3, numbers);
        List<Integer> first = numbers.subList(0,3);
        List<Integer> second = numbers.subList(3,6);
        List<Integer> third = numbers.subList(6,9);

        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(first);
        listOfLists.add(second);
        listOfLists.add(third);

        System.out.println("Print from List of Lists!");
        for (int i = 0; i < listOfLists.size(); i++)
        {
            System.out.println("Printing from list on: "+i+" index");
            for (int j = 0; j < listOfLists.get(i).size(); j++)
            {
                System.out.println(listOfLists.get(i).get(j));
            }
        }


    }


    //keeping it in here for bad memories
    public ArrayList<List<Integer>> splitArrayListsOffset (int numOfLists, int subListSize,List<Integer> list)
    {
        ArrayList<List<Integer>> listOfLists = new ArrayList<>();

        //Dividend
        int bigListSize = list.size();

        //Divider
        int numOfSubLists = numOfLists;

        //Modulo
        int modulo = bigListSize % numOfSubLists;

        //Checks if list that needs to be split can be split.
        if (list.size() > 2)
        {
            System.out.println("List can be split!");
            System.out.println("List will be split into: "+numOfLists+" sub-lists");
            System.out.println("Sub Lists size will be max: "+subListSize);

            for (int i = 0; i < numOfSubLists; i++)
            {
                listOfLists.add(new ArrayList<>());
            }
            for (int i = 0; i < list.size(); i++)
            {
                for (int j = 0; j <= subListSize; j++)
                {
                   listOfLists.get(i).add(list.get(j));
                   list.remove(Integer.valueOf(j));
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

    public ArrayList<List<Integer>> splitArrayLists (int numOfLists, int subListSize,List<Integer> list)
    {
        ArrayList<List<Integer>> listOfLists = new ArrayList<>();

        //Dividend
        int bigListSize = list.size();

        //Divider
        int numOfSubLists = numOfLists;

        //Modulo
        int modulo = bigListSize % numOfSubLists;

        //Checks if list that needs to be split can be split.
        if (list.size() > 2)
        {
            System.out.println("List can be split!");
            System.out.println("List will be split into: "+numOfLists+" sub-lists");
            System.out.println("Sub Lists size will be max: "+subListSize);

            for (int i = 1; i <= list.size(); i++)
            {

                //Loop that only will work if the rest value is 0
                if ((bigListSize % i) == 0)
                {
                    ArrayList<Integer> subList = new ArrayList<>();
                    //Nested loop that retrieves elements in the parameter list.
                    //Its max is equal to the size you define.
                    for (int j = 0; j < subListSize; j++)
                    {
                        subList.add(list.get(i-1));

                        //To empty parameter list.
//                        System.out.println("REMOVED: "+list.get(Integer.valueOf(i)));
//                        list.remove(Integer.valueOf(i));
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