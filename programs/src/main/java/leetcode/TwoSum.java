package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /*
      Given an array of integers, and a target value this method returns indices
      of the two numbers such that they add up to a specific target input.
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++)
        {
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) !=i)
            {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No solution found");
    }
}
