package neetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int count = 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; i++)
        {
            if(nums[i]>0)
            {
                break;
            }
            if(nums[i] == 0 || nums[i] != nums[i-1])
            {
                int si = i+1;
                int li = nums.length -1;
                int target = -nums[i];

                while (si<li)
                {
                    if(nums[si] + nums[li] == target)
                    {
                        lists.add(Arrays.asList(nums[i], nums[si], nums[li]));

                        while(si<li && nums[si] == nums[si+1]) si++;
                        while(si<li && nums[li] == nums[li-1]) li--;

                        si++;
                        li--;
                    }
                    else if(nums[si] + nums[li] > target)
                    {
                        li--;
                    }
                    else
                    {
                        si++;
                    }
                }
            }
        }
        return lists;
    }

    private static int[] findTwoSumAllCombinations(int[] numbers, int from, int target) {
        int si = from;
        int li = numbers.length-1;
        ArrayList<Integer> arrr = new ArrayList<>();
        while (si<li)
        {
            int sum = numbers[si] + numbers[li];
            if(sum == target)
            {
                arrr.add(-target);
                arrr.add(numbers[si]);
                arrr.add(numbers[li]);
                return new int[] {si+1, li+1};
            }
            else if(sum > target)
            {
                li-=1;
            }
            else
            {
                si+=1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        int i = -2;
        System.out.printf(String.valueOf(threeSum(nums)));
    }
}
