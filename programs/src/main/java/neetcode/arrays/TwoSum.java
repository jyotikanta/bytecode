package neetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;


//https://leetcode.com/problems/two-sum/
public class TwoSum {

    public static void main(String[] args)
    {
        int[] indx = twoSum(new int[]{1,4,2,7},3);
        System.out.println(Arrays.toString(indx));
    }


    public static int[] twoSum(int[] nums, int target)
    {
        int[] indx = {};
        int index = 0;
        HashMap<Integer,Integer> elements = new HashMap<>();
        for(int n:nums)
        {
            if(elements.containsKey(target-n))
            {
                Integer indx1 = elements.get(target-n);
                indx = new int[]{indx1, index};
            }
            else
            {
                elements.put(n, index++);
            }
        }
        return indx;
    }
}
