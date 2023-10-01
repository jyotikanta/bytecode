package neetcode.twopointers;

import java.util.Arrays;

public class TrappingRainWater {
    static int totalTrap = 0;
    public static int trap(int[] height) {
        if(height.length<=2)
        {
            return 0;
        }
        if(height.length==3)
        {
            if(height[1]<height[0] && height[1]<height[2])
            {
                totalTrap = totalTrap + Math.min(height[0],height[2]) - height[1];
                return totalTrap;
            }
        }
        int si = 0;
        int li = height.length-1;
        int maxFromLeft = 0;
        int maxFromRight = 0;
        int idxOfMaxFromLeft = 0;
        int idxOfMaxFromRight = 0;
        //Calculate the trap range
        while (height[si]==0)
        {
            si++;
        }
        maxFromLeft = height[si];
        idxOfMaxFromLeft = si;

        //From left calculate if there is any elevation bigger than the starting elevation and find which is the nearer. If found that will be the end range
        while (li>si) {
            //0,7,1,4,6
            if (height[li] >= maxFromLeft) {
                maxFromRight = height[li];
                idxOfMaxFromRight = li;
            }
            li--;
        }
        //If no such bigger elevation found then find the max elevation from the left that will be the end range.
        li = height.length-1;
        if(maxFromRight==0)
        {
            while (li>si)
            {
                if(height[li]>maxFromRight)
                {
                    maxFromRight = height[li];
                    idxOfMaxFromRight = li;
                }
                li--;
            }
        }
        int[] rightArr;
        if (maxFromRight == 0)
        {
            rightArr = Arrays.copyOfRange(height, idxOfMaxFromLeft+1, height.length);
        }
        else
        {
            int gap = idxOfMaxFromRight-idxOfMaxFromLeft-1;
            if(gap>=1)
            {
                int sumOfHeights = 0;
                for(int i = idxOfMaxFromLeft+1;i<idxOfMaxFromRight;i++)
                {
                    sumOfHeights+=height[i];
                }
                totalTrap = totalTrap +
                        (((idxOfMaxFromRight-idxOfMaxFromLeft-1)*(Math.min(maxFromLeft,maxFromRight)))-sumOfHeights);
            }
            rightArr = Arrays.copyOfRange(height, idxOfMaxFromRight, height.length);
        }

        trap(rightArr);
        return totalTrap;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{2,0,3,4,3,4,1,1,2,2,4,1}));
        //System.out.println(trap(new int[]{0,7,1,4,6}));
    }
}
