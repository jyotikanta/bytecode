package neetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().beautifulSubsets(new int[]{2,4,6},2));
    }
    public int beautifulSubsets(int[] nums, int k) {
        List<List<Integer>> subSets = new ArrayList<>();
        List<Integer> currSet = new ArrayList<>();
        Arrays.sort(nums); //sort the numbers as the array can contain duplicates
        //We can generate all the subset and loop through it to find the beautiful subset or
        //We can find the beautiful subset while we are generating the subset.
        subsetHelper(0, nums, currSet, subSets,k);

        int count = 0;
        for(List<Integer> list: subSets){
            if(!anyAbsoluteDiffEqualsK((ArrayList<Integer>)list,k)){
                count++;
            }
        }
        return count;
    }

    private void subsetHelper(int index, int[] nums, List<Integer> currSet, List<List<Integer>> subSets, int k){
        if(index==nums.length){
            subSets.add(new ArrayList(currSet));
            //if the subset size is 1 or
            //if the size is 2 and the difference between them is k then add the subset To beautiful SubSet.
            // if(currSet.size()==1||(currSet.size()==2 && Math.abs(currSet.get(0)-currSet.get(1))==k)){
            //     subSets.add(new ArrayList(currSet));
            // }else if(currSet.size()>2){
            //     //do the absolute difference to find if this subset is beautiful or not
            //     if(!anyAbsoluteDiffEqualsK(nums, k)){
            //         subSets.add(new ArrayList(currSet));
            //     }
            // }
        }else{
            currSet.add(nums[index]);
            subsetHelper(index+1, nums, currSet, subSets, k);
            currSet.remove(currSet.size()-1);

            while(index+1<nums.length && nums[index]==nums[index+1]){
                index++;
            }
            subsetHelper(index+1, nums, currSet, subSets, k);
        }
    }

    public boolean anyAbsoluteDiffEqualsK(ArrayList<Integer> nums, int k) {
        int index = 0;
        HashMap<Integer,Integer> elements = new HashMap<>();
        for(Integer n:nums)
        {
            if(elements.containsKey(Math.abs(k-n)))
            {
                return true;
            }
            else
            {
                elements.put(n, index++);
            }
        }
        return false;
    }
}