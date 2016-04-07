import java.util.*;
public class Tester
{
    public static void main(String[] args)
    {
        int[] intArray = ArrayUtil.randomIntArray(10, 100);
        System.out.println(Arrays.toString(intArray));
       
        BubbleSort.intSort(intArray);
    }
}
