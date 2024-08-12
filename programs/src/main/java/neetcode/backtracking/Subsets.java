package neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1,2,3}));
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subSets = new ArrayList<>();
        List<Integer> curSet = new ArrayList<>();
        helper(0, nums, subSets, curSet);
        return subSets;
    }
    public void helper(int pos,int[] nums, List<List<Integer>> subSets, List<Integer> curSet){
        if(pos==nums.length){
            subSets.add(new ArrayList<>(curSet));
        }else{
            curSet.add(nums[pos]);
            helper(pos+1, nums, subSets, curSet);
            curSet.remove(curSet.size()-1);
            helper(pos+1, nums, subSets, curSet);
        }
    }
}
