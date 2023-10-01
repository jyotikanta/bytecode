package neetcode.twopointers;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int si = 0;
        int li = height.length-1;
        int area = 0;
        int smallestHeight;
        while(si<li)
        {
            smallestHeight = Math.min(height[si], height[li]);
            area = Math.max(area, smallestHeight*(li-si));
            if(height[si] <= height[li])
            {
                si++;
            }
            else
            {
                li--;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,1}));
    }
}
