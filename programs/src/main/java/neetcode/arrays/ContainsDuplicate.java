package neetcode.arrays;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

//https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicate
{
    public static void main(String[] args)
    {
        int nums[] = {2,5,3,6,7,3,5};
        System.out.println(Arrays.toString(nums) + " Contains Duplicate : " + containsDuplicate(nums));
    }

    private static boolean containsDuplicate(int[] nums)
    {
        Set<Integer> elements = new HashSet<Integer>();
        for(int i : nums)
        {
            if(elements.contains(i))
            {
                return true;
            }
            elements.add(i);
        }
        return false;
    }
}
