package neetcode.sorting;

import java.util.Arrays;

public class MinAvg {
    public static void main(String[] args) {
        System.out.println(minimumAverage(new int[]{7,8,3,4,15,13,4,1}));
    }
    public static double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int l=0;
        int r=nums.length-1;
        double minAvg = Double.MAX_VALUE;
        while(l<nums.length/2){
            double avg = (double)(nums[l] + nums[r])/2;
            minAvg = Math.min(minAvg, avg);
            l++;
            r--;
        }
        return minAvg;
    }
}
