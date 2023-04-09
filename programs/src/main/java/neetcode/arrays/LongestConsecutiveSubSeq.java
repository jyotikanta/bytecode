package neetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class LongestConsecutiveSubSeq {
    public static void main(String[] args) {
        LongestConsecutiveSubSeq lcss = new LongestConsecutiveSubSeq();
        System.out.println(lcss.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }

    public int longestConsecutive(int[] nums) {
        int ls = 0;

        HashSet<Integer> numSet = new HashSet<>();
        for(int num: nums){
            numSet.add(num);
        }
        for(int num: numSet){
            if(!numSet.contains(num-1)){
                boolean vs = true;//found start of a valid sequence
                int cls = 1; //set current longest sequence to default
                int currNum = num;
                while(vs){
                    currNum = currNum+1;
                    if(!numSet.contains(currNum))
                        break;
                    cls++;
                }
                ls = Math.max(cls,ls);
            }
        }
        return ls;
    }
}
