package leetcode;

import java.util.Arrays;

class LargestNumberAtLeastOnce {
    int dominantIndex(int[] nums) {

        if(nums==null||nums.length==0)
            return -1;
        else if(nums.length==1)
            return 0;

        int[] originalCopy = Arrays.copyOf(nums,nums.length);

        Arrays.sort(nums);
        int largest = nums[nums.length-1];
        int secondLargest = nums[nums.length-2];

        if(largest >= 2*secondLargest)
        {
            for(int i=0;i<originalCopy.length;i++)
            {
                if(largest==originalCopy[i])
                    return i;
            }
        }
        return -1;
    }
}
