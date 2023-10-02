package neetcode.twopointers;

public class TrappingRainWaterV1 {

    public static int trap(int[] height) {
        if(height.length==0)
            return 0;
        int res = 0;
        int l = 0, r = height.length-1;
        int leftMax = height[l], rightMax = height[r];
        while (l<r)
        {
            if(leftMax<=rightMax)
            {
                l+=1;
                leftMax = Math.max(leftMax,height[l]);
                res += leftMax - height[l];
            }
            else
            {
                r-=1;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(trap(new int[]{2,0,3,4,3,4,1,1,2,2,4,1}));
    }
}
