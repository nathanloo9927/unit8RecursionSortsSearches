import java.util.*;
public class ListMethods
{
    public static ArrayList<Integer> makeList(int n)
    {
        ArrayList<Integer> tempList = null;
        if (n <= 0)
        {
            tempList = new ArrayList<Integer>();
        } else
        {
            tempList = makeList(n-1);
            tempList.add(n);
            return tempList;
        }
        return tempList;
    }
    public static ArrayList<Integer> reverseList(ArrayList<Integer> tList)
    {
        ArrayList<Integer> list = ListMethods.deepClone(tList);
        if ((list.size() == 1) || (list.size() == 0))
        {
            return list;
        } else
        {
            Integer tempInt = list.remove(0);
            list = ListMethods.reverseList(list);
            list.add(tempInt);
        }
        return list;
    }
    public static ArrayList<Integer> even(ArrayList<Integer> tList)
    {
        ArrayList<Integer> list = ListMethods.deepClone(tList);
        if ((list.size() == 1) || (list.size() == 0))
        {
            return list;
        } else
        {
            Integer tempInt = list.remove(0);
            list.remove(0);
            list = ListMethods.even(list);
            list.add(0, tempInt);
        }
        return list;
    }
    public static ArrayList<Integer> merge(ArrayList<Integer> tList1, ArrayList<Integer> tList2)
    {
        ArrayList<Integer> list1 = ListMethods.deepClone(tList1);
        ArrayList<Integer> list2 = ListMethods.deepClone(tList2);
        ArrayList<Integer> tempList;
        if (list1.size() == 0)
        {
            return list2;
        } else if (list2.size() == 0)
        {
            return list1;
        } else
        {
            Integer lastElement1 = list1.get(list1.size() - 1);
            Integer lastElement2 = list2.get(list2.size() - 1);
            if (lastElement1.compareTo(lastElement2) < 0)
            {
                lastElement2 = list2.remove(list2.size() - 1);
                tempList = ListMethods.merge(list1, list2);
                tempList.add(lastElement2);
            } else
            {
                lastElement1 = list1.remove(list1.size() - 1);
                tempList = ListMethods.merge(list1, list2);
                tempList.add(lastElement1);
            }
        }
        return tempList;
    }
    public static ArrayList<Integer> deepClone(ArrayList<Integer> tList)
    {
       ArrayList<Integer> list = new ArrayList<Integer>(); 
       for (Integer i : tList)
       {
          list.add(new Integer(i));
       }
       return list;
    }
}
