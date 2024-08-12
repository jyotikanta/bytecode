package leetcode.medium;

import java.util.Arrays;

public class MinSwap {
    public static void main(String[] args) {
        MinSwap minSwap = new MinSwap();
        int res = minSwap.minSwaps(new int[]{1,1,0,0,1});
        System.out.println(res);
    }

    public int minSwaps(int[] nums) {
        int len = nums.length;
        long noOfOnes = Arrays.stream(nums).filter(num->num==1).count();
        int L = 0;
        int maxWindowSize = 0;
        int count = 0;
        for(int R=L;R<(len*2);){
            if(nums[R%len]==1){
                count++;
            }
            if(R-L+1==noOfOnes){
                L=L+1;
                R=L;
                maxWindowSize = Math.max(maxWindowSize, count);
                count = 0;
                continue;
            }else{
                R++;
            }
        }
        return (int)noOfOnes-maxWindowSize;
    }
}
