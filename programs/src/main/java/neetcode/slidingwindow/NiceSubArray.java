package neetcode.slidingwindow;

import java.util.Collections;
import java.util.PriorityQueue;

public class NiceSubArray {
    public static int numberOfSubarrays(int[] nums, int k) {
        int L=0;
        int nice = 0;
        int n=nums.length;
        //build the prefix array to store the odd and even occurrence
        int[] prefix = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                prefix[i] = 0;
            }else{
                prefix[i] = 1;
            }
        }

        int total = 0;
        int niceIndex = -1;
        for(int R=0;L<=R && R<n;R++){
            total+=prefix[R];
            if(total==k){
                if(niceIndex==-1){
                    niceIndex=R;
                }
                nice++;
            }else if(total>k){
                total = total-prefix[L];
                L++;
                //R--;
            }
            if(R==n-1 && L<=niceIndex){
                R=niceIndex-1;
                total = total-prefix[L]-prefix[niceIndex];
                L++;
                niceIndex=-1;
            }
        }
        return nice;
    }

    public static void main(String[] args) {
        //System.out.println(numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2}, 2));
        System.out.println(numberOfSubarrays(new int[]{1,1,2,1,1}, 3));
    }
    public int longestSubarray(int[] nums, int limit) {
        int maxDiff = 0;


        // minPQ.add(nums[0]);
        // maxPQ.add(nums[0]);
        int maxLength = 0;
        for(int L=0;L<nums.length;L++){
            PriorityQueue minPQ = new PriorityQueue<>();
            PriorityQueue maxPQ = new PriorityQueue<>(Collections.reverseOrder());
            for(int R=L;R<nums.length;R++){
                minPQ.add(nums[R]);
                maxPQ.add(nums[R]);
                //if(minPQ.size()>1){
                if(Math.abs((Integer)maxPQ.peek()-(Integer)minPQ.peek())<=limit){
                    maxLength = Math.max(maxLength, R-L+1);
                }
                //}
            }
        }

        return maxLength;
    }
}
