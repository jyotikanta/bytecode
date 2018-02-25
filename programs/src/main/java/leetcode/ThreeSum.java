package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;

            int right = nums.length - 1;

            while (left < right) {

                //if the 3 indices add to 0. Increment count.
                if (nums[i] + nums[left] + nums[right] == 0) {

                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    if(!lists.contains(list))
                        lists.add(list);
                    //increment left pointer
                    left++;

                }

                right--;
            }

        }
        if(!lists.isEmpty())
            return lists;
        else
            throw new IllegalArgumentException("Not such three entry found");
    }
}
